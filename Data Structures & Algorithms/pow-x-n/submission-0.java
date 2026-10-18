class Solution {
    double pow(double x, int n) {
        if (n == 0) return 1;

        double p = pow(x, n / 2);

        if ((n & 1) == 1) return p * p * x;

        return p * p;
    }
    public double myPow(double x, int n) {
        if (n < 0) {
            double ans = pow(x, -n);
            return 1 / ans;
        }

        return pow(x, n);
    }
}
