<%@include file="/header.jspf" %>

<body>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-left">
				<h1>Cadastro de CD</h1>
				<form class="form" method="post" action="adicionarCD">
					<div class="form-group" style="width: 400px">
						<label>Nome:</label>
						<input type="text" class="form-control"	value="teste"name="nomeCD" placeholder="Digite o titulo do CD"> 
						<label>Preco:</label>
						<input type="text" class="form-control" value="10.50" name="preco"  placeholder="Digite o preço do CD"> <label>idArtista:</label>
						<input type="text" class="form-control" value="5" name="idArtista"
							placeholder="Digite o artista"> <label>Gravadora:</label>
						<input type="text" class="form-control" value="teste" name="gravadora"
							placeholder="Digite a gravadora do cd"> <label>Ano
							Lançamento:</label> <input value="1994" type="text" class="form-control"
							name="dataLancamento"
							placeholder="Digite a data de lançamento do cd"> 
						<div class="form-group container">
							<button type="reset" class="btn btn-danger">Cancelar</button>
							<button type="submit" class="btn btn-primary">Proximo</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>


<%@ include file="/footer.jspf"%>