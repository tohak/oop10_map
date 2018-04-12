package com.konovalov;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {

	public static ArrayList<String> textIn() {
		List<String> textIn = new ArrayList<>();
		String text = "";
		String temp = "";
		try (BufferedReader br = new BufferedReader(new FileReader("English.in"))) {
			for (; (temp = br.readLine()) != null;) {
				text += temp;
			}
		} catch (IOException e) {
			System.out.println("Error, read file");
		}
		String[] arrayText = text.split(" ");
	for (int i = 0; i < arrayText.length; i++) {
		textIn.add(arrayText[i]);
	}

		return (ArrayList<String>) textIn;
	}
	public static void textOutFile(String textOut) {
		try(BufferedWriter bw=new BufferedWriter(new FileWriter("Ukrainian.out"))) {
			bw.write(textOut);
		} catch (IOException e) {
			System.out.println("Error, write File");
		}
	}
	public static void dictionary(String text) {
		try(BufferedWriter bw=new BufferedWriter(new FileWriter("dictionary.txt",true))) {
			bw.write(text);
			bw.write(System.lineSeparator());
		} catch (IOException e) {
			System.out.println("Error, write File");
		}
	}
	
	

}
