/*
В обычный калькулятор без логирования добавьте возможность отменить последнюю операцию.
Отмена последней операции должна быть реализована следующим образом:
если передан оператор '<' калькулятор должен вывести результат предпоследней операции.
оператор '<' калькулятор должен вывести результат предпоследней операции.

calculate('+', 3, 7)
calculate('+', 4, 7)
calculate('<', 0, 0)

10.0
11.0
10.0

calculate('*', 3, 2)
calculate('-', 7, 4)
calculate('<', 0, 0)

6.0
3.0
6.0
 */
import java.util.ArrayDeque;
import java.util.Deque;
public class case3 {
    static class Calculator {
        Deque<Integer> deque = new ArrayDeque<>();
        public double calculate(char op, int a, int b) {
            if (op == '+') {
                int c = a + b;
                deque.addFirst(c);
            } else if (op == '-') {
                int c = a - b;
                deque.addFirst(c);
            } else if (op == '*') {
                int c = a * b;
                deque.addFirst(c);
            } else if (op == '/') {
                int c = a / b;
                deque.addFirst(c);
            } else {
                deque.removeFirst();
            }

            return (double) deque.getFirst();
        }
    }


    // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
    public static class Printer {
        public static void main(String[] args) {
            int a, b, c, d;
            char op, op2, undo;

            if (args.length == 0) {
                // При отправке кода на Выполнение, вы можете варьировать эти параметры
                a = 3;
                op = '+';
                b = 7;
                c = 4;
                op2 = '+';
                d = 7;
                undo = '<';
            } else {
                a = Integer.parseInt(args[0]);
                op = args[1].charAt(0);
                b = Integer.parseInt(args[2]);
                c = Integer.parseInt(args[3]);
                op2 = args[4].charAt(0);
                d = Integer.parseInt(args[5]);
                undo = args[6].charAt(0);
            }

            Calculator calculator = new Calculator();
            double result = calculator.calculate(op, a, b);
            System.out.println(result);
            double result2 = calculator.calculate(op2, c, d);
            System.out.println(result2);
            double prevResult = calculator.calculate(undo, 0, 0);
            System.out.println(prevResult);
        }
    }
}
