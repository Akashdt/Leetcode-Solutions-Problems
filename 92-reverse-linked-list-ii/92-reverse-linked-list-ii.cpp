/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int left, int right) {
          
        if(left == right){
            return head;
        }
		
        ListNode *start = nullptr, *end = nullptr, *temp = head;;
        
        for(int i=1;i<=right;i++){
            
            if(i == left-1){
                start = temp;
            }
            
            temp = temp->next;
        }
        
        end = temp;
        ListNode *prev = end,*curr = nullptr, *nxt = nullptr;
        
        if(start == nullptr){
            curr = head;
        }else{
            curr = start->next;
        }
        
        nxt = curr->next;

        for(int i=0;i<=right-left;i++){
            curr->next = prev;
            prev = curr;
            curr = nxt;
            
            if(nxt == nullptr){
                break;
            }else{
                nxt = nxt->next;
            }
        }
        
        if(start == nullptr){
            head = prev;
        }else{
            start->next = prev;
        }
        
        return head;
    }
};