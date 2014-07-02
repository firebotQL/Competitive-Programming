#include <cstdio>
#include <iostream>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

int main(int argc,char* argv[])
{
	char c;
	bool bb(true);
	openFile();
	while(std::cin.get(c)) {
		if (c == '\"' && bb) {
			std::cout << "``";
			bb = false;
		} else if (c == '\"' && !bb) {
			std::cout << "''";
			bb = true;
		} else {
			std::cout << c;
		}
	}
	return 0;
} 