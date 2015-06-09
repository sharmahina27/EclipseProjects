import java.awt.print.Book;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import javax.swing.text.html.HTMLDocument.Iterator;


public class DFS {
	Stack<Integer> dfs_stack;
	boolean[] visited;
	
	public DFS() {
		dfs_stack = new Stack<Integer>();
		
	}
	
	public void DFSTraversal(int startNode, int V) {
		visited = new boolean[V];
		for(int i = 0 ; i < V ; ++i){
			visited[i] = false;
		}
		
		
		
		visited[startNode] = true;
		System.out.println(startNode);
		
		}
		
	}
	
	/*public static void main(String[] args){
		Graph g = new Graph(4);
		g.populateGraph();
		g.printAdjacancyList(4);
		Map<Integer, LinkedList<Integer>> adjList = g.getAdjacencyList(); 
		DFS dfs = new DFS();
		
		
		
	}*/

