public class MinMaxTwoDArray {
    public static<E extends Comparable<E>> E min (E[][] list){
        E min = list[0][0];
        for (E[] es : list) {
            for (int j = 0; j < list[0].length; j++) {
                if (es[j].compareTo(min) < 0) {
                    min = es[j];
                }
            }
        }
        return min;
    }
    public static <E extends Comparable<E>> E max (E[][] list){
        E max = list[0][0];
        for (E[] es : list) {
            for (int j = 0; j < list[0].length; j++) {
                if (es[j].compareTo(max) > 0) {
                    max = es[j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[][] arr = {{4, 5, 6}, {1, 2, 3}};
        System.out.println("Minimum: " + min(arr));
        System.out.println("Maximum: " + max(arr));
    }
}
