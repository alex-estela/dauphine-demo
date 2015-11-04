package cultureproduit.demo.vote;

import org.hibernate.validator.constraints.NotBlank;

public class VoteForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";

    @NotBlank(message = VoteForm.NOT_BLANK_MESSAGE)
	private String tool;

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}   
}
