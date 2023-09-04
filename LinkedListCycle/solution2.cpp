#include <iostream>
#include <unordered_set>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

// This way time complexity is o(n) and space complexity is o(1) 
class Solution
{
public:
    bool hasCycle(ListNode *head)
    {
        ListNode* slow = head, *fast = head;  
        while (fast != nullptr && fast -> next != nullptr)
        {
            slow = slow -> next;
            fast = fast -> next -> next;
            if(slow == fast){
                return true;
            }
        }

        return false;
    }
};

int main(){
    Solution solution;
    cout << solution.hasCycle(new ListNode(4)) << endl;

    return 0;
}