package com.minila.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreeatingController {
	
	@Autowired
	private SimpMessagingTemplate webSocket;
	
	public void setWebSocket(SimpMessagingTemplate socket) {
		this.webSocket = socket;
	}

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}
	
	
	
	public void sendMessageToClient(String channel, String message) {
		webSocket.convertAndSend(channel, message);
	}
	

}
