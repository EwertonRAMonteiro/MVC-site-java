package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HospedagemDao;
import model.Cliente;
import model.Hospedagem;


@WebServlet("/HCreateAndFind")
public class HospedagemCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HospedagemCreateAndFind() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisa = request.getParameter("pesquisa");
		
		if(pesquisa == null) {
			pesquisa="";
		}
		
		List<Hospedagem> hospedagems = HospedagemDao.fin(pesquisa);
		
		request.setAttribute("hospedagems", hospedagems);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("listah.jsp");
		requestDispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Hospedagem hospedagem = new Hospedagem();
		hospedagem.cliente = new Cliente();
		
		hospedagem.setNomeHotel(request.getParameter("nomeHotel"));
		hospedagem.setEndereco(request.getParameter("endereco"));
		hospedagem.setEstado(request.getParameter("estado"));
		hospedagem.setValorIntegral(request.getParameter("valorIntegral"));
		hospedagem.setCheckIn(request.getParameter("checkIn"));
		hospedagem.setCheckOut(request.getParameter("checkOut"));
		hospedagem.setNumeroHotel(request.getParameter("numeroHotel"));
		hospedagem.cliente.setCpf(request.getParameter("cpf"));
		hospedagem.cliente.setNomeCompleto(request.getParameter("nomeCompleto"));
		hospedagem.cliente.setRua(request.getParameter("rua"));
		hospedagem.cliente.setBairro(request.getParameter("bairro"));
		hospedagem.cliente.setCep(request.getParameter("cep"));
		hospedagem.cliente.setCidade(request.getParameter("cidade"));
		hospedagem.cliente.setEstado(request.getParameter("estado"));
		hospedagem.cliente.setEmail(request.getParameter("email"));
		hospedagem.cliente.setNumero(request.getParameter("numero"));
		
		int clienteId = 0;
		HospedagemDao.create(hospedagem, clienteId);		
		doGet(request, response);
	}

}
