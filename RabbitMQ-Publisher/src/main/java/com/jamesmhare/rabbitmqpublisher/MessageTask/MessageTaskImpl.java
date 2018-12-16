package com.jamesmhare.rabbitmqpublisher.MessageTask;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * This serves as an implementation of the {@link MessageTask} interface.
 * 
 * @author James Hare
 *
 */
public class MessageTaskImpl implements MessageTask {

	private ConnectionFactory factory;

	public MessageTaskImpl() {
		factory = new ConnectionFactory();
		factory.setHost(MessageTaskConstants.HOST_NAME);
	}

	/**
	 * {@inheritDoc}
	 */
	public void startMessageTask() {
		try (Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();
				Scanner in = new Scanner(System.in)) {
			channel.queueDeclare(MessageTaskConstants.QUEUE_NAME, true, false, false, null);
			System.out.print("Enter your message: ");
			String message = in.nextLine();
			channel.basicPublish("", MessageTaskConstants.QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,
					message.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + message + "'");
		} catch (IOException | TimeoutException exception) {
			System.out.println(exception.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getHost() {
		return factory.getHost();
	}
}
