package project01;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class main {
	public main() {
		Frame mainF=new Frame("����ȭ��");
		mainF.setSize(300,341);
		mainF.setLayout(new FlowLayout());
		JButton btn1=new JButton("ȸ����ȸ");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signin a=new signin("");
			}
		});
		JButton btn2=new JButton("���ӵ��");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signin a = new signin(1);
			}
		});
		JButton btn3=new JButton("�̱���");
		JButton btn4=new JButton("�̱���");
		
		
		mainF.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		mainF.add(btn1);
		mainF.add(btn2);
		mainF.add(btn3);
		mainF.add(btn4);
		mainF.setVisible(true);
	}

}
