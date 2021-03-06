package it.blackhat.symposium.actions.admin;

import it.blackhat.symposium.actions.Action;
import it.blackhat.symposium.actions.ActionFactory;
import it.blackhat.symposium.helpers.InvalidActionException;

/**
 *
 * @author Symposium Group
 */
public class AdminActionFactory implements ActionFactory {

    @Override
    public Action createAction(String actionType) throws InvalidActionException {
        switch (actionType) {
            case "adminSignout":
                return new SignoutAdmin();
            case "showUsersAction":
                return new ShowUsersAction();
            case "generateReportListAction":
                return new GenerateReportListAction();
            default:
                throw new InvalidActionException("Azione non supportata");
        }
    }

}
