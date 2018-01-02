public class Ingredient{
    private String name;
    private double unitPrice;

    Ingredient(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    String getName(){
        return name;
    }

    double getUnitPrice() {
        return unitPrice;
    }

    public boolean equals(Object obj){

        if(!(obj instanceof Ingredient)){
            return false;
        }
        return this.getName().toLowerCase().equals(((Ingredient) obj).getName().toLowerCase());
    }

    public int hashCode(){
        return name.hashCode();
    }
}

