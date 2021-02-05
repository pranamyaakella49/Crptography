package com.assignment.crypto;
import java.util.Arrays;
import java.util.Scanner;

public class RowTranspositionCipherTest {
	
	public static void main(String[] args) {

		System.out.println("Enter the message");
		Scanner scanner = new Scanner(System.in);
		String message = scanner.nextLine();
		System.out.println("Enter the key");
		String key = scanner.nextLine();
		System.out.println("Enter the choice");
		System.out.println("1. Encryption \n 2. Decryption");
		int choice = scanner.nextInt();
		String updatedMessage = message.toLowerCase().trim();
		String updatedKey = key.toLowerCase();
		StringBuffer buffer = new StringBuffer();
		String[] updatedMessageArray = updatedMessage.split(" ");
		for(String s : updatedMessageArray){
			buffer.append(s);
		}
		int actualMessageLength = buffer.toString().length();
		int extraBits = (buffer.length()%updatedKey.length());
		StringBuffer removedBuffer = new StringBuffer();

			for (int i = 0; i < extraBits; i++) {
				buffer.append("x");
			}
		char[] keyChars = key.trim().toLowerCase().toCharArray();
		Arrays.sort(keyChars);
		String encryptedKey = null;
		String decryptedKey = null;

		switch (choice){
			case 1:
                                System.out.println("Entered plain text is " +message);
                                System.out.println("Entered key value is " +key);
				encryptedKey = Encryption.encryptWithKey(buffer.toString().toCharArray(), keyChars, updatedKey);
				break;
			case 2:
                                System.out.println("Entered cipher text is " +message);
                                System.out.println("Entered key value is " +key);
				decryptedKey = Decryption.decryptWithKey(buffer.toString().toCharArray(), keyChars, updatedKey);
				break;
		}

	}

}
