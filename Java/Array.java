import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Array<T> implements Iterable {
    private T[] arr;
    private int len = 0;
    private int capacity = 0;

    public Array() {
        this(16);
    }

    public Array(int capacity) {
        if (capacity < 0)
            throw new IllegalAccessError("Capacity can not be less than 0");
        arr = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T value) {
        arr[index] = value;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
            len = 0;
        }
    }

    public void add(T value) {
        if (len + 1 > capacity) {
            T[] new_arr = (T[]) new Object[capacity * 2];
            for (int i = 0; i < capacity; i++) {
                new_arr[i] = arr[i];
                arr = new_arr;
            }
            arr[len + 1] = value;
            len++;
        }
    }

    public T removeAt(int index) {
        if (index > len || index < 0)
            throw new IllegalAccessError();
        T temp = arr[index];
        T[] new_arr = (T[]) new Object[len - 1];
        for (int i = 0, j = 0; i < capacity; i++, j++) {
            if (i != index)
                j--;
            else
                new_arr[j] = arr[i];
        }
        len = len - 1;
        capacity = len;
        return temp;
    }

    public boolean remove(T object) {
        for (int i = 0; i < capacity; i++) {
            if (arr[i].equals(object))
                removeAt(i);
            return true;
        }
        return false;
    }

    public int indexOf(T object) {
        for (int i = 0; i < capacity; i++) {
            if (arr[i].equals(object))
                removeAt(i);
            return i;
        }
    }

    public boolean isContains(T object) {
        for (int i = 0; i < capacity; i++) {
            if (arr[i].equals(object))
                return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < len;
            }

            public T next() {
                return arr[index++];
            }
        };
        return null;
    }

    @Override
    public String toString() {
        if (len == 0)
            return "[]";
        else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (int i = 0; i < len - 1; i++) {
                stringBuilder.append(arr[i] + ",");
            }

            return stringBuilder.append(arr[len - 1] + "]").toString();
        }
    }

}