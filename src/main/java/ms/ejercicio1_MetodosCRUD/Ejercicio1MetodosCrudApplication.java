package ms.ejercicio1_MetodosCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients //1. la anotacion
public class Ejercicio1MetodosCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ejercicio1MetodosCrudApplication.class, args);
	}

}
