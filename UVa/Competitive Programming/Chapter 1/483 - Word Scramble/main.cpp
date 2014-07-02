#include <cstdio>
#include <iostream>
#include <cstring>
#include <vector>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}
int main(int argc,char* argv[])
{
	char temp[2000];
	char* beg, *end;
	openFile();
	while(std::cin >> temp)
	{
		beg = temp;
		end = temp + strlen(temp);
		for(--end; beg < end; ++beg, --end)
		{
			*beg = *beg ^ *end;
			*end = *beg ^ *end;
			*beg = *beg ^ *end;
		}
		
		if (std::cin.peek() == '\n')
			std::cout << temp << '\n';
		else 
			if (!std::cin.eof())
				std::cout << temp << ' ';
			else
				std::cout << temp;
	}
}