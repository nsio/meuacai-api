package br.com.meuacai.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.meuacai.api.domain.model.Personalizacao;

@Repository
public interface PersonalizacaoRepository extends JpaRepository<Personalizacao, Long>{

}
