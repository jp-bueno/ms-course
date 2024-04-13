package br.com.jpbueno.hrworker.resources;

import br.com.jpbueno.hrworker.entities.Worker;
import br.com.jpbueno.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAllWorkers() {
        List<Worker> lsWorkers = workerRepository.findAll();
        return ResponseEntity.ok(lsWorkers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findByIdWorker(@PathVariable("id") @Valid Long id) {

        // Imprime a porta que está rodando
        logger.info("PORT = " +env.getProperty("local.server.port"));

        Worker worker = workerRepository.findById(id).orElse(new Worker());
        return ResponseEntity.ok(worker);
    }
}
