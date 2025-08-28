package com.aiddbot.archetype.cli.config;

import java.net.URI;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Validated
@ConfigurationProperties(prefix = "cli")
public class CliProperties {

  private final Network network = new Network();
  private final Endpoints endpoints = new Endpoints();

  public Network getNetwork() {
    return network;
  }

  public Endpoints getEndpoints() {
    return endpoints;
  }

  public static class Network {
    @Min(1)
    private int connectTimeoutMs = 2000;

    @Min(1)
    private int readTimeoutMs = 2000;

    public int getConnectTimeoutMs() {
      return connectTimeoutMs;
    }

    public void setConnectTimeoutMs(int connectTimeoutMs) {
      this.connectTimeoutMs = connectTimeoutMs;
    }

    public int getReadTimeoutMs() {
      return readTimeoutMs;
    }

    public void setReadTimeoutMs(int readTimeoutMs) {
      this.readTimeoutMs = readTimeoutMs;
    }
  }

  public static class Endpoints {
    @NotNull
    private URI ipGeoBaseUrl = URI.create("http://ip-api.com/json");
    @NotNull
    private URI openMeteoBaseUrl = URI.create("https://api.open-meteo.com/v1/forecast");

    public URI getIpGeoBaseUrl() {
      return ipGeoBaseUrl;
    }

    public void setIpGeoBaseUrl(URI ipGeoBaseUrl) {
      this.ipGeoBaseUrl = ipGeoBaseUrl;
    }

    public URI getOpenMeteoBaseUrl() {
      return openMeteoBaseUrl;
    }

    public void setOpenMeteoBaseUrl(URI openMeteoBaseUrl) {
      this.openMeteoBaseUrl = openMeteoBaseUrl;
    }
  }
}
