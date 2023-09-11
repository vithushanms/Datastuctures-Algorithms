def romanToInt(s: str) -> int:
    vals = { 
        "I": 1,
        "V": 5,
        "X": 10,
        "L": 50,
        "C": 100,
        "D": 500,
        "M": 1000
    }
    
    right = len(s) - 1
    intVal = 0
    last = 0
    for i in range(len(s)):
        if(vals[s[right]] >= last):
            intVal += vals[s[right]]
        else:
            intVal -= vals[s[right]]
            
        last = vals[s[right]]
        right -= 1

    return intVal

if __name__ == "__main__":
    print(romanToInt("MCMXCIV"))