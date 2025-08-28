package com.aiddbot.archetype.cli.integrations.openmeteo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenMeteoCurrent {

  @JsonProperty("temperature")
  private Double temperature;

  @JsonProperty("windspeed")
  private Double windspeed;

  @JsonProperty("weathercode")
  private Integer weathercode;

  public Double getTemperature() {
    return temperature;
  }

  public void setTemperature(Double temperature) {
    this.temperature = temperature;
  }

  public Double getWindspeed() {
    return windspeed;
  }

  public void setWindspeed(Double windspeed) {
    this.windspeed = windspeed;
  }

  public Integer getWeathercode() {
    return weathercode;
  }

  public void setWeathercode(Integer weathercode) {
    this.weathercode = weathercode;
  }
}
