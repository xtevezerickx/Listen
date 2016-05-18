<%@include file="/header.jspf" %>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-left">
				<h1>Cadastro de CD</h1>
				<form class="form" method="post" action="adicionarCD">
					<div class="form-group" style="width: 400px">
						<label>Nome:</label>
						<input type="text" class="form-control"	name="tituloCD" placeholder="Digite o titulo do CD"> 
						<label>Preco:</label>
						<input type="text" class="form-control" name="preco"  placeholder="Digite o preço do CD"> <label>idArtista:</label>
						<input type="text" class="form-control" name="idArtista"
							placeholder="Digite o artista"> <label>Gravadora:</label>
						<input type="text" class="form-control" name="gravadora"
							placeholder="Digite a gravadora do cd"> <label>Ano
							Lançamento:</label> <input type="text" class="form-control"
							name="dataLancamento"
							placeholder="Digite a data de lançamento do cd"> <a
							href=#><label data-toggle="collapse" data-target="#faixas">Faixas
								<span class="glyphicon glyphicon-chevron-down"></span>
						</label></a>
						<div id="faixas" class="collapse">
							<%
								for (int i = 0; i <= 10; i++) {
							%>
							<input type="text" class="form-control" id="dscFaixa" name="dscFaixa"
								placeholder="Digite a faixa do cd">
							<%
								}
							%>
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