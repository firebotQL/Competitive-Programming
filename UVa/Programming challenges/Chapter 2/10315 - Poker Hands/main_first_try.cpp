#include <cstdio>
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <utility>

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}
typedef std::pair<int,char> card;
typedef std::vector<std::pair<int,char> > hand;
hand gFirstHand;
hand gSecondHand;
int gFirstHandRank = 0;
int gSecondHandRank = 0;

bool sortFunc(const card a, const card b) { 
	return (a.first < b.first); 
}

void printHands()
{
	for(hand::iterator it = gFirstHand.begin(); it != gFirstHand.end(); it++)
		std::cout << (*it).first << (*it).second << " ";
	std::cout << " - ";
	for(hand::iterator it = gSecondHand.begin(); it != gSecondHand.end(); it++)
		std::cout << (*it).first << (*it).second << " ";
	std::cout << std::endl;
}

std::pair<int, int> covertToPair(std::string& temp)
{
	std::pair<int,char> pTemp;
	switch(temp[0])
	{
	case 'T':
		pTemp.first = 10;
		break;
	case 'J':
		pTemp.first = 11;
		break;
	case 'Q':
		pTemp.first = 12;
		break;
	case 'K':
		pTemp.first = 13;
		break;
	case 'A':
		pTemp.first = 14;
		break;
	default:	
		pTemp.first = atoi(&temp[0]);
		break;
	}
	pTemp.second = temp[1];
	return pTemp;
}

// Straight flush: 5 cards of the same suit with consecutive values.
bool straightFlush(hand& Hand)
{
	for(hand::size_type i = 1; i < Hand.size(); i++)
	{
		if (Hand[i-1].second != Hand[i].second ||
			((Hand[i-1].first)+1 != Hand[i].first))
			return false;
	}

	return true;
}

// Four of a kind: 4 cards with the same value.
bool fourOfAKind(hand& Hand)
{
	int iCount(1), iMaxChain(0);
	for(hand::size_type i = 1; i < Hand.size(); i++)
	{
		if (Hand[i-1].first == Hand[i].first)
			iCount++;
		else
			if (iCount > iMaxChain)
			{
				iMaxChain = iCount;
				iCount = 1;
			}
	}

	if (iCount > iMaxChain)
	{
		iMaxChain = iCount;
		iCount = 1;
	}

	if (iMaxChain == 4)
		return true;
	else
		return false;
}

// Full House: 3 cards of the same value, with the remaining 2 cards forming a pair. 
bool fullHouse(hand& Hand)
{
	int iCount(1);
	bool hadPair(false), hadTriple(false);
	for(hand::size_type i = 1; i < Hand.size(); i++)
	{
		if(Hand[i-1].first == Hand[i].first)
			iCount++;
		else
			if (iCount == 2 && !hadPair)
			{
				iCount = 1;
				hadPair = true;
			}
			else if (iCount == 3 && !hadTriple)
				{
					iCount = 1;
					hadTriple = true;
				}
				else
					return false;
	}
	return true;
}

// Flush: Hand contains 5 cards of the same suit.
bool flush(hand& Hand)
{
	for(hand::size_type i = 1; i < Hand.size(); i++)
	{
		if(Hand[i-1].second != Hand[i].second)
			return false;
	}
	return true;
}

// Straight: Hand contains 5 cards with consecutive values.
bool straight(hand& Hand)
{
	for(hand::size_type i = 1; i < Hand.size(); i++)
	{
		if (Hand[i-1].first+1 != Hand[i].first)
			return false;
	}
	return true;
}

// Three of a Kind: Three of the cards in the hand have the same value.
bool threeOfAKind(hand& Hand)
{
	int iCount(1), iMaxChain(0);
	for(hand::size_type i = 1; i < Hand.size(); i++)
	{
		if (Hand[i-1].first == Hand[i].first)
			iCount++;
		else
			if (iCount > iMaxChain)
			{
				iMaxChain = iCount;
				iCount = 1;
			}
	}

	if (iCount > iMaxChain)
	{
		iMaxChain = iCount;
		iCount = 1;
	}

	if (iMaxChain == 3)
		return true;
	else
		return false;
}

