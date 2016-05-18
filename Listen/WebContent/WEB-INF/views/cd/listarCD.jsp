<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="/header.jspf"%>
<body>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-center">
				<h1>Alteração de CDs</h1>
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<th>Nome</th>
							<th>idArtista</th>
							<th>Gravadora</th>
							<th>Ano Lançamento</th>
							<th colspan="2">Opções</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cd}" var="cd">
							<tr>
								<th>${cd.nome}</th>
								<th>${cd.idArtista}</th>
								<th>${cd.gravadora}</th>
								<th>${cd.anoLancamento}</th>
								<th><a href="#" class="btn btn-primary btn-sm"> <span
										class="glyphicon glyphicon-search"></span> Alterar
								</a></th>
								<th><a href="removerCD" class="btn btn-danger btn-sm">
										<span class="glyphicon glyphicon-trash"></span> Remover
								</a></th>
							</tr>
						</c:forEach>
					</tbody>
					<tr>
						<th>1</th>
						<th>blabla</th>
						<th>sim</th>
						<th>10/08/2154</th>


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
</body>
<%@include file="/footer.jspf"%>
