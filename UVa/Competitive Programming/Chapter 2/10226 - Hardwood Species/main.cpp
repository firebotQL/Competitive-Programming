#include <stdio.h>
#include <map>
#include <string>
#include <cstring>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
		//freopen("test.out", "w", stdout);
	#endif
}

int main(int argc, char* argv[])
{
	int N, total;
	std::map<std::string, int> trees;
	std::map<std::string, int>::iterator it;
	openFile();
	scanf("%d\n", &N);
	char tree_name[30];
	while(N--)
	{
		total = 0;
		trees.clear();
		while(fgets(tree_name, 31, stdin) && tree_name[0] != '\n')
		{
			tree_name[strlen(tree_name)-1] = '\0';
			trees[tree_name]++;
			total++;
		}
		
		for(it = trees.begin(); it != trees.end(); ++it)
			printf("%s %.4f\n", it->first.c_str(), it->second*100.0/total);	

		
		if (N)
			printf("\n");
	}
	return 0;
}	
