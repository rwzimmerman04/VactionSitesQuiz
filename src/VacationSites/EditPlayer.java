package VacationSites;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
 * Class        EditPlayer.java
 * Description  A jDialog that holds input fields for editing a player in the list.
 * Project      Project 1 -- Vacation Sites Quiz
 * Platform     jdk 1.8.0_241; NetBeans IDE 18; PC Windows 10
 * Course       CS 143
 * Hours        25 minutes
 * Date         10/8/2023
 * History Log  10/8/2023
 * @author	<i>Robert Zimmerman</i>
 * @version 	%1%
 * @see     	javax.swing.JDialog
 * @see         java.awt.Toolkit 
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class EditPlayer extends javax.swing.JDialog {

    private Player myPlayer;
    private BinarySearchTree playersTree;
    
    private Color pink = Color.PINK;
    private Color white = Color.WHITE;
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  EditPlayer() - Default Constructor
     * Description  Create an instance of the EditPlayer jDialog.
     * Date         10/8/2023
     * History Log  10/8/2023
     * @author      <i>Robert Zimmerman</i>
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public EditPlayer() {
        initComponents();
        //set nameJTextField as default focus
        nameJTextField.requestFocus();
        //Set Icon
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/SiteImages/VacationSplashSmall.png"));
        
        this.setLocationRelativeTo(null);       //Centers the form on creation
        this.setResizable(false);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  AddPlayer() - Overriden Constructor
     * Description  Create an instance of the AddPlayer jDialog passing in a
     *              BST for the players, and a file path for the players.
     * Date         10/6/2023
     * History Log  10/6/2023
     * @author      <i>Robert Zimmerman</i>
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public EditPlayer( BinarySearchTree playersBST, Player currentPlayer) 
    {
        this();
        this.playersTree = playersBST;
        this.myPlayer = currentPlayer;
        
        this.setModal(true);
        nameJTextField.setText(myPlayer.getName());
        nameJTextField.setToolTipText("Enter players name. Then press Enter.");
        ageJTextField.setText(myPlayer.getAge() + "");
        ageJTextField.setToolTipText("Enter an integer value for player age."
                + " Then press Enter.");
        correctJTextField.setText(myPlayer.getCorrect() + "");
        correctJTextField.setToolTipText("Enter an integer value of correct questions,"
                + "must be less than or equal to total amount of questions."
                + " Then press Enter.");
        totalJTextField.setText(myPlayer.getTotalQuestions() + "");
        totalJTextField.setToolTipText("Enter an integer value of total questions."
                + " Then press Enter.");
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       allFieldsFilled()
     * Description  Returns boolean true if all the fields are filled entries,
     *              else it returns false.
     * Date         10/8/2023
     * History log  10/8/2023
     * @author      <i>Robert Zimmerman</i>
     * @return      boolean
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public boolean allFieldsFilled()
    {
       if(correctJTextField.getText().isEmpty())
       {
           return false;
       }
       if(ageJTextField.getText().isEmpty())
       {
           return false;
       }
       if(nameJTextField.getText().isEmpty())
       {
           return false;
       }
       if(totalJTextField.getText().isEmpty())
       {
           return false;
       }
       return true;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJLabel = new javax.swing.JLabel();
        saveJButton = new javax.swing.JButton();
        nameJLabel = new javax.swing.JLabel();
        cancelJButton = new javax.swing.JButton();
        ageJLabel = new javax.swing.JLabel();
        correctJLabel = new javax.swing.JLabel();
        totalJLabel = new javax.swing.JLabel();
        ageJTextField = new javax.swing.JTextField();
        correctJTextField = new javax.swing.JTextField();
        nameJTextField = new javax.swing.JTextField();
        totalJTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleJLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titleJLabel.setText("Edit Player Details");

        saveJButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        saveJButton.setText("Save");
        saveJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveJButtonActionPerformed(evt);
            }
        });

        nameJLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameJLabel.setText("Name: ");

        cancelJButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancelJButton.setText("Cancel");
        cancelJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelJButtonActionPerformed(evt);
            }
        });

        ageJLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ageJLabel.setText("Age:");

        correctJLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        correctJLabel.setText("Correct: ");

        totalJLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalJLabel.setText("Total:");

        ageJTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ageJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageJTextFieldActionPerformed(evt);
            }
        });
        ageJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ageJTextFieldKeyTyped(evt);
            }
        });

        correctJTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        correctJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correctJTextFieldActionPerformed(evt);
            }
        });
        correctJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                correctJTextFieldKeyTyped(evt);
            }
        });

        nameJTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJTextFieldActionPerformed(evt);
            }
        });

        totalJTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalJTextFieldActionPerformed(evt);
            }
        });
        totalJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                totalJTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(saveJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelJButton)
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameJLabel)
                                    .addComponent(ageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                    .addComponent(ageJTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(correctJLabel)
                                    .addComponent(totalJLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(correctJTextField)
                                    .addComponent(totalJTextField)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(titleJLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(titleJLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correctJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(correctJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalJLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveJButton)
                    .addComponent(cancelJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       saveJButtonActionPerformed()
     * Description  Save the new player to the file if there is not already a player
     *              with the same info,then close the form.
     * Date         10/8/2023
     * History log  10/8/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void saveJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveJButtonActionPerformed
        if(allFieldsFilled())
        {
            String name = nameJTextField.getText();
            int age = Integer.parseInt(ageJTextField.getText());
            int correct = Integer.parseInt(correctJTextField.getText());
            int total = Integer.parseInt(totalJTextField.getText());
            if(total >= correct)
            {
                playersTree.remove(myPlayer);
                Player newPlayer = new Player(name, age, correct, total);
                if(playersTree.containsPlayer(newPlayer))
                {
                    JOptionPane.showMessageDialog(null, "Player already exists in list.", 
                    "Already existing player error",JOptionPane.WARNING_MESSAGE);
                }
                else
                {
                    playersTree.insertNode(newPlayer);
                    this.setVisible(false);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Correct must be"
                    + " less than or equal to total.",
                    "Invalid value error",
                    JOptionPane.WARNING_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "All Fields must be filled.",
                "Empty field error",
                JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_saveJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       cancelJButtonActionPerformed()
     * Description  Close the form without saving any changes.
     * Date         10/8/2023
     * History log  10/8/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void cancelJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelJButtonActionPerformed
        nameJTextField.setText("");
        ageJTextField.setText("");
        correctJTextField.setText("");
        totalJTextField.setText("");
        this.setVisible(false);
    }//GEN-LAST:event_cancelJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       ageJTextFieldActionPerformed()
     * Description  Checks the information of the textfield when enter is pressed.
     * Date         10/8/2023
     * History log  10/8/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void ageJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageJTextFieldActionPerformed
        if(!Validation.isInteger(ageJTextField.getText()) ||
            (ageJTextField.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Invalid age.",
                "Invalid integer error",JOptionPane.WARNING_MESSAGE);
            ageJTextField.setBackground(pink);
        }
        else
        {
            ageJTextField.setBackground(white);
        }
    }//GEN-LAST:event_ageJTextFieldActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       ageJTextFieldKeyTyped()
     * Description  validates the Key typed to see if it is a valid character,
     *              if not consume the character and give the user a beep.
     * Date         10/8/2023
     * History log  10/8/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void ageJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageJTextFieldKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)
            || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE))
    {
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_ageJTextFieldKeyTyped
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       correctJTextFieldActionPerformed()
     * Description  Checks the information of the textfield when enter is pressed.
     * Date         10/8/2023
     * History log  10/8/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void correctJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correctJTextFieldActionPerformed
        if(!Validation.isInteger(correctJTextField.getText()) ||
            (correctJTextField.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Invalid integer.",
                "Invalid integer error",JOptionPane.WARNING_MESSAGE);
            correctJTextField.setBackground(pink);
        }
        else
        {
            correctJTextField.setBackground(white);
        }
    }//GEN-LAST:event_correctJTextFieldActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       correctJTextFieldKeyTyped()
     * Description  validates the Key typed to see if it is a valid character,
     *              if not consume the character and give the user a beep.
     * Date         10/6/2023
     * History log  10/6/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void correctJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_correctJTextFieldKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)
            || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE))
    {
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_correctJTextFieldKeyTyped
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       nameJTextFieldActionPerformed()
     * Description  Checks the information of the textfield when enter is pressed.
     * Date         10/6/2023
     * History log  10/6/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void nameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJTextFieldActionPerformed
        if(!Validation.isValidName(nameJTextField.getText()) ||
            (nameJTextField.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Invalid name.",
                "Name Error",JOptionPane.WARNING_MESSAGE);
            nameJTextField.setBackground(pink);
        }
        else
        {
            nameJTextField.setBackground(white);
        }
    }//GEN-LAST:event_nameJTextFieldActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       totalJTextFieldActionPerformed()
     * Description  Checks the information of the textfield when enter is pressed.
     * Date         10/8/2023
     * History log  10/8/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void totalJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalJTextFieldActionPerformed
        if(!Validation.isInteger(totalJTextField.getText()) ||
            (totalJTextField.getText().isEmpty()))
        {
            JOptionPane.showMessageDialog(null, "Invalid integer.",
                "Invalid integer error",JOptionPane.WARNING_MESSAGE);
            totalJTextField.setBackground(pink);
        }
        else
        {
            totalJTextField.setBackground(white);
        }
    }//GEN-LAST:event_totalJTextFieldActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       totalJTextFieldKeyTyped()
     * Description  validates the Key typed to see if it is a valid character,
     *              if not consume the character and give the user a beep.
     * Date         10/8/2023
     * History log  10/8/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.KeyEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void totalJTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalJTextFieldKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)
            || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE))
    {
        getToolkit().beep();
        evt.consume();
        }
    }//GEN-LAST:event_totalJTextFieldKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ageJLabel;
    private javax.swing.JTextField ageJTextField;
    private javax.swing.JButton cancelJButton;
    private javax.swing.JLabel correctJLabel;
    private javax.swing.JTextField correctJTextField;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JButton saveJButton;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JLabel totalJLabel;
    private javax.swing.JTextField totalJTextField;
    // End of variables declaration//GEN-END:variables
}
