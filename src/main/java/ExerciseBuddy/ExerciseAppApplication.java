package ExerciseBuddy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import ExerciseBuddy.Domain.Exercise;
import ExerciseBuddy.Domain.ExerciseRepository;





@SpringBootApplication
public class ExerciseAppApplication {

	private static final Logger log = LoggerFactory.getLogger(ExerciseAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ExerciseAppApplication.class, args);
		
	}
		@Bean
		public CommandLineRunner demo(ExerciseRepository eRepository) {
			return (args) ->{
			
		Exercise exercise1 = new Exercise("Crunch abs", "Upperbody","12 sets");
		
		Exercise exercise2 = new Exercise("Legs Press", "Lowerbody","12 sets");
			
		eRepository.save(exercise1);
		eRepository.save(exercise2);
		
		log.info("fetch all books");
		
		for (Exercise exercise : eRepository.findAll()) {
			log.info(exercise.toString());
		}
		};
}
		
		
}

