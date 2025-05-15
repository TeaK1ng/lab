//Путь в графе

import java.util.*;

public class ShortestPathInGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); 
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        int start = scanner.nextInt() - 1;
        int end = scanner.nextInt() - 1;

        int[] distance = new int[n];
        int[] parent = new int[n];
        Arrays.fill(distance, -1);
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (graph[current][neighbor] == 1 && distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    parent[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }

        if (distance[end] == -1) {
            System.out.println(-1);
            return;
        }

        List<Integer> path = new ArrayList<>();
        for (int v = end; v != -1; v = parent[v]) {
            path.add(v + 1);
        }
        Collections.reverse(path);

        System.out.println(distance[end]);
        for (int v : path) {
            System.out.print(v + " ");
        }
    }
}
