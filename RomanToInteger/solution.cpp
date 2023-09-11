#include <iostream>
#include <unordered_map>

using namespace std;

class Solution
{
public:
    int romanToInt(string s)
    {
        unordered_map<char, int> vals = {
            {'I', 1},
            {'V', 5},
            {'X', 10},
            {'L', 50},
            {'C', 100},
            {'D', 500},
            {'M', 1000}};

        int lastVal = 0;
        int intVal = 0;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if (vals[s[i]] >= lastVal)
            {
                intVal += vals[s[i]];
            }
            else
            {
                intVal -= vals[s[i]];
            }
            lastVal = vals[s[i]];
        }

        return intVal;
    }
};

int main()
{
    Solution solution;
    cout << solution.romanToInt("MCMXCIV") << endl;
    return 0;
}