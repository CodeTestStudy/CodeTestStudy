#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string t, string p)
{
    int answer = 0;

    int lent = t.length();
    int lenp = p.length();

    for (int i = 0; i <= lent - lenp; i++)
    {
        if (t[i] > p[0])
            continue;

        int flag = 1;
        for (int j = 0; j < lenp; j++)
        {
            if (t[i + j] > p[j])
            {
                flag = 0;
                break;
            }
            if (t[i + j] < p[j])
                break;
        }
        if (flag)
            answer++;
    }

    return answer;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string t;
    string p;
    cin >> t >> p;
    cout << solution(t, p) << '\n';

    return 0;
}
