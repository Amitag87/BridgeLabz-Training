public class Author extends Book {
    private String name;
    private String bio;
    
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Title: " + title + ", Publication Year: " + publicationYear);
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
    }
}