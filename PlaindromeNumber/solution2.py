# time colplexity O(log10(n)) and space complexity O(1)
def isPalindrome(self, x: int) -> bool:
    if x < 0: 
        return False
    
    temp = 0
    initial = x
    while x > 0:
        temp = (temp * 10) + (x%10)
        x //= 10 

    del x #to save some memory
    return temp == initial