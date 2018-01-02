public class DiscreteQuantity extends Quantity {
    private int q;

    DiscreteQuantity(int q) {
        if (quantityPositiveNumber(q)){
            this.q = q;
        }
    }

    private boolean quantityPositiveNumber(int q){
        if(q>0){
            return true;
        }
        else throw new IndexOutOfBoundsException("Quantity should not be negative or 0.");
    }

    public Quantity adding(Quantity w){
        if (w instanceof DiscreteQuantity) {
            return new DiscreteQuantity(((DiscreteQuantity) w).q + this.q) {
            };
        }
        return null;
    }

    public Quantity subtracting(Quantity w){
        if (w instanceof DiscreteQuantity) {
            if (((DiscreteQuantity)w).q < q) {
                return new DiscreteQuantity(q - ((DiscreteQuantity)w).q);
            }
        }
        return null;
    }

    public Number getValue(){
        return q;
    }
}
