package controllers.reports;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Follow;
import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class FollowServlet
 */
@WebServlet("/follow")
public class FollowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            EntityManager em = DBUtil.createEntityManager();

            Follow follow= new Follow();

            follow.setFollow_id((Employee)request.getSession().getAttribute("login_employee"));

            Report r = em.find(Report.class, Integer.parseInt(request.getParameter("id")));
            follow.setFollowed_id(r.getEmployee());

            em.getTransaction().begin();
            em.persist(follow);
            em.getTransaction().commit();
            em.close();
            request.getSession().setAttribute("flush","フォローしました。");

            response.sendRedirect(request.getContextPath() + "/reports/index");
    }

}