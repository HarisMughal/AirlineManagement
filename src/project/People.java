/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Mark
 */


//The file contains the Class which will be used to store data

public class People {

   
    
    private String firstName;
    private String lastName;
    private String   passNumber;
    private String dateArival;
    private int    id;
    private int level;  

    // Constructors
    
    public People(String firstName, int level) {
        this.firstName = firstName;
        this.level = level;
    }
    
    public People(String firstName, String lastName, String passNumber, String dateArival, int level) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passNumber = passNumber;
        this.dateArival = dateArival;
        this.level = level;
    }

    
    

    
    //Getters
    public int getId() {
        return id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public String getDateArival() {
        return dateArival;
    }

    public int getLevel() {
        return level;
    }

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }

    public void setDateArival(String dateArival) {
        this.dateArival = dateArival;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    // Funtion to display the formate the output of object People (for Testing)
    @Override
    public String toString() {
        return "Name: "+firstName+"\t level: "+level+"\tId: "+id; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
