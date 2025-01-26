package in.ineuron.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CurrencyServiceRunner implements CommandLineRunner {

	private static final String REST_END_POINT = null;

	@Override
	public void run(String... args) throws Exception {

		//sending syncronious r
		WebClient webClient =  WebClient.create();
		System.out.println("CurrencyServiceRunner.run()");
		webClient.get().uri(REST_END_POINT,args[0],args[1]).
		retrieve()
		;	}

}
