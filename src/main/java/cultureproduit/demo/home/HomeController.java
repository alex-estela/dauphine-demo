package cultureproduit.demo.home;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import cultureproduit.demo.vote.VoteRepository;

@Controller
public class HomeController {
	
	@Autowired
	private VoteRepository voteRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal, Model model) {
		model.addAttribute("numberOfVotes", voteRepository.findAll().size());
		return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
	}
}
