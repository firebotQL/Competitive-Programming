#include <string>
#include <vector>
#include <iostream>

using namespace std;
const char ccHorizontalSegment = '-';
const char ccVertialSegment = '|';

const int baseNumbers[10][5] = 
{
	{2,4,0,4,2},
	{0,3,0,3,0},
	{2,3,2,1,2},
	{2,3,2,3,2},
	{0,4,2,3,0},
	{2,1,2,3,2},
	{2,1,2,4,2},
	{2,3,0,3,0},
	{2,4,2,4,2},
	{2,4,2,3,2}
};

/*0 - do nothing
1,3,4 - multiply('|') rows;
2 - multiply ('-') columns;
// Each digit occupies exactly s+2 columns and 2s+3 rows
*/

string CreateHorizontalString(int rowLength)
{
	string filled(rowLength, ccHorizontalSegment);
	string fullRow(2, ' ');
	fullRow.insert(1, filled);
	return fullRow;
}

string CreateVerticalString(int rowLength, int type )
{
	if (type == 1)
	{
		string first(1, ccVertialSegment);
		string filled(rowLength+1, ' ');
		first.insert(1, filled);
		return first;
	} 
	else if (type == 3)
	{
		string last(1, ccVertialSegment);
		string filled(rowLength+1, ' ');
		filled.insert(filled.size(), last);
		return filled;
	}
	else if (type == 4)	
	{
		string firstlast(2, ccVertialSegment);
		string filled(rowLength, ' ');
		firstlast.insert(1, filled);
		return firstlast;
	}
	return "";
}

int main()
{
	string number, row, sEmpty, sStub;
	string::size_type l, nLength;
	vector<string> lcdScreen;
	int s, i, j, curNum, iCount;
	const int* bNumber;
	char temp;
	while (cin >> s && cin >> number && !(s == 0 && number == "0"))
	{
		lcdScreen.assign(2*s+3, "");
		nLength = number.length();
		sStub = string(1, ' ');
		for(l = 0; l < nLength; l++)
		{
			temp = number[l];
			curNum = atoi(&temp);
			bNumber = &baseNumbers[curNum][0];
			sEmpty = string(s + 2, ' ');
			iCount = 0;
			if (l+1 == nLength)
				sStub = "";

			for(i = 0; i < 5; i++)
			{
				switch(bNumber[i])
				{
				case 0:
					lcdScreen[iCount++].append(sEmpty + sStub);
					break;
				case 1:
				case 3:
				case 4:
					row = CreateVerticalString(s, bNumber[i]);
					for(j = 0; j < s; j++)
						lcdScreen[iCount++].append(row + sStub);
					break;				
				case 2:
					lcdScreen[iCount++].append(CreateHorizontalString(s) + sStub);
					break;
				}
			}
		}

		for(vector<string>::iterator it = lcdScreen.begin(); it != lcdScreen.end(); it++)
			cout << *it << endl;
		cout << endl;
	}
	return 0;
}