#include <cstdio>
 
inline void openFile()
{ 
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

int main(int argc,char *argv[])
{
	long long boards_num, x_count, o_count, x_wins, o_wins;
	int i, j;
	char board[3][3];
	openFile();
	scanf("%lld\n", &boards_num);
	while(boards_num--)
	{
		x_count = o_count = x_wins = o_wins = 0;
		scanf("%c%c%c\n%c%c%c\n%c%c%c\n\n", &board[0][0],&board[0][1],&board[0][2],
							&board[1][0],&board[1][1],&board[1][2],
							&board[2][0],&board[2][1],&board[2][2]); 
		
		for(i = 0; i < 3; ++i)
		{
			// Check rows
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2])
				if (board[i][0] == 'X')
					x_wins++;
				else if (board[i][0] == 'O')
					o_wins++;
			// Check columns
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i])
				if (board[0][i] == 'X')
					x_wins++;
				else if (board[0][i] == 'O')
					o_wins++;

			for(j = 0; j < 3; ++j)
			{
				if (board[i][j] == 'X')
					x_count++;
				else if (board[i][j] == 'O')
					o_count++;
			}
		}
		
		if (x_count-o_count != 1 && x_count-o_count != 0)
		{
			printf("%s\n", "no");
			continue;
		}
		
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2])
			if (board[0][0] == 'X')
					x_wins++;
				else if (board[0][0] == 'O')
					o_wins++;
		
		if(board[0][2] == board[1][1] && board[1][1] == board[2][0])
			if (board[0][2] == 'X')
					x_wins++;
				else if (board[0][2] == 'O')
					o_wins++;
		if (x_wins >= 1 && o_wins >= 1)
			printf("%s\n", "no");
		else if (x_wins > 2 || o_wins > 1)
			printf("%s\n", "no");
			else if (o_wins == 1 && x_count-o_count > 0)
				printf("%s\n", "no");
				else if ((x_wins == 1 || x_wins == 2) && x_count-o_count <= 0)
					printf("%s\n", "no");
					else
						printf("%s\n", "yes");			
				
	} 
	return 0;
}
