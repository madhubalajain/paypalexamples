package com.paypalexamples.base;

//Static Imports
import static io.restassured.RestAssured.given;
//Static Imports
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;


import org.junit.BeforeClass;
import org.junit.Test;

public class BaseClass {
	
	public	static String accessToken;
	
	//PUT YOUR CLIENT ID & CLIENT SECRET HERE
	public static final String  clientId="AWVSzxP0n5VVCWLnTnFeXKUbq5cyxrg2rv6jbbB7RDCtcB1-d_nUKTsoASGmesblBQonp7oQWdfTwy4H";
	public static  final String  clientSecret="EApbdsZawxUtJlnpVsG65hOnUCqssMD-fbzNmvkiJ5uIcneYL3iDBs_t_fOK6UOgfc_jMpQBuphkgzF-";

	@BeforeClass
	public static void init(){		

		RestAssured.baseURI="https://api.sandbox.paypal.com";
		RestAssured.basePath="/v1";

		accessToken=	given()
				.parameters("grant_type","client_credentials")
				.auth()
				.preemptive()
				.basic(clientId, clientSecret)
				.when()
				.post("/oauth2/token")
				.then()
				.extract()
				.path("access_token");
		 		System.out.println("Meu token é: "+accessToken);
	}
	
}
