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

	<title>Gastos</title>
	
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

<main role="main">
  	<div class = "container">
  		<br>
  		<h3>Produto</h3>
  		<br>
  	<c:if test="${produto == null }">  	 
  	  <div class="card" style="width: 40rem;"> 
	  		<div class="card-header">
	   			 Cadastrar Produto
	 		 </div>
 		  <div class="card-body">
			<form id = "form" action="<%=request.getContextPath()%>/post" method="post" enctype="multipart/form-data">
				  <div class="form-row">
				    <div class="col-md-2.5 mb-3">
				      <label for="nome">Nome</label>
				      <input type="text" class="form-control" id="nome" name = "nome" placeholder="Nome do Produto" required>
				    </div>
					<div class="col-md-2.5 mb-3">
						<label for="valor">Valor</label>
					    <input type="number" class="form-control" id="valor" name = "valor" placeholder="Valor"required>
					</div>
					<div class="col-md-2.5 mb-3">
						<label for="categoria">Selecione a Categoria:</label>
						<select class = "form-control" name="categoria" id="categoria" required>
						    <option value="Bens de consumo">Bens de consumo</option>
						    <option value="Bens de capital">Bens de capital</option>
						</select>
					</div>
				  </div>
				  <div class="form-row">
				    <div class="col-md-2.5 mb-3">
				      <label for="descricao">Descrição</label>
				      <input type="text" class="form-control" id="descricao" name = "descricao" placeholder="Descrição">
				    </div>
				  </div>
				  <button class="btn btn-primary" type="submit">Cadastrar</button>
			</form>
		</div>
	  </div>
	 </c:if>
	 <c:if test="${produto != null }">  	 
	  	  <div class="card" style="width: 40rem;"> 
		  		<div class="card-header">
		   			 Editar Produto
		 		 </div>
	 		  <div class="card-body">
				<form id = "form" action="<%=request.getContextPath()%>/put" method="post" enctype="multipart/form-data">
				<input type="hidden" class="form-control" id="id" name = "id" value = "<c:out value = '${produto.id}'/>" required>
					  <div class="form-row">
					    <div class="col-md-2.5 mb-3">
					      <label for="nome">Nome</label>
					      <input type="text" class="form-control" id="nome" name = "nome" placeholder="Nome do Produto" value = "<c:out value = '${produto.nome}'/>" required>
					    </div>
						<div class="col-md-2.5 mb-3">
							<label for="valor">Valor</label>
						    <input type="number" class="form-control" id="valor" name = "valor" placeholder="Valor" value = "<c:out value = '${produto.valor}'/>" required>
						</div>
						<div class="col-md-2.5 mb-3">
							<label for="categoria">Selecione a Categoria:</label>
								<select class = "form-control" name="categoria" id="categoria" required>
								    <option value="Bens de consumo">Bens de consumo</option>
								    <option value="Bens de capital">Bens de capital</option>
								</select>
						</div>
					  </div>
					  <div class="form-row">
					    <div class="col-md-2.5 mb-3">
					      <label for="descricao">Descrição</label>
					      <input type="text" class="form-control" id="descricao" name = "descricao" placeholder="Descrição" value = "<c:out value = '${produto.descricao}'/>" required> 
					    </div>
					  </div>
					  <button class="btn btn-primary" type="submit">Cadastrar</button>
				</form>
			</div>
		  </div>
	 </c:if>
	</div>
</main>
</body>
</body>
</html>


