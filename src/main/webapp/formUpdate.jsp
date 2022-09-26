<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Cliente</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link rel="stylesheet" href="index.css">
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
                <a class="nav-link" href="CreateAndFind">Lista de Clientes</a>
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
    		<h1>Atualizar Cadastro</h1>
    		<hr> 
    		<form action="ClienteUpdate" method="POST">
    			<input value="${cliente.id}" name="id" type="number" style="visibility:hidden">
    			<div class="form-floating mb-3">
						<input value="${cliente.cpf}" name="cpf" maxlength="15" type="text" class="form-control" id="floatingInput1"> 
						<label>CPF (apenas números)</label>
				</div>
    			<div class="form-floating mb-3">
						<input value="${cliente.nomeCompleto}" name="nomeCompleto" maxlength="80" type="text" class="form-control"> 
						<label>Nome</label>
				</div>
				<div class="form-floating mb-3">
						<input value="${cliente.rua}" name="rua" maxlength="50" type="text" class="form-control"> 
						<label>Rua</label>
				</div>
				<div class="form-floating mb-3">
						<input value="${cliente.bairro}" name="bairro" maxlength="50" type="text" class="form-control"> 
						<label>Bairro</label>
				</div>
				<div class="form-floating mb-3">
						<input value="${cliente.cep}" name="cep" maxlength="10" type="text" class="form-control"> 
						<label>CEP (apenas numeros)</label>
				</div>
				<div class="form-floating mb-3">
						<input value="${cliente.cidade}" name="cidade" maxlength="50" type="text" class="form-control"> 
						<label>Cidade</label>
				</div>
				<div class="form-floating mb-3">
						<input value="${cliente.estado}" name="estado" maxlength="30" type="text" class="form-control"> 
						<label>Estado (UF)</label>
				</div>
				<div class="form-floating mb-3">
						<input value="${cliente.email}" name="email" maxlength="50" type="text" class="form-control"> 
						<label>E-mail</label>
				</div>
				<div class="form-floating mb-3">
						<input value="${cliente.numero}" name="numero" maxlength="15" type="text" class="form-control"> 
						<label>Telefone</label>
				</div>
				
				<button class="btn btn-success" type="submit">Atualizar Dados</button>
				<button class="btn btn-secondary" type="reset">Limpar Formulário</button>
    		</form>  
    		<br>
    	</div>
   	 </section>
    
    </main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</body>
</html>