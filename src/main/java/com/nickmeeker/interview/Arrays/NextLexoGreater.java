class Solution {
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // 1) scan from the right, check that the ith number < i+1 number
        while (i >= 0 && nums[i + 1] <= nums[i])
            i--;

        // 2) put next larger in a[i-1]
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
}