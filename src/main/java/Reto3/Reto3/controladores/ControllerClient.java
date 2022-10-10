package Reto3.Reto3.controladores;

import Reto3.Reto3.entidades.Client;
import Reto3.Reto3.servicios.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class ControllerClient {
    @Autowired
    private ServiceClient sc;

    @GetMapping("/all")
    public List<Client> getClientAll(){
        return sc.allClient();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client insertClient(@RequestBody Client cli) {
        return sc.saveClient(cli);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateClient(@RequestBody Client cli){
        return sc.updateClient(cli);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@RequestBody Client cli){
        sc.deleteClient(cli);
    }

    @GetMapping("/{doc}")
    public Client findClientById(@PathVariable("doc")int doc){
        return sc.findClientById(doc);
    }

    @DeleteMapping("/{doc}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientById(@PathVariable("doc") int doc){
        sc.deleteClientById(doc);
    }
}
