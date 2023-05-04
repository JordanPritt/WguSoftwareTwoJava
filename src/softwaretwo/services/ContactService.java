package softwaretwo.services;

import softwaretwo.data.models.Contact;
import softwaretwo.data.repositories.ContactRepository;

import java.util.List;

public class ContactService {
    public static List<Contact> get() {
        ContactRepository repo = new ContactRepository();
        return repo.getAll();
    }
}
