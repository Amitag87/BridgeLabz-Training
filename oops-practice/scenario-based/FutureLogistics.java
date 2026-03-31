abstract class GoodsTransport {
    protected String transportId;
    protected String transportDate;
    protected int transportRating;
    
    public GoodsTransport(String transportId, String transportDate, int transportRating) {
        this.transportId = transportId;
        this.transportDate = transportDate;
        this.transportRating = transportRating;
    }
    
    // Getter and setter methods
    public String getTransportId() {
        return transportId;
    }
    
    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }
    
    public String getTransportDate() {
        return transportDate;
    }
    
    public void setTransportDate(String transportDate) {
        this.transportDate = transportDate;
    }
    
    public int getTransportRating() {
        return transportRating;
    }
    
    public void setTransportRating(int transportRating) {
        this.transportRating = transportRating;
    }
    
    abstract public String vehicleSelection();
    abstract public float calculateTotalCharge();
}

class BrickTransport extends GoodsTransport {
    private float brickSize;
    private int brickQuantity;
    private float brickPrice;
    
    public BrickTransport(String transportId, String transportDate, int transportRating, 
                         float brickSize, int brickQuantity, float brickPrice) {
        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }
    
    // Getter and setter methods
    public float getBrickSize() {
        return brickSize;
    }
    
    public void setBrickSize(float brickSize) {
        this.brickSize = brickSize;
    }
    
    public int getBrickQuantity() {
        return brickQuantity;
    }
    
    public void setBrickQuantity(int brickQuantity) {
        this.brickQuantity = brickQuantity;
    }
    
    public float getBrickPrice() {
        return brickPrice;
    }
    
    public void setBrickPrice(float brickPrice) {
        this.brickPrice = brickPrice;
    }
    
    @Override
    public String vehicleSelection() {
        if (brickQuantity < 300) {
            return "Truck";
        } else if (brickQuantity >= 300 && brickQuantity <= 500) {
            return "Lorry";
        } else {
            return "MonsterLorry";
        }
    }
    
    @Override
    public float calculateTotalCharge() {
        float price = brickPrice * brickQuantity;
        float tax = price * 0.3f;
        float vehiclePrice = getVehiclePrice();
        float discountPercentage = getDiscountPercentage();
        float discount = price * discountPercentage / 100;
        return (price + vehiclePrice + tax) - discount;
    }
    
    private float getVehiclePrice() {
        String vehicle = vehicleSelection().toLowerCase();
        if (vehicle.contains("truck")) {
            return 1000;
        } else if (vehicle.contains("lorry")) {
            return 1700;
        } else {
            return 3000;
        }
    }
    
    private float getDiscountPercentage() {
        if (transportRating == 5) {
            return 20;
        } else if (transportRating == 3 || transportRating == 4) {
            return 10;
        } else {
            return 0;
        }
    }
}

class TimberTransport extends GoodsTransport {
    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;
    
    public TimberTransport(String transportId, String transportDate, int transportRating,
                          float timberLength, float timberRadius, String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }
    
    // Getter and setter methods
    public float getTimberLength() {
        return timberLength;
    }
    
    public void setTimberLength(float timberLength) {
        this.timberLength = timberLength;
    }
    
    public float getTimberRadius() {
        return timberRadius;
    }
    
    public void setTimberRadius(float timberRadius) {
        this.timberRadius = timberRadius;
    }
    
    public String getTimberType() {
        return timberType;
    }
    
    public void setTimberType(String timberType) {
        this.timberType = timberType;
    }
    
    public float getTimberPrice() {
        return timberPrice;
    }
    
    public void setTimberPrice(float timberPrice) {
        this.timberPrice = timberPrice;
    }
    
    @Override
    public String vehicleSelection() {
        float area = 2 * 3.147f * timberRadius * timberLength;
        if (area < 250) {
            return "Truck";
        } else if (area >= 250 && area <= 400) {
            return "Lorry";
        } else {
            return "MonsterLorry";
        }
    }
    
