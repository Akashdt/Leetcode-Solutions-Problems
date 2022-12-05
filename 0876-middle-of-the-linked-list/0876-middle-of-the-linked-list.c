/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* middleNode(struct ListNode* head){
 struct ListNode* fast_ptr = head;
    struct ListNode* slow_ptr = head;
    
    while (fast_ptr!=NULL && fast_ptr->next!=NULL) {
        fast_ptr = fast_ptr->next->next;
        slow_ptr = slow_ptr->next;
    }
    
        return slow_ptr;
}