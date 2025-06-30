const apiUrl = 'http://localhost:8080/api/usuarios';
document.getElementById('formulario').addEventListener('submit', async (e) => {
    e.preventDefault();

    const nome = document.getElementById('nomeCadastro').value;
    const email = document.getElementById('emailCadastro').value;
    const senha = document.getElementById('criarSenhaCadastro').value;
    const confirmarSenha = document.getElementById('confirmarSenhaCadastro').value;

    if (senha !== confirmarSenha) {
        alert("As senhas não coincidem!");
        return;
    }

    await fetch(apiUrl, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ nome, email, senha })
    });

    document.getElementById('formulario').reset();
    carregarUsuarios();
});


const apiArquivo = 'http://localhost:8080/api/arquivo';
