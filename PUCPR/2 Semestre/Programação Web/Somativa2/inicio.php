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
				<li><a href="inicio.php" class="active">Inicio</a></li>
				<li><a href="cadastrar.php">Cadastrar</a></li>
				<li><a href="Listar.php">Listar</a></li>
			</ul>
		  </nav>
		  
		  <article>

			<br/>Bem-vindo <span class="nomeusuario"><?php echo $_SESSION['nome']; ?></span>!<br/><br/>
		
			<a href="logout.php">Sair</a>
		  </article>
		</section>

		<footer>
			<p>© Todos direitos reservados.</p>
			<p>Desenvolvido pelo grupo 46.</p>
		</footer>
	
		
	</body>
</html>