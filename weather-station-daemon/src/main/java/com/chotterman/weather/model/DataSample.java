package com.chotterman.weather.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Date", "Time", "TempOut", "FeelsLike", "HumidityOut", "WindDirection", "WindAvg", "WindGust", "Rain", "AbsPressure" })
public class DataSample {

    @JsonProperty("Date")
    private String date;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("TempOut")
    private Object tempOut;
    @JsonProperty("FeelsLike")
    private Object feelsLike;
    @JsonProperty("HumidityOut")
    private Object humidityOut;
    @JsonProperty("WindDirection")
    private String windDirection;
    @JsonProperty("WindAvg")
    private Object windAvg;
    @JsonProperty("WindGust")
    private Object windGust;
    @JsonProperty("Rain")
    private Object rain;
    @JsonProperty("AbsPressure")
    private Object absPressure;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return The date
     */
    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *            The Date
     */
    @JsonProperty("Date")
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return The time
     */
    @JsonProperty("Time")
    public String getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *            The Time
     */
    @JsonProperty("Time")
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 
     * @return The tempOut
     */
    @JsonProperty("TempOut")
    public Object getTempOut() {
        return tempOut;
    }

    /**
     * 
     * @param tempOut
     *            The TempOut
     */
    @JsonProperty("TempOut")
    public void setTempOut(Object tempOut) {
        this.tempOut = tempOut;
    }

    /**
     * 
     * @return The feelsLike
     */
    @JsonProperty("FeelsLike")
    public Object getFeelsLike() {
        return feelsLike;
    }

    /**
     * 
     * @param feelsLike
     *            The FeelsLike
     */
    @JsonProperty("FeelsLike")
    public void setFeelsLike(Object feelsLike) {
        this.feelsLike = feelsLike;
    }

    /**
     * 
     * @return The humidityOut
     */
    @JsonProperty("HumidityOut")
    public Object getHumidityOut() {
        return humidityOut;
    }

    /**
     * 
     * @param humidityOut
     *            The HumidityOut
     */
    @JsonProperty("HumidityOut")
    public void setHumidityOut(Object humidityOut) {
        this.humidityOut = humidityOut;
    }

    /**
     * 
     * @return The windDirection
     */
    @JsonProperty("WindDirection")
    public String getWindDirection() {
        return windDirection;
    }

    /**
     * 
     * @param windDirection
     *            The WindDirection
     */
    @JsonProperty("WindDirection")
    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    /**
     * 
     * @return The windAvg
     */
    @JsonProperty("WindAvg")
    public Object getWindAvg() {
        return windAvg;
    }

    /**
     * 
     * @param windAvg
     *            The WindAvg
     */
    @JsonProperty("WindAvg")
    public void setWindAvg(Object windAvg) {
        this.windAvg = windAvg;
    }

    /**
     * 
     * @return The windGust
     */
    @JsonProperty("WindGust")
    public Object getWindGust() {
        return windGust;
    }

    /**
     * 
     * @param windGust
     *            The WindGust
     */
    @JsonProperty("WindGust")
    public void setWindGust(Object windGust) {
        this.windGust = windGust;
    }

    /**
     * 
     * @return The rain
     */
    @JsonProperty("Rain")
    public Object getRain() {
        return rain;
    }

    /**
     * 
     * @param rain
     *            The Rain
     */
    @JsonProperty("Rain")
    public void setRain(Object rain) {
        this.rain = rain;
    }

    /**
     * 
     * @return The absPressure
     */
    @JsonProperty("AbsPressure")
    public Object getAbsPressure() {
        return absPressure;
    }

    /**
     * 
     * @param absPressure
     *            The AbsPressure
     */
    @JsonProperty("AbsPressure")
    public void setAbsPressure(Object absPressure) {
        this.absPressure = absPressure;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
