#include <cstdio>
#include <cstring>
#include <vector>
#include <set>
#include <map>

using namespace std;


int grid[101][101];
bool visited[101][101];    
int xStack[1000000];
int yStack[1000000];

int i, j;
    
int main()
{
	
	int T, W, R, C, M, N, caseNr = 1, even, odd, newX, newY, gridVal, stackPointer, tx, ty;
	scanf("%d", &T);
	set<pair<int, int> > inc;
	while(T-- != 0)
	{
		scanf("%d %d %d %d %d", &R, &C, &M, &N, &W);
		inc.clear();
        inc.insert(make_pair(N, M));
        inc.insert(make_pair(N, -M));
        inc.insert(make_pair(-N, M));
        inc.insert(make_pair(-N, -M));
        inc.insert(make_pair(M, N));
        inc.insert(make_pair(M, -N));
        inc.insert(make_pair(-M, N));
        inc.insert(make_pair(-M, -N));
		
		while(W-- != 0)
		{
			scanf("%d %d", &i, &j);
			grid[i][j] = -1;
		}
		
		even = odd = stackPointer = 0;

		xStack[stackPointer] = 0;
		yStack[stackPointer] = 0;
		
		//printf("%d\n", inc.size());
		
		set<pair<int, int> >::iterator it;
		while(stackPointer != -1)
		{
			tx = xStack[stackPointer];
			ty = yStack[stackPointer];
			stackPointer--;
			
			if (!visited[tx][ty])
			{
				visited[tx][ty] = true;
				
				for (it = inc.begin(); it != inc.end(); ++it)
                {
					newX = tx + (*it).first; 
					newY = ty + (*it).second;
					
					if (newX >= 0 && newX < R && newY >= 0 && newY < C && grid[newX][newY] != -1)
					{
						grid[newX][newY]++;
						stackPointer++;
						xStack[stackPointer] = newX;
						yStack[stackPointer] = newY;
					}
				}
			}
		}
		
		for(i = 0; i < R; i++)
		{
			for(j = 0; j < C; j++)
			{
				gridVal = grid[i][j];

				if (gridVal > 0 || (i == 0 && j == 0))
				{
					if (gridVal % 2 == 0)
					{
						even++;
					}
					else
					{
						odd++;
					}
				}
				
				grid[i][j] = 0;
				visited[i][j] = false;
			}
		}
		
		printf("Case %d: %d %d\n", caseNr++, even, odd);
	}
    return 0;
}
