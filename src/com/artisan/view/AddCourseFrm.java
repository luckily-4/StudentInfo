package com.artisan.view;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;

import com.artisan.dao.CourseDao;
import com.artisan.model.Course;
import com.artisan.model.Teacher;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class AddCourseFrm extends JFrame {
	private JTextField courseNameTextField;
	private JTextField studentNumTextField;
	private JComboBox teacherListComboBox;
	private JTextArea courseInfoTextArea;
	public AddCourseFrm() {
		//setClosable(true);
		//setIconifiable(true);
		setTitle("\u6DFB\u52A0\u8BFE\u7A0B");
		setBounds(100, 100, 453, 471);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		label.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		courseNameTextField = new JTextField();
		courseNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6388\u8BFE\u8001\u5E08\uFF1A");
		label_1.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u8001\u5E08.png")));
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		teacherListComboBox = new JComboBox();
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u4EBA\u6570\uFF1A");
		label_2.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u4EBA\u6570.png")));
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		studentNumTextField = new JTextField();
		studentNumTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8BFE\u7A0B\u4ECB\u7ECD\uFF1A");
		label_3.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u4ECB\u7ECD.png")));
		label_3.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		courseInfoTextArea = new JTextArea();
		
		JButton addCourseButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		addCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addCourseAct(ae);
			}
		});
		addCourseButton.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u786E\u8BA4.png")));
		addCourseButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E\u4FE1\u606F");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(studentNumTextField, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(teacherListComboBox, 0, 149, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(courseNameTextField, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(courseInfoTextArea, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(103)
							.addComponent(addCourseButton)
							.addGap(18)
							.addComponent(resetButton)))
					.addGap(117))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(courseNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(teacherListComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(studentNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(courseInfoTextArea, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addCourseButton)
						.addComponent(resetButton))
					.addGap(57))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		courseNameTextField.setText("");
		courseInfoTextArea.setText("");
		studentNumTextField.setText("");
		teacherListComboBox.setSelectedIndex(0);
	}

	protected void addCourseAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String couserName = courseNameTextField.getText().toString();
		String courseInfo = courseInfoTextArea.getText().toString();
		Teacher selectedTeacher = (Teacher)teacherListComboBox.getSelectedItem();
		int studentMaxNum = 0;
		try {
			studentMaxNum = Integer.parseInt(studentNumTextField.getText());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "ѧ������ֻ����������!");
			return;
		}
		if(StringUtil.isEmpty(couserName)){
			JOptionPane.showMessageDialog(this, "������γ�����!");
			return;
		}
		if(studentMaxNum <= 0){
			JOptionPane.showMessageDialog(this, "ѧ������ֻ���������0������!");
			return;
		}
		Course course = new Course();
		course.setName(couserName);
		course.setMax_student_num(studentMaxNum);
		course.setInfo(courseInfo);
		course.setTeacher_id(selectedTeacher.getId());
		CourseDao courseDao = new CourseDao();
		if(courseDao.addCourse(course)){
			JOptionPane.showMessageDialog(this, "��ӳɹ�!");
		}else{
			JOptionPane.showMessageDialog(this, "���ʧ��!");
		}
		courseDao.closeDao();
		resetValue(ae);
	}


}
