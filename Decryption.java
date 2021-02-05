package com.assignment.crypto;
import java.util.HashMap;
import java.util.Map;

public class Decryption {
    public static String decryptWithKey(char[] updatedMessage, char[] sortedKeyChars, String updatedKey) {
        int rows = updatedMessage.length/sortedKeyChars.length;
        int columns = sortedKeyChars.length;
        char[][] transpositionMatrix = new char[rows][columns];
        int charIndex = 0;
        for(int i=0;i<columns; i++){
            for(int j=0;j<rows;j++){
                transpositionMatrix[j][i] = updatedMessage[charIndex];
                charIndex++;
            }
        }
        StringBuffer buffer = new StringBuffer();
        Map<Character, Integer> sortedCharToIndexMap = new HashMap<>();
        for(int i=0;i<sortedKeyChars.length;i++){
            sortedCharToIndexMap.put(sortedKeyChars[i], i);
        }

        Map<Character, Integer> originalCharToIndexMap = new HashMap<>();
        for(int i=0;i<updatedKey.length();i++){
            originalCharToIndexMap.put(updatedKey.toCharArray()[i], sortedCharToIndexMap.get(updatedKey.toCharArray()[i]));
        }
        char[][] decryptedMatrix = new char[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<updatedKey.length();j++){
                int index = originalCharToIndexMap.get(updatedKey.toCharArray()[j]);
                decryptedMatrix[i][j] = transpositionMatrix[i][index];
            }
        }
        StringBuffer decryptedBuffer = new StringBuffer();
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                decryptedBuffer.append(decryptedMatrix[i][j]);
            }
        }
        System.out.println("Decrypted plain text is "+decryptedBuffer.toString());
        return decryptedBuffer.toString();
    }
}
