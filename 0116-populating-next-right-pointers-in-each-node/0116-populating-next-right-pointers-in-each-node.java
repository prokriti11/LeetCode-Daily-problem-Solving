
class Solution {
    public Node connect(Node root) {
        Node dummy = new Node(-1);
        Node curr = root, temp = dummy;

        while(curr != null){
            if(curr.left != null){
                temp.next = curr.left;
                temp = temp.next;
            }
            if(curr.right != null){
                temp.next = curr.right;
                temp = temp.next;
            }
            curr = curr.next;
            if(curr == null){
                curr = dummy.next;
                dummy.next = null;
                temp = dummy;
            }
        }

        return root;
    }
}