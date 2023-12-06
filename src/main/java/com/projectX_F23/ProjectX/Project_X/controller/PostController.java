//package com.projectX_F23.ProjectX.Project_X.controller;
//
//import com.projectX_F23.ProjectX.Project_X.model.Post;
//import com.projectX_F23.ProjectX.Project_X.model.User;
//import com.projectX_F23.ProjectX.Project_X.repository.PostRepository;
//import com.projectX_F23.ProjectX.Project_X.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.security.Principal;
//import java.time.LocalDateTime;
//
//@Controller
//public class PostController {
//    private final PostRepository postRepository;
//    private final UserRepository userRepository;
//
//    @Autowired
//    public PostController(PostRepository postRepository, UserRepository userRepository) {
//        this.postRepository = postRepository;
//        this.userRepository = userRepository;
//    }
//
//    @GetMapping("/createPost")
//    public String showPostForm(Model model) {
//        model.addAttribute("post", new Post());
//        return "createPost";
//    }
//
//    @PostMapping("/post")
//    public String createPost(@ModelAttribute Post post, Principal principal) {
//        if (principal != null) {
//            User user = userRepository.findByUsername(principal.getName());
//            if (user != null) {
//                post.setUser(user);
//                post.setPostDate(LocalDateTime.now());
//                postRepository.save(post);
//            }
//            // Handle the case where the user is not found
//        }
//        // Handle the case where principal is null
//        return "redirect:/home";
//    }
//}
