package de.pandastudios.chatengine.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import de.pandastudios.chatengine.config.Config;
import de.pandastudios.chatengine.io.Message;



public class fileUtils
{
	
	public static String loadAsString(String path)
	{		
		StringBuilder result = new StringBuilder();
		
		try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/de/pandastudios/chatengine/config/banlist")))
		{
			String line = "";
			while ((line = reader.readLine()) != null)
			{
				result.append(line).append("\n");
			}
		} 
		catch (IOException e)
		{
			System.err.println("Couldn't find the file at " );
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
			writer.writeObject("\n");
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
	
	
	public static File openFileChooser()
	{
	
		
		File f;// = new File(uploadfailed.jpg);
		JFileChooser chooser = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("Bilder","gif","png","jpg");
		chooser.addChoosableFileFilter(filter);
		System.out.println(chooser.getSelectedFile().getPath());
		int rueckgabewert = chooser.showDialog(null, "Datei auswählen");
		
		if(rueckgabewert == JFileChooser.APPROVE_OPTION)
		{
			
			return chooser.getSelectedFile();
		}
		return f;
	}
		
				
}
