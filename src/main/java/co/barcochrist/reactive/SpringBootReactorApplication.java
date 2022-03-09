package co.barcochrist.reactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootReactorApplication implements CommandLineRunner {

  private static final Logger log = LoggerFactory.getLogger(SpringBootReactorApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(SpringBootReactorApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Flux<String> names = Flux
        .just("Christian", "Andres", "Camila", "Sara")
        .doOnNext(System.out::println);

    names.subscribe(log::info);
  }
}