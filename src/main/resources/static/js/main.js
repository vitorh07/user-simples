function cadastrar(){
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var email = document.getElementById('email').value;

    if(username == '' || password == '' || email == ''){
        document.getElementById('response').innerHTML = 'Preencha todos os campos!';
        return;
    }

    fetch('http://localhost:8080/api/users/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            password: password,
            email: email
        })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        document.getElementById('response').innerHTML = 'Usuário cadastrado com sucesso!';
    })
    .catch((error) => {
        console.error('Error:', error);
        document.getElementById('response').innerHTML = 'Erro ao cadastrar usuário!';
    });
}

document.getElementById('btnC').addEventListener('click', cadastrar);

