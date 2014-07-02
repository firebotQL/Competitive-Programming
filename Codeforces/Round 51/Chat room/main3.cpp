#include <cstdio>
#include <iostream>
#include <vector>
#include <string>
#include <cctype>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

int mainThree(int argc, char *argv[])
{
	unsigned int i, t, iCount(0);
	openFile();
	std::cin >> i;
	std::vector<unsigned int> divisors(1, i);
	std::vector<unsigned int> max_divisors;
	std::vector<unsigned int>::iterator it;
	for(--i ; 1 < i; --i)
	{
		for(it = divisors.begin(); it != divisors.end(); it++)
			if (*(it) % i == 0)
				iCount++;
		if (iCount == divisors.size())
			divisors.push_back(i);
	}
	bool good = true;
	std::vector<unsigned int>::reverse_iterator rit,rit2;
	for(rit = divisors.rbegin(); rit < divisors.rend(); rit++)
	{
		good = true;
		for(rit2 = rit; rit2 < divisors.rend(); rit2++)
			if (*(rit2) % *(rit) != 0)
			{
				good = false;
				break;
			}
		if (good)
			max_divisors.push_back(*rit);
	}

	for(rit = max_divisors.rbegin(); rit < max_divisors.rend(); rit++)
			std::cout << *rit << " ";
	std::cout << 1;
	return 0;
}