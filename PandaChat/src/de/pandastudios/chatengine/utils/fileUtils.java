package de.pandastudios.chatengine.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fileUtils {
	public static String loadAsString(String path) {
		StringBuilder result = new StringBuilder();
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(fileUtils.class.getResourceAsStream(path)))) {
			String line = "";
			while ((line = reader.readLine()) != null) {
				result.append(line).append("\n");
			}
		} catch (IOException e) {
			System.err.println("Couldn't find the file at " + path);
		}
		
		return result.toString();
	}
}
