/* (C)2023 */
package br.com.edu.recipe.app.api.v1;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ImageController {
    /*

    private final ImageService imageService;

    private  final RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
    	this.imageService = imageService;
    	this.recipeService = recipeService;
    }*/

    /*
    @GetMapping("recipe/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model){
    	model.addAttribute("/*recipe", recipeService.findCommandById(Long.valueOf(id)));

    	return "recipe/imageuploadform";
    }


    @PostMapping("recipe/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){

    	imageService.saveImageFile(Long.valueOf(id), file);

    	return "redirect:/recipe/" + id + "/show";
    }*/

    @GetMapping("recipe/{id}/recipeimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        /*RecipeCommand recipeCommand = recipeService.findCommandById(Long.valueOf(id));

        if (recipeCommand.getImage() != null) {
        	byte[] byteArray = new byte[recipeCommand.getImage().length];
        	int i = 0;

        	for (Byte wrappedByte : recipeCommand.getImage()){
        		byteArray[i++] = wrappedByte; //auto unboxing
        	}

        	response.setContentType("image/jpeg");
        	InputStream is = new ByteArrayInputStream(byteArray);
        	IOUtils.copy(is, response.getOutputStream());
        }*/
    }
}
