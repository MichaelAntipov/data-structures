import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
 */
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities/HTMLChecker/src/TagSample1.html";


        try (Scanner in = new Scanner(new File(filename)))
        {
            Stack<String> stack = new Stack<>();

            boolean isProperlyNested = true;
            int tagPosition = 0; 

            while (in.hasNext()) {
                String tag = in.next();
                tagPosition++;

                if (tag.startsWith("<") && !tag.startsWith("</") && tag.endsWith(">")) {
                    String tagName = tag.substring(1, tag.length() - 1);
                    stack.push(tagName);
                }
                else if (tag.startsWith("</") && tag.endsWith(">")) {
                    String tagName = tag.substring(2, tag.length() - 1);
                    if (stack.isEmpty()) {
                        System.out.println("Error: Closing tag </" + tagName + "> at position " + tagPosition + " without matching opening tag.");
                        isProperlyNested = false;
                        break;
                    }
                    String lastTag = stack.pop();
                    if (!lastTag.equals(tagName)) {
                        System.out.println("Error: Expected closing tag </" + lastTag + "> but found </" + tagName + "> at position " + tagPosition + ".");
                        isProperlyNested = false;
                        break;
                    }
                }
                else {
                    System.out.println("Error: Invalid tag format " + tag + " at position " + tagPosition + ".");
                    isProperlyNested = false;
                    break;
                }
            }

            if (isProperlyNested && !stack.isEmpty()) {
                System.out.println("Error: There are unmatched opening tags remaining in the stack.");
                isProperlyNested = false;
            }

            if (isProperlyNested) {
                System.out.println("The HTML tags are properly nested.");
            } else {
                System.out.println("The HTML tags are NOT properly nested.");
            }

        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

    }
}
