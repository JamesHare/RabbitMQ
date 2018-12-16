package com.jamesmhare.rabbitmqsubscriber.BasicReceiver;

/**
 * This serves as a factory for creating a new instance of the
 * {@link BasicReceiverImpl}
 * 
 * @author James Hare
 *
 */
public class BasicReceiverFactory {
	public BasicReceiver createBasicReceiver() {
		return new BasicReceiverImpl();
	}
}
