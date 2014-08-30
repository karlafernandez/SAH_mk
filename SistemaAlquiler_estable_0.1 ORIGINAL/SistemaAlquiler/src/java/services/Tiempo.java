/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author karla
 */
@WebService(serviceName = "Tiempo")
public class Tiempo {

       /**
     * Web service operation
     */
    @WebMethod(operationName = "getTime")
    public String getTime() {
        //TODO write your implementation code here:
        return new Date().toString();
        
    }
}
