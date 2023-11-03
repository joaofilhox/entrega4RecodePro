<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar Cliente</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-expand-lg bg-body-tertiary ">
		<div class="container-fluid">
			<nav class="navbar navbar-light bg-light">
				<a class="navbar-brand" href="inicio.html"><strong>Voltar
						para o site</strong></a>
			</nav>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" href="CreateAndFind">
							<i class="bi bi-list me-2"></i> Listar Clientes
					</a></li>
					<li class="nav-item"><a class="nav-link" href="index.html">
							<i class="bi bi-person-plus me-2"></i> Cadastrar Cliente
					</a></li>
				</ul>

				<form action="CreateAndFind" method="get" class="d-flex"
					role="search">
					<input name="pesquisa" class="form-control me-2" type="search"
						placeholder="Buscar cliente por Nome" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Buscar</button>
				</form>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="cold-md-7">
				<hr>
				<h3>Atualizar Cliente</h3>
				<hr>
				<form action="ClienteUpdate" method="POST">
					<input value="${cliente.id}" name="id" type="number"
						style="display: none">
					<div class="form-floating mb-3">
						<input value="${cliente.nome}" name="nome" maxlength="40"
							type="text" class="form-control" id="floatingInput1"> <label
							for="floatingInput1">Nome completo</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.cpf}" name="cpf" maxlength="11"
							type="text" class="form-control"> <label
							for="floatingInput2">CPF (apenas números)</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.endereco}" name="endereco" type="text"
							class="form-control"> <label for="floatingInput3">Endereço</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.telefone}" name="telefone" type="tel"
							class="form-control"> <label for="floatingInput4">Telefone</label>
					</div>
					<div class="form-floating mb-3">
						<input value="${cliente.email}" name="email" type="email"
							class="form-control"> <label for="floatingInput5">Email</label>
					</div>
					<button class="btn btn-success" type="submit">Atualizar
						Dados do Cliente</button>
					<button class="btn btn-secondary" type="reset">Limpar
						Formulário</button>
				</form>

			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>