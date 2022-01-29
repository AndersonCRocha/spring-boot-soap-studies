package com.github.anderson.soapstudies.controllers;

import com.github.anderson.soapstudies.soap.SoapClient;
import com.github.anderson.soapstudies.soap.countries.Country;
import com.github.anderson.soapstudies.soap.countries.GetCountryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {

  private final SoapClient client;

  public CountryController(SoapClient client) {
    this.client = client;
  }

  @GetMapping
  public Country getCountryByName(@RequestParam String name) {
    GetCountryResponse response = this.client.getCountryByName(name);
    return response.getCountry();
  }

}
