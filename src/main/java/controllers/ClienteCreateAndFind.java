package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import model.Cliente;


@WebServlet("/CreateAndFind")
public class ClienteCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ClienteCreateAndFind() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");
		
		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<Cliente> clientes = ClienteDao.find(pesquisa);
		
		request.setAttribute("clientes", clientes);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("lista.jsp");
		requestDispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNomeCompleto(request.getParameter("nomeCompleto"));
		cliente.setRua(request.getParameter("rua"));
		cliente.setBairro(request.getParameter("bairro"));
		cliente.setCep(request.getParameter("cep"));
		cliente.setCidade(request.getParameter("cidade"));
		cliente.setEstado(request.getParameter("estado"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setNumero(request.getParameter("numero"));
		
		ClienteDao.create(cliente);
		doGet(request, response);
	}

}
