package vn.techmaster.topcar.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import vn.techmaster.topcar.model.Car;
import vn.techmaster.topcar.repository.CarDao;
import vn.techmaster.topcar.request.DeleteRequest;
import vn.techmaster.topcar.request.SearchRequest;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/car")
public class CarController {

  @Autowired
  private CarDao carDao;

  @GetMapping
  public String listAll(Model model) {
    model.addAttribute("cars", carDao.getALL());
    return "allCars";
  }

  @GetMapping(value = "/{id}")
  public String getCarById(@PathVariable("id") int id, Model model) {
    Optional<Car> car = carDao.get(id);
    if (car.isPresent()) {
      model.addAttribute("car", car.get());
    }
    return "car";
  }

  @GetMapping(value = "/add")
  public String add(Model model) {
    model.addAttribute("car", new Car());
    return "add";
  }

  @PostMapping(value = "/save")
  public String save(Car car, BindingResult result) {
    if (result.hasErrors()) {
      return "add";
    }
    if (car.getId() > 0) {
      carDao.update(car);
      // return "add";
    } else {
      carDao.add(car);
    }
    return "redirect:/car";
  }

  @GetMapping("/edit/{id}")
  public String editCar(@PathVariable("id") int id, Model model) {
    Optional<Car> car = carDao.get(id);
    if (car.isPresent()) {
      model.addAttribute("car", car.get());
    }
    return "add";
  }

  @PostMapping("/delete")
  public String deleteCarByID(@ModelAttribute DeleteRequest request, BindingResult result) {
    if (result.hasErrors() == false) {
      carDao.deleteByID(request.getId());
    }
    return "redirect:/car";
  }

  @GetMapping("/search")
  public String searchForm(Model model) {
    model.addAttribute("searchRequest", new SearchRequest());
    return "search";
  }

  @PostMapping("/search")
  public String searchByKeyword(@ModelAttribute SearchRequest request, BindingResult result, Model model) {
    if (result.hasFieldErrors() == false) {
      model.addAttribute("cars", carDao.searchByKeyword(request.getKeyword()));
    }
    return "allCars";

  }
}
