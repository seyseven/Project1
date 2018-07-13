import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListCommand {

    private final Scanner scanner = new Scanner(System.in);

    public void execute() {


        List list = new ArrayList();
        while (true) {
            showOutMenu();
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Содержимое:\n" + list);
                    break;
                case 2:
                    System.out.println("Пуст ли список: " + list.isEmpty());
                    break;
                case 3:
                    contains(list);
                    break;
                case 4:
                    addition(list);
                    break;
                case 5:
                    addByIndex(list);
                case 6:
                    getByIndex(list);
                case 7:
                    remove(list);
                case 8:
                    removeByIndex(list);
                default:
                    return;
            }
        }
    }

    private void removeByIndex(List list) {

        System.out.println("Введите индекс: ");
        int index = scanner.nextInt();
        list.remove(index);
        System.out.println("Удалено опо индексу " + index);
    }

    private void remove(List list) {
        System.out.println("Введите элемент: ");
        int item = scanner.nextInt();
        list.remove(item);
        System.out.println("Удален элемент " + item);
    }

    private void getByIndex(List list) {
        System.out.println("Введите индекс: ");
        int index = scanner.nextInt();
        System.out.println("Результат: " + list.get(index) );
    }

    private void addByIndex(List list) {
        System.out.println("ввелите элемент: ");
        String item = scanner.next();
        System.out.println("Введите индекс: ");
        int index = scanner.nextInt();
        list.add(index,item);
        System.out.println("добавлено." );
    }

    private void addition(List list) {
        System.out.println("Введите элемент: ");
        String item = scanner.next();
        System.out.println("Добавлено: "+ list.add(item));
    }

    private void contains(List list) {
        System.out.print("Введите элемент: ");
        String item = scanner.next();
        System.out.println("Содержится ли элемент:" + list.contains(item));
    }

    private static void showOutMenu() {
        System.out.println("Выберите тип функцию:");
        System.out.println("1. Вывести");
        System.out.println("2. пуст ли список");
        System.out.println("3. содержит ли определенный элемент");
        System.out.println("4. добавить в конец списка");
        System.out.println("5. добавить по индексу");
        System.out.println("6. показать по индексу");
        System.out.println("7. удалить");
        System.out.println("8. удалить по индексу");
        System.out.println("9. в меню");
    }
}
