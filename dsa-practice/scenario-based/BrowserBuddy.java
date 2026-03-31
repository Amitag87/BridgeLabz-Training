import java.util.Stack;

class HistoryNode {
    String url;
    HistoryNode prev;
    HistoryNode next;
    
    HistoryNode(String url) {
        this.url = url;
    }
}

class Tab {
    String tabId;
    HistoryNode current;
    
    Tab(String tabId, String initialUrl) {
        this.tabId = tabId;
        this.current = new HistoryNode(initialUrl);
    }
}

public class BrowserBuddy {
    private Tab activeTab;
    private Stack<Tab> closedTabs;
    
    public BrowserBuddy() {
        this.closedTabs = new Stack<>();
    }
    
    public void openTab(String tabId, String url) {
        activeTab = new Tab(tabId, url);
        System.out.println("Opened tab " + tabId + " with " + url);
    }
    
    public void navigate(String url) {
        if (activeTab == null) {
            System.out.println("No active tab!");
            return;
        }
        
        HistoryNode newNode = new HistoryNode(url);
        newNode.prev = activeTab.current;
        activeTab.current.next = newNode;
        activeTab.current = newNode;
        
        System.out.println("Navigated to: " + url);
    }
    
    public void goBack() {
        if (activeTab == null || activeTab.current.prev == null) {
            System.out.println("Cannot go back!");
            return;
        }
        
        activeTab.current = activeTab.current.prev;
        System.out.println("Back to: " + activeTab.current.url);
    }
    
    public void goForward() {
        if (activeTab == null || activeTab.current.next == null) {
            System.out.println("Cannot go forward!");
            return;
        }
        
        activeTab.current = activeTab.current.next;
        System.out.println("Forward to: " + activeTab.current.url);
    }
    
    public void closeTab() {
        if (activeTab == null) {
            System.out.println("No tab to close!");
            return;
        }
        
        closedTabs.push(activeTab);
        System.out.println("Closed tab: " + activeTab.tabId);
        activeTab = null;
    }
    
    public void reopenTab() {
        if (closedTabs.isEmpty()) {
            System.out.println("No closed tabs to reopen!");
            return;
        }
        
        activeTab = closedTabs.pop();
        System.out.println("Reopened tab: " + activeTab.tabId + " at " + activeTab.current.url);
    }
    
    public void showHistory() {
        if (activeTab == null) {
            System.out.println("No active tab!");
            return;
        }
        
        System.out.println("\n=== Tab History for " + activeTab.tabId + " ===");
        
        // Go to start of history
        HistoryNode start = activeTab.current;
        while (start.prev != null) {
            start = start.prev;
        }
        
        // Print history with current marker
        HistoryNode temp = start;
        while (temp != null) {
            String marker = (temp == activeTab.current) ? " <- CURRENT" : "";
            System.out.println(temp.url + marker);
            temp = temp.next;
        }
        System.out.println("===============================\n");
    }
    
    public void showClosedTabs() {
        System.out.println("\n=== Closed Tabs ===");
        if (closedTabs.isEmpty()) {
            System.out.println("No closed tabs");
        } else {
            for (int i = closedTabs.size() - 1; i >= 0; i--) {
                Tab tab = closedTabs.get(i);
                System.out.println((closedTabs.size() - i) + ". " + tab.tabId + " - " + tab.current.url);
            }
        }
        System.out.println("===================\n");
    }
    
    public void getCurrentPage() {
        if (activeTab == null) {
            System.out.println("No active tab!");
            return;
        }
        System.out.println("Current page: " + activeTab.current.url + " (Tab: " + activeTab.tabId + ")");
    }
    
    public static void main(String[] args) {
        BrowserBuddy browser = new BrowserBuddy();
        
        // Open tab and navigate
        browser.openTab("Tab1", "google.com");
        browser.navigate("github.com");
        browser.navigate("stackoverflow.com");
        browser.navigate("leetcode.com");
        
        browser.showHistory();
        
        // Test back/forward navigation
        browser.goBack();
        browser.goBack();
        browser.getCurrentPage();
        
        browser.goForward();
        browser.getCurrentPage();
        
        browser.showHistory();
        
        // Close and reopen tab
        browser.closeTab();
        browser.showClosedTabs();
        
        browser.openTab("Tab2", "amazon.com");
        browser.navigate("netflix.com");
        
        browser.closeTab();
        browser.showClosedTabs();
        
        // Reopen tabs
        browser.reopenTab();
        browser.getCurrentPage();
        
        browser.reopenTab();
        browser.getCurrentPage();
        browser.showHistory();
    }
}