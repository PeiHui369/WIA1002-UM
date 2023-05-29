public class StringSubstitutor {
    public static String substituteAI(String str){
        if(str.length() == 0){
            return str;
        }

        char firstChar = str.charAt(0);

        if(firstChar == 'a'){
            return 'i' + substituteAI(str.substring(1));
        }else if(firstChar == 'A'){
            return 'A' + substituteAI(str.substring(1));
        }else{
            return firstChar + substituteAI(str.substring(1));
        }
    }

    public static void main(String[] args) {
        String input1 = "flabbergasted";
        String output1 = substituteAI(input1);
        System.out.println("Input String: " + input1);
        System.out.println("Output String: " + output1);

        String input2 = "Astronaut";
        String output2 = substituteAI(input2);
        System.out.println("Input String: " + input2);
        System.out.println("Output String: " + output2);

    }
}
