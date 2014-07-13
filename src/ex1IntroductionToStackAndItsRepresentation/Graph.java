package ex1IntroductionToStackAndItsRepresentation;

import java.util.Arrays;

public class Graph<E extends Number> {

	/*Graph is a data structure that consists of following two components:
		1. A finite set of vertices also called as nodes.
		2. A finite set of ordered pair of the form (u, v) called as edge. 
		The pair is ordered because (u, v) is not same as (v, u) in case of directed graph(di-graph). 
		The pair of form (u, v) indicates that there is an edge from vertex u to vertex v. 
		The edges may contain weight/value/cost.

		Graphs are used to represent many real life applications: 
			Graphs are used to represent networks. The networks may include paths in a city or telephone network or circuit network. 
			Graphs are also used in social networks like linkedIn, facebook. 
			For example, in facebook, each person is represented with a vertex(or node). 
			Each node is a structure and contains information like person id, name, gender and locale. 
			This can be easily viewed as below. See this for more applications of graph http://en.wikipedia.org/wiki/Graph_theory#Applications.
{
   "id": "100000294527100",
   "first_name": "Amit",
   "gender": "male",
   "last_name": "Jambotkar",
   "link": "https://www.facebook.com/Amit.Jambotkar",
   "locale": "en_US",
   "name": "Amit Jambotkar",
   "username": "Amit.Jambotkar"
}
		
	Following two are the most commonly used representations of graph.
1. Adjacency Matrix
2. Adjacency List
There are other representations also like, Incidence Matrix and Incidence List. The choice of the graph representation is situation specific. It totally depends on the type of operations to be performed and ease of use.

Adjacency Matrix:
Adjacency Matrix is a 2D array of size V x V where V is the number of vertices in a graph. 
Let the 2D array be adj[][], a slot adj[i][j] = 1 indicates that there is an edge from vertex i to vertex j. 
Adjacency matrix for undirected graph is always symmetric. 
Adjacency Matrix is also used to represent weighted graphs.
If adj[i][j] = w, then there is an edge from vertex i to vertex j with weight w.

Pros: Representation is easier to implement and follow. Removing an edge takes O(1) time. 
Queries like whether there is an edge from vertex ‘u’ to vertex ‘v’ are efficient and can be done O(1).

Cons: Consumes more space O(V^2). 
Even if the graph is sparse(contains less number of edges), 
it consumes the same space. Adding a vertex is O(V^2) time.



Adjacency List:
An array of linked lists is used. 
Size of the array is equal to number of vertices. Let the array be array[].
An entry array[i] represents the linked list of vertices adjacent to the ith vertex.
This representation can also be used to represent a weighted graph.
The weights of edges can be stored in nodes of linked lists.    
	*/

	//The below code shows how Adjacency List are implemented.You can write this in different ways using collection.
    //I am explaining without any collection
	Node<E> nodeArr[]=null;
	class Node<E>{
		E value;
		Node<E> nextRef;
		Node(){
			
		}
		Node(E value){
			this.value=value;
			nextRef=null;
			
		}
	}
	
@SuppressWarnings("unchecked")
void 	createGraph(int value){
	//prefer list over arrays
	//nodeArr=(Node<E>[]) new Number[value];
	nodeArr = (Node<E>[]) new Node[value];
		
	}

void addEdge(E x,E y){
//I am giving logic for int for others you may need to modify code or write it in diff manner.
Node<E>temp=new Node<E>(y);
temp.nextRef=nodeArr[x.intValue()];
nodeArr[x.intValue()]=temp;
//This is non directed graph so we will do same for y
temp=new Node<E>(x);
temp.nextRef=nodeArr[y.intValue()];
nodeArr[y.intValue()]=temp;
}
	
void printGraph(){
for(int i=0;i<nodeArr.length;i++){
	Node<E> temp=nodeArr[i];
	while(temp!=null){
		System.out.print(temp.value);
		temp=temp.nextRef;
	}
	System.out.println();
	System.out.println("Next");
	
}
	
}


	//You can try to store vertexes in to List or in this way Map<E,List<E>>
	public static void main(String[] args) {
     Graph<Integer> graph=new Graph<>();
     graph.createGraph(5);
    
     graph.addEdge( 0, 1);
     graph. addEdge( 0, 4);
     graph. addEdge( 1, 2);
     graph. addEdge( 1, 3);
     graph. addEdge( 1, 4);
     graph. addEdge( 2, 3);
     graph. addEdge( 3, 4);
	graph.printGraph();
	}
}
