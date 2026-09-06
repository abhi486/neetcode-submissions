class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l = 0;
        int r = n;
        boolean isOdd = (n + m) % 2 == 1;

        while (l <= r) {
            int mid1 = l + (r - l) / 2;
            int mid2 = (n + m + 1) / 2 - mid1;

            int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int r1 = mid1 == n ? Integer.MAX_VALUE : nums1[mid1];

            int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r2 = mid2 == m ? Integer.MAX_VALUE : nums2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                if (isOdd) {
                    return Math.max(l1, l2);
                }
                else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }
            else if (l2 > r1) {
                l = mid1 + 1;
            }
            else {
                r = mid1 - 1;
            }
        }

        return 0;
    }
}
