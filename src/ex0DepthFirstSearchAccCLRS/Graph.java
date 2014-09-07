package ex0DepthFirstSearchAccCLRS;

import java.util.*;


public class Graph<E> {

    //Map to store vertices so we can use same vertices for our graph
    Map<E, Node<E>> map = new HashMap<E, Node<E>>();
    Map<E, List<Node<E>>> graph = new HashMap<E, List<Node<E>>>();

    int time=0;
    class Node<E> {
        E value;
        char colour;
        int distance;
        int time;
        Node predecessor;


        Node(E value) {
            this.value = value;
            this.colour = 'W';
            this.distance = Integer.MIN_VALUE;
            this.predecessor = null;

        }


    }



    void createGraph(E start, E end) {
        Node<E> startNode = getVertex(start);
        Node<E> endNode = getVertex(end);
        if (graph.containsKey(start)) {

            graph.get(start).add(endNode);
        } else {
            ArrayList<Node<E>> temp = new ArrayList<Node<E>>();
            temp.add(startNode);
            temp.add(endNode);
            graph.put(start, temp);
        }
        if (graph.containsKey(end)) {
            graph.get(end).add(startNode);
        } else {
            ArrayList<Node<E>> temp = new ArrayList<Node<E>>();
            temp.add(endNode);
            temp.add(startNode);
            graph.put(end, temp);
        }
    }

    private Node<E> getVertex(E node) {
        Node<E> startNode = null;
        if (map.containsKey(node)) {
            startNode = map.get(node);

        } else {
            startNode = new Node<E>(node);
            map.put(node, startNode);

        }
        return startNode;
    }

    void printGraph() {
        Set<E> set = graph.keySet();
        Iterator<E> it = set.iterator();
        while (it.hasNext()) {
            Iterator<Node<E>> it1 = graph.get(it.next()).iterator();
            while (it1.hasNext()) {
                Node<E> temp = it1.next();
                System.out.print("---->>"+temp.value + "---" + temp.colour +"-----"  + temp.time +"--->>" );
            }
            System.out.println();
        }


    }

    void DFS(){
        Iterator<E> it=map.keySet().iterator();
        while(it.hasNext()){
            Node<E> temp= map.get(it.next());
            if(temp.colour=='W'){
                DFSUtil(temp.value);
            }


        }

    }

    void DFSUtil(E key) {
        Node<E> parent=map.get(key);
        System.out.println(key);
        time=time+1;
        Iterator<Node<E>> it1 = graph.get(key).iterator();
        Node<E> temp = it1.next();
        temp.predecessor = null;
        temp.colour = 'G';
        temp.distance = 0;
        Iterator<Node<E>> it2 = graph.get(key).iterator();
            while (it2.hasNext()) {
                Node<E> temp3 = it2.next();
                if (temp3.colour == 'W') {
                    temp3.predecessor =parent;

                    DFSUtil(temp3.value);

                }
            }

        time=time+1;
        parent.time=time;
       stack.push(key);


    }

    Stack<E> stack=new Stack<>();
    void printStack() {
        System.out.println("stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());

        }

    }



    public static void main(String arg[]) {

        Graph<Integer> gp = new Graph<Integer>();

        gp.createGraph(1, 2);
        gp.createGraph(4, 1);
        gp.createGraph(2, 3);
        gp.createGraph(3, 1);
        gp.createGraph(4, 3);
       /* gp.createGraph(0, 1);
        gp.createGraph(0, 2);
        gp.createGraph(0, 3);
        gp.createGraph(2, 3);
        gp.createGraph(3, 4);
        gp.createGraph(4, 0);*/

       gp.DFS();
       // gp. DFSUtil(2);
        gp.printGraph();
        gp.printStack();
    }


}
