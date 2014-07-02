#include <cstdio>
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <numeric>
#include <map>

struct candidate
{
	std::string name;
	unsigned int votes;
	bool eliminated;
};

std::vector<candidate> gCandidates;
std::vector<std::vector<unsigned int> > gBallots;

inline void openFile()
{
#ifndef ONLINE_JUDGE
	freopen("test.in", "r", stdin);
#endif
}

void clearVotes()
{
	for(std::vector<candidate>::size_type i = 0; i < gCandidates.size(); i++)
		if(!gCandidates[i].eliminated)
			gCandidates[i].votes = 0;
}

int compute()
{
	unsigned int totalVotes = gBallots.size(); // Calculating total votes
	unsigned int i,j;
	int maxVotes, minVotes;
	int votes, maxIndex, minIndex;
	while(true)
	{
		maxVotes = -9999;
		minVotes = 9999;
		j = 0;
		// Clearing votes,lowest candidate list
		clearVotes();

		// Setting votes for candidates
		for(i = 0; i < gBallots.size(); i++, j=0)
		{
			while(gCandidates[gBallots[i][j]-1].eliminated && j < gBallots[i].size())
				j++;
			if(!gCandidates[gBallots[i][j]-1].eliminated)
				gCandidates[gBallots[i][j]-1].votes++;
		}


		for(i = 0 ; i < gCandidates.size(); i++)
		{
			votes = gCandidates[i].votes;
			if(!gCandidates[i].eliminated)
			{
				if(maxVotes<votes)
				{
					maxVotes = votes; 
					maxIndex = i;
				}
				if (minVotes>votes)
				{
					minVotes = votes; 
					minIndex = i;
				}
			}
		}

		// Max case
		if (totalVotes/2 < maxVotes)
			return maxIndex;

		// Tied case
		if (maxVotes == minVotes)
			return -1;	

		for(i = 0; i < gCandidates.size(); i++)
		{
			if(gCandidates[i].votes == minVotes)
			{
				gCandidates[i].eliminated = true;
			}
		}

	}
	return 0;
}

void print(int i)
{
	switch(i)
	{
	case -1:
		for(unsigned int i = 0; i < gCandidates.size(); i++)
			if(!gCandidates[i].eliminated)
				std::cout << gCandidates[i].name << std::endl;
		break;
	default:
		std::cout << gCandidates[i].name << std::endl;
		break;
	}
}

void computeCase()
{
	int i,n,x,y;
	std::cin >> i;
	bool bReading;
	std::vector<unsigned int> votes;
	candidate tempCandidate;
	// Iterating through all cases
	while(i--)
	{
		std::cin >> n;
		x = n;
		std::cin.ignore();
		// Iterating through candidates (names)
		for(y = 0; y < n; y++)
		{
			std::getline(std::cin, tempCandidate.name);
			tempCandidate.votes = 0;
			tempCandidate.eliminated = false;
			gCandidates.push_back(tempCandidate);
		}
		// Iterating through votes
		while(true)
		{
			if (std::cin.peek() != '\n' && std::cin.peek() != EOF)
			{
				bReading = true;
				votes.assign(n,0);
				for(y = 0; y < n; y++)
					std::cin >> votes[y];
				gBallots.push_back(votes);
			}
			else
			{
				if (bReading) 
				{
					std::cin.ignore();
					bReading = false;
				}
				else
				{
					std::cin.ignore();
					break;
				}
			}
		}

		print(compute());
		if (i > 0)
			std::cout << std::endl;
		gCandidates.clear();
		gBallots.clear();

	}
}

int main(int argc, char *argv[])
{
	openFile();
	computeCase();
	return 0;
}
