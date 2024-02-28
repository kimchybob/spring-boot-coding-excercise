package com.telstra.codechallenge.github;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
  private final AccountService lonelyUserService;

  public AccountController(
      AccountService lonelyUserService) {
    this.lonelyUserService = lonelyUserService;
  }

  @GetMapping(path = "/getLonelyUser")
  public List<Account> lonelyUser() {
    // pass in parameter that sets the number of accounts to return
    return lonelyUserService.getLonelyUser(3);
  }
}
