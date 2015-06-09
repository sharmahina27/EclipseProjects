import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


public class Graph {
	private Map<Integer, LinkedList<Integer>> adjacency_list;
	private int number_of_vertices;
	
	public Graph(int V) {
		number_of_vertices = V;
		adjacency_list = new HashMap<Integer, LinkedList<Integer>>();
		for(int i = 1 ; i <= number_of_vertices; i++){
			adjacency_list.put(i, new LinkedList<Integer>());
		}
	}
	
	public Map<Integer, LinkedList<Integer>> getAdjacencyList() {
		return adjacency_list;
	}
	
	public int getNumberOfVertices() {
		return number_of_vertices;
	}
	
	public void setEdge(int source, int destination){
		if(source > adjacency_list.size() || destination > adjacency_list.size()) {
			System.out.println("The vertex is not present");
			return;
		}
		LinkedList<Integer> slist = adjacency_list.get(source);
		slist.add(destination);
		LinkedList<Integer> dlist = adjacency_list.get(destination);
		dlist.add(source);
	}
	
	public LinkedList<Integer> getEdge(int source) {
		if(source > adjacency_list.size()){
			System.out.println("The vertex is not present");
			return null;
		}
		return adjacency_list.get(source);
	}
	
	public void printAdjacancyList(int number_of_vertices) {
		for(int i = 1; i <= number_of_vertices; ++i){
			System.out.print(i+"->");
			LinkedList<Integer>edgeList = adjacency_list.get(i);
			for(int j = 1; ; ++j){
				if(j != edgeList.size()){
					System.out.print(edgeList.get(j-1)+"->");
				}else {
					System.out.print(edgeList.get(j-1));
					break;
				}
			}
			System.out.println();
		}
	
	}
	
	public void populateGraph() {
		//Graph sampleGraph = new Graph(4);
		this.setEdge(1, 2);
		this.setEdge(2, 3);
		this.setEdge(3, 4);
		this.setEdge(4, 1);
		this.setEdge(1, 3);
	}

	public void DFShelper(int start, boolean[] visited) {
		visited[start] = true;
		System.out.println(start);

		LinkedList<Integer> adj= adjacency_list.get(start);
		ListIterator<Integer> it = adj.listIterator();
		while(it.hasNext()) {
			int nextVertex = it.next();
			if(!visited[nextVertex]){
				DFShelper(nextVertex, visited);
			}
		}
	}
	public void DFS(int v) {
		boolean[] visited = new boolean[number_of_vertices+1];
		for(int i = 0 ; i <= number_of_vertices; ++i){
			visited[i] = false;
		}
		DFShelper(v,visited);
	}
   
	public void BFS(int startVertex) {
		Queue<Integer> bfs_queue = new LinkedList<Integer>();
		boolean[] visited  = new boolean[number_of_vertices+1];
		for(int i = 0 ; i <= number_of_vertices ; ++i) {
			visited[i] = false;
		}
		visited[startVertex] = true;
		bfs_queue.add(startVertex);
		LinkedList<Integer> adj_list;
		while(!bfs_queue.isEmpty()) {
			int node = bfs_queue.remove();
			System.out.println(node);
			adj_list = adjacency_list.get(node);
			ListIterator<Integer> iterator = adj_list.listIterator();
			while(iterator.hasNext()) {
				int nextVertex = iterator.next();
				if(!visited[nextVertex]) {
					bfs_queue.add(nextVertex);
					visited[nextVertex] = true;
				}
			}
		}
	}
	
	public static void main(String[] args){
		Graph g = new Graph(4);
		g.populateGraph();
		//g.printAdjacancyList(4);
		//g.DFS(1);
		g.BFS(4);
		/*int source, destination;
		int number_of_edges, number_of_vertices;
		int count=1;
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Enter number of vertices and edges in the graph.");
			number_of_vertices= scan.nextInt();
			number_of_edges = scan.nextInt();
			Graph adjacencyList = new Graph(number_of_vertices);
			 System.out.println("Enter the edges in graph Format : <source index> <destination index>");
             while (count <= number_of_edges)
             {
                 source = scan.nextInt();
                 destination = scan.nextInt();
                 adjacencyList.setEdge(source, destination);
                 count++;
             }
             adjacencyList.printAdjacancyList(number_of_vertices);
		}catch(InputMismatchException inputMismatch)
        {
            System.out.println("Error in Input Format. \nFormat : <source index> <destination index>");
        }
        scan.close();*/
		
	}
	
}
