package in.ineurn.cards;

public class AmexCard implements ICards{

public boolean payingBill(Double bill) {
		
	System.out.println("AmexCard.payingBill() :: "+bill);
	return true;
	}
}
