import java.io.*;
import java.util.*;

/**
 * This program checks which words in a file are not present in a dictionary.
*/
public class WordAnalysis
{
    public static void main(String[] args)
        throws FileNotFoundException
    {
        // Read the dictionary file and the novel file
        Set<String> dictionaryWords = readWords("./src/words");
        Set<String> novelWords = readWords("./src/war-and-peace.txt");

        for(String word: novelWords){
            if(!dictionaryWords.contains(word)){
                System.out.println(word);
            }
        }

        // print out the number of unique words in the novel
        System.out.println("There are "+novelWords.size() + " unique words in the novel.");

        // print the number of unique words with >3 letters

        Iterator<String> iterator = novelWords.iterator();
        while(iterator.hasNext()){
            if(iterator.hasNext()){
                iterator.remove();
            }
        }

        System.out.println("There are " + novelWords.size() + " unique words with more than 3 letters");
        
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
    */
    public static Set<String> readWords(String filename)
        throws FileNotFoundException
    {
        // We use a HashSet instead of a TreeSet because the order doesn't matter
        Set<String> words = new HashSet<>();

        // deterine the current working directory
        //System.out.println(System.getProperty("user.dir"));

        Scanner in = new Scanner(new File(filename), "UTF-8");
        
        // Use any character that's not a letter as a delimeter

        in.useDelimiter("[^a-zA-Z]+");

        while (in.hasNext()){
            //Add words to the set (duplicates are automaticaly ignored)
            words.add(in.next().toLowerCase());
        }



        return null;
    }
}
