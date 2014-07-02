#include <cstdio>
#include <vector>
#include <stack>
#include <string>
#include <cstring>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

typedef std::vector<std::stack<std::string> > vss;

inline bool compareCardsFromPiles(vss& game, int i, int j)
{
	if (i < 0)
		return false;
	if(game[i].top()[0] == game[j].top()[0] ||
		game[i].top()[1] == game[j].top()[1])
		return true;
	return false;
}

inline void moveCard(vss& game, int i,int j)
{
	game[i].push(game[j].top());
	game[j].pop();
	if (!game[j].size())
		game.erase(game.begin()+j);
}

bool moveCards(vss& game)
{
	for(vss::size_type i = 1; i < game.size(); ++i)
	{
		if (compareCardsFromPiles(game, i-3, i))
		{
			moveCard(game, i-3, i);
			return true;
		}

		if (compareCardsFromPiles(game, i-1, i))
		{
			moveCard(game, i-1, i);
			return true;
		} 

	}
	return false;
}

int main(int argc, char* argv[])
{
	vss game;
	openFile();
	char line[80];
	char *tok;
	std::string card;
	std::stack<std::string> pile;
	int i = 0, nFirst = 0;
	while(fgets(line, 79, stdin) && line[0] != '#' )
	{					
		tok = strtok(line, " ");
		while (tok != NULL)
		{
			card = tok;
			pile.push(card);
			game.push_back(pile);
			pile.pop();
			while(moveCards(game)) {};	
			tok = strtok(NULL, " ");
		}
		i++;
		if (i == 2)
		{
			if (game.size() > 1)
				printf("%d piles remaining:", game.size());
			else
				printf("%d pile remaining:", game.size());
			for(vss::iterator it = game.begin(); it != game.end(); ++it)
				printf(" %d", it->size());
			printf("\n");
			i = 0;
			game.clear();
		}

	}
	return 0;
}
