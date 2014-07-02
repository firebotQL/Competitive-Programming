#include <cstdio>
#include <iostream>
#include <vector>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

int main(int argc, char* argv[])
{
	openFile();
	std::vector<int> hartals, days;
	int T, N, P, i, j, h, iCount(0), step; 
	std::cin >> T;
	while(T--)
	{
		std::cin >> N >> P;
		for(j = 0; j < P; j++)
		{
			std::cin >> i;
			hartals.push_back(i);
		}
		iCount = 0;
		days.assign(N+1, 0);
		for(j = 0; j < P; ++j)
			for(i = 1; i <= N; ++i)
			{
				if(i % hartals[j] == 0 &&
					i % 7 != 6 &&
					i % 7 != 0)
				days[i]++;
			}
		for(i = 1; i <= N; ++i)
			if(days[i] > 0)
				iCount++;

		hartals.clear();
		std::cout << iCount << std::endl;
				
	}  
	return 0;
}
