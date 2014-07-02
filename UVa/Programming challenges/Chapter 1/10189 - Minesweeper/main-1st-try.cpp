#include <iostream>
#include <vector>
#include <string>

using namespace std;

const char ccMine = '*';


int GetFieldsAdjacentMinesCount(vector<string>& p_rInput, int line, int index)
{
	int iCount = 0;
	// Upper line
	if (p_rInput[line-1][index-1] == ccMine)
		iCount++;
	if (p_rInput[line-1][index] == ccMine)
		iCount++;
	if (p_rInput[line-1][index+1] == ccMine)
		iCount++;

	// Same line 
	if (p_rInput[line][index-1] == ccMine)
		iCount++;
	if (p_rInput[line][index+1] == ccMine)
		iCount++;

	// Bottom line 
	if (p_rInput[line+1][index-1] == ccMine)
		iCount++;
	if (p_rInput[line+1][index] == ccMine)
		iCount++;
	if (p_rInput[line+1][index+1] == ccMine)
		iCount++;
	return iCount;
}


int main()
{
	vector<string> input;
	string str;
	int n(-1),m(-1);
	int iCount(0), iFieldCnt(1);
	bool bFirst(true);
	char input[][];
	while (cin >> n >> m )
	{
		if (n == 0 && m == 0)
			return 0;
	
		string dummy(m+2,'.');
		input.push_back(dummy);
		for(int i = 0; i < n; i++)
		{
			cin >> str;
			str.insert(0, ".");
			str.insert(str.length(), ".");
			input.push_back(str);	
		}
		input.push_back(dummy);
		n++;
		m++;
		if (!bFirst)
			cout << endl;
		else 
			bFirst = false;
		cout << "Field #" << iFieldCnt++ << ":" << endl;
		for(int i = 1; i < n; i++)
		{
			for(int j = 1; j < m; j++)
			{
				if (input[i][j] != ccMine)
					cout << GetFieldsAdjacentMinesCount(input, i, j);
				else
					cout << ccMine;
			}
			cout << endl;
		}
		input.clear();
	}
	return 0;
}