// Two Pairs: The hand contains 2 different pairs.
bool twoPairs(hand& Hand)
{
	int iCount(0);
	for(hand::size_type i = 1; i < Hand.size(); i++)	
	{
		if (Hand[i-1].first == Hand[i].first)
			iCount++;
	}
	if (iCount >= 2)
		return true;
	else
		return false;
}

// Pair: 2 of the 5 cards in the hand have the same value.
bool onePair(hand& Hand)
{
	int iCount(0);
	for(hand::size_type i = 1; i < Hand.size(); i++) 
	{
		if (Hand[i-1].first == Hand[i].first)
			iCount++;
	}
	if (iCount >= 1)
		return true;
	else
		return false;
}

void clearHands()
{
	gFirstHand.clear();
	gSecondHand.clear();	
}

int getRank(hand& Hand)
{
	switch(0)
	{
	case 0:
		if (straightFlush(Hand))
			return 9;
	case 1:
		if (fourOfAKind(Hand))
			return 8;
	case 2:
		if (fullHouse(Hand))
			return 7;
	case 3:
		if (flush(Hand))
			return 6;
	case 4:
		if (straight(Hand))
			return 5;
	case 5:
		if (threeOfAKind(Hand))
			return 4;
	case 6:
		if (twoPairs(Hand))
			return 3;
	case 7:
		if (onePair(Hand))
			return 2;
	default:
		return 1;
	}
	return 0;
}

// Ranked by the highest card in the hand.
int compareStraightFlush(const hand& firstHand,const hand& secondHand)
{
	hand::size_type i = firstHand.size()-1;
	if (firstHand[i].first > secondHand[i].first)
		return -1;
	else if (firstHand[i].first < secondHand[i].first)
		return 1;
	return 0;
}

// Ranked by the value of the 4 cards.
int compareFourOfAKind(const hand& firstHand,const hand& secondHand)
{
	int iCount(0), firstSum(0), secondSum(0);
	hand::size_type i;

	for(i = 1; i < firstHand.size(); i++)
		if (firstHand[i-1].first == firstHand[i].first)
		{
			if (iCount == 0)
				firstSum += firstHand[i-1].first + firstHand[i].first;
			else
				firstSum += firstHand[i].first;
			iCount++;
		}

	iCount = 0;

	for(i = 1; i < secondHand.size(); i++)
		if (secondHand[i-1].first == secondHand[i].first)
		{
			if(iCount == 0)
				secondSum += secondHand[i-1].first + secondHand[i].first;
			else
				secondSum += secondHand[i].first;
			iCount++;
		}

	if (firstSum > secondSum)
		return -1;
	else if (firstSum < secondSum)
		return 1;
	return 0;
}

//  Ranked by the value of the 3 cards.
int compareFullHouse(const hand& firstHand,const hand& secondHand)
{
	int iCount(0), firstSum(0), secondSum(0);
	hand::size_type i;

	// Calculating value of 3 cards with equal value in first hand
	for(i = 1; i < firstHand.size(); i++)
	{	
		if (firstHand[i-1].first == firstHand[i].first)
		{
			if (iCount == 0)
				firstSum += firstHand[i-1].first + firstHand[i].first;
			else
				firstSum += firstHand[i].first;
			iCount++;
		}
		else 
		{
			if (iCount == 1)
			{
				firstSum = 0;
				iCount = 0;
			}
			else
			{
				if (iCount == 2)
					break;
			}
		}
	}

	iCount = 0;
	// Calculating value of 3 cards with equal value in second hand
	for(i = 1; i < secondHand.size(); i++)
		if (secondHand[i-1].first == secondHand[i].first)
		{
			if(iCount == 0)
				secondSum += secondHand[i-1].first + secondHand[i].first;
			else
				secondSum += secondHand[i].first;
			iCount++;
		}
		else 
		{
			if (iCount == 1)
			{
				secondSum = 0;
				iCount = 0;
			}
			else
			{
				if (iCount == 2)
					break;
			}
		}
	if (firstSum > secondSum)
		return -1;
	else if (firstSum < secondSum)
		return 1;
	return 0;
}

