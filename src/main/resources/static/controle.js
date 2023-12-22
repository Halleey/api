
        function loadProducts() {
            fetch('/api/v1/produtos/allProducts')
                .then(response => response.json())
                .then(products => {
                    // Construir o HTML para os produtos
                    const productsContainer = document.getElementById('productsContainer');
                    productsContainer.innerHTML = ''; // Limpa o conteúdo existente

                    products.forEach(product => {
                        const productCard = document.createElement('div');
                        productCard.className = 'productCard';
                        productCard.innerHTML = `
                            <img class="card-img-top" src="/api/v1/produtos/img/${product.id}" alt="Product Image">
                            <div class="card-body">
                                <p class="card-text">${product.name}</p>
                                <p>${product.price}</p>
                            </div>
                        `;
                        productsContainer.appendChild(productCard);
                    });
                })
                .catch(error => {
                    console.error('Erro ao carregar produtos:', error.message);
                });
        }

        document.addEventListener('DOMContentLoaded', loadProducts);

        // Filtro de produtos
        function filterProducts() {
            const searchInput = document.getElementById('searchInput').value.toLowerCase();

            fetch('/api/v1/produtos/allProducts')
                .then(response => response.json())
                .then(products => {
                    // Filtrar produtos com base no nome
                    const filteredProducts = products.filter(product => product.name.toLowerCase().includes(searchInput));

                    // Construir o HTML para os produtos filtrados
                    const productsContainer = document.getElementById('productsContainer');
                    productsContainer.innerHTML = ''; // Limpa o conteúdo existente

                    filteredProducts.forEach(product => {
                        const productCard = document.createElement('div');
                        productCard.className = 'productCard';
                        productCard.innerHTML = `
                            <img class="card-img-top" src="/api/v1/produtos/img/${product.id}" alt="Product Image">
                            <div class="card-body">
                                <p class="card-text">${product.name}</p>
                                <p>${product.price}</p>
                            </div>
                        `;
                        productsContainer.appendChild(productCard);
                    });
                })
                .catch(error => {
                    console.error('Erro ao carregar produtos:', error.message);
                });
        }