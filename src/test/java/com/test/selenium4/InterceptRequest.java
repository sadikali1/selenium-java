package com.test.selenium4;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.fetch.Fetch;
import org.openqa.selenium.devtools.v111.network.model.Request;
import org.testng.annotations.Test;

public class InterceptRequest {

	ChromeDriver driver;
  	
	@Test
	public void seleniumTest() {
		driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devTools.addListener(Fetch.requestPaused(), requestConsumer ->{
			Request request = requestConsumer.getRequest();
			String currentRequestUrl = request.getUrl();
			if(currentRequestUrl.contains("ws_api.php?ip")) {
				String updateUrl = currentRequestUrl.replace("103.92.43.74", "103.156.141.100");
				
				devTools.send(Fetch.continueRequest(requestConsumer.getRequestId(), 
						Optional.of(updateUrl), Optional.empty(),Optional.empty(), 
						Optional.empty(), Optional.empty()));
			}
			else {
				devTools.send(Fetch.continueRequest(requestConsumer.getRequestId(), 
						Optional.of(currentRequestUrl), Optional.empty(),Optional.empty(), 
						Optional.empty(), Optional.empty()));
			}
			
		});
		
	    driver.get("https://weatherstack.com/");
	 
	}
}
