package loanapproval;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class Fahrer_Listener implements TaskListener {

private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

	public void notify(DelegateTask delegateTask) {
		String assignee = delegateTask.getAssignee();
		delegateTask.setVariable("ClaimedFahrer", assignee);
		LOGGER.info("Auftrag angenommen von Fahrer: '" + assignee + "'");
	}

}
