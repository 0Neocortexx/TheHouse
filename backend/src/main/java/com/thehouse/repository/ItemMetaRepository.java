package com.thehouse.repository;

import com.thehouse.model.entities.ItemMeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemMetaRepository extends JpaRepository<ItemMeta, Long> {

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
    List<ItemMeta> findAllByOrderByIdAsc();
}