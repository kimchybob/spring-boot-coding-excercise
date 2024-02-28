package com.telstra.codechallenge.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Account {
  private Integer id;
  private String login;
  private String html_url;
}
