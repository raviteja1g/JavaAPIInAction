package com.java.api.oops.concepts;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.api.model.Apartment;

public class HiTechApartment extends Apartment {

	public static final Logger logger = LoggerFactory.getLogger(HiTechApartment.class);

	@Test
	public void testProtectedMembersAcces() {

		logger.debug("Acccessing protected member inherited from Apartment super class: {} ",
				this.digitalLockAvailable);
	}

	protected void isAptDigitallySecure(Apartment apt) {

		/*
		 * Compilation error accessing on any object passed to apt, Since this way of
		 * access will allow classes that are not subclass of Apartment will gain access
		 * to it
		 */
		// boolean isSucure = apt.digitalLockAvailable;

		// Accessing a protected member inherited from Apartment class
		boolean isSecure = this.digitalLockAvailable;

		this.isDigitalLockAvailable();

		isSecure = super.digitalLockAvailable;

		super.isDigitalLockAvailable();
	}

}
