package soa;

public class RequestHandlerProxy implements soa.RequestHandler {
  private String _endpoint = null;
  private soa.RequestHandler requestHandler = null;
  
  public RequestHandlerProxy() {
    _initRequestHandlerProxy();
  }
  
  public RequestHandlerProxy(String endpoint) {
    _endpoint = endpoint;
    _initRequestHandlerProxy();
  }
  
  private void _initRequestHandlerProxy() {
    try {
      requestHandler = (new soa.RequestHandlerServiceLocator()).getRequestHandler();
      if (requestHandler != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)requestHandler)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)requestHandler)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (requestHandler != null)
      ((javax.xml.rpc.Stub)requestHandler)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public soa.RequestHandler getRequestHandler() {
    if (requestHandler == null)
      _initRequestHandlerProxy();
    return requestHandler;
  }
  
  public java.lang.String getStateDetails() throws java.rmi.RemoteException{
    if (requestHandler == null)
      _initRequestHandlerProxy();
    return requestHandler.getStateDetails();
  }
  
  
}