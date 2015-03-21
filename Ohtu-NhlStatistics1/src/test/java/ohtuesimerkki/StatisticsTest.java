package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StatisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    @Before
    public void init(){
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchFindsCorrectPlayer(){
        Player semenko = stats.search("Semenko");

        assertNotNull("search should return Semenko",semenko);
    }

    @Test
    public void searchShouldReturnNullIfNotFound(){
        Player jagr = stats.search("Jagr");

        assertNull("search should return null",jagr);
    }

    @Test
    public void teamReturnsOnlyPlayersFromOneTeam(){
        List<Player> players = stats.team("EDM");
        boolean allFromSame = true;

        for (Player p : players){
            if(!p.getTeam().equals("EDM")){
                allFromSame = false;
                break;
            }
        }

        assertTrue(allFromSame);
    }

    @Test
    public void topScorersDoesntReturnAnyIfParamIsZero(){
        List<Player> players = stats.topScorers(0);

        assertEquals("Should be zero",0,players.size());
    }

    @Test
    public void topScorersReturnsCorrectAmountOfPlayers(){
        List<Player> players = stats.topScorers(3);

        assertEquals("Should be 3",3,players.size());
    }
}