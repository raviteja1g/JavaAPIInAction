package com.java.api.lambdas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.api.model.House;

public class FunctionalInterfaceTest {

	static final Logger logger = LoggerFactory.getLogger(FunctionalInterfaceTest.class);

	public static void main(String[] args) {

		List<House> community = new ArrayList<>();

		House house1 = new House(1, "Test Address1", "100");
		House house2 = new House(2, "Test Address2", "1000");
		House house3 = new House(4, "Test Address3", "10000");
		House house4 = new House(1, "Test Address4", "10000");
		House house5 = new House(2, "Test Address5", "10000");
		House house6 = new House(3, "Test Address6", "10000");

		community.add(house1);
		community.add(house2);
		community.add(house3);
		community.add(house4);
		community.add(house5);
		community.add(house6);

		FunctionalInterfaceTest test = new FunctionalInterfaceTest();

		System.out.println("Impretive Style Programming:-----------------------------");
		test.performImperativeOperationsOnCommunity(community);

		System.out.println("\n Declarative Style Programming:-----------------------------");
		test.performDeclartiveStyleOperationsOnCommuninity(community);

		test.performTerminalOperationsOnCommunity(community);
		
		List<String> testStrings = new ArrayList<>();
		Collections.addAll(testStrings, "Test 1", "Test 2", "Test 3", "Test 4");
		test.performReduction(testStrings);
	}

	
	public void performTerminalOperationsOnCommunity(Collection<House> community) {
		Optional<House> randomHouse = community.stream().findAny();
		
		System.out.println("House selected: " + randomHouse.get());
		
		// community.stream().filter(house -> { return house.getNumberOfRooms()>3;}).findFirst().ifPresent(System.out::println);;
		
		community.stream().filter(house -> { return house.getNumberOfRooms()>3;}).findFirst().ifPresent( house -> System.out.println("First house with more than 3 rooms"));;
		
		boolean anyHouseWithFourRooms = community.stream().filter(house -> { return house.getNumberOfRooms()>3;}).anyMatch(house -> { return house.getNumberOfRooms() == 4;});
		 
		System.out.println("House with Four rooms: " + anyHouseWithFourRooms);
		
	}
	
	public void performDeclartiveStyleOperationsOnCommuninity(Collection<House> community) {
		System.out.println("Houses inside community before action: ");
		community.forEach(System.out::println);

		for (House house : community) {
			boolean isEligible = filter(house, (House h1) -> {
				return (h1.getNumberOfRooms() >= 2 ? true : false);
			});

			if (isEligible) {
				apply(house, (House inputHouse) -> {
					inputHouse.setAddress(inputHouse.getAddress().concat("*"));
					return inputHouse;
				});
			}
		}

		System.out.println("Houses inside community after action: ");
		community.forEach(System.out::println);
		
	}
	
	public void performReduction(Collection<String> listOfStrings) {
		StringBuilder reducedString = listOfStrings.stream().reduce(new StringBuilder(), (sb, s) -> sb.append(s), (sb1, sb2) -> sb1.append(sb2));
		System.out.println("Reduced String from sequential Stream: " + reducedString);
		
		StringBuilder reducedString1 = listOfStrings.stream().parallel().reduce(new StringBuilder(), (sb, s) -> sb.append(s), (sb1, sb2) -> sb1.append(sb2));		
		System.out.println("Reduced String (Inconsistent result due to use of StringBuilder as it is not thread safe and mutuable) from parallel Stream: " + reducedString1);
		
		StringBuilder reducedString2 = listOfStrings.stream().collect(() -> new StringBuilder(), (sb, s) -> sb.append(s), (sb1, sb2) -> sb1.append(sb2));
		System.out.println("Reduced String with collect (for mutable types) from sequential Stream: " + reducedString2);
		
		StringBuilder reducedString3 = listOfStrings.stream().parallel().collect(() -> new StringBuilder(), (sb, s) -> sb.append(s), (sb1, sb2) -> sb1.append(sb2));
		System.out.println("Reduced String with collect (for mutable types) from parallel Stream: " + reducedString3);
		
		String reducedString4 = listOfStrings.stream().parallel().collect(Collectors.joining());
		System.out.println("Reduced String with collect (for mutable types) from parallel Stream using Collectors: " + reducedString4);

		
	}

	public void performImperativeOperationsOnCommunity(Collection<House> community) {

		System.out.println("Houses inside community before action: ");
		community.forEach(System.out::println);

		community.stream().filter(house -> {
			return (house.getNumberOfRooms() >= 2);
		}).map((House inputHouse) -> {
			inputHouse.setAddress(inputHouse.getAddress().concat("*"));
			return inputHouse;
		});

		System.out.println("Houses inside community after action: ");
		community.forEach(System.out::println);
	}

	public boolean filter(House house, Predicate<House> filter) {
		return filter.test(house);
	}

	public House apply(House house, Function<House, House> transformer) {
		return transformer.apply(house);
	}

	@ParameterizedTest()
	@ValueSource(strings = {"UDUDUDUDUDUDU", "UDDDDUDUDUDUDUDUUUU"})
	public void solveCountingValleysOnHikeProblem(String hike) {
		int valleyCount = countingValleys(hike.length(), hike);
		logger.debug("Number of valleys in a hike: {} --> {}", hike, valleyCount);
	}
	
	
    int countingValleys(int n, String s) {
    	// Valley has to start with D and End with U
        // If(encounter D) --> +1 for U, -1 for D --> every time you get 0 increment 
        // valley count

        char[] steps = s.toCharArray();
        int valleyCount = 0;
        int trackSteps = 0;
        for (int i=0;i<steps.length;i++) {
            if(steps[i] == 'D') {
               trackSteps--;
            } else {
               trackSteps++;
            }
            if(trackSteps == 0 && 1 != 0 && steps[i] == 'U') {
                valleyCount++;    
            } 
            if(n-1 == i || trackSteps > (n - i - 1) || trackSteps < (i+1 -n)) {
                break;
            }
        }
      return valleyCount;
    }

}
