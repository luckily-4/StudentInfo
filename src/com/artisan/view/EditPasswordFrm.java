package com.artisan.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.artisan.dao.AdminDao;
import com.artisan.dao.StudentDao;
import com.artisan.model.Admin;
import com.artisan.model.Student;
import com.artisan.model.Teacher;
import com.artisan.util.StringUtil;

public class EditPasswordFrm extends JFrame {

	private JPanel contentPane;
	private JPasswordField oldPasswordTextField;
	private JPasswordField newPasswordTextField;
	private JPasswordField confirmPasswordTextField;
	private JLabel currentUserLabel;


	public EditPasswordFrm() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
//		setClosable(true);
//		setIconifiable(true);
		JLabel label = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		label.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/password.png")));
		label.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		oldPasswordTextField = new JPasswordField();
		oldPasswordTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_1.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		newPasswordTextField = new JPasswordField();
		newPasswordTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		confirmPasswordTextField = new JPasswordField();
		confirmPasswordTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitEdit(e);
			}
		});
		submitButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		JLabel label_3 = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		label_3.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		label_3.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		currentUserLabel = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(86)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(submitButton)
							.addGap(61)
							.addComponent(resetButton))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(label_2)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(confirmPasswordTextField, 167, 167, 167))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(label_1)
									.addComponent(label))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(newPasswordTextField)
									.addComponent(oldPasswordTextField, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(label_3)
								.addGap(18)
								.addComponent(currentUserLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(currentUserLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(submitButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		if("ϵͳ����Ա".equals(MainFrm.userType.getName())){
			Admin admin = (Admin)MainFrm.userObject;
			currentUserLabel.setText("��ϵͳ����Ա��" + admin.getName());
		}else if("ѧ��".equals(MainFrm.userType.getName())){
			Student student = (Student)MainFrm.userObject;
			currentUserLabel.setText("��ѧ����" + student.getName());
		}else{
			Teacher teacher = (Teacher)MainFrm.userObject;
			currentUserLabel.setText("��ѧ����" + teacher.getName());
		}
	}

	protected void submitEdit(ActionEvent e) {
		// TODO Auto-generated method stub
		String oldPassword = oldPasswordTextField.getText().toString();
		String newPassword = newPasswordTextField.getText().toString();
		String conformPassword = confirmPasswordTextField.getText().toString();
		if(StringUtil.isEmpty(oldPassword)){
			JOptionPane.showMessageDialog(this, "����д�����룡");
			return;
		}
		if(StringUtil.isEmpty(newPassword)){
			JOptionPane.showMessageDialog(this, "����д�����룡");
			return;
		}
		if(StringUtil.isEmpty(conformPassword)){
			JOptionPane.showMessageDialog(this, "��ȷ�������룡");
			return;
		}
		if(!newPassword.equals(conformPassword)){
			JOptionPane.showMessageDialog(this, "�����������벻һ�£�");
			return;
		}
		if("ϵͳ����Ա".equals(MainFrm.userType.getName())){
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			Admin admin = (Admin)MainFrm.userObject;
			adminTmp.setName(admin.getName());
			adminTmp.setId(admin.getId());
			adminTmp.setPassword(oldPassword);
			JOptionPane.showMessageDialog(this, adminDao.editPassword(adminTmp, newPassword));
			adminDao.closeDao();
			return;
		}
		if("ѧ��".equals(MainFrm.userType.getName())){
			StudentDao studentDao = new StudentDao();
			Student studentTmp = new Student();
			Student student = (Student)MainFrm.userObject;
			studentTmp.setName(student.getName());
			studentTmp.setPassword(oldPassword);
			studentTmp.setId(student.getId());
			JOptionPane.showMessageDialog(this, studentDao.editPassword(studentTmp, newPassword));
			studentDao.closeDao();
			return;
		}

		
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		confirmPasswordTextField.setText("");
	}
}
