package com.example.SubForm1;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.pdfcrowd.*;


/*@Controller
public class MyController {

    @GetMapping("/addUser")
    public String sendForm(User user) {

        return "addUser";
    }

    @PostMapping("/addUser")
    public String processForm(User user) {

        return "showMessage";
    }
}/*

 */
@Controller
public class MyController implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/showMessage").setViewName("showMessage");
	}

    @GetMapping("/addUser")
    public String sendForm(User user) {

        return "addUser";
    }

    @PostMapping("/addUser")
    public String processForm(@Valid User user , BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()) {
            return "addUser";
        }

        System.out.println("we are here");
        return "showMessage";
    }

    public void generate(){

    }


    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IllegalStateException,IOException{
        System.out.println("1");
	    String basedir = "/home/elizaveta/IdeaProjects/SubForm1/src/main/resources/templates/";
        System.out.println("dir found");
	   file.transferTo(new File(basedir+"myfile.jpg"));
        System.out.println("last step");
	    return "redirect:/addUser";}


    /*@RequestMapping(value = "/generate/pdf", method = RequestMethod.GET)
    ModelAndView generatePdf(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        System.out.println("Calling generatePdf()...");

        Employee employee = new Employee();
        employee.setFirstName("Yashwant");
        employee.setLastName("Chavan");


        ModelAndView modelAndView = new ModelAndView("pdfView","command",employee);

        return modelAndView;
    }*/

    }