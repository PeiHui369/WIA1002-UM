public class Node<ValueType> {
    private ValueType value;
    private String edgeName1;
    private String edgeName2;
    private Node<ValueType> edgeNode1;
    private Node<ValueType> edgeNode2;

    public Node(ValueType value){
        this.value = value;
    }

    public void setEdge1(String edgeName, Node<ValueType> node){
        this.edgeName1 = edgeName;
        this.edgeNode1 = node;
    }

    public void setEdge2(String edgeName, Node<ValueType> node){
        this.edgeName2 = edgeName;
        this.edgeNode2 = node;
    }

    public ValueType getValue(){
        return value;
    }

    public void printEdgesAndNodes() {
        System.out.println("-------------------------------------");
        System.out.println(value.toString());
        if (edgeName1 != null && edgeNode1 != null) {
            System.out.println(":" + edgeName1 + "->");
            System.out.println("\t\t" +edgeNode1.getValue().toString());
        }
        if (edgeName2 != null && edgeNode2 != null) {
            System.out.println(":" + edgeName2 + "->");
            System.out.println("\t\t" +edgeNode2.getValue().toString());
        }
        System.out.println("-------------------------------------");
    }


}
