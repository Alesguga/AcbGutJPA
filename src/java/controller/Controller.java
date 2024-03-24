package controller;

import entities.Equipo;
import entities.Jugador;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import util.JPAUtil;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String op = request.getParameter("op");
        List equipos = null;
        List jugadores = null;

        // Singleton
        EntityManager em = (EntityManager) session.getAttribute("em");
        if (em == null) {
            // Create the EntityManager
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            session.setAttribute("em", em);
        }

        switch (op) {
            case "inicio": {
                // actuar en consecuencia
                // .........
                // session.setAttribute("Key", objeto);
                // request.setAttribute("Key", objeto);
                Query q = em.createQuery("SELECT e FROM Equipo e");
                equipos = q.getResultList();
                session.setAttribute("equipos", equipos);
                request.getRequestDispatcher("home.jsp").forward(request, response);
                break;
            }
            case "vaequipo": {

                String idequipo = request.getParameter("idequipo");
                Equipo equipo = em.find(Equipo.class, Short.valueOf(idequipo));
                session.setAttribute("equipo", equipo);
                request.getRequestDispatcher("jugadores.jsp").forward(request, response);
                break;
            }
            case "like": {
                String idjugador = request.getParameter("idjugador");
                Jugador jugador = em.find(Jugador.class, Short.valueOf(idjugador));
                Short likes = jugador.getLikes();
                likes++;
                jugador.setLikes(likes);
                EntityTransaction t = em.getTransaction();
                t.begin();
                em.merge(jugador);
                t.commit();
                request.getRequestDispatcher("jugadores.jsp").forward(request, response);

                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + op);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
