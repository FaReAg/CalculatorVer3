public class Solution {
       public static String calculate(Choice express){
        double computation = operation(express);
        String result;
        if (express.isRoman()) result = (Convertation.parseToRoman((int) computation));
        else result = String.valueOf(computation);
        return result;
    }

            private static double operation(Choice express){ // Raschet
                 int num1 = express.getMembers()[0];
                 int num2 = express.getMembers()[1];
                   switch (express.getOperation()){
                        case "+": return (num1+num2);
                       case "-": return (num1-num2);
                          case "*": return (num1*num2);
                          case "/": return (num1/num2);

        }
        return 0;
    }
}
