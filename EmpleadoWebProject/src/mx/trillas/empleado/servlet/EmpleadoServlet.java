package mx.trillas.empleado.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
		
		if (request.getParameterMap().containsKey("ssn")) {
			String ssn = request.getParameter("ssn");
			if (!ssn.equals("")) {
				if (vericarDatosNumerico(ssn)){
					try {
						int intSsn = Integer.parseInt(ssn);
					}catch(NumberFormatException e){
						throw e;
					}
				} else {
					success = false;
					message += "El campo ssn solo acepta numeros";
					inputerror.add("ssn");
				}
			} else {
				success = false;
				message += "El campo ssn no debe ir vacío";
				inputerror.add("ssn");
			}
		}
		
		if (request.getParameterMap().containsKey("nombre")) {
			String nombre = request.getParameter("nombre");
			if (!nombre.equals("")) {
				if (!vericarDatosLetras(nombre)){
					success = false;
					message += "| El campo nombre solo acepta texto";
					inputerror.add("nombre");
				}
			} else {
				success = false;
				message += "| El campo nombre no debe ir vacío";
				inputerror.add("nombre");
			}
		}
		
		if (request.getParameterMap().containsKey("curp")) {
			String curp = request.getParameter("curp");
			if (!curp.equals("")) {
				if (!vericarCurp(curp)){
					success = false;
					message += "| El campo Curp no es valido";
					inputerror.add("curp");
				}
			} else {
				success = false;
				message += "| El campo Curp no debe ir vacío";
				inputerror.add("curp");
			}
		}
		
		if (request.getParameterMap().containsKey("edad")) {
			String edad = request.getParameter("edad");
			if (!edad.equals("")) {
				if (!vericarDatosNumerico(edad)){
					success = false;
					message += "| El campo Edad solo acepta numeros";
					inputerror.add("edad");
				} else { 
					try {
						int intEdad = Integer.parseInt(edad);
					}catch(NumberFormatException e){
						throw e;
					}
				}
			} else {
				success = false;
				message += "| El campo  edad no debe ir vacío";
				inputerror.add("edad");
			}
		}

		if (request.getParameterMap().containsKey("sueldo")) {
			String sueldo = request.getParameter("sueldo");
			if (!sueldo.equals("")) {
				if (!vericarDatosNumerico(sueldo)){
					success = false;
					message += "| El campo Sueldo solo acepta numeros";
					inputerror.add("sueldo");
				} else {
					try {
						int intSueldo = Integer.parseInt(sueldo);
					}catch(NumberFormatException e){
						throw e;
					}
				}
			} else {
				success = false;
				message += "| El campo  sueldo no debe ir vacío";
				inputerror.add("sueldo");
			}
		}
		
		JSONArray jsonArray = new JSONArray();
		String value1 = "";

		JSONObject obj = new JSONObject();
				obj.put("success", success);
				obj.put("message", message);
				obj.put("datos", "");
				obj.put("inputerror", inputerror);
				
//		System.out.println("json: " + obj);
//		response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(obj.toString());
	}
	
	public static boolean vericarDatosLetras(String alph){
		String regex = "([A-Za-z])+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(alph);
		return matcher.matches();
	}
	
	public static boolean vericarCurp(String curp){
		String regex = "^[A-Z]{1}[AEIOU]{1}[A-Z]{2}";
		regex += "[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
		regex += "[HM]{1}";
		regex += "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OCPLQT|QR|SP|SL|SR|TC|TS)";
		regex += "[B-DF-HJ-NP-TV-Z]{3}";
		regex += "[0-9A-Z]{1}";
		regex += "[0-9]{1}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(curp);
		return matcher.matches();
	}
	
	public static boolean vericarDatosNumerico(String numeric){
		String regex = "([0-9])+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(numeric);
		return matcher.matches();
	}
}