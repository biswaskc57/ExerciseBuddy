package ExerciseBuddy.Web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import org.springframework.util.StringUtils;

import ExerciseBuddy.Domain.Trainer;
import ExerciseBuddy.Repo.TrainerRepository;
import ExerciseBuddy.Services.FileUploadUtil;


@Controller
public class ImageController {

	 @Autowired
	    private TrainerRepository repo;
	     
	    @PostMapping("/save/image")
	    public RedirectView saveUser(Trainer trainer,
	            @RequestParam("image") MultipartFile multipartFile) throws IOException {
	         
	        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	        trainer.setPhotos(fileName);
	         
	        Trainer savedTrainer = repo.save(trainer);
	 
	        String uploadDir = "trainer-photos/" + savedTrainer.getId();
	 
	        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	         
	        return new RedirectView("/trainerlist", true);
	    }
	}
	

