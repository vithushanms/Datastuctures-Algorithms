class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hash_map = {}

        for i in range(len(nums)):
            compliment = target - nums[i]

            if(compliment in hash_map):
                return {hash_map[compliment], i}

            hash_map[nums[i]] = i

        return {}