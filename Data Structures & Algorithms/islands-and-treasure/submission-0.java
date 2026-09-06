class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[] {i, j, 0});
                }
            }
        }

        while (q.size() > 0) {
            int[] p = q.poll();
            int i = p[0];
            int j = p[1];
            int dist = p[2];

            if (grid[i][j] == -1) continue;
            
            if (grid[i][j] != 0 && grid[i][j] != Integer.MAX_VALUE) continue;

            grid[i][j] = dist;

            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == Integer.MAX_VALUE) {
                    q.add(new int[] {x, y, dist + 1});
                }
            }
        }
    }
}
