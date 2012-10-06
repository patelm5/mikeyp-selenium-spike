package org.mikeyp;

import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Orchestrator {

	private static final Logger logger = Logger.getLogger(Orchestrator.class.getName());
	public static void main(String [] args)
	{
		if(args.length != 3)
		{
			logger.severe("Incorrect number of args. Arg1 : number of chrome windows, Arg2 : site, Arg3 : poll interval");
			System.exit(1);
		}
		System.setProperty("webdriver.chrome.driver","C:/chromedriver/chromedriver.exe");
		 ApplicationContext cxt = new ClassPathXmlApplicationContext("appContext.xml");
		 SeleniumController controller = cxt.getBean(SeleniumController.class); 
		 controller.startWindows(Integer.parseInt(args[0]),args[1],Long.parseLong(args[2])); 
	}
}
