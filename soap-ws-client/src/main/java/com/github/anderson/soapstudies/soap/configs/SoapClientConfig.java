package com.github.anderson.soapstudies.soap.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SoapClientConfig {

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setPackagesToScan("com.github.anderson.soapstudies.soap");
    return marshaller;
  }

  @Bean
  public WebServiceTemplate webServiceTemplate() {
    return new WebServiceTemplate(marshaller());
  }

}
