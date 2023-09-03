#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> triplets;

        for (int i=0; i < nums.size() - 1; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int left = i + 1, right = nums.size() - 1;
            while (right > left) {
                int total = nums[i] + nums[left] + nums[right];

                if(total == 0){
                    triplets.push_back({nums[i], nums[left], nums[right]});
                    while (left < right && nums[left] == nums[left + 1]){
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right -= 1;
                    }
                    right-=1;
                    left+=1;
                } else if (total > 0) {
                    right -=1;
                } else {
                    left +=1;
                }
            }
        }
        return triplets;
    }
};

int main(){
    Solution solution;

    vector<int> nums = {-1,0,1,2,-1,-4};
    vector<vector<int>> result = solution.threeSum(nums);
    cout << "[";
    for (int i = 0; i < result.size(); i++){
        cout << "[";
        for (int j = 0; j < result[i].size(); j++){
            cout << result[i][j] << ", ";
        }
        cout << "],";
    }
    cout << "]" << endl;
}