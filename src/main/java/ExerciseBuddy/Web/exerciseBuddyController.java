package ExerciseBuddy.Web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import ExerciseBuddy.Domain.Exercise;
import ExerciseBuddy.Domain.ExerciseRepository;

@Controller
class exerciseBuddyController {
	
	
	@Autowired
	private ExerciseRepository eRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(@ModelAttribute Exercise exercise,Model model)
	{
		model.addAttribute("exercises",eRepository.findAll());
	return "exerciseList";
	}
}
