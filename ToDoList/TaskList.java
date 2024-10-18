package ToDoList;

public class TaskList {
    private class Node {
        Task task;
        Node next;
        Node prev;

        Node(Task task) {
            this.task = task;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;

    public TaskList() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void markTaskAsCompleted(String description) {
        Node current = head;
        while (current != null) {
            if (current.task.getDescription().equals(description)) {
                current.task.markAsCompleted();
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found: " + description);
    }

    public void deleteTask(int position) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        Node current = head;
        int currentIndex = 0;

        while (current != null && currentIndex != position) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            System.out.println("Task not found at position: " + position);
            return;
        }

        if (current.prev == null) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            current.prev.next = current.next;
            if (current.next != null) {
                current.next.prev = current.prev;
            }
        }

        current.next = null;
        current.prev = null;
    }

    public void printTasks() {
        Node current = head;
        int index = 0;
        while (current != null) {
            System.out.println(index + ": " + current.task);
            current = current.next;
            index++;
        }
    }
}
