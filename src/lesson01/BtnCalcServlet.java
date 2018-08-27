package lesson01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BtnCalcServlet
 */
@WebServlet("/btncalcservlet") // паттерн сервлета вставляется в аттрибут action соответствующей формы
public class BtnCalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BtnCalcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double num1 = Double.parseDouble(request.getParameter("Num1"));
		double num2 = Double.parseDouble(request.getParameter("Num2"));
		double result;
		String buttonValue = request.getParameter("Oper");
		switch (buttonValue) {
		case "+":
			result = num1+num2;
			break;
		case "-":
			result = num1-num2;
			break;
		case "*":
			result=num1*num2;
			break;
		default:
			result=num1/num2;
			break;
		}
		request.setAttribute("result", result);
		System.out.println("servlet works");
		RequestDispatcher rd = request.getRequestDispatcher("/Lesson01/ButtonsCalc.jsp");
		rd.forward(request, response);
		
	}

}
