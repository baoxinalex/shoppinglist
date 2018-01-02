public class Testing {

    public static void main(String[] args) {

        Ingredient egg = new Ingredient("egg", 0.5);
        Ingredient water = new Ingredient("water", 0.3);
        Ingredient flour = new Ingredient("flour", 1);
        Ingredient sugar = new Ingredient("sugar", 0.01);
        Ingredient apple = new Ingredient("apple", 0.2);
        Ingredient oil = new Ingredient("oil", 1.2);

        DiscreteQuantity q1 = new DiscreteQuantity(3);
        Quantity q2 = new ContinuousQuantity(2.3, "L");
        Quantity q3 = new DiscreteQuantity(5);
        Quantity q4 = new ContinuousQuantity(4.3, "L");
        Quantity q5 = new DiscreteQuantity(7);
        Quantity q6 = new ContinuousQuantity(6.3, "L");
        Quantity q7 = new DiscreteQuantity(9);
        Quantity q8 = new ContinuousQuantity(8.3, "L");

        //1.1 add all ingredient to the shopping list
        ShoppingListApp shoppingListApp = new ShoppingListApp();
        shoppingListApp.addIngredient(egg,q1); //1.5
        shoppingListApp.addIngredient(egg,q8); //exception
        shoppingListApp.addIngredient(water,q2); //0.69
        shoppingListApp.addIngredient(flour,q4);// 4.3
        shoppingListApp.addIngredient(apple,q5); //1.4

        //1.2 all should be added and egg's quantity should be still q1
        System.out.println(shoppingListApp.getQuantity(egg).getValue());
        System.out.println(shoppingListApp.getQuantity(water).getValue());
        System.out.println(shoppingListApp.getQuantity(flour).getValue());
        System.out.println(shoppingListApp.getQuantity(apple).getValue());


        //1.3 add the same object, egg quantity value should be 8
        shoppingListApp.addIngredient(egg, q3);
        System.out.println(shoppingListApp.getQuantity(egg).getValue()); //8

        //2.1 deduct sugar which is not in the list, it should throw exception
        shoppingListApp.deductIngredient("sugar",q1);
        //2.2 deduct egg in the list, it should be removed
        shoppingListApp.deductIngredient("egg",q1);

        //3.1 remove sugar and it should promopt that sugar is not in the shopping lis
        shoppingListApp.removeIngredient(sugar);
        //3.2 remove the apple, and it should print null
        shoppingListApp.removeIngredient(apple);
        System.out.println(shoppingListApp.getQuantity(apple));

        //4 after exception is thrown, calcluation should not include the objects that failed to add in the list
        System.out.println(shoppingListApp.calculate()); //7.49

        //5.1 it should print out egg
        System.out.println(shoppingListApp.getIngredient("egg").getName());
        //5.2 it should print null
        System.out.println(shoppingListApp.getIngredient("sugar"));

        //6.1 it should print out 5
        System.out.println(shoppingListApp.getQuantity(egg).getValue());
        //6.2 it should print out null
        System.out.println(shoppingListApp.getQuantity(sugar));
    }
}
