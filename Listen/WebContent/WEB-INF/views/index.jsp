<%@include file="/header.jspf"%>

<meta charset="utf-8">
<script>
$(document).ready(function(){
    $('[data-toggle="popover"]').popover({
    	html:true,
    	container:'body'
    });   
});
</script>
<style>
.popover{
	
	width: auto;
}
.content{
	max-width: 100%;
	max-height: 100%;
}
</style>

<body style="background-color:white;" >
	<div  style="background-color:white;"class="container-fluid">
		<div class="row content">
		<%@include file="/menuleft.jspf" %>
			<div style="background-color:white;"class="col-sm-10 text-center">
				<h1>Listen</h1>
				<hr>
				<div class="container">
					<div class="row">
						<c:forEach items="${cds}" var="cd">
							<div class="col-sm-4 col-md-3">
								<div class="productbox">
									<div class="imgthumb img-responsive">
										<img src=<c:url value="/imagens/CD.png" /> width="50%" alt="imagem">
									</div>
									<div class="caption">
										
										<h5><strong>${cd.nomeCD}</strong></h5>
										<b class="finalprice">Pre&ccedilo R$ ${cd.preco}</b>
										<p>
										
											
											<button type="button"class="btn btn-primary btn-md btn-block">
											<span class="glyphicon glyphicon-plus-sign"></span>
											Adicionar ao Carrinho
											</button>
											
											
											
											<a style="text-decoration:none;" title="Faixas do CD" 
											 data-toggle="popover" 
											 data-trigger="focus"
											 data-placement="auto bottom"
											  data-content="
											  <c:forEach items="${listaDeFaixas}" var="faixa">
												<c:if test="${cd.idCD eq faixa.idCd }">
												Faixa ${faixa.numFaixa } - ${faixa.dscFaixa}
												<br />
												
												
												</c:if>	
																				
												</c:forEach>
												Gravadora: ${cd.gravadora}	<br>
												Lan&ccedilamento: ${cd.dataLancamento } <br>
												Artista: ${cd.nomeArtista }<br>
												Genero: ${cd.dscGenero }
													
													">
											   <button type="button"
												class="btn btn-info btn-md btn-block">
												Mais Informa&ccedil&otildees...</button>
											  
											  </a>
										
											 
											
										</p>
										
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<!--/row-->
				</div>
				<!--/container -->
			</div>
		</div>
	</div>
</body>

<%@include file="/footer.jspf"%>