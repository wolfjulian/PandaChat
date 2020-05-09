package de.pandastudios.chatengine.io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


import de.pandastudios.chatengine.config.Config;

public class Message 
{
	
	private String content;
	private BufferedImage bimg;
	
	public Message() 
	{

	}
	
	public String writeMessage(String content) 
	{
		this.content = content;
		
		return content;
	}
	
	public void writeImage(File img)
	{

			
		
		bimg = new BufferedImage(240, 240, BufferedImage.TYPE_INT_ARGB);
		try {
			bimg = ImageIO.read(img);
		}catch(IOException e)
		{
			System.out.println("Error creating Image in Message.writeImage()");
		}

	}
	public BufferedImage getBimg()
	{

		return bimg;

	}
	
	public long getSize() 
	{
		return content.getBytes().length;
	}
	
	public String toString()
	{
		return content;
	}
}
