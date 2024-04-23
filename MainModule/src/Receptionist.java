

import java.util.HashMap;
import java.util.Map;

public class Receptionist {

    private String username;
    private String password;
    private Map<String, String> credentials;

    public Receptionist() {
        this.username = "";
        this.password = "";
        this.credentials = new HashMap<>();
    }

    // Method to create a new username-password pair
    public void createCredentials(String username, String password) {
    	this.username=username;
    	this.password=password;
        credentials.put(username, password);
    }

    // Method to verify credentials
    public boolean verifyCredentials(String username, String password) {
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }

    // Method to update password
    public void updatePassword(String username, String newPassword) {
        if (credentials.containsKey(username)) {
            credentials.put(username, newPassword);
            System.out.println("Password updated successfully for username: " + username);
        } else {
            System.out.println("Username not found.");
        }
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for credentials map
    public Map<String, String> getCredentials() {
        return credentials;
    }

    // Setter for credentials map
    public void setCredentials(Map<String, String> credentials) {
        this.credentials = credentials;
    }
}
