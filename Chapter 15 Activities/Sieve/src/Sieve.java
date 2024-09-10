import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Your work goes here
        Set<Integer> set = new HashSet<>();
        
        // Fill the set with numbers from 1 to n
        for (int i = 2; i <= n; i++) {
            set.add(i);
        }

        for(int k =2; k< n; k++){
            for(int i =2; i < n; i++){
                set.remove(i*k);
            }
        }


        /* for(int i = 2; i< n/2; i++ ){
            Iterator<Integer> iterator = set.iterator();

            while(iterator.hasNext()){
                int j = iterator.next();
                if(j % i == 0 && j>i){
                    iterator.remove();
                }
            }
        }
        */
        System.out.println(set);







    }
}
