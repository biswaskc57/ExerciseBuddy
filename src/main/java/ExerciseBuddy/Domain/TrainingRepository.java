package ExerciseBuddy.Domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
public interface TrainingRepository 	 extends CrudRepository<Training, Long> {

		List<Training>findById(int id);
	}

