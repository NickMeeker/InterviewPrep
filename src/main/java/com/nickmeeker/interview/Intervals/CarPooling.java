/*
    [1,5]
    [3,7]
    
    
    1) sort trips by start
    2) priorityqueue for the end of the trip
    
    iterate over start of trips
        add people for this trip
        check if t.start < pq.peek()
            if it is, then i can "end" that trip by subtracting its people from capacity
            
        check if current cap > cap
        

*/

class Solution {
  static class Trip {
    int people;
    int start;
    int end;

    Trip(int people, int start, int end) {
      this.people = people;
      this.start = start;
      this.end = end;
    }

    public static final Comparator<Trip> compareStart = new Comparator<Trip>() {
      @Override
      public int compare(Trip t1, Trip t2) {
        return t1.start - t2.start;
      }
    };

    public static final Comparator<Trip> compareEnd = new Comparator<Trip>() {
      @Override
      public int compare(Trip t1, Trip t2) {
        return t1.end - t2.end;
      }
    };
  }

  public boolean carPooling(int[][] trips, int capacity) {
    List<Trip> list = new ArrayList<>();
    PriorityQueue<Trip> pq = new PriorityQueue<>(5, Trip.compareEnd);
    int capSoFar = 0;
    for (int[] t : trips) {
      list.add(new Trip(t[0], t[1], t[2]));
    }

    Collections.sort(list, Trip.compareStart);

    capSoFar += list.get(0).people;
    pq.add(list.get(0));
    for (int i = 1; i < list.size(); i++) {
      Trip thisTrip = list.get(i);
      capSoFar += thisTrip.people;
      while (!pq.isEmpty() && thisTrip.start >= pq.peek().end) {
        capSoFar -= pq.poll().people;
      }

      if (capSoFar > capacity)
        return false;
      pq.add(thisTrip);
    }

    return capSoFar <= capacity;
  }
}