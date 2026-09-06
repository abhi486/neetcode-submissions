class Solution {
    int[] dx = new int[] {0, 0, 1, -1};
    int[] dy = new int[] {1, -1, 0, 0};
    int n, m;

    void dfs(int[][] grid, int i, int j, Set<Integer> set) {
        int hash = i * m + j;
        if (set.contains(hash)) return;

        set.add(hash);
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && x < n && y >= 0 && y < m && grid[i][j] <= grid[x][y]) {
                dfs(grid, x, y, set);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < n; i++) {
            dfs(grid, i, 0, set1);
            dfs(grid, i, m - 1, set2);
        }

        for (int j = 0; j < m; j++) {
            dfs(grid, 0, j, set1);
            dfs(grid, n - 1, j, set2);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int hash : set1) {
            if (set2.contains(hash)) {
                List<Integer> list = new ArrayList<>();
                list.add(hash / m);
                list.add(hash % m);
                ans.add(list);
            }
        }

        return ans;
    }
}
