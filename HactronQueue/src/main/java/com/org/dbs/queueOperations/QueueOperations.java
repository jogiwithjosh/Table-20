package com.org.dbs.queueOperations;

import java.math.BigInteger;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.dbs.queueManager.QueueManager;

@RestController
public class QueueOperations {

	@GetMapping("/create-queue")
	public HashMap<String, Object> createQueue(@RequestParam String topic, @RequestParam BigInteger size){
		return QueueManager.createQueue(topic, size);
	}
	
}
