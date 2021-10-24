public class Choice {

    private String expression;
    private String firstMember;
    private String secondMember;
    private String operation;
    private boolean isRoman; //Vibiraet Roman Arab

         public Choice(String expression) { // Proveriaet vvod znakov
              this.expression = expression;
                 String[] members = expression.trim().split("[+\\-*/]");
                 this.operation = expression.replaceAll("[\\d,\\w]","").trim();
                  if ((members.length!=2)||(this.operation.length()!=1)||!(this.operation.matches("[+\\-*/]")))
                   throw new IllegalArgumentException("Wrong input correct it");
                    this.firstMember = members[0].trim();
                    this.secondMember = members[1].trim();
                       setIsRoman();
    }

    private void setIsRoman(){ // Proverka Cifri odinakovogo tipa
          String arabicRegexp = "[0-9]+";
          String romeRegexp ="(?i)C{0,3}(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])" ;
        if (firstMember.matches(arabicRegexp) && secondMember.matches(arabicRegexp)) {
            this.isRoman = false;
        }
        else if (firstMember.matches(romeRegexp) && secondMember.matches(romeRegexp)) {
            this.isRoman = true;
        }
        else throw new IllegalArgumentException("Wrong");
    }

             public boolean isRoman() {
              return isRoman;
    }

                public int[] getMembers(){ // konvertacia chisla
                 int first = 0;
                 int second = 0;
                 if (!this.isRoman) {
                  first = Integer.parseInt(this.firstMember);
                    second = Integer.parseInt(this.secondMember);
        }
        else if (this.isRoman){
            first = Convertation.parseToArab(this.firstMember);
            second = Convertation.parseToArab(this.secondMember);
        }
               int[] result = new int[]{first, second};
                  return result;
    }

    public String getOperation() {
        return operation;
    }
}