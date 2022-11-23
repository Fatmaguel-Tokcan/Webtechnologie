package de.htw.berlin.Webtechnologie.service;


import de.htw.berlin.Webtechnologie.api.TodoList;
import de.htw.berlin.Webtechnologie.api.TodoListManipulationRequest;
import de.htw.berlin.Webtechnologie.persistence.TodoListEntity;
import de.htw.berlin.Webtechnologie.persistence.TodoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoListService {

    private final TodoListRepository TodoListRepository;

    public TodoListService(TodoListRepository TodoListRepository) {
        this.TodoListRepository = TodoListRepository;
    }

    public List<TodoList> findAll() {
        List<TodoListEntity> TodoLists = TodoListRepository.findAll();
        return TodoLists.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public TodoList findById(Long id){
        var TodoListEntity = TodoListRepository.findById(id);
        return TodoListEntity.map(this::transformEntity).orElse(null);

    }

    public TodoList create(TodoListManipulationRequest request) {
        var TodoListEntity = new TodoListEntity(request.getAufgabe(), request.getArchiv(), request.getAbgabedatum(),
                request.getNochZuErledigenTasks(),request.isErledigt(),
                request.isRückgängig(),request.isSpeichern(),request.isLöschen());
        TodoListEntity = TodoListRepository.save(TodoListEntity);
        return transformEntity(TodoListEntity);
    }

    public TodoList update(Long id, TodoListManipulationRequest request){
        var TodoListEntityOptional = TodoListRepository.findById(id);
        if (TodoListEntityOptional.isEmpty()){
            return null;
        }

        var TodoListEntity = TodoListEntityOptional.get();
        TodoListEntity.setAufgabe(request.getAufgabe());
        TodoListEntity.setArchiv(request.getArchiv());
        TodoListEntity.setAbgabeDatum(request.getAbgabedatum());
        TodoListEntity.setNochZuErledigenTask(request.getNochZuErledigenTasks());
        TodoListEntity.setErledigt(request.isErledigt());
        TodoListEntity.setRückgängig(request.isRückgängig());
        TodoListEntity.setSpeichern(request.isSpeichern());
        TodoListEntity.setLöschen(request.isLöschen());
        TodoListEntity = TodoListRepository.save(TodoListEntity);

        return transformEntity(TodoListEntity);
    }

    public boolean deleteById(Long id){
        if (!TodoListRepository.existsById(id)){
            return false;
        }
        TodoListRepository.deleteById(id);
        return true;
    }

    private TodoList transformEntity(TodoListEntity TodoListEntity) {
        return new TodoList(
                TodoListEntity.getId(),
                TodoListEntity.getAufgabe(),
                TodoListEntity.getArchiv(),
                TodoListEntity.getAbgabeDatum(),
                TodoListEntity.getNochZuErledegenTask(),
                TodoListEntity.isErledigt(),
                TodoListEntity.isRückgängig(),
                TodoListEntity.isSpeichern(),
                TodoListEntity.isLöschen()


        );
    }
}
