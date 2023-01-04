#include <string>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

map<int,int>m;
bool cmp(const pair<int,int>& a, const pair<int,int>& b) {
	return a.second > b.second;
}

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    
    for (int t:tangerine)
    {
        if (m.find(t) == m.end())
        {
            m.insert({t,1});
        }
        else
        {
            m[t]++;
        }
    }
    
    vector<pair<int,int>> v(m.begin(),m.end());
    sort(v.begin(),v.end(),cmp);
    
    for (int i = 0 ; i<v.size(); i++)
    {
        if (k<=v[i].second)
        {
            answer++;
            break;
        }
        else 
        {
            answer++;
            k-=v[i].second;
        }
    }
    return answer;
}
