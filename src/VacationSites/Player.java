    package VacationSites;

import java.io.Serializable;
import static java.lang.Double.isFinite;
import java.text.DecimalFormat;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>~
 * Class        Player
 * File         Player.java
 * Description  Defines the player class for objects
 * @author      <i>Robert Zimmerman</i>
 * Environment  PC, Windows 10 Home, jdk 1.8.0_241, NetBeans 18
 * Date         9/19/2023
 * History log  9/19/2023
 * Version      1.0
 * @see         java.util.Objects
 * </pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Player extends Person implements Comparable, Serializable
{
    // Name and age fields are inherited from abstract Person class
    private int correct;            //Number of correct questions
    private int totalQuestions;     //Number of total questions
    
    //Formats the float from calculate percent to teo decimal places
    private static final DecimalFormat df = new DecimalFormat("00.00");
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Constructor  Player()
     * Description  Sets the default constructor
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * Version      1.0
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Player() 
    {
        this(0, 0);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Constructor  Person()
     * Description  Sets the constructor with parameters passed in
     * @param       correct int
     * @param       totalQuestions int
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * Version      1.0
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Player(int correct, int totalQuestions) 
    {
        this.correct = correct;
        this.totalQuestions = totalQuestions;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Constructor  Person()
     * Description  Super constructor holding all values from this class and subclass
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * Version      1.0
     * @param       name String
     * @param       age int
     * @param       correct int
     * @param       totalQuestions int
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Player(String name, int age, int correct, int totalQuestions) 
    {
        super(name, age);
        this.correct = correct;
        this.totalQuestions = totalQuestions;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Constructor  Player()
     * Description  Sets the copy constructor
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * Version      1.0
     * @param       another Player
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Player(Player another) 
    {
        this.name = another.name;
        this.age = another.age;
        this.correct = another.correct;
        this.totalQuestions = another.totalQuestions;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method   `   calculatePercent()
     * Description  Calculates the players percentage score of their last quiz
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @return      float
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public float calculatePercent()
    {
        float percent;
            
            percent = ((float)this.correct / (float)this.totalQuestions * 100.0f);
            if(isFinite(percent))
            {
                return Float.parseFloat(df.format(percent));
            }
            else
            {
                return 0.0f;
            }
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method   `   getCorrect()
     * Description  Returns correct field of object.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @return      int
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getCorrect() {
        return correct;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method   `   setCorrect()
     * Description  Sets correct field of object.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @param       correct int
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setCorrect(int correct) {
        this.correct = correct;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method   `   getTotalQuestions()
     * Description  Returns totalQuestions field of object.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @return      int
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getTotalQuestions() {
        return totalQuestions;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method   `   setTotalQuestions()
     * Description  Sets totalQuestions field of object.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @param       totalQuestions int
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method   `   equals()
     * Description  Checks if two player objects are equal to each other.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @param       obj Object
     * @return      boolean
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
        {
            return true;
        }
        if (obj == null) 
        {
            return false;
        }
        if (getClass() != obj.getClass()) 
        {
            return false;
        }
        final Player other = (Player) obj;
        if (!this.name.equals(other.name))
        {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }
    
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method   `   compareTo()
     * Description  Compares two player objects to see if they are equal to, greater,
     *              or less than one another.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @param       obj Object
     * @return      int
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public int compareTo(Object obj)
    {
        try
        {
            Player otherPlayer = (Player) obj;
            //If name is equal, compare by age.
            if((this.getName().toLowerCase()).equals(
                    otherPlayer.getName().toLowerCase()))
            {
                return this.age - otherPlayer.age;
            }
            else {
                return this.getName().compareToIgnoreCase(otherPlayer.name);
            }   
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }   
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method   `   toString()
     * Description  Returns player objects fields in string format.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @return      String
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public String toString() {
        return super.toString() + "," + correct + "," + totalQuestions;
    }
}
