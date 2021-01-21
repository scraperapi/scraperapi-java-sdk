package com.scraperapi;

import kong.unirest.Unirest;

import java.util.HashMap;
import java.util.Map;

public class ScraperApiClient {

  private String apiToken;

  public ScraperApiClient(String token) {
    this.apiToken = token;
  }

  public ScraperApiRequest get(String url) {
    return new ScraperApiRequest(url, "GET", this.apiToken);
  }

  public ScraperApiRequest post(String url) {
    return new ScraperApiRequest(url, "POST", this.apiToken);
  }

  public ScraperApiRequest put(String url) {
    return new ScraperApiRequest(url, "PUT", this.apiToken);
  }


  public AccountStats account() {

    Map<String, Object> query = new HashMap<String, Object>();
    query.put("api_key", apiToken);

    return Unirest.get("https://api.scraperapi.com/account")
      .queryString(query)
      .asObject(AccountStats.class)
      .getBody();
  }
}
