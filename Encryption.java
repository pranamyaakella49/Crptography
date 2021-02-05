package com.assignment.crypto;
import java.util.HashMap;
import java.util.Map;

public class Encryption {

    public static String encryptWithKey(char[] updatedMessage, char[] sortedKeyChars, String updatedKey) {
        int rows = updatedMessage.length/sortedKeyChars.length;
        int columns = sortedKeyChars.length;
        int[] sortedKeyPos = new int[updatedKey.length()];

        char[][] transpositionMatrix = new char[rows][columns];
        int charIndex = 0;
        for(int i=0;i<rows; i++){
            for(int j=0;j<columns;j++){
                transpositionMatrix[i][j] = updatedMessage[charIndex];
                charIndex++;
            }
        }
        StringBuffer buffer = new StringBuffer();
        Map<Integer, Integer> charToIndexMap = new HashMap<>();

        for (int i = 0; i < updatedKey.length(); i++)
        {
            for (int j = 0; j < updatedKey.length(); j++)
            {
                if (updatedKey.toCharArray()[i] == sortedKeyChars[j])
                    charToIndexMap.put(j, i);
                sortedKeyPos[i] = j;
            }
        }

        for(Integer key: charToIndexMap.keySet()){
            int actualColumnIndex = charToIndexMap.get(key);

            for(int i=0; i<rows; i++){
                buffer.append(transpositionMatrix[i][actualColumnIndex]);
            }

        }
        System.out.println("Encrypted cipher text is "+buffer.toString());
        return buffer.toString();

    }
}
