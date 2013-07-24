package org.zapto.aragao.service;

import java.util.concurrent.ConcurrentLinkedQueue;

import javax.ejb.Singleton;

import org.zapto.aragao.MessageReceiver;

/**
 * Session Bean implementation class MessageReceiverFactory
 */
@Singleton
public class MessageReceiverRegister {
	private ConcurrentLinkedQueue<MessageReceiver> receivers = new ConcurrentLinkedQueue<MessageReceiver>();
	
	public void process(String message) {
		for (MessageReceiver receiver : receivers) {
			receiver.process(message);
		}
	}
	
	public void register(MessageReceiver receiver) {
		receivers.add(receiver);
	}
}
