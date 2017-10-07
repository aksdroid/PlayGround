package edu.aksdroid.play.consumer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import edu.aksdroid.play.model.Player;

public class PlayConsumer {
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/playit";
		String response = restTemplate.getForObject(url, String.class);
		System.out.println(response);

		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

		ResponseEntity<Player> exchange = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Player.class);
		System.out.println(exchange.getBody());
	}
}
