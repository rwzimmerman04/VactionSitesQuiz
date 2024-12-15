package VacationSites;

import java.util.Objects;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>~
 * Class        Person
 * File         Person.java
 * Description  Defines the person class for objects
 * @author      <i>Robert Zimmerman</i>
 * Environment  PC, Windows 10 Home, jdk 1.8.0_241, NetBeans 18
 * Date         9/19/2023
 * History log  9/19/2023
 * Version      1.0
 * @see         java.util.Objects
 * </pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public abstract class Person 
{
    protected String name;      //The person's name
    protected int age;          //The person's age

     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Constructor  Person()
     * Description  Sets the default constructor
     * @author      <i>Robert Zimmerman</i>
     * Environment  PC, Windows 10 Home, jdk 18, NetBeans 18
     * Date         9/19/2023
     * History log  9/19/2023
     * Version      1.0
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Person() 
    {
        this("", 0);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Constructor  Person()
     * Description  Sets the constructor with parameters passed in
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @param       name String
     * @param       age int
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Person(String name, int age) 
    {
        this.name = name;
        this.age = age;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Constructor  Person()
     * Description  Sets the copy constructor
     * @author      <i>Robert Zimmerman</i>
     * Date         
     * History log  9/19/2023
     * @param       another Person
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Person(Person another) 
    {
        this.name = another.name;
        this.age = another.age;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method       getName()
     * Description  Returns name field
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @return      String
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getName() {
        return name;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method       setName()
     * Description  Sets name field
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @param       name String
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setName(String name) {
        this.name = name;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method       getAge()
     * Description  Returns age field
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @return      int
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getAge() {
        return age;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method       setName()
     * Description  Sets age field
     * @author      <i>Robert Zimmerman</i>
     * Environment  PC, Windows 10 Home, jdk 18, NetBeans 18
     * Date         9/19/2023
     * History log  9/19/2023
     * Version      1.0
     * @param       age int
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setAge(int age) {
        this.age = age;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method       toString()
     * Description  Overriding method returns string containing all the data fields
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @return      String
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public String toString() {
        return name + "," + age;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method       equals()
     * Description  Overriding method returns boolean if two Person object are equal
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @param       obj Object
     * @return      Boolean
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        
        if (this.age != other.age) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
}
