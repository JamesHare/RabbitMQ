package com.jamesmhare.rabbitmqsubscriber.application;

import com.jamesmhare.rabbitmqsubscriber.BasicReceiver.BasicReceiver;
import com.jamesmhare.rabbitmqsubscriber.BasicReceiver.BasicReceiverFactory;
import com.jamesmhare.rabbitmqsubscriber.MessageWorker.MessageWorker;
import com.jamesmhare.rabbitmqsubscriber.MessageWorker.MessageWorkerFactory;

/**
 * This will serve as an entry point for the RabbitMQ Subscriber application.
 * 
 * @author James Hare
 *
 */
public class Application {

	private static BasicReceiver basicReceiver;
	private static BasicReceiverFactory basicReceiverFactory;
	private static MessageWorker messageWorker;
	private static MessageWorkerFactory messageWorkerFactory;

	public static void main(String[] args) throws Exception {
		messageWorkerFactory = new MessageWorkerFactory();
		messageWorker = messageWorkerFactory.createMessageWorker();
		messageWorker.startWorker();
	}

}
