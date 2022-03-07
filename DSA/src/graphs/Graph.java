package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

    // Hashmap of vertices
    // Key = Name of current vertex
    // Value = Address of Vertex class containing neighbors of current vertex
    HashMap<String, Vertex> vertices;

    private class Vertex {
        // Hashmap of neighbors
        // Key = neighbor vertex name
        // Value = Cost of edge between current vertex and respective neighbor
        HashMap<String, Integer> neighbors = new HashMap<>();
    }

    // empty constructor
    public Graph() {
        this.vertices = new HashMap<>();
    }

    public int numberOfVertices() {
        return this.vertices.size();
    }

    public boolean containsVertex(String vertexName) {
        return this.vertices.containsKey(vertexName);
    }

    public void addVertex(String vertexName) {
        // Empty neighbors hashmap
        Vertex vertex = new Vertex();

        // A distinct vertex initially
        vertices.put(vertexName, vertex);
    }

    public void removeVertex(String vertexName) {
        // Reference to given vertex name
        Vertex vertex = this.vertices.get(vertexName);

        // If vertex does not exist
        if (vertex == null)
            return;

        // -- vertex exists --
        // List of all neighbors names of given vertex
        ArrayList<String> neighborsNames = new ArrayList<>(vertex.neighbors.keySet());

        // Visit each neighbors' neighbor hashmap
        // remove given vertex from their hashmap
        for (String neighbor : neighborsNames) {
            this.vertices.get(neighbor).neighbors.remove(vertexName);
        }

        // remove given vertex from vertices hashmap
        this.vertices.remove(vertexName);
    }

    public int numberOfEdges() {
        // List of all vertices names
        ArrayList<String> keys = new ArrayList<>(this.vertices.keySet());

        // counter of edges
        int count = 0;

        // for each key
        for (String key : keys) {
            // Vertex class address of corresponding vertex name
            Vertex vertex = vertices.get(key);

            // Adding number of edges connected to a particular vertex
            count += vertex.neighbors.size();
        }

        // As each edge is added two times
        return count / 2;
    }

    public boolean containsEdge(String vertex1, String vertex2) {
        // References to vertices of given names
        Vertex vtx1 = this.vertices.get(vertex1);
        Vertex vtx2 = this.vertices.get(vertex2);

        // returns true if both vertices exist and one lies in others' neighbours hashmap
        return vtx1 != null && vtx2 != null && vtx1.neighbors.containsKey(vertex2);
    }

    public void addEdge(String vertex1, String vertex2, int cost) {
        // References to vertices of given names
        Vertex vtx1 = this.vertices.get(vertex1);
        Vertex vtx2 = this.vertices.get(vertex2);

        // If vertices don't exist, or they are ALREADY NEIGHBORS(i.e. edge already exists)
        if (vtx1 == null || vtx2 == null || vtx1.neighbors.containsKey(vertex2))
            return;

        // -- Both vertices exist and are not already neighbors --
        // Make neighbors of each other
        vtx1.neighbors.put(vertex2, cost);
        vtx2.neighbors.put(vertex1, cost);
    }

    public void removeEdge(String vertex1, String vertex2) {
        // References to vertices of given names
        Vertex vtx1 = this.vertices.get(vertex1);
        Vertex vtx2 = this.vertices.get(vertex2);

        // If vertices don't exist or they are not neighbors
        if (vtx1 == null || vtx2 == null || !vtx1.neighbors.containsKey(vertex2))
            return;

        // -- Both vertices exist and are already neighbors --
        // Make neighbors of each other
        vtx1.neighbors.remove(vertex2);
        vtx2.neighbors.remove(vertex1);
    }

    public void display() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // List of all vertices names
        ArrayList<String> keys = new ArrayList<>(this.vertices.keySet());

        for (String key : keys) {
            // Visit each vertex
            Vertex vertex = this.vertices.get(key);

            // Print its neighbors
            System.out.println(key + " -> " + vertex.neighbors);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
    }

    // -- APPROACH --
    // Check if direct edge exists b/w desired vertices
    // If not then give recursive calls to neighbors
    // -- STACK OVERFLOW --
    // If vertex1 and vertex 2 does not have a direct edge then the call will be given to its neighbors
    // Now if neighbors also do not have any direct edge then they will call their neighbors
    // vertex1 will also be among them that will cause infinite recursion
    // To avoid this mark the vertex as processed once checked
    // HASHMAP should be passed as parameter as it needs to be same throughout the recursion
    public boolean hasPath(String vertex1, String vertex2, HashMap<String, Boolean> processed) {
        // checked once
        processed.put(vertex1, true);

        // BASE CASE
        if (this.containsEdge(vertex1, vertex2))
            return true;

        Vertex vertex = this.vertices.get(vertex1);

        // List of all neighbors names of given vertex
        ArrayList<String> neighborsNames = new ArrayList<>(vertex.neighbors.keySet());

        for (String neighbor : neighborsNames) {
            // RECURSIVE CALL only if not checked before
            if (!processed.containsKey(neighbor) && this.hasPath(neighbor, vertex2, processed))
                return true;
        }
        return false;
    }

    private class Pair {
        String vertexName;
        String pathSoFar;
    }

    // Breadth First Search
    // Always finds the shortest path
    // Iterative algorithm
    // APPROACH - process vertices nearest to source first then proceed further
    // QUEUE Implementation
    // O(Vertices + Edges)
    public boolean bfs(String source, String destination) {
        // Level-order implementation
        LinkedList<Pair> queue = new LinkedList<>();

        // Processed vertices hashmap
        HashMap<String, Boolean> processed = new HashMap<>();

        // Create a source pair
        Pair sourcePair = new Pair();
        sourcePair.vertexName = source;
        sourcePair.pathSoFar = source;

        // Add source pair to the queue
        queue.addLast(sourcePair);

        // Till the queue is empty
        while (!queue.isEmpty()) {

            // Remove first pair for processing
            Pair removedPair = queue.removeFirst();

            // If already processed means a path was discovered before
            // Hence ignore this path
            if (processed.containsKey(removedPair.vertexName)) {
                continue;
            }

            // Marked processed
            processed.put(removedPair.vertexName, true);

            // If direct edge found (BASE CASE)
            if (this.containsEdge(removedPair.vertexName, destination)) {
                System.out.println(removedPair.pathSoFar + destination);
                return true;
            }

            // -- Direct edge is not found --
            // Proceed with neighbors

            // Removed vertex
            Vertex removedPairVertex = vertices.get(removedPair.vertexName);

            // neighbors keySet list
            ArrayList<String> neighbors = new ArrayList<>(removedPairVertex.neighbors.keySet());

            // Processing neighbors
            for (String neighbor : neighbors) {
                // only unprocessed neighbors
                if (!processed.containsKey(neighbor)) {
                    // Add neighbor pairs to the queue along with their paths
                    Pair neighborPair = new Pair();
                    neighborPair.vertexName = neighbor;
                    neighborPair.pathSoFar = removedPair.pathSoFar + neighbor;

                    queue.addLast(neighborPair);
                }
            }
        }
        return false;
    }

    // Depth First Search
    // Need not always return the shortest path
    // Iterative algorithm
    // APPROACH - exhaustive searches of all the nodes by going ahead, if possible, else by backtracking
    // STACK Implementation
    // O(Vertices + Edges)
    public boolean dfs(String source, String destination) {

        LinkedList<Pair> stack = new LinkedList<>();

        // Processed vertices hashmap
        HashMap<String, Boolean> processed = new HashMap<>();

        // Create a source pair
        Pair sourcePair = new Pair();
        sourcePair.vertexName = source;
        sourcePair.pathSoFar = source;

        // Add source pair to the stack
        stack.addFirst(sourcePair);

        // Till the stack is empty
        while (!stack.isEmpty()) {

            // Remove first pair for processing
            Pair removedPair = stack.removeFirst();

            // If already processed means a path was discovered before
            // Hence ignore this path
            if (processed.containsKey(removedPair.vertexName)) {
                continue;
            }

            // Marked processed
            processed.put(removedPair.vertexName, true);

            // If direct edge found (BASE CASE)
            if (this.containsEdge(removedPair.vertexName, destination)) {
                System.out.println(removedPair.pathSoFar + destination);
                return true;
            }

            // -- Direct edge is not found --
            // Proceed with neighbors

            // Removed vertex
            Vertex removedPairVertex = vertices.get(removedPair.vertexName);

            // neighbors keySet list
            ArrayList<String> neighbors = new ArrayList<>(removedPairVertex.neighbors.keySet());

            // Processing neighbors
            for (String neighbor : neighbors) {
                // only unprocessed neighbors
                if (!processed.containsKey(neighbor)) {
                    // Add neighbor pairs to the stack along with their paths
                    Pair neighborPair = new Pair();
                    neighborPair.vertexName = neighbor;
                    neighborPair.pathSoFar = removedPair.pathSoFar + neighbor;

                    stack.addFirst(neighborPair);
                }
            }
        }
        return false;
    }

    // Fix one vertex and add all its neighbors(unprocessed) to queue
    // Remove vertices from queue
    // 1. mark them processed
    // 2. print their path
    // 3. add neighbors of removed vertex to queue
    // Repeat for all vertices(unprocessed)
    public void bft() {
        // Level-order implementation
        LinkedList<Pair> queue = new LinkedList<>();

        // Processed vertices hashmap
        HashMap<String, Boolean> processed = new HashMap<>();

        // List of all vertices
        ArrayList<String> vertices = new ArrayList<>(this.vertices.keySet());

        for (String vertex : vertices) {

            // If there is discontinuity in graph
            // Few vertices will be unprocessed and their paths will be printed separately
            if (processed.containsKey(vertex))
                continue;

            // Create a source pair
            Pair sourcePair = new Pair();
            sourcePair.vertexName = vertex;
            sourcePair.pathSoFar = vertex;

            // Add source pair to the queue
            queue.addLast(sourcePair);

            // Till the queue is empty
            while (!queue.isEmpty()) {

                // Remove first pair for processing
                Pair removedPair = queue.removeFirst();

                // If already processed means a path was discovered before
                // Hence ignore this path
                if (processed.containsKey(removedPair.vertexName)) {
                    continue;
                }

                // Marked processed
                processed.put(removedPair.vertexName, true);

                // print path
                System.out.println(removedPair.vertexName + " via " + removedPair.pathSoFar);

                // Proceed with neighbors

                // Removed vertex
                Vertex removedPairVertex = this.vertices.get(removedPair.vertexName);

                // neighbors keySet list
                ArrayList<String> neighbors = new ArrayList<>(removedPairVertex.neighbors.keySet());

                // Processing neighbors
                for (String neighbor : neighbors) {
                    // only unprocessed neighbors
                    if (!processed.containsKey(neighbor)) {
                        // Add neighbor pairs to the queue along with their paths
                        Pair neighborPair = new Pair();
                        neighborPair.vertexName = neighbor;
                        neighborPair.pathSoFar = removedPair.pathSoFar + neighbor;

                        queue.addLast(neighborPair);
                    }
                }
            }
        }
    }

    // As it is based on STACK implementation
    // Neighbors will be popped out first
    public void dft() {
        // Level-order implementation
        LinkedList<Pair> stack = new LinkedList<>();

        // Processed vertices hashmap
        HashMap<String, Boolean> processed = new HashMap<>();

        // List of all vertices
        ArrayList<String> vertices = new ArrayList<>(this.vertices.keySet());

        for (String vertex : vertices) {

            // If there is discontinuity in graph
            // Few vertices will be unprocessed and their paths will be printed separately
            if (processed.containsKey(vertex))
                continue;

            // Create a source pair
            Pair sourcePair = new Pair();
            sourcePair.vertexName = vertex;
            sourcePair.pathSoFar = vertex;

            // Add source pair to the stack
            stack.addFirst(sourcePair);

            // Till the stack is empty
            while (!stack.isEmpty()) {

                // Remove first pair for processing
                Pair removedPair = stack.removeFirst();

                // If already processed means a path was discovered before
                // Hence ignore this path
                if (processed.containsKey(removedPair.vertexName)) {
                    continue;
                }

                // Marked processed
                processed.put(removedPair.vertexName, true);

                // print path
                System.out.println(removedPair.vertexName + " via " + removedPair.pathSoFar);

                // Proceed with neighbors

                // Removed vertex
                Vertex removedPairVertex = this.vertices.get(removedPair.vertexName);

                // neighbors keySet list
                ArrayList<String> neighbors = new ArrayList<>(removedPairVertex.neighbors.keySet());

                // Processing neighbors
                for (String neighbor : neighbors) {
                    // only unprocessed neighbors
                    if (!processed.containsKey(neighbor)) {
                        // Add neighbor pairs to the stack along with their paths
                        Pair neighborPair = new Pair();
                        neighborPair.vertexName = neighbor;
                        neighborPair.pathSoFar = removedPair.pathSoFar + neighbor;

                        stack.addFirst(neighborPair);
                    }
                }
            }
        }
    }

    // Traverse through the graph (copied bft code)
    // return true if two paths for a single vertex are found
    public boolean isCyclic() {
        // Level-order implementation
        LinkedList<Pair> queue = new LinkedList<>();

        // Processed vertices hashmap
        HashMap<String, Boolean> processed = new HashMap<>();

        // List of all vertices
        ArrayList<String> vertices = new ArrayList<>(this.vertices.keySet());

        for (String vertex : vertices) {

            // If there is discontinuity in graph
            if (processed.containsKey(vertex))
                continue;

            // Create a source pair
            Pair sourcePair = new Pair();
            sourcePair.vertexName = vertex;
            sourcePair.pathSoFar = vertex;

            // Add source pair to the queue
            queue.addLast(sourcePair);

            // Till the queue is empty
            while (!queue.isEmpty()) {

                // Remove first pair for processing
                Pair removedPair = queue.removeFirst();

                // Second time occurrence of a vertex implies a CYCLE
                if (processed.containsKey(removedPair.vertexName)) {
                    return true;
                }

                // Marked processed
                processed.put(removedPair.vertexName, true);

                // Proceed with neighbors

                // Removed vertex
                Vertex removedPairVertex = this.vertices.get(removedPair.vertexName);

                // neighbors keySet list
                ArrayList<String> neighbors = new ArrayList<>(removedPairVertex.neighbors.keySet());

                // Processing neighbors
                for (String neighbor : neighbors) {
                    // only unprocessed neighbors
                    if (!processed.containsKey(neighbor)) {
                        // Add neighbor pairs to the queue along with their paths
                        Pair neighborPair = new Pair();
                        neighborPair.vertexName = neighbor;
                        neighborPair.pathSoFar = removedPair.pathSoFar + neighbor;

                        queue.addLast(neighborPair);
                    }
                }
            }
        }
        return false;
    }

    public boolean isContinuous() {
        // Level-order implementation
        LinkedList<Pair> queue = new LinkedList<>();

        // Processed vertices hashmap
        HashMap<String, Boolean> processed = new HashMap<>();

        // List of all vertices
        ArrayList<String> vertices = new ArrayList<>(this.vertices.keySet());

        int flag = 0;
        for (String vertex : vertices) {

            // If there is discontinuity in graph CONTINUE WILL NOT BE EVALUATED AND LOOP WILL RUN
            if (processed.containsKey(vertex))
                continue;

            // If graph is continuous then loop will run only once(flag = 1)
            // otherwise flag >=2
            flag++;

            // Create a source pair
            Pair sourcePair = new Pair();
            sourcePair.vertexName = vertex;
            sourcePair.pathSoFar = vertex;

            // Add source pair to the queue
            queue.addLast(sourcePair);

            // Till the queue is empty
            while (!queue.isEmpty()) {

                // Remove first pair for processing
                Pair removedPair = queue.removeFirst();

                // If already processed means a path was discovered before
                // Hence ignore this path
                if (processed.containsKey(removedPair.vertexName)) {
                    continue;
                }

                // Marked processed
                processed.put(removedPair.vertexName, true);

                // Proceed with neighbors

                // Removed vertex
                Vertex removedPairVertex = this.vertices.get(removedPair.vertexName);

                // neighbors keySet list
                ArrayList<String> neighbors = new ArrayList<>(removedPairVertex.neighbors.keySet());

                // Processing neighbors
                for (String neighbor : neighbors) {
                    // only unprocessed neighbors
                    if (!processed.containsKey(neighbor)) {
                        // Add neighbor pairs to the queue along with their paths
                        Pair neighborPair = new Pair();
                        neighborPair.vertexName = neighbor;
                        neighborPair.pathSoFar = removedPair.pathSoFar + neighbor;

                        queue.addLast(neighborPair);
                    }
                }
            }
        }
        return flag < 2;
    }

    // Tree is an acyclic connected graph.
    public boolean isTree() {
        return !this.isCyclic() && this.isContinuous();
    }

    // returns ArrayList of ArrayLists of connected vertices
    public ArrayList<ArrayList<String>> getConnectedComponents() {
        // Level-order implementation
        LinkedList<Pair> queue = new LinkedList<>();

        // Processed vertices hashmap
        HashMap<String, Boolean> processed = new HashMap<>();

        // List of all vertices
        ArrayList<String> vertices = new ArrayList<>(this.vertices.keySet());

        // Ans List
        ArrayList<ArrayList<String>> list = new ArrayList<>();

        for (String vertex : vertices) {

            // If there is discontinuity in graph
            if (processed.containsKey(vertex))
                continue;

            // For a group of connected components
            ArrayList<String> subList = new ArrayList<>();

            // Create a source pair
            Pair sourcePair = new Pair();
            sourcePair.vertexName = vertex;
            sourcePair.pathSoFar = vertex;

            // Add source pair to the queue
            queue.addLast(sourcePair);

            // Till the queue is empty
            while (!queue.isEmpty()) {

                // Remove first pair for processing
                Pair removedPair = queue.removeFirst();

                // If already processed means a path was discovered before
                // Hence ignore this path
                if (processed.containsKey(removedPair.vertexName)) {
                    continue;
                }

                // Marked processed
                processed.put(removedPair.vertexName, true);

                // Add vertex to subList
                subList.add(removedPair.vertexName);

                // Proceed with neighbors

                // Removed vertex
                Vertex removedPairVertex = this.vertices.get(removedPair.vertexName);

                // neighbors keySet list
                ArrayList<String> neighbors = new ArrayList<>(removedPairVertex.neighbors.keySet());

                // Processing neighbors
                for (String neighbor : neighbors) {
                    // only unprocessed neighbors
                    if (!processed.containsKey(neighbor)) {
                        // Add neighbor pairs to the queue along with their paths
                        Pair neighborPair = new Pair();
                        neighborPair.vertexName = neighbor;
                        neighborPair.pathSoFar = removedPair.pathSoFar + neighbor;

                        queue.addLast(neighborPair);
                    }
                }
            }
            // Add subList to list when queue is empty
            list.add(subList);
        }
        return list;
    }
}

