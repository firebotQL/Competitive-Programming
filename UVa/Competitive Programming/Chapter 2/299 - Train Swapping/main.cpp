#include <cstdio>
#include <vector>
#include <algorithm>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

const char* result = "Optimal train swapping takes %d swaps.\n" ;

inline int count_swappings(std::vector<int>& train)
{
	bool bSort = true;
	int iCount(0);
	int i, t_length(train.size());
	
	while(bSort)
	{
		bSort = false;
		for(i = 0; i < t_length-1; ++i)
		{
			if (train[i] > train[i+1])
			{
				bSort = true;
				std::swap(train[i], train[i+1]);
				iCount++;
			}
		}
	}
	
	return iCount;
}

int main(int argv, char* argc[])
{
	openFile();
	int N, L, z;
	scanf("%d\n", &N);
	std::vector<int> train;
	char dummy[10];
	bool bSort;
	while(N--)
	{
		train.clear();
		scanf("%d", &L);
		while(L-- && scanf("%d", &z))
			train.push_back(z);

		printf(result, count_swappings(train));
	}
	return 0;
}
