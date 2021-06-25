package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author 839217
 */
public class ShoppingListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
         String username = request.getParameter("username");
         String action = (String) request.getParameter("action");
        if (action!=null && action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
            response.sendRedirect("/lab06/ShoppingList");
            
            return;
        }
        
        else if(username == null||username.equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
            request.setAttribute("username", username);
             ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            request.setAttribute("List", items);
             getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request,response); 
    }
        
        
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
        request.setAttribute("username",request.getParameter("username"));
            session.setAttribute("username",request.getParameter("username"));
       String action = (String) request.getParameter("action");
       ArrayList<String> items = (ArrayList) session.getAttribute("items");
       
        if(items == null) {
           items = (ArrayList) new ArrayList<>();
        }
        
        else if (action.equals("register")) {
            
            session.setAttribute("List",items);
            request.setAttribute("List",items);
            request.setAttribute("username",request.getParameter("username"));
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request,response); 
            return;
            
        }
        else if(action.equals("Add")) {
            String addItem = (String) request.getParameter("itemName");
           

                items.add(addItem);
                request.setAttribute("List",items);
                session.setAttribute("List", items);
                request.setAttribute("username",request.getParameter("username"));
          getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request,response); 
          return;
        }
        
        else if(action.equals("Delete")) {
            String deleteItem = request.getParameter("item");
            
                for(int i=0; i<items.size(); i++) {
                    if(items.get(i).equals(deleteItem)) {
                        items.remove(i);
                }  
            }
                
            
          session.setAttribute("username",request.getParameter("username"));
          session.setAttribute("List", items);
          session.setAttribute("items", items);
         
          getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp") .forward(request,response); 
          return;
        }
        else if (action.equals("logout")) {
            session.invalidate();
            session = request.getSession();
            response.sendRedirect("/lab06/ShoppingList");
            
            return;
        }
        session.setAttribute("List", items);
        session.setAttribute("items", items);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }

}
