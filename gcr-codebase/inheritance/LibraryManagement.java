public class LibraryManagement {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", 2020);
        Author book2 = new Author("Effective Java", 2018, "Joshua Bloch", "Software engineer and Java architect");
        
        System.out.println("Library Management System");
        System.out.println("=========================");
        
        System.out.println("Book 1:");
        book1.displayInfo();
        System.out.println();
        
        System.out.println("Book 2 with Author:");
        book2.displayInfo();
    }
}