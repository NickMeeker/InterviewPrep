class Solution {
  static class MeetingTime implements Comparable<MeetingTime> {
    int s;
    int e;

    MeetingTime(int s, int e) {
      this.s = s;
      this.e = e;
    }

    @Override
    public int compareTo(MeetingTime b) {
      return this.s - b.s;
    }
  }

  public int minMeetingRooms(int[][] intervals) {
    if (intervals.length == 0)
      return 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>(5);
    List<MeetingTime> times = new ArrayList<>();
    for (int[] t : intervals) {
      MeetingTime mt = new MeetingTime(t[0], t[1]);
      times.add(mt);
    }
    Collections.sort(times);
    queue.add(times.get(0).e);
    for (int i = 1; i < times.size(); i++) {
      if (times.get(i).s >= queue.peek())
        queue.poll();
      queue.add(times.get(i).e);
    }
    return queue.size();
  }
}