#include <cstdio>
#include <cmath>
#include <stack>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

int main(int argc, char* argv[])
{
	openFile();
	long long i;
	std::stack<long long> numbers;
	while(scanf("%lld", &i) != EOF)
		numbers.push(i);
	
	while(numbers.size())
	{
		printf("%.4lf\n", sqrt(double(numbers.top())));
		numbers.pop();
	}
	
	return 0;
}
