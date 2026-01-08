class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;
    
    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    private TaskNode head;
    private TaskNode current;
    
    public void addTask(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        
        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }
    
    public void removeTask(int taskId) {
        if (head == null) return;
        
        if (head.taskId == taskId && head.next == head) {
            head = null;
            current = null;
            return;
        }
        
        TaskNode temp = head;
        TaskNode prev = null;
        
        do {
            if (temp.taskId == taskId) {
                if (prev != null) {
                    prev.next = temp.next;
                } else {
                    TaskNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                }
                
                if (current == temp) {
                    current = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }
    
    public void viewCurrentTask() {
        if (current != null) {
            System.out.println("Current Task: ID=" + current.taskId + ", Name=" + current.taskName + 
                             ", Priority=" + current.priority + ", Due=" + current.dueDate);
        }
    }
    
    public void moveToNext() {
        if (current != null) {
            current = current.next;
            System.out.println("Moved to next task");
        }
    }
    
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }
        
        System.out.println("=== All Tasks ===");
        TaskNode temp = head;
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName + 
                             ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
    
    public TaskNode searchByPriority(int priority) {
        if (head == null) return null;
        
        TaskNode temp = head;
        do {
            if (temp.priority == priority) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);
        
        return null;
    }
    
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        
        scheduler.addTask(1, "Complete Project", 1, "2024-01-15");
        scheduler.addTask(2, "Review Code", 2, "2024-01-10");
        scheduler.addTask(3, "Write Tests", 3, "2024-01-12");
        
        scheduler.displayAllTasks();
        
        scheduler.viewCurrentTask();
        scheduler.moveToNext();
        scheduler.viewCurrentTask();
        
        scheduler.removeTask(2);
        System.out.println("\nAfter removing task 2:");
        scheduler.displayAllTasks();
    }
}