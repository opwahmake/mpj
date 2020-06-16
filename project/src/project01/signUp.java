package project01;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class signUp {
	
	public signUp() {
		Frame SF= new Frame("Sign up");
		JPanel sf=new JPanel();
		sf.setSize(200,400);
		SF.setSize(200,400);
		sf.setLayout(new FlowLayout());
		JButton signin=new JButton("회원가입");
		JButton cc=new JButton("돌아가기");
	
		JLabel lid =new JLabel("아이디");
		Label lpwd =new Label("비밀번호");
		Label lname =new Label("이름");
		Label lTnum =new Label("핸드폰 번호");
		
		TextField id=new TextField(20);
		TextField pwd=new TextField(20);
		TextField name=new TextField(20);
		TextField Tnum=new TextField(20);
		SF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				SF.dispose();
			}
		});
		SF.setResizable(false);

		sf.add(lid);		
		sf.add(id);
		sf.add(lpwd);
		sf.add(pwd);
		sf.add(lname);		
		sf.add(name);
		sf.add(lTnum);

		sf.add(Tnum);
		sf.add(signin);
		sf.add(cc);
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=id.getText();
				String spwd=pwd.getText();
				String sname=name.getText();
				String sTnum=Tnum.getText();				
				signin si=new signin(sid,spwd,sname,sTnum);
			}
		});
		cc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				SF.dispose();
			}
		});
		SF.add(sf);
		SF.setVisible(true);
	
	}


	
}
