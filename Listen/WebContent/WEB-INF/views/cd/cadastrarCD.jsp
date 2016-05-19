<%@include file="/header.jspf" %>

<body>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-left">
				<h1>Cadastro de CD</h1>
				<form class="form" method="post" action="adicionarCD">
					<div class="form-group" style="width: 400px">
						<label>Nome:</label><input type="text" class="form-control"	value="teste"name="nomeCD" placeholder="Digite o titulo do CD"> 
						<label>Preco:</label>	<input type="text" class="form-control" value="10.50" name="preco"  placeholder="Digite o preço do CD">
						<label>Artista:</label><input type="text" class="form-control" value="5" name="nomeArtista" placeholder="Digite o artista">
						<label>Genero:</label>	<input type="text" class="form-control" value="teste" name="dscGenero"placeholder="Digite a gravadora do cd">
						<label>Gravadora:</label>	<input type="text" class="form-control" value="teste" name="gravadora"placeholder="Digite a gravadora do cd">
						<label>Ano	Lançamento:</label> <input value="1994" type="text" class="form-control"name="dataLancamento" placeholder="Digite a data de lançamento do cd"> 
						<a href=#><label data-toggle="collapse" data-target="#faixas">Faixas</label></a>
						<div id="faixas" class="collapse">
						<c:forEach begin="1" end="10">
						<input type="text" class="form-control" id="faixa"
							name="faixa" placeholder="Digite a faixa do cd" style="width: 400px">
						<br>
						</c:forEach>

						</div>
						<div class="form-group container">
							<button type="reset" class="btn btn-danger">Cancelar</button>
							<button type="submit" class="btn btn-primary">Cadastrar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>


<%@ include file="/footer.jspf"%>