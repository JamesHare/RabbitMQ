package com.jamesmhare.rabbitmqsubscriber.MessageWorker;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 * This serves as an implementation of the {@link MessageWorker} interface.
 * 
 * @author James Hare
 *
 */
public class MessageWorkerImpl implements MessageWorker {

	private ConnectionFactory factory;
	private Connection connection;
	private Channel channel;

	public MessageWorkerImpl() {
		factory = new ConnectionFactory();
		factory.setHost(MessageWorkerConstants.HOST_NAME);
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
		} catch (IOException | TimeoutException exception) {
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void startWorker() {
		try {
			channel.queueDeclare(MessageWorkerConstants.QUEUE_NAME, true, false, false, null);
			System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

			channel.basicQos(1);

			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
				String message = new String(delivery.getBody(), "UTF-8");

				System.out.println(" [x] Received '" + message + "'");
				try {
					processMessage(message);
				} finally {
					System.out.println(" [x] Done");
					channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
				}
			};
			channel.basicConsume(MessageWorkerConstants.QUEUE_NAME, false, deliverCallback, consumerTag -> {
			});
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void processMessage(String message) {
		for (char ch : message.toCharArray()) {
			if (ch == '.') {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException exception) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getHost() {
		return factory.getHost();
	}

}
