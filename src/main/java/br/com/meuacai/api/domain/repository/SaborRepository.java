package br.com.meuacai.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meuacai.api.domain.model.Sabor;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long>{

}
