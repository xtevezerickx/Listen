<%@include file="/header.jspf" %>

<body>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-left">
				<h1>Cadastro de CD</h1>
				<form class="form" method="post" action="adicionarCd">
					<div class="form-group" style="width: 400px">
						
						<label>Nome:</label><input type="text" class="form-control"	value="teste"name="nomeCD" placeholder="Digite o titulo do CD"> 
						<label>Preco:</label>	<input type="text" class="form-control" value="10.50" name="preco"  placeholder="Digite o preço do CD">
						<label>Artista:</label><input type="text" class="form-control" value="Artista" name="nomeArtista" placeholder="Digite o artista">
						<label>Genero:</label>
						<select class="form-control" name=dscGenero>
						<c:forEach items="${listaGeneros}" var="generos">
							<option>${generos}</option>
						</c:forEach>
						</select>					

						<label>Gravadora:</label>	<input type="text" class="form-control" value="teste" name="gravadora" placeholder="Digite a gravadora do cd">
						<label>Ano	Lançamento:</label> <input value="1994" type="text" class="form-control"name="dataLancamento" placeholder="Digite a data de lançamento do cd"> 
						
						<br>
						<p style="text-align:right;">
							<button type="reset" class="btn btn-danger">Cancelar</button>
							<button type="submit" class="btn btn-primary">Cadastrar</button>
						</p>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>


<%@ include file="/footer.jspf"%>