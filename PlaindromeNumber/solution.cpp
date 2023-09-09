#include <iostream>
#include <cstring>
#include <sstream>
using namespace std;

// Time complexity O(n)
class Solution {
public:
    bool isPalindrome(int x) {
        string x_str = to_string(x);
        int left = 0, right = x_str.length() - 1; 
        while (left < right) {
            char temp = x_str[left];
            x_str[left] = x_str[right];
            x_str[right] = temp;
            left++;
            right--;
        }

        string original = to_string(x);
        for (int i = 0; i < x_str.length(); i++) {
            if (x_str[i] != original[i]) {
                return false;
            }
        }

        return true;
    }
};

int main(){
    Solution Solution;
    cout << (Solution.isPalindrome(121) ? "true" : "false") << endl;
    return 0;
}