package com.telstra.codechallenge.github;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AccountService {
  @Value("${lonelyUser.base.url}")
  private String lonelyUserBaseUrl;

  private final RestTemplate restTemplate;

  public AccountService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  /**
   * Returns an array of the oldest accounts with zero followers.
   * Taken from
   * <a href="https://api.github.com">https://api.github.com</a>.
   * For API documentation see:
   * <a href=
   * "https://docs.github.com/en/rest/search/search?apiVersion=2022-11-28#search-users">
   * Repository Search API docs</a>.
   *
   * @return - a user account list.
   */
  public List<Account> getLonelyUser(Integer userNum) {
    AccountResponse lonelyUserResponse = restTemplate.getForObject(
        lonelyUserBaseUrl + "/search/users?q=followers:0&sort=joined&order=asc&per_page=" + userNum,
        AccountResponse.class);

    List<Account> longlyUser = null;
    if (lonelyUserResponse != null) {
      longlyUser = lonelyUserResponse.getItems();
    }

    return longlyUser;
  }
}
