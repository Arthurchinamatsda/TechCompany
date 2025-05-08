let divDoCadastro = document.getElementById('divDoCadastro');
let divDoLogin = document.getElementById('divDoLogin');
let cadastro1 = document.getElementById('cadastro');
let login1 = document.getElementById('login');
let corpo = document.getElementById('corpo');
function cadastro(){
    divDoCadastro.style.display = 'block';
    cadastro1.style.display = 'none';
    login1.style.display = 'none';
    corpo.style.background = '#000';
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
    corpo.style.background = "#fff";
}

function fecharCadastro(){
    divDoCadastro.style.display = 'none';
    cadastro1.style.display = 'block';
    login1.style.display = 'block';
}
function proximoTelaCadastro(){
    document.getElementById('proximoTelaCadastro')
}