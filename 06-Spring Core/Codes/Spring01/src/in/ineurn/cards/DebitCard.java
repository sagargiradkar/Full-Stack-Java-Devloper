package in.ineurn.cards;

public class DebitCard implements ICards {

public boolean payingBill(Double bill) {
		
	System.out.println("DebitCard.payingBill() :: "+bill);
	return true;
	}
}
