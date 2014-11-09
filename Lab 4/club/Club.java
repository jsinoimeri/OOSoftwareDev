import java.util.ArrayList;
import java.util.Random;

/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Club
{
    // Define any necessary fields here ...
    private ArrayList<Membership> member_list;
    private Random random_generator;
    
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        // Initialise any fields here ...
        member_list = new ArrayList<Membership>();
        random_generator = new Random();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        member_list.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return member_list.size();
    }
    
    /**
    * Determine if a specific person is a member of the club.
    * @param name The person's name.
    * @return true if that person is a member;
    * otherwise return false.
    */
    public boolean hasMember(String name)
    {
        for(Membership s1: member_list)
        {
            if (s1.getName().equals(name))
            {
                return true;
            }
        }
        
        return false;
    }
    
   
    /**
    * Determine the number of members who joined in the
    * given month.
    * @param month The month we are interested in.
    * @return The number of members.
    */
    public int joinedInMonth(int month)
    {
        ArrayList<Membership> month_members = new ArrayList<Membership>();
        
        if (month >= 1 && month <= 12)
        {
            for(Membership m1: member_list)
            {
                if (m1.getMonth() == month) {month_members.add(m1);}
            }
        }
        
        else {System.out.printf("\nInvalid month\n");}
        
        return month_members.size();
    }
    
    /**
    * Select a random member of the club.
    * @return The randomly selected member.
    */
    public Membership pickAMember()
    {
        int index = random_generator.nextInt(member_list.size());
        return member_list.get(index);
    }
    
    /**
    * Remove from the club's collection all members who
    * joined in the given month, and return them stored
    * in a separate collection object.
    * @param month The month of the Membership.
    * @return The members who joined in the given month.
    */
    public ArrayList<Membership> purge(int month)
    {
        ArrayList<Membership> purge_month_members = new ArrayList<Membership>();
        
        if (month >= 1 && month <= 12)
        {
            int index = 0;
            while (index < member_list.size())
            {
                if (member_list.get(index).getMonth() == month) 
                {
                    purge_month_members.add(member_list.get(index));
                    member_list.remove(index);
                    index = 0;
                }
                
                else {index ++;}
            }
        }
        
        else {System.out.printf("\nInvalid month\n");}
        
        return purge_month_members;
    }
}
