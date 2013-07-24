package org.zapto.aragao.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

import org.zapto.aragao.MessageReceiver;

/**
 * Session Bean implementation class MessageReceiverFactory
 */
@Singleton
public class MessageReceiverRegister {
	private List<MessageReceiver> receivers = new ArrayList<MessageReceiver>();
	
	public void delivery(String message) {
		for (MessageReceiver receiver : receivers) {
			receiver.process(message);
		}
	}
	
	public void register(MessageReceiver receiver) {
		receivers.add(receiver);
	}
	
	public void unregister(MessageReceiver receiver) {
		receivers.remove(receiver);
	}
}
