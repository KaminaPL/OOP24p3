package music;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

public class SongTest {

    private Connection connection;

    @Before
    public void setConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/bartosz/IdeaProjects/shop/songs.db");
            if(connection != null){
                System.out.println("Connection successful");
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }

    }


    @Test
    public void testRead() {
        Song.Persistance sp = new Song.Persistance();

        //setConnection();
        try {
            Optional<Song> optional;
            optional = sp.read(3, connection);
            System.out.println(optional.get());
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
       //closeConnection();
    }

    @Test
    public void testReadWithWrongIndex() {
        Song.Persistance sp = new Song.Persistance();

       // setConnection();
        try {
            Optional<Song> optional;
            optional = sp.read(100, connection);
            if(! optional.isPresent()){
                throw new NoSuchElementException("No such element");
            }
            System.out.println(optional.get());
        }catch (SQLException | NoSuchElementException e){
            System.err.println(e.getMessage());
        }
       // closeConnection();
    }
    @Test
    public void testReadStream() {
        Song.Persistance sp = new Song.Persistance();

        // setConnection();
        try {
            Optional<Song> optional;
            optional = sp.read(100, connection);
            if(! optional.isPresent()){
                throw new NoSuchElementException("No such element");
            }
            System.out.println(optional.get());
        }catch (SQLException | NoSuchElementException e){
            System.err.println(e.getMessage());
        }
        // closeConnection();
    }

    @After
    public void closeConnection(){
        try {
            connection.close();
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }



}