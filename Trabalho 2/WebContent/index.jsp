<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">

	<title>Controle De Gastos</title>
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<header>
	  <div class="navbar navbar-dark bg-dark shadow-sm">
	    <div class="container d-flex justify-content-between">
	      <a href="index.jsp" class="navbar-brand d-flex align-items-center">
	        <strong>Controle De Gastos</strong>
	      </a>
	    </div>
	  </div>
	</header>
	<section class="jumbotron text-center" style= "background-image: url(https://cdnb.artstation.com/p/assets/images/images/019/170/275/large/ford-nguyen-rooftop.jpg?1562315892);background-size: cover;">
	    <div class="container">
	      <h1 class="badge badge-primary text-wrap" style= "background-color: #00000059;color: white; font-size:300%;">Controle De Gastos!!</h1>
	      <br>
	      <c:if test="${gastos != null }">
		      <p class="badge badge-primary text-wrap" style= "background-color: #00000059;color: white; font-size:180%;">Quantidade de bens de consumo: ${gastos.qtdCon}<br>Quantidade de bens de capital: ${gastos.qtdCap}<br>
		      Maior preço: R$ ${gastos.maiorValor}<br>Menor preço: R$ ${gastos.menorValor}<br>Valor Total: R$ ${gastos.menorValor}</p>
	      </c:if>
	      <div>
	      	<form action="GastosController" method="get">
				<input class="btn btn-primary my-2" type = "submit" value = "Clique aqui para ver o Relatório">
			</form>
	        <form action="<%=request.getContextPath()%>/get" method="get">
				<input class="btn btn-secondary my-2" type = "submit" value = "Clique aqui para ver a Tabela">
			</form>
	      </div>
	    </div>
  </section>
	
	<main role="main">
		  <c:if test="${lista != null }">
			<div class="mx-auto" style="width: 50%;height: 150px;">
			<div class ="container text-right">
				<a class="btn btn-success my-2" href="form.jsp">Adicionar Produto</a>
		  	</div>
				<table class="table table-bordered">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">Nome</th>
				      <th scope="col">Valor</th>
				      <th scope="col">Categoria</th>
				      <th scope="col">Descricação</th>
				      <th scope="col">Editar</th>
				      <th scope="col">Excluir</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${lista}" var = "produtos">
					    <tr>
					      <td>${produtos.nome}</td>
					      <td>R$ ${produtos.valor}</td>
					      <td>${produtos.categoria}</td>
					      <td>${produtos.descricao}</td>
					      <td>
					      <form action="<%=request.getContextPath()%>/formEdit?id=<c:out value = '${produtos.id}'/>" method="post">
							<input class="btn btn-primary btn-sm" type = "submit" value="Editar">
						  </form>
					      </td>
					      <td>
					      <form action="<%=request.getContextPath()%>/delete?id=<c:out value = '${produtos.id}'/>" method="post">
							<input class="btn btn-danger btn-sm" type = "submit" value="Deletar">
						  </form>
					      </td>
							
					    </tr>
					 </c:forEach>
				  </tbody>
				</table>
			</div>
		</c:if>
		<br>
		<br>
	</main>
	
</body>
</html>