package com.java.api.collections;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.api.model.House;

public class HashSetTest {

	static final Logger logger = LoggerFactory.getLogger(HashSetTest.class);

	@Test
	public void testHashTableVariants() {
		Set<House> community = new HashSet<House>();

		House house1 = new CustomHouse(3, "Test Address1", "1024sqft");
		House house2 = new CustomHouse(3, "Test Address1", "1024sqft");

		community.add(house1);
		community.add(house2);

		logger.debug("Value of community: {}", community);

		// Since house1 and house2 are logically equal, and as set should not have
		// duplicates.
		// hashCode and equal methods have to be overridden so that both hash values of
		// the objects will result in same value,
		// Understand that Hash function value is dependent on the hash code and
		// comparison of two object values is determined
		// by equals method by default
		
		Assertions.assertEquals(1, community.size());

	}
	
	public class CustomHouse extends House{

		public CustomHouse(int numberOfRooms, String address, String space) {
			super(numberOfRooms, address, space);
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.address.hashCode();
			
		}
		
		@Override
		public boolean equals(Object object) {
			return (super.numberOfRooms == ((CustomHouse)object).numberOfRooms && super.address == ((CustomHouse)object).address && super.space == ((CustomHouse)object).space);
		}
		
	}

}
