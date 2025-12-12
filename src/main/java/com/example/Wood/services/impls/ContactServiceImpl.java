package com.example.Wood.services.impls;

import com.example.Wood.dtos.ContactDto;
import com.example.Wood.models.Contact;
import com.example.Wood.repositories.ContactRepository;
import com.example.Wood.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;

    @Override
    public void addContact(ContactDto contactDto) {
        Contact contact=new Contact();
        contact.setEmail(contactDto.getEmail());
        contact.setFirstName(contactDto.getFirstName());
        contact.setLastName(contactDto.getLastName());
        contact.setMessage(contactDto.getMessage());
        contactRepository.save(contact);

    }
}
