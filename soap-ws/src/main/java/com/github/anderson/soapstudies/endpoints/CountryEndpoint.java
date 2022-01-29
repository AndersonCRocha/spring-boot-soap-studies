package com.github.anderson.soapstudies.endpoints;

import com.github.anderson.soapstudies.repositories.CountryRepository;
import com.github.anderson.soapstudies.schemas.country.Country;
import com.github.anderson.soapstudies.schemas.country.GetCountryRequest;
import com.github.anderson.soapstudies.schemas.country.GetCountryResponse;
import com.github.anderson.soapstudies.utils.Constants;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

  private final CountryRepository repository;

  public CountryEndpoint(CountryRepository repository) {
    this.repository = repository;
  }

  @PayloadRoot(namespace = Constants.NAMESPACE_COUNTRIES, localPart = "getCountryRequest")
  @ResponsePayload
  public GetCountryResponse getCountryResponse(@RequestPayload GetCountryRequest request) {
    try {
      Country country = repository.getCountryByName(request.getName());
      GetCountryResponse response = new GetCountryResponse();
      response.setCountry(country);
      return response;
    } catch (Exception ex) {
      ex.printStackTrace();
      throw new RuntimeException(ex.getMessage());
    }
  }

}
