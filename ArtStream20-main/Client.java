

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Client extends Informations implements Validation{
    
    // private static ArrayList <String> names = new ArrayList<>();
    // private static ArrayList <String> pass = new ArrayList<>();
    // private static ArrayList<DashboardClient> dashboardClients = new ArrayList<>();
   
    
   
    public static int noOfClient = 0;
    private int index = 0;
    
    public Client(String username,String password)
    {
        super(username,password);
        
        try {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter("clientaccs.txt",true))) {
                writer.write(username + ":" + password);
                writer.newLine();
            }
            System.out.println("Account created: " + username);
            ++noOfClient;
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getLocalizedMessage());
        }

        // try
        // {           
        //     names.add(username);
        //     pass.add(password);

            

        //      System.out.println(names.get(noOfClient));
        //      System.out.println(pass.get(noOfClient));
           
        //     dashboardClients.add(new DashboardClient(username));
 
             
             
        //     ++noOfClient;
            
        // }catch(Exception e)
        // {
        //     System.out.print("sdfdsf");
        // }
        

    }

    public Client()
    {
        super("Unknown","LOL");
    }
    @Override
    public boolean validateLogin(String name, String password) {

        try (BufferedReader reader = new BufferedReader(new FileReader("clientaccs.txt")))   {
            String line;
            while((line = reader.readLine()) != null) {
                String[] credentials = line.split(":");
                    if (credentials.length == 2 && name.equals(credentials[0]) && password.equals(credentials[1])) {
                        return true;
                    }
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return false;
        // for (int i = 0; i < names.size(); ++i) {
        //     if (name.equals(names.get(i)) && password.equals(pass.get(i))) {
        //         index = i;       
        //         System.out.print(index);       
        //         return true; 
        //     }
        // }
        // return false; 
    }/* 
    @Override
    public boolean validateRegister(String name, String password) {

        for (int i = 0; i < names.size(); ++i) {
            if (name.equals(names.get(i)) && password.equals(pass.get(i))) {
                return true; 
            }
        }
        return false; 
    }
    */
    @Override
    public boolean validateRegister(String name, String password){

        

        try (BufferedReader reader = new BufferedReader(new FileReader("clientacca.txt"))){
            String line;

            while ((line = reader.readLine()) !=null) {
                String [] credentials = line.split(":");
                if(credentials.length > 0 && name.equals(credentials[0])) {
                    return false;
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clientaccs.txt",true))) {
            writer.write(name + ":" + password);
            writer.newLine();
            
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        return true;
    }
    public void displayDashboard()
    {       
        new displayDashboard.get(index).setVisible(true);; 
        
    }

    
    




}
