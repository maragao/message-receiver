package org.zapto.aragao.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.zapto.aragao.service.MessageReceiverRegister;

/**
 * Message-Driven Bean implementation class for: ReceiverListener
 */
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/queue/test") })
public class ReceiverConsumer implements MessageListener {
	
	@EJB
	private MessageReceiverRegister messageReceiverFactory;

	public void onMessage(Message message) {
		try {
			messageReceiverFactory.process(((TextMessage) message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
	