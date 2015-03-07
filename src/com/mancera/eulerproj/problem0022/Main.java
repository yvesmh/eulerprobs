package com.mancera.eulerproj.problem0022;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*


Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?

 */
public class Main {
	
	private static String FILE_PATH = "src/com/mancera/eulerproj/problem0022/p022_names.txt";

	public static void main(String[] args) {
		
		try {
			String allNames = readNamesFile(FILE_PATH);
			List<String> ordered = orderedNamesListFromFileContents(allNames);
			long sum = 0;
			int size = ordered.size();
			int score;
			String name;
			for(int i = 0; i < size; i++) {
				name = ordered.get(i);
				score = nameScore(name);
				sum += (score * (i + 1));
			}
			
			System.out.println("Answer: " + sum);
		
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	private static String readNamesFile(String fileName) throws FileNotFoundException, IOException {
		
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			
			while(line != null) {
				sb.append(line);
				line = reader.readLine();
			}
			return sb.toString();
		}
	}
	
	private static List<String> orderedNamesListFromFileContents(final String fileContent) {
		
		String[] arrayOfNames = fileContent.split(",");
		List<String> namesWithoutQuotes = new ArrayList<String>();
		for(String name: arrayOfNames) {
			namesWithoutQuotes.add(name.replaceAll("\"", ""));
		}
		
		Collections.sort(namesWithoutQuotes);
		return namesWithoutQuotes;
	}
	
	private static int nameScore(final String name) {
		int score = 0;
		char[] nameChars = name.toCharArray();
		for(char letter: nameChars) {
			//assume all are capital. A starts at 0x41 and it's value is 1
			score += letter - 0x40;
		}
		return score;
	}
}
