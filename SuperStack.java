import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the function below.
     */
    static void superStack(String[] operations) {
            if(operations == null || operations.length ==0) {
                System.out.println("Empty");
                return;
            }
            LinkedList<Integer> list = new LinkedList<>();
            for(int i =0; i< operations.length; i++){
                String current = operations[i];
                if(current.equals("pop")){
                    list.removeLast();
                }
                else {
                if ( current.startsWith("push")){
                    list.addLast(Integer.parseInt(current.split(" ")[1]));
                }
                else {
                    int e = Integer.parseInt(current.split(" ")[1]);
                    int k = Integer.parseInt(current.split(" ")[2]);
                ListIterator<Integer> listIterator = list.listIterator();
                int j =1;
                while(listIterator.hasNext()){
                    if( j> e){
                        break;
                    }
                    listIterator.set(listIterator.next() + k);
                    j++;
                }
                }
                }
                if(list.isEmpty()) System.out.println("Empty");
                else System.out.println(list.getLast());
            }
    }
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int operations_size = 0;
        operations_size = Integer.parseInt(in.nextLine().trim());

        String[] operations = new String[operations_size];
        for(int i = 0; i < operations_size; i++) {
            String operations_item;
            try {
                operations_item = in.nextLine();
            } catch (Exception e) {
                operations_item = null;
            }
            operations[i] = operations_item;
        }

        superStack(operations);
        
    }
}
