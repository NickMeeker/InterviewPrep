/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/*
    could linear search for o(n) time, but a binary search will be faster
    
*/
public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    int start = 0, end = n;
    while (start != end) {
      int mid = start + (end - start) / 2;
      if (isBadVersion(mid)) {
        end = mid;
      } else
        start = mid + 1;
    }

    return start;
  }
}