package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.model.Address;
import liga.medical.personservice.core.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
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
        return addressService.getAddress();
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    @ApiOperation(value = "Получение адреса пациента по id")
    public Address getAddress(@PathVariable("id") long id) {
        return addressService.getAddressById(id);
    }

    @PostMapping(path = "/post")
    @ApiOperation(value = "Добавление адреса пациента")
    public void addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }
}