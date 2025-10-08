<?php
	include "includes/autentica.php";
?>

<?php

	 //Abre conexão com o MySQL
	 $conn = mysqli_connect("localhost", "root", "", "construcaoprodutos");

	 if($conn == false){
		 die("ERRO: Não conectou com o BD!");
	 }

	 $id = "";
	 $nome = "";
	 $codBarras = "";
	 $quantidade = "";
     $undMedida = "";
     $idFornecedor = "";
	 
	 //Se existir GET de ID
	 //Se a tela esta sendo aberta para edição
	 if(isset($_GET['id'])){

		//Obtém o parametro ID que foi enviado via GET
		$id = $_GET['id'];

		//Monta o comando SQL para buscar as informações cadastradas
		$sql = "SELECT * FROM produtos WHERE id = $id";

		//Envio da consulta ao MySQL
		$res = mysqli_query($conn, $sql);
		//Armazena o registro encontrado
		$row = mysqli_fetch_assoc($res);

		//Guarda os valores nas variáveis
		$nome = $row['nome'];
		$codBarras = $row['codBarras'];
        $quantidade = $row['quantidade'];
        $undMedida = $row['undMedida'];
        $idFornecedor = $row['idFornecedor'];
		
	 }

?>
<!DOCTYPE html>
<html>
	<head>
		<title>Materiais de Construção - Área restrita - Cadastro de Produtos</title>
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
                <li><a href="cadprodutos.php"class="activecad">Criar Produtos</a></li>
			</ul>
		  </nav>
		  
		  <article>
		  <?php

			//Se não autenticou - enviado parametro de erro
			if(isset($_GET['erro'])) {
				echo '<p style="text-align:center;color: rgb(190, 19, 19)">Erro ao gravar registro. Código de Fornecedor não encontrado.</p>';
			}

			?>
		  
			<form action="recebeprodutos.php" method="post">
			
				<input type="hidden" name="id" value="<?php echo $id; ?>" />
			

				<label for="nome">Nome</label> 
				<input type="text" name="nome" value="<?php echo $nome; ?>" placeholder="Digite o nome" required>
				

                <label for="codBarras">Código de Barras</label>
				<input type="text" name="codBarras" value="<?php echo $codBarras; ?>" placeholder="Digite o código de barras" required>


                <label for="quantidade">Quantidade</label>
				<input type="text" name="quantidade"  value="<?php echo $quantidade; ?>" placeholder="Digite o número da quantidade" required>

                
                <label for="undMedida">Unidade de Medida</label>
				<select name="undMedida" style="color: gray;" onchange="changeColor(this)" required>
					<option value="" <?php if($undMedida==""){echo "selected";} ?> disabled>Selecione</option>
					<option value="Un" <?php if($undMedida=="Un"){echo "selected";} ?> style="color: black;">Unidade</option>
					<option value="Mt" <?php if($undMedida=="Mt"){echo "selected";} ?> style="color: black;">Metro Linear</option>
					<option value="M3" <?php if($undMedida=="M3"){echo "selected";} ?> style="color: black;">Metro Cúbico</option>
				</select>

				<script>
					function changeColor(select) {
						var selectedOption = select.options[select.selectedIndex];
						selectedOption.style.color = "black"; // Muda a cor do texto para preto
						select.style.color = "black"; // Muda a cor do texto do select para preto
					}
				</script>
       		
				 				
                <label for="idFornecedor">ID do Fornecedor</label>
				<input type="text" name="idFornecedor"  value="<?php echo $idFornecedor; ?>" placeholder="Digite número de ID" required>
				
				
				<input type="submit">
			
			</form>
			<a href="inicio.php">Voltar</a>
		  </article>
		</section>

		<footer>
			<p>© Todos direitos reservados.</p>
		    <p>Desenvolvido pelo grupo 46.</p>
		</footer>
		
		
	</body>
</html>