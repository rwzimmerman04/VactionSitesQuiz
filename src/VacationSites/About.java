package VacationSites;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
 * Class        About.java
 * Description  A jDialog that displays information about the program, the usage
 *              of the program, and the author.
 * Project      Project 1 -- Vacation Sites Quiz
 * Platform     jdk 1.8.0_241; NetBeans IDE 18; PC Windows 10
 * Course       CS 143
 * Hours        20 minutes
 * Date         10/3/2023
  History Log   10/3/2023
 * @author	<i>Robert Zimmerman</i>
 * @version 	%1%
 * @see     	javax.swing.JDialog
 * @see         java.awt.Toolkit 
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class About extends javax.swing.JDialog {

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  About()
     * Description  Create an instance of the About jDialog, takes in a Frame
     *              as a parent Object and a boolean for the modal property
     * Date         10/3/2023
     * History Log  10/3/2023
     * @author      <i>Robert Zimmerman</i>
     * @see         java.awt.Frame
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public About(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.getRootPane().setDefaultButton(closeJButton);
        this.setLocationRelativeTo(null);   //center form
        infoJTextArea.setCaretPosition(0);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateJLabel = new javax.swing.JLabel();
        titleJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoJTextArea = new javax.swing.JTextArea();
        closeJButton = new javax.swing.JButton();
        authorJLabel = new javax.swing.JLabel();
        versionJLabel = new javax.swing.JLabel();
        copyrightJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        dateJLabel.setText("Date: 11/22/2023");

        titleJLabel.setFont(new java.awt.Font("Segoe UI", 2, 36)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(0, 102, 102));
        titleJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SiteImages/VacationSplashSmall.png"))); // NOI18N
        titleJLabel.setText("Vacation Sites Quiz");

        infoJTextArea.setEditable(false);
        infoJTextArea.setColumns(20);
        infoJTextArea.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        infoJTextArea.setLineWrap(true);
        infoJTextArea.setRows(5);
        infoJTextArea.setText("This program is used to be a quiz on vacation sites around the world. The player will be able to choose a name from a list of people stored in a file, and then select how many questions they want to a max of the number of sites in the list. The player will have the option after each question to look at the deatils of a site and have the option to print the jDialog of the player or the main form of the quiz site. Afterwards the player will have the option to play again or leave as well as the data of the players new stats will be recorded to a text file. Players new scores are only added if the new score is better than their last.  The player can always check the statistics of all player who have participated in the quiz and also see who the top three players are.");
        infoJTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(infoJTextArea);

        closeJButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        closeJButton.setText("Close");
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeJButtonActionPerformed(evt);
            }
        });

        authorJLabel.setText("Author: Robert Zimmerman");

        versionJLabel.setText("Version: 1.0.0");

        copyrightJLabel.setText("Copyright: Freeware");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(authorJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(versionJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 126, 126)
                        .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(copyrightJLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dateJLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(titleJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(authorJLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(versionJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(copyrightJLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dateJLabel)))
                    .addComponent(closeJButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       closeJButtonActionPerformed()
     * Description  Event handler to set the the visible property of
     *              the aboutJDialog to false.
     * @author      <i>Robert Zimmerman</i>
     * Date         10/3/2023
     * History Log  10/3/2023  
     * @see         java.awt.event.ActionEvent
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeJButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_closeJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorJLabel;
    private javax.swing.JButton closeJButton;
    private javax.swing.JLabel copyrightJLabel;
    private javax.swing.JLabel dateJLabel;
    private javax.swing.JTextArea infoJTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JLabel versionJLabel;
    // End of variables declaration//GEN-END:variables
}
