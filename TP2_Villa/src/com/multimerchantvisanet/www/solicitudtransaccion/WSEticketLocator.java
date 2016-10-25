/**
 * WSEticketLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.multimerchantvisanet.www.solicitudtransaccion;

public class WSEticketLocator extends org.apache.axis.client.Service implements com.multimerchantvisanet.www.solicitudtransaccion.WSEticket {

/**
 * Consultas en Linea de transacciones
 */

    public WSEticketLocator() {
    }


    public WSEticketLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSEticketLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSEticketSoap
    private java.lang.String WSEticketSoap_address = "http://qas.multimerchantvisanet.com/wsgenerareticket/wseticket.asmx";

    public java.lang.String getWSEticketSoapAddress() {
        return WSEticketSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSEticketSoapWSDDServiceName = "WSEticketSoap";

    public java.lang.String getWSEticketSoapWSDDServiceName() {
        return WSEticketSoapWSDDServiceName;
    }

    public void setWSEticketSoapWSDDServiceName(java.lang.String name) {
        WSEticketSoapWSDDServiceName = name;
    }

    public com.multimerchantvisanet.www.solicitudtransaccion.WSEticketSoap getWSEticketSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSEticketSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSEticketSoap(endpoint);
    }

    public com.multimerchantvisanet.www.solicitudtransaccion.WSEticketSoap getWSEticketSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.multimerchantvisanet.www.solicitudtransaccion.WSEticketSoapStub _stub = new com.multimerchantvisanet.www.solicitudtransaccion.WSEticketSoapStub(portAddress, this);
            _stub.setPortName(getWSEticketSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSEticketSoapEndpointAddress(java.lang.String address) {
        WSEticketSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.multimerchantvisanet.www.solicitudtransaccion.WSEticketSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.multimerchantvisanet.www.solicitudtransaccion.WSEticketSoapStub _stub = new com.multimerchantvisanet.www.solicitudtransaccion.WSEticketSoapStub(new java.net.URL(WSEticketSoap_address), this);
                _stub.setPortName(getWSEticketSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WSEticketSoap".equals(inputPortName)) {
            return getWSEticketSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://www.multimerchantvisanet.com/solicitudtransaccion", "WSEticket");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://www.multimerchantvisanet.com/solicitudtransaccion", "WSEticketSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSEticketSoap".equals(portName)) {
            setWSEticketSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
