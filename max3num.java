//Наибольшее произведение трех чисел
import java.io.*;
import java.util.Arrays;

public class max3num {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = reader.readLine().split(" ");
        reader.close();

        int n = parts.length;
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        Arrays.sort(nums);

        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int option2 = nums[0] * nums[1] * nums[n - 1];

        if (option1 > option2) {
            System.out.println(nums[n - 1] + " " + nums[n - 2] + " " + nums[n - 3]);
        } else {
            System.out.println(nums[0] + " " + nums[1] + " " + nums[n - 1]);
        }
    }
}