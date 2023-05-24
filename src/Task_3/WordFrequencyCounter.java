package Task_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {

    public static void wordFrequencyCounter() {
        Map<String, Integer> wordsFreq = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().toLowerCase().split("\\s+");
                for (String word : words) {
                    if (word.length() > 0) {
                        Integer counter = wordsFreq.get(word);
                        if (counter == null) {
                            counter = 0;
                        }

                        wordsFreq.put(word, counter + 1);
                    }
                }
            }

            wordsFreq.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(System.out::println);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
