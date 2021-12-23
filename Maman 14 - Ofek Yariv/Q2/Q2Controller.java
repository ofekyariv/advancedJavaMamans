package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Q2Controller {

    private PhoneBook phoneBook;
    private HashMap<String, String> book;

    @FXML
    private TableColumn<Map.Entry<String, String>, String> nameCol;
    @FXML
    private TableColumn<Map.Entry<String, String>, String>  phoneCol;
    @FXML
    private Button addBtn;
    @FXML
    private Text txtTitle;
    @FXML
    private TableView<Map.Entry<String, String>> table;
    @FXML
    private Button loadBtn;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPhone;
    @FXML
    private Button removeBtn;
    @FXML
    private Button saveBtn;
    @FXML
    private Button searchBtn;
    @FXML
    private TextField searchText;
    @FXML
    private Button updateBtn;
    @FXML
    private TextField updateName;
    @FXML
    private TextField updatePhone;
    
    @FXML
    void searchBtnClicked(ActionEvent event) {
        txtTitle.setText(phoneBook.search(searchText.getText()));
    }
    
    @FXML
    void addBtnClicked(ActionEvent event) throws Errors {
    	try{
	    	String name =  txtName.getText();
	    	String phone = txtPhone.getText();
	        phoneBook.addContact(name,phone);
	        txtTitle.setText(name + " Added");
	        viewPhoneBook();
    	}
    	catch (Exception error){
    		txtTitle.setText(error.getMessage());
    	}
    }
    
    @FXML
    void removeBtnClicked(ActionEvent event) {
        if (phoneBook.isExist(searchText.getText()) ) {
            phoneBook.deleteContact(searchText.getText());
            viewPhoneBook();
            txtTitle.setText(searchText.getText() + " Removed");
        }
        else {
            txtTitle.setText(searchText.getText() + " Not Found");
        }
    }
    
    @FXML
    void loadBtnClicked(ActionEvent event) throws IOException, Errors, ClassNotFoundException {
    	try{
    		phoneBook.setBook(phoneBook.load());
    	     viewPhoneBook();
    	}
    	catch (Exception error){
    		txtTitle.setText(error.getMessage());
    	}
    }

    @FXML
    void saveBtnClicked(ActionEvent event) throws IOException {
    	try{
    		phoneBook.save(phoneBook);
            txtTitle.setText("'PhoneBook' Saved");
    	}
    	catch (Exception error){
    		txtTitle.setText(error.getMessage());
    	}
        
    }

    @FXML
    public void updateBtnClicked(ActionEvent actionEvent) {
        if (phoneBook.isExist(updateName.getText())){
            phoneBook.editContact(updateName.getText(),updatePhone.getText());
            viewPhoneBook();
            txtTitle.setText(updateName.getText() + " Updated");
        }
        else{
            txtTitle.setText("Name Not Found");
        }
    }
    public void initialize() throws IOException, Errors {
    	try{
    		book = new HashMap<String,String>();
            phoneBook = new PhoneBook(book);
            nameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getKey()));
            phoneCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getValue()));
            txtTitle.setText("");
            viewPhoneBook();
    	}
    	catch (Exception error){
    		txtTitle.setText(error.getMessage());
    	}
    }
    private void viewPhoneBook() {
        table.getItems().clear();
        table.getItems().addAll(phoneBook.getBook().entrySet());
        table.sort();
    }
}
