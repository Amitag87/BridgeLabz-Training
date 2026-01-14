class CircularTour {
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        
        int start = findStartingPoint(petrol, distance);
        if (start == -1) {
            System.out.println("No solution exists");
        } else {
            System.out.println("Starting point: " + start);
        }
    }
    
    static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalPetrol = 0, totalDistance = 0;
        int currentPetrol = 0, start = 0;
        
        for (int i = 0; i < n; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            currentPetrol += petrol[i] - distance[i];
            
            if (currentPetrol < 0) {
                start = i + 1;
                currentPetrol = 0;
            }
        }
        return totalPetrol >= totalDistance ? start : -1;
    }
}
