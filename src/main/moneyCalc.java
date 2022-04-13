package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class moneyCalc extends JFrame {
   
   private static double WON_AMERICA = 1231.10;
   private static double WON_JAPAN = 980.21;
   
   private JPanel contentPane;
   private JTextField textField;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
            	moneyCalc frame = new moneyCalc();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public moneyCalc() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(2000, 100, 777, 350);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      textField = new JTextField();
      textField.setBounds(59, 136, 213, 36);
      contentPane.add(textField);
      textField.setColumns(10);
      
      //String[] nation = {"달러", "엔화"};
      
      JComboBox<String> comboBox = new JComboBox<String>();
      comboBox.setModel(new DefaultComboBoxModel(new String[] {"달러", "엔화"}));
      comboBox.setFont(new Font("Dialog", Font.BOLD, 25));
      comboBox.setBounds(284, 136, 125, 36);
      contentPane.add(comboBox);
      
      JLabel lblNewLabel = new JLabel("");
      lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setBounds(427, 136, 195, 27);
      contentPane.add(lblNewLabel);
      
      JLabel lblNewLabel_1 = new JLabel("원");
      lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 25));
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1.setBounds(634, 136, 64, 27);
      contentPane.add(lblNewLabel_1);
      
      JLabel lblNewLabel_2 = new JLabel("환 율 계 산 기");
      lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 40));
      lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_2.setBounds(59, 22, 639, 50);
      contentPane.add(lblNewLabel_2);
      
      JButton btnNewButton = new JButton("변환하기");
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            int inputDollor = Integer.parseInt(textField.getText());
            System.out.println(inputDollor);
            
            String nationContent = comboBox.getSelectedItem().toString();
            System.out.println(nationContent);
            
            if(nationContent.equals("달러")) {
               double exchangeMoney = inputDollor * WON_AMERICA;
               double resultMoney = Math.round(exchangeMoney * 100)/100.0;
               System.out.printf("%.2f", resultMoney);
               lblNewLabel.setText(Double.toString(resultMoney));
            }else if(nationContent.equals("엔화")) {
               double exchangeMoney = inputDollor * WON_JAPAN;
               double resultMoney = Math.round(exchangeMoney * 100)/100.0;
               System.out.printf("%.2f", resultMoney);
               lblNewLabel.setText(Double.toString(resultMoney));
            }
            
         }
      });
      btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
      btnNewButton.setBounds(280, 232, 173, 36);
      contentPane.add(btnNewButton);
   }
}
