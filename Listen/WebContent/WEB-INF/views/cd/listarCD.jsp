<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Listen</title>
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
					<li><a href="cadastrarCD">Cadastrar</a></li>
					<li><a href="alterarCD">Alterar</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<li><a href="cadastrarUsuario"><span class="glyphicon glyphicon-user"></span> Cadastre-se</a></li>
					<li><a href="login"><span
							class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-center">
				<h1>Alteração de CDs</h1>
				<table class="table table-hover table-striped">
					<tr>
						<th>CodCD</th>
						<th>Descrição</th>
						<th>Finalizado?</th>
						<th>Data de finalização</th>
						<th colspan="2">Opções</th>
					</tr>
					<tr>
						<th>1</th>
						<th>blabla</th>
						<th>sim</th>
						<th>10/08/2154</th>

						<th><a href="#" class="btn btn-primary btn-sm"> <span
								class="glyphicon glyphicon-search"></span> Alterar
						</a></th>
						<th><a href="removerCD" class="btn btn-danger btn-sm"> <span
								class="glyphicon glyphicon-trash"></span> Remover
						</a></th>
					</tr>
					<tr>
						<th>2</th>
						<th>oioiiu</th>
						<th>nao</th>
						<th>8/8/8888</th>

						<th><a href="#" class="btn btn-primary btn-sm"> <span
								class="glyphicon glyphicon-search"></span> Alterar
						</a></th>
						<th><a href="#" class="btn btn-danger btn-sm"> <span
								class="glyphicon glyphicon-trash"></span> Remover
						</a></th>
					</tr>
					<tr>
						<th>3</th>
						<th>oioiiu</th>
						<th>nao</th>
						<th>8/8/8888</th>

						<th><a href="#" class="btn btn-primary btn-sm"> <span
								class="glyphicon glyphicon-search"></span> Alterar
						</a></th>
						<th><a href="#" class="btn btn-danger btn-sm"> <span
								class="glyphicon glyphicon-trash"></span> Remover
						</a></th>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<footer class="container-fluid text-center">
		<p>CopyRight</p>
	</footer>

</body>
</html>