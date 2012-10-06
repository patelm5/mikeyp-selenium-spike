package org.mikeyp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeleniumController {

	@Autowired
	private BrowserPollTask pollTask ; 
	
	public void startWindows(int numberOfWindows,String siteUrl,long pollInterval){
		
		for(int i =0 ; i < numberOfWindows ; i++)
		{
			pollTask.poll(i,siteUrl,pollInterval); 
		}
	}
}