// Hands which are both flushes are ranked using the rules for High Card.
int compareFlush(const hand& firstHand,const hand& secondHand)
{
	hand::size_type i;
	for(i = firstHand.size()-1; i < firstHand.size(); i--)
		if (firstHand[i].first > secondHand[i].first)
			return -1;
		else if (firstHand[i].first < secondHand[i].first)
			return 1;
	return 0;
}

// Hands which both contain a straight are ranked by their highest card.
int compareStraight(const hand& firstHand, const hand& secondHand)
{
	hand::size_type i =  firstHand.size()-1;
	if (firstHand[i].first > secondHand[i].first)
		return -1;
	else if (firstHand[i].first < secondHand[i].first)
		return 1;
	return 0;
}

// Hands which both contain three of a kind are ranked by the value of the 3 cards.
int compareThreeOfAKind(const hand& firstHand, const hand& secondHand)
{
	int iCount(0), firstSum(0), secondSum(0);
	hand::size_type i;

	for(i = 1; i < firstHand.size(); i++)
		if (firstHand[i-1].first == firstHand[i].first)
		{
			if (iCount == 0)
				firstSum += firstHand[i-1].first + firstHand[i].first;
			else
				firstSum += firstHand[i].first;
			iCount++;
		}

	iCount = 0;

	for(i = 1; i < secondHand.size(); i++)
		if (secondHand[i-1].first == secondHand[i].first)
		{
			if(iCount == 0)
				secondSum += secondHand[i-1].first + secondHand[i].first;
			else
				secondSum += secondHand[i].first;
			iCount++;
		}

	if (firstSum > secondSum)
		return -1;
	else if (firstSum < secondSum)
		return 1;
	return 0;
}

//  Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the value of their other pair. 
//  If these values are the same the hands are ranked by the value of the remaining card.
int compareTwoPairs(hand& firstHand, hand& secondHand)
{
	hand::size_type i, fFirstIndex,fSecondIndex;
	int firstSum(0), secondSum(0);
	for(i = firstHand.size()-2; i < firstHand.size()-1; i--)
		if(firstHand[i].first == firstHand[i+1].first)
		{
			fFirstIndex = i;
			break;
		}
	for(i = secondHand.size()-2; i < secondHand.size()-1; i--)
		if(secondHand[i].first == secondHand[i+1].first)
		{
			fSecondIndex = i;
			break;
		}

	firstSum = (firstHand[fFirstIndex].first+firstHand[fFirstIndex+1].first);
	secondSum = (secondHand[fSecondIndex].first+secondHand[fSecondIndex+1].first);
	if (firstSum > secondSum)
		return -1;
	else 
		if (firstSum < secondSum)
			return 1;
		else
		{
			firstHand.erase(firstHand.begin()+fFirstIndex,firstHand.begin()+fFirstIndex+2);
			secondHand.erase(secondHand.begin()+fSecondIndex,secondHand.begin()+fSecondIndex+2);
			for(i = firstHand.size()-2; i < firstHand.size()-1; i--)
				if(firstHand[i].first == firstHand[i+1].first)
				{
					fFirstIndex = i;
					break;
				}
			for(i = secondHand.size()-2; i < secondHand.size()-1; i--)
				if(secondHand[i].first == secondHand[i+1].first)
				{
					fSecondIndex = i;
					break;
				}

			firstSum = (firstHand[fFirstIndex].first+firstHand[fFirstIndex+1].first);
			secondSum = (secondHand[fSecondIndex].first+secondHand[fSecondIndex+1].first);

			if (firstSum > secondSum)
				return -1;
			else 
				if (firstSum < secondSum)
					return 1;
				else
				{
					firstHand.erase(firstHand.begin()+fFirstIndex,firstHand.begin()+fFirstIndex+2);
					secondHand.erase(secondHand.begin()+fSecondIndex,secondHand.begin()+fSecondIndex+2);
					for(i = secondHand.size()-1; i < secondHand.size(); i--)
						if (firstHand[i].first > secondHand[i].first)
							return -1;
						else 
							if (firstHand[i].first < secondHand[i].first)
								return 1;
				}
					
		}
	return 0;
}

