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

int mainbkp(int argc, char *argv[])
{
	std::string etal = "hello";
	std::string temp;
	openFile();
	std::cin >> temp;
	size_t found = 0;
	bool can = true;
	for(size_t i = 0; i < etal.size(); i++)
	{
		found = temp.find(etal[i], found);
		if (found == std::string::npos)
		{
			can = false;
			break;
		} 
		else
		{
			found++;
		}
	}
	if (can)
		std::cout << "YES";
	else
		std::cout << "NO";
	return 0;
}
