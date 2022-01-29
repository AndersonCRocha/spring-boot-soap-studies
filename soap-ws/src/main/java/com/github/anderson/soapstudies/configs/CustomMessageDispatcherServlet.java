package com.github.anderson.soapstudies.configs;

import org.springframework.ws.soap.SoapMessageCreationException;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class CustomMessageDispatcherServlet extends MessageDispatcherServlet {

  @Override
  protected void doService(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws Exception {
    Throwable exception = null;

    try {
      super.doService(servletRequest, servletResponse);
    } catch (SoapMessageCreationException ex) {
      exception = ex;
      servletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    } catch (Exception ex) {
      exception = ex;
      servletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }

    if (servletResponse.getStatus() >= 200 && servletResponse.getStatus() < 300) {
      return;
    }

    String errorMessage = Objects.nonNull(exception) ? exception.getMessage() : "Unknown error";
    servletResponse.getOutputStream().print(errorMessage);
    servletResponse.getOutputStream().flush();
  }
}
