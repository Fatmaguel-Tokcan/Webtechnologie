package de.htw.berlin.Webtechnologie;


import de.htw.berlin.Webtechnologie.api.TodoList;
import de.htw.berlin.Webtechnologie.api.TodoListManipulationRequest;
import de.htw.berlin.Webtechnologie.service.TodoListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class TodoListRestController {

private final TodoListService TodoListService;

    public TodoListRestController(TodoListService TodoListService) {
        this.TodoListService = TodoListService;
    }


    @GetMapping(path = "/api/v1/TodoLists")
   public ResponseEntity<List<TodoList>> fetchTodoLists(){
        return ResponseEntity.ok(TodoListService.findAll());
    }

   @GetMapping(path = "/api/v1/TodoLists/{id}")
   public ResponseEntity<TodoList> fetchTodoListsById(@PathVariable Long id){
    var TodoList = TodoListService.findById(id);
    return TodoList != null? ResponseEntity.ok(TodoList) : ResponseEntity.notFound().build();
   }

    @PostMapping(path = "/api/v1/TodoLists")
    public ResponseEntity<Void> createTodoList(@RequestBody TodoListManipulationRequest request) throws URISyntaxException {
        var TodoList= TodoListService.create(request);
        URI uri = new URI("/api/v1/TodoLists/" + TodoList.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/TodoLists/{id}")
    public ResponseEntity<TodoList> updateTodoLists(@PathVariable Long id, @RequestBody TodoListManipulationRequest request){
      var TodoList = TodoListService.update(id, request);
      return TodoList != null? ResponseEntity.ok(TodoList) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/TodoLists/{id}")
    public ResponseEntity<Void> deleteTodoLists(@PathVariable Long id){
        boolean successful = TodoListService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
