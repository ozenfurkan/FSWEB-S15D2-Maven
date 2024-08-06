package org.example.entity;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class StringSet {

    public static Set<String> findUniqueWords(String text) {
        text = text.replaceAll("[0-9.,!?\"()]", "").toLowerCase();

        String[] words = text.split("\\s+");

        Set<String> uniqueWords = new TreeSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }

        return uniqueWords;
    }


}
