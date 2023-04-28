package com.ig.hcl.springboot.simplekafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
	@KafkaListener(topics="NewTopic", groupId="group_id")
	//Method
	public void consume(String message)
	{
		//Print Statement
		System.out.println("message"+message);
	}

}
