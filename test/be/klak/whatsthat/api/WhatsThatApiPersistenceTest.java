package be.klak.whatsthat.api;

import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import be.klak.whatsthat.AbstractDatastoreTest;
import be.klak.whatsthat.domain.Rebus;

import com.googlecode.objectify.NotFoundException;

public class WhatsThatApiPersistenceTest extends AbstractDatastoreTest {

	@Test(expected = NotFoundException.class)
	public void theThingExplodesWhenNoRebussesAreAvailableAndIWantSome() {
		new WhatsThatApi().getRandomRebus();
	}

	@Test
	public void canILoadSomeRandomRebus() {
		List<String> randomAnswers = Arrays.asList(new String[] { "whoop", "pie", "is", "jumm", "y!!!" });
		for (String random : randomAnswers) {
			saveRandomRebus(random);
		}

		Rebus randomized = new WhatsThatApi().getRandomRebus();
		Assert.assertTrue(randomAnswers.contains(randomized.getAnswer()));
	}
}
