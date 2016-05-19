<%@include file="/header.jspf"%>
<meta charset="utf-8">
<script>
$(document).ready(function(){
    $('[data-toggle="popover"]').popover();   
});
</script>
<body>
	<div class="container">
		<div class="row content">
			<div class="col-sm-12 text-center">
				<h1>Listen</h1>
				<hr>
				<div class="container">
					<div class="row">
						<c:forEach items="${cds}" var="cd">
							<div class="col-xs-18 col-sm-4 col-md-3">
								<div class="productbox">
									<div class="imgthumb img-responsive">
										<img src=<c:url value="/imagens/CD.png" /> width="50%" alt="imagem">
									</div>
									<div class="caption">
										
										<h5>${cd.nomeCD}</h5>
										<b class="finalprice">Pre&ccedilo do cd:${cd.preco}</b>
										<p>
										
											
											<button type="button"class="btn btn-primary btn-md btn-block">
											<span class="glyphicon glyphicon-plus-sign"></span>
											Adicionar ao Carrinho
											</button>
											
											
											
											<a href="#" title="Faixas do CD" 
											 data-toggle="popover" 
											 data-trigger="focus"
											  data-content="
											  <c:forEach items="${listaDeFaixas}" var="faixa">
												<c:if test="${cd.idCD eq faixa.idCd }">
												
												${faixa.dscFaixa} 
												</c:if>									
												</c:forEach>
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