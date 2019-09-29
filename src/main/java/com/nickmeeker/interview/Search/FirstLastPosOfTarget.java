/*
    need to binary search in two directions once i've found the target
    
    left searchf -> 

*/

class Solution {
  public int[] searchRange(int[] nums, int target) {
    int[] answer = new int[2];
    int n = nums.length;
    int start = 0, end = n;
    int index = -1;

    // find a single instance of the target
    while (start != end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        index = mid;
        break;
      }

      if (nums[mid] < target) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }
    // did not find
    if (index == -1) {
      answer[0] = -1;
      answer[1] = -1;
      return answer;
    }

    // find the leftmost instance of the target
    start = 0;
    end = index;
    while (start != end) {
      int mid = start + (end - start) / 2;

      if (nums[mid] == target) {
        end = mid;
        continue;
      } else {
        start = mid + 1;
      }
    }

    answer[0] = start;
    // find rightmost instance
    start = index;
    end = n;
    while (start < end) {
      int mid = (start + end) / 2;

      if (nums[mid] > target) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }

    answer[1] = end - 1;
    return answer;

  }
}