package be.klak.whatsthat.domain;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

import com.google.appengine.repackaged.org.codehaus.jackson.JsonParseException;
import com.google.appengine.repackaged.org.codehaus.jackson.map.JsonMappingException;
import com.google.appengine.repackaged.org.codehaus.jackson.map.ObjectMapper;

public class RebusSerializationTest {

	@Test
	public void canDeserializeSomeRebus() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"answer\":\"Submit my beautiful drawing!\",\"drawing\":{\"pieces\":[{\"x\":460,\"y\":143,\"piece\":true},{\"x\":457,\"y\":143},{\"x\":445,\"y\":143},{\"x\":436,\"y\":142},{\"x\":430,\"y\":142},{\"x\":425,\"y\":142},{\"x\":422,\"y\":142},{\"x\":491,\"y\":140,\"piece\":true},{\"x\":484,\"y\":140},{\"x\":465,\"y\":149},{\"x\":452,\"y\":158},{\"x\":441,\"y\":173},{\"x\":430,\"y\":207},{\"x\":430,\"y\":224},{\"x\":434,\"y\":236},{\"x\":441,\"y\":247},{\"x\":448,\"y\":253},{\"x\":457,\"y\":260},{\"x\":468,\"y\":264},{\"x\":474,\"y\":265},{\"x\":481,\"y\":266},{\"x\":487,\"y\":266},{\"x\":489,\"y\":266},{\"x\":488,\"y\":266},{\"x\":466,\"y\":259},{\"x\":430,\"y\":247},{\"x\":401,\"y\":237},{\"x\":380,\"y\":232},{\"x\":366,\"y\":229},{\"x\":353,\"y\":227},{\"x\":349,\"y\":226},{\"x\":347,\"y\":223},{\"x\":355,\"y\":211},{\"x\":370,\"y\":195},{\"x\":384,\"y\":181},{\"x\":400,\"y\":168},{\"x\":408,\"y\":166},{\"x\":415,\"y\":171},{\"x\":416,\"y\":193},{\"x\":415,\"y\":228},{\"x\":401,\"y\":257},{\"x\":380,\"y\":283},{\"x\":363,\"y\":300}]}}";
		Rebus rebus = new ObjectMapper().readValue(json, Rebus.class);

		Assert.assertEquals("Submit my beautiful drawing!", rebus.getAnswer());
		Assert.assertTrue(rebus.getDrawing().getPieces().size() > 1);
	}
}
