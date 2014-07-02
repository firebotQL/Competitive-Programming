// 10267 - Graphical Editor
#include <cstdio>
#include <vector>
#include <string>
#include <iostream>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

std::vector<std::string> gImage;

bool isAllowedCord(int X, int Y);


void createImage(int M, int N)
{
	std::string temp(M, 'O');
	gImage.assign(N, temp);
}

void clearImage()
{
	if (gImage.size() > 0 && gImage[0].size() > 0)
		createImage(gImage[0].size(), gImage.size());
}

void colorPixel(int X, int Y, char C)
{
	gImage[X][Y] = C;
}

void colorSegment(int X1, int X2, int Y1, int Y2, char C)
{
	int j;
	if (!isAllowedCord(X1,Y1) ||
		!isAllowedCord(X2,Y2)) return;
	for(;X1 <= X2; X1++)
		for(j = Y1;j <= Y2;j++)
			colorPixel(X1,j,C);
}

void printImage()
{
	for(std::vector<std::string>::size_type i = 0; i < gImage.size(); i++)
		std::cout << gImage[i] << std::endl;
}

void boundaryFill(int X, int Y, char t, char r)
{
	if (!isAllowedCord(X,Y)) return;
	if (gImage[X][Y] != t || gImage[X][Y] == r) return;
	gImage[X][Y] = r;
	boundaryFill(X-1, Y, t, r);
	boundaryFill(X+1, Y, t, r);
	boundaryFill(X, Y-1, t, r);
	boundaryFill(X, Y+1, t, r); 
}

bool isAllowedCord(int X, int Y)
{
	if (X < 0 || Y < 0 ||
		X >= gImage.size() || 
		(Y >= gImage[gImage.size()-1].size() ||
		gImage.size() <= 0)
		) return false;
	return true;
}

void compute()
{
	char C;
	int M, N;
	char cmd(' ');
	int X1,X2,Y1,Y2;
	std::string fileName;
	while (true)
	{
		std::cin >> cmd;
		switch (cmd)
		{
		case 'I':
			std::cin >> M >> N;
			createImage(M, N);
			break;
		case 'C':
			clearImage();
			break;
		case 'L':
			std::cin >> Y1 >> X1 >> C;
			Y1--; X1--;
			colorSegment(X1, X1, Y1, Y1, C);
			break;
		case 'V':			
			std::cin >> Y1 >> X1 >> X2 >> C;
			Y1--;X1--;X2--;
			if (X1 > X2)
				std::swap(X1,X2);
			colorSegment(X1, X2, Y1, Y1, C);
			break;
		case 'H':
			std::cin >> Y1 >> Y2 >> X1 >> C;
			Y1--;Y2--;X1--;
			if (Y1 > Y2)
				std::swap(Y1,Y2);
			colorSegment(X1, X1, Y1, Y2, C);
			break;
		case 'K':
			std::cin >> Y1 >> X1 >> Y2 >> X2 >> C;
			Y1--;X1--;Y2--;X2--;
			if (Y1 > Y2)
				std::swap(Y1,Y2);
			if (X1 > X2)
				std::swap(X1,X2);
			colorSegment(X1, X2, Y1, Y2, C);
			break;
		case 'F':
			std::cin >> Y1 >> X1 >> C;
			if (!isAllowedCord(--X1,--Y1)) return;
			boundaryFill(X1, Y1, gImage[X1][Y1], C);
			break;
		case 'S':
			std::cin >> fileName;
			std::cout << fileName << std::endl;
			printImage();
			break;
		case 'X':
			return;
		default:
			std::cin.ignore(100, '\n');
		}
	}
}

int main()
{
	openFile();
	compute();
	return 0;
}
