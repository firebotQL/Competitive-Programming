#include <cstdio>
#include <iostream>
#include <vector>
#include <string>
#include <utility>
#include <algorithm>

typedef std::pair<int, char> card;
typedef std::vector<card > hand;

const int handSize = 5;
const int valuesCount = 14;
const int colorCount = 4;

char* cardValues = "23456789TJQKA";

const char* answers[] = {
	"Black wins.",
	"White wins.",
	"Tie.",
};

enum {
	HC, PR, TP, TK, ST, FL, FH, FK, SF,
};

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
	#endif
}

bool sortFunc(const card& a, const card& b)
{
	return a.first > b.first;
}

void rank(hand& Hand, int* rank )
{
	int i, j, flush, straight, pair(0), three(0), four(0), kind;
	int count [valuesCount] = {0};

	std::sort(Hand.begin(), Hand.end(), sortFunc);
	for(i = 0; i < handSize; ++i)
		count[Hand[i].first] += 1;
	straight = Hand[0].first - Hand[1].first == 1 && Hand[1].first - Hand[2].first == 1 &&
		Hand[2].first - Hand[3].first == 1 && Hand[3].first - Hand[4].first == 1;
	flush = Hand[0].second == Hand[1].second && Hand[1].second == Hand[2].second &&
		Hand[2].second == Hand[3].second && Hand[3].second == Hand[4].second;
	for(i = 0; i < valuesCount; ++i)
		if (count[i] == 2)
			pair++;
		else if (count[i] == 3)
			three++;
		else if (count[i] == 4)
			four++;
	
	if (straight && flush)	// Straight flush
		kind = SF;
	else if (four)	// Four of the Kind
		kind = FK;
	else if (three && pair)	// Full House
		kind = FH;
	else if (flush)	// Flush
		kind = FL;
	else if (straight)	// Straight
		kind = ST;
	else if (three)	// Three of the Kind
		kind = TK;
	else if (pair == 2) // Two Pairs
		kind = TP;
	else if (pair)	// Pair
		kind = PR;
	else			// High Card
		kind = HC;

	rank[0] = kind;
	switch(kind)
	{
	case HC: case FL:	// High Card or Flush
		for(i = 0; i < handSize; ++i)
			rank[i+1] = Hand[i].first;
		break;
	case ST: case SF:	// Straight or Straight Flush
		rank[1] = Hand[0].first;
		break;
	case FK:		// Four of A Kind
		if (Hand[0].first == Hand[1].first)
			rank[1] = Hand[0].first;
		else
			rank[1] = Hand[1].first;
		break;
	case FH:	// Full House
		if (Hand[0].first == Hand[1].first && Hand[1].first == Hand[2].first)
			rank[1] = Hand[0].first;
		else
			rank[1] = Hand[2].first;
		break;
	case TK:	// Three of a Kind
		if (Hand[0].first == Hand[1].first)
			rank[1] = Hand[0].first;
		else if (Hand[1].first == Hand[2].first)
			rank[1] = Hand[1].first;
		else
			rank[1] = Hand[2].first;
		break;
	case PR:	// Pair
		for(i = 0, j = 2; i < handSize-1; ++i)
			if (Hand[i].first == Hand[i+1].first)
				rank[1] = Hand[i++].first;
			else
				rank[j++] = Hand[i].first;
		break;
	case TP:	// Two Pairs
		for (i = 0, j = 3; i < 4; ++i)
			if (Hand[i].first == Hand[i+1].first)
				rank[1] = Hand[i++].first;
			else
				rank[j++] = Hand[i].first;
			if (rank[1] < rank[2])
				rank[1] ^= rank[2], rank[2] ^= rank[1], rank[1] ^= rank[2];
		break;
	}
}

int compare(hand& bHand, hand& wHand)
{
	int bRank [6] = {-1, -1, -1, -1, -1, -1};
	int wRank [6] = {-1, -1, -1, -1, -1, -1};	
	rank(bHand, bRank);
	rank(wHand, wRank);
	for(int i = 0; i < handSize+1; ++i)
		if (bRank[i] > wRank[i])
			return 0;
		else if (bRank[i] < wRank[i])
			return 1;
	return 2;
}

int main(int argc, char* argv [])
{
	openFile();
	std::string temp;
	hand blackHand;
	hand whiteHand;
	int i;
	char values[128];
	for(i = 0; i < valuesCount; ++i)
		values[cardValues[i]] = i;
	while(std::getline(std::cin, temp))
	{
		for(i = 0; i < handSize; ++i)
		{
			blackHand.push_back(std::make_pair(values[temp[3*i]], temp[3 * i+1]));
			whiteHand.push_back(std::make_pair(values[temp[3*i + 3*handSize]], temp[3*i + 3*handSize+1])); 
		}
		std::cout << answers[compare(blackHand, whiteHand)] << std::endl;
		blackHand.clear();
		whiteHand.clear();
	}
}