#include <iostream>
#include <unordered_map>
#include <string>
#include <vector>

using namespace std;

unordered_map<char,int> m;
vector<int> v;

vector<int> solution(string a)
{
    vector<int> ans;
    for (int i = 0 ; i<a.length();i++)
    {
        char k = a[i];
        if (m.find(k) == m.end())
        {
            ans.push_back(-1);
            m.insert({k,i});
        }
        else
        {
            ans.push_back(i-m[k]);
            m[k]=i;
        }
    }
    
    return ans;
}
