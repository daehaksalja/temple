package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.MySQLDB;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Min extends JFrame {

	private JPanel contentPane;
	private JTextField idInputField;
	private JPasswordField passwordInputField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Min frame = new Min();
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
	public Min() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idInputField = new JTextField();
		idInputField.setBounds(151, 91, 135, 29);
		contentPane.add(idInputField);
		idInputField.setColumns(10);
		
		JLabel label = new JLabel("아이디 :");
		label.setBounds(103, 96, 59, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("비밀번호:");
		label_1.setBounds(91, 137, 59, 18);
		contentPane.add(label_1);
		
		JButton button = new JButton("로그인하기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loginID= idInputField.getText();
	            String loginPW = passwordInputField.getText();
	               System.out.println("id:"+loginID);
	               System.out.println("pw:"+loginPW);
	               
	               MySQLDB db = new MySQLDB();
	               int loginResult = db.login(loginID, loginPW);
	               if(loginResult == 1000) {
	            	   System.out.println("로그인성공했으니 다른창을 띄워주세요");
	            	   moneyCalc lf = new moneyCalc();
	            	   lf.setVisible(true);
	            	   setVisible(false);
	               }else {
	            	   JOptionPane.showMessageDialog(contentPane, "아디나 비번이 틀립니다", "불가", JOptionPane.WARNING_MESSAGE);
	               }
			}
		});
		button.setBounds(161, 170, 105, 28);
		contentPane.add(button);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLogin.setFont(new Font("Abyssinica SIL", Font.BOLD, 43));
		lblLogin.setBounds(151, 12, 142, 67);
		contentPane.add(lblLogin);
		
		JButton button_1 = new JButton("회원가입하기");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Regist rf= new Regist();
	            rf.setVisible(true);
	            setVisible(false);
			}
		});
		button_1.setBounds(12, 223, 105, 28);
		contentPane.add(button_1);
		
		JLabel lblNaver = new JLabel("NAVER");
		lblNaver.setForeground(new Color(51, 204, 0));
		lblNaver.setFont(new Font("Noto Sans CJK KR Black", Font.BOLD, 23));
		lblNaver.setBounds(12, 12, 94, 29);
		contentPane.add(lblNaver);
		
		passwordInputField = new JPasswordField();
		passwordInputField.setBounds(151, 135, 135, 29);
		contentPane.add(passwordInputField);
	}
}
