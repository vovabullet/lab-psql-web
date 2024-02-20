package ru.rutmiit.web;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rutmiit.services.ReturnService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class ReturnController {
    private final ReturnService returnService;

    public ReturnController(ReturnService returnService) {
        this.returnService = returnService;
    }

    @GetMapping("/findSuppliersWithReturnsInPeriod")
    public String showSuppliersWithReturnsInPeriod(@RequestParam("RStartDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                   @RequestParam("REndDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
                                                   Model model) {
        List<String> suppliers = returnService.findSuppliersWithReturnsInPeriod(startDate, endDate);
        model.addAttribute("suppliers", suppliers);
        return "find-Suppliers-With-ReturnsIn-Period";
    }
}