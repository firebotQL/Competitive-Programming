#include <cstdio>
#include <iostream>
#include <vector>
#include <string>
#include <cctype>
#include <iterator>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

int main(int argc, char *argv[])
{
	unsigned int i,x,y;
	openFile();
	std::cin >> i;
	std::istream_iterator<unsigned int> eos;
	std::istream_iterator<unsigned int> iit(std::cin);
	std::vector<unsigned int> trees;
	while(iit++ != eos)
		trees.push_back(*iit);
	y = i-1;
	unsigned int changes;
	for(x = 0; x <= y; x++, y--)
	{
		if (trees[x] != trees[y])
		{
			changes = 
		}
	}
	
	

	return 0;
}