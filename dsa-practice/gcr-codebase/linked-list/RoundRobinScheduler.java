class ProcessNode {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnaroundTime;
    ProcessNode next;
    
    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}

public class RoundRobinScheduler {
    private ProcessNode head;
    private ProcessNode current;
    private int timeQuantum = 3;
    private int currentTime = 0;
    
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        
        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
        } else {
            ProcessNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }
    
    public void removeProcess(int processId) {
        if (head == null) return;
        
        if (head.processId == processId && head.next == head) {
            head = null;
            current = null;
            return;
        }
        
        ProcessNode temp = head;
        ProcessNode prev = null;
        
        do {
            if (temp.processId == processId) {
                if (prev != null) {
                    prev.next = temp.next;
                } else {
                    ProcessNode last = head;
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
    
    public void simulate() {
        if (head == null) return;
        
        System.out.println("=== Round Robin Scheduling Simulation ===");
        System.out.println("Time Quantum: " + timeQuantum);
        
        while (hasRemainingProcesses()) {
            if (current.remainingTime > 0) {
                int executeTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= executeTime;
                currentTime += executeTime;
                
                System.out.println("Process " + current.processId + " executed for " + executeTime + 
                                 " units. Remaining: " + current.remainingTime);
                
                if (current.remainingTime == 0) {
                    current.turnaroundTime = currentTime;
                    current.waitingTime = current.turnaroundTime - current.burstTime;
                    System.out.println("Process " + current.processId + " completed");
                }
            }
            
            current = current.next;
        }
        
        calculateAverages();
    }
    
    private boolean hasRemainingProcesses() {
        ProcessNode temp = head;
        do {
            if (temp.remainingTime > 0) {
                return true;
            }
            temp = temp.next;
        } while (temp != head);
        return false;
    }
    
    private void calculateAverages() {
        double totalWaiting = 0;
        double totalTurnaround = 0;
        int count = 0;
        
        ProcessNode temp = head;
        do {
            totalWaiting += temp.waitingTime;
            totalTurnaround += temp.turnaroundTime;
            count++;
            temp = temp.next;
        } while (temp != head);
        
        System.out.println("\\n=== Results ===");
        System.out.println("Average Waiting Time: " + (totalWaiting / count));
        System.out.println("Average Turnaround Time: " + (totalTurnaround / count));
    }
    
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue");
            return;
        }
        
        System.out.println("=== Process Queue ===");
        ProcessNode temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + 
                             ", Priority: " + temp.priority + ", Remaining: " + temp.remainingTime);
            temp = temp.next;
        } while (temp != head);
    }
    
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        
        scheduler.displayProcesses();
        scheduler.simulate();
    }
}