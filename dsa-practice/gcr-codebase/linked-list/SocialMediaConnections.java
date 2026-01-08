import java.util.ArrayList;
import java.util.List;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    UserNode next;
    
    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMediaConnections {
    private UserNode head;
    
    public void addUser(int userId, String name, int age) {
        UserNode newNode = new UserNode(userId, name, age);
        if (head == null) {
            head = newNode;
        } else {
            UserNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    
    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);
        
        if (user1 != null && user2 != null) {
            if (!user1.friendIds.contains(userId2)) {
                user1.friendIds.add(userId2);
            }
            if (!user2.friendIds.contains(userId1)) {
                user2.friendIds.add(userId1);
            }
            System.out.println("Friend connection added between " + userId1 + " and " + userId2);
        }
    }
    
    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);
        
        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(userId2));
            user2.friendIds.remove(Integer.valueOf(userId1));
            System.out.println("Friend connection removed between " + userId1 + " and " + userId2);
        }
    }
    
    public List<Integer> findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUser(userId1);
        UserNode user2 = findUser(userId2);
        List<Integer> mutualFriends = new ArrayList<>();
        
        if (user1 != null && user2 != null) {
            for (int friendId : user1.friendIds) {
                if (user2.friendIds.contains(friendId)) {
                    mutualFriends.add(friendId);
                }
            }
        }
        
        return mutualFriends;
    }
    
    public void displayFriends(int userId) {
        UserNode user = findUser(userId);
        if (user != null) {
            System.out.println("Friends of " + user.name + " (ID: " + userId + "):");
            for (int friendId : user.friendIds) {
                UserNode friend = findUser(friendId);
                if (friend != null) {
                    System.out.println("  - " + friend.name + " (ID: " + friendId + ")");
                }
            }
        }
    }
    
    public UserNode searchByName(String name) {
        UserNode current = head;
        while (current != null) {
            if (current.name.equals(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public UserNode findUser(int userId) {
        UserNode current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public int countFriends(int userId) {
        UserNode user = findUser(userId);
        return user != null ? user.friendIds.size() : 0;
    }
    
    public void displayAllUsers() {
        System.out.println("=== All Users ===");
        UserNode current = head;
        while (current != null) {
            System.out.println("ID: " + current.userId + ", Name: " + current.name + 
                             ", Age: " + current.age + ", Friends: " + current.friendIds.size());
            current = current.next;
        }
    }
    
    public static void main(String[] args) {
        SocialMediaConnections smc = new SocialMediaConnections();
        
        smc.addUser(1, "Alice", 25);
        smc.addUser(2, "Bob", 30);
        smc.addUser(3, "Charlie", 28);
        smc.addUser(4, "Diana", 26);
        
        smc.addFriendConnection(1, 2);
        smc.addFriendConnection(1, 3);
        smc.addFriendConnection(2, 3);
        smc.addFriendConnection(2, 4);
        
        smc.displayAllUsers();
        
        smc.displayFriends(1);
        smc.displayFriends(2);
        
        List<Integer> mutual = smc.findMutualFriends(1, 2);
        System.out.println("Mutual friends between Alice and Bob: " + mutual);
        
        System.out.println("Bob has " + smc.countFriends(2) + " friends");
    }
}