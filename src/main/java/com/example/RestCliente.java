package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestCliente {
	private static final String GET_ALL_PRODUCTOS_API = "http://localhost:8080/api/producto";
	private static final String GET_PRODUCTO_BY_ID_API = "http://localhost:8080/api/producto/{id}";
	
	static RestTemplate restTemplate = new RestTemplate();
	
	public static void main(String[] args) {
		callGetAllProductosAPI();
		System.out.println("\n");
		callGetProductoByAPI();
	}
	
	private static void callGetAllProductosAPI() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		ResponseEntity<String> result = restTemplate.exchange(GET_ALL_PRODUCTOS_API, HttpMethod.GET, entity, String.class);
		System.out.println(result);
	}
	
	private static void callGetProductoByAPI() {
		Map<String, Integer> param = new HashMap<>();
		param.put("id", 1);
		
		String resultado =restTemplate.getForObject(GET_PRODUCTO_BY_ID_API, String.class, param);
		System.out.println(resultado);
	}
}
