package ExerciseBuddy;

import java.text.SimpleDateFormat;

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
import ExerciseBuddy.Domain.Trainer;
import ExerciseBuddy.Domain.TrainerRepository;






@SpringBootApplication
public class ExerciseAppApplication {

	private static final Logger log = LoggerFactory.getLogger(ExerciseAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ExerciseAppApplication.class, args);
		
	}
		@Bean
		public CommandLineRunner demo(ExerciseRepository eRepository, CategoryRepository cRepository, TrainerRepository trRepository) {
			return (args) ->{
				
				
				
				
				cRepository.save(new Category("Abs"));
				cRepository.save(new Category("Chest"));
				cRepository.save(new Category("Shoulder"));
				cRepository.save(new Category("Legs"));
				cRepository.save(new Category("Back"));
				
				
				
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");		
			
		Exercise exercise1 = new Exercise("Crunch abs", "Upperbody","12 sets", cRepository.findByName("Abs").get(0), format.parse("2021-04-16"));
		
		Exercise exercise2 = new Exercise("Legs Press", "Lowerbody","12 sets", cRepository.findByName("Legs").get(0), format.parse("2021-05-16") );
			
		eRepository.save(exercise1);
		eRepository.save(exercise2);
		
		
		Trainer trainer1 = new Trainer("Biswas KC", "Biswas43gmail.com", 451898090, "122222-323", "Body-building",
				"Trainer for 2 years");
		Trainer trainer2 = new Trainer("Danny shepherd", "Danny3gmail.com", 451898092, "652222-3623", "Jumba",
				"Trainer for 2 years");
		Trainer trainer3 = new Trainer("lung chong", "lung3gmail.com", 225189809, "4222-3239", "Karate",
				"Trainer for 2 years");
		
		trRepository.save(trainer1);
		trRepository.save(trainer2);
		trRepository.save(trainer3);
		
		log.info("fetch all exercises");
		
		for (Exercise exercise : eRepository.findAll()) {
			log.info(exercise.toString());
		}
		};
}
		
		
}

