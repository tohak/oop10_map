package com.konovalov;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		File fileDictionary = new File("dictionary.txt");
		String eng = "world";
		String ua = "mir";
		String separator = ",";
		FileOperation.dictionary(eng + separator + ua);
		Map<String, String> map = mapDic(fileDictionary);
		List<String> list = FileOperation.textIn();
		transl(list, map);
	}

	public static HashMap<String, String> mapDic(File file) {
		Map<String, String> mapDic = new HashMap<>();
		String temp = "";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (; (temp = br.readLine()) != null;) {
				String[] arrTemp = temp.split(",");				
				mapDic.put(arrTemp[0], arrTemp[1]);
			}
		} catch (IOException|NullPointerException e) {
			System.out.println("Error, read file");
		}
		return (HashMap<String, String>) mapDic;
	}

	public static void transl(List<String> list, Map<String, String> map) {
		String text = "";
		for (String element : list) {
			if (map.containsKey(element)) {
				text += map.get(element) + " ";
			}
		}
		FileOperation.textOutFile(text);
	}
}
