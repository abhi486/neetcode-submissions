class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[] dx = new int[] {0, 0, 1, -1};
        int[] dy = new int[] {1, -1, 0, 0};

        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        q.add(new int[] {0, 0, grid[0][0]});
        boolean[][] vis = new boolean[n][n];

        while (q.size() > 0) {
            int[] p = q.poll();
            int i = p[0];
            int j = p[1];
            int time = p[2];

            if (i == n - 1 && j == n - 1) {
                return time;
            }

            if (vis[i][j]) continue;
            vis[i][j] = true;
            
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];

                if (x >= 0 && x < n && y >= 0 && y < n && !vis[x][y]) {
                    if (grid[x][y] > time) {
                        q.add(new int[] {x, y, grid[x][y]});
                    }
                    else {
                        q.add(new int[] {x, y, time});
                    }
                }
            }
        }

        return 0;
    }
}
