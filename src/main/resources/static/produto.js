document.getElementById("CreateProduto").addEventListener("submit", function(event) {
    event.preventDefault();

    const name = document.getElementById("name").value;
    const price = parseFloat(document.getElementById("preco").value);
    const imagem = document.getElementById("imagem").files[0];

    // Verifica se o preço é um número válido
    if (isNaN(price)) {
        alert("Por favor, insira um valor numérico para o preço.");
        return;
    }

    const formData = new FormData();
    formData.append("name", name);
    formData.append("price", price);
    formData.append("imagem", imagem);

    fetch("api/v1/produtos", {
        method: "POST",
        body: formData  // Use FormData para enviar dados multipart/form-data
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Erro ao enviar a requisição");
            }
            return response.json();
        })
        .then(data => {
            // Manipule a resposta da API conforme necessário
            console.log("Produto salvo com sucesso:", data);
            
            // Exiba a mensagem de sucesso no HTML
            const mensagemElement = document.getElementById("mensagem");
            mensagemElement.innerHTML = "Produto salvo com sucesso!";
            mensagemElement.style.color = "green"; //
            document.getElementById("CreateProduto").reset();
        })
        .catch(error => {
            // Caso de erros da requisição
            console.error("Erro na requisição:", error.message);
            
            // Exiba a mensagem de erro no HTML
            const mensagemElement = document.getElementById("mensagem");
            mensagemElement.innerHTML = "Erro ao salvar o produto.";
            mensagemElement.style.color = "red";
        });
});
