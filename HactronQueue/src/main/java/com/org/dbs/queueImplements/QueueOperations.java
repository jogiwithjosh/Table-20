package com.org.dbs.queueImplements;

import java.math.BigInteger;
import java.util.HashMap;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.dbs.queueManager.QueueManager;

@CrossOrigin(origins = "*")
@RestController
public class QueueOperations {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String createQueue(@RequestParam String topic){
		return topic;
	}
	
	@GetMapping("/create-queue")
	@ResponseBody
	public HashMap<String, Object> createQueue(@RequestParam String topic, @RequestParam BigInteger size){
		return QueueManager.createQueue(topic, size);
	}
	
	@GetMapping("/delete-queue")
	@ResponseBody
	public HashMap<String, Object> deleteQueue(@RequestParam String topic, @RequestParam BigInteger size){
		return QueueManager.deleteQueue(topic);
	}
	
	@GetMapping("/add-element")
	@ResponseBody
	public HashMap<String, Object> addElement(@RequestParam String topic, @RequestParam String element){
		return QueueManager.addElement(topic, element);
	}
	
	@GetMapping("/list-topics")
	@ResponseBody
	public HashMap<String, Object> getQueues() {
		return QueueManager.getQueues();
	}
	
	@GetMapping("/register-consumer")
	@ResponseBody
	public HashMap<String, Object> registerConsumer(@RequestParam String topic) {
		return QueueManager.registerConsumer(topic);
	}
	
	@GetMapping("/browse-messages")
	@ResponseBody
	public HashMap<String, Object> browseMessages(@RequestParam String topic) {
		return QueueManager.browseMessages(topic);
	}
	
	@GetMapping("/consumer")
	@ResponseBody
	public HashMap<String, Object> Consumer(@RequestParam String topic) {
		return QueueManager.Consumer(topic);
	}
	
	@GetMapping("/queue-status")
	@ResponseBody
	public HashMap<String, Object> queueStatus(@RequestParam String topic) {
		return QueueManager.queueStatus(topic);
	}
	
	
}