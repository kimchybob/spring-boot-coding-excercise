package com.telstra.codechallenge.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AccountResponse {
  private Integer total_count;
  private Boolean incomplete_results;
  private List<Account> items;

  public List<Account> getItems() {
    return items;
  }
}
