package CustomerMS;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import org.apache.log4j.LogManager;

@SpringBootApplication
public class MicroserviceApplication {

	static Logger logger= LogManager.getLogger(MicroserviceApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(MicroserviceApplication.class, args);

	}

	@Bean
	public RestTemplate restTemplate() {
		{
			return new RestTemplate();
		}


	}
}
