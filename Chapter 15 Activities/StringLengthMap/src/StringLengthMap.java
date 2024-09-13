import java.io.*;
import java.util.*;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Modify Worked Example 15.1.
 */
public class StringLengthMap
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String filename = "Chapter 15 Activities\\StringLengthMap\\src\\test1.txt";

        


        Map<Integer, String> strlength = new HashMap<>();
        Map<Integer, String> strlength1 = new HashMap<>();
        //int len1 = 0;
        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            
            
            while (in.hasNext())
            {
                String word = clean(in.next());
                Integer len = word.length();
                
                
                if(strlength.get(len) == "" || strlength.get(len) == null){
                    strlength.put(len,word);
                }
                else{
                    String s = strlength.get(len);
                    s = s +", " + word;
                    strlength.put(len, s);
                }
                
                   //len1 = len;
                
                /* else if(strlength.size() > 0){
                    for(int i = 0; i < strlength.size(); i++){
                        if(len == strlength.)
                    }
                }*/

                // Update the map here
                // Modify Worked Example 15.1


                


            }

            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }

        for(int i =0; i < 16;i++){
            strlength1.put(i,strlength.get(i));
        }

        for(int i = 0; i< 16; i++){
            if()
                System.out.println(strlength1.get(i));
        }
        
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}