//Клавиатура
import java.io.*;

public class calcul {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine()); 
        int[] durability = new int[n];

        String[] parts = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            durability[i] = Integer.parseInt(parts[i]);
        }

        int k = Integer.parseInt(reader.readLine());
        int[] pressCount = new int[n];

        String[] presses = reader.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            int key = Integer.parseInt(presses[i]) - 1;
            pressCount[key]++;
        }

        for (int i = 0; i < n; i++) {
            if (pressCount[i] > durability[i]) {
                writer.write("YES\n");
            } else {
                writer.write("NO\n");
            }
        }

        reader.close();
        writer.flush();
        writer.close();
    }
}
