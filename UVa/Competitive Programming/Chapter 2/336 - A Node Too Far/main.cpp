#include <cstdio>
#include <iostream>
#include <vector>
#include <queue>
#include <map>

inline void openFile()
{
	#ifndef ONLINE_JUDGE
		freopen("test.in", "r", stdin);
		freopen("test.out", "w", stdout);
	#endif
}

char answer[] = { "Case %d: %d nodes not reachable from node %d with TTL = %d.\n" };

void FillGraph(std::map<int, std::vector<int> > & G, int NC, std::map<int, int>& distance)
{
	int node1, node2;
	G.clear();
	while(NC--)
	{
		scanf("%d %d", &node1, &node2);
		if (!distance[node1]) distance[node1] = -1;
		if (!distance[node2]) distance[node2] = -1;
		G[node1].push_back(node2);
		G[node2].push_back(node1);
	}
}

void printQueue(std::queue<int> q)
{
	while(!q.empty())
	{
		printf("%d ", q.front());
		q.pop();
	}
	printf("\n");
}
int CountNotReachableUsingBFS(std::map<int, std::vector<int> > &G,
				std::map<int, int>& distance,
				int root_node,
				int TTL)
{
	std::queue<int> q;
	std::map<int, bool> used;
	q.push(root_node);
	used[root_node] = true;
	distance[root_node] = 0;
	int cnode, qnode, count(0);
	std::vector<int>::size_type i;
	while(!q.empty())
	{
		qnode = q.front();
		q.pop();

		for(i = 0; i < G[qnode].size(); ++i)
		{
			cnode = G[qnode][i];
			if (!used[cnode])
			{
				used[cnode] = true;
				distance[cnode] = distance[qnode] + 1;
				q.push(cnode);
			}
		}
		
	}
	for(std::map<int, int>::iterator it = distance.begin(); it != distance.end(); ++it)
	{
		if (it->second == -1 || it->second > TTL)
			count++;
		it->second = -1;
	}
	return count;
}

int main(int argc, char* argv[])
{
	std::map<int, std::vector<int> > G;	// Graph
	std::map<int, int> distance;
	int NC, root_node, TTL, case_count(1), not_reachable_count;
	openFile();
	// Iterating through all graphs
	// and calculating node
	while (std::cin >> NC && NC)
	{
		FillGraph(G, NC, distance);
		
		while(std::cin >> root_node >> TTL &&
			 (root_node || TTL))
		{		
			//printf("root node: %d ; ttl: %d\n", root_node, TTL);	
			// Walking through graph with BFS algorithm
			not_reachable_count = CountNotReachableUsingBFS(G, distance, root_node, TTL);
			printf(answer, case_count++, not_reachable_count, root_node, TTL);
		}
		G.clear();
		distance.clear();
		
	}
	
	return 0;
}
