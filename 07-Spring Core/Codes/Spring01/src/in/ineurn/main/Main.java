package in.ineurn.main;

import in.ineurn.cards.AmexCard;
import in.ineurn.cards.CareditCard;
import in.ineurn.cards.DebitCard;
import in.ineurn.cards.PaymentProcess;

public class Main {

	public static void main(String[] args) {

		PaymentProcess pp = new PaymentProcess(new CareditCard());
		boolean status = pp.doThePayment("CreditCard", 100.0);
		
		if(status) {
			System.out.println("Payment Succes using Credit Card");
		}else {
			System.out.println("Payment Failled");
		}
		System.out.println();
		PaymentProcess pp1 = new PaymentProcess(new DebitCard());
		boolean status1 = pp1.doThePayment("DebitCard", 1000.0);
		if(status1) {
			System.out.println("Payment Succes uing Debit Card");
		}else {
			System.out.println("Payment Failled");
		}
		System.out.println();
		PaymentProcess pp2 = new PaymentProcess(new AmexCard());
		boolean status2 = pp2.doThePayment("AmexCard", 10000.0);
		if(status2) {
			System.out.println("Payment Succes using Amex Card");
		}else {
			System.out.println("Payment Failled");
		}
		System.out.println();
		boolean status3 = pp2.doThePayment("AmexCard", 10000.0);
		if(status3) {
			System.out.println("Payment Succes using Amex Card");
		}else {
			System.out.println("Payment Failled");
		}
	}

}
