#include <cstdio>

int graph[6][6];
int path[10];
int pathsize = 0;

void backtracking(int nr)
{
	path[pathsize++] = nr;
	
	if (pathsize == 9)
	{
		for(int i = 0; i < pathsize; i++)
			printf("%d", path[i]);
		printf("\n");
		pathsize--;
		return;		
	}	

	for(int i = 1; i < 6; ++i)
	{
		if (graph[nr][i])
		{
			graph[nr][i] = graph[i][nr] = 0;
			backtracking(i);
			graph[nr][i] = graph[i][nr] = 1;
		}
	}
	pathsize--;
}

// Adjacency matrix
int main()
{
	graph[1][2] = graph[2][1] = 1;
	graph[1][3] = graph[3][1] = 1;
	graph[1][5] = graph[5][1] = 1;
	graph[2][3] = graph[3][2] = 1;
	graph[2][5] = graph[5][2] = 1;
	graph[3][4] = graph[4][3] = 1;
	graph[3][5] = graph[5][3] = 1;
	graph[4][5] = graph[5][4] = 1;
	backtracking(1);
}
