#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int n, int k, vector<int> enemy) {
    priority_queue<int> pq;
    
    if (k>=enemy.size()) return enemy.size();
    int answer = 0;
    for (int nxt : enemy)
    {
        pq.push(nxt);
        if (n>=nxt)
        {
            n-=nxt;
            answer++;
        }
        else
        {
            if (k)
            {
                k--;
                n += pq.top();
                pq.pop();
                n-=nxt;
                answer++;
            }
            else return answer;
        }
    }
    
    return answer;
}
