import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
 */
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return Reversed sentence.
     */
    public static String reverse(String sentence)
    {
        Scanner scanner = new Scanner(sentence);
        Stack<String> stack = new Stack<>(); 
        String reversedSentence = ""; 

        while (scanner.hasNext()) {
            String word = scanner.next();

            stack.push(word.toLowerCase()); 

            if (word.endsWith(".")) { 
                
                String lastWord = stack.pop();
                lastWord = lastWord.substring(0, lastWord.length() - 1);
                stack.push(lastWord); 

                String tempSentence = "";

                while (!stack.isEmpty()) {
                    String currentWord = stack.pop();
                    if (tempSentence.isEmpty()) {
                        currentWord = currentWord.substring(0, 1).toUpperCase() + currentWord.substring(1);
                    }
                    tempSentence += currentWord;
                    if (!stack.isEmpty()) {
                        tempSentence += " "; 
                    }
                }

                tempSentence += "."; 

                reversedSentence += tempSentence;

                if (scanner.hasNext()) {
                    reversedSentence += " "; 
                }

                stack.clear();
            }
        }

        scanner.close(); 

        return reversedSentence.trim(); 
    }
}