// Hands which both contain a pair are ranked by the value of the cards forming the pair. 
// If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.
int comparePair(hand& firstHand, hand& secondHand)
{
	hand::size_type i, fFirstIndex, fSecondIndex;
	int firstSum(0), secondSum(0);
	for(i = firstHand.size()-2; i < firstHand.size(); i--)
		if(firstHand[i].first == firstHand[i+1].first)
		{
			fFirstIndex = i;
			break;
		}
	for(i = secondHand.size()-2; i < secondHand.size()-1; i--)
		if(secondHand[i].first == secondHand[i+1].first)
		{
			fSecondIndex = i;
			break;
		}

	firstSum = (firstHand[fFirstIndex].first+firstHand[fFirstIndex+1].first);
	secondSum = (secondHand[fSecondIndex].first+secondHand[fSecondIndex+1].first);

	if (firstSum > secondSum)
		return -1;
	else 
		if (firstSum < secondSum)
			return 1;
		else
		{
			firstHand.erase((firstHand.begin()+fFirstIndex),(firstHand.begin()+(fFirstIndex+2)));
			secondHand.erase((secondHand.begin()+fSecondIndex),(secondHand.begin()+(fSecondIndex+2)));
			for(i = secondHand.size()-1; i < secondHand.size(); i--)
				if (firstHand[i].first > secondHand[i].first)
					return -1;
				else 
					if (firstHand[i].first < secondHand[i].first)
						return 1;
		}
	
	return 0;
}

// Hands which do not fit any higher category are ranked by the value of their highest card. 
// If the highest cards have the same value, the hands are ranked by the next highest, and so on.
int compareHighest(hand& firstHand, hand& secondHand)
{
	hand::size_type i;
	for(i = firstHand.size()-1; i < firstHand.size(); i--)
		if (firstHand[i].first > secondHand[i].first)
			return -1;
		else if (firstHand[i].first < secondHand[i].first)
			return 1;
	return 0;
}

int compare(int rank, hand& firstHand, hand& secondHand)
{
	switch(rank)
	{
	case 9:	// str flush
		return compareStraightFlush(firstHand, secondHand);
	case 8: // 4 of kind
		return compareFourOfAKind(firstHand, secondHand);
	case 7: // full house
		return compareFullHouse(firstHand, secondHand);
	case 6: // flush
		return compareFlush(firstHand, secondHand);
	case 5: // straight
		return compareStraight(firstHand, secondHand);
	case 4: // 3 of kind
		return compareThreeOfAKind(firstHand, secondHand);
	case 3: // two pairs
		return compareTwoPairs(firstHand, secondHand);
	case 2: // pair
		return comparePair(firstHand, secondHand);
	case 1: // highest
		return compareHighest(firstHand, secondHand);
	}
	return 0;
}

void calculate()
{
	int n = 0, winner;
	std::string temp;
	while(n < 10)
	{
		std::cin >> temp;
		if(n < 5)
			gFirstHand.push_back(covertToPair(temp));
		else
			gSecondHand.push_back(covertToPair(temp));
		n++;
	}
	std::cin.ignore();
	std::sort(gFirstHand.begin(), gFirstHand.end(), sortFunc);
	std::sort(gSecondHand.begin(), gSecondHand.end(), sortFunc);

	gFirstHandRank = getRank(gFirstHand);
	gSecondHandRank = getRank(gSecondHand);

	if (gFirstHandRank != gSecondHandRank)
	{
		if (gFirstHandRank > gSecondHandRank)
			std::cout << "Black wins." << std::endl;
		else
			std::cout << "White wins." << std::endl;
	}
	else
	{
		winner = compare(gFirstHandRank, gFirstHand, gSecondHand);
		switch(winner)
		{
		case 1:
			std::cout << "White wins." << std::endl;
			break;
		case -1:
			std::cout << "Black wins." << std::endl;
			break;
		case 0:
			std::cout << "Tie." << std::endl;
			break;
		}
	}

	clearHands();
}

int main(int argc, char* argv[])
{
	openFile();
	int i(0);
	while(!std::cin.eof())
	{
		calculate();
	}
} 
