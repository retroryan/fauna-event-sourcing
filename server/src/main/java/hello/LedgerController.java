package hello;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LedgerController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private LedgerService ledgerService;

    @Autowired
    public LedgerController(LedgerService ledgerService) {
        this.ledgerService = ledgerService;
    }



    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("name = " + name);
        return new Greeting(counter.incrementAndGet(),
            String.format(template, name));
    }

    @RequestMapping("/all")
    public Collection<LedgerEntry> all(@RequestParam(value = "clientid", defaultValue = "0") int clientId) throws Exception {
        System.out.println("LedgerController.all");

        Collection<LedgerEntry> allEntries = ledgerService.all(clientId);
        System.out.println("read allEntries = " + allEntries);
        String format = String.format(template, allEntries);
        return allEntries;
    }

    @PostMapping("/add")
    ResponseEntity<String> add(@RequestBody LedgerEntry entry) throws Exception {
        System.out.println("entry = " + entry);

        ledgerService.addEntry(entry);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}