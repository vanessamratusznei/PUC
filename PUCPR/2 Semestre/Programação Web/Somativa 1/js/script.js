// Função para validar os dados do formulário
function validateForm() {
    
    // Obtendo os elementos do formulário
    var name = document.getElementById("name");
    var email = document.getElementById("email");
    var phone = document.getElementById("phone");
    var pet = document.getElementById("pet");
    var date = document.getElementById("date");
    var time = document.getElementById("time");
    
    // Criando uma variável para armazenar as mensagens de erro
    var errors = "";
    
    // Verificando se os campos estão vazios ou inválidos
    if (name.value == "") {
    errors += "O campo nome é obrigatório.\n";
    }
    if (email.value == "" || !email.value.includes("@")) {
    errors += "O campo email é obrigatório e deve ser válido.\n";
    }
    if (phone.value == "" || isNaN(phone.value)) {
    errors += "O campo telefone é obrigatório e deve conter apenas números.\n";
    }
    if (pet.value == "") {
    errors += "O campo pet é obrigatório.\n";
    }
    if (date.value == "") {
    errors += "O campo data é obrigatório.\n";
    }
    if (time.value == "") {
    errors += "O campo horário é obrigatório.\n";
    }
    
    // Se houver erros, exibe um alerta com as mensagens e impede o envio do formulário
    if (errors != "") {
    alert(errors);
    return false;
    } else {
    
    // Se não houver erros, envia os dados via método GET para a página de confirmação
    window.location.href = "formAction.html?name=" + name.value + "&email=" + email.value + "&phone=" + phone.value + "&pet=" + pet.value + "&date=" + date.value + "&time=" + time.value;
    
    return false; // Impede o recarregamento da página atual
    }
    }
    
    // Função para recuperar os dados enviados via método GET
    function getFormData() {
    
    // Obtendo a URL da página atual
    var url = window.location.href;
    
    // Separando a parte que contém os dados enviados
    var data = url.split("?")[1];
    
    // Separando cada parâmetro e seu valor
    var params = data.split("&");
    
    // Criando um objeto para armazenar os dados
    var formData = {};
    
    // Percorrendo cada parâmetro e atribuindo ao objeto
    for (var i = 0; i < params.length; i++) {
    var pair = params[i].split("=");
    formData[pair[0]] = pair[1];
    }
    
    // Obtendo o elemento que vai exibir os dados
    var dataList = document.getElementById("data");
    
    // Criando uma lista com os dados
    var list = "<li>Nome: " + formData.name + "</li>";
    list += "<li>Email: " + formData.email + "</li>";
    list += "<li>Telefone: " + formData.phone + "</li>";
    list += "<li>Pet: " + formData.pet + "</li>";
    list += "<li>Data: " + formData.date + "</li>";
    list += "<li>Horário: " + formData.time + "</li>";
    
    // Inserindo a lista no elemento
    dataList.innerHTML = list;
    }    