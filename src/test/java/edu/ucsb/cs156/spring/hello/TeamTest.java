package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void equals_coversAllCases() {
        Team t1 = new Team("s25-99");
        t1.addMember("Alice");

        Team t2 = new Team("s25-99");
        t2.addMember("Alice");

        Team t3 = new Team("s25-98"); // different name
        t3.addMember("Alice");

        Team t4 = new Team("s25-99");
        t4.addMember("Bob"); // different member

        assertEquals(t1, t1);

        assertNotEquals(t1, null);
        assertNotEquals(t1, "not a team");

        assertEquals(t1, t2);      // same name and members
        assertNotEquals(t1, t3);   // different name
        assertNotEquals(t1, t4);   // different members
    }


    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void hashCode_returns_correct_hashCode() {
        Team t = new Team();
        t.setName("foo");
        t.addMember("bar");

        int result = t.hashCode();
        int expectedResult = 130294; // Run once to get the value, then plug it in

        assertEquals(expectedResult, result);
    }

}
