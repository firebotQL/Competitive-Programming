
using namespace std;

bool matrix[30 + 3] [30 + 3];

void reset()
{
	for(int i = 0; i < 33; i++)
		memset(matrix[i], false, sizeof(matrix[i]));
}

int main()
{
	int edges;
	int cases = 0;

	while(cin >> edges && edges)
	{
		reset();
		
		map<int, int> index;
		int nodeNumber = 1;
		for(int i = 0; i < edges; i++)
		{
			int a, b;
			cin >> a >> b;
			if (!index[a]) index[a] = nodeNumber++;
			if (!index[b]) index[b] = nodeNumber++;

			matrix[index[a]][index[b]] = matrix[index[b]][index[a]] = true;
		}
		
		int queryNode;
		int ttl;
		int dist[30 + 3];

		while(cin >> queryNode >> ttl)
		{
			if (queryNode == 0 && ttl == 0) break;
			
			memset(dist, -1, sizeof(dist));

			dist[index[queryNode]] = 0;
			
			queue<int> q;
			q.push(index[queryNode]);

			while(!q.empty())
			{
				int pop = q.front();
				q.pop();
				
				for(int i = 1; i < nodeNumber; i++)
					if(matrix[pop][i] && dist[i] == -1)
					{
						dist[i] = dist[pop] + 1;
						q.push(i);
					}
			}
		}
	}
}
