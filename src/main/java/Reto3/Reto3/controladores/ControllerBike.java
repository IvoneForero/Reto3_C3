package Reto3.Reto3.controladores;

import Reto3.Reto3.entidades.Bike;
import Reto3.Reto3.servicios.ServiceBike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Bike")
public class ControllerBike {
    @Autowired
    private ServiceBike sb;

    @GetMapping("/all")
    public List<Bike> getBikeAll(){
        return sb.allBike();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike insertBike(@RequestBody Bike bik) {
        return sb.saveBike(bik);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Bike updateBike(@RequestBody Bike bik){
        return sb.updateBike(bik);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBike(@RequestBody Bike bik){
        sb.deleteBike(bik);
    }

    @GetMapping("/{doc}")
    public Bike findBikeById(@PathVariable("doc")int doc){
        return sb.findBikeById(doc);
    }

    @DeleteMapping("/{doc}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBikeById(@PathVariable("doc") int doc){
        sb.deleteBikeById(doc);
    }
}
