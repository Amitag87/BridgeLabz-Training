import java.util.*;

class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}

class BackupTask implements Comparable<BackupTask> {
    String folderPath;
    int priority; // Higher number = higher priority
    String taskName;
    
    BackupTask(String folderPath, int priority, String taskName) throws InvalidBackupPathException {
        if (folderPath == null || folderPath.trim().isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path: " + folderPath);
        }
        this.folderPath = folderPath;
        this.priority = priority;
        this.taskName = taskName;
    }
    
    @Override
    public int compareTo(BackupTask other) {
        return Integer.compare(other.priority, this.priority); // Higher priority first
    }
    
    @Override
    public String toString() {
        return taskName + " (Priority: " + priority + ", Path: " + folderPath + ")";
    }
}

public class FileBackupScheduler {
    private PriorityQueue<BackupTask> backupQueue;
    
    public FileBackupScheduler() {
        this.backupQueue = new PriorityQueue<>();
    }
    
    public void scheduleBackup(String folderPath, int priority, String taskName) throws InvalidBackupPathException {
        BackupTask task = new BackupTask(folderPath, priority, taskName);
        backupQueue.offer(task);
        System.out.println("Scheduled: " + task);
    }
    
    public void executeBackups() {
        System.out.println("\\nExecuting backups in priority order:");
        
        while (!backupQueue.isEmpty()) {
            BackupTask task = backupQueue.poll();
            executeBackup(task);
        }
    }
    
    private void executeBackup(BackupTask task) {
        System.out.println("Backing up: " + task);
        // Simulate backup process
        try {
            Thread.sleep(100); // Simulate backup time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Backup completed for: " + task.taskName);
    }
    
    public void showPendingTasks() {
        System.out.println("\\nPending backup tasks:");
        PriorityQueue<BackupTask> temp = new PriorityQueue<>(backupQueue);
        
        while (!temp.isEmpty()) {
            System.out.println(temp.poll());
        }
    }
    
    public static void main(String[] args) {
        FileBackupScheduler scheduler = new FileBackupScheduler();
        
        try {
            // Schedule various backup tasks with different priorities
            scheduler.scheduleBackup("/critical/database", 10, "Database Backup");
            scheduler.scheduleBackup("/documents", 5, "Documents Backup");
            scheduler.scheduleBackup("/system/config", 9, "System Config Backup");
            scheduler.scheduleBackup("/user/photos", 3, "Photos Backup");
            scheduler.scheduleBackup("/logs", 7, "Logs Backup");
            
            scheduler.showPendingTasks();
            scheduler.executeBackups();
            
            // Try invalid path
            scheduler.scheduleBackup("", 5, "Invalid Backup");
            
        } catch (InvalidBackupPathException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}