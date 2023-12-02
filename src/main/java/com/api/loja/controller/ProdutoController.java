package com.api.loja.controller;

import com.api.loja.dto.ProdutoDto;
import com.api.loja.entity.Produtos;
import com.api.loja.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Produtos> setProduto(@RequestParam("imagem") MultipartFile imagem, @RequestParam("name") String name, @RequestParam("price") BigDecimal price) {
        try {
            // Crie uma instância de Produtos com os parâmetros recebidos
            Produtos produtos = new Produtos();
            produtos.setName(name);
            produtos.setPrice(price);

            // Chame o serviço para salvar o produto com imagem
            Produtos prod = produtoService.salvarComImagem(produtos, imagem);

            // Retorne uma resposta de sucesso com o produto salvo
            return ResponseEntity.status(HttpStatus.CREATED).body(prod);
        } catch (RuntimeException e) {
            // Em caso de erro, retorne uma resposta de erro interno do servidor
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            // Poderia ser tratado de uma forma mais específica dependendo do caso, como retornar uma mensagem de erro personalizada.
        }
    }


    @GetMapping("/allProducts")
    public ResponseEntity <List<ProdutoDto>> getAllProducts() {
        List<ProdutoDto> produtos = produtoService.buscarProdutos().stream().map(ProdutoDto::FromEntity).toList();
        return ResponseEntity.ok().body(produtos);
    }
    @GetMapping("/img/{id}")
    //chama a foto armazenada na lista byte pelo id no banco
    public  ResponseEntity<byte[]> getImgId(@PathVariable Long id) {

    Produtos produtos = produtoService.getProdutoId(id);
    byte[] imagem = produtos.getImagem();

        //Classe para configurar os cabeçalho http
        HttpHeaders headers = new HttpHeaders();
        //Define o cabeçalho da resposta, no caso img_jpg
        headers.setContentType(MediaType.IMAGE_JPEG);
        //retorna os bytes da imagem, o cabeçalho e um status ok para sucesso
        return new ResponseEntity<>(imagem, headers, HttpStatus.OK);
    }
}
