package com.github.anderson.soapstudies.soap;

import com.github.anderson.soapstudies.soap.countries.GetCountryRequest;
import com.github.anderson.soapstudies.soap.countries.GetCountryResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class SoapClient {

  private final WebServiceTemplate wsTemplate;
  private final String wsUrl;

  public SoapClient(WebServiceTemplate wsTemplate, @Value("${ws.url}") String wsUrl) {
    this.wsTemplate = wsTemplate;
    this.wsUrl = wsUrl;
  }

  public GetCountryResponse getCountryByName(String name) {
    GetCountryRequest request = new GetCountryRequest();
    request.setName(name);
    return (GetCountryResponse) this.wsTemplate.marshalSendAndReceive(wsUrl, request);
  }

}
