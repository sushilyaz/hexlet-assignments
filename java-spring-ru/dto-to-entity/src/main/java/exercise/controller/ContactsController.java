package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import exercise.model.Contact;
import exercise.repository.ContactRepository;
import exercise.dto.ContactDTO;
import exercise.dto.ContactCreateDTO;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(ContactCreateDTO contactCreateDto) {
        var contact = toEntity(contactCreateDto);
        contactRepository.save(contact);
        var contactDto = toDto(contact);
        return contactDto;
    }

    private Contact toEntity (ContactCreateDTO contactCreateDTO) {
        var contact = new Contact();
        contact.setFirstName(contactCreateDTO.getFirstName());
        contact.setLastName(contact.getLastName());
        contact.setPhone(contact.getPhone());
        return contact;
    }

    private ContactDTO toDto (Contact contact) {
        var dto = new ContactDTO();
        dto.setId(contact.getId());
        dto.setPhone(contact.getPhone());
        dto.setFirstName(contact.getFirstName());
        dto.setLastName(contact.getLastName());
        dto.setUpdatedAt(contact.getUpdatedAt());
        dto.setCreatedAt(contact.getCreatedAt());
        return dto;
    }
    // END
}
