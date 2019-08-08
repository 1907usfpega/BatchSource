package com.revature.driver;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.bean.ZipCode;

public class ClientDriver {

	public static void main(String[] args) {
		Client client= ClientBuilder.newClient();
		WebTarget webTarget= client.target("http://localhost:8080/ZIpCodeService/rest/zipcodes");
		//Get Request for a specific zipcode
		Builder getZipCodeBuilder= webTarget.path("33559").request();
		Response getZipCodeResponse= getZipCodeBuilder.accept(MediaType.APPLICATION_JSON).get();
		 int statusCode=getZipCodeResponse.getStatus();
		 System.out.println("Returned with status code: "+statusCode );
		 ZipCode z= getZipCodeResponse.readEntity(ZipCode.class);
		 System.out.println(z);
		 
		 System.out.println("************************");
		 //Post Request
		 Builder bob= webTarget.request();
		 z= new ZipCode(35775,"Valhermoso Springs","Alabama");
		 Response postZipCodeResponse= bob.accept(MediaType.APPLICATION_JSON)
				 .post(Entity.entity(z, MediaType.APPLICATION_JSON));
		 statusCode=postZipCodeResponse.getStatus();
		 System.out.println("Returned with status code: "+statusCode );
		 String s= postZipCodeResponse.readEntity(String.class);
		 System.out.println(s);
		}

}
