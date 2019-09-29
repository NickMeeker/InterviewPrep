/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null)
      return "";
    List<String> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    HashSet<TreeNode> visited = new HashSet<>();

    queue.add(root);
    while (!queue.isEmpty()) {
      root = queue.poll();

      if (root == null) {
        list.add("n");
        continue;
      }

      list.add(Integer.toString(root.val));

      // add left node
      queue.add(root.left);
      // add right node
      queue.add(root.right);
    }

    StringBuilder output = new StringBuilder();
    for (String s : list) {
      output.append(s);
      output.append(",");
    }

    if (output.length() != 0) {
      output.delete(output.length() - 1, output.length());
    }

    return output.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (data.length() == 0)
      return null;
    String[] nodes = data.split(",");
    int i = 0;
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(Integer.parseInt(nodes[i]));
    TreeNode actualRoot = root;
    queue.add(root);
    while (i < nodes.length && !queue.isEmpty()) {
      root = queue.poll();

      // left
      if (!nodes[++i].equals("n")) {
        TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
        queue.add(left);
        root.left = left;
      } else {
        root.left = null;
      }

      // right
      if (!nodes[++i].equals("n")) {
        TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
        queue.add(right);
        root.right = right;
      } else {
        root.right = null;
      }
    }
    return actualRoot;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));