<%@include file="/header.jspf"%>

<script>
$(document).ready(function() {
    var max_fields      = 30; //maximum input boxes allowed
    var wrapper         = $("#faixas"); //Fields wrapper
    var add_button      = $(".add_field_button"); //Add button ID
    
    var x = 1; //initlal text box count
    $("#add_button").click(function(e){ //on add input button click
        e.preventDefault();
        if(x < max_fields){ //max input box allowed
            x++; //text box increment
            $(wrapper).append('<div><input id="faixa" style="width: 400px;" name="faixa" class="form-control" placeholder="Digite a faixa do cd" type="text" required=""><a href="#" id="remove_field">Remover</a></div>'); //add input box
        }
    });
    
    $(wrapper).on("click","#remove_field", function(e){ //user click on remove text
        e.preventDefault();
    $(this).parent('div').remove();
    	x--;
    })
    
});
   



</script>

<body>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-left">
				<h1>Cadastro de Faixas</h1>
					
				<form class="form" method="post" action="adicionarFaixa?cdId=${cdId}">
				<button id="add_button" class="btn btn-info" type="button"> Adicionar faixa </button>
				<br>
					<div id="faixas">
						<div>
						<input type="text" class="form-control" id="faixa"
							name="faixa" placeholder="Digite a faixa do cd" style="width: 400px">
						<br>
						</div>
				
					</div>
				
							<button type="reset" class="btn btn-danger">Cancelar</button>
							<button type="submit" class="btn btn-success">Finalizar</button>
						
				</form>
			</div>
		</div>
	</div>
</body>

<%@include file="/footer.jspf"%>