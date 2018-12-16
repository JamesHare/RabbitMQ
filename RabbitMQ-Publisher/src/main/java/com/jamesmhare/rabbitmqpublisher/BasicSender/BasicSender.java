package com.jamesmhare.rabbitmqpublisher.BasicSender;

/**
 * This serves as an interface for a basic sender which publishes to a messaging
 * queue to send messages to any receivers subscribed to the message queue.
 * 
 * @author James Hare
 *
 */
public interface BasicSender {

	/**
	 * Asks the user for a message to send to any receivers listening on the message
	 * queue.
	 */
	void startSender();

	/**
	 * Returns the host of the sender as a {@link String}.
	 * 
	 * @return - The host of the sender as a {@link String}.
	 */
	String getHost();
}
