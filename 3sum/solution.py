def threeSum(nums: list[int]) -> list[list[int]]:
    nums.sort()
    triplets = []

    for i in range(len(nums) - 1):
        if nums[i] > 0:
            break  # Early termination if the target is positive


        if i > 0 and nums[i] == nums[i - 1]:
            continue #skip duplicates
        
        left, right = i + 1, len(nums) - 1 #two pointers

        while left < right:
            total = nums[right] + nums[left] + nums[i]
            if total == 0:
                triplets.append([nums[i], nums[left], nums[right]])
                while left < right and nums[left] == nums[left + 1]:
                    left +=1 #skip duplicates
                while left < right and nums[right] == nums[right -1]:
                    right -= 1 #skip duplicates
                right -=1
                left += 1  
            elif total > 0:
                right -=1
            else :
                left += 1

    return triplets

if __name__ == "__main__":
    print(threeSum([-1, 0, 1, 2, -1, -4]))
    