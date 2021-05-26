package com.artisan.view;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.artisan.dao.ClassDao;
import com.artisan.model.StudentClass;
import com.artisan.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageClassFrm extends JFrame {
	private JTextField searchClassNameTextField;
	private JTable classListTable;
	private JTextField editClassNameTextField;
	private JTextArea editClassInfoTextArea;

	public ManageClassFrm() {
//		setClosable(true);
//		setIconifiable(true);
		setTitle("\u73ED\u7EA7\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 773, 562);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		searchClassNameTextField = new JTextField();
		searchClassNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentClass sc = new StudentClass();
				sc.setName(searchClassNameTextField.getText().toString());
				setTable(sc);
			}
		});
		searchButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/\u641C\u7D22.png")));
		searchButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		JLabel label_1 = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		label_1.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		editClassNameTextField = new JTextField();
		editClassNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u73ED\u7EA7\u4FE1\u606F\uFF1A");
		label_2.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		editClassInfoTextArea = new JTextArea();
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEditAct(ae);
			}
		});
		submitEditButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitEditButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		JButton submitDeleteButton = new JButton("\u5220\u9664");
		submitDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteClassAct(ae);
			}
		});
		submitDeleteButton.setIcon(new ImageIcon(ManageClassFrm.class.getResource("/images/\u5220\u9664.png")));
		submitDeleteButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(160)
							.addComponent(label)
							.addGap(18)
							.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(110)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 536, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_2)
									.addGap(18)
									.addComponent(editClassInfoTextArea))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addGap(18)
									.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
							.addGap(102)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(submitDeleteButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(submitEditButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(editClassInfoTextArea, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addGap(32))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(submitEditButton)
							.addGap(34)
							.addComponent(submitDeleteButton)
							.addContainerGap())))
		);
		
		classListTable = new JTable();
		classListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedTableRow(me);
			}
		});
		classListTable.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		classListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"\u73ED\u7EA7\u7F16\u53F7","\u73ED\u7EA7\u540D\u79F0" , "\u73ED\u7EA7\u4FE1\u606F\u4ECB\u7ECD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		classListTable.getColumnModel().getColumn(2).setPreferredWidth(316);
		scrollPane.setViewportView(classListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new StudentClass());
	}
	protected void deleteClassAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "��ȷ��ɾ��ô��") != JOptionPane.OK_OPTION){
			return;
		}
		int index = classListTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ��������!");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
		ClassDao classDao = new ClassDao();
		if(classDao.delete(id)){
			JOptionPane.showMessageDialog(this, "ɾ���ɹ�!");
		}else{
			JOptionPane.showMessageDialog(this, "ɾ��ʧ��!");
		}
		classDao.closeDao();
		setTable(new StudentClass());
	}

	protected void submitEditAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		ClassDao classDao = new ClassDao();
		int index = classListTable.getSelectedRow();
		if(index == -1){
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵ�����!");
			return;
		}
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		String className = dft.getValueAt(classListTable.getSelectedRow(), 1).toString();
		String classInfo = dft.getValueAt(classListTable.getSelectedRow(), 2).toString();
		String editClassName = editClassNameTextField.getText().toString();
		String editClassInfo = editClassInfoTextArea.getText().toString();
		if(StringUtil.isEmpty(editClassName)){
			JOptionPane.showMessageDialog(this, "����дҪ�޸ĵ�����!");
			return;
		}
		if(className.equals(editClassName) && classInfo.equals(editClassInfo)){
			JOptionPane.showMessageDialog(this, "����û�����κ��޸�!");
			return;
		}
		int id = Integer.parseInt(dft.getValueAt(classListTable.getSelectedRow(), 0).toString());
		StudentClass sc = new StudentClass();
		sc.setId(id);
		sc.setName(editClassName);
		sc.setInfo(editClassInfo);
		if(classDao.update(sc)){
			JOptionPane.showMessageDialog(this, "���³ɹ�!");
		}else{
			JOptionPane.showMessageDialog(this, "����ʧ��!");
		}
		classDao.closeDao();
		setTable(new StudentClass());
	}

	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		editClassNameTextField.setText(dft.getValueAt(classListTable.getSelectedRow(), 1).toString());
		editClassInfoTextArea.setText(dft.getValueAt(classListTable.getSelectedRow(), 2).toString());
	}

	private void setTable(StudentClass studentClass){
		DefaultTableModel dft = (DefaultTableModel) classListTable.getModel();
		dft.setRowCount(0);
		ClassDao classDao = new ClassDao();
		List<StudentClass> classList = classDao.getClassList(studentClass);
		for (StudentClass sc : classList) {
			Vector v = new Vector();
			v.add(sc.getId());
			v.add(sc.getName());
			v.add(sc.getInfo());
			dft.addRow(v);
		}
		classDao.closeDao();
	}
}
