package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.model.Contact;
import liga.medical.personservice.core.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/contact")
@Api(value = "Api для работы оператора клиники")
public class ContactController {
    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(path = "/get", produces = "application/json")
    @ApiOperation(value = "Получение контактов пациентов")
    public List<Contact> getContact() {
        return contactService.getContact();
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    @ApiOperation(value = "Получение контакта пациента по id")
    public Contact getContact(@PathVariable("id") long id) {
        return contactService.getContactById(id);
    }

    @PostMapping(path = "/post")
    @ApiOperation(value = "Добавление контакта пациента")
    public void addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);
    }
}