package ojek.jpa_project.controller;

import ojek.jpa_project.model.Driver;
import ojek.jpa_project.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ojek")
public class DriverController {
    @Autowired
    DriverService driverService;

    @GetMapping("/driver")
    List<Driver> getAll(){
        return driverService.getAll();
    }

    @GetMapping("/driver/{id}")
    Driver getById(@PathVariable String id){
        return driverService.getById(id);
    }

    @PostMapping("/driver")
    Driver create(@Valid @RequestBody Driver driver){
        return driverService.create(driver);
    }

    @PutMapping("/driver/{id}")
    Driver update(@PathVariable String id, @Valid @RequestBody Driver driver){
        return driverService.update(id, driver);
    }

    @DeleteMapping("driver/{id}")
    boolean detele(@PathVariable String id){
        return driverService.delete(id);
    }
}
