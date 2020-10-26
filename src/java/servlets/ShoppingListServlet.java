/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 831719
 */
@WebServlet(name = "ShoppingListServlet", urlPatterns = {"/ShoppingList"})
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        
        String action = (String) request.getParameter("action");
        
        if (action != null)
        {
            if (action.equals("logout"))
            {
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        }
        
        String username = (String) session.getAttribute("username");
        
        if (username != null)
        {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        else
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
                
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        
        String action = (String) request.getParameter("action");
        ArrayList<String> itemList = (ArrayList) session.getAttribute("itemList");
        
        if (itemList == null)
        {
            itemList = new ArrayList<>();
        }
        
        if (action.equals("register"))
        {
            String username = request.getParameter("username");
            session.setAttribute("username", username);
        }
        
        if (action.equals("add"))
        {
            String item = request.getParameter("item");
            itemList.add(item);
                request.setAttribute("item", " ");
        }
        
        if (action.equals("delete"))
        {
            String items = request.getParameter("items");
            if (!items.equals(""))
            {
                itemList.remove(items);
            }
        }
        
        session.setAttribute("itemList", itemList);
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
