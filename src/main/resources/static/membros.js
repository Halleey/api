
    document.addEventListener('DOMContentLoaded', function () {
        const url = 'http://localhost:8080/api/v1/usuarios/all';

        fetch(url)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Erro na requisição: ${response.status}`);
                }
                return response.json();
            })
            .then(users => {
                console.log(users);

                // Exibir usuários na tabela
                displayUsers(users);
            })
            .catch(error => {
                console.error('Erro:', error);
            });
    });

    function displayUsers(users) {
        const userList = document.getElementById('user-list');

        users.forEach(user => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.endereco}</td>

            `;
            row.classList.add('shine-effect'); // Adiciona classe de efeito de brilho
            userList.appendChild(row);
        });
    }