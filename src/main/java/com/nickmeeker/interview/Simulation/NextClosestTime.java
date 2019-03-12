/*
    Can just simulate moving the clock forward.
*/

class Solution {
  public String nextClosestTime(String time) {
      String[] hhmm = time.split(":");
      HashSet<Integer> set = new HashSet<Integer>();
      for(int i = 0; i < hhmm[0].length(); i++) {
          set.add((int)hhmm[0].charAt(i)-'0');
      }
      for(int i = 0; i < hhmm[1].length(); i++) {
          set.add((int)hhmm[1].charAt(i)-'0');
      }
      int hh = Integer.parseInt(hhmm[0]);
      int mm = Integer.parseInt(hhmm[1]);
      mm++;
      while(true) {
          if(mm == 60) {
              mm = 0;
              hh++;
          }
          if(hh == 24)
              hh = 0;
          String hours = "";
          if(hh < 10)
              hours += "0";
          hours += hh;
          String minutes = "";
          if(mm < 10)
              minutes += "0";
          minutes += mm;
          boolean found = true;
          for(char c : hours.toCharArray())
              if(!set.contains((int)c-'0'))
                  found = false;
          
          for(char c : minutes.toCharArray())
              if(!set.contains((int)c-'0'))
                  found = false;
          
          if(found)
              return hours + ":" + minutes;
          mm++;
      }
  }
}