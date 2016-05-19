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
							<th>Data Criacao</th>
							<th>Ano Lançamento</th>
							<th colspan="2">Opções</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cds}" var="cd">
							<tr>
								<td>${cd.nomeCD}</td>
								<td>${cd.idArtista}</td>
								<td>${cd.gravadora}</td>
								<td>${cd.dataCriacao}</td>
								<td>${cd.dataLancamento}</td>
							<th></th>
								<th><a href="#" class="btn btn-primary btn-sm"> <span
										class="glyphicon glyphicon-search"></span> Alterar
								</a></th>
								<th><a href="removerCD?cdId=${cd.idCD}" class="btn btn-danger btn-sm">
										<span class="glyphicon glyphicon-trash"></span> Remover
								</a></th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<%@include file="/footer.jspf"%>
