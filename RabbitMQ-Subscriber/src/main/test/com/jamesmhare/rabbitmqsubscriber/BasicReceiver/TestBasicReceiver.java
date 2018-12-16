package com.jamesmhare.rabbitmqsubscriber.BasicReceiver;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Test for the {@link BasicReceiverFactory} class.
 * 
 * @author James Hare
 *
 */
public class TestBasicReceiver {

	/**
	 * Test to ensure that {@link BasicReceiverFactory} works correctly with good
	 * input and that a new {@link BasicReceiver} object was created.
	 */
	@Test
	public void testBasicReceiverFactorySuccess() {
		BasicReceiverFactory testBasicReceiverFactory = new BasicReceiverFactory();
		BasicReceiver testBasicReceiver = testBasicReceiverFactory.createBasicReceiver();
		assertThat(testBasicReceiver, instanceOf(BasicReceiver.class));
	}

}
