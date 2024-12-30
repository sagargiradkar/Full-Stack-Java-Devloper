package in.ineuron;

import in.ineuron.comp.WishMessageGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Boot01BasicAppApplication {
	static {
		System.out.println("Boot01BasicAppApplication.class file is loading ...");
	}
	public Boot01BasicAppApplication(){
		System.out.println("Boot01BasicAppApplication :: Zero param Constructor ");
	}
	@Bean
	public LocalDateTime createObj(){
		System.out.println("Boot01BasicAppApplication.createObje() method");
		return LocalDateTime.now();
	}
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Boot01BasicAppApplication.class, args);

		WishMessageGenerator wmg = applicationContext.getBean(WishMessageGenerator.class);
		System.out.println(wmg);

		String result = wmg.greetUser("Sagar");
		System.out.println(result);

		applicationContext.close();
	}

}
