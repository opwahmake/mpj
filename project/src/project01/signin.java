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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class signin{
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static String user = "kosea";
	static String password = "kosea2019a";
	static Connection con;
	static Statement stmt;
	static ResultSet rs;
	
	
	public signin(int test) {//��� ��ȸ ������ ����
		try {
			connDB();
			JFrame JF= new JFrame("���� ���");
			JF.setLayout(new FlowLayout());
			JF.setSize(200,300);
			JButton btn1=new JButton("���");
			JLabel JL1=new JLabel("���� ���");
			JLabel JL2=new JLabel("���� �̸�");
			JLabel JL3=new JLabel("�ο�");
			JLabel JL4=new JLabel("����ݾ� �Ѿ�");
			TextField TF1=new TextField(20);
			TextField TF2=new TextField(20);
			TextField TF3=new TextField(20);
			TextField TF4=new TextField(20);
			JF.add(JL1);
			JF.add(TF1);
			JF.add(JL2);
			JF.add(TF2);
			JF.add(JL3);
			JF.add(TF3);
			JF.add(JL4);
			JF.add(TF4);
			JF.add(btn1);
			
			JF.setVisible(true);
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String intro=TF1.getText();
					String member=TF2.getText();
					String ps=TF3.getText();
					String debt=TF4.getText();
					String query="insert into meeting (intro,member,ps,debt)values('"+intro+"','"+member+"','"+ps+"','"+debt+"')";
					System.out.println(query);
					try {
						boolean b = stmt.execute(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println(e1);
					}
				}
			});
//			rs=stmt.executeQuery(query);
			
						
		} catch (Exception e) {
			System.out.print(e);
		}

	}

	
	

	
	public signin(String test) {//��� ��ȸ ������ ����
		try {
			connDB();
			JTable table;
			JScrollPane scrollPane;
			JFrame f =new JFrame("test");
			JPanel j =new JPanel();
			JButton jb=new JButton("��ȸ");
//			f.setLayout(null);
			f.setSize(500,500);
			String query="select * from sign";
			rs=stmt.executeQuery(query);
			rs.first();
			
			
			String colName[]= {"���̵�","����","�ڵ���","��������"};
			DefaultTableModel model=new DefaultTableModel(colName,0);
			jb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						while(rs.next()) {
							String a=rs.getString("id");
							String b=rs.getString("name");
							String c=rs.getString("tel_num");
							String d=rs.getString("dat");
						model.addRow(new Object[] {a,b,c,d});
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
//			while(rs.next()) {
//				String a=rs.getString("id");
//				String b=rs.getString("name");
//				String c=rs.getString("tel_num");
//				String d=rs.getString("dat");
//			model.addRow(new Object[] {a,b,c,d});
//			}
			j.add(jb);
			f.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			table=new JTable(model);
			scrollPane=new JScrollPane(table);
			scrollPane.setSize(400,400);
			j.setSize(500,500);
			j.add(scrollPane);
			f.add(j);
			f.setVisible(true);
			
						
		} catch (Exception e) {
			System.out.print(e);
		}

	}

	
	
	public signin(String id,String pw) {

		try {
			connDB();
			
			String query = "select id,pwd from sign where id = '"+id+"' and pwd = '"+pw+"'";
//			boolean b = stmt.execute(query);
			System.out.println(query); 
			rs = stmt.executeQuery(query);
			rs.last();
			if(rs.getRow()==1) {main n=new main();}
			else {
				Frame error = new Frame ("����");
				error.setSize(300,70);
				error.setLayout(new FlowLayout());
				Button btn1 =new Button("���ư���");
				Label erL=new Label("���̵� ��й�ȣ�� Ȯ���ϼ���.");
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
			
			
		} catch (Exception e) {
			System.out.print(e);
		}

	}

	public signin(String id,String pwd,String name,String Tnum) {

		try {
			connDB();
			
			String query = "INSERT INTO sign(num,id,pwd,name,Tel_num) VALUES(auto.nextval,'"+id+"','"+pwd+"','"+name+"','"+Tnum+"')";
			boolean b = stmt.execute(query);
			Frame signinF = new Frame("ȸ������ ����");
			signinF.setSize(200,200);
			signinF.setLayout(new FlowLayout());
			Label signinLabbel= new Label("ȸ������ �Ϸ�");
			Button signinButton = new Button("���ư���");
			
			signinF.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			
			signinButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					signinF.dispose();
				}
			});
			
			signinF.add(signinLabbel);
			signinF.add(signinButton);
			signinF.setVisible(true);
			
		}
		catch (Exception e) 
		{
			System.out.print(e);
		}

	}

	public static void connDB() {
		try 
		{ 
		Class.forName(driver);
        System.out.println("jdbc driver loading success");
        con = DriverManager.getConnection(url, user, password);
        System.out.println("oracle connection success");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        System.out.println("statement create success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
