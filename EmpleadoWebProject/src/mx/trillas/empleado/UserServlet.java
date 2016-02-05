package mx.trillas.empleado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/empleado/alta/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doPost(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, ServletException, IOException {
		// TODO Auto-generated method stub
		
		boolean success = true;
		String message = "";
		List<String> inputerror = new ArrayList<>();

		String ssn = request.getParameter("ssn");
		String nombre = request.getParameter("nombre");
		String edad = request.getParameter("edad");
		String curp = request.getParameter("curp");
		String sueldo = request.getParameter("sueldo");
		
		
		if (request.getParameterMap().containsKey("ssn")) {
			if (!ssn.equals("")) {
				try {
					int intSsn = Integer.parseInt(ssn);
				}catch(NumberFormatException e){
					throw e;
				}
				
			} else {
				success = false;
				message += "|El ssn no debe ir vacío";
				inputerror.add("ssn");
			}
		}

		/*
		if (nombre == null || nombre.equals("")) {
			System.out.println("Valor nulo vacio");
		}
		if (curp == null || curp.equals("")) {
			System.out.println("Valor nulo vacio");
		}
		if (edad == null || edad.equals("")) {
			System.out.println("Valor nulo vacio");
		}
		if (sueldo == null || sueldo.equals("")) {
			System.out.println("Valor nulo vacio");
		}
		*/
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Estoy en User servlet...");
	}

}
