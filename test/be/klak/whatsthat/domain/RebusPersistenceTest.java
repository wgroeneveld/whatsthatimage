package be.klak.whatsthat.domain;

import junit.framework.Assert;

import org.junit.Test;

import be.klak.whatsthat.AbstractDatastoreTest;
import be.klak.whatsthat.OfyService;

public class RebusPersistenceTest extends AbstractDatastoreTest {

	@Test
	public void canISaveSomeRebus() {
		Rebus myRebus = saveRandomRebus("iets mooi");

		Rebus savedRebus = OfyService.ofy().load().type(Rebus.class).first().get();
		Assert.assertEquals("iets mooi", savedRebus.getAnswer());
		Assert.assertNotNull(myRebus.getId());
		Assert.assertEquals(1, myRebus.getDrawing().getPieces().get(0).getX());
	}

}
