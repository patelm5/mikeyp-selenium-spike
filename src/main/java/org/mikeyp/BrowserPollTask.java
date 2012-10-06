package org.mikeyp;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class BrowserPollTask {


	private static final Logger logger = Logger.getLogger(BrowserPollTask.class.getName());
	@Async
	public void poll(int id, String siteUrl,long pollInterval) {

		WebDriver driver = new ChromeDriver();

		boolean notLoaded = true;
		while (notLoaded) {
			try {
				driver.manage().timeouts().implicitlyWait(pollInterval, TimeUnit.SECONDS);
				driver.get(siteUrl);
				notLoaded = false;
			} catch (Exception e) {
				notLoaded = true;
			}
			
		}
		logger.info("WINDOW "+id+" IS READY");
	}
}
