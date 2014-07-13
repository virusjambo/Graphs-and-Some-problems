package Ex3DepthFirstSearchOnGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/*Depth First Traversal (or Search) for a graph is similar to Depth First Traversal of a tree. The only catch here is, unlike trees, 
 graphs may contain cycles, so we may come to the same node again. To avoid processing a node more than once, we use a boolean visited array. 
 For example, in the following graph, we start traversal from vertex 2. When we come to vertex 0, we look for all adjacent vertices of it.
 2 is also an adjacent vertex of 0. If we don’t mark visited vertices, then 2 will be processed again and it will become a non-terminating process. 
 Depth First Traversal of the following graph is 2, 0, 1, 3*/
//http://d2o58evtke57tz.cloudfront.net/wp-content/uploads/DFS.jpg
//you can see image at above link

/*Depth-first search (DFS) is an algorithm (or technique) for traversing a graph.

 Following are the problems that use DFS as a bulding block.

 1) For an unweighted graph, DFS traversal of the graph produces the minimum spanning tree and all pair shortest path tree.

 2) Detecting cycle in a graph 
 A graph has cycle if and only if we see a back edge during DFS. So we can run DFS for the graph and check for back edges. 

 3) Path Finding
 We can specialize the DFS algorithm to find a path between two given vertices u and z.
 i) Call DFS(G, u) with u as the start vertex.
 ii) Use a stack S to keep track of the path between the start vertex and the current vertex.
 iii) As soon as destination vertex z is encountered, return the path as the
 contents of the stack



 4) Topological Sorting


 5) To test if a graph is bipartite
 We can augment either BFS or DFS when we first discover a new vertex, color it opposited its parents, 
 and for each other edge, check it doesn’t link two vertices of the same color. 
 The first vertex in any connected component can be red or black!


 6) Finding Strongly Connected Components of a graph A directed graph is called strongly connected if there is a path 
 from each vertex in the graph to every other vertex. 

 7) Solving puzzles with only one solution, such as mazes. 
 (DFS can be adapted to find all solutions to a maze by only including nodes on the current path in the visited set.)

 Sources:
 http://www8.cs.umu.se/kurser/TDBAfl/VT06/algorithms/LEC/LECTUR16/NODE16.HTM
 http://en.wikipedia.org/wiki/Depth-first_search
 http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/GraphAlgor/depthSearch.htm
 http://ww3.algorithmdesign.net/handouts/DFS.pdf
 */
public class Graph<E> {
	HashMap<E, ArrayList<E>> graph = new HashMap<>();
	ArrayList<E> forest = new ArrayList<>();

	void addEdge(E value, E value1) {
		ArrayList<E> list;
		if (!graph.containsKey(value)) {
			list = new ArrayList<>();
			list.add(value);
			list.add(value1);
			graph.put(value, list);

		} else {
			list = graph.get(value);
			list.add(value1);

		}

	}

	void DFS(E value) {
		forest.add(value);
		System.out.println(value);
		if (graph.containsKey(value)) {
			// Iterator for adjacent vertices.
			ArrayList<E> list = graph.get(value);
			Iterator<E> iterator = list.iterator();
			while (iterator.hasNext()) {
				value = iterator.next();
				if (!forest.contains(value)) {
					// Recurse adjacent nodes
					DFS(value);

				}

			}
		}

	}

	public static void main(String[] args) {
		Graph<Integer> g = new Graph<Integer>();
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		g.DFS(2);
	}

}
