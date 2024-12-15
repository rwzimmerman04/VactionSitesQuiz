package VacationSites;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
 * Class        PlayerDetails.java
 * Description  A jDialog that displays information about the current player.
 * Project      Project 1 -- Vacation Sites Quiz
 * Platform     jdk 1.8.0_241; NetBeans IDE 18; PC Windows 10
 * Course       CS 143
 * Hours        20 minutes
 * Date         10/4/2023
 * History Log  10/4/2023, 10/5/2023
 * @author	<i>Robert Zimmerman</i>
 * @version 	%1%
 * @see     	javax.swing.JDialog
 * @see         java.awt.Toolkit 
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class PlayerDetails extends javax.swing.JDialog {
    
    private Player myPlayer;

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  PlayerDetails() - Default Constructor
     * Description  Create an instance of the PlayerDetails jDialog.
     * Date         10/4/2023
     * History Log  10/4/2023, 10/5/2023
     * @author      <i>Robert Zimmerman</i>
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public PlayerDetails() {
        initComponents();
        //set quitJButton as defaut focus
        this.getRootPane().setDefaultButton(quitJButton);
        //Set Icon
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/SiteImages/VacationSplashSmall.png"));
        
        this.setLocationRelativeTo(null);       //Centers the form on creation
        this.setResizable(false);
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  PlayerDetails() - Overidden Constructor
     * Description  Create an instance of the PlayerDetails jDialog.
     * Date         10/4/2023
     * History Log  10/4/2023, 10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       currentPlayer Player
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public PlayerDetails(Player currentPlayer)
    {
        this();     //Call default constructor
        myPlayer = new Player(currentPlayer);
        String name = myPlayer.getName();
        this.setTitle("Details and Picture of " + name);
        this.setModal(true);
        setPicture(playerImageJLabel, "src/PlayerImages/", name);
        displayInfo();
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       setPicture()
     * Description  Sets the players picture to the playerImageJLabel
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       labelIn JLabel
     * @param       folderIn String
     * @param       nameIn String
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setPicture(JLabel labelIn, String folderIn, String nameIn)
    {
        String imagePath = folderIn + nameIn + ".png";
        labelIn.setIcon(new ImageIcon(imagePath));
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       displayInfo()
     * Description  Appends player info to StringBuilder then adds to 
     *              playerDetailsJTextArea.
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void displayInfo()
    {
        StringBuilder outputBuffer = new StringBuilder();
        System.out.println("PLayer is: " + myPlayer );
        outputBuffer.append("Player: " + myPlayer.getName() + "\n");
        outputBuffer.append("Age of Player: " + myPlayer.getAge() + "\n");
        outputBuffer.append("Correct Questions: " + myPlayer.getCorrect() + "\n");
        outputBuffer.append("Total Questions: " + myPlayer.getTotalQuestions() + "\n\n");
        outputBuffer.append("Percent Correct: " + myPlayer.calculatePercent() + "%");
        
        playerDetailsJTextArea.setText(outputBuffer.toString());
        
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getMyPlayer()
     * Description  Returns myPlayer field
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @return      Player
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Player getMyPlayer() 
    {
        return myPlayer;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       setMyPlayer()
     * Description  Sets myPlayer field
     * Date         10/5/2023
     * History log  10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       myPlayer Player
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setMyPlayer(Player myPlayer) 
    {
        this.myPlayer = myPlayer;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        playerDetailsJTextArea = new javax.swing.JTextArea();
        quitJButton = new javax.swing.JButton();
        playerImageJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Player Details"); // NOI18N

        playerDetailsJTextArea.setEditable(false);
        playerDetailsJTextArea.setColumns(20);
        playerDetailsJTextArea.setRows(5);
        jScrollPane1.setViewportView(playerDetailsJTextArea);

        quitJButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        quitJButton.setText("Quit");
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });

        playerImageJLabel.setPreferredSize(new java.awt.Dimension(165, 165));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(playerImageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(quitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(playerImageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(quitJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       quitJButtonActionPerformed()
     * Description  Handles closing the player details form.
     * @author      <i>Robert Zimmerman</i>
     * @param       evt ActionEvent
     * Date         10/5/2023
     * History Log  10/5/2023
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJButtonActionPerformed
        this.setVisible(false);     //Set from to not visible
    }//GEN-LAST:event_quitJButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea playerDetailsJTextArea;
    private javax.swing.JLabel playerImageJLabel;
    private javax.swing.JButton quitJButton;
    // End of variables declaration//GEN-END:variables
}
