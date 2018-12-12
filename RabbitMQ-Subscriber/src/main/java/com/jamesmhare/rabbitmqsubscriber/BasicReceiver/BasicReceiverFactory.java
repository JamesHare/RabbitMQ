package com.jamesmhare.rabbitmqsubscriber.BasicReceiver;

/**
 * This serves as a factory for creating a new instance of the
 * {@link BasicReceiverImpl}
 * 
 * @author jameshare
 *
 */
public class BasicReceiverFactory {
	public BasicReceiver createBasicReceiver() {
		return new BasicReceiverImpl();
	}
}
