package com.aiddbot.archetype.cli.config;

import java.time.Duration;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import reactor.netty.http.client.HttpClient;

/**
 * Configuration for a singleton {@link WebClient} with sensible defaults for
 * timeouts and headers.
 */
@Configuration
public class WebClientConfig {

  private static final Logger log = LoggerFactory.getLogger(WebClientConfig.class);

  @Bean
  WebClient webClient(CliProperties props, ObjectProvider<BuildProperties> buildProps) {
    int connectMs = props.getNetwork().getConnectTimeoutMs();
    int readMs = props.getNetwork().getReadTimeoutMs();

    HttpClient httpClient = HttpClient.create()
        // Connect timeout
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, connectMs)
        // Read/response timeout
        .responseTimeout(Duration.ofMillis(readMs));

    String version = resolveVersion(buildProps);
    String userAgent = "ArchetypeJavaCLI/" + version;

    WebClient client = WebClient.builder()
        .clientConnector(new ReactorClientHttpConnector(httpClient))
        .defaultHeaders(headers -> {
          headers.setAccept(List.of(MediaType.APPLICATION_JSON));
          headers.set(HttpHeaders.USER_AGENT, userAgent);
        })
        .build();

    log.info(
        "WebClient configured: connectTimeoutMs={}, readTimeoutMs={}, userAgent={}",
        connectMs,
        readMs,
        userAgent);

    return client;
  }

  private static String resolveVersion(ObjectProvider<BuildProperties> buildProps) {
    BuildProperties bp = buildProps.getIfAvailable();
    if (bp != null) {
      return bp.getVersion();
    }
    return "dev";
  }
}
