package contact; 
import java.util.Objects;

public class Contact {
	// Final ensures contact_id cannot be changed
	private final String contact_id;
	
	private String first_name;
	private String last_name;
	private String phone;
	private String address;
	
	//Constructor for contact info
	public Contact(String contact_id, String first_name, String last_name, String phone, String address) {
		this.contact_id = validateID(contact_id);
		
		this.first_name = ValidateFirstname(first_name);
		this.last_name = ValidateLastname(last_name);
		this.phone = validatePhone(phone);
		this.address = validateAddress(address);
		
		
	}
	//Getter methods getting contact info
	public String getContactID() {return contact_id;}
	public String getFirstName() {return first_name;}
	public String getLastName() {return last_name;}
	public String getPhone() {return phone;}
	public String getaddress() {return address;}
	
	//Setter methods for setting contact info
	public void setFirstName(String first_name) {this.first_name = ValidateFirstname(first_name);}
	public void setLastName(String last_name) {this.last_name = ValidateLastname(last_name);}
	public void setPhone(String phone) {this.phone = validatePhone(phone);}
	public void setAddress(String address) {this.address = validateAddress(address);}
	
	
	//Validation helpers for contact info ensuring it meets requirements and leaves error messages if not correct
	private static String validateID(String contact_id) {
		//Ensures that ID is not a null value
		Objects.requireNonNull(contact_id, "contactId must not be null");
		
		if (contact_id.length() > 10) throw new IllegalArgumentException("contactId must be <= 10 characters");
        // length() counts characters.
        // If more than 10, throw error.
		
		if (contact_id.isBlank()) throw new IllegalArgumentException("contactId must not be blank");

        // isBlank() checks empty OR only spaces like "   ".

        // Helps ensure the ID isn't useless.
		
		return contact_id; 
			
		}
	
	private static String ValidateFirstname(String first_name) {
		
	Objects.requireNonNull(first_name, "firstName must not be null");
    // Must exist.

    if (first_name.length() > 10) throw new IllegalArgumentException("firstName must be <= 10 characters");
    // Must be 10 chars or less.

    if (first_name.isBlank()) throw new IllegalArgumentException("firstName must not be blank");
    // Must not be empty/spaces.

    return first_name;
	}
	
	
	private static String ValidateLastname(String last_name) {
		Objects.requireNonNull(last_name, "Last Name must not be null");
		//Must exist.
		
		if(last_name.length() > 10) throw new IllegalArgumentException("Last name must be <= 10 characters");
		//Must be 10 chars or less
		
		if(last_name.isBlank()) throw new IllegalArgumentException("Last name must not be blank");
		
		return last_name;
		
	}
	
	private static String validatePhone(String phone) {

        Objects.requireNonNull(phone, "phone must not be null");
        // Must exist.



        if (!phone.matches("\\d{10}")) {

        // Java helper , String.matches(regex)


            throw new IllegalArgumentException("phone must be exactly 10 digits");

            // If not exactly 10 digits, throw error.

        }



        return phone;

    }
	
	 private static String validateAddress(String address) {
	        Objects.requireNonNull(address, "address must not be null");
	        // Must exist.

	        if (address.length() > 30) throw new IllegalArgumentException("address must be <= 30 characters");
	        // Must be 30 chars or less.

	        if (address.isBlank()) throw new IllegalArgumentException("address must not be blank");
	        // Must not be empty/spaces.

	        return address;
	    }
	
	
	
	
	

}
