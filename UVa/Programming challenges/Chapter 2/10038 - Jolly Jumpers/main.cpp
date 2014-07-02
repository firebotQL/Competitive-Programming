#include <cstdio>
#include <cstdlib>
#include <iostream>
#include <queue>
#include <string>
#include <algorithm>
#include <numeric>

std::vector<unsigned int> gLine;

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}
void generatePossible(unsigned int n)
{
	gLine.clear();
	gLine.reserve(n);
	for(unsigned int i = 1; i < n; i++)
		gLine.push_back(i);
}
void computeCase()
{
	int n,m(-1),i,z;
	std::vector<unsigned int>::iterator it;
	while(std::cin >> n)
	{
		generatePossible(n);
		for(i = 0; i < n; i++)
		{
			if (i > 0)
				z = m;
			std::cin >> m;	
			if (i > 0)
			{
				it = std::find(gLine.begin(),gLine.end(),std::abs(z-m));
				if (it != gLine.end())
					gLine.erase(it);
			}
		}
		if (gLine.empty())
			std::cout << "Jolly";
		else
			std::cout << "Not jolly";
		std::cout << std::endl;
	}
}

int main(int argc, char *argv[])
{
	openFile();
	computeCase();
	return 0;
}
