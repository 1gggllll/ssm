package com.my.ioc_01;

public class DefaultServiceLocator {

  private static ClientServiceImpl clientService01= new ClientServiceImpl();

  public ClientServiceImpl createClientServiceInstance() {
    return clientService01;
  }
}