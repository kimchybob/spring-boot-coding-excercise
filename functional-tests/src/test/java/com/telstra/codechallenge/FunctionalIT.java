package com.telstra.codechallenge;

import com.intuit.karate.junit5.Karate;

public class FunctionalIT {
  @Karate.Test
  Karate testMicroservice() {
    return Karate.run("microservice").relativeTo(getClass());
  }

  @Karate.Test
  Karate testHelloWorld() {
    return Karate.run("helloworld").relativeTo(getClass());
  }

  @Karate.Test
  Karate testGetAccount() {
    return Karate.run("getaccounts").relativeTo(getClass());
  }
}