package com.main.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.java.kafka.KafkaProducer;
import com.main.java.model.User;

@RestController
@RequestMapping("/kafka")
public class MessageController {
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	//http:localhost:8080/kafka/publishing?message=Hello_World
	@GetMapping("publishing")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("message sent");
	}
	
	@GetMapping("publishingJson")
	public ResponseEntity<String> publish(@RequestBody User user){
		kafkaProducer.sendMessage(user);
		return ResponseEntity.ok("message sent");
	}
}



