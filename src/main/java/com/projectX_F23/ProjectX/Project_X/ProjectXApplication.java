package com.projectX_F23.ProjectX.Project_X;

import com.projectX_F23.ProjectX.Project_X.model.User;
import com.projectX_F23.ProjectX.Project_X.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class ProjectXApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjectXApplication.class, args);
	}

	@Repository
	public class UserRepository {
		private final JdbcTemplate jdbcTemplate;

		public UserRepository(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate = jdbcTemplate;
		}

		public void save(User user) {
			String sql = "INSERT INTO users (email, username, password, verified, role, profileInfo) VALUES (?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, user.getEmail(), user.getUsername(), user.getPassword(), user.getVerified(), user.getRole(), user.getProfileInfo());
		}

		// Other CRUD methods
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			// Create a new user instance
			User newUser = new User(
					null, // id will be generated automatically
					"leo.messi@goat.com",
					"LM10",
					"password8",
					true,
					"ADMIN",
					"Profile information here"
			);

			// Save the new user to the database
			userRepository.save(newUser);
		};
	}


	@GetMapping("/")
	public String apiRoot(Model model) {
		return "redirect:/login";
	}

}