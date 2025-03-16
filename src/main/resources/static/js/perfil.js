

function carregarPerfil(){
    const user = JSON.parse(localStorage.getItem('user'));
    const userId = JSON.parse(localStorage.getItem("user")).id;

    console.log(user);
    console.log(userId);
    fetch(`http://localhost:8080/api/users/id/${userId}`)
    .then(response => response.json())
    .then(data => {
        document.getElementById('username').innerText = user.username;
        document.getElementById('email').innerText = user.email;
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

carregarPerfil();