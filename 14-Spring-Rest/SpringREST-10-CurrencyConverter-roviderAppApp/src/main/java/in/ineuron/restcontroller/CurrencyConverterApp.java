package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.CurruncyResponse;

@RestController
@RequestMapping("/api/currency")
public class CurrencyConverterApp {

	@GetMapping(value = "/getCurrencyExchangeCost/from/{from}/to/{to}")
	public ResponseEntity<CurruncyResponse> getCurrencyValue(@PathVariable String from,@PathVariable String to) {
	 	CurruncyResponse response = new CurruncyResponse();
	 	response.setCurrencyId(1);
	 	response.setCurrencyFrom(from);
	 	response.setCurrencyTo(to);
	 	response.setCurrencyValue(82);
	 	return new ResponseEntity<CurruncyResponse>(response,HttpStatus.OK);
	 	
	}
}
