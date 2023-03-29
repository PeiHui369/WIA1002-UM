/*Write a Java program that read an HTML file
into a string that is passed into the isHTMLMatched method
to check whether the file has matching tags.
Test your program using another HTML file which has one of the closing tags missing.
*/
package HTML;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class HTMLTagMatcher {
    public static void main(String[] args) {
        String filename = "sample.html";
        String html = readFileToString(filename);
        boolean matched = isHTMLMatched(html);
        System.out.println(filename + " has " + (matched ? "matching" : "mismatched") + " tags.");
    }

    private static String readFileToString(String filename){
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line=br.readLine())!=null){
                sb.append(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: "+e.getMessage());
        }
        return sb.toString();
    }

    private static boolean isHTMLMatched(String html){
        Stack<String> stack = new Stack<>();
        int pos = 0;
        while (pos < html.length()){
            int tagStart = html.indexOf('<', 0); //(ch, fromIndex)
            if(tagStart == -1){
                break;
            }

            int tagEnd = html.indexOf('>',tagStart);
                if(tagEnd == -1){
                    break;
                }

            pos = tagEnd+1;
            String tag = html.substring(tagStart, tagEnd+1);

            if(tag.startsWith("</")){
                if(stack.isEmpty()){
                    return false;
                }
                String openTag = stack.pop();
                if(!tag.substring(2).equals(openTag.substring(1))){
                    return false;
                }
            }else if (tag.endsWith("/>")){
                continue;
            }else{
                stack.push(tag);
            }
        }
        return stack.isEmpty();
    }
}

/*
This program reads an HTML file specified by the 'filename' variable into a string using the 'readFileToString' method.
The 'isHTMLMatched' method checks whether the HTML string has matching tags by using a stack to keep track of opening tags and matching them with closing tags as they are encountered.
If a closing tag is encountered with no matching opening tag, or if there are unmatched opening tags remaining in the stack at the end, the method returns 'false'.
 */