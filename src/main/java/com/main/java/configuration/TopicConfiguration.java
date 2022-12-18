package com.main.java.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfiguration {

	@Value("${Topic.dfPartitions}")
	String dfPartitions;
	
	@Value("${Topic.dfReplicas}")
	String dfReplicas;
	
	@Value("${Topic.tdPartitions}")
	String tdPartitions;
	
	@Value("${Topic.tdReplicas}")
	String tdReplicas;
	
	@Bean
	NewTopic fetchedData() {
		System.out.println(dfPartitions);
		return TopicBuilder.name("DataFetch").partitions(Integer.parseInt(dfPartitions)).replicas(Integer.parseInt(dfReplicas))
			      .build();
	}
	
	@Bean
	NewTopic transformedData() {
		return TopicBuilder.name("TransformedData").partitions(Integer.parseInt(tdPartitions)).replicas(Integer.parseInt(tdReplicas))
			      .build();
	}
}
