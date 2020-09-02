


public class Test3 {

    class Node{
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class ListNode {
        public Node head;

        public ListNode() {
            this.head = null;
        }

        public ListNode partition(ListNode head, int x) {
                ListNode bs = null;
                ListNode be = null;
                ListNode as = null;
                ListNode ae = null;
                ListNode cur = head;
                while (cur != null) {
                    if (cur.data < x) {
                        if (bs == null) {
                            bs = cur;
                            be = bs;
                        } else {
                            be.next = cur;
                            be = be.next;
                        }
                    } else {
                        if (as == null) {
                            as = cur;
                            ae = as;
                        } else {
                            ae.next = cur;
                            ae = ae.next;
                        }
                    }
                    cur = cur.next;
                }
                if (bs == null) {
                    return as;
                }
                be.next = as;
                if (as != null) {
                    ae.next = null;
                }
                return bs;
        }
    }

}
