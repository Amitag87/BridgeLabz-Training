import java.util.*;

interface MealPlan {
    String getMealType();
    List<String> getRestrictions();
}

class VegetarianMeal implements MealPlan {
    public String getMealType() { return "Vegetarian"; }
    public List<String> getRestrictions() { 
        return Arrays.asList("No meat", "No fish"); 
    }
}

class VeganMeal implements MealPlan {
    public String getMealType() { return "Vegan"; }
    public List<String> getRestrictions() { 
        return Arrays.asList("No animal products", "No dairy", "No eggs"); 
    }
}

class KetoMeal implements MealPlan {
    public String getMealType() { return "Keto"; }
    public List<String> getRestrictions() { 
        return Arrays.asList("Low carb", "High fat", "Moderate protein"); 
    }
}

class HighProteinMeal implements MealPlan {
    public String getMealType() { return "High-Protein"; }
    public List<String> getRestrictions() { 
        return Arrays.asList("High protein content", "Lean meats preferred"); 
    }
}

class Meal<T extends MealPlan> {
    String mealName;
    T mealPlan;
    List<String> ingredients;
    
    Meal(String mealName, T mealPlan, List<String> ingredients) {
        this.mealName = mealName;
        this.mealPlan = mealPlan;
        this.ingredients = ingredients;
    }
    
    void displayMeal() {
        System.out.println("Meal: " + mealName);
        System.out.println("Type: " + mealPlan.getMealType());
        System.out.println("Ingredients: " + ingredients);
        System.out.println("Restrictions: " + mealPlan.getRestrictions());
    }
}

public class PersonalizedMealPlanGenerator {
    public static <T extends MealPlan> boolean validateMealPlan(Meal<T> meal) {
        // Simple validation - check if meal has ingredients
        if (meal.ingredients.isEmpty()) {
            System.out.println("Invalid meal plan: No ingredients specified");
            return false;
        }
        System.out.println("Meal plan validated for: " + meal.mealName);
        return true;
    }
    
    public static <T extends MealPlan> Meal<T> generateMealPlan(String mealName, T mealPlan, List<String> ingredients) {
        Meal<T> meal = new Meal<>(mealName, mealPlan, ingredients);
        if (validateMealPlan(meal)) {
            System.out.println("Generated meal plan: " + mealName);
            return meal;
        }
        return null;
    }
    
    public static void main(String[] args) {
        // Generate different meal plans
        Meal<VegetarianMeal> vegMeal = generateMealPlan(
            "Veggie Pasta", 
            new VegetarianMeal(), 
            Arrays.asList("Pasta", "Tomatoes", "Cheese", "Basil")
        );
        
        Meal<VeganMeal> veganMeal = generateMealPlan(
            "Quinoa Bowl", 
            new VeganMeal(), 
            Arrays.asList("Quinoa", "Avocado", "Chickpeas", "Spinach")
        );
        
        Meal<KetoMeal> ketoMeal = generateMealPlan(
            "Salmon Salad", 
            new KetoMeal(), 
            Arrays.asList("Salmon", "Lettuce", "Olive Oil", "Cheese")
        );
        
        Meal<HighProteinMeal> proteinMeal = generateMealPlan(
            "Chicken Bowl", 
            new HighProteinMeal(), 
            Arrays.asList("Chicken Breast", "Broccoli", "Brown Rice")
        );
        
        System.out.println("\\n=== Generated Meal Plans ===");
        if (vegMeal != null) vegMeal.displayMeal();
        System.out.println();
        if (veganMeal != null) veganMeal.displayMeal();
        System.out.println();
        if (ketoMeal != null) ketoMeal.displayMeal();
        System.out.println();
        if (proteinMeal != null) proteinMeal.displayMeal();
    }
}