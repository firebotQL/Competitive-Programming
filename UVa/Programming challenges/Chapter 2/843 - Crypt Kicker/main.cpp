#include <cstdio>
#include <iostream>
#include <vector>
#include <string>
#include <map>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

int main(int argc,char* argv[])
{
	int i;
	std::string temp;
	std::map<unsigned int, std::vector<std::string> > dictionary;
	std::map<unsigned int, std::string> encryptedDictionary;
	std::vector<std::string> encryptedLines;
	openFile();
	std::cin >> i;
	while(i--)
	{
		std::cin >> temp;
		dictionary[temp.size()].push_back(temp);
	}
	std::cin.ignore();
	while(std::getline(std::cin, temp))
	{
		for(std::string::size_type i = 0; i < temp.size(); i++)
			if (temp[i] != ' ')
				std::cout << (int)temp[i] << "|";
			else
				std::cout << "  |";
		std::cout << std::endl;
		encryptedLines.push_back(temp);
	}
	
	return 0;
} 