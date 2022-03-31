import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

     
class NumStack {
    int sum;
    ArrayList<Integer> currStack;
    
    NumStack() {
        currStack = new ArrayList<Integer>();
    }
    
    void push(int value) {
        currStack.add(value);
        this.sum += value;
    }
    
    void pop() {
        this.sum -= currStack.get(0);
        currStack.remove(0);
    }
}

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */
     
     static public NumStack processStack(List<Integer> h1) {
         NumStack s1 = new NumStack();
         for(Integer item : h1) {
             s1.push(item);
         }
         return s1;
     }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
    NumStack s1 = processStack(h1);
    NumStack s2 = processStack(h2);
    NumStack s3 = processStack(h3);
    while(s1.sum != s2.sum || s1.sum != s3.sum || s2.sum != s3.sum ) {
        int maxVal = Math.max(s1.sum, Math.max(s2.sum, s3.sum));
        if(s1.sum == maxVal) {
            s1.pop();
        } 
        if(s2.sum == maxVal) {
            s2.pop();
        }
        if(s3.sum == maxVal) {
            s3.pop();
        }
    }
        return s1.sum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

    }
}
