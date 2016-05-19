<%@include file="/header.jspf" %>
<body>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-12 text-center">
				<h1>Welcome</h1>

				<hr>
				<h3>Test</h3>
				<c:forEach begin="1" end="10">
				<p>Lorem ipsum...</p>
				</c:forEach>

			</div>
		</div>
	</div>
</body>

<%@include file="/footer.jspf"%>