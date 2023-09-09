#include <iostream>
#include <cmath>
using namespace std;

// Time complexity O(log10(n))
class Solution{
public:
    bool isPlaindromeNumber(int x){
        int original = x;
        if (x < 0){
            return false;
        }

        int temp = 0;
        while(x > 0){
            temp = (10 * temp) + (x%10);
            x /= 10;
        }

        return temp == original;
    }
};

int main(){
    Solution Solution;
    cout << (Solution.isPlaindromeNumber(8) ? "true" : "false") << endl;
    return 0;

}