<table>
	<thead>
		<tr>
			<th>Código</th>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Preço</th>
			<th>Quantidade</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${produtoList}" var="produto">
			<tr>
				<td>${produto.id}</td>
				<td>${produto.nome}</td>
				<td>${produto.descricao}</td>
				<td>R$ ${produto.preco}</td>
				<td>${produto.quantidade}</td>
				<td><a href="<c:url value="/produto/${produto.id}"/>">Editar</a> </td>
				<td>
					<form action="<c:url value="/produto/${produto.id}"/>" method="post">
						<button class="link" name="_method" value="DELETE">Remover</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>