package com.test.selenium4;

import java.util.Optional;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.network.Network;
import org.openqa.selenium.devtools.v111.network.model.Response;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.devtools.v111.network.model.Request;
import org.openqa.selenium.devtools.v111.network.model.RequestId;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CapAPIResponse {

	EdgeDriver driver;
	  	
	@Test
	public void seleniumTest() {
		driver = new EdgeDriver();
		DevTools devTools = driver.getDevTools(); 
		devTools.createSession();
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		devTools.addListener(Network.requestWillBeSent(), requestConsumer ->{
			Request request = requestConsumer.getRequest();
			System.out.println(request.getUrl());
		});
		
		final RequestId[] requestId = new RequestId[1];
		
		devTools.addListener(Network.responseReceived(), responseConsumer -> {
			Response response = responseConsumer.getResponse();
			requestId[0] = responseConsumer.getRequestId();	
			if( response.getUrl().contains("ws_api.php?")) {
				System.out.println(response.getStatus() + " "+ response.getUrl());
				Assert.assertEquals(response.getStatus() , 200);
				String responseBody = devTools.send(Network.getResponseBody(requestId[0] )).getBody();
				System.err.println(responseBody);
			}	
			
		});
	    driver.get("https://weatherstack.com/");
	 
	}
}
