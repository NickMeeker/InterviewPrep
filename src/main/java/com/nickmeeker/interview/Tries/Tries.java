public class Tries {

  /**
   * Every node in the trie has an array representing its children (the suffix to that particular node)
   * and a count, indicating how many words end at that particular node.
   */
  static class Node {
      private Node[] children;
      private int count;
      public Node() {
          this.children = new Node[26];
          this.count = 0;
      }

      /**
       * Insertion function. 
       * 
       * Create a node at the index of the first letter in the word, then remove the first letter
       * and recurse "into" the node at that index.
       */
      public void insert(String word) {
          if(word.length() == 0) {
              this.incrementCount();
              return;
          }
          char firstLetter = word.charAt(0);
          int index = this.letterToIndex(firstLetter);
          if(this.children[index] == null) {
              this.children[index] = new Node();
          }

          word = this.removeFirstLetter(word);
          this.children[index].insert(word);
      }

      /**
       * Find function.
       * 
       * Similar to insert, except we're not creating the node.
       */
      public boolean find(String word) {
          if(word.length() == 0)
              return true;

          char firstLetter = word.charAt(0);
          int index = this.letterToIndex(firstLetter);
          if(this.children[index] == null)
              return false;

          word = this.removeFirstLetter(word);
          return this.children[index].find(word);
      }

      /**
       * Prints the entire trie, indicating where the words are.
       */
      public void printTrie(String wordSoFar, int index) {
          char letter = this.indexToLetter(index);
          if(index != -1) {
              wordSoFar += letter;
              System.out.print(wordSoFar);
              if (this.count > 0)
                  System.out.println("(word)");
              else
                  System.out.println();
          }

          for(int i = 0; i < 26; i++) {
              if(this.children[i] != null)
                  this.children[i].printTrie(wordSoFar, i);
          }
      }

      public void incrementCount() {
          this.count++;
      }

      public void decrementCount() {
          this.count--;
      }

      public char indexToLetter(int index) {
          return (char)(index + 'a');
      }

      public int letterToIndex(char letter) {
          return (int)(letter - 'a');
      }

      public String removeFirstLetter(String word) {
          if(word.length() > 1)
              return word.substring(1);
          else
              return "";
      }
  }

  public static void main(String[] args) {
      Node head = new Node();
      head.insert("cats");
      head.insert("cat");
      head.insert("cars");
      head.insert("dogs");
      head.printTrie("",-1);
  }
}
