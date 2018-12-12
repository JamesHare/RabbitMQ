package com.jamesmhare.rabbitmqsubscriber.application;

import com.jamesmhare.rabbitmqsubscriber.BasicReceiver.BasicReceiver;
import com.jamesmhare.rabbitmqsubscriber.BasicReceiver.BasicReceiverFactory;

/**
 * This will serve as an entry point for the RabbitMQ Subscriber application.
 * 
 * @author jameshare
 *
 */
public class Application {

	private static BasicReceiver basicReceiver;
	private static BasicReceiverFactory basicReceiverFactory;

	public static void main(String[] args) throws Exception {
		basicReceiverFactory = new BasicReceiverFactory();
		basicReceiver = basicReceiverFactory.createBasicReceiver();
		basicReceiver.startReceiver();
	}

}
