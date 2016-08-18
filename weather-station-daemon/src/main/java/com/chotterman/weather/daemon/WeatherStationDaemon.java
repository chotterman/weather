package com.chotterman.weather.daemon;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.chotterman.weather.model.DataSample;
import com.chotterman.weather.model.WeatherDataSamples;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * This program demonstrates how to use the Watch Service API to monitor change events for a
 * specific directory.
 * 
 * @author www.codejava.net
 *
 */
public class WeatherStationDaemon {

    static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        // Build a new authorized API client service.
        ObjectMapper mapper = new ObjectMapper();
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            Path dir = Paths.get("C:\\weather");
            dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

            System.out.println("Watch Service registered for dir: " + dir.getFileName());

            while (true) {
                WatchKey key;
                try {
                    key = watcher.take();
                } catch (InterruptedException ex) {
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    @SuppressWarnings("unchecked")
                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path fileName = ev.context();

                    System.out.println(kind.name() + ": " + fileName);

                    if (kind == ENTRY_CREATE) {
                        //JSON from file to Object
                        DataSample[] samplesArray = mapper.readValue(new File("C:\\weather\\live_json.txt"), DataSample[].class);
                        WeatherDataSamples samples = new WeatherDataSamples();
                        for (DataSample dataSample : samplesArray) {
                            samples.getDataSamples().add(dataSample);
                        }
                        try {
                            sendPost(samples);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (kind == ENTRY_MODIFY && fileName.toString().equals("DirectoryWatchDemo.java")) {
                        System.out.println("My source file has changed!!!");
                    }
                }

                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static void sendPost(WeatherDataSamples samples) throws Exception {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://1-dot-weatherdataservice.appspot.com/_ah/api/weatherdata/v1/void");
        StringEntity params = new StringEntity(mapper.writeValueAsString(samples));
        System.out.println("Sending : " + mapper.writeValueAsString(samples));

        httpPost.addHeader("content-type", "application/json");
        httpPost.setEntity(params);
        CloseableHttpResponse response1 = httpclient.execute(httpPost);

        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();

            EntityUtils.consume(entity1);
        } finally {
            response1.close();
        }

    }
}