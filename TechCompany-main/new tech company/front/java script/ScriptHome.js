let divDoCadastro = document.getElementById('divDoCadastro');
let divDoLogin = document.getElementById('divDoLogin');
let cadastro1 = document.getElementById('cadastro');
let login1 = document.getElementById('login');
let corpo = document.getElementById('corpo');
let divSenha = document.getElementById('divDoCadastroSenha');

function cadastro(){
    divDoCadastro.style.display = 'block';
    cadastro1.style.display = 'none';
    login1.style.display = 'none';
}
function login(){
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
    divDoLogin.style.display = 'none'; 
    login1.style.display = 'block';
    cadastro1.style.display = 'block';
}

function fecharCadastro(){
    divDoCadastro.style.display = 'none';
    cadastro1.style.display = 'block';
    login1.style.display = 'block';
}
function proximoTelaCadastro(){
    divSenha.style.display = 'block';
    divDoCadastro.style.display = 'none';
}
function fecharCadastroSenha(){
    divDoCadastro.style.display = 'block';
    divSenha.style.display = 'none';
}

function confirmandoSenha(){
    let senha = document.getElementById('criarSenhaCadastro').value;
    let confirmSenha = document.getElementById('confirmarSenhaCadastro').value;
    if(senha == confirmSenha && senha !== "" && confirmSenha !== ""){
        window.location.href="../html/IndexHomeHome.html";  
    }
    else{
        alert("error")
    }
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

