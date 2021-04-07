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

import ExerciseBuddy.Domain.Trainer;
import ExerciseBuddy.Domain.TrainerRepository;
import ExerciseBuddy.Domain.Training;
import ExerciseBuddy.Domain.TrainingRepository;

@Controller
class exerciseBuddyController {

	
	
	
	@Autowired
	private CategoryRepository cRepository;
	
	@Autowired
	private TrainerRepository trRepository;
	
	@Autowired
	private TrainingRepository trainingRepository;

	
	
	@RequestMapping(value = {"/", "/trainerlist"}, method = RequestMethod.GET)
	public String trainerList(@ModelAttribute Trainer trainer, Model model) {
		model.addAttribute("trainers", trRepository.findAll());
		return "trainerlist";
	}
	
	

	@RequestMapping (value = "/booktrainer", method = RequestMethod.GET)
	public String bbookTutor(Model model){
		model.addAttribute("trainings", new Training());
		model.addAttribute("categories", cRepository.findAll());
		model.addAttribute("trainers", trRepository.findAll());
			return "bookTrainer";
		
	}
	
	//Saving a exercise
	//@RequestMapping(value =  "/save", method = RequestMethod.POST)
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Training training){
	trainingRepository.save(training);
	return "redirect:trainerlist";
	
	}
	
	
	//RESTful service to get all exercises
			@RequestMapping(value = "/schedule/{id}")
		public String schedule( @PathVariable("id") Long trainerId, Model model) {	
				model.addAttribute("trainers", trRepository.findById(trainerId).get());
		    return "schedule";
		}    

	
	
	
	}
