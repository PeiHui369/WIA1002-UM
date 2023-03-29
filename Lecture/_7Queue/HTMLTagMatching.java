import java.util.Stack;

public class HTMLTagMatching {
    public static boolean isHTMLMatched(String html) {
        Stack<String> buffer = new Stack<>();

        int j = html.indexOf('<');
        while (j != -1) {
            int k = html.indexOf('>', j + 1);
            if (k == -1) {
                // Invalid tag
                return false;
            }

            String tag = html.substring(j + 1, k).trim(); // Trim the tag

            if (!tag.startsWith("/")) { // This is an opening tag
                buffer.push(tag);
            } else { // This is a closing tag
                if (buffer.isEmpty()) {
                    // No tag to match
                    return false;
                }
                if (!tag.substring(1).equals(buffer.pop())) {
                    // Mismatched tag
                    return false;
                }
            }

            j = html.indexOf('<', k + 1);
        }

        return buffer.isEmpty(); // Were all opening tags matched?
    }
}

/*
The changes made to the original code are:

The code is wrapped in a 'isHTMLMatched' method to make it a complete and functional method.
The 'while' loop is now enclosed in the method.
The 'trim' method is used to remove any leading/trailing whitespace in the extracted tag.
The 'return' statements are now within the method and returning the correct values.
The class declaration has been corrected to match the filename

//From lecture notes, with error
import java.util.Stack;

public class HTMLTagMatching {
    Stack<String> buffer = new Stack<>();

    //Find first '<' character (if any)
    int j = html.indexOf('<');
    while(j!=-1)
    {
        //Find next '>' character
        int k = html.indexOf('>', j + 1);
        if (k == -1) {                        //Invalid tag
            return false;
        }


    //Strip away <>
    String tag = html.substring(j + 1, k);      //^Need .trim()
    if(!tag.startsWith("/"))

    {                   //This is an opening tag
        buffer.push(tag);
    }else

    {                                      //This is a closing tag
        if (buffer.isEmpty()) {
            return false;
        }    //No tag to match
        if (!tag.substring(1).equals(buffer.pop())) {     //Mismatched tag
            return false;
        }
    }

    //Find next '<' character (if any)
    j =html.indexOf('<',k+1);
}
    return buffer.isEmpty();    //Were all opening tags matched?
}
*/
