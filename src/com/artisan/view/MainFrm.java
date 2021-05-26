package com.artisan.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.artisan.model.UserType;
public class MainFrm extends JFrame {
	private JPanel contentPane;

	public static UserType userType;
	public static Object userObject;
	private JMenuItem addStudentMenuItem ;
	private JMenu manageClassMenu ;
	private JMenu courseMenu;
	private JMenuItem studentAttdentanceMenuItem;
	private JMenuItem manageAttendanceMenuItem;
	private JMenuItem statsAttendanceMenuItem;
	private JMenuItem addScoreMenuItem;
	private JMenuItem viewScoreMenuItem;
	private JMenuItem manageScoreMenuItem;
	private JMenuItem scoreStatsMenuItem;
	private   JLabel backgroundLabe1;
	public MainFrm(UserType userType,Object userObject) {
		this.userType = userType;
		this.userObject = userObject;
		setTitle("\u5B66\u751F\u4FE1\u606F\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 774);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7CFB\u7EDF\u8BBE\u7F6E.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MainFrm.this, "确定退出么？") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9000\u51FA.png")));
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		menuBar.add(menu_1);
		
		addStudentMenuItem = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		addStudentMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentFrm addStudentFrm = new AddStudentFrm();
				addStudentFrm.setVisible(true);
			}
		});
		addStudentMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		menu_1.add(addStudentMenuItem);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5B66\u751F\u5217\u8868");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStudentFrm studentManageFrm = new ManageStudentFrm();
				studentManageFrm.setVisible(true);

			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7528\u6237\u5217\u8868.png")));
		menu_1.add(menuItem_3);
		
		manageClassMenu = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		manageClassMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u73ED\u7EA7\u7BA1\u7406.png")));
		menuBar.add(manageClassMenu);
		
		JMenuItem menuItem_4 = new JMenuItem("\u73ED\u7EA7\u6DFB\u52A0");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addStudentClass(ae);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		manageClassMenu.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("\u73ED\u7EA7\u7BA1\u7406");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ManageClassFrm classManageFrm = new ManageClassFrm();
				classManageFrm.setVisible(true);

			}
		});


		courseMenu = new JMenu("\u8BFE\u7A0B\u7BA1\u7406");
		courseMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		menuBar.add(courseMenu);
		
		JMenuItem addCourseMenuItem = new JMenuItem("\u6DFB\u52A0\u8BFE\u7A0B");
		addCourseMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddCourseFrm addCourseFrm = new AddCourseFrm();
				addCourseFrm.setVisible(true);

			}
		});
		addCourseMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		courseMenu.add(addCourseMenuItem);
		
		JMenuItem courseListMenuItem = new JMenuItem("\u8BFE\u7A0B\u5217\u8868");
		courseListMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageCourseFrm manageCourseFrm = new ManageCourseFrm();
				manageCourseFrm.setVisible(true);

			}
		});
		courseListMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u8BFE\u7A0B\u5217\u8868.png")));
		courseMenu.add(courseListMenuItem);
		
		JMenu menu_4 = new JMenu("\u9009\u8BFE\u7BA1\u7406");
		menu_4.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9009\u62E9.png")));
		menuBar.add(menu_4);
		
		JMenuItem menuItem_2 = new JMenuItem("\u9009\u8BFE\u7BA1\u7406");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageSelectedCourseFrm manageSelectedCourseFrm = new ManageSelectedCourseFrm();
				manageSelectedCourseFrm.setVisible(true);

			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u9009\u62E9.png")));
		menu_4.add(menuItem_2);
		
		JMenu menu_2 = new JMenu("\u7B7E\u5230\u8003\u52E4");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7B7E\u5230.png")));
		menuBar.add(menu_2);
		
		studentAttdentanceMenuItem = new JMenuItem("\u5B66\u751F\u7B7E\u5230");
		studentAttdentanceMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AttendanceStudentFrm attendanceStudentFrm = new AttendanceStudentFrm();
				attendanceStudentFrm.setVisible(true);

			}
		});
		studentAttdentanceMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		studentAttdentanceMenuItem.setEnabled(false);
		menu_2.add(studentAttdentanceMenuItem);
		
		manageAttendanceMenuItem = new JMenuItem("\u7B7E\u5230\u7BA1\u7406");
		manageAttendanceMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageAttendanceFrm manageAttendanceFrm = new ManageAttendanceFrm();
				manageAttendanceFrm.setVisible(true);

			}
		});
		manageAttendanceMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7B7E\u5230\u5217\u8868.png")));
		menu_2.add(manageAttendanceMenuItem);
		
		statsAttendanceMenuItem = new JMenuItem("\u7B7E\u5230\u7EDF\u8BA1");
		statsAttendanceMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatsAttendanceFrm statsAttendanceFrm = new StatsAttendanceFrm();
				statsAttendanceFrm.setVisible(true);

			}
		});
		statsAttendanceMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7EDF\u8BA1.png")));
		menu_2.add(statsAttendanceMenuItem);
		
		JMenu menu_5 = new JMenu("\u6210\u7EE9\u7BA1\u7406");
		menu_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6210\u7EE9.png")));
		menuBar.add(menu_5);
		
		addScoreMenuItem = new JMenuItem("\u5F55\u5165\u6210\u7EE9");
		addScoreMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddScoreFrm addScoreFrm = new AddScoreFrm();
				addScoreFrm.setVisible(true);

			}
		});
		addScoreMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		menu_5.add(addScoreMenuItem);
		
		viewScoreMenuItem = new JMenuItem("\u6210\u7EE9\u67E5\u770B");
		viewScoreMenuItem.setEnabled(false);
		viewScoreMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ViewScoreFrm viewScoreFrm = new ViewScoreFrm();
				viewScoreFrm.setVisible(true);

			}
		});
		viewScoreMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u67E5\u770B.png")));
		menu_5.add(viewScoreMenuItem);
		
		manageScoreMenuItem = new JMenuItem("\u6210\u7EE9\u7BA1\u7406");
		manageScoreMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageScoreFrm manageScoreFrm = new ManageScoreFrm();
				manageScoreFrm.setVisible(true);

			}
		});
		manageScoreMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u6210\u7EE9.png")));
		menu_5.add(manageScoreMenuItem);
		
		scoreStatsMenuItem = new JMenuItem("\u6210\u7EE9\u7EDF\u8BA1");
		scoreStatsMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StatsScoreFrm statsScoreFrm = new StatsScoreFrm();
				statsScoreFrm.setVisible(true);

			}
		});
		scoreStatsMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u7EDF\u8BA1.png")));
		menu_5.add(scoreStatsMenuItem);
		
		JMenu menu_3 = new JMenu("\u5E2E\u52A9");
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5E2E\u52A9.png")));
		menuBar.add(menu_3);
		
		JMenuItem menuItem_6 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				aboutUs(ae);
			}
		});
		menuItem_6.setIcon(new ImageIcon(MainFrm.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC.png")));
		menu_3.add(menuItem_6);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

	      backgroundLabe1 = new JLabel("");
		  backgroundLabe1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/2.jpg")));

		contentPane.add(backgroundLabe1, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setAuthority();
	}

	protected void addStudentClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		AddStudentClassFrm sca = new AddStudentClassFrm();
		sca.setVisible(true);

	}

	protected void editPassword(ActionEvent ae) {

		EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
		editPasswordFrm.setVisible(true);
		
	}

	protected void aboutUs(ActionEvent ae) {
		String info = "[零式]\n";
		info += "成员:**********";
		int ret = JOptionPane.showOptionDialog(this, info, "关于我们", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, new ImageIcon(LoginFrm.class.getResource("/images/logo.png")), null,null);
		if(ret == 0){
			//采用Java 调用系统浏览器打开制定
			try {
				URI uri = new URI("/关于我们\\index.html");
				Desktop.getDesktop().browse(uri);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(this, "null！");
		}
	}
	private void setAuthority(){
		if("学生".equals(userType.getName())){
			addStudentMenuItem.setEnabled(false);
			manageClassMenu.setEnabled(false);
			courseMenu.setEnabled(false);
			studentAttdentanceMenuItem.setEnabled(true);
			manageAttendanceMenuItem.setEnabled(false);
			statsAttendanceMenuItem.setEnabled(false);
			addScoreMenuItem.setEnabled(false);
			viewScoreMenuItem.setEnabled(true);
			manageScoreMenuItem.setEnabled(false);
			scoreStatsMenuItem.setEnabled(false);
		}

	}
}
