package com.main.java.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.main.java.model.User;

@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics= "DataFetch" , groupId="DataTransformationGroup")
	public void consumeData(String message) {
		LOGGER.info(String.format("message recieved==%s", message));
	}
	
	@KafkaListener(topics= "DataFetch" , groupId="DataTransformationGroup")
	public void consumeData(User data) {
		LOGGER.info(String.format("message recieved==%s", data.toString()));
	}
	
//	public void consumeTransformedData(String message) {
//		LOGGER.info(String.format("message recieved==%s", message));
//	}
}
