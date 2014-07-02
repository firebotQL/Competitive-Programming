#include <cstdio>
#include <cstdlib>
#include <bitset>
#include <string>
#include <algorithm>

#define SWAP(x,y) (x^=y, y^=x, x^=y)

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
};

std::map<char*, std::vector<int>> g_teams;

inline void parseLine(char* line, int& iCount)
{
	char tm_nameOne[35], tm_nameTwo[35];
	int tmOne_res, tmTwo_res;
	temp = strtok (played_games, "#@");
	while (temp != NULL)
	{
		switch(iCount)
		{
		case 0:
			strcpy(tm_nameOne, pch);
			break;
		case 1:
			tmOne_res = atoi(pch);
			break;
		case 2:
			tmTwo_res = atoi(pch);
			break;
		case 3:
			strcpy(tm_nameTwo, pch);
			break;
		}
		pch = strtok (NULL, "#@");
		iCount++;
	}
}

inline void fillTeam(char* name, int point, bool bOutcome)
{

}

int main(int argv, char* argc[])
{
	openFile();
	int N,T,G,iCount;
	scanf("%d\n", &N);
	char t_name[103], tm_name[35], tm_name2[35], played_games[80], *temp;
	std::vector<int> temp;
	while(N--)
	{
		scanf("%s", t_name);
		scanf("%d\n", &T);
		while(T--)
		{
			scanf("%s", tm_name);
			teams[tm_name] = temp;
		}
		scanf("%d\n", &G);
		while(G--)
		{
			scanf("%s", played_games);
			// Splitting by #
			iCount = 0;
		}
	}
	return 0;
} 