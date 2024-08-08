package com.scraperapi;

import kong.unirest.Unirest;

import java.util.HashMap;
import java.util.Map;

public class ScraperApiRequest {

  private String url= null;
  private String api_key = null;
  private String method= null;
  private String country_code= null;
  private String device_type= null;
  private Boolean premium = false;
  private Boolean render = false;
  private String session_number= null;
  private Boolean autoparse = false;
  private Integer retry_n = 3;
  private Integer timeout = 60000;
  private String body= null;

  private HashMap<String, String> headers = new HashMap<String, String>();

  public ScraperApiRequest(String url, String method, String api_key) {
    this.url = url;
    this.method = method;
    this.api_key = api_key;
  }

  public ScraperApiRequest premium(Boolean value) { this.premium = value; return this; }
  public ScraperApiRequest render(Boolean value) { this.render = value; return this; }
  public ScraperApiRequest autoparse(Boolean value) { this.autoparse = value; return this; }

  public ScraperApiRequest country_code(String value) { this.country_code = value; return this; }
  public ScraperApiRequest device_type(String value) { this.device_type = value; return this; }
  public ScraperApiRequest session_number(String value) { this.session_number = value; return this; }
  public ScraperApiRequest body(String value) { this.body = value; return this; }

  public ScraperApiRequest retry(Integer value) { this.retry_n = value; return this; }
  public ScraperApiRequest timeout(Integer value) { this.timeout = value; return this; }

  public ScraperApiRequest header(String key, String value) {
    headers.put(key, value);
    return this;
  }

  public String result() {

    Unirest.config().reset();

    Unirest.config()
      .socketTimeout(this.timeout)
      .automaticRetries(retry_n > 0);

    Map<String, Object> query = new HashMap<String, Object>();

    query.put("api_key", this.api_key);
    query.put("url", this.url);
    if (country_code != null) query.put("country_code", this.country_code);
    if (device_type != null) query.put("device_type", this.device_type);
    if (premium != null)  query.put("premium", this.premium);
    if (render != null)  query.put("render", this.render);
    if (session_number != null)  query.put("session_number", this.session_number);
    if (autoparse != null)  query.put("autoparse", this.autoparse);
    if (headers.size() > 0)  query.put("keep_headers", true);


    if (method == "GET") {
      return Unirest.get("https://api.scraperapi.com/")
        .queryString(query)
        .headers(headers)
        .asString()
        .getBody();
    }

    if (method == "POST") {
      return Unirest.post("https://api.scraperapi.com/")
        .body(this.body)
        .queryString(query)
        .headers(headers)
        .asString()
        .getBody();
    }

    if (method == "PUT") {
      return Unirest.put("https://api.scraperapi.com/")
        .body(this.body)
        .queryString(query)
        .headers(headers)
        .asString()
        .getBody();
    }

    return null;

  }

}
