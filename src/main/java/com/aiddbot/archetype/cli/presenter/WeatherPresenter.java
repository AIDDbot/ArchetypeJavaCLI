package com.aiddbot.archetype.cli.presenter;

import org.springframework.stereotype.Component;

import com.aiddbot.archetype.cli.integrations.openmeteo.WeatherObservation;

@Component
public class WeatherPresenter {

  /**
   * Format a concise one-line weather summary.
   */
  public String present(String locationText, WeatherObservation obs) {
    String loc = (locationText == null || locationText.isBlank()) ? "your location" : locationText;
    return String.format("%s: %.1f°C, wind %.1f m/s (code %d)", loc, obs.getTemperatureCelsius(), obs.getWindSpeed(),
        obs.getWeatherCode());
  }
}
