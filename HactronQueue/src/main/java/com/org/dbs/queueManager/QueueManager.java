package com.org.dbs.queueManager;

import java.util.LinkedList;
import java.util.Queue;
import java.math.BigInteger;
import java.util.HashMap;

class QueueDetails {
	String name;
	BigInteger max_size;
	Queue<String> queue;
}

public class QueueManager {
	
	private static HashMap<String, QueueDetails> queues = new HashMap<String, QueueDetails>();
	
	public static HashMap<String, Object> createQueue(String topic, BigInteger size){
		HashMap<String, Object> response = new HashMap<String, Object>();
		if (queues.containsKey(topic)) {	
			response.put("success", false);
			response.put("message","topic already exists.");
			return response;
		}
		QueueDetails queue = new QueueDetails();
		queue.max_size = size;
		queue.name = topic;
		queue.queue = new LinkedList<>(); 
		queues.put(topic, queue);
		response.put("success", true);
		response.put("message","topic created successfully.");
		return response;
	}
	 
}
