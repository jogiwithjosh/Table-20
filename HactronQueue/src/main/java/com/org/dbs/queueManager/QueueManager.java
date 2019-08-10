package com.org.dbs.queueManager;

import java.util.LinkedList;
import java.util.Queue;
import java.math.BigInteger;
import java.util.ArrayList;
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
	
	public static HashMap<String, Object> deleteQueue(String topic){
		HashMap<String, Object> response = new HashMap<String, Object>();
		if (queues.containsKey(topic)) {
			queues.remove(topic);
			response.put("success", true);
			response.put("message", "topic deleted successfully");
			return response;
		}
		response.put("success", false);
		response.put("message", "topic doesn't exists");
		return response;
	}
	
	public static HashMap<String, Object> addElement(String topic, String element){
		HashMap<String, Object> response = new HashMap<String, Object>();
		if (queues.containsKey(topic)) {
			QueueDetails queue = queues.get(topic);
			
			if(BigInteger.valueOf(queue.queue.size()).compareTo(queue.max_size) < 0) {
				queue.queue.add(element);
				response.put("success", true);
				response.put("message", "message published successfully.");
				return response;
			}
			response.put("success", false);
			response.put("message", "queue is over populated.");
			return response;
		}
		response.put("success", false);
		response.put("message", "topic doesn't exists");
		return response;
	}
	
	public static HashMap<String, Object> getQueues(){
		HashMap<String, Object> response = new HashMap<String, Object>();
		if (queues.size() > 0) {
			ArrayList<String> topics = new ArrayList<>(queues.keySet());
			response.put("success", true);
			response.put("queues", topics);
			response.put("message", "list of queues.");
			return response;
		}
		response.put("success", false);
		response.put("queues", new ArrayList<String>());
		response.put("messages", "no queues present.");
		return response;
		
	}
	
	public static HashMap<String, Object> registerConsumer(String topic){
		HashMap<String, Object> response = new HashMap<String, Object>();
		if (queues.containsKey(topic)) {
			response.put("success", true);
			response.put("socket-url", "http://d57e3509.ngrok.io:6000");
			response.put("message", "subscribe to the url.");
			return response;
		}
		response.put("success", false);
		response.put("socket-url", "");
		response.put("message", "topic doesn't exist.");
		return response;
	}
	
	public static HashMap<String, Object> browseMessages(String topic){
		HashMap<String, Object> response = new HashMap<String, Object>();
		if (queues.containsKey(topic)) {
			response.put("success",true);
			response.put("messages", new ArrayList<String>(queues.get(topic).queue));
			response.put("message", "");
			return response;
		}
		response.put("success",false);
		response.put("topic", new ArrayList<String>());
		response.put("message", "topic doesn't exist.");
		return response;
	}
	
	public static HashMap<String, Object> Consumer(String topic){
		HashMap<String, Object> response = new HashMap<String, Object>();
		if (queues.containsKey(topic)) {
			response.put("success",true);
			response.put("topicMessage", queues.get(topic).queue.poll());
			response.put("message", "");
			return response;
		}
		response.put("success",false);
		response.put("topicMessage", new ArrayList<String>());
		response.put("message", "topic doesn't exist.");
		return response;
	}
	
	public static HashMap<String, Object> queueStatus(String topic){
		HashMap<String, Object> response = new HashMap<String, Object>();
		if (queues.containsKey(topic)) {
			response.put("success",true);
			response.put("name", queues.get(topic).name);
			response.put("max-size", queues.get(topic).max_size);
			response.put("current-size", queues.get(topic).queue.size());
			response.put("message", "");
			return response;
		}
		response.put("success", false);
		response.put("name", "");
		response.put("max-size", 0);
		response.put("current-size", 0);
		response.put("message", "topic doesn't exist.");
		return response;
	}

}
