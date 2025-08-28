package com.aiddbot.archetype.cli.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import com.aiddbot.archetype.cli.integrations.ipapi.IpGeoClient;
import com.aiddbot.archetype.cli.integrations.openmeteo.OpenMeteoClient;
import com.aiddbot.archetype.cli.presenter.WeatherPresenter;
import com.aiddbot.archetype.cli.errors.UserFacingErrors;
import com.aiddbot.archetype.cli.runtime.CodedException;

@ShellComponent
public class WeatherCommands {

  private final IpGeoClient ipGeoClient;
  private final OpenMeteoClient openMeteoClient;
  private final WeatherPresenter presenter;

  public WeatherCommands(IpGeoClient ipGeoClient, OpenMeteoClient openMeteoClient, WeatherPresenter presenter) {
    this.ipGeoClient = ipGeoClient;
    this.openMeteoClient = openMeteoClient;
    this.presenter = presenter;
  }

  @ShellMethod(key = "weather", value = "Show current weather for coordinates or detected IP location")
  public String weather(@ShellOption(help = "latitude", defaultValue = "${null}") Double lat,
      @ShellOption(help = "longitude", defaultValue = "${null}") Double lon) {

    double useLat = 0.0;
    double useLon = 0.0;
    String locationText = null;

    if (lat == null || lon == null) {
      var ipResp = ipGeoClient.resolve();
      useLat = ipResp.getLat();
      useLon = ipResp.getLon();
      // ip-api provides city and country fields but we didn't map them; show generic text
      locationText = "approx. coords";
    } else {
      useLat = lat;
      useLon = lon;
    }

    try {
      var obs = openMeteoClient.fetchCurrent(useLat, useLon);
      return presenter.present(locationText, obs);
    } catch (CodedException ce) {
      String msg = UserFacingErrors.format(ce);
      System.err.println(msg);
      throw ce; // rethrow so application-level mapper can set exit code
    }
  }
}
