#include <cstdio>
#include <cstdlib>
#include <stack>
#include <vector>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
		freopen("test.out", "w", stdout);
	#endif 
}

int main(int argc, char* argv[])
{
	std::stack<int> station;
	std::vector<int> A, B;
	int N, i, j, offset, z, x;
	openFile();
	char line[10000];
	char* data;
	bool move, notFirst(false);
	while(scanf("%d\n", &N))
	{
		if (notFirst)
			printf("\n");
		if (!N)
			break;
		notFirst = true;
		for(i = 1; i <= N; ++i)
			A.push_back(i);
		while(fgets(line, 10000, stdin) && line[0] != '0')
		{
			data = line;
			while(1 == sscanf(data, " %d%n", &j, &offset))
			{
				B.push_back(j);
				data += offset;
			}
			move = true;
			z = 0, x = 0;
			while(z != N && move)
			{
				// If index is in bounds
				// then if station is empty or 
				// station vagon is not equal B front vagon
				move = false;
				if (x != N && 
					(!station.size() || B[z] != station.top()))
				{
						station.push(A[x++]);
						move = true;
				}
				if (B[z] == station.top())
				{
					station.pop();	
					z++;
					move = true;
				}
			}	
			if (z == N)
				printf("Yes\n");
			else
				printf("No\n");		
		B.clear();
		while(station.size())
			station.pop();			
		}		
		
		A.clear();	
	}
	return 0;
}
