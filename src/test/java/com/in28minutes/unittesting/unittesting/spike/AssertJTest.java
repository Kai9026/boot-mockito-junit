package com.in28minutes.unittesting.unittesting.spike;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssertJTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12, 15, 45);
		
		assertThat(numbers).hasSize(3).contains(12, 15)
									  .allMatch(x -> x > 10)
									  .allMatch(x -> x < 100)
									  .noneMatch(x -> x < 0);
		
		assertThat("").isEmpty();
		assertThat("ABCDE").contains("BCD").startsWith("ABC")
										   .endsWith("CDE");
	}
}
