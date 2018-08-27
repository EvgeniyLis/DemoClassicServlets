package lesson01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChBoxCalcServlet
 */
@WebServlet("/chboxcalcservlet")
public class ChBoxCalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChBoxCalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double num1 = Double.parseDouble(request.getParameter("Num1"));
		double num2 = Double.parseDouble(request.getParameter("Num2"));
		String result="";
		if (request.getParameter("Add")!=null) {
			result+="sum= "+(num1+num2)+"<br>";
		}
		if (request.getParameter("Sub")!=null) {
			result+="Sub= "+(num1-num2)+"<br>";
		}
		if (request.getParameter("Mult")!=null) {
			result+="Mult= "+(num1*num2)+"<br>";
		}
		if (request.getParameter("Div")!=null) {
			result+="Div= "+(num1/num2)+"<br>";
		}
		
		request.setAttribute("result", result);
		System.out.println("servlet works");
		RequestDispatcher rd = request.getRequestDispatcher("/Lesson01/CheckBoxCalc.jsp");
		rd.forward(request, response);
	}

}
