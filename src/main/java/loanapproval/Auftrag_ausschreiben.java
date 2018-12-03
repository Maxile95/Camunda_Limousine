package loanapproval;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Auftrag_ausschreiben implements JavaDelegate {

	private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

	public void execute(DelegateExecution execution) throws Exception {

		LOGGER.info("Auftrag einer Fahrergruppe zuteilen...");

		if (execution.getVariable("LimousineType").equals("Limousine A")) {
			LOGGER.info("Auftrag Fahrergruppe A zugeteilt!");
			execution.setVariable("FahrerGruppe", "FahrerA");
		} else if (execution.getVariable("LimousineType").equals("Limousine B")) {
			LOGGER.info("Auftrag Fahrergruppe B zugeteilt!");
			execution.setVariable("FahrerGruppe", "FahrerB");
		}

	}

}