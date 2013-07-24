package org.zapto.aragao.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.zapto.aragao.MessageReceiver;
import org.zapto.aragao.service.MessageReceiverRegister;

@WebListener
public class StartupListener implements ServletContextListener  {

	@EJB
	private MessageReceiverRegister messageReceiverRegister;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent context) {
		loadProperty();
	}
	
	private void loadProperty() {
		Properties prop = new Properties();
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("message-receiver.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String messageClassName = prop.getProperty("message-receiver.class");
		if (messageClassName != null) {
			try {
				MessageReceiver msgRec = (MessageReceiver) Class.forName(messageClassName).newInstance();
				messageReceiverRegister.register(msgRec);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
       
}
