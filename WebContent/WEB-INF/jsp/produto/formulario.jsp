<form action="<c:url value="/produto/${produto.id}"/>" method="post">
	<fieldset>
		<legend>Adiciona Produto</legend>
		<label for="nome">Nome:</label>
		<input type="text" name="produto.nome" value="${produto.nome}"/>
			
		<label for="descricao">Descrição:</label>
		<input type="text" style="width: 380px" name="produto.descricao" value="${produto.descricao}"/>
			
		<label for="preco">Preço:</label>
		<input type="text" style="width: 80px" name="produto.preco" value="${produto.preco}"/>
			
		<label for="quantidade">Quantidade:</label>
		<input type="text" style="width: 80px" name="produto.quantidade" value="${produto.quantidade}"/>
		<input type="submit" value="Criar"/>
	</fieldset>
</form>