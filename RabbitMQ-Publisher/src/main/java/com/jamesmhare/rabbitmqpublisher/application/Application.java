package com.jamesmhare.rabbitmqpublisher.application;

import com.jamesmhare.rabbitmqpublisher.BasicSender.BasicSender;
import com.jamesmhare.rabbitmqpublisher.BasicSender.BasicSenderFactory;

/**
 * This will serve as an entry point for the RabbitMQ Publisher application.
 * 
 * @author jameshare
 *
 */
public class Application {

	private static BasicSender basicSender;
	private static BasicSenderFactory basicSenderFactory = new BasicSenderFactory();

	public static void main(String[] args) throws Exception {
		basicSender = basicSenderFactory.createBasicSender();
		basicSender.startSender();
	}

}
