<%@include file="/header.jspf"%>
<body>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-left">
				<h1>Cadastro de Faixas</h1>
				<form class="form" method="post" action="adicionarFaixa">
					<div id="faixas" >
						<%for (int i = 0; i <= 10; i++) {%>
						<input type="text" class="form-control" id="faixa"
							name="faixa" placeholder="Digite a faixa do cd" style="width: 400px">
						<br>
						<%}%>
					</div>
					<div class="form-group container">
							<button type="reset" class="btn btn-danger">Cancelar</button>
							<button type="submit" class="btn btn-success">Finalizar</button>
						</div>
				</form>
			</div>
		</div>
	</div>
</body>

<%@include file="/footer.jspf"%>