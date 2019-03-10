import java.util.*;

class LinkedLists {
    static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
            this.next = null;
        }

        public Node tailInsert(int val) {
            Node temp = this;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(val);
            return this;
        }

        public Node headInsert(int val) {
            Node temp = new Node(val);
            temp.next = this;
            return temp;
        }

        public int size() {
            Node temp = this;
            int counter = 0;
            while(temp != null) {
                temp = temp.next;
                counter++;
            }
            return counter;
        }

        public int get(int index) {
            if(index < 0)
                return -1;
            int i = 0;
            Node temp = this;
            while(i < index && temp != null) {
                temp = temp.next;
                i++;
            }
            if(temp == null)
                return -1;
            else
                return temp.val;
        }

        public Node remove(int val) {
            Node temp = new Node(-1), dummyHead = temp;
            temp.next = this;
            while(temp.next != null) {
                if(temp.next.val == val) {
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
            return dummyHead.next;
        }

        public Node insertIndex(int val, int index) {
            if(index < 0 || index > this.size() - 1)
                return this;
            int i = 0;
            Node temp = this;
            while(i < index-1 && temp != null) {
                temp = temp.next;
                i++;
            }
            Node newNext = temp.next;
            temp.next = new Node(val);
            temp.next.next = newNext;
            return this;
        }

        public Node removeIndex(int index) {
            if(index < 0 || index > this.size() - 1)
                return this;
            int i = 0;
            Node temp = this;
            while(i < index-1 && temp != null) {
                temp = temp.next;
                i++;
            }
            temp.next = temp.next.next;
            return this;
        }

        public Node reverse() {
            Node current = this, prev = null, next;
            while(current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
        }
        public void printList() {
            Node temp = this;
            while(temp != null) {
                System.out.print(temp.val+"->");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }





    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = "";
        int val = -1;
        Node head = new Node(-1);
        do {
            System.out.println("Linked List Practice\n");
            System.out.println("Print: Print List");
            System.out.println("Init: Initialize List");
            System.out.println("TailInsert: Tail Insert");
            System.out.println("HeadInsert: Head Insert");
            System.out.println("Size: Size");
            System.out.println("Get: Get");
            System.out.println("Remove: Remove");
            System.out.println("InsertIndex: Insert at Index");
            System.out.println("RemoveIndex: Remove at Index");
            System.out.println("Reverse: Reverse List");
            System.out.println("Exit: Exit");

            input = scan.nextLine();
            for(int clear = 0; clear < 50; clear++) {
                System.out.println("\b") ;
            }
            if(input.equals("Print")) {
                head.printList();
            } else if (input.equals("Init")){
                System.out.println("Val: ");
                val = scan.nextInt();
                scan.nextLine();
                head = new Node(val);
            }else if(input.equals("TailInsert")) {
                System.out.print("Val: ");
                val = scan.nextInt();
                scan.nextLine();
                head = head.tailInsert(val);
            } else if(input.equals("HeadInsert")) {
                System.out.print("Val: ");
                val = scan.nextInt();
                scan.nextLine();
                head = head.headInsert(val);
            } else if(input.equals("Size")) {
                System.out.println(head.size());
            } else if(input.equals("Get")) {
                System.out.print("Index: ");
                val = scan.nextInt();
                scan.nextLine();
                System.out.println(head.get(val));
            } else if(input.equals("Remove")) {
                System.out.print("Val: ");
                val = scan.nextInt();
                scan.nextLine();
                head = head.remove(val);
            } else if(input.equals("InsertIndex")) {
                System.out.print("Val: ");
                val = scan.nextInt();
                System.out.println();
                System.out.print("Index: ");
                int index = scan.nextInt();
                scan.nextLine();
                head = head.insertIndex(val, index);
            } else if(input.equals("RemoveIndex")) {
                System.out.print("Index: ");
                val = scan.nextInt();
                scan.nextLine();
                head = head.removeIndex(val);
            }else if(input.equals("Reverse")) {
                head = head.reverse();
            }
        } while(!input.equals("Exit"));





    }
}