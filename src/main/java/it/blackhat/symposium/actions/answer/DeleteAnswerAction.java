package it.blackhat.symposium.actions.answer;


import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.managers.AnswerManager;
import it.blackhat.symposium.managers.AnswerModelManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Describes the delete answer action by the user
 *
 * @author Gozzetto
 * @author 2Deimos
 */
public class DeleteAnswerAction implements Action {
    private AnswerManager answerManager;
    private final Log deleteAnswerLog = LogFactory.getLog(DeleteAnswerAction.class);


    /**
     * Initializes an Answer Manager
     */
    public DeleteAnswerAction() {
        super();
    }


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse res) {
        try {
            this.answerManager = new AnswerModelManager();
            String idAnswer = req.getParameter("id");
            int idAnswerInt = Integer.parseInt(idAnswer);
            answerManager.removeAnswer(idAnswerInt);
            return "/index.jsp";
        } catch (SQLException e) {
            deleteAnswerLog.error("Errore interno", e);
            return "/error500.jsp";
        }
    }
}
