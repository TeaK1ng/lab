//Компоненты связности

import java.util.*;

public class ConnectedComponents {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static List<List<Integer>> components;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n + 1];
        components = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, component);
                components.add(component);
            }
        }
        System.out.println(components.size());
        for (List<Integer> comp : components) {
            System.out.println(comp.size());
            for (int node : comp) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
    private static void dfs(int node, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, component);
            }
        }
    }
}