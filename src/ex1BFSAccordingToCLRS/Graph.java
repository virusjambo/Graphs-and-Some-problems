package ex1BFSAccordingToCLRS;

import java.util.*;


public class Graph<E> {

    class Node<E> {
        E value;
        char colour;
        int distance;
        Node predecessor;

        Node(E value) {
            this.value = value;
            this.colour = 'W';
            this.distance = Integer.MIN_VALUE;
            this.predecessor = null;

        }
    }

    Map<E, List<Node<E>>> graph = new HashMap<E, List<Node<E>>>();


    void createGraph(E start, E end) {
        Node<E> startNode = new Node<E>(start);
        Node<E> endNode = new Node<E>(end);

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

    Queue<Node<E>> queue = new LinkedList<>();

    void BFS(E key) {
        Iterator<Node<E>> it1 = graph.get(key).iterator();
        Node<E> temp = it1.next();
        temp.predecessor = null;
        temp.colour = 'G';
        temp.distance = 0;
        queue.add(temp);
        while (!queue.isEmpty()) {
            Node<E> temp1 = queue.poll();
            Iterator<Node<E>> it2 = graph.get(temp1.value).iterator();
            while (it2.hasNext()) {
                Node<E> temp3 = it2.next();
                if (temp3.colour == 'W') {
                    temp3.predecessor = temp1;
                    temp3.colour = 'G';
                    temp3.distance = temp1.distance + 1;
                    queue.add(temp3);
                }
            }


        }


    }


    void printGraph() {
        Set<E> set = graph.keySet();
        Iterator<E> it = set.iterator();
        while (it.hasNext()) {
            Iterator<Node<E>> it1 = graph.get(it.next()).iterator();
            while (it1.hasNext()) {
                Node<E> temp = it1.next();
                System.out.print(temp.value + "" + temp.colour + temp.distance + " ----");
            }
            System.out.println();
        }


    }

    public static void main(String arg[]) {

        Graph<Integer> gp = new Graph<Integer>();
        gp.createGraph(0, 1);
        gp.createGraph(0, 2);
        gp.createGraph(0, 3);
        gp.createGraph(2, 3);
        gp.createGraph(3, 4);
        gp.createGraph(4, 0);

        gp.BFS(0);
        gp.printGraph();
    }
}