function login(){
    var identifier = document.getElementById('identifier').value;
    var password = document.getElementById('password').value;

    if(identifier == '' || password == ''){
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
    .then(response => response.json())
    .then(data => {
        if (data) {
            console.log('Success:', data);
            window.location.href = 'perfil.html';
            localStorage.setItem('user', JSON.stringify(data));
        } else {
            document.getElementById('response').innerHTML = 'Login falhou!';
        }
    })
    .catch((error) => {
        console.error('Error:', error);
        document.getElementById('response').innerHTML = 'Erro ao realizar login!';
    });
}

document.getElementById('btnL').addEventListener('click', login);
