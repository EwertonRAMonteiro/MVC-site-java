<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Pesquisa de clientes</title>
	<link rel="stylesheet" href="index.css">
<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
	</head>
<body>
	<header>
      <!--bootstrap nav com alterações-->
      <nav id="cont" class="navbar navbar-expand-lg navbar-dark">
        <div class="container-fluid">
          <a class="navbar-brand" href="index.html">
            <img src="logoIconeNav.png" alt="logoDaNav" width="99" height="25"
              class="d-inline-block align-text-top">
          </a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link text-white" aria-current="page" href="index.html">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link text-white" href="CreateAndFind">lista de clientes</a>
              </li>
            </ul>
            <form action="CreateAndFind" method="GET" class="d-flex" role="search">
    			 <input name="pesquisa" class="form-control me-2" type="search" placeholder="digite o nome ou cpf" aria-label="Search">
     			 <button class="btn btn-primary" type="submit">buscar</button>
   			 </form>
          </div>
        </div>
      </nav>
    </header>
    <main class="container">
   	 <section class="row">
    	<div class="cold-md-7">
    		<hr>
    		<h1>lista de clientes</h1>
    		<hr> 
    		<table class="table">
    			<thead>
    				<tr>
    					<th>#</th>
    					<th>CPF</th>
    					<th>Nome</th>
    					<th>Rua</th>
    					<th>Bairro</th>
    					<th>CEP</th>
    					<th>Cidade</th>
    					<th>Estado</th>
    					<th>E-mail</th>
    					<th>Numero</th>
    				</tr>
    			</thead>
    			<tbody>
    				<c:forEach items="${clientes}" var="cliente">
						<tr>
							<td>${clientes.id}</td>
							<td>${clientes.cpf}</td>
							<td>${clientes.nomeCompleto}</td>
							<td>${clientes.rua}</td>
							<td>${clientes.bairro}</td>
							<td>${clientes.cep}</td>
							<td>${clientes.cidade}</td>
							<td>${clientes.estado}</td>
							<td>${clientes.email}</td>
							<td>${clientes.numero}</td>
							<td>
								<a href="ClienteDelete?clienteId=${clientes.id}">Deletar</a>
								<a href="ClienteUpdate?clienteId=${clientes.id}">Atualizar</a>
							</td>
						</tr>
					</c:forEach>
    			</tbody>
    		</table>
    		<br>
    		<h5><a href="index.html">Voltar para o Cadastro de Clientes</a></h5>	
    	</div>
   	 </section>
    
    </main>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>
