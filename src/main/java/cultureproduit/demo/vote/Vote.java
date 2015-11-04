package cultureproduit.demo.vote;

import javax.persistence.*;

import cultureproduit.demo.account.Account;

@SuppressWarnings("serial")
@Entity
@Table(name = "vote")
public class Vote implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String tool;
	
	@ManyToOne
	private Account account;

    protected Vote() {

	}
	
	public Vote(String tool, Account account) {
		this.tool = tool;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}
}
