package VacationSites;

import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*<pre>
 * Class        PlayersStatistics.java
 * Description  A jDialog that displays information about the statistics of all
 *              participating players, and the top three players.
 * Project      Project 1 -- Vacation Sites Quiz
 * Platform     jdk 1.8.0_241; NetBeans IDE 18; PC Windows 10
 * Course       CS 143
 * Hours        1 hour 10 minutes
 * Date         10/10/2023
 * History Log  10/9/2023, 10/10/2023
 * @author	<i>Robert Zimmerman</i>
 * @version 	%1%
 * @see     	javax.swing.JDialog
 * @see         java.awt.Toolkit 
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class PlayersStatistics extends javax.swing.JDialog {
    private LinkedList<Player> myPlayers = new LinkedList<>();
    private float percentMean;              //Average(Mean) percent
    private float percentMedian;            //Median of percents
    private float percentSum;               //Sum of all percents
    private float percentStdDeviation;      //Standard Deviation of all percents
    
    private StringBuilder statsBuffer = new StringBuilder();        //Stats info
    private StringBuilder topThreeBuffer = new StringBuilder();     //Top-3 info
    
    private LinkedList<Player> topThreeList = new LinkedList<>();
    
    //Formats the float from calculate percent to teo decimal places
    private static final DecimalFormat percentage = new DecimalFormat("00.00");
    private static final DecimalFormat deviation = new DecimalFormat("0.000");
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  PlayersStatistics() - Default Constructor
     * Description  Create an instance of the PlayersStatistics jDialog.
     * Date         10/10/2023
     * History Log  10/9/2023, 10/10/2023
     * @author      <i>Robert Zimmerman</i>
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public PlayersStatistics() 
    {
        initComponents();
        //Set default to statTypeJButton
        statTypeJButton.requestFocus();
        //Set modal
        this.setModal(true);
        //Set icon
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/SiteImages/VacationSplashSmall.png"));
        
        this.setLocationRelativeTo(null);       //Centers the form on creation
        this.setResizable(false);
        
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  PlayersStatistics() - Overidden Constructor
     * Description  Create an instance of the PlayersStatistics jDialog.
     * Date         10/10/2023
     * History Log  10/9/2023, 10/10/2023
     * @author      <i>Robert Zimmerman</i>
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public PlayersStatistics(BinarySearchTree playersTree)
    {
        this();
        bstToList(playersTree.getRoot());
        percentMean = calculateMean();
        percentMedian = calculateMedian();
        percentStdDeviation = calculateStdDeviation();
        getTopThree();
        buildStatBuffer();
        buildTopThreeBuffer();
        statisticsJTextArea.setText(statsBuffer.toString());
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       calculateMean()
     * Description  Calculate the mean of participating players.
     * Date         10/9/2023
     * History log  10/9/2023, 10/10/2023
     * @author      <i>Robert Zimmerman</i>
     * @return      float
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public float calculateMean()
    {
        percentSum = 0.0f;                                  //Set sum to 0
        float numberOfPlayers = 0.0f;                       //Size of players as float
        for(int i = 0; i < myPlayers.size(); i++)
        {
            Player player = myPlayers.get(i);   //Retrieve player
            if(player.getTotalQuestions() != 0)     //Evaluate participation
            {
                percentSum += player.calculatePercent();    //Add player percent to sum
                numberOfPlayers += 1.0;
            }
        }
        if(numberOfPlayers == 0.0)
        {
            return 0.0f;
        }
        float mean = ((float)percentSum / (float)numberOfPlayers);  //Calculate mean
        return Float.parseFloat(percentage.format(mean));
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       calculateMedian()
     * Description  Calculate the median of participating players.
     * Date         10/9/2023
     * History log  10/9/2023, 10/10/2023
     * @author      <i>Robert Zimmerman</i>
     * @return      float
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public float calculateMedian()
    {
        ArrayList<Float> percentsList = new ArrayList<>();  //ArrayList of percents
        for(int i = 0; i < myPlayers.size(); i++)            //Look through players
        {
            Player player = myPlayers.get(i);
            if(player.getTotalQuestions() != 0)
            {
                percentsList.add(player.calculatePercent());    //Add percents to list
            }
        }
        if(percentsList.size() == 0)
        {
            return 0.0f;
        }
        Collections.sort(percentsList, new FloatComparator());  //Sort the list
        return percentsList.get((percentsList.size() / 2));          //Retrieve the median
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       calculateStdDeviation()
     * Description  Calculate the standard deviation of participating players.
     * Date         10/9/2023
     * History log  10/9/2023, 10/10/2023
     * @author      <i>Robert Zimmerman</i>
     * @return      float
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public float calculateStdDeviation()
    {
        //STD-DEV. == SQRT( (SUM OF ALL - AVERAGE(MEAN)) / (SIZE OF SAMPLE))
        
        if(myPlayers.size() > 0)
        {
            float radicand = (percentSum - percentMean) / (myPlayers.size());
            float stdDeviation = (float)Math.sqrt(radicand);
            return Float.parseFloat(deviation.format(stdDeviation));
        }
        return 0.0f;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getTopThree()
     * Description  Add the top three players to a list.
     * Date         10/9/2023
     * History log  10/9/2023, 10/10/2023
     * @author      <i>Robert Zimmerman</i>
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void getTopThree() 
    {
        boolean foundThree = false;
        int highestIndex = 0, count = 0;
        while(!foundThree)
        {
            float highest = 0.0f;
            Player highestPlayer = new Player();
            for(int i = 0; i < myPlayers.size(); i++)
            {
                Player player = myPlayers.get(i);
                System.out.println(player);
                if((player.calculatePercent() > highest) && 
                        (player.getTotalQuestions() != 0))
                {
                    highestPlayer = player;
                    highest = player.calculatePercent();
                    highestIndex = i;
                }
            }
            
            System.out.println(count);
            if((count == 3) || highest == 0.0)
            {
                foundThree = true;
                break;
            }
            topThreeList.add(highestPlayer);
            myPlayers.remove(highestPlayer);
            count++;
        }
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       buildStatBuffer()
     * Description  Create the Stringbuider for the general stats of all
     *              participating players.
     * Date         10/9/2023
     * History log  10/9/2023
     * @author      <i>Robert Zimmerman</i>
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void buildStatBuffer()
    {
        statsBuffer.replace(0, WIDTH, "");
        String statTempString = 
                "Statistics of all particpating Players: \n"
                + "Mean:               " + percentMean + "%\n"
                + "Median:             " + percentMedian + "%\n"
                + "Standard Deviation: " + percentStdDeviation + "%\n";
        statsBuffer.append(statTempString);
        
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       buildStatBuffer()
     * Description  Create the Stringbuider for the top three players of all
     *              participating players.
     * Date         10/9/2023
     * History log  10/9/2023
     * @author      <i>Robert Zimmerman</i>
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void buildTopThreeBuffer()
    {
        String topThreeTempString = "";
        topThreeBuffer.replace(0, WIDTH, "");
        if(topThreeList.size() == 3)
        {
            Player p1 = topThreeList.get(0);
            Player p2 = topThreeList.get(1);
            Player p3 = topThreeList.get(2);
            topThreeTempString = 
                "Player 1 info: \n"
                + "Name: " + p1.getName() + "\n"
                + "Age: " + p1.getAge() + "\n"
                + "Correct: " + p1.getCorrect() + "\n"
                + "Total: " + p1.getTotalQuestions() + "\n"
                + "Percent Correct: " + p1.calculatePercent() + "\n\n"
                + "Player 2 info: \n"
                + "Name: " + p2.getName() + "\n"
                + "Age: " + p2.getAge() + "\n"
                + "Correct: " + p2.getCorrect() + "\n"
                + "Total: " + p2.getTotalQuestions() + "\n"
                + "Percent Correct: " + p2.calculatePercent() + "\n\n"
                + "Player 3 info: \n"
                + "Name: " + p3.getName() + "\n"
                + "Age: " + p3.getAge() + "\n"
                + "Correct: " + p3.getCorrect() + "\n"
                + "Total: " + p3.getTotalQuestions() + "\n"
                + "Percent Correct: " + p3.calculatePercent() + "\n\n";
        } 
        else if(topThreeList.size() == 2) 
        {
            Player p1 = topThreeList.get(0);
            Player p2 = topThreeList.get(1);
            topThreeTempString = 
                  "Player 1 info: \n"
                + "Name: " + p1.getName() + "\n"
                + "Age: " + p1.getAge() + "\n"
                + "Correct: " + p1.getCorrect() + "\n"
                + "Total: " + p1.getTotalQuestions() + "\n"
                + "Percent Correct: " + p1.calculatePercent() + "\n\n"
                + "Player 2 info: \n"
                + "Name: " + p2.getName() + "\n"
                + "Age: " + p2.getAge() + "\n"
                + "Correct: " + p2.getCorrect() + "\n"
                + "Total: " + p2.getTotalQuestions() + "\n"
                + "Percent Correct: " + p2.calculatePercent() + "\n\n"
                + "Player 3 info: No valid participant.";
        }
        else if(topThreeList.size() == 1)
        {
            Player p1 = topThreeList.get(0);
            topThreeTempString = 
                  "Player 1 info: \n"
                + "Name: " + p1.getName() + "\n"
                + "Age: " + p1.getAge() + "\n"
                + "Correct: " + p1.getCorrect() + "\n"
                + "Total: " + p1.getTotalQuestions() + "\n"
                + "Percent Correct: " + p1.calculatePercent() + "\n\n"
                + "Player 2 info: No valid participant. \n\n"
                + "Player 3 info: No valid participant.";
        }
        else
        {
            topThreeTempString = 
                  "Player 1 info: No valid Participant. \n\n"
                + "Player 2 info: No valid participant. \n\n"
                + "Player 3 info: No valid participant.";
        }
        
        topThreeBuffer.append(topThreeTempString);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       bstToList()
     * Description  Copy all the player objects in the BST to a list.
     * Date         10/9/2023
     * History log  10/9/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       node BinarySearchTreeNode
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void bstToList(BinarySearchTreeNode node)
    {
        if(node != null )
        {
            myPlayers.add(node.data);
        }
        if(node.left != null)
        {
            bstToList(node.left);
        }
        if(node.right != null)
        {
            bstToList(node.right);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        statisticsJTextArea = new javax.swing.JTextArea();
        closeJButton = new javax.swing.JButton();
        statTypeJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleJLabel.setFont(new java.awt.Font("Segoe Print", 0, 18)); // NOI18N
        titleJLabel.setText("Players Statistics");
        titleJLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        statisticsJTextArea.setEditable(false);
        statisticsJTextArea.setBackground(new java.awt.Color(255, 255, 255));
        statisticsJTextArea.setColumns(20);
        statisticsJTextArea.setRows(5);
        statisticsJTextArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(statisticsJTextArea);

        closeJButton.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        closeJButton.setText("Close");
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeJButtonActionPerformed(evt);
            }
        });

        statTypeJButton.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        statTypeJButton.setText("Top Three");
        statTypeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statTypeJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(98, Short.MAX_VALUE)
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(statTypeJButton)
                        .addGap(27, 27, 27)
                        .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statTypeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       statTypeJButtonActionPerformed()
     * Description  Toggles if the the stats textArea shows the general stats or
     *              the top three players.
     * Date         10/9/2023
     * History log  10/9/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void statTypeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statTypeJButtonActionPerformed
        if(statTypeJButton.getText().toString().equals("Top Three"))
        {
            statisticsJTextArea.setText(topThreeBuffer.toString());
            statTypeJButton.setText("Stats");
        }
        else
        {
            statisticsJTextArea.setText(statsBuffer.toString());
            statTypeJButton.setText("Top Three");
        }
    }//GEN-LAST:event_statTypeJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       closeJButtonActionPerformed()
     * Description  Close the JDialog.
     * Date         10/9/2023
     * History log  10/9/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeJButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_closeJButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
     * Inner-Class  FloatComparator.java
     * Description  Defines the FloatComparator comparator.
     * Project      Project 1 -- Vacation Sites Quiz
     * Platform     jdk 1.8.0_241; NetBeans IDE 18; PC Windows 10
     * Course       CS 143
     * Hours        15 minutes
     * Date         10/9/2023
     * History Log  10/9/2023
     * @author      <i>Robert Zimmerman</i>
     * @version     %1%
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    static class FloatComparator implements Comparator<Float>
    {
        
        /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       compare()
     * Description  Sets the comparator for float values
     * Date         10/9/2023
     * History log  10/9/2023
     * @author      <i>Robert Zimmerman</i>
     * @param       float1 Float
     * @param       float2 Float
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
        @Override
        public int compare(Float float1, Float float2) {
            if(float1 < float2)
            {
                return -1;
            }
            else if(float2 > float1)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton statTypeJButton;
    private javax.swing.JTextArea statisticsJTextArea;
    private javax.swing.JLabel titleJLabel;
    // End of variables declaration//GEN-END:variables
}
