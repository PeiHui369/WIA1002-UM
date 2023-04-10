package tutorial1;
public class Telephone {
    private String areaCode;
    private int number;
    static int numberOfTelephoneObject;

    Telephone(String areaCode, int number){
        this.areaCode = areaCode;
        this.number = number;
        numberOfTelephoneObject++;
    }

    public String getAreaCode(){
        return this.areaCode;
    }

    public void setAreaCode(String areaCode){
        this.areaCode = areaCode;
    }

    public int getNumber(){
        return this.number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public String makeFullNumber(){
        return this.areaCode +"-"+ this.number;
    }

    public static void main(String[] args) {
        Telephone[] phoneArr = new Telephone[5];
        int number = 79676300;
        for(int i = 0; i<5; i++){
            phoneArr[i] = new Telephone("03", number++);
        }
        for(int i = 0; i<numberOfTelephoneObject; i++){
            System.out.println(phoneArr[i].makeFullNumber());
        }
        }
}
