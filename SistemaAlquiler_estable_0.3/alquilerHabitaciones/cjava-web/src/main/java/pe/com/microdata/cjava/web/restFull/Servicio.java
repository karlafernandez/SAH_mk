/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.microdata.cjava.web.restFull;

 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
 
@Path("/message")
public class Servicio{
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {
 
		String result = "Restful example : " + msg;
 
		return Response.status(200).entity(result).build();
 
	}
 
}