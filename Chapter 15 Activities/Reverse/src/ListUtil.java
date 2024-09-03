import java.util.*;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        
            for(int i =0; i< (strings.size() / 2); i++){
                String a = strings.get(i);
                String b = strings.get(strings.size()-1 -i);
                int index2 = strings.size()-1 -i;
                strings.set(i,b);
                strings.set(index2,a);

            }

    }
}