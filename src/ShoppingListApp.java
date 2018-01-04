import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

class ShoppingListApp {

    private Map<Ingredient, Quantity> shoppingList = new HashMap<>();

    void addIngredient(Ingredient ingredientToAdd, Quantity quantityToAdd) {

        if (shoppingList.containsKey(ingredientToAdd)){
            if(quantityToAdd.getClass().equals(shoppingList.get(ingredientToAdd).getClass())) {
                shoppingList.replace(ingredientToAdd, shoppingList.get(ingredientToAdd), shoppingList.get(ingredientToAdd).adding(quantityToAdd));
            }
            else
                try {
                    throw new Exception("Added quantity should be the same type as the existing quantity.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        else{
            shoppingList.put(ingredientToAdd, quantityToAdd);
        }
    }

    void deductIngredient(String name, Quantity quantityToDeduct) {
        Ingredient temp = new Ingredient(name,1);
        if(shoppingList.containsKey(temp)){
            //condition "if(quantityToDeduct.getClass().equals(shoppingList.get(temp).getClass()))" does not work here
            // as shoppingList.get(temp) returns DiscreteQuantity$1 rather than DiscreteQuantity
            if((quantityToDeduct instanceof DiscreteQuantity && (shoppingList.get(temp)) instanceof DiscreteQuantity)
                    ||(quantityToDeduct instanceof ContinuousQuantity && (shoppingList.get(temp)) instanceof ContinuousQuantity)){
                if(quantityToDeduct.getValue().doubleValue()<shoppingList.get(temp).getValue().doubleValue()){
                    shoppingList.replace(temp, shoppingList.get(temp), shoppingList.get(temp).subtracting(quantityToDeduct));
                }
                else{
                    shoppingList.remove(temp);
                }
            }else {
                try {
                    throw new Exception("Deducted quantity should be the same type as the existing one.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else System.out.println(name + " does not exist in the shopping list, thus it can't be deducted.");
    }

    void removeIngredient(Ingredient ingredient) {
        if (shoppingList.containsKey(ingredient)) {
            shoppingList.remove(ingredient);
        } else {
            System.out.println(ingredient.getName() + " does not exist in the shopping list, thus it cannot be removed.");
        }
    }

    double calculate() {
        double price = 0;
        DecimalFormat df = new DecimalFormat(".00");

        for (Ingredient ingredient : shoppingList.keySet()) {
            price += ingredient.getUnitPrice() * shoppingList.get(ingredient).getValue().doubleValue();
        }
        return Double.parseDouble(df.format(price));
    }

    Ingredient getIngredient(String name){
        for (Ingredient ingre1 : shoppingList.keySet()){
            if ((ingre1.getName().toLowerCase()).equals(name.toLowerCase())){
                return ingre1;
            }
        }

        return null;
    }

    Quantity getQuantity(Ingredient ingredient) {
        if (shoppingList.containsKey(ingredient)) {
                return shoppingList.get(ingredient);
            }
        else return null;
    }
}