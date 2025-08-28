package com.aiddbot.archetype.cli.integrations.openmeteo;

/** Minimal domain object representing a current weather observation. */
public class WeatherObservation {

  private final double temperatureCelsius;
  private final double windSpeed;
  private final int weatherCode;

  public WeatherObservation(double temperatureCelsius, double windSpeed, int weatherCode) {
    this.temperatureCelsius = temperatureCelsius;
    this.windSpeed = windSpeed;
    this.weatherCode = weatherCode;
  }

  public double getTemperatureCelsius() {
    return temperatureCelsius;
  }

  public double getWindSpeed() {
    return windSpeed;
  }

  public int getWeatherCode() {
    return weatherCode;
  }
}
