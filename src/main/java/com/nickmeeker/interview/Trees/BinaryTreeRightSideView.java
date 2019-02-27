/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
       1            <---
     /   \
    2     3         <---
   /      
  6               <---
      
    BFS the tree, and store levels in arraylist
        (1)
        (2,3)
        (5,4)
        return last element in each arraylist
*/

class Solution {
  List<List<Integer>> layers;
  public List<Integer> rightSideView(TreeNode root) {
      if(root == null) return new ArrayList<>();
      List<Integer> output = new ArrayList<>();
      layers = new ArrayList<>();
      bfs(root);
      for(List<Integer> layer : layers) {
          output.add(layer.get(layer.size() - 1));
      }
      return output;
  }
  
  void bfs(TreeNode root) {
      Queue<TreeNode> queue = new LinkedList<>();
      HashMap<TreeNode, Integer> map = new HashMap<>();
      //HashSet<TreeNode> visited = new HashSet<>();
      int currentLayer = 0, previousLayer = -1;
      
      queue.add(root);
      map.put(root, currentLayer);
      
      while(!queue.isEmpty()) {
          root = queue.poll();
          //visited.add(root);
          currentLayer = map.get(root);
          if(currentLayer != previousLayer) {
              previousLayer = currentLayer;
              layers.add(new ArrayList<>());
          }
          layers.get(currentLayer).add(root.val);
          // go left
          if(root.left != null) {
              queue.add(root.left);
              map.put(root.left, currentLayer + 1);
          }
          // go right
          if(root.right != null) {
              queue.add(root.right);
              map.put(root.right, currentLayer + 1);
          }
      }
  }
}