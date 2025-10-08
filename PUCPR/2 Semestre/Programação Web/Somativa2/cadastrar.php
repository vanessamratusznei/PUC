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
				<li><a href="cadastrar.php"class="active">Cadastrar</a></li>
                <li><a href="cadusuarios.php">Criar Usuários</a></li>
                <li><a href="cadfornecedores.php">Criar Fornecedores</a></li>
                <li><a href="cadprodutos.php">Criar Produtos</a></li>
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