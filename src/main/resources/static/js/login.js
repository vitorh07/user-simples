function login() {
    var identifier = document.getElementById('identifier').value;
    var password = document.getElementById('password').value;

    if (identifier === '' || password === '') {
        document.getElementById('response').innerHTML = 'Preencha todos os campos!';
        return;
    }

    fetch('http://localhost:8080/api/users/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            identifier: identifier,
            password: password
        })
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        } else {
            throw new Error('Login falhou!');
        }
    })
    .then(data => {
        console.log('Success:', data);
        localStorage.setItem('token', data.token); // Armazena apenas o token
        window.location.href = 'perfil.html'; // Redireciona para a página de perfil
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('response').innerHTML = 'Erro ao realizar login!';
    });
}

document.getElementById('btnL').addEventListener('click', login);