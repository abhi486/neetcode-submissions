class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] indegree = new int[n][m];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        // Calculate in-degrees for each cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] > matrix[i][j]) {
                        indegree[x][y]++;
                    }
                }
            }
        }
        
        // Add all cells with 0 in-degree to the queue
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (indegree[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        int ans = 0;
        
        // Process layer by layer (BFS)
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int s = 0; s < size; s++) {
                int[] curr = queue.poll();
                int i = curr[0], j = curr[1];
                
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < n && y >= 0 && y < m && matrix[x][y] > matrix[i][j]) {
                        indegree[x][y]--;
                        if (indegree[x][y] == 0) {
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}