class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l1 = 0;
        int r1 = matrix.length - 1;

        while (l1 <= r1) {
            int m1 = l1 + (r1 - l1) / 2;

            int l2 = 0;
            int r2 = matrix[m1].length - 1;

            // System.out.println(l1 + ", " r1 + ", " + m1);
            if (target > matrix[m1][r2]) {
                l1 = m1 + 1;
            }
            else if (target < matrix[m1][l2]) {
                r1 = m1 - 1;
            }
            else {
                // System.out.println(m1);
                while (l2 <= r2) {
                    int m2 = l2 + (r2 - l2) / 2;

                    if (matrix[m1][m2] == target) {
                        return true;
                    }
                    else if (matrix[m1][m2] < target) {
                        l2 = m2 + 1;
                    }
                    else {
                        r2 = m2 - 1;
                    }
                }

                return false;
            }
        }

        return false;
    }
}
