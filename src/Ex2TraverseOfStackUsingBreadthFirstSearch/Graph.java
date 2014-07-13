package Ex2TraverseOfStackUsingBreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph<E> {
	// In BreadthFirstSearch we are traversing adjacent edges first.
	// We put each vertex in queue for later traverse and current vertex we pop
	// from queue and print it.
	// Here we are using HashMap To store nodes.Where each vertex becomes a Key
	// and adjacent vertexes are stored in List.
	HashMap<E, ArrayList<E>> graph = new HashMap<>();

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

	// Queue for traverse
	Queue<E> queue = new LinkedList<>();
	// Forest to store visited vertex
	ArrayList<E> forest = new ArrayList<>();

	void breadthFirstSearchOfGraph(E value) {
		//store current value in a forest.
		forest.add(value);
		//Add same to queue
		queue.add(value);
		while (!queue.isEmpty()) {
			value = queue.poll();
			System.out.println(value);
			if (graph.containsKey(value)) {
				//Iterator for adjacent vertices.
				ArrayList<E> list = graph.get(value);
				Iterator<E> iterator = list.iterator();
				while (iterator.hasNext()) {
					value = iterator.next();
					if (!forest.contains(value)) {
						//add adjacent vertices which are not visited and mark them as visited using forest list
						queue.add(value);
						forest.add(value);
					}

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
		g.breadthFirstSearchOfGraph(2);
	}

}
