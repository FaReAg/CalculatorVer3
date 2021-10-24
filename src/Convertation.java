import java.util.*;
import java.util.stream.Collectors;

    public enum Convertation {
        I(1),IV(4),V(5),IX(9),X(10),XL(40),L(50),XC(90),C(100);
              private int value;
        Convertation(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
             public static List<Convertation> reversedRoman() {
                  return Arrays.stream(values()).sorted(Comparator.comparing(Convertation::getValue).reversed()).collect(Collectors.toList());
    }

         public static String parseToRoman(int number) { // Convertacia Roman toArab
              if (number<1) throw new IllegalArgumentException("Erorre");
             StringBuilder result = new StringBuilder();
             for (Convertation romaNum : reversedRoman()) {
            while (number > (romaNum.getValue() - 1)) {
                result.append(romaNum);
                number -= romaNum.getValue();
            }
        }
        return result.toString();
    }

                public static int parseToArab(String s) { //Convertacia Roman toArab
                     if (s.isEmpty()||s==null) throw new IllegalArgumentException("Wrong Entry");
                       int i = 0, result = 0;
                       while ((s.length() > 0) && (i < Convertation.values().length))
                      if (s.startsWith(String.valueOf(reversedRoman().get(i)))){
                         result+= reversedRoman().get(i).getValue();
                         s = s.substring(String.valueOf(reversedRoman().get(i)).length());
            }
            else i++;
        if (s.length() > 0) throw new IllegalArgumentException("Wrong Entry");
        return result;
    }
}
