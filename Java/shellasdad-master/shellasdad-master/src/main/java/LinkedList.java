import java.util.NoSuchElementException;

public class LinkedList implements Deque {
    private static final int NOT_FOUND = -1;

    private static class Node {
        private Object item;
        private Node next;
        private Node prev;
    }

    private Node first;
    private Node last;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object item) {
        Node buffFirst = new Node();
        buffFirst = first;
        for (int i = 0; i < size; i++) {
            if (item.equals(buffFirst.item)) {
                return true;
            } else {
                buffFirst = buffFirst.next;
            }
        }
        return false;
    }

    @Override
    public boolean add(Object item) {
        addLast(item);
        return true;
    }

    @Override
    public boolean remove(Object item) {
        Node removingNode = getNode(item);
        if (removingNode != null) {
            removeNode(removingNode);
            return true;
        } else {
            return false;
        }
    }

    private Node getNode(Object item) {
        Node buff = first;
        for (int i = 0; i < size; i++) {
            if (item.equals(buff.item)) {
                return buff;
            } else {
                buff = buff.next;
            }
        }

        return null;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }

    @Override
    public void addFirst(Object item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = first;
        if (first != null) {
            first.prev = newNode;
        } else {
            last = newNode;
        }
        first = newNode;
        size++;
    }

    @Override
    public void addLast(Object item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.prev = last;
        if (last != null) {
            last.next = newNode;
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
    }

    @Override
    public Object getFirst() {
        checkForNotEmpty();
        return first.item;
    }

    private void checkForNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Object getLast() {
        checkForNotEmpty();
        return last.item;
    }

    @Override
    public Object pollFirst() {
        try {
            return removeFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public Object pollLast() {
        try {
            return removeLast();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public Object removeFirst() {
        checkForNotEmpty();
        Object result = first.item;
        removeNode(first);
        return result;
    }

    @Override
    public Object removeLast() {
        checkForNotEmpty();
        Object result = last.item;
        removeNode(last);
        return result;
    }

    private void removeNode(Node removingNode) {
        if (removingNode.prev != null) {
            removingNode.prev.next = removingNode.next;
        } else {
            first = removingNode.next;
        }

        if (removingNode.next != null) {
            removingNode.next.prev = removingNode.prev;
        } else {
            last = removingNode.prev;
        }

        size--;
    }
}
