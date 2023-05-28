package Reto3Atenea.USA.com.Controller;

import Reto3Atenea.USA.com.Model.Gama;
import Reto3Atenea.USA.com.Service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api/Gama")
public class GamaController {
    @Autowired
    private GamaService gamaService;

    @GetMapping("/all")
    public List<Gama> getAll() {
        return gamaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Gama> getGama(@PathVariable int id){
        return gamaService.getGama(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gama save (@RequestBody Gama gama){
        return gamaService.save(gama);
    }
}
