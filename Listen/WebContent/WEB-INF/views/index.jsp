<%@include file="/header.jspf"%>

<meta charset="utf-8">
<script>
$(document).ready(function(){
    $('[data-toggle="popover"]').popover({
    	html:true,
    	container:'body'
    });   
});

$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip(); 
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
				<h2>&Uacuteltimos Lan&ccedilamentos</h2>
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
										<b class="price">Pre&ccedilo R$ ${cd.preco}</b>
										<p>
										
											
											<button type="button"class="btn btn-primary btn-md btn-block">
											
											Adicionar ao Carrinho
											<span class="glyphicon glyphicon-plus"></span>
											</button>
											
											
											
											<a style="text-decoration:none;" title="Outras Informa&ccedil&otildees" 
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
												
												Mais Informa&ccedil&otildees
												<span class="glyphicon glyphicon-info-sign"></span>
												</button>
											  
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
<footer style= "background-color: white;" class="text-center footer">
<ul class="pagination" style="align:center;">
    						<li><a href="#">1</a></li>
    						<li><a href="#">2</a></li>
    						<li><a href="#">3</a></li>
   							<li><a href="#">4</a></li>
   							<li><a href="#">5</a></li>
  						</ul>

</footer>

<%@include file="/footer.jspf"%>