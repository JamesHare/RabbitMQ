package com.jamesmhare.rabbitmqpublisher.BasicSender;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * This serves as an implementation of the {@link BasicSender} interface.
 * 
 * @author James Hare
 *
 */
public class BasicSenderImpl implements BasicSender {

	private ConnectionFactory factory;

	public BasicSenderImpl() {
		factory = new ConnectionFactory();
		factory.setHost(BasicSenderConstants.HOST_NAME);
	}

	/**
	 * {@inheritDoc}
	 */
	public void startSender() {
		try (Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();
				Scanner in = new Scanner(System.in)) {
			channel.queueDeclare(BasicSenderConstants.QUEUE_NAME, false, false, false, null);
			System.out.print("Enter a message: ");
			String message = in.nextLine();
			channel.basicPublish("", BasicSenderConstants.QUEUE_NAME, null, message.getBytes("UTF-8"));
			System.out.println(" [x] Sent '" + message + "'");
		} catch (IOException | TimeoutException e) {
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
