/**
 * Tiempo_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.java;

public class Tiempo_ServiceLocator extends org.apache.axis.client.Service implements com.java.Tiempo_Service {

    public Tiempo_ServiceLocator() {
    }


    public Tiempo_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Tiempo_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TiempoPort
    private java.lang.String TiempoPort_address = "http://localhost:8085/SistemaAlquiler/Tiempo";

    public java.lang.String getTiempoPortAddress() {
        return TiempoPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TiempoPortWSDDServiceName = "TiempoPort";

    public java.lang.String getTiempoPortWSDDServiceName() {
        return TiempoPortWSDDServiceName;
    }

    public void setTiempoPortWSDDServiceName(java.lang.String name) {
        TiempoPortWSDDServiceName = name;
    }

    public com.java.Tiempo_PortType getTiempoPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TiempoPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTiempoPort(endpoint);
    }

    public com.java.Tiempo_PortType getTiempoPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.java.TiempoPortBindingStub _stub = new com.java.TiempoPortBindingStub(portAddress, this);
            _stub.setPortName(getTiempoPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTiempoPortEndpointAddress(java.lang.String address) {
        TiempoPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.java.Tiempo_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.java.TiempoPortBindingStub _stub = new com.java.TiempoPortBindingStub(new java.net.URL(TiempoPort_address), this);
                _stub.setPortName(getTiempoPortWSDDServiceName());
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
        if ("TiempoPort".equals(inputPortName)) {
            return getTiempoPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://services/", "Tiempo");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://services/", "TiempoPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TiempoPort".equals(portName)) {
            setTiempoPortEndpointAddress(address);
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
