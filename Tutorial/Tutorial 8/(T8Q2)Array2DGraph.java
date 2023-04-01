import java.util.Arrays;

public class Array2DGraph {
    public static void main(String[] args) {
        final int[][] adjacencyMatrix = {
                {0,0,1,1,0,0,0,0,0},
                {0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,1,0,0,0},
                {0,0,0,0,1,0,0,0,0},
                {0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,0}
        };
        printAdjacencyMatrix(adjacencyMatrix);
    }

    public static void printAdjacencyMatrix(int[][] adjacencyMatrix){
        final int SPACE = 4;
        final int MARGIN = 2;

        System.out.printf("%" + SPACE + "s", "");

        for(int ch = 'A'; ch <= 'I'; ch++){
            System.out.print((char)ch + " ".repeat(MARGIN));
        }
        System.out.println();

        int ch = 'A';
        for(int[] row : adjacencyMatrix){
            System.out.println((char)ch + " ".repeat(SPACE-2) + Arrays.toString(row));
            ch++;
        }
    }
}

/*
The code defines a Java class called "T8Q2" that contains a main method and a static method called "printAdjacencyMatrix".

The main method initializes a 2D array called "adjacencyMatrix" that represents the adjacency matrix of a graph with nine vertices labeled from A to I. 
The elements of the array are binary values that indicate whether an edge exists between two vertices.

The main method then calls the "printAdjacencyMatrix" method and passes the adjacency matrix as an argument.

The "printAdjacencyMatrix" method takes a 2D integer array (the adjacency matrix) as a parameter and prints it out to the console. 
It first initializes two constants, SPACE and MARGIN, which are used to format the output.

The method then prints the labels of the vertices (A to I) along the top row of the matrix. 
It uses a for loop to iterate over the ASCII codes of the characters A to I and prints each character followed by a margin of spaces.

Next, the method iterates through each row of the adjacency matrix and prints the label of the corresponding vertex (A to I) in the leftmost column, 
followed by the values in the row. 
It uses the Arrays.toString() method to convert the row array to a string and print it out. 
The label is printed with a fixed width of SPACE characters, and the row is printed with a margin of MARGIN spaces between each value.

The output of the program is a formatted representation of the adjacency matrix, which shows which vertices are connected by edges in the graph.

The output of the program is:
       A   B   C   D   E   F   G   H   I  
A     [0, 0, 1, 1, 0, 0, 0, 0, 0]
B     [0, 0, 0, 1, 0, 0, 0, 0, 0]
C     [0, 0, 0, 0, 1, 1, 0, 0, 0]
D     [0, 0, 0, 0, 1, 0, 0, 0, 0]
E     [0, 0, 0, 0, 0, 0, 1, 0, 0]
F     [0, 0, 0, 0, 0, 0, 0, 1, 0]
G     [0, 0, 0, 0, 0, 0, 0, 1, 0]
H     [0, 0, 0, 0, 0, 0, 0, 0, 1]
I     [0, 0, 0, 0, 0, 0, 0, 0, 0]

The output shows the adjacency matrix of a graph with nine vertices labeled from A to I. 
The labels of the vertices are printed along the top row, and the values of the adjacency matrix are printed in rows below. 
The values indicate whether there is an edge between two vertices: a value of 1 indicates an edge exists, while a value of 0 indicates no edge. 
For example, there is an edge between vertices C and D, as indicated by the value 1 in the (3, 4) position of the matrix.


*/

