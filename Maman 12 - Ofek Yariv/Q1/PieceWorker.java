package maman12a;
public class PieceWorker extends Employee {
    private int numOfItems;
    private final int itemPrice = 10;

    public PieceWorker(String firstname, String lastName, String socialSecurityNumber, BirthDate date, int items) {
        super(firstname, lastName, socialSecurityNumber, date);

        if (items < 0){
            throw new IllegalArgumentException("items must be >= 0");
        }
        this.numOfItems = items;
    }

    public int getNumOfItems()
    {
        return this.numOfItems;
    }

    @Override
    public double earnings() {
        return getNumOfItems() * itemPrice + getBirthdayBonus();
    }

    public String toString() {
        return String.format("%s is a Piece worker, he created %s items, each item priced: $%s",super.toString(), getNumOfItems(),itemPrice);
    }
}
