class Solution {
    void merge(int[] nums, int l, int mid, int r) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = l; i <= mid; i++) left.add(nums[i]);
        for (int j = mid + 1; j <= r; j++) right.add(nums[j]);

        int i = 0, j = 0, k = l;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                nums[k++] = left.get(i++);
            }
            else {
                nums[k++] = right.get(j++);
            }
        }

        while (i < left.size()) nums[k++] = left.get(i++);
        while (j < right.size()) nums[k++] = right.get(j++);
    }
    void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}