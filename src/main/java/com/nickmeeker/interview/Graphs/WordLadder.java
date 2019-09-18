/*
    this is a graph theory problem
    
    if a word is one letter different from another word, then an edge between them exists
*/

class Solution {
  static class Node {
    public int index;
    public String word;
    public List<Node> adj;

    public Node(int index, String word) {
      this.index = index;
      this.word = word;
      this.adj = new ArrayList<Node>();
    }
  }

  private boolean canTransform(String w1, String w2) {
    int num_dif = 0;
    for (int i = 0; i < w1.length(); i++) {
      if (w1.charAt(i) != w2.charAt(i))
        num_dif++;
    }

    return num_dif == 1;
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    List<Node> nodes = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    HashSet<Node> visited = new HashSet<>();
    HashMap<Node, Node> prev = new HashMap<>();

    int n = wordList.size();
    for (int i = 0; i < n; i++) {
      nodes.add(new Node(i, wordList.get(i)));
    }

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        // check for a path
        if (canTransform(wordList.get(i), wordList.get(j))) {
          nodes.get(i).adj.add(nodes.get(j));
          nodes.get(j).adj.add(nodes.get(i));
        }
      }
    }

    // add the beginning word
    nodes.add(new Node(nodes.size(), beginWord));
    for (int i = 0; i < n; i++) {
      if (canTransform(wordList.get(i), beginWord)) {
        nodes.get(i).adj.add(nodes.get(nodes.size() - 1));
        nodes.get(nodes.size() - 1).adj.add(nodes.get(i));
      }
    }

    Node s = nodes.get(nodes.size() - 1);
    queue.add(s);
    visited.add(s);
    boolean answer = false;
    while (!queue.isEmpty()) {
      s = queue.poll();
      if (s.word.equals(endWord)) {
        answer = true;
        break;
      }
      for (Node t : s.adj) {
        if (!visited.contains(t)) {
          visited.add(t);
          prev.put(t, s);
          queue.add(t);
        }
      }
    }
    if (!answer)
      return 0;

    String string = endWord;
    Node current = s;
    int count = 0;

    while (!string.equals(beginWord)) {
      count++;
      current = prev.get(current);
      string = current.word;
    }
    return ++count;
  }
}