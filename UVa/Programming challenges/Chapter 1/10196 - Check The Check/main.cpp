#include <cstdio>
#include <iostream>
#include <vector>
#include <cstring>
#include <cctype>
#include <string>

std::vector<std::string> gBoard;
const int boardSize = 8;
std::string etal;
std::string answerPart = " king is in check.";
const char whiteKing = 'K';
const char blackKing = 'k';

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

void printResult(int boardNr, int situation)
{
	std::string color;
	switch(situation)
	{
	case 0:
		color = "no";
		break;
	case 1:
		color = "white";
		break;
	case 2:
		color = "black";	
		break;
	}
	std::cout << "Game #" << boardNr << ": " << color << answerPart << std::endl;
}

bool recursivelyIfCheck(const char& figure, int x, int i, int direction, bool startPos)
{
	if (x < 0 || x >= boardSize ||
		i < 0 || i >= boardSize)
		return false;
	if (gBoard[x][i] == figure)
		return true;
	else if (startPos || gBoard[x][i] == '.')
	{
		switch(direction)
		{
		case 0:
			return recursivelyIfCheck(figure, x, i - 1, direction, false);
			break;
		case 1:
			return recursivelyIfCheck(figure, x - 1, i - 1, direction, false);
			break;
		case 2:
			return recursivelyIfCheck(figure, x - 1, i, direction, false);
			break;
		case 3:
			return recursivelyIfCheck(figure, x - 1, i + 1, direction, false);
			break;
		case 4:
			return recursivelyIfCheck(figure, x, i + 1, direction, false);
			break;
		case 5:
			return recursivelyIfCheck(figure, x + 1, i + 1, direction, false);
			break;
		case 6:
			return recursivelyIfCheck(figure, x + 1, i, direction, false);
			break;
		case 7:
			return recursivelyIfCheck(figure, x + 1, i - 1, direction, false);
			break;
		}
	}
	return false;
}

bool pawnCheck(int isBlack, int x, int i)
{
	char figure;

	if(isBlack)
	{
		figure = whiteKing;
		if (x+1 < boardSize)
			x++;
		else
			return false;
	} 
	else 
	{
		figure = blackKing;
		if (x-1 >= 0)
			x--;
		else
			return false;
	}

	if ((i-1 >= 0 && gBoard[x][i-1] == figure) ||
		(i+1 < boardSize && gBoard[x][i+1] == figure))
		return true;

	return false;
}

bool rookCheck(int isBlack, int x, int i)
{
	char figure;
	if (x < 0 || x >= boardSize ||
		i < 0 || i >= boardSize)
		return false;

	if (isBlack)
		figure = whiteKing;
	else
		figure = blackKing;

	return recursivelyIfCheck(figure,x,i, 0, true) || 
		recursivelyIfCheck(figure,x,i, 2, true) ||
		recursivelyIfCheck(figure,x,i, 4, true) ||
		recursivelyIfCheck(figure,x,i, 6, true);

	return false;
}

bool bishopCheck(int isBlack, int x, int i)
{
	char figure;
	if (x < 0 || x >= boardSize ||
		i < 0 || i >= boardSize)
		return false;
	if (isBlack)
		figure = whiteKing;
	else
		figure = blackKing;

	return recursivelyIfCheck(figure,x,i, 1, true) || 
		recursivelyIfCheck(figure,x,i, 3, true) ||
		recursivelyIfCheck(figure,x,i, 5, true) ||
		recursivelyIfCheck(figure,x,i, 7, true);
	return false;
}

bool queenCheck(int isBlack, int x, int i)
{
	char figure;
	if (x < 0 || x >= boardSize ||
		i < 0 || i >= boardSize)
		return false;
	if (isBlack)
		figure = whiteKing;
	else
		figure = blackKing;

	return recursivelyIfCheck(figure,x,i, 0, true) || 
		recursivelyIfCheck(figure,x,i, 1, true) ||
		recursivelyIfCheck(figure,x,i, 2, true) ||
		recursivelyIfCheck(figure,x,i, 3, true) ||
		recursivelyIfCheck(figure,x,i, 4, true) ||
		recursivelyIfCheck(figure,x,i, 5, true) ||
		recursivelyIfCheck(figure,x,i, 6, true) ||
		recursivelyIfCheck(figure,x,i, 7, true);

	return false;
}

