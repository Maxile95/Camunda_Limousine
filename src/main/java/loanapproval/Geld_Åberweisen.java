package loanapproval;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Geld_überweisen implements JavaDelegate {

	
	
private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

public void execute(DelegateExecution execution) throws Exception {

		LOGGER.info("Der Geldbetrag von'"
		+ execution.getVariable("Amount") +
		"' Euro wurde von '" + execution.getVariable("Customer") + "' ueberwiesen an den Fahrer '" +
		execution.getVariable("ClaimedFahrer") + "'");
	}
	
}


