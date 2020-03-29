package de.pandastudios.chatengine.io;

import de.pandastudios.chatengine.config.Config;

public class Message {
	
	private String content;
	
	public Message() {

	}
	
	public String writeMessage(String content) {
		this.content = content;
		
		return content;
	}
	
	public long getSize() {
		return content.getBytes().length;
	}
	
}
