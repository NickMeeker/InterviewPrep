class Solution {
  static class Interval implements Comparable<Interval> {
    int s;
    int e;

    Interval(int s, int e) {
      this.s = s;
      this.e = e;
    }

    @Override
    public int compareTo(Interval a) {
      return this.e - a.e;
    }
  }

  public int eraseOverlapIntervals(int[][] intervals) {
    List<Interval> list = new ArrayList<>();

    for (int[] i : intervals)
      list.add(new Interval(i[0], i[1]));

    Collections.sort(list);

    int count = 0;
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i).s < list.get(i - 1).e) {
        list.remove(i--);
        count++;
      }
    }
    return count;
  }
}