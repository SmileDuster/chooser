package chooser;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Errortext {
	public static void errorchecking (int input,String name) {
		if(input==1||input==11||input==21) {
			return;
		}
		JDialog creatsuccess = new JDialog();
		creatsuccess.setTitle("提示信息");
		creatsuccess.setVisible(true);
		creatsuccess.setSize(300, 150);
		creatsuccess.setResizable(false);
		creatsuccess.setLocationRelativeTo(null);
		creatsuccess.setLayout(null);
		Container container = creatsuccess.getContentPane();
		JButton accept = new JButton("确定");
		accept.setBounds(120, 75, 60, 30);
		accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				creatsuccess.dispose();
				return;
			}
		});
		container.add(accept);
		switch (input) {
		case 1://创建时成功
//			JLabel text1 = new JLabel(name+"创建成功");
//			text1.setBounds(0, 0, 300, 75);
//			text1.setFont(new Font("", 1, 15));
//			text1.setHorizontalAlignment(SwingConstants.CENTER);
//			container.add(text1);
			break;
		case 0://创建时失败
			JLabel text2 = new JLabel("出现未知错误 "+name+"创建失败");
			text2.setBounds(0, 0, 300, 75);
			text2.setFont(new Font("", 1, 15));
			text2.setHorizontalAlignment(SwingConstants.CENTER);
			container.add(text2);
			break;
		case -1://创建时已有相同文件
			JLabel text3 = new JLabel("已存在同名文件 请确认后重试 "+name+"创建失败");
			text3.setBounds(0, 0, 300, 75);
			text3.setFont(new Font("", 1, 15));
			text3.setHorizontalAlignment(SwingConstants.CENTER);
			container.add(text3);
			break;
		case -2://创建时名单丢失
			JLabel text4 = new JLabel("警告：文件丢失 部分数据失效"+name+"创建成功");
			text4.setBounds(0, 0, 300, 75);
			text4.setFont(new Font("", 1, 15));
			text4.setHorizontalAlignment(SwingConstants.CENTER);
			container.add(text4);
			break;
		case 11://删除成功
//			JLabel text5 = new JLabel(name+"删除成功");
//			text5.setBounds(0, 0, 300, 75);
//			text5.setFont(new Font("", 1, 15));
//			text5.setHorizontalAlignment(SwingConstants.CENTER);
//			container.add(text5);
			break;
		case 10://删除失败
			JLabel text6 = new JLabel("出现未知错误 "+name+"删除失败");
			text6.setBounds(0, 0, 300, 75);
			text6.setFont(new Font("", 1, 15));
			text6.setHorizontalAlignment(SwingConstants.CENTER);
			container.add(text6);
			break;
		case 21:
//			JLabel text7 = new JLabel(name+"载入成功");
//			text7.setBounds(0, 0, 300, 75);
//			text7.setFont(new Font("", 1, 15));
//			text7.setHorizontalAlignment(SwingConstants.CENTER);
//			container.add(text7);
			break;
		case 20:
			JLabel text8 = new JLabel("出现未知错误 "+name+"载入失败");
			text8.setBounds(0, 0, 300, 75);
			text8.setFont(new Font("", 1, 15));
			text8.setHorizontalAlignment(SwingConstants.CENTER);
			container.add(text8);
			break;
		case 19:
			JLabel text9 = new JLabel("文件已丢失或损坏 "+name+"载入失败");
			text9.setBounds(0, 0, 300, 75);
			text9.setFont(new Font("", 1, 15));
			text9.setHorizontalAlignment(SwingConstants.CENTER);
			container.add(text9);
			break;
		case 1001:
			JLabel text10 = new JLabel("这项修改将在下一次启动时生效");
			text10.setBounds(0, 0, 300, 75);
			text10.setFont(new Font("", 1, 15));
			text10.setHorizontalAlignment(SwingConstants.CENTER);
			container.add(text10);
			break;
		case 1002:
			JLabel text11 = new JLabel("请先输入或粘贴内容");
			text11.setBounds(0, 0, 300, 75);
			text11.setFont(new Font("", 1, 15));
			text11.setHorizontalAlignment(SwingConstants.CENTER);
			container.add(text11);
			break;
		}
	}
}
