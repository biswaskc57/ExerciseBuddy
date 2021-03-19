package ExerciseBuddy.Web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import ExerciseBuddy.Domain.Exercise;

@Controller
class exerciseBuddyController {
	
	
	@RequestMapping(value = "/exercise", method = RequestMethod.GET)
	public String hello(@ModelAttribute Exercise exercise,Model model)
	{
		model.addAttribute("messages", exercise);
	return "exerciseList";
	}
}
