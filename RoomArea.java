//Площадь комнаты

import java.util.*;

public class RoomArea {
    static int n;
    static char[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.nextLine());
        maze = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            maze[i] = scanner.nextLine().toCharArray();
        }

        int startRow = scanner.nextInt() - 1;
        int startCol = scanner.nextInt() - 1;

        System.out.println(bfs(startRow, startCol));
    }

    static int bfs(int x, int y) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n &&
                    !visited[nx][ny] && maze[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return count;
    }
}
