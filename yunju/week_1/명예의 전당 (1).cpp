#include <string>
#include <vector>
#include <set>

using namespace std;

multiset<int>s;

vector<int> solution(int k, vector<int> score) {
    vector<int> answer;
    for (int i = 0 ; i<score.size(); i++)
    {
        s.insert(score[i]);
        int sz = s.size();
        if (sz>k) s.erase(s.begin());
        answer.push_back(*s.begin());
    }
    return answer;
}
