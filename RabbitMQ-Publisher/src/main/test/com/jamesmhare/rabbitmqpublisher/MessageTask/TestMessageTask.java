package com.jamesmhare.rabbitmqpublisher.MessageTask;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Test for the {@link MessageTaskFactory} class.
 * 
 * @author James Hare
 *
 */
public class TestMessageTask {

	/**
	 * Test to ensure that {@link MessageTaskFactory} works correctly with good
	 * input and that a new {@link MessageTask} object was created.
	 */
	@Test
	public void testMessageTaskFactorySuccess() {
		MessageTaskFactory testMessageTaskFactory = new MessageTaskFactory();
		MessageTask testMessageTask = testMessageTaskFactory.createMessageTask();
		assertThat(testMessageTask, instanceOf(MessageTask.class));
	}

}
