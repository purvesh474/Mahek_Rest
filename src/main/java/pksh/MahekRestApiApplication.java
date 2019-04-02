package pksh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "Controller","Service","Exception"} )
public class MahekRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MahekRestApiApplication.class, args);
	}

}
