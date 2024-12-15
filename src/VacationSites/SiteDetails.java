package VacationSites;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
 * Class        SiteDetails.java
 * Description  A jDialog that displays information about the current site.
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
public class SiteDetails extends javax.swing.JDialog {
    
    Site mySite;
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  SiteDetails() - default Constructor
     * Description  Create an instance of the SiteDetails JDialog
     * Date         10/4/2023
     * History Log  10/4/2023, 10/5/2023
     * @author      <i>Robert Zimmerman</i>
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public SiteDetails() {
        initComponents();
        this.getRootPane().setDefaultButton(quitJButton);
        //Set Icon
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/SiteImages/VacationSplashSmall.png"));
        
        this.setLocationRelativeTo(null);       //Centers the form on creation
        this.setResizable(false);
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  SiteDetails() - overloaded Constructor
     * Description  Create an instance of the SiteDetails JDialog
     * Date         10/4/2023
     * History Log  10/4/2023, 10/5/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       currentSite Site
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public SiteDetails(Site currentSite)
    {
        this();     //Call default Constructor
        mySite = new Site(currentSite);
        String name = mySite.getName();
        this.setTitle("Details and Country Flag of " + name);
        this.setModal(true);
        
        siteNameJLabel.setText(name);
        setPicture(siteFlagJLabel, "src/SiteImages/", name);
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
        String imagePath = folderIn + nameIn + ".gif";
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
        try
        {
            StringBuilder outputBuffer = new StringBuilder();
            String textPath = "src/Data/" + mySite.getName() + ".txt";
            File textFile = new File(textPath);
            Scanner textScanner = new Scanner(textFile);
            String info = "";
            while(textScanner.hasNextLine())
            {
                info += textScanner.nextLine();
            }
            //Append the text file contents to buffer
            outputBuffer.append(info);
            outputBuffer.append("\n\n");
            //Append the sites name to buffer
            outputBuffer.append("Name: " + mySite.getName() + "\n");
            //Append the sites Country to buffer
            outputBuffer.append("Country: " + mySite.getCountry() + "\n");
            //Append the sites Capital to buffer
            outputBuffer.append("Capital: " + mySite.getCapital() + "\n");
            //Append the sites Population to buffer
            outputBuffer.append("Population: " + mySite.getPopulation() + " million\n");
            //Append the sites Area to buffer
            outputBuffer.append("Area: " + mySite.getArea() + " Square Miles\n");
            siteInfoJTextArea.setText(outputBuffer.toString()); 
        }
        catch(FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, mySite.getName() + ".txt could not be found",
                    "File Not Found Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        siteNameJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        siteInfoJTextArea = new javax.swing.JTextArea();
        quitJButton = new javax.swing.JButton();
        siteFlagJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        siteNameJLabel.setFont(new java.awt.Font("Segoe Print", 0, 24)); // NOI18N
        siteNameJLabel.setForeground(new java.awt.Color(204, 0, 255));

        siteInfoJTextArea.setEditable(false);
        siteInfoJTextArea.setColumns(20);
        siteInfoJTextArea.setLineWrap(true);
        siteInfoJTextArea.setRows(5);
        siteInfoJTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(siteInfoJTextArea);

        quitJButton.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        quitJButton.setForeground(new java.awt.Color(204, 0, 255));
        quitJButton.setText("Quit");
        quitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(quitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(siteNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(siteFlagJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(siteNameJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(siteFlagJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       quitJButtonActionPerformed()
     * Description  Handles closing the site details form.
     * @author      <i>Robert Zimmerman</i>
     * @param       evt ActionEvent
     * Date         10/5/2023
     * History Log  10/5/2023
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void quitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitJButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_quitJButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton quitJButton;
    private javax.swing.JLabel siteFlagJLabel;
    private javax.swing.JTextArea siteInfoJTextArea;
    private javax.swing.JLabel siteNameJLabel;
    // End of variables declaration//GEN-END:variables
}
