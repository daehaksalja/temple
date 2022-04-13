package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.MySQLDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Regist extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField passwordField;
	private JPasswordField rePasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Regist frame = new Regist();
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
	public Regist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNaver = new JLabel("NAVER");
		lblNaver.setForeground(new Color(51, 204, 0));
		lblNaver.setFont(new Font("Noto Sans CJK KR Black", Font.BOLD, 23));
		lblNaver.setBounds(12, 12, 94, 29);
		contentPane.add(lblNaver);
		
		
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setForeground(new Color(51, 204, 51));
		lblNewLabel.setFont(new Font("Noto Sans CJK HK", Font.BOLD, 19));
		lblNewLabel.setBounds(173, 14, 80, 29);
		contentPane.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setFont(new Font("Dialog", Font.ITALIC, 12));
		idField.setBounds(190, 91, 114, 22);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel label = new JLabel("아이디:");
		label.setFont(new Font("Noto Serif CJK TC SemiBold", Font.PLAIN, 12));
		label.setBounds(106, 93, 59, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("비밀번호:");
		label_1.setFont(new Font("Noto Serif CJK KR", Font.BOLD, 12));
		label_1.setBounds(106, 135, 59, 18);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("비밀번호 확인:");
		label_2.setFont(new Font("Noto Serif CJK KR", Font.PLAIN, 10));
		label_2.setBounds(106, 167, 94, 18);
		contentPane.add(label_2);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean idFix = false;
	        	 boolean pwFix = false;
	        	 boolean idEng = false;
	        
	         String id= idField.getText();
	         String resultID = id.trim().replaceAll(" ", "");
	         int resultLeng = resultID.length();
	         String onlyEng = resultID.replaceAll("[^a-zA-Z0-9]","");
	         
	         
	         System.out.println(resultID);
	         System.out.println("아이디의 길이:"+resultLeng);
	         MySQLDB db1 = new MySQLDB();
	         boolean idDup = db1.idDuplicate(onlyEng);
	         
	         
	         
	         
	         if(onlyEng.length()>0) {
	             System.out.println("영어로만 이루어진 올바른 아이디입니다");
	             System.out.println("디비에 저장될 아이디"+onlyEng);
	             idEng=true;
	          }else {
	             System.out.println("영아가 아닌 다른문자가 있다");
	             JOptionPane.showMessageDialog(contentPane, "영어로만 입력합시다", "경고", JOptionPane.WARNING_MESSAGE);
	          }
	         
	         if(id == null || id.equals("")) {
	        	 System.out.println("아이디가 비었습니다");
	        	 JOptionPane.showMessageDialog(contentPane, "아이디가 비었다", "회원가입불가", JOptionPane.WARNING_MESSAGE);
	         }else {
	        	 String resultPW = id.trim().replaceAll(" ", "");
	        	 idFix = true;
	         }
	         if(idDup == false){
	        	 System.out.println("사용가능한 아이디당");
	        	 
	         }else {
	        	 System.out.println("좆중복 민주화");
	        	 JOptionPane.showMessageDialog(contentPane, "이미있는 아이디댜", "회원가입불가", JOptionPane.WARNING_MESSAGE);
	         }
	         String pw = passwordField.getText();
	         String rePW = rePasswordField.getText();
	         
	         if(pw==null || pw.equals("")) {
	        	 System.out.println("비밀번호가 비었읍니다");
	        	 JOptionPane.showMessageDialog(contentPane, "비밀번호를 입력하셔야합니다", "회원가입불가", JOptionPane.WARNING_MESSAGE);
	         }else {
	        	       String resultPW = pw.trim().replaceAll(" ", "");
	        		      if(resultPW.equals(rePW)) {
	        		         System.out.println("비밀번호가 일치합니다");
	        		         pwFix = true;
	        	        }else {
	        	        	passwordField.setText("");
	        	        	rePasswordField.setText("");
	        	            System.out.println("비밀번호가 일치하지않습니다");
	        	            JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치하지않습니다", "회원가입불가", JOptionPane.WARNING_MESSAGE);
	                     }
	         }
	         
	         if(idFix == true && pwFix == true && idDup == false && idEng) {
	        	 MySQLDB db = new MySQLDB();
	        	 db.insert(onlyEng, pw);
	        	 System.out.println("insert 완료");
	        	 setVisible(false);
	        	 Min main = new Min();
	        	 main.setVisible(true);
	        	 
	         }else {
	        	 System.out.println("회원가입불가");
	        	 JOptionPane.showMessageDialog(contentPane, "아이디와 비번을 올바르게입력해주세요", "회원가입불가", JOptionPane.WARNING_MESSAGE);
	         }
	        	 
	            System.out.println("id:"+id);
	            System.out.println("pw:"+pw);
			}
		});
		btnNewButton.setBounds(321, 183, 105, 28);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("돌아가기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Min main = new Min();
		            main.setVisible(true);
		            setVisible(false);
			}
		});
		button.setBounds(321, 223, 105, 28);
		contentPane.add(button);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(190, 133, 114, 22);
		contentPane.add(passwordField);
		
		rePasswordField = new JPasswordField();
		rePasswordField.setBounds(190, 165, 114, 22);
		contentPane.add(rePasswordField);
	}
}
