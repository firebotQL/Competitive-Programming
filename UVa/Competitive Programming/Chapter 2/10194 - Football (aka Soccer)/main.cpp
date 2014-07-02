#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
	freopen("test.out", "w", stdout);
#endif
}
struct statistic
{
	std::string tm_name;
	int points;
	int total_games;
	int wins;
	int ties;
	int losses;
	int goals_dif;
	int goal_scor;
	int goal_against;
};

std::vector<statistic> g_team_stats;

inline statistic* getTeamByName(char* tm_name)
{
        const char *test;
	for(std::vector<statistic>::iterator it = g_team_stats.begin(); it != g_team_stats.end(); ++it)
        {
               test = it->tm_name.c_str();
		if (!strcmp(it->tm_name.c_str(), tm_name))
			return &(*it);
        }

	return NULL;	// SHOULD NEVER HAPPEN

}

inline void setCommonResultsForTeam(statistic* team, int& score1, int& score2)
{
	team->total_games++;
	team->goal_scor += score1;
	team->goal_against += score2;
	team->goals_dif += score1;
	team->goals_dif -= score2;
}

inline void setResults(statistic* team1, statistic* team2, int& score1, int& score2)
{
	setCommonResultsForTeam(team1, score1, score2);
	setCommonResultsForTeam(team2, score2, score1);

	if (score1 > score2)
	{
		team1->points += 3;
		team1->wins++;
		team2->losses++;
	}
	else if (score1 < score2)
	{
		team2->points += 3;
		team2->wins++;
		team1->losses++;
	}
	else
	{
		team1->points++;
		team1->ties++;
		team2->points++;
		team2->ties++;
	}
}

inline void parseLine(char* line, char* tm_name, char* tm_name2, int& score1, int& score2)
{
	char *token;
	int iCount(0);
	token = strtok (line, "#@");
	while (token != NULL)
	{
		switch(iCount)
		{
		case 0:
			strcpy(tm_name, token);
			break;
		case 1:
			score1 = atoi(token);
			break;
		case 2:
			score2 = atoi(token);
			break;
		case 3:
			strcpy(tm_name2, token);
		}
		token = strtok(NULL, "#@");
		iCount++;
	}
	statistic* team1 = getTeamByName(tm_name);
	statistic* team2 = getTeamByName(tm_name2);
	setResults(team1, team2, score1, score2);
}

bool stricmp(std::string& first, std::string& second)
{
	std::string str1(first);
	std::string str2(second);
	std::transform(str1.begin(), str1.end(), str1.begin(), ::tolower);
	std::transform(str2.begin(), str2.end(), str2.begin(), ::tolower);
	if (strcmp(str1.data(), str2.data()) < 0)
		return true; 
	return false;
}

bool sortfunction (statistic i, statistic j) {
	if (i.points > j.points)
	{
		return true;
	}
	else if (i.points == j.points)
	{
		if (i.wins > j.wins)
		{
			return true;
		}
		else if (i.wins == j.wins)
		{
			if (i.goals_dif > j.goals_dif)
			{
				return true;
			}
			else if (i.goals_dif == j.goals_dif)
			{
				if (i.goal_scor > j.goal_scor)
				{
					return true;
				}
				else if (i.goal_scor == j.goal_scor)
				{
					if (i.total_games < j.total_games)
					{
						return true;
					}
					else if (i.total_games == j.total_games)
					{
						if (stricmp(i.tm_name, j.tm_name))
						{
							return true;
						}
					}
				}
			}
		}
	}
	return false;
 }

int main(int argc,char* argv[])
{
	openFile();
	int N, T, G, score1, score2, iCount;
	std::vector<statistic>::iterator it;
	scanf("%d\n", &N);
	char line[80], buf[35], tm_name[35], tm_name2[35], tour_name[105];
	std::string team_name;
	statistic temp = { "", 0, 0, 0, 0, 0, 0, 0, 0};
	while(N--)
	{
		iCount = 1;
		g_team_stats.clear();
		fgets(tour_name, sizeof tour_name, stdin);
		scanf("%d\n", &T);
		while(T--)
		{
			scanf("%30[^\r\n]\r\n", tm_name);
			temp.tm_name = tm_name;
			g_team_stats.push_back(temp);
		}
		scanf("%d\n", &G);
		while(G--)
		{
			scanf("%80[^\r\n]\r\n", line);
			parseLine(line, tm_name, tm_name2, score1, score2);
		}
		printf("%s", tour_name);
		std::sort(g_team_stats.begin(), g_team_stats.end(), sortfunction);
		for(it = g_team_stats.begin(); it != g_team_stats.end(); ++it, ++iCount)
		{
			printf("%i) %s %ip, %ig (%i-%i-%i), %igd (%i-%i)\n", iCount, it->tm_name.c_str(), it->points,
				it->total_games,
				it->wins,
				it->ties,
				it->losses,
				it->goals_dif,
				it->goal_scor,
				it->goal_against);
		}
		if (N != 0)
			printf("\n");
	}
	return 0;
}
