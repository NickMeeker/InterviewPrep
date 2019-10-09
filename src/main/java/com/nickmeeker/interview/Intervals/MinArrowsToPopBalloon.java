/*
    sort by endpoint 
        iterate over the points, 
            if current start fits inside prev end, count ++, else make prev current and count++ 

*/


class Solution {
  static class Balloon implements Comparable<Balloon> {
      int start;
      int end;
      
      Balloon(int start, int end) {
          this.start = start;
          this.end = end;
      }
      
      @Override
      public int compareTo(Balloon b) {
          return this.end - b.end;
      }
  }
  
  
  public int findMinArrowShots(int[][] points) {
      if(points.length == 0) return 0;
      List<Balloon> balloons = new ArrayList<>();
      for(int[] balloon : points)
          balloons.add(new Balloon(balloon[0], balloon[1]));
      
      Collections.sort(balloons);
      int count = 1;
      int prev = 0;
      for(int i = 0; i < balloons.size(); i++) {
          if(balloons.get(i).start <= balloons.get(prev).end) {
              continue;
          } else {
              count++;
              prev = i;
          }
      }
      return count;
  }
}