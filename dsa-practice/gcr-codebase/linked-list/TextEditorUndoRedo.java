class TextStateNode {
    String content;
    TextStateNode next;
    TextStateNode prev;
    
    public TextStateNode(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

public class TextEditorUndoRedo {
    private TextStateNode current;
    private int maxHistorySize = 10;
    private int currentSize = 0;
    
    public TextEditorUndoRedo() {
        current = new TextStateNode("");
        currentSize = 1;
    }
    
    public void addState(String newContent) {
        TextStateNode newNode = new TextStateNode(newContent);
        
        // Remove any forward history (redo states)
        current.next = null;
        
        // Add new state
        newNode.prev = current;
        current.next = newNode;
        current = newNode;
        currentSize++;
        
        // Maintain history size limit
        if (currentSize > maxHistorySize) {
            removeOldestState();
        }
        
        System.out.println("New state added: \"" + newContent + "\"");
    }
    
    private void removeOldestState() {
        TextStateNode temp = current;
        
        // Find the head (oldest state)
        while (temp.prev != null) {
            temp = temp.prev;
        }
        
        // Remove the oldest state
        if (temp.next != null) {
            temp.next.prev = null;
            currentSize--;
        }
    }
    
    public boolean undo() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed");
            return true;
        } else {
            System.out.println("Cannot undo - at the beginning of history");
            return false;
        }
    }
    
    public boolean redo() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Redo performed");
            return true;
        } else {
            System.out.println("Cannot redo - at the end of history");
            return false;
        }
    }
    
    public String getCurrentState() {
        return current.content;
    }
    
    public void displayCurrentState() {
        System.out.println("Current text: \"" + getCurrentState() + "\"");
    }
    
    public void displayHistory() {
        System.out.println("=== Text History ===");
        TextStateNode temp = current;
        
        // Go to the beginning
        while (temp.prev != null) {
            temp = temp.prev;
        }
        
        // Display all states
        int index = 0;
        while (temp != null) {
            String marker = (temp == current) ? " <- CURRENT" : "";
            System.out.println(index + ": \"" + temp.content + "\"" + marker);
            temp = temp.next;
            index++;
        }
    }
    
    public static void main(String[] args) {
        TextEditorUndoRedo editor = new TextEditorUndoRedo();
        
        editor.displayCurrentState();
        
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.addState("Hello World! How are you?");
        
        editor.displayHistory();
        
        editor.undo();
        editor.displayCurrentState();
        
        editor.undo();
        editor.displayCurrentState();
        
        editor.redo();
        editor.displayCurrentState();
        
        editor.addState("Hello World! Good morning.");
        
        System.out.println("\\nFinal history:");
        editor.displayHistory();
    }
}