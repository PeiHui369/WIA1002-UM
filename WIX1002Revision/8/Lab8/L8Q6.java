package Lab8;

public class BurgerStall {
    String name, ID;
    int numberOfBurgerSold;

    BurgerStall(String name, String ID, int numberOfBurgerSold){
        this.name = name;
        this.ID = ID;
        this.numberOfBurgerSold = numberOfBurgerSold;
    }

    public void sold(int soldBur){
        this.numberOfBurgerSold += soldBur;
    }

    public static void allSold(BurgerStall[] arr){
        int sum = 0;
        for(BurgerStall stall : arr){
            sum+=stall.numberOfBurgerSold;
        }
        System.out.println("Total number of burgers sold by all stalls: " + sum);
    }

    public static void displayInfo(BurgerStall[] arr){
        int index =1;
        for(BurgerStall stall : arr){
            System.out.printf("Stall %d \nOwner: %s\nID: %s\nNumber of Burger Sold: %d\n\n",index,stall.name,stall.ID,stall.numberOfBurgerSold);
            index++;
        }
    }

    public static void main(String[] args) {
        BurgerStall[] burgerStall = {new BurgerStall("Ali","1",123), new BurgerStall("Bo", "456",90)};
        burgerStall[0].sold(50);
        displayInfo(burgerStall);
        allSold(burgerStall);
    }
}
