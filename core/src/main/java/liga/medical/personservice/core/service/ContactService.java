package liga.medical.personservice.core.service;

import liga.medical.personservice.core.mapper.ContactMapper;
import liga.medical.personservice.core.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final ContactMapper contactMapper;

    public ContactService(ContactMapper contactMapper) {
        this.contactMapper = contactMapper;
    }

    public List<Contact> getContact() {
        return contactMapper.listContact();
    }

    public Contact getContactById(long id) {
        return contactMapper.getContactById(id);
    }

    public void addContact(Contact contact) {
        contactMapper.addContactInDB(contact);
    }
}