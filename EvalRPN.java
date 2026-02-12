import java.util.Deque;
import java.util.ArrayDeque;
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String t : tokens) {
            if (isOperator(t)) {
                int b = stack.pop();
                int a = stack.pop();
                int res = apply(a, b, t);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
    private boolean isOperator(String s) {
        return "+-*/".contains(s) && s.length() == 1;
    }
    private int apply(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": 
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] t1 = {"2","1","+","3","*"};
        System.out.println(s.evalRPN(t1)); // 9

        String[] t2 = {"4","13","5","/","+"};
        System.out.println(s.evalRPN(t2)); // 6

        String[] t3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(s.evalRPN(t3)); // 22
    }
}
