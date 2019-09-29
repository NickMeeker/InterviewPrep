class Solution {
  static class Point implements Comparable<Point> {
    int x;
    int y;
    int d;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
      this.d = (0 - x) * (0 - x) + (0 - y) * (0 - y);
    }

    @Override
    public int compareTo(Point p) {
      return this.d - p.d;
    }
  }

  public int[][] kClosest(int[][] points, int K) {
    PriorityQueue<Point> q = new PriorityQueue<>();
    for (int[] point : points) {
      int x = point[0];
      int y = point[1];
      q.add(new Point(x, y));
    }

    int i = 0;
    int[][] answer = new int[K][2];
    while (i < K) {
      Point p = q.poll();
      answer[i][0] = p.x;
      answer[i][1] = p.y;
      i++;
    }
    return answer;
  }
}