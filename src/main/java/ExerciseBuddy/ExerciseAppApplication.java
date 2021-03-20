package ExerciseBuddy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ExerciseBuddy.Domain.Category;
import ExerciseBuddy.Domain.CategoryRepository;
import ExerciseBuddy.Domain.Exercise;
import ExerciseBuddy.Domain.ExerciseRepository;





@SpringBootApplication
public class ExerciseAppApplication {

	private static final Logger log = LoggerFactory.getLogger(ExerciseAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ExerciseAppApplication.class, args);
		
	}
		@Bean
		public CommandLineRunner demo(ExerciseRepository eRepository, CategoryRepository cRepository) {
			return (args) ->{
				
				cRepository.save(new Category("Abs"));
				cRepository.save(new Category("Chest"));
				cRepository.save(new Category("Shoulder"));
				cRepository.save(new Category("Legs"));
				cRepository.save(new Category("Back"));
				
				
				
				
			
		Exercise exercise1 = new Exercise("Crunch abs", "Upperbody","12 sets", cRepository.findByName("Abs").get(0));
		
		Exercise exercise2 = new Exercise("Legs Press", "Lowerbody","12 sets", cRepository.findByName("Legs").get(0) );
			
		eRepository.save(exercise1);
		eRepository.save(exercise2);
		
		log.info("fetch all books");
		
		for (Exercise exercise : eRepository.findAll()) {
			log.info(exercise.toString());
		}
		};
}
		
		
}

