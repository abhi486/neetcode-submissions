class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int maj1 = 0;
        int count1 = 0;

        int maj2 = 0;
        int count2 = 0;

        for (int x : nums) {
            if (count1 == 0) {
                maj1 = x;
            }
            else if (count2 == 0) {
                maj2 = x;
            }

            if (maj1 == x) count1++;
            else if (maj2 == x) count2++;
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int x : nums) {
            if (maj1 == x) count1++;
            if (maj2 == x) count2++;
        }

        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        if (count1 > n / 3) list.add(maj1);
        if (maj1 != maj2 && count2 > n / 3) list.add(maj2);

        return list;
    }
}