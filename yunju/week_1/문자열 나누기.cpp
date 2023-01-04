#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = 0;
    int sm = 0;
    int df = 0;
    
    char slt = s[0];
    for (int i = 0 ; i< s.length(); i++)
    {
        char c = s[i];
        if (c == slt) sm++;
        else df++;
        
        if (sm == df)
        {
            answer++;
            sm = 0; 
            df = 0;
            slt = s[i+1];
        }
        else if (i == s.length()-1) answer++;
    }
    
    return answer;
}
