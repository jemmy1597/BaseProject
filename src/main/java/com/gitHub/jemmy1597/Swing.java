import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

public class Swing extends JFrame {
	private boolean cb1_state=false,cb2_state=false,cb3_state=false,cb4_state=false;
 	private int custom_time=5;
	private int custom_db=70;
 	public int PanelFlag = 0;
 	JLabel dbData;
 	String status = "�l���O���A:OFF\n���������A:OFF\n���T���A:OFF\n���v�����A:OFF\n\n�{�b���q:0 db\n\n�]�w���˶g��:5 min\n�]�w���q�W��:70 db";
 	JTextArea textarea = new JTextArea(status);
 	
	Swing(){
		super("<�W�}��+99���i��}> �ϴo�H�F�~�t��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,500);
		/*****************�ŧi����********************/
		JCheckBox cb1 = new JCheckBox("�۰ʶ}���l���O"),
				  cb2 = new JCheckBox("�۰����|"),
				  cb3 = new JCheckBox("���q����"),
				  cb4 = new JCheckBox("�a�_���s����");
		
		JButton setting = new JButton("�]�w");
		JButton panel_ON = new JButton("�l���O�Ұ�");
		JButton panel_OFF = new JButton("�l���O����");
		
		JLabel lb1 = new JLabel("Function");
		JLabel lb2 = new JLabel("���A�ʵ���");
		/*****************�ŧi����********************/
		/*****************��ť��********************/
		ItemListener cblistener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox cbSourse = (JCheckBox)e.getSource();
				String target = cbSourse.getActionCommand();
				if(e.getStateChange( )== ItemEvent.SELECTED)
					switch(target) {
					case "�۰ʶ}���l���O":
						cb1_state = true;
						break;
					case "�۰����|":
						cb2_state = true;
						break;
					case "���q����":
						cb3_state = true;
						break;
					case "�a�_���s����":
						cb4_state = true;
						break;
					}
				else if(e.getStateChange() == ItemEvent.DESELECTED)
					switch(target) {
					case "�۰ʶ}���l���O":
						cb1_state = false;
						break;
					case "�۰����|":
						cb2_state = false;
						break;
					case "���q����":
						cb3_state = false;
						break;
					case "�a�_���s����":
						cb4_state = false;
						break;
					}
			}
		};
		cb1.addItemListener(cblistener);
		cb2.addItemListener(cblistener);
		cb3.addItemListener(cblistener);
		cb4.addItemListener(cblistener);
		
		ActionListener buttonlistener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btnSourse = (JButton)e.getSource();
				String target = btnSourse.getActionCommand();
				switch(target) {
				case "�]�w":
					String time = JOptionPane.showInputDialog("�п�J���˶g�� ���:����");
					timeSet(time);
					String db = JOptionPane.showInputDialog("�п�J���q�W�� ���:db");
					dbSet(db);
					break;
				case "�l���O�Ұ�":
					cb1.setSelected(false);
					PanelFlag = 1;
					System.out.println("�l���O�w�Ұ�");
					break;
				case "�l���O����":
					cb1.setSelected(false);
					PanelFlag = 2;
					System.out.println("�l���O�w����");
					break;
				}
			}	
		};
		setting.addActionListener(buttonlistener);
		panel_ON.addActionListener(buttonlistener);
		panel_OFF.addActionListener(buttonlistener);
		/*****************��ť��********************/
		/*****************Layout�]�w********************/
		Container cp = getContentPane();
		cp.setLayout(null);
		
		lb1.setBounds(10, 10, 200, 30);
		lb2.setBounds(400,10,200,30);
		lb1.setFont(new Font("Time New Roman",Font.BOLD,30));
		lb2.setFont(new Font("Time New Roman",Font.BOLD,30));
		
		cb1.setBounds(10, 50, 200,20);
		cb2.setBounds(10, 80, 200,20);
		cb3.setBounds(10, 110, 200,20);
		cb4.setBounds(10, 140, 200,20);
		cb1.setFont(new Font("Time New Roman",Font.PLAIN,20));
		cb2.setFont(new Font("Time New Roman",Font.PLAIN,20));
		cb3.setFont(new Font("Time New Roman",Font.PLAIN,20));
		cb4.setFont(new Font("Time New Roman",Font.PLAIN,20));
		
		textarea.setBounds(380, 50, 210, 250);
		textarea.setFont(new Font("Time New Roman",Font.PLAIN,18));
		
		setting.setBounds(10, 280, 150, 30);
		panel_ON.setBounds(10, 200, 150, 30);
		panel_OFF.setBounds(10, 230, 150, 30);
		setting.setFont(new Font("Time New Roman",Font.PLAIN,18));
		panel_ON.setFont(new Font("Time New Roman",Font.PLAIN,18));
		panel_OFF.setFont(new Font("Time New Roman",Font.PLAIN,18));
		
		cp.add(lb1);
		cp.add(lb2);
		cp.add(cb1);
		cp.add(cb2);
		cp.add(cb3);
		cp.add(cb4);
		cp.add(textarea);
		cp.add(setting);
		cp.add(panel_ON);
		cp.add(panel_OFF);
		
		/*****************Layout�]�w********************/
		setVisible(true);
	}
	public boolean getcb1() {
		return cb1_state;
	}
	public boolean getcb2() {
		return cb2_state;
	}
	public boolean getcb3() {
		return cb3_state;
	}
	public boolean getcb4() {
		return cb4_state;
	}
	public int getcustom_time() {
		return custom_time;
	}
	public int getcustom_db() {
		return custom_db;
	}
	public void showStatus(String s) {
		textarea.setText(s);
	}
	public void timeSet(String s) {
		try {
		int time = Integer.parseInt(s);
		if(time<=0 || time>10)
			System.out.println("�п�J1~10");
		else
			custom_time = time;
		}catch(NumberFormatException e) {
			System.out.println("��J����");
		}
	}
	public void dbSet(String s) {
		try {
			int db = Integer.parseInt(s);
			if(db<=0)
				System.out.println("�п�J�����");
			else
				custom_db = db;
			}catch(NumberFormatException e) {
				System.out.println("��J����");
			}
	}
}
