import java.util.Stack;

public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if (s.equals("(")) {
                // Ignora parênteses abertos
            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
                ops.push(s); // Empilha operadores
            } else if (s.equals(")")) {
                // Quando encontra um parêntese fechado, desempilha e avalia a operação
                String op = ops.pop();
                double v = vals.pop();

                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    v = vals.pop() / v;
                } else if (op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }

                vals.push(v); // Empilha o resultado da operação
            } else {
                // Se não for um operador ou parêntese, empilha o valor como double
                vals.push(Double.parseDouble(s));
            }
        }

        // O resultado final é o último valor na pilha de valores
        StdOut.println(vals.pop());
    }
}