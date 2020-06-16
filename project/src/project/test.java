package project;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class test{
	public static void main(String[] args) {
		JTable table;
		JScrollPane scrollPane;
		JFrame f =new JFrame("test");
		JPanel j =new JPanel();
//		f.setLayout(null);
		f.setSize(1000,1000);
		String colName[]= {"아이디","성명","핸드폰","선택","가입일자"};
		DefaultTableModel model=new DefaultTableModel(colName,0);

		model.addRow(new Object[]{"id","id","id","id","id"});
		model.addRow(new Object[]{"id","id","id","id","id"});
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		table=new JTable(model);
//		table.addMouseListener(new JTableMouseListener());
		scrollPane=new JScrollPane(table);
		scrollPane.setSize(400,400);
		j.setSize(500,500);
		f.add(j);
//		j.add(table);
		j.add(scrollPane);
		f.setVisible(true);
	}	
//	private class JTableMouseListener implements MouseListener
//	{
//	@Override
//	public void mouseClicked(java.awt.event.MouseEvent e) {
//		
//	}

}

