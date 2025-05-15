//Самое частое слово

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder text = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            text.append(line).append(" ");
        }

        String[] words = text.toString().trim().split("\\s+");

        HashMap<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        String result = words[0];
        int maxCount = freq.get(result);

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && word.compareTo(result) < 0)) {
                maxCount = count;
                result = word;
            }
        }

        writer.write(result);
        writer.newLine();
        writer.flush();
        reader.close();
        writer.close();
    }
}
