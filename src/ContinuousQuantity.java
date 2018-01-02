public class ContinuousQuantity extends Quantity{
    private double q;
    private String measurementUnit;

    ContinuousQuantity(double q, String measurementUnit) {
        if (quantityPositiveNumber(q)){
            this.q = q;
            this.measurementUnit = measurementUnit;
        }
    }

    private boolean quantityPositiveNumber(double q){
        if(q>0){
            return true;
        }
        else throw new IndexOutOfBoundsException("Quantity should not be negative or 0.");
    }

    public Quantity adding(Quantity w){
        if (w instanceof ContinuousQuantity) {
            return new ContinuousQuantity(((ContinuousQuantity) w).q + this.q, measurementUnit);
        }
        return null;
    }

    public Quantity subtracting(Quantity w){
        if (w instanceof ContinuousQuantity) {
            if (((ContinuousQuantity)w).q < q) {
                return new ContinuousQuantity(q - ((ContinuousQuantity)w).q, measurementUnit);
            }
        }
        return null;
    }

    public Number getValue(){
        return q;
    }
}
