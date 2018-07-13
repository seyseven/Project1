import java.util.Scanner;

public class Shell {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ListCommand listCommand = new ListCommand();
    private static final DequeCommand dequeCommand = new DequeCommand();
    private static final SetCommand setCommand = new SetCommand();
    private static final MapCommand mapCommand = new MapCommand();

    public static void main(String[] args) {
        while (true) {
            showOutMenu();
            switch (scanner.nextInt()) {
                case 1:
                    listCommand.execute();
                    break;
                case 2:
                    dequeCommand.execute();
                    break;
                case 3:
                    setCommand.execute();
                    break;
                case 4:
                    mapCommand.execute();
                    break;
                default:
                    return;
            }
        }
    }

    private static void showOutMenu() {
        System.out.println("Выберите тип коллекции:");
        System.out.println("1. List");
        System.out.println("2. Set");
        System.out.println("3. Deque");
        System.out.println("4. Map");
    }
}
