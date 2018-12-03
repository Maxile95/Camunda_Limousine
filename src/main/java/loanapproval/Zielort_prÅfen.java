package loanapproval;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Zielort_prüfen implements JavaDelegate {

	private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

	public void execute(DelegateExecution execution) throws Exception {

		LOGGER.info("Zielort wird ueberprueft...");

		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement stmt = con.createStatement();

		String sql = "Select count(*) from ORT where ZielName='" + execution.getVariable("Zielort") + "'";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {

			if (rs.getInt(1) >= 1) {
				LOGGER.info("Zielort '" + execution.getVariable("Zielort") + "' in Datenbank vorhanden");
				execution.setVariable("ZielOK", true);
			} else if (rs.getInt(1) == 0) {
				LOGGER.info("Zielort '" + execution.getVariable("Zielort") + "' nicht in Datenbank vorhanden");
				execution.setVariable("ZielOK", false);
			}

		}

	}

}
