<?php

    //(Re)iniciar a sessao
    session_start();

    //Se NÃO foi criada uma sessao autenticada
    //Se NÃO existe o valor id guardado na sessao
    if(!isset($_SESSION['id'])) {

        header("Location: index.php?autentica=1");

    }


?>