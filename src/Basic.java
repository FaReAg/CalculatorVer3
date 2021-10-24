import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Basic {
    public static void main(String[] args) {
        System.out.println("Input");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // Vvod primera
                  try{
                    Choice reader = new Choice(input.readLine());
                     System.out.println(" = "+ Solution.calculate(reader));
              } catch (IOException e) {
                      e.printStackTrace();
           }catch (IllegalArgumentException e){ // Vidaet soobshenie o nepravilnom vvode
              System.out.println(e.getMessage());
        }
    }
}