package com.company;

public class ConcreteDecryption implements Algorithm {
    @Override
    public String implementAlgorithm(String data, String typeOfAlgorithm, int key) {
        if (typeOfAlgorithm.equals("unicode")) {
            return unicodeDecryption(data, key);
        } else {
            return shiftDecryption(data, key);
        }
    }

    private String unicodeDecryption(String data, int key) {
        String decryptedString = "";
        for (int i = 0; i < data.length(); i++) {
            char c = (char) (data.charAt(i) - key);
            decryptedString = decryptedString.concat(String.valueOf(c));
        }
        return decryptedString;
    }

    private String shiftDecryption(String data, int key) {
        String decryptedString = "";
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (Character.isAlphabetic(c)) {
                if (c >= 65 && c <= 90) {
                    c -= key;
                    if (c < 65) {
                        c = (char) (91 - 65 + c);
                    }
                } else if (c >= 97 && c <= 122) {
                    c -= key;
                    if (c < 97) {
                        c = (char) (123 - 97 + c);
                    }
                }
            }

            decryptedString = decryptedString.concat(String.valueOf(c));
        }
        return decryptedString;
    }
}
