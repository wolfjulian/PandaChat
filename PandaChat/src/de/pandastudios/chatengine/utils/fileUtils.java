package de.pandastudios.chatengine.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class fileUtils
{
	public static String loadAsString(String path)
	{
		StringBuilder result = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(path)))
		{
			String line = "";
			while ((line = reader.readLine()) != null)
			{
				result.append(line).append("\n");
			}
		} 
		catch (IOException e)
		{
			System.err.println("Couldn't find the file at " + path);
		}

		return result.toString();
	}
	
	public static void writeAsString(String path, String content)
	{
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path,true)))
		{
			writer.write(content);
			writer.newLine();
		} 
		catch (IOException e)
		{
			System.err.println("Couldn't find the file at " + path);
		}
	}
}
