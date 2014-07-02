#include <cstdio>
#include <vector>
#include <utility>
#include <algorithm>
#include <string>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
};

bool sortfnc (std::pair<int, std::string> i,std::pair<int, std::string> j) { return i.first < j.first; }

int main(int argv, char* argc[])
{
	std::vector<std::pair<int, std::string> > vPairs;
	openFile();
	int n, i, j, x, z;
	scanf("%d\n", &n);
	char buffer[1024];
	char temp = '\0';
	char dummy[10];
	for(i = 0; i < n; ++i)
	{
		j = 0;
		while(scanf("%d[^\n]", &z)) {
			vPairs.push_back(std::make_pair(z, &temp));
			if (scanf("%[\n]", &dummy))
				break;
		};

		while(scanf("%s[^ ]", &buffer)) {
			vPairs[j++].second.assign(buffer);
			if (scanf("%[\n]", &dummy))
				break;
		}
		sort(vPairs.begin(), vPairs.end(), sortfnc);
		for(x = 0; x < j; ++x)
			printf("%s\n", vPairs[x].second.c_str());
		if (i+1 != n)
			printf("\n");
		vPairs.clear();
	}

	return 0;
} 