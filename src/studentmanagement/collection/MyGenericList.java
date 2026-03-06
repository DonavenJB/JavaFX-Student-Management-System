package studentmanagement.collection;

import java.util.ArrayList;
import java.util.List;

public class MyGenericList<T extends Comparable<T>> {

    private class Node<T> {
        T value;
        Node<T> next;
    }

    private Node<T> first = null;
    private int count = 0;

    public MyGenericList() {
    }

    public List<T> fetchAllItems() {
        List<T> elements = new ArrayList<>();
        Node<T> current = first;
        while (current != null) {
            elements.add(current.value);
            current = current.next;
        }
        return elements;
    }

    public void add(T element) {
        Node<T> newNode = new Node<>();
        newNode.value = element;
        newNode.next = null;
        if (first == null) {
            first = newNode;
        } else {
            Node<T> lastNode = walkToTail(first);
            lastNode.next = newNode;
        }
        count++;
    }

    public T get(int pos) {
        if (pos < 0 || pos >= count) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }

        Node<T> nodePtr = first;
        for (int i = 0; i < pos; i++) {
            nodePtr = nodePtr.next;
        }
        return nodePtr.value;
    }

    public void delete(int pos) {
        if (pos < 0 || pos >= count) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }

        if (pos == 0) {
            first = first.next;
        } else {
            Node<T> prev = first;
            Node<T> current = first.next;
            for (int i = 1; i < pos; i++) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
        }
        count--;
    }

    private Node<T> walkToTail(Node<T> nodePointer) {
        return nodePointer.next == null ? nodePointer : walkToTail(nodePointer.next);
    }

    public int size() {
        return count;
    }

    public void sort() {
        List<T> elements = fetchAllItems();
        elements.sort(Comparable::compareTo);
        first = null;
        count = 0;
        for (T element : elements) {
            add(element);
        }
    }
}
