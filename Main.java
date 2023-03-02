package Seminar_7;

import Seminar_7.logger.Decorator;
// import Seminar_7.logger.LoggerAble;
import Seminar_7.logger.LoggerTerminal;
import Seminar_7.controllers.UserController;
import Seminar_7.model.FileOperation;
import Seminar_7.model.FileOperationImpl;
import Seminar_7.model.Repository;
import Seminar_7.model.RepositoryFile;
import Seminar_7.utils.Validate;
import Seminar_7.views.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("users.txt");
        // Repository repository = new RepositoryFile(fileOperation);
        Repository repository = new Decorator(new RepositoryFile(fileOperation), new LoggerTerminal());
        Validate validate = new Validate();
        UserController controller = new UserController(repository, validate);
        ViewUser view = new ViewUser(controller, validate);

        view.run();
    }
}