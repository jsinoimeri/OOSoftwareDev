import java.util.ArrayList;

/**
 * The test class ClubTest.
 *
 * @author  D.L. Bailey
 * @version SYSC 2004 Fall 2013, Oct. 7, 2013.
 */
public class ClubTest extends junit.framework.TestCase
{

    private Club club1;
    private Club club2;
    
    /**
     * Default constructor for test class ClubTest
     */
    public ClubTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
        club1 = new Club();
        
        club2 = new Club();
        club2.join(new Membership("Jack", 2, 2004));
        club2.join(new Membership("Gwen", 3, 2004)); 
        club2.join(new Membership("Ianto", 2, 2007));
        club2.join(new Membership("Toshiko", 2, 2004));
        club2.join(new Membership("Owen", 4, 2005));
        club2.join(new Membership("Rhys", 4, 2008));             
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }
    
    public void testJoinAndNumberOfMembers()
    {
        
        /* A new club has 0 members. */
        assertEquals(0, club1.numberOfMembers());
         
        /* After calling join five times, the club should
         * have 5 members.
         * Note - if the following test fails, check join and numberOfMembers.
         */
        assertEquals(6, club2.numberOfMembers());
    }
    
    public void testhasMember()
    {
        assertFalse(club1.hasMember("Jack"));
        
        assertTrue(club2.hasMember("Jack"));
        assertTrue(club2.hasMember("Ianto"));   
        assertTrue(club2.hasMember("Owen")); 
        assertTrue(club2.hasMember("Rhys"));         
        assertFalse(club2.hasMember("David"));
    }
    
    public void testJoinedInMonth()
    {
        // Check a new, empty club.
        for (int i = 1; i <= 12; i += 1) {
            assertEquals(0, club1.joinedInMonth(i)); 
        }        
        
        // 0 members joined in Jan.
        assertEquals(0, club2.joinedInMonth(1));
        // 3 members joined in Feb.
        assertEquals(3, club2.joinedInMonth(2));         
        // 1 member joined in Mar.
        assertEquals(1, club2.joinedInMonth(3));
        // 1 member joined in Apr.
        assertEquals(2, club2.joinedInMonth(4));  
        
        // 0 members joined in May - Dec.
        for (int i = 5; i <= 12; i += 1) {
            assertEquals(0, club2.joinedInMonth(i)); 
        }
    }
    
    public void testPickAMember()
    {
        Membership member = club2.pickAMember();
        if (member.getName().equals("Jack")) {
            assertEquals(2, member.getMonth());
            assertEquals(2004, member.getYear());
        } else if (member.getName().equals("Gwen")) {
            assertEquals(3, member.getMonth());
            assertEquals(2004, member.getYear());
        } else if (member.getName().equals("Ianto")) {
            assertEquals(2, member.getMonth());
            assertEquals(2007, member.getYear());
        } else if (member.getName().equals("Toshiko")) {
            assertEquals(2, member.getMonth());
            assertEquals(2004, member.getYear());
        } else if (member.getName().equals("Owen")) {
            assertEquals(4, member.getMonth());
            assertEquals(2005, member.getYear());
        } else if (member.getName().equals("Rhys")) {
            assertEquals(4, member.getMonth());
            assertEquals(2008, member.getYear());
        } else {
            fail("Randomly selected member is" + member.getName() + "?");
        } 
        
        /* For a more robust test, we should call pickAMember many times, and
         * verify every member is picked approximately the same number of times
         * as every other member.
         */
    }
 
    public void testPurgeJan()
    {
       // Remove all members who joined in January.
       ArrayList<Membership> purged = club2.purge(1);
       assertEquals(6, club2.numberOfMembers());
       assertEquals(0, purged.size());
 
    }
    
    public void testPurgeMarch()
    {
       // Remove all members who joined in March.
       ArrayList<Membership> purged = club2.purge(3);
       assertEquals(5, club2.numberOfMembers());
       assertEquals(1, purged.size());
       assertEquals("Gwen",purged.get(0).getName());
    }
    
    public void testPurgeApr()
    {
       // Remove all members who joined in April.
       ArrayList<Membership> purged = club2.purge(4);
       assertEquals(4, club2.numberOfMembers());
       assertEquals(2, purged.size());
       String name1 = purged.get(0).getName();
       String name2 = purged.get(1).getName();       
       assertTrue(name1.equals("Owen") || name1.equals("Rhys"));
       assertTrue(name2.equals("Owen") || name2.equals("Rhys"));      
    } 
    
    public void testPurgeFeb()
    {
       // Remove all members who joined in Feb.
       ArrayList<Membership> purged = club2.purge(2);
       assertEquals(3, club2.numberOfMembers());
       assertEquals(3, purged.size());
       String name1 = purged.get(0).getName();
       String name2 = purged.get(1).getName();
       String name3 = purged.get(2).getName();
       assertTrue(name1.equals("Jack") || name1.equals("Ianto") || name1.equals("Toshiko"));
       assertTrue(name2.equals("Jack") || name2.equals("Ianto") || name2.equals("Toshiko"));
       assertTrue(name3.equals("Jack") || name3.equals("Ianto") || name3.equals("Toshiko"));      
    }       
}
