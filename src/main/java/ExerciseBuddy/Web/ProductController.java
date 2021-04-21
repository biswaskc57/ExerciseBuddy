package ExerciseBuddy.Web;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;




import ExerciseBuddy.Domain.Product;

import ExerciseBuddy.Repo.ProductRepo;
import ExerciseBuddy.Services.FileUploadUtil;




@Controller
public class ProductController {
	
	 @Autowired
	    private ProductRepo repo;
	     
	    @PostMapping("/save/image")
	    public RedirectView saveUser(Product product,
	            @RequestParam("picture") MultipartFile multipartFile) throws IOException {
	         
	        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
	        product.setPhotos(fileName);
	         
	        Product savedTrainer = repo.save(product);
	        System.out.println(savedTrainer.getName());
	        System.out.println(product.getName());
	        
	        
	        //saves folder in the given directory
	        String uploadDir = "src/main/resources/static/" + savedTrainer.getId();
	        
	       
	        System.out.println(uploadDir);
	 
	        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
	        System.out.println("hehehehehe");
	        return new RedirectView("/trainerlist", true);
	       
	    }
	
}
	
