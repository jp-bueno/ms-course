package br.com.jpbueno.hrworker.resources;

import br.com.jpbueno.hrworker.entities.Worker;
import br.com.jpbueno.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAllWorkers() {
        List<Worker> lsWorkers = workerRepository.findAll();
        return ResponseEntity.ok(lsWorkers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findByIdWorker(@PathVariable("id") @Valid Long id) {
        Worker worker = workerRepository.findById(id).orElse(new Worker());
        return ResponseEntity.ok(worker);
    }
}
