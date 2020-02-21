package com.company;

public class ConcreteEncryption implements Algorithm {
    @Override
    public String implementAlgorithm(String data, String typeOfAlgorithm, int key) {
        if (typeOfAlgorithm.equals("unicode")) {
            return unicodeEncryption(data, key);
        } else {
            return shiftEncryption(data, key);
        }
    }

    private String unicodeEncryption(String data, int key) {
        String encryptedString = "";
        for (int i = 0; i < data.length(); i++) {
            char c = (char) (data.charAt(i) + key);
            encryptedString = encryptedString.concat(String.valueOf(c));
        }
        return encryptedString;
    }

    private String shiftEncryption(String data, int key) {
        String encryptedString = "";
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (Character.isAlphabetic(c)) {
                if (c >= 65 && c <= 90) {
                    c += key;
                    if (c > 90) {
                        c = (char) (c - 90 + 64);
                    }
                } else if (c>=97&&c<=122) {
                    c += key;
                    if (c > 122) {
                        c = (char) (c - 122 + 96);
                    }
                }
            }
            encryptedString = encryptedString.concat(String.valueOf(c));
        }
        return encryptedString;
    }
}
