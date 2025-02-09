package UserPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class UserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String mensage = "";
        try {
            String userName = request.getParameter("userName");
            int userAge = Integer.parseInt(request.getParameter("userAge"));

            mensage = (userAge >= 18)
                    ? "Hola " + userName + ", tu edad es de " + userAge + " años, eres mayor de edad."
                    : "Hola " + userName + ", tu edad es de " + userAge + " años,  eres menor de edad.";

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error con los datos ingresados");
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println("<!DOCTYPE html>");
            out.println("<html>");

            out.println("<head>");

            out.println("<title>Respuesta al usuario</title>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");

            out.println("<style>");
            out.println("body {");
            out.println("    font-family: 'Arial', sans-serif;");
            out.println("    background-color: #f4f4f9;");
            out.println("    margin: 0;");
            out.println("    padding: 0;");
            out.println("    display: flex;");
            out.println("    justify-content: center;");
            out.println("    align-items: center;");
            out.println("    height: 100vh;");
            out.println("    color: #333;");
            out.println("}");
            out.println("section {");
            out.println("    background-color: #fff;");
            out.println("    padding: 20px;");
            out.println("    border-radius: 8px;");
            out.println("    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");
            out.println("    width: 100%;");
            out.println("    max-width: 400px;");
            out.println("}");
            out.println("p {");
            out.println("    font-size: 1.2rem;");
            out.println("    color: #007BFF;");
            out.println("    text-align: center;");
            out.println("}");
            out.println("</style>");

            out.println("</head>");

            out.println("<body>");
            out.println("<section>");
            out.println("<h1>Resultado del Formulario</h1>");
            out.println("<p>" + mensage + "</p>");
            out.println("</section>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
