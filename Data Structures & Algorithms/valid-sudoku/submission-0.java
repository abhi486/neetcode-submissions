class Solution {
    public boolean isValidSudoku(char[][] grid) {
        int n = 9;
        
        // Check cols
        for (int j = 0; j < n; j++) {
            int[] map = new int[10];
            for (int i = 0; i < n; i++) {
                char ch = grid[i][j];
                if (ch == '.') continue;
                if (map[ch - '0'] == 1) return false;
                map[ch - '0'] = 1;
            }
        }

        // check row
        for (int i = 0; i < n; i++) {
            int[] map = new int[10];
            for (int j = 0; j < n; j++) {
                char ch = grid[i][j];
                if (ch == '.') continue;
                if (map[ch - '0'] == 1) return false;
                map[ch - '0'] = 1;
            }
        }

        // Check small grid
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                int[] map = new int[10];

                for (int l = i; l < i + 3; l++) {
                    for (int k = j; k < j + 3; k++) {
                        char ch = grid[l][k];
                        if (ch == '.') continue;
                        if (map[ch - '0'] == 1) return false;
                        map[ch - '0'] = 1;
                    }
                }
            }
        }

        return true;
    }
}
