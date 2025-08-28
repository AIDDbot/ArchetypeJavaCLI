package com.aiddbot.archetype.cli.integrations.ipapi;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.aiddbot.archetype.cli.config.CliProperties;
import com.aiddbot.archetype.cli.runtime.CodedException;
import com.aiddbot.archetype.cli.runtime.ExitCodes;

import reactor.core.Exceptions;

/**
 * Simple client to resolve approximate coordinates from ip-api.com using the application WebClient.
 */
@Component
public class IpGeoClient {

  private static final Logger log = LoggerFactory.getLogger(IpGeoClient.class);

  private final WebClient webClient;
  private final URI baseUri;

  public IpGeoClient(WebClient webClient, CliProperties props) {
    this.webClient = webClient;
    this.baseUri = props.getEndpoints().getIpGeoBaseUrl();
  }

  /**
   * Resolve the current IP location. Throws {@link CodedException} on failures.
   */
  public IpGeoResponse resolve() {
    try {
      IpGeoResponse resp = webClient.get()
          .uri(baseUri)
          .retrieve()
          .bodyToMono(IpGeoResponse.class)
          .block();

      if (resp == null) {
        throw new CodedException(ExitCodes.UNKNOWN, "ip-geo returned empty response");
      }

      if (!"success".equalsIgnoreCase(resp.getStatus())) {
        String msg = resp.getMessage() != null ? resp.getMessage() : "ip-geo returned failure";
        throw new CodedException(ExitCodes.NETWORK, "ip-geo failed: " + msg);
      }

      if (resp.getLat() == null || resp.getLon() == null) {
        throw new CodedException(ExitCodes.UNKNOWN, "ip-geo returned invalid coordinates");
      }

      return resp;
    } catch (WebClientResponseException wcre) {
      log.error("ip-geo HTTP error: {}", wcre.getMessage());
      throw new CodedException(ExitCodes.NETWORK, "ip-geo HTTP error: " + wcre.getMessage(), wcre);
    } catch (RuntimeException re) {
      // treat reactor / timeout / other network issues as network failures
      log.error("ip-geo network/runtime error: {}", re.toString());
      Throwable unwrapped = Exceptions.unwrap(re);
      throw new CodedException(ExitCodes.NETWORK, "ip-geo network error: " + unwrapped.getMessage(), unwrapped);
    }
  }
}
