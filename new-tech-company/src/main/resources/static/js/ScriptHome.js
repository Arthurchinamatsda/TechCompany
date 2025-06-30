// Variável global para o corpo
const corpo = document.getElementById('corpo');

function cadastro(){
    const loginBtn = document.getElementById('login');
    const cadastroBtn = document.getElementById('cadastro');
    const divDoCadastro = document.getElementById('divDoCadastro');
    
    // Animação dos botões
    loginBtn.classList.add('button-hidden');
    cadastroBtn.classList.add('button-hidden');
    
    // Mostrar formulário com animação
    setTimeout(() => {
        divDoCadastro.style.display = 'block';
        setTimeout(() => {
            divDoCadastro.classList.add('form-visible');
        }, 10);
    }, 300);
    
    corpo.style.background = "linear-gradient(to left, #38CAFFE5, #4F42FF1A, #FF8C42)";
}

function login(){
    const divDoLogin = document.getElementById('divDoLogin');
    
    
    // Mostrar formulário com animação
    setTimeout(() => {
        divDoLogin.style.display = 'block';
        setTimeout(() => {
            divDoLogin.classList.add('form-visible');
        }, 10);
    }, 300);
    
    corpo.style.background = "linear-gradient(to left, #38CAFFE5, #4F42FF1A, #FF8C42)";
}

function fecharLogin(){
    const divDoLogin = document.getElementById('divDoLogin');
    
    // Esconder formulário com animação
    divDoLogin.classList.remove('form-visible');
    
    setTimeout(() => {
        divDoLogin.style.display = 'none';
    }, 500);
}

function fecharCadastro(){
    const loginBtn = document.getElementById('login');
    const cadastroBtn = document.getElementById('cadastro');
    const divDoCadastro = document.getElementById('divDoCadastro');
    
    // Esconder formulário com animação
    divDoCadastro.classList.remove('form-visible');
    
    setTimeout(() => {
        divDoCadastro.style.display = 'none';
        // Mostrar botões novamente
        loginBtn.classList.remove('button-hidden');
        cadastroBtn.classList.remove('button-hidden');
    }, 500);
    
    corpo.style.backgroundColor = "#ffff";
}

function proximoTelaCadastro(){
    const divSenha = document.getElementById('divDoCadastroSenha');
    const divDoCadastro = document.getElementById('divDoCadastro');
    
    // Animação entre formulários
    divDoCadastro.classList.remove('form-visible');
    
    setTimeout(() => {
        divDoCadastro.style.display = 'none';
        divSenha.style.display = 'block';
        setTimeout(() => {
            divSenha.classList.add('form-visible');
        }, 10);
    }, 500);
}

function fecharCadastroSenha(){
    const divSenha = document.getElementById('divDoCadastroSenha');
    const divDoCadastro = document.getElementById('divDoCadastro');
    
    // Animação entre formulários
    divSenha.classList.remove('form-visible');
    
    setTimeout(() => {
        divSenha.style.display = 'none';
        divDoCadastro.style.display = 'block';
        setTimeout(() => {
            divDoCadastro.classList.add('form-visible');
        }, 10);
    }, 500);
    
    corpo.style.backgroundColor = "#ffff";
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
function abrirCriarArquivo(){
    const criarProjetoBtn = document.getElementById('criarProjeto');
    const divDoCriarProjeto = document.getElementById('divCriarProjeto');

    
    // Mostrar formulário com animação
    setTimeout(() => {
        divDoCriarProjeto.style.display = 'block';
        setTimeout(() => {
            divDoCriarProjeto.classList.add('form-visible');
        }, 10);
    }, 300);
    
    corpo.style.background = "linear-gradient(to left, #38CAFFE5, #4F42FF1A, #FF8C42)";

}