package social.media.platform.linkedList;

public class LinkedList<T> {

    static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public static void main(String[] args) {
        // LinkedList<String> list = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();

       /*list.addFirst("T1");
        list.addFirst("T2");
        list.addFirst("T3");
        list.print();
        System.out.println();
        list.remove("T2");
        list.print();
        System.out.println();
        list.add(0, " T2");
        list.add(2, "Tomato");
        list.print();*/
        System.out.println();
        list.addFirst(3);
        list.addFirst(35);
        list.addFirst(32);
        list.addFirst(17);
        list.print();
        System.out.println();
        list.remove(3);
        list.print();

    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void remove(T data) {
        if (head == null) {
            System.out.println("The list is empty, deletion is not possible.");
            return;
        }

        if (head.data.equals(data)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
            return;
        }

        Node<T> current = head;
        while (current != null && !current.data.equals(data)) {
            current = current.next;
        }

        if (current != null) {
            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }

            if (current.prev != null) {
                current.prev.next = current.next;
            }
        } else {
            System.out.println("Element not found.");
        }
    }

    public void print() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

    }

    public void remove(int index) {
        if (head == null) {
            throw new NullPointerException("List is empty");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }
        if (index == 0) {
            head = head.next;
            return;
        }

        Node<T> currentNode = head;
        int count = 0;

        while (currentNode != null && count < index - 1) {
            currentNode = currentNode.next;
            count++;
        }

        if (currentNode == null || currentNode.next == null)
            throw new IndexOutOfBoundsException("Index out of bounds");

        currentNode.next = currentNode.next.next;

    }

    public void add(int index, T data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("The index cannot be negative.");
        }
        Node<T> newNode = new Node<>(data);

        if (index == 0) {
            if (head == null) { // Список пуст
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            return;
        }

        Node<T> current = head;
        int currentIndex = 0;

        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("The index exceeds the size of the list.");
        }
        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        } else { // Если вставка в конец
            tail = newNode;
        }
        current.next = newNode;
    }
}
