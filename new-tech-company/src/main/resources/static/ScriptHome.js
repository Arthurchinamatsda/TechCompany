function cadastro(){
    let login1 = document.getElementById('login');
    let cadastro1 = document.getElementById('cadastro');
    let divDoCadastro = document.getElementById('divDoCadastro');
    divDoCadastro.style.display = 'block';
    cadastro1.style.display = 'none';
    login1.style.display = 'none';
}
function login(){
    let corpo = document.getElementById('corpo');
    let login1 = document.getElementById('login');
    let divDoLogin = document.getElementById('divDoLogin');
    let cadastro1 = document.getElementById('cadastro');
    divDoLogin.style.display = 'block';
    login1.style.display = 'none';
    cadastro1.style.display = 'none'
    corpo.style.backgroundColor = "#38CAFFE5";
    corpo.style.background = "linear-gradient(to left, #38CAFFE5, #4F42FF1A, #FF8C42)";
    corpo.style.backgroundRepeat = 'no-repeat';
    corpo.style.backgroundSize = 'cover';
    corpo.style.backgroundPosition = 'center';
}
function fecharLogin(){
    let corpo = document.getElementById('corpo');
    let login1 = document.getElementById('login');
    let divDoLogin = document.getElementById('divDoLogin');
    let cadastro1 = document.getElementById('cadastro');
    divDoLogin.style.display = 'none'; 
    login1.style.display = 'block';
    cadastro1.style.display = 'block';
}

function fecharCadastro(){
    let corpo = document.getElementById('corpo');
    let login1 = document.getElementById('login');
    let divDoCadastro = document.getElementById('divDoCadastro');
    let cadastro1 = document.getElementById('cadastro');
    divDoCadastro.style.display = 'none';
    cadastro1.style.display = 'block';
    login1.style.display = 'block';
}
function proximoTelaCadastro(){
    let divSenha = document.getElementById('divDoCadastroSenha');
    let divDoCadastro = document.getElementById('divDoCadastro');
    divSenha.style.display = 'block';
    divDoCadastro.style.display = 'none';
}
function fecharCadastroSenha(){
    let divSenha = document.getElementById('divDoCadastroSenha');
    let corpo = document.getElementById('corpo');
    let divDoCadastro = document.getElementById('divDoCadastro');
    divDoCadastro.style.display = 'block';
    divSenha.style.display = 'none';
}

    let senha = document.getElementById('criarSenhaCadastro').value;
    let confirmSenha = document.getElementById('confirmarSenhaCadastro').value;
    if(senha == confirmSenha && senha !== "" && confirmSenha !== ""){
        senhaConfirmada = confirmSenha = senha;
    }
    else{
        alert("error")
    }
function confirmandoEmailESenha(){
    let nome = document.getElementById('nomeCadastro').value;
    let email = document.getElementById('emailCadastro').value;
    if(nome !== "" && email !== ""){
        proximoTelaCadastro();
    }
    else{
        alert("nao estao preenchidos")
    }
}

