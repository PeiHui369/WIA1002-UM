import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadMyLetter_22004781{
    public static void main(String[] args){

        try{
            Scanner inputStream = new Scanner(new FileInputStream("C:\\Users\\User\\Documents\\LeePeiHui_22004781.txt"));
            while(inputStream.hasNextLine()){
                System.out.print(inputStream.nextLine());
            }
            inputStream.close();
        } catch (FileNotFoundException e){
            System.out.println("File was not found");
        }
    }
}
