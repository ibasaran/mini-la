package com.minila.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minila.websocket.GreeatingController;

@RestController
@RequestMapping(path = "api/v1/testsocket")
public class TestController {
	
	@Autowired
	public GreeatingController gcontroller;
	
	@GetMapping
	public String sendMessageToClient() {
		
		gcontroller.sendMessageToClient("/topic/greetings", "Merhaba");
		
		return "Sended";
	}

}