    @Override
    public float calculateTotalCharge() {
        float volume = 3.147f * timberRadius * timberRadius * timberLength;
        float typeMultiplier = timberType.equalsIgnoreCase("Premium") ? 0.25f : 0.15f;
        float price = volume * timberPrice * typeMultiplier;
        float tax = price * 0.3f;
        float vehiclePrice = getVehiclePrice();
        float discountPercentage = getDiscountPercentage();
        float discount = price * discountPercentage / 100;
        return (price + vehiclePrice + tax) - discount;
    }
    
    private float getVehiclePrice() {
        String vehicle = vehicleSelection().toLowerCase();
        if (vehicle.contains("truck")) {
            return 1000;
        } else if (vehicle.contains("lorry")) {
            return 1700;
        } else {
            return 3000;
        }
    }
    
    private float getDiscountPercentage() {
        if (transportRating == 5) {
            return 20;
        } else if (transportRating == 3 || transportRating == 4) {
            return 10;
        } else {
            return 0;
        }
    }
}

class Utility {
    public static GoodsTransport parseDetails(String input) {
        String[] parts = input.split(":");
        String transportType = parts[3].trim();
        
        if (transportType.equalsIgnoreCase("BrickTransport")) {
            return new BrickTransport(parts[0].trim(), parts[1].trim(), 
                                    Integer.parseInt(parts[2].trim()), 
                                    Float.parseFloat(parts[4].trim()), 
                                    Integer.parseInt(parts[5].trim()),
                                    Float.parseFloat(parts[6].trim()));
        } else if (transportType.equalsIgnoreCase("TimberTransport")) {
            return new TimberTransport(parts[0].trim(), parts[1].trim(), 
                                     Integer.parseInt(parts[2].trim()),
                                     Float.parseFloat(parts[4].trim()),
                                     Float.parseFloat(parts[5].trim()),
                                     parts[6].trim(),
                                     Float.parseFloat(parts[7].trim()));
        }
        return null;
    }
    
    public static boolean validateTransportId(String transportId) {
        if (transportId.length() != 6 || 
            !transportId.substring(0, 3).equals("RTS") ||
            !transportId.substring(3, 6).matches("\\d{3}") ||
            !Character.isUpperCase(transportId.charAt(5))) {
            System.out.println("Transport id " + transportId + " is invalid");
            System.out.println("Please provide a valid record");
            return false;
        }
        return true;
    }
    
    public static String findObjectType(GoodsTransport goodsTransport) {
        if (goodsTransport instanceof TimberTransport) {
            return "TimberTransport";
        } else if (goodsTransport instanceof BrickTransport) {
            return "BrickTransport";
        }
        return "";
    }
}

public class FutureLogistics {
    public static void main(String[] args) {
        System.out.println("Enter the Goods Transport details");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine();
        
        String[] parts = input.split(":");
        String transportId = parts[0].trim();
        
        if (!Utility.validateTransportId(transportId)) {
            return;
        }
        
        GoodsTransport transport = Utility.parseDetails(input);
        String type = Utility.findObjectType(transport);
        
        if (type.equals("TimberTransport")) {
            TimberTransport timber = (TimberTransport) transport;
            timber.calculateTotalCharge();
            System.out.println("Transporter id : " + transport.getTransportId());
            System.out.println("Date of transport : " + transport.getTransportDate());
            System.out.println("Rating of the transport : " + transport.getTransportRating());
            System.out.println("Type of the timber : " + timber.getTimberType());
            System.out.println("Timber price per kilo : " + timber.getTimberPrice());
            System.out.println("Vehicle for transport : " + timber.vehicleSelection());
            System.out.printf("Total charge : %.3f%n", timber.calculateTotalCharge());
        } else if (type.equals("BrickTransport")) {
            BrickTransport brick = (BrickTransport) transport;
            brick.calculateTotalCharge();
            System.out.println("Transporter id : " + transport.getTransportId());
            System.out.println("Date of transport : " + transport.getTransportDate());
            System.out.println("Rating of the transport : " + transport.getTransportRating());
            System.out.println("Quantity of bricks : " + brick.getBrickQuantity());
            System.out.println("Brick price : " + brick.getBrickPrice());
            System.out.println("Vehicle for transport : " + brick.vehicleSelection());
            System.out.printf("Total charge : %.1f%n", brick.calculateTotalCharge());
        }
    }
}
