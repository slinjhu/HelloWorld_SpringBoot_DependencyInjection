package hello.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public interface GreetingService {
  String greet();
}

class EnglishGreetingService implements GreetingService {
  public String greet(){
    return "Hello world";
  }
}

class SpanishGreetingService implements GreetingService {
  public String greet(){
    return "Hola mundo";
  }
}

class FrenchGreetingService implements GreetingService {
  public String greet(){
    return "Bonjour le monde";
  }
}

@Configuration
class GreetingConfiguration {
  @Bean
  @ConditionalOnProperty(prefix = "settings", name = "lang", havingValue = "english")
  public GreetingService englishGreeting(){
    return new EnglishGreetingService();
  }

  @Bean
  @ConditionalOnProperty(prefix = "settings", name = "lang", havingValue = "spanish")
  public GreetingService spanishGreeting(){
    return new SpanishGreetingService();
  }

  @Bean
  @ConditionalOnProperty(prefix = "settings", name = "lang", havingValue = "french")
  public GreetingService frenchGreeting(){
    return new FrenchGreetingService();
  }
}
