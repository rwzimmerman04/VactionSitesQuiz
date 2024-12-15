package VacationSites;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.Position;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
 * Class        SitesGUI.java
 * Description  A class representing the GUI used in Vacation sites quiz. Provide
 *              the tools for a user to be able to take a quiz on vacation
 *              sites around the world.
 * Project      Project 1 -- Vacation Sites Quiz
 * Platform     jdk 1.8.0_241; NetBeans IDE 18; PC Windows 10
 * Course       CS 143
 * Hourse       6 hours 30 minutes
 * Date         9/26/2023
 * History Log  9/26/2023, 9/28/2023, 9/29/2023, 10/3/2023  
 * @author	<i>Robert Zimmerman</i>
 * @version 	%1%
 * @see     	javax.swing.JFrame
 * @see         java.awt.Toolkit 
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class SitesGUI extends javax.swing.JFrame {
    //Class variables
    static int maxQuestions = 10;           //Max nuber of questions
    private int numberOfQuestions = 0;
    
    //Set the main ADTs to be used for sites, countries
    private BinarySearchTree playersTree = new BinarySearchTree();
    private List<Site> sitesList = new LinkedList<Site>();
    private Map<String, String> sitesHashMap = new HashMap<String, String>();
    
    //Set file name strings for later use
    private String sitesFileName = "src/Data/SiteData/Sites.txt";
    private String sitesObjectFileName = "src/Data/Countries.dat";
    private String playersFileName = "src/Data/PlayerData/Players.txt";
    
    //Parallel ArrayLists to hold the index of site and if it has been used
    private ArrayList<Boolean> sitesUsedArrayList = new ArrayList<Boolean>();
    private ArrayList<Integer> numbersArrayList = new ArrayList<Integer>();
    
    private int currentIndex;                       //Index of current site
    private String correctCountry = "";             //Holds name of correct country
    private int countCorrect = 0;                   //Holds number of correct answers
    private int numberOfCountries = maxQuestions;   //Used for unique random number
    
    private int sitesDisplayed = 0;                 //Number of displayed sites
    
    
    //Used to add players to the playersJList
    DefaultListModel<String> playerJListModel = new DefaultListModel<String>();
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Constructor      SitesGUI() ~ default constructor
     * Description      Create instance of SitesGUI form, set the page icon, the
     *                  submitJButton to the default button, fill the players 
     *                  names and set up countries list for viewing, center the 
     *                  form.
     * @author          <i>Robert Zimmerman</i>
     * Date             9/28/2023
     * History Log      9/28/2023 10/5/2023
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public SitesGUI() {
        initComponents();
        //Add listmodel to playerJList
        playerJList.setModel(playerJListModel);  
        
        //Sets the submitJButton defualt key to enter
        this.getRootPane().setDefaultButton(submitJButton);

        siteDetailJMenuItem.setEnabled(false);
        
        this.setLocationRelativeTo(null);   //center form
        //Set the icon image
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/SiteImages/VacationSplashTiny.png"));
        
        readSites(sitesFileName);
        
        readPlayers(playersFileName);
        
        //Set the defuat player to be the top of the playerJList
        playerJList.setSelectedIndex(0);
        
        submitJButton.setEnabled(false);      //disable submitJButton
        nextJButton.setEnabled(false);        //disable nextJButton
        againJButton.setEnabled(false);       //disable againJButton
        countryJComboBox.setEnabled(true);    //enable to countryJComboBox
        questionsJTextField.requestFocus();     //questionsJTextField recieves focus
        
        //Set default image of the imageJLabel
        imageJLabel.setIcon(new ImageIcon("src/SiteImages/Red Square.png"));
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       displaySite()
     * Description  Handles printing the form.
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void displaySite()
    {
        currentIndex = getUniqueRandomIndex();  //Get a random index
        correctCountry = sitesList.get(currentIndex).getCountry();
        String correctSiteName = sitesList.get(currentIndex).getName();
        siteNameJLabel.setText(correctSiteName);
        String imagePath = "src/SiteImages/" +  correctSiteName + ".png";
        imageJLabel.setIcon(new ImageIcon(imagePath));
        imageJLabel.setToolTipText(null);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       clearForm()
     * Description  Clears the form.
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void clearForm()
    {
        sitesDisplayed = 0;
        countCorrect = 0;
        newPlayersJMenuItem.setEnabled(true);
        newSitesJMenuItem.setEnabled(true);
        clearJMenuItem.setEnabled(true);
        addJMenuItem.setEnabled(true);
        editJMenuItem.setEnabled(true);
        deleteJMenuItem.setEnabled(true);
        searchJMenuItem.setEnabled(true);
        questionsJTextField.setEnabled(true);
        questionsJTextField.setText("");
        playerJList.setEnabled(true);
        imageJLabel.setIcon(new ImageIcon("src/SiteImages/Red Square.png"));
        againJButton.setEnabled(false);
        nextJButton.setEnabled(false);
        submitJButton.setEnabled(false);
        resultJLabel.setText("");
        readSites(sitesFileName);
        readPlayers(playersFileName);
        countryJComboBox.setEnabled(true);
        
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       searchPlayer()
     * Description  Searches the BinarySearchTree of player objects to find a
     *              a specific node given a players name.
     *              information.
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       playerName String
     * @return      BinarySearchTreeNode
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode searchPlayer(String playerName) 
    {
        BinarySearchTreeNode current = playersTree.getRoot();
        while(current != null)
        {    
            if(playerName.compareTo(current.data.getName()) < 0)
            {
              current = current.left;   
            }
            else if(playerName.compareTo(current.data.getName()) > 0)
            {
                current = current.right;
            }
            else if(current.data.getName().equals(playerName))
            {
                return current;
            }
        }
        return null;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       fillComboBox()
     * Description  Fills a the countryJComboBox from a list of country names
     * Date         10/3/2023
     * History log  10/3/2023, 10/5/2023
     * @param       sites List
     * @author      <i>Robert Zimmerman</i>
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void fillComboBox(List sites) 
    {
        Set uniqueCountries = new TreeSet<Site>();
        Site country = null;
        String countryName = "";
        countryJComboBox.removeAllItems();
        for(int i = 0; i < sites.size(); i++)
        {
            country = (Site) (sites.get(i));
            countryName = country.getCountry();
            uniqueCountries.add(countryName);
        }
        for(Object countryItem: uniqueCountries) 
        {
            if(countryItem instanceof String)
            {
                countryJComboBox.addItem(countryItem.toString());
            }
        }
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getUniqueRandomIndex()
     * Description  Returns a random number between 0 and the size of the sitesList
     * Date         10/3/2023
     * History log  10/3/2023
     * @return      int
     * @author      <i>Robert Zimmerman</i>
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getUniqueRandomIndex() 
    {
        Random gen = new Random();
        int randomIndex = 0;
        do
        {
            randomIndex = gen.nextInt(sitesList.size());
        }
        while(sitesUsedArrayList.get(randomIndex));
        sitesUsedArrayList.set(randomIndex, true);
        return randomIndex;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       readPlayers()
     * Description  Fills a playerTree BST and a JListModel to add player name
     *              options to the GUI
     * Date         9/29/2023
     * History log  9/29/2023, 10/3/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       fileName String
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void readPlayers(String fileName) 
    {
        int counter = 0;
        //Clear player tree set
        playersTree.removeAll();
        playerJListModel.removeAllElements();
        try
        {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            String line = "";           //Holds the text in the line of the file
            String playerName = "";     //Holds the current players name
            int age = 0;    int correct = 0;    int questions = 0;
            
            Player player = new Player();
            while(fileScanner.hasNextLine())
            {
                line = fileScanner.nextLine();
                StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
                while(stringTokenizer.hasMoreElements())
                {
                    //Grab player name
                    playerName = stringTokenizer.nextToken();
                    //Add player name to the playerJListModel
                    playerJListModel.addElement(playerName);
                    //Grab the player age
                    age = Integer.parseInt(stringTokenizer.nextElement().toString());
                    //Grab the player's correct answers
                    correct = Integer.parseInt(stringTokenizer.nextElement().toString());
                    //Grab the player's total questions
                    questions = Integer.parseInt(stringTokenizer.nextElement().toString());
                    //Add the info to a new player object
                    player = new Player(playerName, age, correct, questions);
                }
                playersTree.insertNode(player);
            }
            fileScanner.close();
            playerJList.setCellRenderer(new DefaultListCellRenderer());
            playerJList.setVisible(true);
            playerJList.setSelectedIndex(0);
        }
        catch(FileNotFoundException ex)
        {
            JFileChooser chooser = new JFileChooser("src/Data");
            int chosen = chooser.showOpenDialog(this);
            if(chosen == JFileChooser.APPROVE_OPTION)
            {
                File selection = chooser.getSelectedFile();
                String filePath = selection.getPath();
                if(filePath.contains("Player"))
                {
                    readPlayers(filePath);
                }
                else
                {
                    readSites(filePath);
                }
            }
            JOptionPane.showMessageDialog(null, fileName + " does not exist", 
                    "File not found error", JOptionPane.WARNING_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJLabel = new javax.swing.JLabel();
        questionsJLabel = new javax.swing.JLabel();
        questionsJTextField = new javax.swing.JTextField();
        nameOfSiteJLabel = new javax.swing.JLabel();
        siteNameJLabel = new javax.swing.JLabel();
        selectJLabel = new javax.swing.JLabel();
        countryJComboBox = new javax.swing.JComboBox<>();
        nextJButton = new javax.swing.JButton();
        againJButton = new javax.swing.JButton();
        submitJButton = new javax.swing.JButton();
        playerJScrollPane = new javax.swing.JScrollPane();
        playerJList = new javax.swing.JList<>();
        imageJLabel = new javax.swing.JLabel();
        resultJLabel = new javax.swing.JLabel();
        sitesJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        newSitesJMenuItem = new javax.swing.JMenuItem();
        newPlayersJMenuItem = new javax.swing.JMenuItem();
        clearJMenuItem = new javax.swing.JMenuItem();
        printPlayerJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        fileJSeparator = new javax.swing.JPopupMenu.Separator();
        quitJMenuItem = new javax.swing.JMenuItem();
        playerDataJMenu = new javax.swing.JMenu();
        addJMenuItem = new javax.swing.JMenuItem();
        editJMenuItem = new javax.swing.JMenuItem();
        searchJMenuItem = new javax.swing.JMenuItem();
        deleteJMenuItem = new javax.swing.JMenuItem();
        statisticJMenuItem = new javax.swing.JMenuItem();
        playerDetailJMenuItem = new javax.swing.JMenuItem();
        siteDetailJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Vacation Sites Quiz"); // NOI18N

        titleJLabel.setFont(new java.awt.Font("Segoe Print", 0, 30)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(204, 0, 204));
        titleJLabel.setText("Vacation Sites Quiz");

        questionsJLabel.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        questionsJLabel.setForeground(new java.awt.Color(204, 0, 204));
        questionsJLabel.setText("Questions:");

        questionsJTextField.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        questionsJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionsJTextFieldActionPerformed(evt);
            }
        });
        questionsJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                questionsJTextFieldKeyTyped(evt);
            }
        });

        nameOfSiteJLabel.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        nameOfSiteJLabel.setForeground(new java.awt.Color(204, 0, 204));
        nameOfSiteJLabel.setText("Name of Site");

        siteNameJLabel.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        siteNameJLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        selectJLabel.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        selectJLabel.setForeground(new java.awt.Color(204, 0, 204));
        selectJLabel.setText("Select A Country:");

        countryJComboBox.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N

        nextJButton.setText("Next Site");
        nextJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextJButtonActionPerformed(evt);
            }
        });

        againJButton.setText("Play Again");
        againJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                againJButtonActionPerformed(evt);
            }
        });

        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        playerJList.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        playerJList.setName("Players"); // NOI18N
        playerJScrollPane.setViewportView(playerJList);

        imageJLabel.setBackground(new java.awt.Color(204, 204, 204));

        resultJLabel.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N

        fileJMenu.setMnemonic('F');
        fileJMenu.setText("File");

        newSitesJMenuItem.setText("New Sites");
        newSitesJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newSitesJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(newSitesJMenuItem);

        newPlayersJMenuItem.setText("New Players");
        newPlayersJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPlayersJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(newPlayersJMenuItem);

        clearJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        clearJMenuItem.setMnemonic('C');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.setToolTipText("Clear player, start a new quiz");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printPlayerJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        printPlayerJMenuItem.setText("Print Player");
        printPlayerJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printPlayerJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printPlayerJMenuItem);

        printJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print Form");
        printJMenuItem.setToolTipText("Print Form as GUI");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);
        fileJMenu.add(fileJSeparator);

        quitJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        quitJMenuItem.setMnemonic('Q');
        quitJMenuItem.setText("Quit");
        quitJMenuItem.setToolTipText("End application");
        quitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(quitJMenuItem);

        sitesJMenuBar.add(fileJMenu);

        playerDataJMenu.setText("Player Database");

        addJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        addJMenuItem.setText("Add");
        addJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJMenuItemActionPerformed(evt);
            }
        });
        playerDataJMenu.add(addJMenuItem);

        editJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        editJMenuItem.setText("Edit");
        editJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJMenuItemActionPerformed(evt);
            }
        });
        playerDataJMenu.add(editJMenuItem);

        searchJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        searchJMenuItem.setText("Search");
        searchJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJMenuItemActionPerformed(evt);
            }
        });
        playerDataJMenu.add(searchJMenuItem);

        deleteJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        deleteJMenuItem.setText("Delete");
        deleteJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJMenuItemActionPerformed(evt);
            }
        });
        playerDataJMenu.add(deleteJMenuItem);

        statisticJMenuItem.setText("Statistics");
        statisticJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statisticJMenuItemActionPerformed(evt);
            }
        });
        playerDataJMenu.add(statisticJMenuItem);

        playerDetailJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        playerDetailJMenuItem.setText("Player Details");
        playerDetailJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerDetailJMenuItemActionPerformed(evt);
            }
        });
        playerDataJMenu.add(playerDetailJMenuItem);

        siteDetailJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        siteDetailJMenuItem.setText("Site Details");
        siteDetailJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siteDetailJMenuItemActionPerformed(evt);
            }
        });
        playerDataJMenu.add(siteDetailJMenuItem);

        sitesJMenuBar.add(playerDataJMenu);

        helpJMenu.setText("Help");

        aboutJMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        aboutJMenuItem.setMnemonic('A');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        sitesJMenuBar.add(helpJMenu);

        setJMenuBar(sitesJMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(nextJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(againJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(playerJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resultJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(selectJLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionsJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(nameOfSiteJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(countryJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(siteNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(questionsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(questionsJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(nameOfSiteJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(siteNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(imageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(againJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(countryJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resultJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(playerJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       readSites()
     * Description  Fills a List of sites and adds the site and country to a
     *              HashMap Then calls the fillComboBox method to add countries
     *              to the countryJComboBox.
     * Date         9/29/2023
     * History log  9/29/2023, 10/3/2023
     * @param       fileName String
     * @author      <i>Robert Zimmerman</i>
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void readSites(String fileName)
    {
        int counter = 0;
        sitesList.clear();                  //Clear the LinkedList of sites
        sitesUsedArrayList.clear();         //Clear the used sites Array list
        numbersArrayList.clear();           //Clear the numbers Array list 
        sitesHashMap.clear();               //Clear the sites HashMap
        try
        {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            String line = "";           //Holds the text in the line of the file
            String name = "";           //Holds the name of the site
            String country = "";        //Holds the name of teh sites's country
            String capital = "";        //Holds the name of the country's capital
            float population = 0;       //Holds the population of the country
            float area  = 0;            //Holds the area of the country is square miles
            Site site = new Site();     //Create new site object to hold info
            //Read from the file of counties and fill the above local variables
            while(fileScanner.hasNextLine())
            {
                line = fileScanner.nextLine();
                StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
                while(stringTokenizer.hasMoreElements())
                {
                    //Get the name of the site
                    name = stringTokenizer.nextElement().toString();
                    //Get the country teh site resides in
                    country = stringTokenizer.nextElement().toString();
                    //Add teh site and country to the sites HashMap
                    sitesHashMap.put(name, country);
                    //Get the population of the country
                    population = Float.parseFloat(stringTokenizer.nextElement().toString());
                    //Get the capital of the country
                    capital = stringTokenizer.nextElement().toString();
                    //Get the area of the country in square miles
                    area = Float.parseFloat(stringTokenizer.nextElement().toString());
                    //Add the information to the site object
                    site = new Site(name, country, population, capital, area);
                }
                sitesList.add(site);     //Add the site object to the sites LinkedList
                numbersArrayList.add(counter);  //used in unique random number generation
                sitesUsedArrayList.add(false);  //used in unique random number generation
                counter++;                  //Increment the counter
            }
            fileScanner.close();            //Close the fileScanner
            fillComboBox(sitesList);    //Fill the countryComboBox
            maxQuestions = sitesList.size();    //Max questions equals number of sites
            questionsJTextField.setToolTipText("Enter 1 - " + maxQuestions + 
                    " and press Enter to start quiz");
        } 
        catch (FileNotFoundException ex) 
        {
            JFileChooser chooser = new JFileChooser("src/Data");
            int chosen = chooser.showOpenDialog(this);
            if(chosen == JFileChooser.APPROVE_OPTION)
            {
                File selection = chooser.getSelectedFile();
                String filePath = selection.getPath();
                if(filePath.contains("Player"))
                {
                    readPlayers(filePath);
                }
                else
                {
                    readSites(filePath);
                }
            }
            JOptionPane.showMessageDialog(null, fileName + " not found", 
                    "File not found error", JOptionPane.WARNING_MESSAGE);
        }
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       savePlayers()
     * Description  The method builds a buffer of the BST info and writes to the 
     *              player text file.
     * Date         10/5/2023
     * History log  10/5/2023
     * @param       playersFile String
     * @author      <i>Robert Zimmerman</i>
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void savePlayers(String playersFile)
    {
        try
        {
            FileWriter filePointer = new FileWriter(playersFile, false);
            PrintWriter writeFile = new PrintWriter(filePointer, false);
            //Get root of the BinarySearchTree
            BinarySearchTreeNode root = playersTree.getRoot();
            
            playersTree.setBuffer(new StringBuilder()); //Clears buffer
            
            playersTree.buildBuffer(root);          //Build the file content
            
            String buffer = playersTree.getBuffer().substring(0
                    ,playersTree.getBuffer().length() - 1);
            
            writeFile.print(buffer);            //Write to the file
            writeFile.close();                    //Close the PrintWriter & file
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Could not write to file",
                    "Write File Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       setSelectedPlayer()
     * Description  The method sets the selected player to the passed in player.
     * Date         10/6/2023
     * History log  10/6/2023
     * @param       player Player
     * @author      <i>Robert Zimmerman</i>
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setSelectedPlayer(Player player)
    {
        boolean foundPlayer = false;
        String playerName = player.getName();
        while(!foundPlayer)
        {
            int index = playerJList.getNextMatch(playerName,
                    0, Position.Bias.Forward);
            playerJList.setSelectedIndex(index);
            foundPlayer = true;
        }
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       clearJMenuItemActionPerformed()
     * Description  Handles clearing the form.
     * Date         10/6/2023
     * History log  10/6/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        clearForm();
    }//GEN-LAST:event_clearJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       printJMenuItemActionPerformed()
     * Description  Handles printing the form.
     * Date         9/28/2023
     * History log  9/28/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       quitJMenuItemActionPerformed()
     * Description  Handles the closing the program.
     * Date         9/28/2023
     * History log  9/28/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void quitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       aboutJMenuItemActionPerformed()
     * Description  Handles the aboutJMenuItem open an informative AboutJDialog.
     * Date         9/28/2023
     * History log  9/28/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        About aboutWindow = new About(this, true);
        aboutWindow.setVisible(true);
    }//GEN-LAST:event_aboutJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       addJMenuItemActionPerformed()
     * Description  Handles the addJMenuItem open an interactive JDialog to
     *              add a non-existing player.
     * Date         10/6/2023
     * History log  10/6/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void addJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJMenuItemActionPerformed
        AddPlayer addPlayer = new AddPlayer(playersTree);
        addPlayer.setVisible(true);
        savePlayers(playersFileName);
        readPlayers(playersFileName);
    }//GEN-LAST:event_addJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       questionsJTextActionPerformed()
     * Description  Handles pressing enter of the questionsJTextField
     * Date         10/3/2023
     * History log  10/3/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void questionsJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionsJTextFieldActionPerformed
        try
        {
            if(!Validation.isInteger(questionsJTextField.getText(),
                    1, maxQuestions))
            {
                throw new NumberFormatException();
            }    
            numberOfQuestions = Integer.parseInt(questionsJTextField.getText());
            questionsJTextField.setEnabled(false);
            countryJComboBox.setEnabled(true);
            submitJButton.setEnabled(true);
            countryJComboBox.requestFocus();
            playerJList.setEnabled(false);
            submitJButton.setEnabled(true);
            newSitesJMenuItem.setEnabled(false);
            newPlayersJMenuItem.setEnabled(false);
            siteDetailJMenuItem.setEnabled(false);
            addJMenuItem.setEnabled(false);
            editJMenuItem.setEnabled(false);
            searchJMenuItem.setEnabled(false);
            deleteJMenuItem.setEnabled(false);
            newSitesJMenuItem.setEnabled(false);
            newPlayersJMenuItem.setEnabled(false);
            clearJMenuItem.setEnabled(false);
            displaySite();
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "Message must be in the range of 1-" + 
                    maxQuestions, "Inavlid input error", JOptionPane.WARNING_MESSAGE);
            questionsJTextField.selectAll();
        }
    }//GEN-LAST:event_questionsJTextFieldActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       nextJButtonActionPerformed()
     * Description  Handles the nextJButton being pressed displaying next site.
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void nextJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextJButtonActionPerformed
        displaySite();
        siteDetailJMenuItem.setEnabled(false);
        submitJButton.setEnabled(true);
        nextJButton.setEnabled(false);
        countryJComboBox.setEnabled(true);
    }//GEN-LAST:event_nextJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       againJButtonActionPerformed()
     * Description  Handles the againJButton being pressed startng a new game.
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void againJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_againJButtonActionPerformed
        clearForm();
    }//GEN-LAST:event_againJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       submitJButtonActionPerformed()
     * Description  Handles the submitJButton being pressed enabling the nextJButton.
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        sitesDisplayed++;
        //Name of correct country
        String correct = sitesList.get(currentIndex).getCountry();
        //Name of the current site
        String site = sitesList.get(currentIndex).getName();
        //String value of players entry
        String answer = countryJComboBox.getSelectedItem().toString();
        //Empty string to initialize the result response to player
        String result = "";
        if(correct.equals(answer))
        {
            countCorrect++;
            result = "Correct!" + countCorrect + "/" + sitesDisplayed;
            resultJLabel.setForeground(Color.GREEN);
        }
        else
        {
            result = "Incorrect!" + countCorrect + "/" + sitesDisplayed;
            resultJLabel.setForeground(Color.RED);
        }
        //Proccesses the end of the quiz
        if(sitesDisplayed == numberOfQuestions) 
        {   
            String playerName = playerJList.getSelectedValue();
            Player currentPlayer = searchPlayer(playerName).data;   //Current player
            float initialPercent = currentPlayer.calculatePercent();    //First percent
            float newPercent = ((float)countCorrect / (float)numberOfQuestions) * 100.0f; //New Percent
            
            //Save new score if better
            if(newPercent >= initialPercent)
            {
                currentPlayer.setTotalQuestions(numberOfQuestions);
                currentPlayer.setCorrect(countCorrect);
                //Save the player info
                savePlayers(playersFileName);
            }
            againJButton.setEnabled(true);
        }
        else
        {
            nextJButton.setEnabled(true);
        }
        resultJLabel.setText(result);
        imageJLabel.setToolTipText(site + ", " + correctCountry);
        siteDetailJMenuItem.setEnabled(true);
        submitJButton.setEnabled(false);
        countryJComboBox.setEnabled(false);
    }//GEN-LAST:event_submitJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       questionsJTextFieldKeyTyped()
     * Description  validates the Key typed to see if it is a valid character,
     *              if not, consume the character and give the user a beep.
     * Date         10/3/2023
     * History log  10/3/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void questionsJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_questionsJTextFieldKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) 
                || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) 
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_questionsJTextFieldKeyTyped
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       printPlayerJMenuItemActionPerformed()
     * Description  Handles printing the current player information.
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void printPlayerJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printPlayerJMenuItemActionPerformed
        String currentName = playerJList.getSelectedValue();
        Player currentPlayer = searchPlayer(currentName).data;
        
        PlayerDetails playerDetails = new PlayerDetails(currentPlayer);
        playerDetails.setVisible(false);
        
        PrintUtilities.printComponent(playerDetails);
    }//GEN-LAST:event_printPlayerJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       deleteJMenuItemActionPerformed()
     * Description  Handles deleting the current player information.
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void deleteJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJMenuItemActionPerformed
        String playerName = playerJList.getSelectedValue();
        int index = playerJList.getSelectedIndex();
        int result = JOptionPane.showConfirmDialog(null, "Delete Player", 
                "Are you sure you want to delete " + playerName + "?", 
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if(result == JOptionPane.OK_OPTION)
        {
            Player playerToBeRemoved = searchPlayer(playerName).data;
            playersTree.remove(playerToBeRemoved);
            
            savePlayers(playersFileName);
            playerJListModel.remove(index);
        }
        
        playerJList.setSelectedIndex(0);
    }//GEN-LAST:event_deleteJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       searchJMenuItemActionPerformed()
     * Description  Handles searching for a player.
     * Date         10/6/2023
     * History log  10/6/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void searchJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJMenuItemActionPerformed
        String input = JOptionPane.showInputDialog("Enter player name:");
        if(input.isEmpty())
        {
            System.exit(0);
        }
        else
        {
            try
            {
                Player searchedPlayer = searchPlayer(input).data;
                if(playersTree.contains(searchedPlayer))
                {
                    setSelectedPlayer(searchedPlayer);
                }
            }
            catch(NullPointerException ex)
            {
                JOptionPane.showMessageDialog(null, "Unable to find player",
                "Searching Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_searchJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       playerDetailJMenuItemActionPerformed()
     * Description  Handles creating PlayerDetails JDialog with current player
     *              information.
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void playerDetailJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerDetailJMenuItemActionPerformed
        String currentName = playerJList.getSelectedValue();
        Player currentPlayer = searchPlayer(currentName).data;
        
        PlayerDetails playerDetails = new PlayerDetails(currentPlayer);
        playerDetails.setVisible(true);
    }//GEN-LAST:event_playerDetailJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       newSitesJMenuItemActionPerformed()
     * Description  Handles access and selection of a new sites text file for 
     *              quiz use.
     *              information.
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void newSitesJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newSitesJMenuItemActionPerformed
        JFileChooser chooser = new JFileChooser("src/Data/SiteData");
        int chosen = chooser.showOpenDialog(this);
        if(chosen == JFileChooser.APPROVE_OPTION)
        {
            File file = chooser.getSelectedFile();
            String filePath = file.getPath();
            readSites(filePath);
            sitesFileName = filePath;
        }
    }//GEN-LAST:event_newSitesJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       newPlayersJMenuItemActionPerformed()
     * Description  Handles access and selection of a new players text file for 
     *              quiz use.
     *              information.
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void newPlayersJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPlayersJMenuItemActionPerformed
        JFileChooser chooser = new JFileChooser("src/Data/PlayerData");
        int chosen = chooser.showOpenDialog(this);
        if(chosen == JFileChooser.APPROVE_OPTION)
        {
            File file = chooser.getSelectedFile();
            String filePath = file.getPath();
            readPlayers(filePath);
            playersFileName = filePath;
        }
    }//GEN-LAST:event_newPlayersJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       siteDetailJMenuItemActionPerformed()
     * Description  Handles creating SiteDetails JDialog with current player
     *              information.
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void siteDetailJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siteDetailJMenuItemActionPerformed
        Site currentSite = sitesList.get(currentIndex);
        
        SiteDetails siteDetails = new SiteDetails(currentSite);
        siteDetails.setVisible(true);
    }//GEN-LAST:event_siteDetailJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       editJMenuItemActionPerformed()
     * Description  Handles the addJMenuItem open an interactive JDialog to
     *              edit an existing player.
     * Date         10/6/2023
     * History log  10/6/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void editJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJMenuItemActionPerformed
        Player currentPlayer = searchPlayer(
                playerJList.getSelectedValue().toString()).data;
        EditPlayer editPlayer = new EditPlayer(playersTree, 
                currentPlayer);
        editPlayer.setVisible(true);
        savePlayers(playersFileName);
        readPlayers(playersFileName);
    }//GEN-LAST:event_editJMenuItemActionPerformed

    private void statisticJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statisticJMenuItemActionPerformed
        PlayersStatistics stats = new PlayersStatistics(playersTree);
        stats.setVisible(true);
    }//GEN-LAST:event_statisticJMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
     * Method       main()
     * Description  Displays splash screen and the main GUI form.
     * Date         10/3/2023   
     * History log  10/3/2023
     * @param       args are the command line strings
     * @author      <i>Robert Zimmerman</i>
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String args[]) {
        Splash mySplash = new Splash(4000);     // duration = 4 seconds
        mySplash.showSplash();                  // show splash screen
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SitesGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JMenuItem addJMenuItem;
    private javax.swing.JButton againJButton;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JComboBox<String> countryJComboBox;
    private javax.swing.JMenuItem deleteJMenuItem;
    private javax.swing.JMenuItem editJMenuItem;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JPopupMenu.Separator fileJSeparator;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JLabel imageJLabel;
    private javax.swing.JLabel nameOfSiteJLabel;
    private javax.swing.JMenuItem newPlayersJMenuItem;
    private javax.swing.JMenuItem newSitesJMenuItem;
    private javax.swing.JButton nextJButton;
    private javax.swing.JMenu playerDataJMenu;
    private javax.swing.JMenuItem playerDetailJMenuItem;
    private javax.swing.JList<String> playerJList;
    private javax.swing.JScrollPane playerJScrollPane;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JMenuItem printPlayerJMenuItem;
    private javax.swing.JLabel questionsJLabel;
    private javax.swing.JTextField questionsJTextField;
    private javax.swing.JMenuItem quitJMenuItem;
    private javax.swing.JLabel resultJLabel;
    private javax.swing.JMenuItem searchJMenuItem;
    private javax.swing.JLabel selectJLabel;
    private javax.swing.JMenuItem siteDetailJMenuItem;
    private javax.swing.JLabel siteNameJLabel;
    private javax.swing.JMenuBar sitesJMenuBar;
    private javax.swing.JMenuItem statisticJMenuItem;
    private javax.swing.JButton submitJButton;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}
