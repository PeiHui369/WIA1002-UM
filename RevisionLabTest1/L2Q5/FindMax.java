package Lab2;

public class FindMax {
    static class Circle implements Comparable<Circle> {
        //Circle not generic class, so not Circle<T>
        //Circle class uses Comparable interface: implements Comparable<Circle> [Type is Circle, as we want to compare Circle]
        double radius;

        Circle(double r){
            this.radius = r;
        }

        @Override
        public int compareTo(Circle o) {
            if(radius < o.radius){return -1;}
            else if (radius == o.radius) {return 0;}
            else{return 1;}
        }

        public String toString(){
            return "Circle radius: "+radius;
        }
    }

    public static <T extends Comparable<T>> T max (T[] list){
        T max = list[0];
        for(T ele : list){
            if(ele.compareTo(max) > 0){
                max = ele;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Integer[] list1 = {1,2,3};
        String[] list2 = {"red", "green", "blue"};
        Circle[] list3 = {new Circle(3), new Circle(2.9), new Circle(5.9)};

        System.out.println(max(list1));
        System.out.println(max(list2));
        System.out.println(max(list3));
    }
}
