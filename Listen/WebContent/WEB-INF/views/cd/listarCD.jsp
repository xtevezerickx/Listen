<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="/header.jspf"%>
<style>
	.table th{
		text-align: center;
	}
</style>
<script type="text/javascript">

function aumenta(obj){
    obj.height=obj.height*3;
	obj.width=obj.width*3;
}
 
function diminui(obj){
	obj.height=obj.height/3;
	obj.width=obj.width/3;
}

</script>
<body>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-center">
			
			<c:if test="${msg != null }">
			<div class="alert alert-success">
    			<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    			<strong>Parabéns!</strong> ${msg}
  			</div>
			</c:if>
			
		
			
				<h1>Alteração de CDs</h1>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Capa do Album</th>
							<th>Nome</th>
							<th>Artista</th>
							<th>Genero</th>
							<th>Gravadora</th>
							<th>Data Criacao</th>
							<th>Ano Lançamento</th>
							<th colspan="4">Opções</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cds}" var="cd">
							<tr>
								<td><img src=<c:url value='/imagens/CD${cd.idCD}.png' />
								 width="50px" height="50px" alt="/imagens/CD.png"
								
								 ></td>
								<td>${cd.nomeCD}</td>
								<td>${cd.nomeArtista}</td>
								<td>${cd.dscGenero}</td>			
								<td>${cd.gravadora}</td>
								<td>${cd.dataCriacao}</td>
								<td>${cd.dataLancamento}</td>
								
								<th>
								<a href="mostrarFaixa?cdId=${cd.idCD}" class="btn btn-success btn-sm"> <span
										class="glyphicon glyphicon-plus"></span> Adicionar Faixas
								</a>
								</th>
								<th>
								<a href="uploadImagem?cdId=${cd.idCD}" class="btn btn-info btn-sm"> <span
										class="glyphicon glyphicon-picture"></span> Adicionar Imagem
								</a>
								</th>
							
								<th><a href="mostrarCD?cdId=${cd.idCD}" class="btn btn-primary btn-sm"> <span
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
<footer style= "background-color: white;" class="text-center footer">
<ul class="pager">
	<li><a href="listarCd?pag=${paginas[0]}">Primeira</a></li>


			<c:forEach items="${paginas}" var="pagina" >
	
				<li><a href="listarCd?pag=${pagina}">${pagina}</a></li>
			
			</c:forEach>
		
		
<li><a href="listarCd?pag=${fn:length(paginas)}">Ultima</a></li>
</ul>

</footer>
<%@include file="/footer.jspf"%>
