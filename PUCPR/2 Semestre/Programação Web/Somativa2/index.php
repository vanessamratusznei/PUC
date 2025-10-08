
<!DOCTYPE html>
<html>
	<head>
		<title>Materiais de Construção - Login</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="css/estilo.css?v=<?= time() ?>">
	</head>
	<body>
	
		<header>
		  <h2>Materiais de Construção</h2>
		</header>
		
		<main>
			<p style="text-align:center"></br>Realize o login para acessar a área restrita.</p>

			<?php

				//Se não autenticou - enviado parametro de erro
				if(isset($_GET['erro'])) {
					echo '<p style="text-align:center;color:red">Usuário e/ou Senha incorreto(s).</p>';
				}

				if(isset($_GET['autentica'])) {
					echo '<p style="text-align:center;color:red">Você não tem permissão de acesso.</p>';
				}

			?>
		</main>
	
		<div class="index">
						
			
			<form action="login.php" method="post">
			
				<label for="login">Usuário</label> 
				<input type="email" name="login" id="login" placeholder="Digite o e-mail" required>
				
				<label for="senha">Senha</label> 
				<input type="password" name="senha" id="senha" placeholder="Digite a senha" required><br/><br/>
				
				<input type="submit" value="Autenticar">
			
			</form>
		</div>
		
		

		<footer>
		  <p>© Todos direitos reservados.</p>
		  <p>Desenvolvido pelo grupo 46.</p>
		</footer>
	</body>
</html>