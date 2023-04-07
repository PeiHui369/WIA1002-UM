public class CompareMax {
    public static <E extends Comparable<E>> E maximum(E o1, E o2, E o3){
        E max = o1;
        if(o2.compareTo(max)>0){
            max = o2;
        }
        if(o3.compareTo(max)>0){
            max = o3;
        }
        return max;
    }

    public static void main (String[] args){
        System.out.println(maximum(1,2,3));
    }
}
