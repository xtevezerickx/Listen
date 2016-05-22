<%@include file="/header.jspf" %>

<body>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-left">
				<h1>Alterar cd - ${cd.nomeCD}</h1>
				<form class="form" method="post" action="alterarCd">
					<div class="form-group" style="width: 400px">
						<input type="hidden" name=idCD value="${cd.idCD}"> ${cd.idCD}
						<label>Nome:</label><input type="text" class="form-control"	value="${cd.nomeCD }"name="nomeCD"> 
						<label>Preco:</label>	<input type="text" class="form-control" value="${cd.preco }" name="preco">
						<label>Artista:</label><input type="text" class="form-control" value="${cd.nomeArtista }" name="nomeArtista">
						<label>Genero:</label>
						<select class="form-control" name=genero >
					
							<option selected="selected">${cd.dscGenero }</option>
						<c:forEach items="${listaGeneros}" var="generos">
							<option>${generos}</option>
						</c:forEach>
						</select>
						<label>Gravadora:</label>	<input type="text" class="form-control" value="${cd.gravadora }" name="gravadora">
						<label>Ano	Lançamento:</label> <input value="${cd.dataLancamento }" type="text" class="form-control"name="dataLancamento" placeholder="Digite a data de lançamento do cd"> 
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