
import java.util.LinkedList;
import java.util.ListIterator;


/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /* The addLast method can be used to populate a list. */
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Gamora");

        System.out.println(staff);

        // the list is currently TNPG

        /* 
        * The ListIterator method creates a new list iterator
        * that is poisitoned at the head of the list
        * the | is used to represent the iterator position.
         */
        ListIterator<String> iterator = staff.listIterator();// |TNPG
        /* The next method advances the iterator over the next element in the list. */

        iterator.next(); // T|NPG

        String avenger = iterator.next(); // TN|PG

        System.out.println(avenger);

        /* The add method inserts an element at the iterator poistion. 
            The iterator is then positiioned AFTER the element that was added.
        */

       iterator.add("Steve"); // TNS|PG
       iterator.add("Clint"); // TNSC|PG

       System.out.println(staff);

       /*
        the remove method remove the element returned by the last call to noext or previous
       */
        iterator.next();//TNSCP|G
        iterator.remove();// Peter is removed
        System.out.println(staff);

        /* The set method updates the element returned by the last call to next or previous */
        iterator.previous(); // TNS|CG
        iterator.set("T'Challa");

        System.out.println(staff);

        /* The hasNext method is used to determine if there is a next node after the iterator. The hasNext method is often used in the condition of a while loop */

        iterator = staff.listIterator(); // |TNSTG
        while(iterator.hasNext()){
            String n = iterator.next();
            if(n.equals("Natasha")){// TN|STG
                iterator.remove();// T|STG
            }
        } // TSTG|

        System.out.println(staff);

        /* Enhance for loops work with Linked Lists */
        for(String n: staff){
            System.out.print(n+ " ");
        }

        System.out.println();

        /* 
        ConcurrentModificationException
        
        CANNOT modify a linked list while using an iterator. UNLESS you use the iterator to do the modification
        */

       iterator = staff.listIterator(); // |TSTG

       while(iterator.hasNext()){
            String n = iterator.next();
            if(n.equals("Tony")){
                //staff.remove("Tony");
            }
       }
       /* The enhanced for loop AUTOMATICALLY creates an iterator. */
       for(String n: staff) {
            if(n.equals("Tony")){
                staff.add("Bruce");
            }
       }
        
    }
}