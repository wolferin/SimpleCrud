import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Kenny on 01.08.2015.
 */
@WebServlet(name = "servlet", urlPatterns = "/index")
public class MyServlet extends HttpServlet {

    private static final String LIST_USER = "/listUser.jsp";
    private static final String ADD_OR_EDIT = "/userADD.jsp";
    private static final String INDEX = "/index.jsp";

    UserDAO userDAO;

    public MyServlet() {
        super();
        userDAO = new UserDAO();
    }

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String action = request.getParameter("action");
    if (action == null) {
        action = "listUser";
    }

    if (action.equalsIgnoreCase("listUser")) {
        listUser(request, response);

    } else if (action.equalsIgnoreCase("delete")) {
        delete(request, response);

    } else if (action.equalsIgnoreCase("edit")) {
        edit(request, response);

    } else if (action.equalsIgnoreCase("addUser")) {
        addUser(request, response);

        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("id"));
        userDAO.delete(userId);
        request.setAttribute("users", userDAO.allUser());
        request.getRequestDispatcher(getServletContext().getInitParameter("jspDir") + "/listUser.jsp")
                                                                            .forward(request, response);

    }

    protected void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("users", userDAO.allUser());
        request.getRequestDispatcher(getServletContext().getInitParameter("jspDir") + "/listUser.jsp")
                                                                            .forward(request, response);


    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.getUserById(userId);
        request.setAttribute("users", user);
        request.getRequestDispatcher(getServletContext().getInitParameter("jspDir") + "/userADD.jsp")
                                                                            .forward(request, response);


    }

    protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher(getServletContext().getInitParameter("jspDir") + "/userADD.jsp")
                                                                            .forward(request, response);

    }

@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();

        user.setName(request.getParameter("name"));
        user.setSurname(request.getParameter("surname"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(Integer.parseInt(request.getParameter("phone")));

        String userId = request.getParameter("id");

        if(userId == null || userId.isEmpty()) {
            userDAO.add(user);

        } else {
            user.setId(Integer.parseInt(userId));
            userDAO.update(user);

        }request.setAttribute("users", userDAO.allUser());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(getServletContext().getInitParameter("jspDir")
                                                                                                    + "/listUser.jsp");
        request.setAttribute("users", userDAO.allUser());
        requestDispatcher.forward(request, response);


    }
}


  /* if (action.equalsIgnoreCase("delete")){

        } else if (action.equalsIgnoreCase("edit")){
            forward = ADD_OR_EDIT;
            int userId = Integer.parseInt(request.getParameter("id"));
            User user = userDAO.getUserById(userId);
            request.setAttribute("users", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;

        } else {
            forward = ADD_OR_EDIT;
        }*/
