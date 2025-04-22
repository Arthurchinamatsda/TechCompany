// Função para alternar visibilidade do formulário de postagem
function togglePostForm() {
    const form = document.getElementById('postForm');
    form.style.display = form.style.display === 'block' ? 'none' : 'block';
  }
  
  // Função para criar o post
  function createPost() {
    const imageInput = document.getElementById('imageInput');
    const postText = document.getElementById('postText');
    
    const imageFile = imageInput.files[0];
    if (!imageFile || !postText.value.trim()) return alert('Por favor, adicione uma imagem e uma legenda.');
  
    const post = document.createElement('div');
    post.className = 'post';
  
    // Lê a imagem e converte para uma URL de visualização
    const reader = new FileReader();
    reader.onload = function(e) {
      const postImage = document.createElement('img');
      postImage.src = e.target.result;
  
      post.innerHTML = `
        <div class="content">
          <p>${postText.value}</p>
          <div class="actions">
            <button onclick="curtir(this)">Curtir</button>
            <button onclick="comentar(this)">Comentar</button>
          </div>
          <div class="comments">
            <input type="text" placeholder="Adicionar um comentário...">
          </div>
        </div>
      `;
      post.insertBefore(postImage, post.firstChild);
      document.getElementById('feed').prepend(post);
      
      // Limpa os campos
      imageInput.value = '';
      postText.value = '';
      togglePostForm();
    };
    
    reader.readAsDataURL(imageFile);
  }
  
  // Função para curtir o post
  function curtir(button) {
    const post = button.closest('.post');
    const likeButton = post.querySelector('.actions button:first-child');
    
    if (likeButton.innerText === 'Curtir') {
      likeButton.innerText = 'Descurtir';
    } else {
      likeButton.innerText = 'Curtir';
    }
  }
  
  // Função para comentar no post
  function comentar(button) {
    const commentBox = button.closest('.post').querySelector('.comments input');
    const commentText = commentBox.value.trim();
    
    if (commentText) {
      const comment = document.createElement('p');
      comment.innerText = commentText;
      button.closest('.post').querySelector('.comments').appendChild(comment);
      commentBox.value = ''; // Limpa o campo
    }
  }