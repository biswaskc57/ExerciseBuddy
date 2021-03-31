package ExerciseBuddy.Web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import ExerciseBuddy.Domain.CategoryRepository;
import ExerciseBuddy.Domain.Exercise;
import ExerciseBuddy.Domain.ExerciseRepository;

@Controller
class exerciseBuddyController {

	@Autowired
	private ExerciseRepository eRepository;
	
	@Autowired
	private CategoryRepository cRepository;

	@RequestMapping(value = {"/", "/exerciseList"}, method = RequestMethod.GET)
	public String hello(@ModelAttribute Exercise exercise, Model model) {
		model.addAttribute("exercises", eRepository.findAll());
		return "exerciseList";
	}
	
	
	@RequestMapping (value = "/add", method = RequestMethod.GET)
	public String addExercise(Model model){
		model.addAttribute("exercise", new Exercise());
		model.addAttribute("categories", cRepository.findAll());
			return "addExercise";
		
	}

	//Saving a exercise
	//@RequestMapping(value =  "/save", method = RequestMethod.POST)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Exercise exercise){
	eRepository.save(exercise);
	return "redirect:exerciseList";
	}
	
	
	//RESTful service to get all exercises
		@RequestMapping(value = "/exercises", method = RequestMethod.GET)
	public @ResponseBody List<Exercise> exerciseListRest() {	
	    return (List<Exercise>) eRepository.findAll();
	}    

	// RESTful service to get book by id
	@RequestMapping(value="/exercise/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Exercise> findExerciseRest(@PathVariable("id") Long exerciseId) {
		return eRepository.findById(exerciseId);
	}
	}
