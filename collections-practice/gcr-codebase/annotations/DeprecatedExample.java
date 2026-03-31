class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("Using old feature - not recommended");
    }
    
    public void newFeature() {
        System.out.println("Using new improved feature");
    }
}

public class DeprecatedExample {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        
        api.oldFeature(); // This will show deprecation warning
        api.newFeature();
    }
}