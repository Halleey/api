// scripts.js

// Função para carregar e exibir produtos
function loadProducts() {
    fetch('/api/v1/produtos/allProducts')
        .then(response => response.json())
        .then(products => {
            // Construir o HTML para os produtos
            const productsHtml = products.map(product => `
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="/api/v1/produtos/img/${product.id}" alt="Product Image">
                    <div class="card-body">
                        <p class="card-text">${product.name}</p>
                        <p>${product.price}</p>
                    </div>
                </div>
            `).join('');

            // Atualizar o conteúdo da div com os produtos
            document.getElementById('productsContainer').innerHTML = productsHtml;
        })
        .catch(error => {
            console.error('Erro ao carregar produtos:', error.message);
        });
}

// Chamar a função para carregar produtos quando a página carregar
document.addEventListener('DOMContentLoaded', loadProducts);

// Função para filtrar produtos com base na barra de pesquisa
function filterProducts() {
    const searchInput = document.getElementById('searchInput').value.toLowerCase();

    fetch('/api/v1/produtos/allProducts')
        .then(response => response.json())
        .then(products => {
            // Filtrar produtos com base no nome
            const filteredProducts = products.filter(product => product.name.toLowerCase().includes(searchInput));

            // Construir o HTML para os produtos filtrados
            const productsHtml = filteredProducts.map(product => `
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="/api/v1/produtos/img/${product.id}" alt="Product Image">
                    <div class="card-body">
                        <p class="card-text">${product.name}</p>
                        <p>${product.price}</p>
                    </div>
                </div>
            `).join('');

            // Atualizar o conteúdo da div com os produtos filtrados
            document.getElementById('productsContainer').innerHTML = productsHtml;
        })
        .catch(error => {
            console.error('Erro ao carregar produtos:', error.message);
        });
}
