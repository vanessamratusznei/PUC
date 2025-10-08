<?php
	include "includes/autentica.php";
?>

<!DOCTYPE html>
<html>
	<head>
		<title>Materiais de Construção - Área restrita - Tela inicial</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/estilo.css?v=<?= time() ?>">
	</head>
	<body>
	
		<header>
		  <h2>Materiais de Construção</h2>
		</header>

		<section>
		  <nav>
			<ul id="menu">
				<li><a href="listar.php"class="active">Listar</a></li>
                <li><a href="listausuarios.php">Usuários Cadastrados</a></li>
                <li><a href="listafornecedores.php">Fornecedores Cadastrados</a></li>
                <li><a href="listaprodutos.php">Produtos Cadastrados</a></li>
			</ul>
		  </nav>
		  
		  <article>

            <a href="inicio.php">Voltar</a>
					
		  </article>
		</section>

		<footer>
            <p>© Todos direitos reservados.</p>
		    <p>Desenvolvido pelo grupo 46.</p>
		</footer>
	
		
	</body>
</html>