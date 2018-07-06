import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Time extends com{

    private PrintStream printStream;

    public Time(){
        this.printStream = printStream;
    }

    public void execute(){
        Date date = new Date();
        SimpleDateFormat formatime = new SimpleDateFormat("kk:mm:ss zzz");
        String d = formatime.format(date);
        printStream.println(d);
    }
    public void getHelp(){
    }
}

class Dates extends com{
    public void execute(){
        Date date = new Date();
        SimpleDateFormat formtime = new SimpleDateFormat("dd:mm:yyyy E");
        String d = formtime.format(date);
        System.out.println(d);
    }
}