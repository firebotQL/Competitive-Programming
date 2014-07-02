import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		int n, m, i, val, k, v;
		Integer index = null;
		String line;
		String[] split;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Map<Integer, Integer>> adjacencyList = new HashMap<Integer, Map<Integer, Integer>>();
		Map<Integer, Integer> tempMap;
		StringTokenizer st = null;
		StringBuilder sb  = null;
		while((line = reader.readLine()) != null) {
			sb = new StringBuilder(1000000);
			st = new StringTokenizer(line);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(reader.readLine());
			for(i = 0; i < n; i++) {
				val = Integer.parseInt(st.nextToken());
				tempMap = adjacencyList.get(val);
				if (tempMap == null) {
					tempMap = new HashMap<Integer, Integer>();
					adjacencyList.put(val, tempMap);
				}
				tempMap.put(tempMap.size()+1, i+1);
			}
			
			for(i = 0; i < m; i++) {
				st = new StringTokenizer(reader.readLine());
				k = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				tempMap = adjacencyList.get(v);
				if (tempMap != null) {
					index = tempMap.get(k);
					if (index != null) {
						sb.append(index).append("\n");
					} else {
						sb.append(0).append("\n");
					}  
				} else {
					sb.append(0).append("\n");
				}				
			}
			System.out.print(sb.toString());
			adjacencyList.clear();
		}
		
	}
}