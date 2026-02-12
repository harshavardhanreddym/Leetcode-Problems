import java.util.*;

public class Solution {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;

        for (int num : pushed) {
            stack.push(num);

            while (!stack.isEmpty() && j < popped.length 
                    && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }

    // Optional main method for testing locally
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,2,1};

        System.out.println(validateStackSequences(pushed, popped));
    }
}
