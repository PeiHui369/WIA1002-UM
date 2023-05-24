package T8;

public class LinkedListRepresentation{
    public static void main (String[] args){
        Graph<Character> graph = new Graph<>();
        for(char ch = 'A'; ch<='I'; ch++){
            graph.addVertex(ch);}
            graph.addEdge('A','C');
            graph.addEdge('A', 'D'); // adds an edge between vertices 'A' and 'D'
            graph.addEdge('B', 'D'); // adds an edge between vertices 'B' and 'D'
            graph.addEdge('C', 'E'); // adds an edge between vertices 'C' and 'E'
            graph.addEdge('C', 'F'); // adds an edge between vertices 'C' and 'F'
            graph.addEdge('D', 'E'); // adds an edge between vertices 'D' and 'E'
            graph.addEdge('E', 'G'); // adds an edge between vertices 'E' and 'G'
            graph.addEdge('F', 'H'); // adds an edge between vertices 'F' and 'H'
            graph.addEdge('G', 'H'); // adds an edge between vertices 'G' and 'H'
            graph.addEdge('H', 'I'); // adds an edge between vertices 'H' and 'I'
            graph.showAdjacencyList(); // displays the graph's adjacency list
            // Adjacency list is used
        
    }
}
class Graph <E extends Comparable<E>>{
    static class Vertex<E extends Comparable<E>>{
        Vertex<E> nextVertex;
        Edge<E> firstEdge;
        E item;

        Vertex(E item){
            this.item = item;
        }
    }

    static class Edge<E extends Comparable<E>>{
        Vertex<E> toVertex; //Reference to the vertex this edge connects to
        Edge<E> nextEdge; //reference to the next edge connected to this vertex;
        Edge(Vertex<E> toVertex, Edge<E> nextEdge){
            this.toVertex = toVertex;
            this.nextEdge = nextEdge;
        }
    }

    Vertex<E> head; //reference to the first vertex in the graph
    int size; //the number of vertices in the graph

    public void addVertex(E item) { //adds a new vertex to the graph
        Vertex<E> newVertex = new Vertex<>(item); //creates a new vertex object
        if (head == null) {   //if the graph is empty, set the head to the new vertex
            head = newVertex;
        }else{ //otherwise, loop through the list of vertices and add the new vertex to the end
            Vertex<E> vertex = head;
            while(vertex.nextVertex != null){
                vertex = vertex.nextVertex;
            }
            vertex.nextVertex = newVertex;
        }
        size++;
    }

    public boolean addEdge(E src, E dst){

        Vertex<E> srcVertex = vertex(src); //This line creates a new vertex object from the source vertex using the 'vertex' method and assigns it to 'srcVertex'
        Vertex<E> dstVertex = vertex(dst); //This line creates a new vertex object from the destination vertex using the 'vertex' method and assigns it to 'dstVertex'
        if(srcVertex == null ||dstVertex == null){ //This 'if' statement checks whether either the source or destination vertex is null, which means they do not exist in the graph. If either is null, the method returns 'false'
            return false;
        }
        srcVertex.firstEdge = new Edge<>(dstVertex, srcVertex.firstEdge); //If both vertices exist, this line creates a new edge from the source to the destination vertex and assigns it to 'srcVertex.firstEdge', which is a reference to the first edge leaving from the source vertex. It then returns 'true' to indicate that the edge was successfully added.
        return true;}
        /*
        This is a commented-out block of code that performs the same function as the above code, but uses nested loops to search for the source and destination vertices
//		for (Vertex<E> srcVertex = head; srcVertex != null; srcVertex = srcVertex.nextVertex)
//            if (srcVertex.item.compareTo(src) == 0)
//                for (Vertex<E> dstVertex = head; dstVertex != null; dstVertex = dstVertex.nextVertex)
//                    if (dstVertex.item.compareTo(dst) == 0) {
//                        srcVertex.firstEdge = new Edge<>(dstVertex, srcVertex.firstEdge);
//                        return true;
//                    }
//        return false;

         */


    //Method for finding a vertex with a given item value
    private Vertex<E> vertex(E item){
        for(Vertex<E> vertex = head; vertex!=null; vertex = vertex.nextVertex) { //this 'for' loop iterates through all vertices in the graph, starting from the head vertex
            if (vertex.item.compareTo(item) == 0) {   //This 'if' statement checks whether the item value of the current vertex is equal to the target item value. If so, it returns the current vertex.
                return vertex;
            }
        }
            return null; //if the target item value is not found in the graph, the method returns 'null'
    }

    public void showAdjacencyList(){
        for(Vertex<E> vertex = head; vertex != null; vertex = vertex.nextVertex){
            System.out.print(vertex.item);
            for(Edge<E> edge = vertex.firstEdge; edge!= null; edge = edge.nextEdge){
                System.out.print(" -->" + edge.toVertex.item);
                //This 'for' loop iterates through all edges leaving from the current vertex, starting from the first edge ('vertex.firstEdge'). For each edge, it prints an arrow followed by the item value of the vertex that the edge points to ('edge.toVertex.item)
            }
            System.out.println(); //Prints a newline character to separate the adjacency list for each vertex
        }

    }
}

@
String[][] vert = {"A", "B", "C", "D", "E", "F", "G", "H", "I");
for(String str:vert){
        myGraph.addVertex(str);
       myGraph.addEdge("A", "C", 1);
       myGraph.addEdge("A", "D", 1);
       myGraph.addEdge("B", "D", 1);
       myGraph.addEdge("C", "E", 1);
       myGraph.addEdge("C", "F", 1);
       myGraph.addEdge("D", "E", 1);
       myGraph.addEdge("E", "G", 1);
       myGraph.addEdge("F", "H", 1);
       myGraph.addEdge("G", "H", 1);
       myGraph.addEdge("H", "I", 1);   
    
