package be.klak.whatsthat;

import org.junit.After;
import org.junit.Before;

import be.klak.whatsthat.domain.DrawablePiece;
import be.klak.whatsthat.domain.Drawing;
import be.klak.whatsthat.domain.Rebus;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public abstract class AbstractDatastoreTest {

	private final LocalServiceTestHelper helper =
			new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

	@Before
	public void setUp() {
		helper.setUp();
	}

	@After
	public void tearDown() {
		helper.tearDown();
	}

	protected Rebus saveRandomRebus(String answer) {
		Rebus myRebus = new Rebus(new Drawing(new DrawablePiece(1, 1)), answer);
		OfyService.ofy().save().entities(myRebus).now();
		return myRebus;
	}

}
