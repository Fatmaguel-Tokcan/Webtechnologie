package de.htw.berlin.Webtechnologie.persistence;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoListRepository extends JpaRepository<TodoListEntity, Long> {

   List<TodoListEntity> findAllById(Long id);

}

