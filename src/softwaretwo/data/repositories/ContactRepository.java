package softwaretwo.data.repositories;

import softwaretwo.data.access.ClientScheduleContext;
import softwaretwo.data.models.Contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactRepository {
    public List<Contact> getAll() {
        try {
            ClientScheduleContext.OpenConnection();
            List<Contact> contacts = new ArrayList<>();

            String getAllContactsSql = "SELECT * FROM client_schedule.contacts";
            PreparedStatement ps = ClientScheduleContext.connection.prepareStatement(getAllContactsSql);
            ResultSet results = ps.executeQuery();
            while (results.next()) {
                Contact currentContact = new Contact(
                        results.getInt("Contact_ID"),
                        results.getString("Contact_Name"),
                        results.getString("Email")
                );
                contacts.add(currentContact);
            }

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
