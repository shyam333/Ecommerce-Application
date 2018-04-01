package helloworld.demo.com.ecommerceapplication;



    public class Contact  {
    public String ID;
    public String Name;

    public Contact() {

    }

    public Contact(String ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    public Contact(String Name)
    {
        this.Name = Name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }



}