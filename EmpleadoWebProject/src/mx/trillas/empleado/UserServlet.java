package mx.trillas.empleado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		String edad = "";
		
		if (request.getParameterMap().containsKey("ssn")) {
			String ssn = request.getParameter("ssn");
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
		
		if (request.getParameterMap().containsKey("nombre")) {
			String nombre = request.getParameter("nombre");
			if (nombre.equals("")) {
				success = false;
				message += "|El nombre no debe ir vacío";
				inputerror.add("nombre");
			}
		}
		
		if (request.getParameterMap().containsKey("curp")) {
			String curp = request.getParameter("curp");
			if (curp.equals("")) {
				success = false;
				message += "|El nombre no debe ir vacío";
				inputerror.add("nombre");
			}
		}
		
		if (request.getParameterMap().containsKey("edad")) {
			edad = request.getParameter("edad");
			if (!edad.equals("")) {
				try {
					int intEdad = Integer.parseInt(edad);
				}catch(NumberFormatException e){
					throw e;
				}
				
			} else {
				success = false;
				message += "|Campo edad no debe ir vacío";
				inputerror.add("edad");
			}
		}

		if (request.getParameterMap().containsKey("sueldo")) {
			String sueldo = request.getParameter("sueldo");
			if (!sueldo.equals("")) {
				try {
					int intSueldo = Integer.parseInt(sueldo);
				}catch(NumberFormatException e){
					throw e;
				}
				
			} else {
				success = false;
				message += "|Campo sueldo no debe ir vacío";
				inputerror.add("sueldo");
			}
		}

		Gson gson =  new Gson();
		Gson gson2 =  new GsonBuilder().create();
		
		/*
		String json = gson.toJson(edad); 
		 
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
			
		/*
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Estoy en User servlet...");
		*/
	}
}
