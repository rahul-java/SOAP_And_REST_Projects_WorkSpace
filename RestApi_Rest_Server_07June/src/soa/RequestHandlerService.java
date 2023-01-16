/**
 * RequestHandlerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soa;

public interface RequestHandlerService extends javax.xml.rpc.Service {
    public java.lang.String getRequestHandlerAddress();

    public soa.RequestHandler getRequestHandler() throws javax.xml.rpc.ServiceException;

    public soa.RequestHandler getRequestHandler(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
