package com.github.anderson.soapstudies.configs;

import com.github.anderson.soapstudies.utils.Constants;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServicesConfig extends WsConfigurerAdapter {

  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcher(ApplicationContext context) {
    MessageDispatcherServlet messageDispatcherServlet = new CustomMessageDispatcherServlet();
    messageDispatcherServlet.setApplicationContext(context);
    messageDispatcherServlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean<>(messageDispatcherServlet, "/ws/*");
  }

  @Bean(name = "countries")
  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
    DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
    definition.setPortTypeName("CountryPort");
    definition.setLocationUri("/ws");
    definition.setTargetNamespace(Constants.NAMESPACE_COUNTRIES);
    definition.setSchema(countriesSchema);
    return definition;
  }

  @Bean
  public XsdSchema countriesSchema() {
    return new SimpleXsdSchema(new ClassPathResource("countries.xsd"));
  }

}
