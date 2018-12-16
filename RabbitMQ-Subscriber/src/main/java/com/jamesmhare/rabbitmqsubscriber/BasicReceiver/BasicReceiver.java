package com.jamesmhare.rabbitmqsubscriber.BasicReceiver;

/**
 * This serves as an interface for a basic receiver which subscribes to a
 * messaging queue to receive messages from the publisher.
 * 
 * @author James Hare
 *
 */
public interface BasicReceiver {

	/**
	 * Starts the message receiver.
	 */
	void startReceiver();

	/**
	 * Returns the host of the receiver as a {@link String}.
	 * 
	 * @return - The host of the receiver as a {@link String}.
	 */
	String getHost();
}
