import java.util.*;

public class DequeCommand {
    private final Scanner scanner = new Scanner(System.in);

    public void execute() {
        Deque deque = new LinkedList();

        while (true) {
            showOutMenu();
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Содержимое:\n" + deque);
                    break;
                case 2:
                    System.out.println("Пуст ли список: " + deque.isEmpty());
                    break;
                case 3:
                    Contains(deque);
                    break;
                case 4:
                    addFirst(deque);
                    break;
                case 5:
                    addLast(deque);
                    break;
                case 6:
                    deque.getFirst();
                    break;
                case 7:
                    deque.getLast();
                    break;
                case 8:
                    deque.pollFirst();
                    break;
                case 9:
                    deque.pollLast();
                    break;
                case 10:
                    deque.removeFirst();
                    break;
                case 11:
                    deque.removeLast();
                    break;
                default:
                    return;
            }
        }
    }


    private void addLast(Deque deque) {
        System.out.println("Введите элемент: ");
        String item = scanner.next();
        deque.addLast(item);
        System.out.println("Добавлено в конец" );
    }

    private void addFirst(Deque deque) {
        System.out.println("Введите элемент: ");
        String item = scanner.next();
        deque.addFirst(item);
        System.out.println("Добавлено в начало" );
    }

    private void Contains(Deque deque) {
        System.out.println("Введите элемент: ");
        String item = scanner.next();
        System.out.println("Содержится ли элемент:" + deque.contains(item));
    }

    private static void showOutMenu() {
        System.out.println("Выберите тип функцию:");
        System.out.println("1. Вывести");
        System.out.println("2. пуст ли список");
        System.out.println("3. содержит ли определенный элемент");
        System.out.println("4. добавить первым элементом");
        System.out.println("5. добавить последним элементом");
        System.out.println("6. вывести первый элемент");
        System.out.println("7. вывести последний элемент");
        System.out.println("8. получить первый элемент коллекции, удалив его при этом из самой коллекции ");
        System.out.println("9. получить последний элемент коллекции, удалив его при этом из самой коллекции ");
        System.out.println("10. удалить элемент из начала коллекции ");
        System.out.println("11. удалить элемент из конца коллекции  ");
        System.out.println("12. возврат в меню выбора коллекции ");
    }
}
