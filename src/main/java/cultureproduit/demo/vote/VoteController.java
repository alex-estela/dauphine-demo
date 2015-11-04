package cultureproduit.demo.vote;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cultureproduit.demo.support.web.MessageHelper;

@Controller
public class VoteController {
	
	private static final String VOTED_MESSAGE = "voted.message";
	
	private static final Logger logger = LoggerFactory.getLogger("demo");
	
	@Autowired
	private VoteRepository voteRepository;

	@RequestMapping(value = "vote")
	public String vote(@Valid @ModelAttribute VoteForm voteForm, Errors errors, RedirectAttributes ra) {
		Vote vote = voteRepository.save(new Vote(voteForm.getTool(), null));
		logger.info("Saved vote #" + vote.getId() + ": " + vote.getTool());
		MessageHelper.addSuccessAttribute(ra, VOTED_MESSAGE);
		return "redirect:/";
    }
}
