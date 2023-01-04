#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int clmn;

bool comp(const vector<int> & v, const vector<int>& vv)
{
    if (v[clmn] == vv[clmn])
    {
        return v[0]>vv[0];
    }
    return v[clmn]<vv[clmn];
}

int solution(vector<vector<int>> data, int col, int row_begin, int row_end) {
    int answer = 0;
    
    clmn = col-1;
    sort(data.begin(), data.end(), comp);
    for (int i = row_begin; i<=row_end; i++)
    {
        int ret = 0;
        for (int j = 0 ; j <data[0].size();j++)
        {
            ret+=(data[i-1][j]%i);
        }
        answer ^= ret;
    }
    
    return answer;
}
