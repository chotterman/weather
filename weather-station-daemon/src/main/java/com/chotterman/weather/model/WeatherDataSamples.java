package com.chotterman.weather.model;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSamples {

    private List<DataSample> dataSamples;

    public WeatherDataSamples() {
        this.dataSamples = new ArrayList<DataSample>();
    }

    public List<DataSample> getDataSamples() {
        return dataSamples;
    }

    public void setDataSamples(List<DataSample> dataSamples) {
        this.dataSamples = dataSamples;
    }

}
