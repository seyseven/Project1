import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args){

        Map<String,com> commands = new HashMap<String,com>();
        commands.put("time", new Time());
        commands.put("message", new Message());
        commands.put("exit", new Quit());
        commands.put("date", new Dates());

        Scanner scan = new Scanner(System.in);

        String s;
        while(true){
            System.out.print("> ");
            s = scan.nextLine();
            if(commands.get(s) != null)
                commands.get(s).execute();
        }
    }
}
class Calc{

    public int sum (int number1, int number2){
        return number1 + number2;
    }
    public int sub (int number1, int number2){
        return number1 - number2;
    }
    public int mul (int number1, int number2){
        return number1 * number2;
    }
    public int div (int number1, int number2){
        return number1 / number2;
    }
}