package skittishsloth.ai.orchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "skittishsloth.ai")
public class OrchestratorApplication {

	public static void main(String[] args) {
		log.info("Main Starting");
		SpringApplication.run(OrchestratorApplication.class, args);
	}

}