package com.api.loja.repository;

import com.api.loja.entity.CarroCompras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<CarroCompras, Long> {
}
