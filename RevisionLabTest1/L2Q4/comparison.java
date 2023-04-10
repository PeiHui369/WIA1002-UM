package Lab2;

public class comparison {
    public static <T extends Comparable<T>> String minmax(T[] arr){
        T min = arr[0];
        T max = arr[0];

        for(T ele : arr){
            if(ele.compareTo(min) < 0){
                min = ele;
            }
            if(ele.compareTo(max) > 0){
                max = ele;
            }
        }

        return "Min = " + min + " Max = " +max;
    }

    public static void main(String[] args) {
        Integer[] intArr ={5,3,7,1,4,9,8,2};
        String[] strArr = {"red", "blue", "orange", "tan"};

        String intStr = minmax(intArr);
        System.out.println(intStr);
        String str = minmax(strArr);
        System.out.println(str);
    }
}
