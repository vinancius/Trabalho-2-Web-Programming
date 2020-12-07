package br.com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.ProdutoBean;
import br.com.bo.ProdutoBO;

/**
 * Servlet implementation class produtoController
 */
@MultipartConfig 
@WebServlet("/")
public class produtoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProdutoBO produtoBO = new ProdutoBO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public produtoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getServletPath()) {
		case "/get":
			ArrayList<ProdutoBean> lista = new ArrayList<ProdutoBean>();
			lista = produtoBO.listarProdutos();
			request.setAttribute("lista", lista);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		switch (request.getServletPath()) {
		case "/post":
				produtoBO.inserirProduto(request.getParameter("nome"),Double.parseDouble(request.getParameter("valor")),request.getParameter("categoria"), request.getParameter("descricao"));
				response.sendRedirect("index.jsp");
			break;
			
		case "/delete":
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				produtoBO.deletarProduto(id);
				response.sendRedirect("index.jsp");
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "/formEdit":
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				ProdutoBean produto = produtoBO.getProduto(id);
				request.setAttribute("produto", produto);
				request.getRequestDispatcher("form.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case "/put":
			try {
				produtoBO.atualizarProduto(Integer.parseInt(request.getParameter("id")),request.getParameter("nome"),Double.parseDouble(request.getParameter("valor")),request.getParameter("categoria"), request.getParameter("descricao"));
				response.sendRedirect("index.jsp");
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
		}
	}
}
