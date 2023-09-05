def isPalindrome(x: int) -> bool:
    num = [char for char in str(x)]
    left = 0
    right = len(num) - 1
    while left < right:
        temp = num[left]
        num[left] = num[right]
        num[right] = temp
        left += 1
        right -= 1
    
    reversed = ''.join(num)
    if str(x) == reversed:
        return True
    return False

if __name__ == "__main__":
    res = isPalindrome(121)
    print(res)        