class test {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.display();

        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 6);
        graph.addEdge("C", "A", 7);
        graph.addEdge("D", "E", 8);
        graph.addEdge("A", "E", 9);
        graph.addEdge("B", "G", 0);
        graph.addEdge("A", "F", 10);

        graph.display();

        graph.removeEdge("D", "E");
        graph.display();

        graph.removeVertex("C");
        graph.display();

        System.out.println(graph.numberOfEdges());
        System.out.println(graph.numberOfVertices());
        System.out.println(graph.containsVertex("A"));
        System.out.println(graph.containsVertex("C"));
        System.out.println(graph.containsEdge("A", "B"));
        System.out.println(graph.containsEdge("A", "C"));
        System.out.println(graph.containsEdge("A", "D"));

        graph.addEdge("B", "D", 10);
        graph.addEdge("D", "E", 15);
        graph.display();

        System.out.println(graph.hasPath("A", "D", new HashMap<>()));
        System.out.println(graph.hasPath("A", "F", new HashMap<>()));

        System.out.println();

        System.out.println("A -> F");
        System.out.println("-- BFS ---");
        System.out.println(graph.bfs("A", "F"));
        System.out.println("-- DFS ---");
        System.out.println(graph.dfs("A", "F"));
        System.out.println("A -> B");
        System.out.println("-- BFS ---");
        System.out.println(graph.bfs("A", "B"));
        System.out.println("-- DFS ---");
        System.out.println(graph.dfs("A", "B"));
        System.out.println("A -> D");
        System.out.println("-- BFS ---");
        System.out.println(graph.bfs("A", "D"));
        System.out.println("-- DFS ---");
        System.out.println(graph.dfs("A", "D"));
        System.out.println("A -> E");
        System.out.println("-- BFS ---");
        System.out.println(graph.bfs("A", "E"));
        System.out.println("-- DFS ---");
        System.out.println(graph.dfs("A", "E"));

        System.out.println();
        System.out.println("-- BFT --");
        graph.bft();

        System.out.println();
        System.out.println("-- DFT --");
        graph.dft();

        System.out.println();
        graph.removeEdge("B", "D");
        System.out.println("Is cycle present? " + graph.isCyclic());

        System.out.println();
        graph.removeEdge("A", "B");
        System.out.println("Is graph continuous? " + graph.isContinuous());

        System.out.println();
        System.out.println("Is it a tree? " + graph.isTree());

        System.out.println();
        System.out.println("Connected Components : " + graph.getConnectedComponents());
    }
}
