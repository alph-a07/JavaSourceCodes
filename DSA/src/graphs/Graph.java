package graphs;

import heaps.GenericHeap;

import java.util.*;

public class Graph {

    // Hashmap of vertices
    // Key = Name of current vertex
    // Value = Address of Vertex class containing neighbors of current vertex
    HashMap<String, Vertex> vertices;

    private static class Vertex {
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
        if (vertex == null) return;

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
        if (vtx1 == null || vtx2 == null || vtx1.neighbors.containsKey(vertex2)) return;

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
        if (vtx1 == null || vtx2 == null || !vtx1.neighbors.containsKey(vertex2)) return;

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
        if (this.containsEdge(vertex1, vertex2)) return true;

        Vertex vertex = this.vertices.get(vertex1);

        // List of all neighbors names of given vertex
        ArrayList<String> neighborsNames = new ArrayList<>(vertex.neighbors.keySet());

        for (String neighbor : neighborsNames) {
            // RECURSIVE CALL only if not checked before
            if (!processed.containsKey(neighbor) && this.hasPath(neighbor, vertex2, processed)) return true;
        }
        return false;
    }

    private static class Pair {
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
    // O(Vertices + edges)
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
            if (processed.containsKey(vertex)) continue;

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
    // O(Vertices + edges)
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
            if (processed.containsKey(vertex)) continue;

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
    // O(Vertices + edges)
    public boolean isCyclic() {
        // Level-order implementation
        LinkedList<Pair> queue = new LinkedList<>();

        // Processed vertices hashmap
        HashMap<String, Boolean> processed = new HashMap<>();

        // List of all vertices
        ArrayList<String> vertices = new ArrayList<>(this.vertices.keySet());

        for (String vertex : vertices) {

            // If there is discontinuity in graph
            if (processed.containsKey(vertex)) continue;

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

    // O(Vertices + edges)
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
            if (processed.containsKey(vertex)) continue;

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
    // O(Vertices + edges)
    public boolean isTree() {
        return !this.isCyclic() && this.isContinuous();
    }

    // returns ArrayList of ArrayLists of connected vertices
    // O(Vertices + edges)
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
            if (processed.containsKey(vertex)) continue;

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

    private static class PrimsPair implements Comparable<PrimsPair> {
        String vertex;
        String acqVertex;
        int cost;

        @Override
        // Make lower cost priority
        public int compareTo(PrimsPair o) {
            return o.cost - this.cost;
        }
    }

    // (V * log V) + (V * log V) + (2E * log V)
    // 2(V+E) * log V
    // O((E +V) * log V)
    public Graph primsAlgo() {
        Graph MST = new Graph();

        HashMap<String, PrimsPair> map = new HashMap<>();
        GenericHeap<PrimsPair> heap = new GenericHeap<>();

        // Add pairs to heap and map both
        // O(V)
        for (String key : this.vertices.keySet()) {
            PrimsPair pair = new PrimsPair();
            pair.vertex = key;
            pair.acqVertex = null;
            pair.cost = Integer.MAX_VALUE;

            heap.add(pair);
            map.put(key, pair);
        }

        // O(V * log V)
        while (!heap.isEmpty()) {
            // remove a pair
            PrimsPair removedPair = heap.remove();
            map.remove(removedPair.vertex); // O(log V)

            // Initial case
            if (removedPair.acqVertex == null) {
                MST.addVertex(removedPair.vertex);
            }
            // If removed pair vertex was approached from some other vertex
            else {
                MST.addVertex(removedPair.vertex);
                MST.addEdge(removedPair.vertex, removedPair.acqVertex, removedPair.cost);
            }

            // Work on neighbors
            //O( 2E * log V)
            for (String neighbor : this.vertices.get(removedPair.vertex).neighbors.keySet()) {
                // only if already not added to MST
                if (map.containsKey(neighbor)) {
                    int oldCost = map.get(neighbor).cost;
                    int newCost = this.vertices.get(removedPair.vertex).neighbors.get(neighbor);

                    // update cost if lower cost is found
                    if (newCost < oldCost) {
                        PrimsPair neighborPair = map.get(neighbor);
                        neighborPair.acqVertex = removedPair.vertex;
                        neighborPair.cost = newCost;
                        // We need to upHeapify the heap after updating index
                        // which will require index of the neighborPair in heap
                        // we will track index through the heap class itself
                        heap.updatePriority(neighborPair); // O(log V)
                    }
                }
            }
        }
        return MST;
    }

    private static class DijkstraPair implements Comparable<DijkstraPair> {

        String vertex;
        String pathSoFar;
        int cost;

        @Override
        public int compareTo(DijkstraPair o) {
            return o.cost - this.cost;
        }
    }

    // O((E +V) * log V)
    public HashMap<String, Integer> dijkstraAlgo(String source) {

        HashMap<String, Integer> ans = new HashMap<>();
        HashMap<String, DijkstraPair> map = new HashMap<>();
        GenericHeap<DijkstraPair> heap = new GenericHeap<>();

        // Add pairs to heap and map both
        for (String key : this.vertices.keySet()) {
            DijkstraPair pair = new DijkstraPair();
            pair.vertex = key;
            pair.pathSoFar = "";
            pair.cost = Integer.MAX_VALUE;

            if (key.equals(source)) {
                pair.pathSoFar = key;
                pair.cost = 0;
            }

            heap.add(pair);
            map.put(key, pair);
        }

        while (!heap.isEmpty()) {
            // remove a pair
            DijkstraPair removedPair = heap.remove();
            map.remove(removedPair.vertex);

            // Add to answer
            ans.put(removedPair.vertex, removedPair.cost);

            // Work on neighbors
            for (String neighbor : this.vertices.get(removedPair.vertex).neighbors.keySet()) {
                // only if already not added to MST
                if (map.containsKey(neighbor)) {
                    int oldCost = map.get(neighbor).cost;
                    int newCost = removedPair.cost + this.vertices.get(removedPair.vertex).neighbors.get(neighbor);

                    // update cost if lower cost is found
                    if (newCost < oldCost) {
                        DijkstraPair neighborPair = map.get(neighbor);
                        neighborPair.pathSoFar = removedPair.pathSoFar + neighbor;
                        neighborPair.cost = newCost;
                        // We need to upHeapify the heap after updating index
                        // which will require index of the neighborPair in heap
                        // we will track index through the heap class itself
                        heap.updatePriority(neighborPair);
                    }
                }
            }
        }
        return ans;
    }

    // Sets implementation for Kruskal's Algorithm
    public static class DisJointSet {

        // To store addresses of nodes corresponding to vertex name
        HashMap<String, Node> map = new HashMap<>();

        private static class Node {
            String data;
            Node parent;
            int rank;
        }

        // O(1)
        public void create(String value) {
            Node newNode = new Node();
            newNode.data = value;
            newNode.parent = newNode;
            newNode.rank = 0;

            map.put(newNode.data, newNode);
        }

        // O(1)
        public void union(String value1, String value2) {
            // Nodes corresponding to vertices' names
            Node node1 = map.get(value1);
            Node node2 = map.get(value2);

            // Nodes of representative vertices
            Node rep1 = find(node1);
            Node rep2 = find(node2);

            // Both have same representatives
            // Belong to same set
            if (Objects.equals(rep1.data, rep2.data)) {
                return;
            }
            // belong to different sets
            else {
                // same rank
                // make anyone parent(your choice)
                if (rep1.rank == rep2.rank) {
                    rep2.parent = rep1;
                    rep1.rank += 1;
                }
                // make higher rank parent
                else if (rep1.rank > rep2.rank) {
                    rep2.parent = rep1;
                } else {
                    rep1.parent = rep2;
                }
            }
        }

        // returns representative of set containing value(root node)
        // O(1) -- Average
        public String find(String value) {
            // find(map.get(value)) => returns address of root node
            return find(map.get(value)).data;
        }

        // returns address of top most parent(representative) of given node(root node)
        private Node find(Node node) {
            if (node == node.parent) {
                return node;
            }

            Node rep = find(node.parent);
            node.parent = rep;  // PATH COMPRESSION -- O(1)
            return rep;
        }
    }

    private static class EdgePair implements Comparable<EdgePair> {
        String vertex1;
        String vertex2;
        int cost;

        @Override
        // Ascending Order(small cost less priority)
        public int compareTo(EdgePair o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return vertex1 + "-" + vertex2 + " : " + cost;
        }
    }

    // returns a list of edges in form of EdgePair
    public ArrayList<EdgePair> getAllEdges() {
        ArrayList<EdgePair> edges = new ArrayList<>();

        for (String vertexName : vertices.keySet()) {
            Vertex vertex = vertices.get(vertexName);

            for (String neighbor : vertex.neighbors.keySet()) {
                EdgePair pair = new EdgePair();
                pair.vertex1 = vertexName;
                pair.vertex2 = neighbor;
                pair.cost = vertex.neighbors.get(neighbor);

                edges.add(pair);
            }
        }
        return edges;
    }

    // (E * log E) + V + E
    // O(E * log E)
    // O(E * log V)   -- As E = V^2 in worst case
    public void kruskalAlgo() {
        ArrayList<EdgePair> edges = getAllEdges(); // get all edges
        Collections.sort(edges); // sort based on cost -- O(E * log E)

        DisJointSet set = new DisJointSet();

        // 1 - Create sets for each vertex
        for (String vertexName : vertices.keySet()) {
            set.create(vertexName);  // O(V)
        }

        // O(E)
        for (EdgePair edge : edges) {

            // Representatives of both ends of a particular edge
            String rep1 = set.find(edge.vertex1);
            String rep2 = set.find(edge.vertex2);

            if (rep1.equals(rep2)) {
                // same set => ignore
                continue;
            } else {
                System.out.println(edge);
                set.union(edge.vertex1, edge.vertex2);
            }
        }
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
        //graph.removeEdge("B", "D");
        System.out.println("Is cycle present? " + graph.isCyclic());

        System.out.println();
        //graph.removeEdge("A", "B");
        System.out.println("Is graph continuous? " + graph.isContinuous());

        System.out.println();
        System.out.println("Is it a tree? " + graph.isTree());

        System.out.println();
        System.out.println("Connected Components : " + graph.getConnectedComponents());

        System.out.println();
        System.out.println("MST using Prim's algorithm:");
        graph.primsAlgo().display();
        System.out.println(graph.primsAlgo().isTree());

        System.out.println();
        System.out.println("Minimum distance of vertices from source using Dijkstra's Algorithm:");
        System.out.println(graph.dijkstraAlgo("A"));

        System.out.println();
        System.out.println("Kruskal's Algorithm to find an MST:");
        graph.kruskalAlgo();
    }
}
