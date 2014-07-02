#include <cstdio>
#include <vector>
#include <string>
#include <algorithm>
#include <iostream>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
	freopen("test.out", "w", stdout);
#endif
}
int countSortedness(std::string str)
{
	int iCount(0), i, j, len(str.length());
	for(i = 0; i < len; ++i)
		for(j = i+1; j < len; ++j)
			if(str[i] > str[j]) iCount++;

	return iCount;
}

bool sortfunc(std::pair<int,std::string> el1, std::pair<int,std::string> el2)
{
	return el1.first < el2.first ? true : false;
}

void show_result(std::pair<int, std::string> el)
{
	printf("%s\n", el.second.c_str());
}

int main(int argv,char* argc[])
{
	openFile();
	int M,n,m,size;
	scanf("%d", &M);
	std::vector<std::pair<int,std::string> > strings;
	std::string temp;
	while(M--)
	{
		strings.clear();
		scanf("%d %d", &n, &m);
		while(m--)
		{
			std::cin >> temp;
			strings.push_back(std::make_pair(countSortedness(temp), temp));
		}
		std::stable_sort(strings.begin(), strings.end(), sortfunc);

		size = strings.size();
		for_each(strings.begin(), strings.end(), show_result);
		if (size > 0 && M)
			printf("\n");
	}
	return 0;
}