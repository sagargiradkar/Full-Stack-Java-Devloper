package in.ineurn.cards;

public class PaymentProcess {

	private ICards payment = null;
	
	public PaymentProcess(ICards payment) {
		this.payment = payment;
	}
	

	public void setPayment(ICards payment) {
		this.payment = payment;
	}

	public boolean doThePayment(String cardType,Double billAmount )
	{
		/*
		 * if("CreditCard".equals(cardType)) { CareditCard cc = new CareditCard ();
		 * return cc.payingBill(billAmount); }else if("DebitCard".equals(cardType)) {
		 * DebitCard cc = new DebitCard(); return cc.payingBill(billAmount);
		 * 
		 * }else if("AmexCard".equals(cardType)) { AmexCard cc = new AmexCard(); return
		 * cc.payingBill(billAmount); }else { return false;
		 * 
		 * }
		 */
		
		return payment.payingBill(billAmount);
	}
}
