#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(std::vector<int>& nums, int target) {
        unordered_map<int, int> hash_map;

        for (int i = 0; i < nums.size(); i++){
            int complement = target - nums[i];

            if(hash_map.find(complement) != hash_map.end()){
                return {hash_map[complement] , i};
            }
            
            hash_map[nums[i]] = i;
        }

        return {};
    }
};

int main() {
    Solution solution;
    std::vector<int> nums = {2, 7, 11, 15}; // Replace with your input nums
    int target = 18; // Replace with your target sum

    std::vector<int> result = solution.twoSum(nums, target);

    if (result.size() == 2) {
        std::cout << "Indices: " << result[0] << ", " << result[1] << std::endl;
        std::cout << "Values: " << nums[result[0]] << ", " << nums[result[1]] << std::endl;
    } else {
        std::cout << "No solution found." << std::endl;
    }

    return 0;
}

