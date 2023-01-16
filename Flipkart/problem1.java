class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next=head;
        
        ListNode cur = temp;
        HashMap<Integer,ListNode> hm = new HashMap<>();
        int ps=0;
        
        while(cur!=null){
            ps += cur.val;
            
            if(hm.containsKey(ps)){
                hm.get(ps).next = cur.next;
               hm.clear();
                cur=temp;
                ps = 0;
            }
            else{
                hm.put(ps,cur);
                cur = cur.next;
            }
        }
        return temp.next;
    }
}
