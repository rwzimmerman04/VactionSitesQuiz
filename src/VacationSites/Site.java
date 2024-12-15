package VacationSites;

import java.util.Objects;


/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <pre>~
 * Class        Site
 * File         Site.java
 * Description  Defines the Site class for objects
 * @author      <i>Robert Zimmerman</i>
 * Environment  PC, Windows 10 Home, jdk 1.8.0_241, NetBeans 18
 * Date         9/19/2023
 * History log  9/19/2023
 * Version      1.0
 * @see         java.util.Objects
 * </pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class Site 
{
    private String name;        //Name of the site
    private String country;     //Name of the sites country
    private float population;     //Number of the population
    private String capital;     //Name of countries capital
    private float area;           //Area of the country in square miles

    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Constructor  Site()
     * Description  Sets the default constructor for Site class
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @param       name String
     * @param       country String
     * @param       population float
     * @param       capital String
     * @param       area float
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Site(String name, String country, float population, 
            String capital, float area) 
    {
        this.name = name;
        this.country = country;
        this.population = population;
        this.capital = capital;
        this.area = area;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Constructor  Site()  - Override Constructor
     * Description  Sets the overridden constructor for Site class
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Site() 
    {
        this( "", "", 0, "", 0);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Constructor  Site()  - Copy Constructor
     * Description  Sets the copy constructor for Site class
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @param       another Site
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Site(Site another) 
    {
        name = another.name;
        country = another.country;
        population = another.population;
        capital = another.capital;
        area = another.area;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method       getName()
     * Description  Returns name field of Site object.
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
     * Method       getCountry)
     * Description  Returns country field of Site object.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @return      String
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getCountry() {
        return country;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method       getPopulation()
     * Description  Returns population field of Site object.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @return      float
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public float getPopulation() {
        return population;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method       getCapital()
     * Description  Returns capital field of Site object.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @return      String
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String getCapital() {
        return capital;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method       getAre()
     * Description  Returns area field of Site object.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @return      float
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public float getArea() {
        return area;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method       setName()
     * Description  Sets name field of Site object.
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
     * Method       setCountry()
     * Description  Sets country field of Site object.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @param       country String
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setCountry(String country) {
        this.country = country;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method       setPopulation()
     * Description  Sets population field of Site object.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @param       population float
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setPopulation(float population) {
        this.population = population;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method       setCapital()
     * Description  Sets capital field of Site object.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @param       capital String
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setCapital(String capital) {
        this.capital = capital;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>~
     * Method       setArea()
     * Description  Sets area field of Site object.
     * @author      <i>Robert Zimmerman</i>
     * Date         9/19/2023
     * History log  9/19/2023
     * @param       area float
     * @see         java.util.Objects
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setArea(float area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Site other = (Site) obj;
        if (this.population != other.population) {
            return false;
        }
        if (this.area != other.area) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        return Objects.equals(this.capital, other.capital);
    }

    @Override
    public String toString() 
    {
        return "name: " + name + 
                ", country: " + country + 
                ", population: " + population + 
                ", capital: " + capital + 
                ", area: " + area + '}';
    }
    
}
