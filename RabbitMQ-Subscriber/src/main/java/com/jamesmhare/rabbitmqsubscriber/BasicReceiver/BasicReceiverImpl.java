package com.jamesmhare.rabbitmqsubscriber.BasicReceiver;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * This serves as an implementation of the {@link BasicReceiver} interface.
 * 
 * @author jameshare
 *
 */
public class BasicReceiverImpl implements BasicReceiver {

	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel;
	private DeliverCallback deliverCallback;

	public BasicReceiverImpl() {
		factory = new ConnectionFactory();
		factory.setHost(BasicReceiverConstants.HOST_NAME);
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.queueDeclare(BasicReceiverConstants.QUEUE_NAME, false, false, false, null);
		} catch (IOException | TimeoutException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void startReceiver() {
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		deliverCallback = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			System.out.println(" [x] Received '" + message + "'");
		};
		try {
			channel.basicConsume(BasicReceiverConstants.QUEUE_NAME, true, deliverCallback, consumerTag -> {
			});
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getHost() {
		return factory.getHost();
	}

}
