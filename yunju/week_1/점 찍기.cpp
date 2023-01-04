#include <string>
#include <vector>
#include <cmath>

using namespace std;

long long solution(int k, int d) {
    long long answer = 0;
    for (int i = 0 ;;i++)
    {
        long long a = i*k;
        if (a>d) break;
        long long b = sqrtl((long long)d*d-a*a);
        b/=k;
        b++;
        answer+=b;
    }
    return answer;
}
