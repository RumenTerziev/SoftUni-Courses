package phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import phonebook.entity.Contact;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ContactController {
    private List<Contact> contacts;


    public ContactController() {
        this.contacts = new ArrayList<>();
    }


    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("contacts", contacts);
        return modelAndView;
    }

    @PostMapping("/")
    public String addContact(Contact contact) {
       Contact contactToAdd = contacts.stream().filter(contact1 -> contact1.getName().equals(contact.getName())).findFirst().orElse(null);
        if (contactToAdd == null) {
            this.contacts.add(contact);
            return "redirect:/";
        } else {
            throw new IllegalArgumentException("Contact already added");
        }

    }


    @PutMapping("/")
    public String updateByName(Contact changedContact) {
        Contact contactToChange;

        for (Contact contact : contacts) {
            if (contact.getName().equals(changedContact.getName())) {
                contactToChange = contact;
                this.contacts.remove(contact);
                this.contacts.add(changedContact);
                break;
            }
        }

        return "redirect:/";
    }

}
