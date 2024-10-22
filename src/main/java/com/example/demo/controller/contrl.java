package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
//import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

//import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

//import java.security.Principal;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import com.example.demo.model.ChatMessage;
import com.example.demo.model.Profile;
import com.example.demo.model.User;
//import com.example.demo.model.emailModel;
import com.example.demo.model.instaModel;
//import com.example.demo.model.msgModel;
import com.example.demo.model.registerModel;
import com.example.demo.service.AuthService;
import com.example.demo.service.EmailService;
import com.example.demo.service.ProfileService;
//import com.example.demo.service.editService;
//import com.example.demo.service.MessageService;
//import com.example.demo.service.emailUserService;
import com.example.demo.service.instaService;
import org.springframework.ui.Model;


//import jakarta.persistence.criteria.Path;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class contrl {
@Autowired
instaService instaservice;

@GetMapping("/login")
public ModelAndView loginData(
	    @RequestParam("username") String user,
	    @RequestParam("password") String pass) {
	
	instaservice.usersave(user,pass);
	System.out.println("login successfully");
	
	ModelAndView modelandview = new ModelAndView();
	modelandview.setViewName("homePage");
	
	instaModel Login = new instaModel();
	Login.setUsername(user);
	Login.setPassword(pass);
	modelandview.addObject("user",Login);
	
	
	return modelandview;
}

  @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password, HttpSession session) {
        // Authenticate the user
        boolean isAuthenticated = authService.authenticate(username, password);
        
        if (isAuthenticated) {
            // Store the username in the session
            session.setAttribute("loggedInUsername", username);
            return "homePage";
        } else {
            // Handle login failure
            session.setAttribute("errorMessage", "Invalid username or password.");
            return "homePage";
        } }
	  /*@PostMapping("/login")
	  public String loginUser(@RequestParam(required = false) String username, @RequestParam(required = false) String password, HttpSession session) {
	      System.out.println("Received username: " + username);
	      System.out.println("Received password: " + password);

	      if (username == null || password == null) {
	          System.out.println("Username or password is missing.");
	          session.setAttribute("errorMessage", "Username or password is missing.");
	          return "homePage";
	      }

	      boolean isAuthenticated = authService.authenticate(username, password);
	      if (isAuthenticated) {
	          session.setAttribute("loggedInUsername", username);
	          return "homePage";
	      } else {
	          session.setAttribute("errorMessage", "Invalid username or password.");
	          return "homePage";
	      }
	  }*/
	@GetMapping("/signUp")
	public String signUpPage() {
		return"signUp";
	
	}
	
	@GetMapping("/Login")
	public String login() {
		return"index";
	
	}
	
    @Autowired
    instaService instaservice1;
    
    @GetMapping("/register")
	public ModelAndView registrationData(
			 @RequestParam("mob") String Mobile,
			 @RequestParam("fname") String Fullname,
		    @RequestParam("uname") String Username,
		    @RequestParam("pass") String pinNum) {
		
    	
    	instaservice1.regSave(Mobile,Fullname,Username,pinNum);
		System.out.println("registered successfully");
		
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("homePage");
		
		registerModel register = new registerModel();
		register.setMob(Mobile);
		register.setFname(Fullname);
		register.setUname(Username);
		register.setPass(pinNum);
		modelandview.addObject("user",register);
		modelandview.addObject("errorMessage", "Invalid username or password. Please try again.");
		return modelandview;
}
    


    @PostMapping("/register")
    public String register(@Valid @ModelAttribute registerModel r, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            // If there are validation errors, return to the form
            return "index";
        }

        instaservice1.regSave(r.getMob(), r.getFname(), r.getUname(), r.getPass());
        session.setAttribute("message", "User registered successfully.");
        return "homePage";
    }
    /*@PostMapping("/updateProfile")
    public String updateProfile(@RequestParam("username") String username,
                                @RequestParam("bio") String bio,
                                @RequestParam("profilePicture") MultipartFile file,
                                HttpSession session) throws IOException {
        
        // Handle the profile picture upload
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            Path path = Paths.get("path/to/upload/directory/" + fileName);
            Files.write(path, file.getBytes());
            // Save file path to user profile
        }

        // Update user profile details in the database
        Profile userProfile = (Profile) session.getAttribute("loggedInUserProfile");
        userProfile.setUsername(username);
        userProfile.setBio(bio);
        // userProfile.setProfilePicture(fileName); // Save the new profile picture file name
        ProfileService.save(userProfile); // Save updated profile to the database

        session.setAttribute("loggedInUserProfile", userProfile); // Update session profile
        return "redirect:/homePage"; // Redirect to home page
    }*/



   /* @PostMapping("/register")
    public String register(@Valid @ModelAttribute registerModel r, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index";
        }

        if (!instaservice1.isUsernameUnique(r.getUname())) {
            model.addAttribute("errorMessage", "Username already exists.");
            return "index";
        }

        instaservice1.regSave(r.getMob(), r.getFname(), r.getUname(), r.getPass());
        model.addAttribute("message", "User registered successfully.");
        return "homePage";
    }*/

    
    
	@GetMapping("/homepage")
	public String HomePage() {
		return"homePage";
	}
	
	@GetMapping("/reset-password")
	public String resetPasswordPage() {
		return"resetPassword";
	
	}
	   @Autowired
	    private ProfileService profileService;
	@GetMapping("/profileview")
	public ModelAndView viewProfile(HttpSession session) {
	    String username = (String) session.getAttribute("loggedInUsername");
	    if (username == null) {
	        return new ModelAndView("redirect:/login");
	    }

	    Profile profile = profileService.findByUsername(username);
	    ModelAndView modelAndView = new ModelAndView("profile");
	    modelAndView.addObject("profile", profile);
	    return modelAndView;
	}

       
    @GetMapping("/unfollow")
    public String unfollowlink() {
    	return"unfollowLink";
    }
    @GetMapping("/searchbar")
	public String searchBar() {
		return"searchbar";
	
	}
    @GetMapping("/camera")
 	public String cam() {
 		return"cam";
 	
 	}

    
 
    
    
    
    private static final String UPLOADED_FOLDER = "path/to/uploaded/folder/"; // Update this path

    @PostMapping("/uploadProfilePicture")
    public String uploadProfilePicture(@RequestParam("profilePicture") MultipartFile file) {
        if (file.isEmpty()) {
            return "redirect:/profile?error=File is empty";
        }

        try {
            // Create directory if it doesn't exist
            File directory = new File(UPLOADED_FOLDER);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Generate a unique filename
            String originalFilename = file.getOriginalFilename();
            String uniqueFilename = UUID.randomUUID().toString() + "_" + originalFilename;
            java.nio.file.Path path = Paths.get(UPLOADED_FOLDER + uniqueFilename);

            // Write file to the path
            Files.write(path, file.getBytes());

            // Update user's profile picture URL in the database or session
            // Example: userService.updateProfilePicture(userId, uniqueFilename);

        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/profile?error=File upload failed";
        }

        return "redirect:/profile";
    }
    
    @Controller
    @RequestMapping("/profile")
    public class ProfileController {

        @GetMapping("/view")
        public String viewProfile(Model model, HttpSession session) {
            // Retrieve the username from the session
            String username = (String) session.getAttribute("loggedInUsername");
            if (username == null) {
                return "redirect:/login"; // Redirect to login page if not logged in
            }

            // Fetch the profile by username
            Profile profile = profileService.findByUsername(username);
            model.addAttribute("profile", profile);

            return "view"; // Return the view page template name (view.html in templates folder)
        }
    }


        // Edit Profile Page
    @GetMapping("/edit")
    public ModelAndView editProfile(HttpSession session) {
        String username = (String) session.getAttribute("loggedInUsername");
        if (username == null) {
            return new ModelAndView("redirect:/login");
        }

        Profile profile = profileService.findByUsername(username);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("profile", profile); // Add profile to the model
        return modelAndView;
    }

        // Update Profile (After Edit)
        @PostMapping("/update")
        public ModelAndView updateProfile(@ModelAttribute Profile profile, HttpSession session) {
            String username = (String) session.getAttribute("loggedInUsername");
            if (username == null) {
                return new ModelAndView("redirect:/login");
            }

            // Find user by email or username (assuming email and username are the same)
            Profile existingProfile = profileService.findByUsername(username);

            if (existingProfile != null) {
                // Update the profile fields with new data
                existingProfile.setBio(profile.getBio());
                existingProfile.setUsername(profile.getUsername());
                existingProfile.setProfilePictureUrl(profile.getProfilePictureUrl());

                // Save the updated profile
                profileService.updateProfile(existingProfile);
            }

            return new ModelAndView("redirect:/profile"); // Redirect back to the profile view page
        }
    
    
    @Autowired
    private EmailService emailService;
    
    @PostMapping("/reset-password")
    public ModelAndView sendEmail(@RequestParam("email") String email) {
        String subject = "Welcome to our Service";
        String message = "Hi Thank you for signing up!";

        // Call service to send email
        emailService.sendEmail(email, subject, message);

        // Redirect to confirmation page
        return new ModelAndView("redirect:/email-sent");
    }

    @GetMapping("/email-sent")
    public String emailSentPage() {
        return "email-sent";  // HTML page that shows email was sent
    }
    
    @PostMapping("/test-email")
    public String sendTestEmail() {
        try {
            emailService.sendEmail("recipient@example.com", "Test Subject", "This is a test email.");
            return "Email sent successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending email: " + e.getMessage();
        }
    }
    
    
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) throws Exception {
        return new ChatMessage(HtmlUtils.htmlEscape(message.getFrom()), HtmlUtils.htmlEscape(message.getText()));
    }
    
    @GetMapping("/chat")
    public String Chat() {
    	return "chat"; 
    }
    
    
    @GetMapping("/logout")
    public String logout() {
    	return "index"; // Redirect to login page after logout
    }
}

