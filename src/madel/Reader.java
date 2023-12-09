package madel;

import enam.Gender;

public class Reader {//id, fullName, email, phoneNumber, Gender gender
    public static long ID = 0;
    private long id;
    private String fui_name;
    private String gmail;
    private String phone_number;
    private Gender gender;

    public Reader( String fui_name, String gmail, String phone_number, Gender gender) {
        this.id = ++ID;
        this.fui_name = fui_name;
        this.gmail = gmail;
        this.phone_number = phone_number;
        this.gender = gender;
    }

    public Reader() {

    }

    public static long getID() {
        return ID;
    }

    public static void setID(long ID) {
        Reader.ID = ID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFui_name() {
        return fui_name;
    }

    public void setFui_name(String fui_name) {
        this.fui_name = fui_name;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Reader " +
                "id = " + id +
                ", fui name = " + fui_name +
                ", gmail = " + gmail +
                ", phone number = " + phone_number +
                ", gender = " + gender + "\n";
    }
}
