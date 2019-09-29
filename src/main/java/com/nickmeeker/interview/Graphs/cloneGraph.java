/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
  public Node cloneGraph(Node node) {
    Queue<Node> queue = new LinkedList<>();
    Set<Node> visited = new HashSet<>();

    HashMap<Node, Node> map = new HashMap<>();
    queue.add(node);
    visited.add(node);

    while (!queue.isEmpty()) {
      Node temp = queue.poll();
      map.put(temp, new Node(temp.val, new ArrayList<>()));

      for (Node neighbor : temp.neighbors) {
        if (!visited.contains(neighbor)) {
          visited.add(neighbor);
          queue.add(neighbor);
        }
      }
    }

    visited = new HashSet<>();
    queue.add(node);
    visited.add(node);

    while (!queue.isEmpty()) {
      Node temp = queue.poll();

      for (Node neighbor : temp.neighbors) {
        map.get(temp).neighbors.add(map.get(neighbor));
        if (!visited.contains(neighbor)) {
          visited.add(neighbor);
          queue.add(neighbor);
        }
      }
    }

    return map.get(node);
  }
}