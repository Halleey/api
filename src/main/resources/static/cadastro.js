     document.getElementById("createUserForm").addEventListener("submit", function(event) {
        event.preventDefault();

        const name = document.getElementById("name").value;
        const password = document.getElementById("password").value;
        const email = document.getElementById("email").value;
        const endereco = document.getElementById("endereco").value;


        const userData = {
            name: name,
            password: password,
            email: email,
            endereco: endereco,
        };

        fetch("/api/v1/usuarios", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(userData)
        })
            .then(response => response.json())
            .then(data => {
                document.getElementById("message").textContent = "Usuário criado com sucesso. ID: " + data.id;
            })
            .catch(error => {
                document.getElementById("message").textContent = "Erro ao criar o usuário: " + error.message;
            });
    });