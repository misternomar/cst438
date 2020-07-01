package cst438;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieRatings {
	
	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping("/movies/new")
	public String movieRatingsForm(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "rating_form";
	}
	
	@PostMapping("/movies/new")
	public String processMovieForm(@Valid Movie movie,
			BindingResult result, 
			Model model) {
		if(result.hasErrors()) {
			System.out.println("****" + result.getAllErrors());
			return "rating_form";
		}
		else {
			movie.setTime(new java.util.Date().toString());
			movieRepository.save(movie);
			System.out.println("****" + movie.getTitle());
		}		
		return "redirect:/movies/new";
	}
	
	@GetMapping("/movies")
	public String showMovies(Model model) {
		Iterable<Movie> ratings = movieRepository.findAllMovieRatingsOrderByTitleDateDesc();
		model.addAttribute("ratings", ratings);
		//System.out.println()
		return "show_movies";
	}
}
