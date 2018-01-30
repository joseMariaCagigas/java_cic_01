package es.cic.curso;

import java.io.Serializable;

import com.vaadin.ui.TextField;

public class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1822861817111197911L;
	private String firstName;
	private String lastName;
	
	public Persona() {
		super();
	}

	public Persona(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
