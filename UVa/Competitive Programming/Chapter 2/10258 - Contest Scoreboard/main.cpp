#include <cstdlib>
#include <cstdio>
#include <cstring>
#include <vector>
#include <map>
#include <algorithm>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
		freopen("test.out", "w", stdout);
	#endif
}

struct problem_data
{
	problem_data() : solved(false), time(0) {};
	bool solved;
	int time;	
};

struct contestant_data
{
	contestant_data() : nr(-1), problems(0), time(0) { };
	int nr;
	int problems;
	int time;
};

typedef std::map<int, problem_data > data;

std::map<int, data> g_input_scores;
std::vector<contestant_data> g_output_scores;

bool sort_contestants_func(contestant_data el, contestant_data el2)
{
	if (el.problems > el2.problems)
		return true;
	if (el.problems == el2.problems && el.time < el2.time)
		return true;
	if (el.problems == el2.problems && el.time == el2.time && el.nr < el2.nr)
		return true;
	return false;
}

void print_final_scores(contestant_data contestant_result)
{
	printf("%d %d %d\n", contestant_result.nr, contestant_result.problems, contestant_result.time);
}

int main(int argv,char* argc[])
{
	openFile();	
	int cases_number, nr, problem, time;
	char L, str[2056];
	data::iterator prob_it;
	std::map<int, data>::iterator o_it;
	std::vector<contestant_data>::iterator it;

	scanf("%d\n", &cases_number);

	while(cases_number--)
	{	
		g_input_scores.clear();
		g_output_scores.clear();
		while( fgets(str, 2056, stdin) && strlen(str) > 2) // strlen in linux returns 2 (i guess "\r\n" ). On windows it is 0. I can be wrong please correct me :)
		{
			sscanf(str,"%d %d %d %c", &nr, &problem, &time, &L);
			g_input_scores[nr];
			if (!g_input_scores[nr][problem].solved)
			{
				if (L == 'C')
				{
					g_input_scores[nr][problem].time += time;
					g_input_scores[nr][problem].solved = true;
				}
				if (L == 'I')
				{
					g_input_scores[nr][problem].time += 20;
				}
			}
		}

		// Convert input scoreboard to output scoreboard
		for(o_it = g_input_scores.begin(); o_it != g_input_scores.end(); ++o_it)
		{
			contestant_data output_row;
			output_row.nr = o_it->first;
			for (prob_it = o_it->second.begin(); prob_it != o_it->second.end(); ++prob_it)
				if (prob_it->second.solved)	
				{
					output_row.problems++;
					output_row.time += prob_it->second.time;
				}
		
			g_output_scores.push_back(output_row);
		}

		// Sort output scoreboard
		std::sort(g_output_scores.begin(), g_output_scores.end(), sort_contestants_func);

		// Printing scoreboard
		for_each(g_output_scores.begin(), g_output_scores.end(), print_final_scores);
			
		if (cases_number)
			printf("\n");
	}
	return 0;
} 
