/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoegame;

/**
 *
 * @author Windows User
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGame extends JPanel {
    JButton buttons[] = new JButton[9]; 
    int alt = 0;
    public TicTacToeGame()
    {
      setLayout(new GridLayout(3,3));
      initializebuttons(); 
      
    }
    
    public void initializebuttons()
    {
        for(int i = 0;i<= 8;i++)
          
            {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new buttonListener());
            
            add(buttons[i]);
                                         
        }
    }
    public void resetButtons()
    {
        for(int i = 0; i <= 8; i++)
        {
            buttons[i].setText("");
        }
    }
    private class buttonListener implements ActionListener
    {
       
        public void actionPerformed(ActionEvent e) 
        {
            
            JButton b = (JButton)e.getSource();
            Icon ico=new ImageIcon(toString()+".GIF");
            b.setBackground(Color.BLACK);
            b.setIcon(ico);
            b.setEnabled(false);
            if(alt%2 == 0){
                b.setText("X");
               b.setBackground(Color.GREEN);
        }
               else{
                b.setText("O");
                b.setBackground(Color.BLUE);
                
        }
            if(checkForWin() == true)
            {
                JTextField textField = new JTextField(10);
               int result= JOptionPane.showConfirmDialog(null, "YOU ARE A WINNER,CONGRATULATIONS");
               if ( result==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, textField.getText());
        }
                resetButtons();
            }
                
            alt++;
            
        }
        
        public boolean checkForWin()
        {
       
            if( checkAdjacent(0,1) && checkAdjacent(1,2) )  
                return true;
            else if( checkAdjacent(3,4) && checkAdjacent(4,5) )
                return true;
            else if ( checkAdjacent(6,7) && checkAdjacent(7,8))
                return true;
           
            else if ( checkAdjacent(0,3) && checkAdjacent(3,6))
                return true;  
            else if ( checkAdjacent(1,4) && checkAdjacent(4,7))
                return true;
            else if ( checkAdjacent(2,5) && checkAdjacent(5,8))
                return true;
            
            else if ( checkAdjacent(0,4) && checkAdjacent(4,8))
                return true;  
            else if ( checkAdjacent(2,4) && checkAdjacent(4,6))
                return true;
            else 
                return false;
            
            
        }
        
        public boolean checkAdjacent(int a, int b)
        {
            if ( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("") )
                return true;
            else
                return false;
        }
        
    }
    
    public static void main(String[] args) 
    {
        JFrame f= new JFrame("Tic-Tac-Toe Game");
        f.setTitle("Tic Tac Toe!");
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane();f.add(new TicTacToeGame());
        f.setBounds(400,400,300,300);
    }
}



