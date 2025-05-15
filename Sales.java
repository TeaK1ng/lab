//Продажи

import java.util.*;

public class SalesAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> salesData = new TreeMap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            if (parts.length == 3) {
                String buyer = parts[0];
                String item = parts[1];
                int quantity = Integer.parseInt(parts[2]);

                salesData.computeIfAbsent(buyer, k -> new TreeMap<>())
                        .merge(item, quantity, Integer::sum);
            }
        }
        scanner.close();

        for (Map.Entry<String, Map<String, Integer>> buyerEntry : salesData.entrySet()) {
            System.out.println(buyerEntry.getKey() + ":");
            for (Map.Entry<String, Integer> itemEntry : buyerEntry.getValue().entrySet()) {
                System.out.println(itemEntry.getKey() + " " + itemEntry.getValue());
            }
        }
    }
}