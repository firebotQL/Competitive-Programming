#include <cstdio>
#include <algorithm>
#include <map>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
	freopen("test.out", "w", stdout);
#endif
}

void counting_output(std::map<int, long long>& sequence)
{
	char i;
	long long j;
	for(i = 0; i < sequence.size(); ++i)
		for(j = 0; j < sequence[i]; ++j)
		{
			if (sequence[i] > 0)
			{
				printf("%d", i);
				if (i+1 == sequence.size() && j+1 == sequence[i])
					continue;
				printf(" ");
			}			
		}
}


int main(int argv,char* argc[])
{
	openFile();
	int n, e;	
	std::map<int, long long> sequence;
	while(scanf("%d", &n) && n > 0)
	{
		sequence.clear();
		while(n--)
		{
			scanf("%i", &e);
			sequence[e]++;
		}
		
		counting_output(sequence);
		printf("\n");
	}
	return 0;
}