package de.pandastudios.chatengine.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;



public class fileUtils
{
	
	public static String loadAsString(String path)
	{
		FileSystem fs = FileSystems.getDefault();
		Path p = fs.getPath(path);
		
		StringBuilder result = new StringBuilder();
		
		try (ObjectInputStream reader = new ObjectInputStream(Files.newInputStream((p))))
		{
			String line = "";
			while (reader != null)
			{
				try
				{
					line = (String) reader.readObject();
				} catch (ClassNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				result.append(line).append("\n");
			}
		} 
		catch (IOException e)
		{
			System.err.println("Couldn't find the file at " + p);
		}
		return result.toString();
	}
//	public static String loadAsString(String path)
//	{
//		StringBuilder result = new StringBuilder();
//
//		try (BufferedReader reader = new BufferedReader(new FileReader(path)))
//		{
//			String line = "";
//			while ((line = reader.readLine()) != null)
//			{
//				result.append(line).append("\n");
//			}
//		} 
//		catch (IOException e)
//		{
//			System.err.println("Couldn't find the file at " + path);
//		}
//
//		return result.toString();
//	}
	
	public static void writeAsString(String path,String content)
	{
		FileSystem fs = FileSystems.getDefault();
		Path p = fs.getPath(path);
		
		try (ObjectOutputStream writer = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(p))))
		{
			writer.writeObject(content);
			writer.flush();
		} 
		catch (IOException e)
		{
			System.err.println("Couldn't find the file at " + p);
		}
	}
//	public static void writeAsString(String path, String content)
//	{
//		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path,true)))
//		{
//			writer.write(content);
//			writer.newLine();
//		} 
//		catch (IOException e)
//		{
//			System.err.println("Couldn't find the file at " + path);
//		}
//	}
}
