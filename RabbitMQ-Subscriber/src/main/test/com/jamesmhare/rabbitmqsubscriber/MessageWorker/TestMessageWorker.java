package com.jamesmhare.rabbitmqsubscriber.MessageWorker;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Test for the {@link MessageWorkerFactory} class.
 * 
 * @author James Hare
 *
 */
public class TestMessageWorker {

	/**
	 * Test to ensure that {@link MessageWorkerFactory} works correctly with good
	 * input and that a new {@link MessageWorker} object was created.
	 */
	@Test
	public void testMessageWorkerFactorySuccess() {
		MessageWorkerFactory testMessageWorkerFactory = new MessageWorkerFactory();
		MessageWorker testMessageWorker = testMessageWorkerFactory.createMessageWorker();
		assertThat(testMessageWorker, instanceOf(MessageWorker.class));
	}

}
