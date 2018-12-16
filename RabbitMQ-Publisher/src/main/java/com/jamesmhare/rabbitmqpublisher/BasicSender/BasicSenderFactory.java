package com.jamesmhare.rabbitmqpublisher.BasicSender;

/**
 * This serves as a factory for creating a new instance of the
 * {@link BasicSenderImpl}
 * 
 * @author James Hare
 *
 */
public class BasicSenderFactory {
	public BasicSender createBasicSender() {
		return new BasicSenderImpl();
	}
}
