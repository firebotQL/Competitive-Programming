#include <cstdio>
#include <iostream>
#include <cstring>
#include <iomanip>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

inline void swap(int& a,int &b)
{
	a ^= b;
	b = a ^ b;
	a ^= b;
}

char* message[] =
{
	"There is no empty spots.\n",
	"There is one empty spot.\n",
	"There are %d empty spots.\n"
};

int main(int argc,char* argv[])
{
	int** board;
	openFile();
	int X1,Y1,X2,Y2,W,H,N,i,j,iCount(0),slots;
	while(scanf("%d %d %d\n", &W, &H, &N) != EOF && 
			(W != 0 || H != 0 || N != 0))
	{
		iCount = 0;
		board = new int*[W];
		for(i = 0; i < W; ++i)
		{
			board[i] = new int[H];
				for(j = 0; j < H; ++j)
					board[i][j] = 0;
		}

		while(N--)
		{
			scanf("%d %d %d %d\n", &X1, &Y1, &X2, &Y2);
			if (X1 > X2)
				swap(X1, X2);
			if (Y1 > Y2)
				swap(Y1, Y2);
			for(i = X1-1; i < X2; ++i)
				for(j = Y1-1; j < Y2; ++j)
				{
					if (board[i][j] != 1)
					{
						iCount++;
						board[i][j] = 1;
					}
				}
		}
		slots = W*H-iCount;
		switch(slots)
		{
		case 0:
			printf(message[0]);
			break;
		case 1:
			printf(message[1]);
			break;
		default:
			printf(message[2], slots);
			break;
		}
		for(i = 0; i < W; i++)
			delete [] board[i];
	}
	return 0;
} 
