import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        s.reverseBetween(listNode,2,4);
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null)return head;
        ListNode temp1 = head;
        ListNode temp2 = head;
        for(int i = 0;i < right;i++){
            temp1 = temp1.next;
        }

        for(int i = 0;i < left-2;i++){
            temp2 = temp2.next;
        }

        ListNode temp3 = temp2.next;
        int[] k = new int[500];
        int t = 0;
        for(int i = 0;i < right-left+1;i++){
            k[t++] = temp3.val;
            temp3 = temp3.next;
        }
        Arrays.sort(k,0,right-left+1);
        for(int i = 0;i < right - left+1;i++){
            temp2.next = new ListNode(k[i]);
        }
        temp2.next = temp1;
        return head;
    }
}