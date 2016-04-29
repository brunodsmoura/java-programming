package com.brunodoescoding.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
	
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
		int totalOfInputs = scanner.nextInt();

		if(totalOfInputs < 1 || totalOfInputs > 10) {
			throw new IllegalArgumentException("O numero de sequencias a serem enviadas deve estar no range de 1 a 10.");
		}

		List<String> sequences = new ArrayList<>();
		Pattern onlyLettersAllowed = Pattern.compile("[a-z]{1,100000}");

		for(int i = 0; i < totalOfInputs; i++) {
			String sequence = scanner.next();

			if(!onlyLettersAllowed.matcher(sequence).matches()) {
				throw new IllegalArgumentException(String.format("Sequencia %s nao condiz com a especificacao.", sequence));
			}

			sequences.add(sequence);
		}
		
		for(String sequence : sequences) {
			int length = sequence.length();
			int total = 0;

			for(int i = 0; i < length; i++){
				String preffix = sequence.substring(i, length);
				if(preffix.equals(sequence)) {
					total += length;
					continue;
				}

				int preffixLength = preffix.length();
				for(int j = 0; j < preffixLength; j++) {
					if(preffix.charAt(j) != sequence.charAt(j)){
						total += j;
						break;
					}
					
					if(j == (preffixLength - 1)) {
						total += preffixLength;
					}
				}
			}

			System.out.println(total);
		}
	}

}
