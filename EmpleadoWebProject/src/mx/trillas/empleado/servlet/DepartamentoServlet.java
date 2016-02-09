package mx.trillas.empleado.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

/**
 * Servlet implementation class DepartamentoAltaServlet
 */
@WebServlet(description = "alta de Departamento Nuevos", urlPatterns = { "/departamento/alta/DepartamentoAltaServlet" })
public class DepartamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartamentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean success = true;
		List<String> message = new ArrayList<>();
		List<String> inputerror = new ArrayList<>();
		
		
		if (request.getParameterMap().containsKey("departamento")) {
			String departamento = request.getParameter("departamento");
			if (departamento.equals("")) {
				success = false;
				message.add("El departamento no debe ir vacío");
				inputerror.add("departamento");
			
			}
		}
		if (request.getParameterMap().containsKey("prueba")) {
			String prueba = request.getParameter("prueba");
			if (prueba.equals("")) {
				success = false;
				message.add("Prueba no debe ir vacía");
				inputerror.add("prueba");
			
			}
		}
		JSONArray jsonArray = new JSONArray(inputerror);
		JSONArray jsonArray2 = new JSONArray(message);
		
		/*JsonObject obj = Json.createObjectBuilder().add("success", success)
				.add("message",jsonArray2.toString())
				.add("datos", "")				
				.add("inputerror", jsonArray.toString()).build();*/
		
		
		JsonArray value = Json.createArrayBuilder()
			     .add(Json.createObjectBuilder()
			         .add("sucess",success)
			         .add("message",jsonArray2.toString())
			         .add("inputerror",jsonArray.toString()))
			         .build();
		
		System.out.println("json: " + value);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(value.toString());
		
	}
}
