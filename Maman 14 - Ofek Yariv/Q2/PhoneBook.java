package application;

import javafx.stage.FileChooser;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> book;

    public PhoneBook() throws IOException {
        book = new HashMap<>();
    }

    public PhoneBook(Map<String, String> map) throws IOException {
        book = new HashMap<>(map);
    }
    
    public Map<String, String> getBook() {
        return book;
    }
    
    public void setBook(Map<String, String> book) {
        this.book = book;
    }

    public void addContact(String name, String phone) throws Errors {
        if (name.equals("") || phone.equals("")) {
            throw new Errors("Empty Fields");
        }
        if (phone.matches("[0-9]+")) {
            book.put(name, phone);
        } else {
            throw new Errors("Invalid Phone Number");
        }
    }
    
    public void deleteContact(String name) {
        book.remove(name);
    }
    
    public void editContact (String name, String newPhone){
        book.replace(name,newPhone);
    }
    
    public boolean isExist(String name) {
        return this.book.containsKey(name);
    }

    public String search(String query) {
    	return isExist(query) ? (query + ": " + book.get(query).toString()) : (query + " Not Found");
    }
    
    public void save(PhoneBook book) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("PhoneBook"));
        output.writeObject(book.getBook());
        output.flush();
        output.close();
    }

    public Map<String, String> load () throws IOException, ClassNotFoundException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("select a file");
        chooser.setInitialDirectory(new File("."));
        File file = chooser.showOpenDialog(null);
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream in = new ObjectInputStream(fileIn);
    	book = (Map<String, String>) in.readObject();
        in.close();
        fileIn.close();
        return book;
    }
}
