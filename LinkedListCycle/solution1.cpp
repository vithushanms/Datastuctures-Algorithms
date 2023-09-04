#include <iostream>
#include <unordered_set>
using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
};

// This way time complexity is o(n) and space complexity is o(n) 
class Solution
{
public:
    bool hasCycle(ListNode *head)
    {
        ListNode *current = head;
        unordered_set<ListNode *> path;

        while (current != nullptr)
        {
            if (path.count(current))
            {
                return true;
            }

            path.insert(current);
            current = current->next;
        }

        return false;
    }
};

int main(){
    Solution solution;
    cout << solution.hasCycle(new ListNode(4)) << endl;

    return 0;
} 