package br.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.GastosBean;
import br.com.bo.ProdutoBO;

/**
 * Servlet implementation class GastosController
 */
@WebServlet("/GastosController")
public class GastosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProdutoBO produtoBO = new ProdutoBO();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GastosController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GastosBean gastos = produtoBO.contabilizarGastos();
		request.setAttribute("gastos", gastos);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
