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
                session = request.getSession();
            }
        }
        
        String username = (String) session.getAttribute("username");
        
        if (username != null)
        {
            getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
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
        ArrayList<String> shopList = (ArrayList) session.getAttribute("shopList");
        
        if (shopList == null)
        {
            shopList = new ArrayList<>();
        }
        
        if (action.equals("register"))
        {
            String username = request.getParameter("username");
            session.setAttribute("username", username);
        }
        
        if (action.equals("add"))
        {
            String item = request.getParameter("item");
            if(!item.equals(""))
            {
                shopList.add(item);
            }
        }
        
        if (action.equals("delete"))
        {
            String listItem = request.getParameter("listItem");
            if (!listItem.equals(""))
            {
                shopList.remove(listItem);
            }
        }
        
        session.setAttribute("shopList", shopList);
        getServletContext().getRequestDispatcher("/WEB-INF/ShoppingList.jsp").forward(request, response);
    }

}
