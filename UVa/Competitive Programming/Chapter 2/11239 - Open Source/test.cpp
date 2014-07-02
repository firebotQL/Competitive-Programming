#include <cstdio>
#include <map>
#include <vector>
#include <set>
#include <string>
#include <algorithm>
#include <utility>
#include <iostream>

using namespace std;

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
		freopen("test.out", "w", stdout);
	#endif
}

bool compare_by_count(pair<string, set<string> > element1,
			pair<string, set<string> > element2)
{
	if (element1.second.size() > element2.second.size())
		return true;
	if (element1.second.size() == element2.second.size()
		&& element1.first.compare(element2.first) < 0)
		return true;
	return false;
}

int main(int argc, char* argv[])
{
	string project_name;
	string line;
	map<string, set<string> > projects_sheet;	// projects_sheet -> students (1 to n)
	map<string, set<string> > stud_app_list;	// students -> projects_sheet (1 to n)
	vector<pair<string, set<string> > > result_list;	// result list for sorting

	map<string, set<string> >::iterator it;
	set<string>::iterator it2;
	vector<pair<string, set<string> > >::iterator it3;
	
	openFile();
	while(getline(cin, line).good() && line[0] != '0')
	{
		if (line[0] == '1')
		{
			// Iterating through job students and checking if any
			// of following students assigned for more than 1 job
			for(it = projects_sheet.begin(); it != projects_sheet.end(); ++it)
			{
				for (it2 = it->second.begin(); it2 != it->second.end(); ++it2)
				{
					if (stud_app_list[*it2].size() > 1)
						it->second.erase(it2);
				}
			}
			
			copy(projects_sheet.begin(), projects_sheet.end(), back_inserter(result_list));

			stable_sort(result_list.begin(), result_list.end(), compare_by_count);

			for(it3 = result_list.begin(); it3 != result_list.end(); ++it3)
				cout << it3->first << " " << it3->second.size() << endl;

			result_list.clear();
			stud_app_list.clear();
			projects_sheet.clear();

			continue;
		}
		
		if (isupper(line[0]))
		{
			project_name = line;
			projects_sheet[project_name];
		}
		else
		{
			projects_sheet[project_name].insert(line);
			stud_app_list[line].insert(project_name);			
		}
			
	}
	return 0;
}
