//Поиск цикла

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CycleDetection {
    static int cycleStart = -1;
    static int cycleEnd = -1;
    static boolean findCycleDFS(int u, int p, int n, int[][] adjMatrix, boolean[] visited, int[] parent) {
        visited[u] = true;
        parent[u] = p;
        for (int v = 0; v < n; ++v) {
            if (adjMatrix[u][v] == 1) {
                if (v == p) {
                    continue;
                }
                if (visited[v]) {
                    cycleStart = v;
                    cycleEnd = u;
                    return true;
                }
                if (!visited[v]) {
                    if (findCycleDFS(v, u, n, adjMatrix, visited, parent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                if (findCycleDFS(i, -1, n, adjMatrix, visited, parent)) {
                    break;
                }
            }
        }
        if (cycleStart == -1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            List<Integer> cycle = new ArrayList<>();
            int curr = cycleEnd;
            while (curr != cycleStart) {
                cycle.add(curr + 1);
                curr = parent[curr];
            }
            cycle.add(cycleStart + 1);
            System.out.println(cycle.size());
            for (int i = cycle.size() - 1; i >= 0; --i) {
                System.out.print(cycle.get(i) + (i == 0 ? "" : " "));
            }
            System.out.println();
        }
    }
}