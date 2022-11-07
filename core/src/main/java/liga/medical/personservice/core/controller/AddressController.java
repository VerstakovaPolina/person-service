package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.model.Address;
import liga.medical.personservice.core.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/address")
@Api(value = "Api для работы оператора клиники")
public class AddressController {
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(path = "/get", produces = "application/json")
    @ApiOperation(value = "Получение адреса пациента")
    public List<Address> getAddress() {
        log.info("\nПолучение адреса пациента");
        return addressService.getAddress();
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    @ApiOperation(value = "Получение адреса пациента по id")
    public Address getAddress(@PathVariable("id") long id) {
        log.info("\nПолучение адреса пациента по id");
        return addressService.getAddressById(id);
    }

    @PostMapping(path = "/post")
    @ApiOperation(value = "Добавление адреса пациента")
    public void addAddress(@RequestBody Address address) {
        log.info("\nДобавление адреса пациента");
        addressService.addAddress(address);
    }
}