import java.util.*;

public class SetCommand {
    private final Scanner scanner = new Scanner(System.in);

    public void execute() {


        Set set = new HashSet();
        while (true) {
            showOutMenu();
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Содержимое:\n" + set);
                    break;
                case 2:
                    System.out.println("Пуст ли список: " + set.isEmpty());
                    break;
                case 3:
                    Contains(set);
                    break;
                case 4:
                    add(set);
                    break;
                case 5:
                    remove(set);
                    break;
                default:
                    return;
            }
        }
    }

    private void remove(Set set) {
        System.out.println("Введите элемент: ");
        String item = scanner.next();
        set.remove(item);
        System.out.println("Удалено.");
    }

    private void add(Set set) {
        System.out.println("Введите элемент: ");
        String item = scanner.next();
        set.add(item);
        System.out.println("Добавлено.");
    }

    private void Contains(Set set) {
        System.out.println("Введите элемент: ");
        String item = scanner.next();
        System.out.println("Содержится ли элемент:" + set.contains(item));
    }
    private static void showOutMenu() {
        System.out.println("Выберите тип коллекции:");
        System.out.println("1.вывести список элементов коллекции");
        System.out.println("2. пуст ли список");
        System.out.println("3. содержит ли коллекция элемент");
        System.out.println("4. добавление элемента в конец списка ");
        System.out.println("5. удаление элемента");
        System.out.println("6. возврат в меню выбора коллекции");
    }
}
