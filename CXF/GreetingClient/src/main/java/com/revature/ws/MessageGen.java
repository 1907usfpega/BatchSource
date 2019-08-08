package com.revature.ws;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2019-08-07T16:43:04.286-04:00
 * Generated source version: 3.1.6
 * 
 */
@WebService(targetNamespace = "http://ws.revature.com/", name = "MessageGen")
@XmlSeeAlso({ObjectFactory.class})
public interface MessageGen {

    @WebMethod
    @RequestWrapper(localName = "getMessage", targetNamespace = "http://ws.revature.com/", className = "com.revature.ws.GetMessage")
    @ResponseWrapper(localName = "getMessageResponse", targetNamespace = "http://ws.revature.com/", className = "com.revature.ws.GetMessageResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String getMessage();
}
