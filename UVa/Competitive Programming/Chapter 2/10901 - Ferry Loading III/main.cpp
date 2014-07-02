#include <cstdio>
#include <cstring>
#include <queue>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

const char default_side[] = "left";

void ferryCar(int time, int n, char* side, char* ferry_side,std::queue<int>& ferry)
{
	if (!strcmp(side, ferry_side))
	{
		if (ferry.size() < n)
		{
		}
	} 
	else
	{
		if (ferry.size() < n)
		{
		}
	}
}

int main(int argc,char* argv[])
{
	openFile();
	int c,n,t,m, time;
	scanf("%d\n", &c);
	std::queue<int> ferry;
	char side[7];
	char ferry_side[7];
	while(c--)
	{
		strcpy(ferry_side, default_side);
		scanf("%d %d %d\n", &n, &t, &m);
		while(m--)
		{
			scanf("%d %s\n", &time, side);
			printf("%d %s\n", time, side);
			ferryCar(time, side, ferry_side);
		}
	}
	return 0;
}
