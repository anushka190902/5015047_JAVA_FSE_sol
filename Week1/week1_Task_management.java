class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskLinkedList {
    private Node head;

    public TaskLinkedList() {
        head = null;
    }

    // Method to add a task
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
        }
        System.out.println("Task added: " + task);
    }

    // Method to search for a task by ID
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Task not found
    }

    // Method to traverse and print all tasks
    public void traverseTasks() {
        Node current = head;
        System.out.println("Traversing tasks:");
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Method to delete a task by ID
    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false; // List is empty
        }

        // Handle case where the task to be deleted is the head
        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted: " + taskId);
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.task.taskId != taskId) {
            current = current.next;
        }

        if (current.next == null) {
            return false; // Task not found
        }

        // Remove the node
        current.next = current.next.next;
        System.out.println("Task deleted: " + taskId);
        return true;
    }

    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        // Adding tasks
        taskList.addTask(new Task(1, "Task A", "Pending"));
        taskList.addTask(new Task(2, "Task B", "In Progress"));
        taskList.addTask(new Task(3, "Task C", "Completed"));

        // Traversing tasks
        taskList.traverseTasks();

        // Searching for a task
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println("Task found: " + task);
        } else {
            System.out.println("Task not found.");
        }

        // Deleting a task
        boolean isDeleted = taskList.deleteTask(2);
        if (isDeleted) {
            taskList.traverseTasks();
        }
    }
}
