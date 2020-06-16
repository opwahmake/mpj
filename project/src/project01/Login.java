package project01;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Login {
	public static void main(String[] args) {
		Frame F= new Frame("로그인");
		JPanel f = new JPanel();
//		JLabel JL=new JLabel();
//		f.add(JL);
//		JL.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\606b3d53635879b3ce083c5b2ca1080b"));
//		JL.setBounds(0, 0, 200, 200);
		f.setSize(200,200);
		F.setSize(200,150);
		
		f.setLayout(new FlowLayout());
		JButton btn2=new JButton("로그인");
		TextField tpw=new TextField(20);
		TextField tid=new TextField(20);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=tid.getText();
				String pw=tpw.getText();
				if(id.equals("")||pw.equals("")){
					Frame error = new Frame ("에러");
					error.setSize(300,70);
					error.setLayout(new FlowLayout());
					Button btn1 =new Button("돌아가기");
					Label erL=new Label("아이디나 비밀번호를 입력하세요.");
					error.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent e) {
							error.dispose();
						}
					});
					btn1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							error.dispose();
						}
					});
					error.add(erL);
					error.add(btn1);
					error.setVisible(true);
				}
				else { signin s=new signin(id,pw);}
				
			}	
		});
		

		F.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		f.add(tid);
		f.add(tpw);
		f.add(btn2);
		F.add(f);
		JButton btn1_1= new JButton("회원가입");
		
		btn1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp sp = new signUp();				
			}
		});
		f.add(btn1_1);
		F.setVisible(true);
}
}