package in.ineurn.cards;

public class CareditCard implements ICards {

	public boolean payingBill(Double bill) {
		
		System.out.println("CareditCard.payingBill() :: "+bill);
		return true;
	}
}
