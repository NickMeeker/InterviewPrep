/*
    We need a linked list to handle lru condition (a list where the first element is the 
    LRU -> ... -> MRU) and then a hashmap for the actual map. Just going to use a LinkedHashMap
        
*/


class LRUCache {
  int capacity;
  LinkedHashMap<Integer, Integer> map;
  public LRUCache(int capacity) {
      this.capacity = capacity;
      this.map = new LinkedHashMap<>();
  }
  
  public int get(int key) {
      // if the map contains the key, we need to update its place
      // in the lru list
      if(map.containsKey(key)) {
          int v = map.get(key);
          // remove it from whereever it is in the list -> O(1)
          map.remove(key);
          // put it so it's at the tail of the list
          map.put(key, v);
      }
      return map.getOrDefault(key, -1);
  }
  
  public void put(int key, int value) {
      // Two cases. first is that the key isn't already in the list
      if(!map.containsKey(key)) {
          // if we're at capacity, we have to start "popping off" lru elements
          while(map.size() > capacity - 1) {
              // just use a linkedhashmap iterator to do this.
              // make sure you're iterating over the keySet()
              Iterator it = map.keySet().iterator();
              it.next();
              it.remove();
          }
          // then just put the value. MRU will insert itself at the tail
          map.put(key, value);
      } 
      // the other case is that this is a new element
      else {
          // if it's already in the map, we have to remove it first
          // so we can reinsert it at the end 
          if(map.size() > 0){
              map.remove(key);
          }
          // then just insert it
          map.put(key, value);
      }
      
  }
}

/**
* Your LRUCache object will be instantiated and called as such:
* LRUCache obj = new LRUCache(capacity);
* int param_1 = obj.get(key);
* obj.put(key,value);
*/