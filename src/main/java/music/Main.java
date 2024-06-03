package music;

import org.example.auth.Account;
import  org.example.database.DatabaseConnection;
import java.util.Optional;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        // Klasy z paczki org.example.site
        /* DatabaseConnection dbc = new DatabaseConnection();

        dbc.connect("/home/bartosz/IdeaProjects/shop/database.db", 1);

        Account accountManager = new Account();
        Account.AccountManager ac = accountManager.new AccountManager(dbc);

        Account accountOne = new Account(1, "John Doe");


        try{
            ac.register(accountOne, 1);
            ac.authenticate(accountOne, 1);
            System.out.println(ac.getAccount(accountOne.id(), 1));
        }catch (SQLException | ClassNotFoundException e){
            System.err.println(e.getMessage());
        }

         */

        //Zad 1 Testy
        Playlist playlist = new Playlist();
        Song music = new Song("AC/DC", "Highway to Hell", 207 );
        Song music2 = new Song("Black Sabbath", "Black Sabbath ", 380);

        if(playlist.isEmpty()){
            System.out.println("Playlist is empty");
        }
        playlist.add(music);
        if(playlist.size() == 1){
            System.out.println("Playlist contains one song");
        }
        playlist.add(music2);
        System.out.println("List of songs in playList: ");
        for(int i = 0; i < playlist.size(); i++){
            System.out.println(playlist.get(i));
        }

        //System.out.println(playlist.atSecond(-1));
       //System.out.println(playlist.atSecond(1000));
       // Zad 1 Testy



    }
}
