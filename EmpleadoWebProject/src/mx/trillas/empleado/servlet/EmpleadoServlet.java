package mx.trillas.empleado.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import javax.json.Json;
//import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

//import org.json.JSONArray;

//import com.google.gson.JsonObject;

//import org.json.JSONArray;
//import org.json.JSONException;

//import com.google.gson.JsonObject;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/empleado/alta/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws   NumberFormatException, ServletException, IOException {
		
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
				inputerror.add("curp");
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
		
		
		
		JSONArray jsonArray = new JSONArray();
//		JsonObject obj =null;
		String value1 = "";
		/*
		for (int i = 0; i< jsonArray.length(); i++ ){
				try {
					value1 = jsonArray.getString(i);
					System.out.println("value" + i + " : " + value1);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		*/
		JSONObject obj = new JSONObject();
//		JsonObject obj = Json.createObjectBuilder().add("success", success)
				obj.put("success", success);
				obj.put("message", message);
				obj.put("datos", "");
				obj.put("inputerror", inputerror);
		 
		System.out.println("json: " + obj);

//		response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(obj.toString());
	}
}