package in.ineuron.model;

import lombok.Data;

@Data
public class CurruncyResponse {

	private Integer currencyId;
	private String currencyFrom;
	private String currencyTo;
	private Integer currencyValue;
	
}
