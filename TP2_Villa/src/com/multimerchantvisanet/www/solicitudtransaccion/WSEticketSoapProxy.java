package com.multimerchantvisanet.www.solicitudtransaccion;

public class WSEticketSoapProxy implements com.multimerchantvisanet.www.solicitudtransaccion.WSEticketSoap {
  private String _endpoint = null;
  private com.multimerchantvisanet.www.solicitudtransaccion.WSEticketSoap wSEticketSoap = null;
  
  public WSEticketSoapProxy() {
    _initWSEticketSoapProxy();
  }
  
  public WSEticketSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSEticketSoapProxy();
  }
  
  private void _initWSEticketSoapProxy() {
    try {
      wSEticketSoap = (new com.multimerchantvisanet.www.solicitudtransaccion.WSEticketLocator()).getWSEticketSoap();
      if (wSEticketSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSEticketSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSEticketSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSEticketSoap != null)
      ((javax.xml.rpc.Stub)wSEticketSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.multimerchantvisanet.www.solicitudtransaccion.WSEticketSoap getWSEticketSoap() {
    if (wSEticketSoap == null)
      _initWSEticketSoapProxy();
    return wSEticketSoap;
  }
  
  public java.lang.String generaEticket(java.lang.String xmlIn) throws java.rmi.RemoteException{
    if (wSEticketSoap == null)
      _initWSEticketSoapProxy();
    return wSEticketSoap.generaEticket(xmlIn);
  }
  
  
}