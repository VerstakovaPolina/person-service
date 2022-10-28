package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.Contact;
import liga.medical.personservice.core.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(path = "/contact", produces = "application/json")
    public List<Contact> getContact() {
        return contactService.getContact();
    }

    @GetMapping(path = "/contact/{id}", produces = "application/json")
    public Contact getContact(@PathVariable("id") long id) {
        return contactService.getContactById(id);
    }

    @PostMapping
    public void addContact(@RequestBody Contact contact) {
        contactService.addContact(contact);
    }
}