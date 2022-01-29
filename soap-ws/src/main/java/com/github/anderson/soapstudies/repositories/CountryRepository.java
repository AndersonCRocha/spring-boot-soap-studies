package com.github.anderson.soapstudies.repositories;

import com.github.anderson.soapstudies.schemas.country.Country;
import com.github.anderson.soapstudies.schemas.country.Currency;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryRepository {

  private static final List<Country> countries = new ArrayList<>();

  static {
    Country brazil = new Country();
    brazil.setName("Brazil");
    brazil.setCapital("Brasilia");
    brazil.setPopulation(212_600_000);
    brazil.setCurrency(Currency.BRL);
    countries.add(brazil);

    Country eua = new Country();
    eua.setName("American United States");
    eua.setCapital("Washington");
    eua.setPopulation(329_500_000);
    eua.setCurrency(Currency.USD);
    countries.add(eua);
  }

  public Country getCountryByName(String name) {
    return countries.stream()
      .filter(country -> country.getName().equals(name))
      .findFirst()
      .orElseThrow(() -> new RuntimeException("Country not found"));
  }

}
