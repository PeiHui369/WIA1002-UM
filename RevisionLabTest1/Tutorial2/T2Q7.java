package tutorial2;

import java.util.ArrayList;

public class wild {
    public static void main(String[] args) {
        ArrayList<String> vehicle = new ArrayList<>();
        ArrayList<Object> transportation = new ArrayList<>();

        wild.allTransportation(vehicle,transportation);
    }

    public static <T> void allTransportation(ArrayList<?> a, ArrayList<?> b){
        System.out.println("done");
    }
}
