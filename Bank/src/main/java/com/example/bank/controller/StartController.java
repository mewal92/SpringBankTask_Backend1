package com.example.bank.controller;



import com.example.bank.models.Category;
import com.example.bank.models.Customer;
import com.example.bank.models.KPI;
import com.example.bank.repositories.CategoryRepository;
import com.example.bank.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
public class StartController {
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    @RequestMapping("start")
    public String formGreeting(){
        return "start.html";
    }

    @PostMapping("/welcome")
    public String greeting(@RequestParam String fname,
                           @RequestParam String lname, Model model) {
        model.addAttribute("fname", fname);
        model.addAttribute("lname", lname);
        return "welcome.html";
    }

    @RequestMapping("/allcategories")
    public String allCategories(Model model) {
        Iterable<Category> cat = categoryRepository.findAll();
        model.addAttribute("allCategories", cat);
        model.addAttribute("name", "Kategorinamn");
        model.addAttribute("categoryTitle", "Alla kategorier");

        return "seeCategories.html";
    }

    @RequestMapping("/addCustomer")
    public String formCustomer(){
        return "hellocustomer.html";
    }


    @PostMapping("/hellocustomer")
    public String addCustomer(@RequestParam String name,
                           @RequestParam String ssn, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("ssn", ssn);
        customerRepository.save(new Customer(name, ssn, new KPI(1)));
        return "addCustomer.html";
    }

    @RequestMapping("/addCategory")
    public String addCategory(Model model){
        return "addCategories.html";
    }

    @PostMapping("/addCategoryAndShow")
    public String addAndShowCategories(@RequestParam String category,
                                       Model model){
        categoryRepository.save(new Category(category));
        return allCategories(model);
    }
}
