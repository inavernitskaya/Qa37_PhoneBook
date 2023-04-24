package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"inna_83@gmail.com","Aa13579$"});
        list.add(new Object[]{"inna_83@gmail.com","Aa13579$"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        // read from file--> add to list
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
       String line = reader.readLine(); // "inna_83@gmail.com,Aa13579$"
          while (line !=null){
              String[] all =line.split(","); //["inna_83@gmail.com"] ["Aa13579$"]
              list.add(new Object[]{new User().withEmail(all[0]).withPassword(all[1])});
              line=reader.readLine(); // "sonya@gmail.com,Ss12345$" //"inna_83@gmail.com,Aa13579$" // null
          }


    return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginFile2() throws IOException {
        List<Object[]> list = new ArrayList<>();
        // read from file--> add to list
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/test.csv")));
        String line = reader.readLine(); // "inna_83@gmail.com,Aa13579$"
        while (line !=null){
            String[] all =line.split("/"); //["inna_83@gmail.com"] ["Aa13579$"]
            list.add(new Object[]{new User().withEmail(all[0]).withPassword(all[1])});
            line=reader.readLine(); // "sonya@gmail.com,Ss12345$" //"inna_83@gmail.com,Aa13579$" // null
        }


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginModels(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("inna_83@gmail.com").withPassword("Aa13579$")});
        list.add(new Object[]{new User().withEmail("inna_83@gmail.com").withPassword("Aa13579$")});

        return list.iterator();
    }

}
