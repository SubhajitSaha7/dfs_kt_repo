package com.cg.test;

import okhttp3.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import java.io.IOException;
import static org.junit.Assert.assertEquals;


public class WiremockWithJunit {
	
	//configures start and stop to port number automatically
	@Rule
	public WireMockRule wm = new WireMockRule(wireMockConfig().port(8080));
	
	private static final Logger log = LoggerFactory.getLogger(WireMockRule.class);
	
	
	@Test
	public void assertWiremockSetup() throws IOException {
	   
		log.info("assertWireMockSetup");
	    configureStubFindAll();
	 
	    OkHttpClient client = new OkHttpClient().newBuilder().build();
	 
	    Request request = new Request.Builder()
	        .url("http://localhost:8080/customer2/all")
	        .get()
	        .build();
	 
	    // Act - call the endpoint
	    Response response = client.newCall(request).execute();
	 
	    // Assert - verify the response
	    assertEquals("{\"customerId\":111,\"customerName\":\"LorenIpsum\",\"dateOfBirth\":\"1968-01-01\",\"phoneNumber\":\"0000000000\"}", response.body().string());
	    
	  }
	 
	  // stub for wiremock
	  private void configureStubFindAll() {
		  log.info("configureStubFindAll");
	    configureFor("localhost", 8080); 
	    
	    stubFor(get(urlPathEqualTo("/customer2/all"))
	    		.willReturn(okJson("{\"customerId\":111,\"customerName\":\"LorenIpsum\",\"dateOfBirth\":\"1968-01-01\",\"phoneNumber\":\"0000000000\"}")));
	    
	  }

}
