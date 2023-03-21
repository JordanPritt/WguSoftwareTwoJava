package softwaretwo.data.repositories;

import softwaretwo.data.access.ClientScheduleContext;
import softwaretwo.data.models.Appointment;
import softwaretwo.data.models.Contact;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactRepository {
    public List<Contact> getAll() {
        try{
            ClientScheduleContext.OpenConnection();
            List<Contact> contacts = new ArrayList<>();



            return contacts;
        } catch (SQLException ex) {
            System.out.println("Failed to query Contacts data. Reason: " + ex.getMessage());
            return new ArrayList<>();
        } catch (Exception ex) {
            System.out.println("Get All Contacts error: " + ex.getMessage());
            return new ArrayList<>();
        }
    }
}
