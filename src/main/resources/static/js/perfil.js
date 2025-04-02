function carregarPerfil() {
    const token = localStorage.getItem('token'); // Recupera o token do localStorage

    if (!token) {
        console.error('Token não encontrado. Redirecionando para a página de login.');
        window.location.href = 'login.html';
        return;
    }

    fetch('http://localhost:8080/api/users/me', {
        method: 'GET',
        headers: {
            'Authorization': `Bearer ${token}` // Envia o token no cabeçalho
        }
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Falha ao carregar perfil!');
        }
    })
    .then(user => {
        document.getElementById('username').innerText = user.username;
        document.getElementById('email').innerText = user.email;
    })
    .catch(error => {
        console.error('Error:', error);
        localStorage.removeItem('token'); // Remove o token inválido
        window.location.href = 'login.html'; // Redireciona para a página de login
    });
}

carregarPerfil();