package be.klak.whatsthat.api;

import static be.klak.whatsthat.OfyService.ofy;
import be.klak.whatsthat.domain.Rebus;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

@Api(name = "whatsthat")
public class WhatsThatApi {

	@ApiMethod(name = "rebus.random")
	public Rebus getRandomRebus() {
		return ofy().load().type(Rebus.class).offset(getRandomRebusIndex()).first().safeGet();
	}

	private int getRandomRebusIndex() {
		return rand(0, ofy().load().type(Rebus.class).count());
	}

	private int rand(int Min, int Max) {
		return Min + (int) (Math.random() * ((Max - Min)));
	}

	@ApiMethod(name = "rebus.set", httpMethod = "POST")
	public Rebus uploadRebus(Rebus rebus) {
		ofy().save().entities(rebus).now();
		return rebus;
	}

}
