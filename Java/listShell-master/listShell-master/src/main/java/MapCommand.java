import java.util.*;

public class MapCommand {
    private final Scanner scanner = new Scanner(System.in);

    public void execute() {
        Map map = new HashMap();

        while (true) {
            showOutMenu();
            switch (scanner.nextInt()) {
                case 1:
                System.out.println("Содержимое:\n" + map);break;
                case 2:
                    System.out.println("Пуст ли список: " + map.isEmpty());break;
                case 3:
                    get(map);break;
                case 4:
                    put(map);break;
                case 5:
                    remove(map);break;
                default:
                    return;
            }
        }
    }

    private void remove(Map map) {
        System.out.println("Введите элемент: ");
        String item = scanner.next();
        map.remove(item);
        System.out.println("Удален элемент " + item);
    }

    private void put(Map map) {
        System.out.println("Введите элемент: ");
        String item = scanner.next();
        System.out.println("Введите ключ: ");
        int key = scanner.nextInt();
        map.put(key,item);
        System.out.println("Вставлено.");
    }

    private void get(Map map) {
        System.out.println("Введите элемент: ");
        String item = scanner.next();
        System.out.println("Элемент: " + map.get(item));
    }

    private static void showOutMenu() {
        System.out.println("Выберите тип коллекции:");
        System.out.println("1. вывести список элементов коллекции");
        System.out.println("2. пуст ли список");
        System.out.println("3. получение элемента коллекции");
        System.out.println("4. добавление элемента в коллекцию");
        System.out.println("4. удаление элемента из коллекции ");
        System.out.println("4. возврат в меню выбора коллекции");
    }
}
