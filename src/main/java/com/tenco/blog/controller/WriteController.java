package com.tenco.blog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tenco.blog.dto.WriteDTO;
import com.tenco.blog.service.WriteService;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/blog")
public class WriteController {
	
	private final WriteService writeService;
	
	public WriteController(WriteService writeService) {
		this.writeService = writeService;
	}
	
    @GetMapping("/main")
    public String getMainPage(Model model) {
        List<WriteDTO> posts = writeService.getAllPosts();

        model.addAttribute("posts", posts);

        return "user/main";
    }

	
	@GetMapping("/write")
	public String getWritePage() {
		return "user/writePage";
	}

	@PostMapping("/write")
	public String writeProc(WriteDTO dto) {
		System.out.println("PostMapping");
		writeService.writePost(dto);
		return "redirect:/blog/main";
	}
	
	@GetMapping("/update/{id}")
	public String getUpdatePage(@PathVariable(name = "id") int id, Model model) {
		System.out.println("getMapping update");
		WriteDTO dto = writeService.getPostById(id);
		model.addAttribute("post", dto);
		
		return "user/updatePage";
	}
    
   @PostMapping("/update")
   public String updateProc(WriteDTO dto) {
	   System.out.println("post update");
	   writeService.updatePost(dto);
       return "redirect:/blog/main";
   }
   
   @GetMapping("/delete/{id}")
   public String deleteProc(@PathVariable(name = "id")int id){
       System.out.println("Delete Mapping");
	   writeService.deletePost(id);
	   return "redirect:/blog/main";
   }
   
   
   
	
}
