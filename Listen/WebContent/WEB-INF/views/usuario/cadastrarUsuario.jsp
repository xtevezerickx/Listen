<!DOCTYPE html>
<html lang="en">
<head>
<title>Cadastro de Usu�rio</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index">Listen</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Cadastrar</a></li>
					<li><a href="listarCD">Alterar</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<li><a href="novoUsuario"><span class="glyphicon glyphicon-user"></span> Cadastre-se</a></li>
					<li><a href="login"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-left">
				<h1>Cadastro de Usu�rio</h1>
				<form class="form" method="post" action="adicionarUsuario">
					<div class="form-group" style="width: 400px">
						<label>Nome:</label> <input type="text" class="form-control" name="nome">
						<label>RG:</label> <input type="text" class="form-control" name="rg">
						<label>CPF:</label> <input type="text" class="form-control" name="cpf">
						<label>Rua:</label> <input type="text" class="form-control" name="rua">
						<label>CEP:</label> <input type="text" class="form-control" name="cep">
						<label>Cidade:</label> <input type="text" class="form-control" name="cidade">
						<label>Estado:</label> <input type="text" class="form-control" name="estado">
						<label>Data de Nascimento:</label> <input type="text" class="form-control" name="dataNascimento">
						<label>Email:</label> <input type="text" class="form-control" name="email">
						<label>Telefone:</label> <input type="text" class="form-control" name="telefone">
						<label>Login:</label> <input type="text" class="form-control" name="login">
						<label>Senha:</label> <input type="text" class="form-control" name="senha">
						<div class="form-group container">
							<button type="reset" class="btn btn-danger">Cancelar</button>
							<button type="submit" class="btn btn-primary">Cadastrar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<footer class="container-fluid text-center">
		<p>CopyRight</p>
	</footer>

</body>