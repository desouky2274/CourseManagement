package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User{

    private static ArrayList<User> allUsers;// to be shared between all admins--> static

    public ArrayList<User>getUsers(){
        return allUsers;
    }


    public void steAllUsers(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        if(!file.exists())
            throw new FileNotFoundException("not found the file");

        while(input.hasNext()){
            String fname = input.next();
            String mname = input.next();
            String lname = input.next();
            long id = input.nextInt();
            String pass = input.next();
            String sign  = input.next();
            if(sign.equals("Student"))
            {
                double gpa = input.nextDouble();
                

            }else if(sign.equals("Admin")){

            }else if(sign.equals("Instructor")){

            }else
            {

            }

        }


    }

    public Admin(long id, String password) {
        super(id, password);
    }

    public Admin(String fName, String mName, String lName, long id, String password) {
        super(fName, mName, lName, id, password);

    }

    public Admin(){

    }

    public static void addUser(User u){
        allUsers.add(u);
    }

    public void removeUser(User u ){
        for(int x=0; x<allUsers.size(); x++){
            if(u.getId() == allUsers.get(x).getId())
                allUsers.remove(x);
        }
    }

    public void updateUserPassword(User u ){ // not completed
        for(int x=0; x<allUsers.size(); x++){
            int index = 0;
            if(u.getId() == allUsers.get(x).getId())
            {
                index = x;
                break;
            }
            //now i have the index of the user in the array
            //perform the specific update
        }
    }

}
