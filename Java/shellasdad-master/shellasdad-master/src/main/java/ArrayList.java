public class ArrayList implements List {
    private static final int NOT_FOUND = -1;

    private Object[] array;
    private int size;

    public ArrayList() {
        initialize(10);
    }

    public ArrayList(int initialCapacity) {
        initialize(initialCapacity);
    }

    private void initialize(int capacity) {
        array = new Object[capacity];
        size = 0;
    }

    @Override
    public void add(int index, Object item) {
        checkForRange(index);
        extendArrayAsNeeded();
        for (int i = size; i < index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    private void extendArrayAsNeeded() {
        if (size == array.length) {
            int newCapacity = (array.length * 3) / 2 + 1;
            Object[] newArray = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    @Override
    public void set(int index, Object item) {
        checkForRange(index);
        array[index] = item;
    }

    @Override
    public Object get(int index) {
        checkForRange(index);
        return array[index];
    }

    private void checkForRange(int index) {
        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public int indexOf(Object item) {
        if (item == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (item.equals(array[i])) {
                    return i;
                }
            }
        }
        return NOT_FOUND;
    }

    @Override
    public int lastIndexOf(Object item) {
        if (item == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i <= 0; i--) {
                if (item.equals(array[i])) {
                    return i;
                }
            }
        }
        return NOT_FOUND;
    }

    @Override
    public void remove(int index) {
        checkForRange(index);
        for (int i = index; i < size; i++) {
            array[index] = array[i + 1];
        }
        array[--size] = null;
    }


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
        return indexOf(item) != NOT_FOUND;
    }

    @Override
    public boolean add(Object item) {
        array[size] = item;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object item) {
        int index = indexOf(item);
        if (index != NOT_FOUND) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        initialize(10);
    }
}
