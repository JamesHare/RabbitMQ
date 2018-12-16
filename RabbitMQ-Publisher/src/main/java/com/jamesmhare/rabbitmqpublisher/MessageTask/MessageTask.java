package com.jamesmhare.rabbitmqpublisher.MessageTask;

/**
 * This serves as an interface for a message task which publishes to a messaging
 * queue to send messages to any receivers subscribed to the message queue. To
 * simulate processing time for a task, periods will be included in the message
 * {@link String} for each second that it takes to process.
 * 
 * @author James Hare
 *
 */
public interface MessageTask {

	/**
	 * Asks the user for a message to send to any receivers listening on the message
	 * queue. The number of periods given in a message correlates to the number of
	 * seconds it will take to process the message.
	 */
	void startMessageTask();

	/**
	 * Returns the host of the sender as a {@link String}.
	 * 
	 * @return - The host of the sender as a {@link String}.
	 */
	String getHost();
}
