package ru.rutmiit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.models.entities.Return;
import ru.rutmiit.services.ReturnService;

import java.util.List;

@RestController
@RequestMapping("/returns")
public class ReturnController {
    private final ReturnService returnService;

    @Autowired
    public ReturnController(ReturnService returnService) {
        this.returnService = returnService;
    }

    @GetMapping
    public List<Return> getAllReturns() {
        return returnService.findAll();
    }

    @PostMapping
    public Return saveReturn(@RequestBody Return aReturn) {
        return returnService.save(aReturn);
    }

    @GetMapping("/{id}")
    public Return getReturnById(@PathVariable Integer id) {
        return returnService.findById(id);
    }
}