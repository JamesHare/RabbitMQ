package com.jamesmhare.rabbitmqpublisher.BasicSender;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Test for the {@link BasicSenderFactory} class.
 * 
 * @author James Hare
 *
 */
public class TestBasicSenderFactory {

	/**
	 * Test to ensure that {@link BasicSenderFactory} works correctly with good
	 * input and that a new {@link BasicSender} object was created.
	 */
	@Test
	public void testBasicSenderFactorySuccess() {
		BasicSenderFactory testBasicSenderFactory = new BasicSenderFactory();
		BasicSender testBasicSender = testBasicSenderFactory.createBasicSender();
		assertThat(testBasicSender, instanceOf(BasicSender.class));
	}

}
