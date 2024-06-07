package com.thehouse.repository;

import com.thehouse.model.entities.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Long> {

    /*
    * Naming Convention (Convenção de Nomenclatura):
    * O Spring Data JPA permite que você defina métodos de consulta personalizados apenas pela nomeação dos métodos seguindo certas convenções.
    * Isso significa que você pode criar métodos personalizados baseando-se em nomes que seguem uma sintaxe específica, e
    * o Spring Data JPA irá automaticamente gerar a implementação desses métodos.
    */

    /*
    * findAll: Indica que o método retornará todos os registros.
    * ByOrderBy: Especifica que a consulta deve ordenar os resultados.
    * Id: O campo pelo qual a ordenação será feita.
    * Asc: Indica que a ordenação será em ordem crescente (ascending).
    */
    List<Meta> findAllByOrderByIdAsc();
}