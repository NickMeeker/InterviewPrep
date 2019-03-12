/*
    if dne --> -1
    
    a / b = 2.0, b / c = 3.0
    
    a / c = ?,
    b / a = ?, 
    a / e = ?,
    a / a = ?, 
    x / x = ? 
    
    [6.0, 0.5, -1.0, 1.0, -1.0 ]
    
    a -> 2.0 -> b
    b -> 1/2 -> a
    
    b -> 3.0 -> c
    c -> 1/3 -> b
    
    
    path from a to c
    a -> b -> c
    a->b: 2.0
    b->c: 3.0
    multiplying: 3.0
    
    b -> a 2.0 -> 2.0
    
    a / e -> -1
    a/a -> 1.0
    x / x -> -1
    
    
    1) build graph using values as weights
    2) for each query:
        find a path from source to destination, multiplying by the weight at each interval
        if source or destination dne, then just immediately -1
        if source == destination, then just immediately 1
    
    
*/

class Solution {
  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
      int indexInGraph = 0;
      /**
       * Using a double object since any real number is a possible weight between nodes.
       * We're using null as the flag to indicate that there's no edge.
       */
      Double[][] graph;
      double[] output = new double[queries.length];
      /**
       * Mapping each string to its index in the graph
       */
      HashMap<String, Integer> map = new HashMap<>();
      for(int i = 0; i < equations.length; i++) {
          for(int j = 0; j < equations[i].length; j++) {
              if(!map.containsKey(equations[i][j])) {
                  map.put(equations[i][j], indexInGraph);
                  indexInGraph++;
              }
          }
      }
      graph = new Double[map.size()][map.size()];
      for(int i = 0; i < equations.length; i++) {
          graph[map.get(equations[i][0])][map.get(equations[i][1])] = values[i];
          // division by 0 means no path
          if(values[i] != 0)
              graph[map.get(equations[i][1])][map.get(equations[i][0])] = (1.0/values[i]);
      }
      
      for(int i = 0; i < queries.length; i++) {
          String numerator = queries[i][0];
          String denominator = queries[i][1];
          // Go!
          output[i] = getPathValue(graph, map, numerator, denominator);
         
      }
      return output;
  }
  
  public double getPathValue(Double[][] graph, HashMap<String, Integer> map, 
                              String numerator, String denominator) {
      /*
          BFS source -> destination
              to get path
          run over path, keeping a running product
          return the running product
      */
      Queue<Integer> queue = new LinkedList<>();
      HashSet<Integer> visited = new HashSet<>();
      HashMap<Integer, Integer> path = new HashMap<>();
      /**
       * Numbers not in the set. Can't operate on these.
       */
      if(!map.containsKey(numerator) || !map.containsKey(denominator)) {
          return -1.0;
      }
      int source = map.get(numerator);
      int target = map.get(denominator);
      // First edge case: division of a number by itself is always 1
      if(source == target)
          return 1.0;
      double runningProduct = 1;
      queue.add(source);

      // Start the BFS!
      while(!queue.isEmpty()) {
          int s = queue.poll();
          visited.add(s);
          for(int i = 0; i < graph.length; i++) {
              // if we haven't visited and there is a path
              if(!visited.contains(i) && graph[s][i] != null) {
                  // map the path to the target index from the current index
                  path.put(i, s);
                  queue.add(i);
              }
          }
      }
      
      // there is no path
      if(!path.containsKey(target)) 
          return -1.0;
      
      // step back through the path we found and multiply to the running product
      while(target != source) {
          int prev = path.get(target);
          runningProduct *= graph[prev][target];
          target = prev;
      }

      // done!
      return runningProduct;
  }
}