bool kingCheck(int isBlack, int x, int i)
{
	if (x < 0 || x >= boardSize ||
		i < 0 || i >= boardSize)
		return false;
	char figure;
	if(isBlack)
		figure = whiteKing;
	else 
		figure = blackKing;

	if (i-1 >= 0)
		if (gBoard[x][i-1] == figure)
			return true;
	if (x-1 >= 0 && i-1 >= 0)
		if (gBoard[x-1][i-1] == figure)
			return true;
	if (x-1 >= 0)
		if (gBoard[x-1][i] == figure)
			return true;
	if (x-1 >= 0 && i+1 < boardSize)
		if (gBoard[x-1][i+1] == figure)
			return true;
	if (i+1 < boardSize)
		if (gBoard[x][i+1] == figure)
			return true;
	if (x+1 < boardSize && i+1 < boardSize)
		if (gBoard[x+1][i+1] == figure)
			return true;
	if (x+1 < boardSize)
		if (gBoard[x+1][i] == figure)
			return true;
	if (x+1 < boardSize && i-1 >= 0)
		if (gBoard[x+1][i-1] == figure)
			return true;

	return false;
}

bool knightCheck(int isBlack, int x, int i)
{
	if (x < 0 || x >= boardSize ||
		i < 0 || i >= boardSize)
		return false;
	char figure;
	if(isBlack)
		figure = whiteKing;
	else 
		figure = blackKing;

	if (x-1 >= 0 && i-2 >= 0)
		if (gBoard[x-1][i-2] == figure)
			return true;

	if (x-2 >= 0 && i-1 >= 0)
		if (gBoard[x-2][i-1] == figure)
			return true;

	if (x-2 >= 0 && i+1 < boardSize)
		if (gBoard[x-2][i+1] == figure)
			return true;	

	if (x-1 >= 0 && i+2 < boardSize)
		if (gBoard[x-1][i+2] == figure)
			return true;	

	if (x+1 < boardSize && i+2 < boardSize)
		if (gBoard[x+1][i+2] == figure)
			return true;	

	if (x+2 < boardSize && i+1 < boardSize)
		if (gBoard[x+2][i+1] == figure)
			return true;	

	if (x+2 < boardSize && i-1 >= 0)
		if (gBoard[x+2][i-1] == figure)
			return true;

	if (x+1 < boardSize && i-2 >= 0)
		if (gBoard[x+1][i-2] == figure)
			return true;

	return false;

}

int checkTheCheck()
{
	char figure;
	int figureType;
	for(std::vector<std::string>::size_type x = 0; x < gBoard.size(); x++)
	{
		for(unsigned int i = 0; i < gBoard[x].size(); i++)
		{
			figure = gBoard[x][i];
			figureType = islower(figure) ? 1 : 2;
			switch(tolower(figure))
			{
			case 'p':
				if (pawnCheck(islower(figure), x, i))
					return figureType;
				break;
			case 'r':
				if (rookCheck(islower(figure), x, i))
					return figureType;
				break;
			case 'b':
				if (bishopCheck(islower(figure), x, i))
					return figureType;
				break;
			case 'q':
				if (queenCheck(islower(figure), x, i))
					return figureType;
				break;
			case 'k':
				if (kingCheck(islower(figure), x, i))
					return figureType;
				break;
			case 'n':
				if (knightCheck(islower(figure), x, i))
					return figureType;
				break;						
			} 
		}
	}
	return 0;
}

int main(int argc, char *argv[])
{
	etal.assign(boardSize, '.');
	std::cout << etal << std::endl;
	std::string temp;
	int iCount(0), iBoardNumber(0);
	openFile();
	while(true)
	{
		std::cin >> temp;
		if (std::strcmp(etal.c_str(), temp.c_str()) == 0)
			iCount++;
		else
			iCount = 0;

		if (iCount == boardSize)
			return 0;

		gBoard.push_back(temp);

		if (gBoard.size() == boardSize)
		{
			printResult(++iBoardNumber, checkTheCheck());
			gBoard.clear();
		}
	}
	return 0;
}
