package com.in28minutes.unittesting.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {

	@Test
	public void learning() {
		String responseFromService = "[" + 
				"{\"id\": 10000, \"name\": \"Pencil\", \"quantity\": 5}," + 
				"{\"id\": 10001, \"name\": \"Pen\", \"quantity\": 15}," + 
				"{\"id\": 10002, \"name\": \"Eraser\", \"quantity\": 10}," + 
				"]";
		
		DocumentContext ctx = JsonPath.parse(responseFromService);
		int length = ctx.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		List<Integer> ids = ctx.read("$..id");
		assertThat(ids).containsExactly(10000,10001,10002);
		
		System.out.println(ctx.read("$.[1]").toString());
		System.out.println(ctx.read("$.[0:2]").toString());
		System.out.println(ctx.read("$.[?(@.name=='Eraser')]").toString());
		System.out.println(ctx.read("$.[?(@.quantity==5)]").toString());
		
	}
}
