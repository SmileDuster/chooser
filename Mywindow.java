package chooser;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Mywindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String lastname="我真的不信你的名字会和这个一样";
	private static String lastquestion="我真的不信你的题目会和这个一样";
	public static JFrame menu = new JFrame(Variable.TITLE);
	public static JFrame pointing = new JFrame("进行随机抽取");
	public static JFrame changing = new JFrame("改变配置");
	public static JFrame creating1 = new JFrame("创建新名单");
	public static JFrame creating2 = new JFrame("确认新名单");
	public static JFrame qchanging = new JFrame("改变配置");
	public static JFrame qcreating1 = new JFrame("创建新题组");
	public static JFrame qcreating2 = new JFrame("确认新题组");
	public static JFrame setting = new JFrame("设置");
	public static JFrame staff = new JFrame("关于");
	public static JFrame checking = new JFrame("目前信息");
	public static JFrame small = new JFrame("简易模式");
	public static JFrame smallgo = new JFrame("简易模式唤醒");
	public static JList<String> selecting = new JList<>();
	public static JList<String> qselecting = new JList<>();
	public static JTextField newname = new JTextField("点这里输入组名");
	public static JTextField qnewname = new JTextField("点这里输入组名");
	public static JLabel nowteam = new JLabel(Nowteamdata.teamname);
	public static JLabel pnowteam = new JLabel(Nowteamdata.teamname);
	public static JLabel nowquestion = new JLabel(Nowquestiondata.name);
	public static JLabel pnowquestion = new JLabel(Nowquestiondata.name);
	public static JButton start = new JButton("开始",new ImageIcon(".\\res\\images\\go.png"));
	public static JComboBox<String> s_defaultteam = new JComboBox<String>();
	public static JComboBox<String> s_defaultquestion = new JComboBox<String>();
	public static JLabel vkcoding = new JLabel("",SwingConstants.CENTER);
	
	
	public static Container container = menu.getContentPane();
	public static Container container2 = pointing.getContentPane();
	public static Container container3 = changing.getContentPane();
	public static Container container4 = creating1.getContentPane();
	public static Container container5 = creating2.getContentPane();
	public static Container qcontainer3 = qchanging.getContentPane();
	public static Container qcontainer4 = qcreating1.getContentPane();
	public static Container qcontainer5 = qcreating2.getContentPane();
	public static Container container7 = setting.getContentPane();
	public static Container container8 = staff.getContentPane();
	public static Container container9 = small.getContentPane();
	public static Container container10 = checking.getContentPane();
	
	public static JLabel newteamname = new JLabel(Variable.creatingname);
	public static JLabel newquestionname = new JLabel(Variable.qcreatingname);
	public static JTextArea question = new JTextArea();
	public static JButton changeq = new JButton("更换题目", new ImageIcon(".\\res\\images\\change.png"));
	public Mywindow () {
		
	}
	
	public static void showqcreating () {
		qcreating1.setResizable(false);
		qcreating1.setVisible(false);
		qcreating1.setBounds(0,0,600, 400);
		qcreating1.setLocationRelativeTo(null);
		qcreating1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		qcreating1.setLayout(null);
		qcreating2.setVisible(false);
		qcreating2.setBounds(0,0,600, 400);
		qcreating2.setLocationRelativeTo(null);
		qcreating2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		qcreating2.setLayout(null);
		qcreating2.setResizable(false);
		
		JLabel notes = new JLabel("您正在创建：");
		JLabel notes2 = new JLabel("输入题目或使用Ctrl+v粘贴题目");
		JLabel notes3 = new JLabel("确定题组：");
		JLabel notes4 = new JLabel("问题展示");
		JLabel notes5 = new JLabel("额外选项");
		notes.setBounds(0, 0, 600, 30);
		newquestionname.setBounds(0, 30, 600, 50);
		notes2.setBounds(0, 80, 600, 30);
		notes3.setBounds(0, 0, 600, 30);
		notes4.setBounds(0, 80, 300, 30);
		notes5.setBounds(300, 80, 300, 30);
		notes.setFont(new Font("", 0, 25));
		newquestionname.setFont(new Font("", 1, 50));
		notes2.setFont(new Font("", 0, 25));
		notes3.setFont(new Font("", 0, 25));
		notes4.setFont(new Font("", 1, 25));
		notes5.setFont(new Font("", 1, 25));
		notes.setHorizontalAlignment(SwingConstants.CENTER);
		newquestionname.setHorizontalAlignment(SwingConstants.CENTER);
		notes2.setHorizontalAlignment(SwingConstants.CENTER);
		notes3.setHorizontalAlignment(SwingConstants.CENTER);
		notes4.setHorizontalAlignment(SwingConstants.CENTER);
		notes5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextArea namelist = new JTextArea();
		namelist.setBackground(new Color(200, 200, 200));
		namelist.setLineWrap(true);
		JScrollPane namelist_js = new JScrollPane(namelist);
		namelist_js.setBounds(50, 110, 500, 170);
		
		JList<String> acceptclass = new JList<>();
		acceptclass.setFont(new Font("", 0, 20));
		JScrollPane acceptclass_js = new JScrollPane(acceptclass);
		acceptclass_js.setBounds(50, 110, 200, 175);
		
		JCheckBox extra1 = new JCheckBox("立即载入此题组", true);
		extra1.setFont(new Font("", 1, 18));
		JCheckBox extra2 = new JCheckBox("将此题组设定为默认题组", false);
		extra2.setFont(new Font("", 1, 18));
		extra1.setBounds(350, 150, 250, 50);
		extra2.setBounds(350, 200, 250, 50);
		
		JButton next1 = new JButton("下一步",new ImageIcon(".\\res\\images\\next.png"));
		JButton prev1 = new JButton("上一步",new ImageIcon(".\\res\\images\\prev.png"));
		JButton next2 = new JButton("确认创建",new ImageIcon(".\\res\\images\\add.png"));
		JButton prev2 = new JButton("上一步",new ImageIcon(".\\res\\images\\prev.png"));
		JButton tips1 = new JButton("操作提示");
		tips1.setBounds(237, 295, 125, 60);
		prev1.setBounds(50, 295, 125, 60);
		prev2.setBounds(50, 295, 125, 60);
		next1.setBounds(425, 295, 125, 60);
		next2.setBounds(425, 295, 125, 60);
		tips1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JDialog showtip = new JDialog(qcreating1);
				showtip.setTitle("提示信息");
				showtip.setVisible(true);
				showtip.setSize(400, 200);
				showtip.setResizable(false);
				showtip.setLocationRelativeTo(null);
				String temp = "<html>程序将以“回车”(换行符)为标准<br/>来区分不同的问题<br/>请您去除同一个问题中的换行<br/>在相邻的问题间添加换行</html>";
				JLabel pikachu = new JLabel(temp);
				showtip.add(pikachu);
				pikachu.setFont(new Font("", 1, 25));
			}
		});
		
		prev1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				qcreating1.setVisible(false);
				qchanging.setVisible(true);
				qselecting.setListData(Variable.questionnamelist);
			}
		});
		next1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(!namelist.getText().equals(""))
					Variable.qtempnamelist = namelist.getText().split("\n");
				else {
					Errortext.errorchecking(1002, null);
					return;
				}
				qcreating1.setVisible(false);
				qcreating2.setVisible(true);
				qcontainer5.add(newquestionname);
				acceptclass.setListData(Variable.qtempnamelist);
			}
		});
		prev2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				qcreating1.setVisible(true);
				qcreating2.setVisible(false);
				qcontainer4.add(newquestionname);
			}
		});
		next2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(true);
				qcreating2.setVisible(false);
				Errortext.errorchecking(Myfile.creatq(Variable.qcreatingname),Variable.qcreatingname);
				namelist.setText(null);
				qnewname.setText("点这里输入组名");
				s_defaultquestion.addItem(Variable.qcreatingname);
				if(extra1.isSelected()) {
					Errortext.errorchecking(Myfile.readq(Variable.qcreatingname),Variable.qcreatingname);
					if(Variable.questionflag)
					nowquestion.setText(Nowquestiondata.name);
					if(!Nowteamdata.teamname.equals("尚未载入名称组")) {
						start.setEnabled(true);
					}
				}
				if(extra2.isSelected()) {
					s_defaultquestion.setSelectedItem(Variable.qcreatingname);
					File default0 = new File(".\\settings\\questiondefaultset.lxc");
					try {
						FileWriter fw = new FileWriter(default0);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(Variable.qcreatingname);
						bw.flush();
						bw.close();
						fw.close();
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					
				}
			}
		});
		qcontainer4.add(newquestionname);
		qcontainer4.add(notes);
		qcontainer4.add(notes2);
		qcontainer4.add(namelist_js);
		qcontainer4.add(next1);
		qcontainer4.add(prev1);
		qcontainer4.add(tips1);
		qcontainer5.add(next2);
		qcontainer5.add(prev2);
		qcontainer5.add(notes3);
		qcontainer5.add(notes4);
		qcontainer5.add(notes5);
		qcontainer5.add(acceptclass_js);
		qcontainer5.add(extra1);
		qcontainer5.add(extra2);
	}
	
	public static void showqchanging () {
		qchanging.setResizable(false);
		qchanging.setVisible(false);
		qchanging.setBounds(0,0,650, 400);
		qchanging.setLocationRelativeTo(null);
		qchanging.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		qchanging.setLayout(null);
		
		qselecting.setListData(Variable.questionnamelist);
		qselecting.setFont(new Font("", 1, 20));
		JScrollPane selecting_js = new JScrollPane(qselecting);
		selecting_js.setBounds(25, 100, 200, 150);
		
		JButton accept = new JButton("确定",new ImageIcon(".\\res\\images\\accept.png"));
		accept.setToolTipText("载入选定的题组");
		accept.setEnabled(false);
		JButton deleteteam = new JButton("删除",new ImageIcon(".\\res\\images\\delete.png"));
		deleteteam.setToolTipText("删除该题组的所有信息");
		deleteteam.setEnabled(false);
		deleteteam.setBounds(25, 305, 200, 40);
		accept.setBounds(25, 260, 200, 40);
		
		JLabel middle_or = new JLabel("或者");
		middle_or.setFont(new Font("",1,50));
		middle_or.setBounds(250, 0, 150, 400);
		middle_or.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel left_text = new JLabel("选择已有题组");
		left_text.setFont(new Font("",1,30));
		left_text.setBounds(0, 0, 250, 100);
		left_text.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel right_text = new JLabel("创建新的题组");
		right_text.setFont(new Font("",1,30));
		right_text.setBounds(0, 0, 250, 100);
		right_text.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JPanel left = new JPanel();
		left.setLayout(null);
		left.setBounds(0, 0, 250, 400);
		left.add(left_text);
		left.add(selecting_js);
		left.add(deleteteam);
		left.add(accept);
		
		
		JPanel right = new JPanel();
		right.setLayout(null);
		right.setBounds(400, 0, 250, 400);
		right.add(right_text);
		
		qnewname.setBounds(25, 150, 200, 50);
		qnewname.setFont(new Font("",0,20));
		qnewname.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				if(qnewname.getText().equals(("题组"+(Variable.questioncount+1))))
				qnewname.setText("点这里输入组名");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				if(qnewname.getText().equals("点这里输入组名"))
					qnewname.setText("题组"+(Variable.questioncount+1));
			}
		});
		
		JButton back = new JButton("返回",new ImageIcon(".\\res\\images\\back.png"));
		JButton creat = new JButton("以此名称创建",new ImageIcon(".\\res\\images\\add.png"));
		creat.setBounds(50, 250, 150, 70);
		creat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(Variable.enterflag[7]==false) {
					Mywindow.showqcreating();
					Variable.enterflag[7]=true;
				}
				if(qnewname.getText().equals("点这里输入组名"))
					Variable.qcreatingname="题组"+(Variable.questioncount+1);
				else
					Variable.qcreatingname=qnewname.getText();
				newquestionname.setText(Variable.qcreatingname);
				qcontainer4.add(newquestionname);
				qchanging.setVisible(false);
				qcreating1.setVisible(true);
			}
		});
		
		right.add(creat);
		back.setBounds(275, 300, 100, 60);
		
		
		right.add(qnewname);
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(true);
				qchanging.setVisible(false);
			}
			
		});
		accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(true);
				qchanging.setVisible(false);
				Errortext.errorchecking(Myfile.readq(qselecting.getSelectedValue()),qselecting.getSelectedValue());
				if(Variable.questionflag)
				nowquestion.setText(Nowquestiondata.name);
				if(!Nowteamdata.teamname.equals("尚未载入名称组")) {
					start.setEnabled(true);
				}
			}
		});
		
		deleteteam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(true);
				qchanging.setVisible(false);
				String temp=qselecting.getSelectedValue();
				Errortext.errorchecking(Myfile.deleteq(temp),temp);
				
			}
		});
		qselecting.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO 自动生成的方法存根
				if(Variable.questioncount!=0) {
					accept.setEnabled(true);
					deleteteam.setEnabled(true);
				}
				if(qselecting.getSelectedValue()==null) {
					accept.setEnabled(false);
					deleteteam.setEnabled(false);
					deleteteam.setEnabled(false);
				}
			}
		});
		qcontainer3.add(left);
		qcontainer3.add(middle_or);
		qcontainer3.add(right);
		qcontainer3.add(back);
	}
	
	
	public static void showstaff () {
		staff.setVisible(false);
		staff.setBounds(0,0,600, 400);
		staff.setResizable(false);
		staff.setLocationRelativeTo(null);
		staff.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		staff.setLayout(new GridLayout(7, 1, 5, 5));
		
		JLabel l1 = new JLabel("制作：梁笑尘",SwingConstants.CENTER);
		JLabel l2 = new JLabel("2018年7月15日 版本1.4",SwingConstants.CENTER);
		JLabel l3 = new JLabel("语言：java",SwingConstants.CENTER);
		JLabel l4 = new JLabel("开发环境：eclipse",SwingConstants.CENTER);
		JLabel l5 = new JLabel("使用的第三方jar:",SwingConstants.CENTER);
		JLabel l6 = new JLabel("jna-4.2.2.jar     platform-3.5.2.jar",SwingConstants.CENTER);
		l1.setFont(new Font("", 1, 25));
		l2.setFont(new Font("", 1, 25));
		l3.setFont(new Font("", 1, 25));
		l4.setFont(new Font("", 1, 25));
		l5.setFont(new Font("", 1, 25));
		l6.setFont(new Font("", 1, 25));
		
		JButton back = new JButton("返回",new ImageIcon(".\\res\\images\\back.png"));
		back.setFont(new Font("", 1, 25));
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				staff.setVisible(false);
				menu.setVisible(true);
			}
		});
		
		container8.add(l1);
		container8.add(l2);
		container8.add(l3);
		container8.add(l4);
		container8.add(l5);
		container8.add(l6);
		container8.add(back);
	}
	
	public static void showsetting () {
		setting.setVisible(false);
		setting.setBounds(0,0,900, 700);
		setting.setResizable(false);
		setting.setLocationRelativeTo(null);
		setting.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setting.setLayout(null);
		
		JPanel team = new JPanel(new GridLayout(4, 1, 5, 5));
		team.setBounds(30, 10, 400, 250);
		team.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3), "名单设置", TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, new Font("", 1, 20)));
		JPanel question = new JPanel(new GridLayout(4, 1, 5, 5));
		question.setBounds(470, 10, 400, 250);
		question.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3), "题组设置", TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, new Font("", 1, 20)));
		JPanel switchs = new JPanel(new GridLayout(4, 1, 5, 5));
		switchs.setBounds(30, 300, 400, 250);
		switchs.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3), "功能开关", TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, new Font("", 1, 20)));
		JPanel vkcode = new JPanel(new GridLayout(4, 1, 5, 5));
		vkcode.setBounds(470, 300, 400, 250);
		vkcode.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3), "快速抽取", TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, new Font("", 1, 20)));
		
		JPanel p11 = new JPanel(new GridLayout(1, 2));
		JPanel p12 = new JPanel(new GridLayout(1, 2));
		JPanel p21 = new JPanel(new GridLayout(1, 3));
		JPanel p22 = new JPanel(new GridLayout(1, 3));
		
		JLabel defaultteam = new JLabel("设置默认名单：",SwingConstants.CENTER);
		defaultteam.setFont(new Font("", 1, 25));
		p11.add(defaultteam);
		JLabel defaultquestion = new JLabel("设置默认题组：",SwingConstants.CENTER);
		defaultquestion.setFont(new Font("", 1, 25));
		p12.add(defaultquestion);
		JLabel setteam = new JLabel("名单抽取方式：",SwingConstants.CENTER);
		setteam.setFont(new Font("", 1, 25));
		p21.add(setteam);
		JLabel setquestion = new JLabel("题组抽取方式：",SwingConstants.CENTER);
		setquestion.setFont(new Font("", 1, 25));
		p22.add(setquestion);
		JPanel p111 = new JPanel(new GridLayout(1, 2));
		JPanel p111111 = new JPanel(new GridLayout(1, 2));
		JRadioButton r1 = new JRadioButton("可重复");
		r1.setFont(new Font("", 1, 20));
		JRadioButton r2 = new JRadioButton("不重复");
		r2.setFont(new Font("", 1, 20));
		JRadioButton r11 = new JRadioButton("可重复");
		r11.setFont(new Font("", 1, 20));
		JRadioButton r22 = new JRadioButton("不重复");
		r22.setFont(new Font("", 1, 20));
		ButtonGroup group = new ButtonGroup();
		ButtonGroup group1 = new ButtonGroup();
		group.add(r1);
		group.add(r2);
		group1.add(r11);
		group1.add(r22);
		if(Variable.questionmode) {
			r11.setSelected(true);
		}
		else {
			r22.setSelected(true);
		}
		if(Variable.teammode) {
			r1.setSelected(true);
		}
		else {
			r2.setSelected(true);
		}
		p111.add(r1);
		p111.add(r2);
		p111111.add(r11);
		p111111.add(r22);
		p21.add(p111);
		p22.add(p111111);
		
		JLabel defaultteam0 = new JLabel("程序会在启动时自动载入此名单");
		defaultteam0.setFont(new Font("", 0, 15));
		JLabel defaultquestion0 = new JLabel("程序会在启动时自动载入此题组");
		defaultquestion0.setFont(new Font("", 0, 15));
		JLabel setteam0 = new JLabel("当前方式说明");
		setteam0.setFont(new Font("", 0, 15));
		if(r1.isSelected()) {
			setteam0.setText(Variable.intro[0]);
		}
		else {
			setteam0.setText(Variable.intro[1]);
		}
		JLabel setquestion0 = new JLabel("当前方式说明");
		setquestion0.setFont(new Font("", 0, 15));
		if(r11.isSelected()) {
			setquestion0.setText(Variable.intro[2]);
		}
		else {
			setquestion0.setText(Variable.intro[3]);
		}
		r1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				setteam0.setText(Variable.intro[0]);
				Variable.teammode=true;
			}
		});
		r2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				setteam0.setText(Variable.intro[1]);
				Variable.teammode=false;
			}
		});
		r11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				setquestion0.setText(Variable.intro[2]);
				Variable.questionmode=true;
			}
		});
		r22.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				setquestion0.setText(Variable.intro[3]);
				Variable.questionmode=false;
			}
		});
		
		s_defaultteam.setToolTipText("此名单会在程序每次启动时自动载入");
		s_defaultteam.setFont(new Font("", 0, 15));
		for(int i = 0; i<Variable.teamscount;i++) {
			s_defaultteam.addItem(Variable.teamnamelist[i]);
		}
		p11.add(s_defaultteam);
		s_defaultquestion.setToolTipText("此题组会在程序每次启动时自动载入");
		s_defaultquestion.setFont(new Font("", 0, 15));
		for(int i = 0; i<Variable.questioncount;i++) {
			s_defaultquestion.addItem(Variable.questionnamelist[i]);
		}
		p12.add(s_defaultquestion);
		team.add(p11);
		team.add(defaultteam0);
		team.add(p21);
		team.add(setteam0);
		question.add(p12);
		question.add(defaultquestion0);
		question.add(p22);
		question.add(setquestion0);
		
		JCheckBox writer = new JCheckBox("启用题组功能");
		writer.setFont(new Font("", 1, 25));
		if(Variable.questionflag) {
			writer.setSelected(true);
		}
		JCheckBox writer0 = new JCheckBox("启用键盘快捷键");
		writer0.setFont(new Font("", 1, 25));
		if(Variable.iflag) {
			writer0.setSelected(true);
		}
		writer0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Errortext.errorchecking(1001, null);
			}
		});
		JLabel swriter = new JLabel("点选后将启用题组功能");
		swriter.setFont(new Font("", 0, 15));
		JLabel swriter0 = new JLabel("点选后将启用点名快捷键");
		swriter0.setFont(new Font("", 0, 15));
		switchs.add(writer);
		switchs.add(swriter);
		switchs.add(writer0);
		switchs.add(swriter0);
		
		JLabel nowvk = new JLabel("当前快捷键："+Variable.vkcodes[Variable.vkcode]);
		nowvk.setFont(new Font("", 1, 25));
		JLabel nowvk0 = new JLabel("按下快捷键可以立即随机抽取一次");
		nowvk0.setFont(new Font("", 0, 15));
		JButton changevk = new JButton("更换快捷键");
		changevk.setFont(new Font("", 1, 25));
		JLabel showchangevk = new JLabel("按下上方按键以开始更改快捷键");
		showchangevk.setFont(new Font("", 1, 25));
		showchangevk.setForeground(new Color(255, 0, 0));
		if(!Variable.iflag) {
			changevk.setEnabled(false);
			showchangevk.setText("无法在快捷键功能关闭时修改");
		}
		changevk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(Variable.changingnum==0) {
					Variable.changingnum=1;
					changevk.setText("我已按下新的快捷键");
					showchangevk.setText("按下新的快捷键 然后单击按钮");
					File tempflag = new File(".\\changevk.key");
					try {
						if(tempflag.exists()) {
							tempflag.delete();
						}
						tempflag.createNewFile();
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
				else if(Variable.changingnum==1) {
					Variable.changingnum=0;
					File tempflag = new File(".\\changevk.key");
					tempflag.delete();
					File returntext = new File(".\\setreturn.key");
					if(!returntext.exists()) {
						changevk.setText("更换快捷键");
						showchangevk.setText("修改失败 未按下按键或程序错误");
						return;
					}
					try {
						FileReader fr = new FileReader(returntext);
						BufferedReader br = new BufferedReader(fr);
						Variable.vkcode=Integer.parseInt(br.readLine());
						br.close();
						fr.close();
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					returntext.delete();
					changevk.setText("更换快捷键");
					showchangevk.setText("完成修改");
					nowvk.setText("当前快捷键："+Variable.vkcodes[Variable.vkcode]);
					vkcoding.setText("点名快捷键  \""+Variable.vkcodes[Variable.vkcode]+"\"");
				}
			}
		});
		vkcode.add(nowvk);
		vkcode.add(nowvk0);
		vkcode.add(changevk);
		vkcode.add(showchangevk);
		
		
		JButton back = new JButton("保存设置",new ImageIcon(".\\res\\images\\accept.png"));
		back.setFont(new Font("", 1, 25));
		back.setBounds(20, 565, 850, 75);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				setting.setVisible(false);
				menu.setVisible(true);
				if(writer.isSelected()) {
					Variable.questionflag=true;
					nowquestion.setText(Nowquestiondata.name);
					pnowquestion.setText(Nowquestiondata.name);
					if(Nowquestiondata.name.equals("尚未载入题组")) {
						start.setEnabled(false);
					}
				}
				else {
					Variable.questionflag=false;
					nowquestion.setText("<html>题组功能未开启<br/>请在设置中开启</html>");
					pnowquestion.setText("题组功能未开启");
					if(!Nowteamdata.teamname.equals("尚未载入名单")) {
						start.setEnabled(true);
					}
				}
				try {
					File flag = new File(".\\settings\\q_switch.lxc");
					FileWriter fw0 = new FileWriter(flag);
					BufferedWriter bw0 = new BufferedWriter(fw0);
					if(writer.isSelected()) {
						bw0.write("1");
						bw0.flush();
					}
					else {
						bw0.write("0");
						bw0.flush();
					}
					bw0.close();
					fw0.close();
				} catch (IOException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}

				try {
					File flag = new File(".\\settings\\i_switch.lxc");
					FileWriter fw0 = new FileWriter(flag);
					BufferedWriter bw0 = new BufferedWriter(fw0);
					if(writer0.isSelected()) {
						bw0.write("1");
						bw0.flush();
					}
					else {
						bw0.write("0");
						bw0.flush();
					}
					bw0.close();
					fw0.close();
				} catch (IOException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}
				
				try {
					File flag = new File(".\\settings\\teammode.lxc");
					FileWriter fw0 = new FileWriter(flag);
					BufferedWriter bw0 = new BufferedWriter(fw0);
					if(r1.isSelected()) {
						bw0.write("1");
						bw0.flush();
					}
					else {
						bw0.write("0");
						bw0.flush();
					}
					bw0.close();
					fw0.close();
				} catch (IOException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}
				
				try {
					File flag = new File(".\\settings\\questionmode.lxc");
					FileWriter fw0 = new FileWriter(flag);
					BufferedWriter bw0 = new BufferedWriter(fw0);
					if(r11.isSelected()) {
						bw0.write("1");
						bw0.flush();
					}
					else {
						bw0.write("0");
						bw0.flush();
					}
					bw0.close();
					fw0.close();
				} catch (IOException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}
				
				try {
					File flag = new File(".\\settings\\vkcode.lxc");
					FileWriter fw0 = new FileWriter(flag);
					BufferedWriter bw0 = new BufferedWriter(fw0);
					bw0.write(String.valueOf(Variable.vkcode));
					bw0.flush();
					bw0.close();
					fw0.close();
				} catch (IOException e2) {
					// TODO 自动生成的 catch 块
					e2.printStackTrace();
				}
				
				try {
					File default0 = new File(".\\settings\\teamdefaultset.lxc");
					FileWriter fw = new FileWriter(default0);
					BufferedWriter bw = new BufferedWriter(fw);
					String temp;
					temp = (String) s_defaultteam.getSelectedItem();
					if(temp!=null) {
						bw.write(temp);
						bw.flush();
					}
					else {
						bw.write("none");
						bw.flush();
					}
					bw.close();
					fw.close();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				try {
					File default0 = new File(".\\settings\\questiondefaultset.lxc");
					FileWriter fw = new FileWriter(default0);
					BufferedWriter bw = new BufferedWriter(fw);
					String temp;
					temp = (String) s_defaultquestion.getSelectedItem();
					if(temp!=null) {
						bw.write(temp);
						bw.flush();
					}
					else {
						bw.write("none");
						bw.flush();
					}
					bw.close();
					fw.close();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				Myfile.creattemp();
			}
		});
		
		container7.add(team);
		container7.add(question);
		container7.add(switchs);
		container7.add(vkcode);
		container7.add(back);
	}
	
	
	public static void showpointing () {
		
		pointing.setLayout(null);
		pointing.setVisible(false);
		pointing.setSize(1000,750);
		pointing.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pointing.setLocationRelativeTo(null);
		pointing.setResizable(false);
		
		JLabel result = new JLabel();
		result.setText("点击按钮...");
		result.setFont(new Font("",1,100));
		result.setBounds(400, 30, 550, 160);
		result.setHorizontalAlignment(SwingConstants.CENTER);
		result.setBorder(new EtchedBorder());
		container2.add(result);
		
		if(Variable.questionflag) {
			question.setText("点击按钮...");
		}
		else {
			question.setText("题组功能未开启");
			question.setEnabled(false);
		}
		
		question.setBackground(new Color(255, 255, 255));
		question.setFont(new Font("", 1, 45));
		question.setLineWrap(true);
		question.setEditable(false);
		JScrollPane s_question = new JScrollPane(question);
		s_question.setBounds(50, 200, 900, 300);
		
		pnowteam.setText(Nowteamdata.teamname);
		pnowteam.setBounds(50, 500, 450, 75);
		pnowteam.setFont(new Font("", 1, 35));
		pnowteam.setHorizontalAlignment(SwingConstants.CENTER);
		container2.add(pnowteam);
		if(!Variable.questionflag) {
			pnowquestion.setText("题组功能未开启");
		}
		else {
			pnowquestion.setText(Nowquestiondata.name);
		}
		pnowquestion.setBounds(500, 500, 450, 75);
		pnowquestion.setHorizontalAlignment(SwingConstants.CENTER);
		pnowquestion.setFont(new Font("", 1, 35));
		container2.add(pnowquestion);
		
		JButton start = new JButton("点名",new ImageIcon(".\\res\\images\\go.png"));
		
		changeq.setBounds(800, 425, 150, 75);
		changeq.setFont(new Font("", 1, 18));
		start.setFont(new Font("", 1, 40));
		JButton back = new JButton("返回",new ImageIcon(".\\res\\images\\back.png"));
		start.setBounds(50, 50, 300, 100);
		back.setBounds(50, 600, 900, 100);
		back.setFont(new Font("", 1, 40));
		container2.add(start);
		container2.add(changeq);
		container2.add(s_question);
		container2.add(back);
		
		changeq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int temp[] = new int[2];
				temp=Choosecore.chooseit();
				while((lastquestion.equals(Variable.nowquestion)&&Nowquestiondata.totalmember>=2)
						||(Nowquestiondata.flag[temp[1]]==true&&!Variable.questionmode)) {
					temp=Choosecore.chooseit();
				}
				question.setText(Variable.nowquestion);
				Nowquestiondata.times++;
				Nowquestiondata.flag[temp[1]]=true;
				if(Nowquestiondata.times==Nowquestiondata.totalmember) {
					for(int i = 0 ; i<Nowquestiondata.totalmember;i++) {
						Nowquestiondata.flag[i]=false;
					}
					Nowquestiondata.times=0;
				}
				lastquestion=Variable.nowquestion;
			}
		});
		
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int temp[] = new int[2];
				temp=Choosecore.chooseit();
				while((lastname.equals(Variable.nowresult)&&Nowteamdata.totalmember>=2)
						||(Nowteamdata.flag[temp[0]]==true&&!Variable.teammode)) {
					temp=Choosecore.chooseit();
				}
				result.setText(Variable.nowresult);
				Nowteamdata.times++;
				Nowteamdata.flag[temp[0]]=true;
				if(Nowteamdata.times==Nowteamdata.totalmember) {
					for(int i = 0 ; i<Nowteamdata.totalmember;i++) {
						Nowteamdata.flag[i]=false;
					}
					Nowteamdata.times=0;
				}
				lastname=Variable.nowresult;
				if(Variable.questionflag) {
					while((lastquestion.equals(Variable.nowquestion)&&Nowquestiondata.totalmember>=2)
							||(Nowquestiondata.flag[temp[1]]==true&&!Variable.questionmode)) {
						temp=Choosecore.chooseit();
					}
					question.setText(Variable.nowquestion);
					Nowquestiondata.times++;
					Nowquestiondata.flag[temp[1]]=true;
					if(Nowquestiondata.times==Nowquestiondata.totalmember) {
						for(int i = 0 ; i<Nowquestiondata.totalmember;i++) {
							Nowquestiondata.flag[i]=false;
						}
						Nowquestiondata.times=0;
					}
					lastquestion=Variable.nowquestion;
				}
			}
		});
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(true);
				pointing.setVisible(false);
			}
			
		});
		
	}
	
	public static void showchanging () {
		changing.setResizable(false);
		changing.setVisible(false);
		changing.setBounds(0,0,650, 400);
		changing.setLocationRelativeTo(null);
		changing.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		changing.setLayout(null);
		
		selecting.setListData(Variable.teamnamelist);
		selecting.setFont(new Font("", 1, 20));
		JScrollPane selecting_js = new JScrollPane(selecting);
		selecting_js.setBounds(25, 100, 200, 150);
		
		JButton accept = new JButton("确定",new ImageIcon(".\\res\\images\\accept.png"));
		accept.setToolTipText("载入选定的名单");
		accept.setEnabled(false);
		JButton deleteteam = new JButton("删除",new ImageIcon(".\\res\\images\\delete.png"));
		deleteteam.setToolTipText("删除该名单的所有信息");
		deleteteam.setEnabled(false);
		deleteteam.setBounds(25, 305, 200, 40);
		accept.setBounds(25, 260, 200, 40);
		
		JLabel middle_or = new JLabel("或者");
		middle_or.setFont(new Font("",1,50));
		middle_or.setBounds(250, 0, 150, 400);
		middle_or.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel left_text = new JLabel("选择已有名单");
		left_text.setFont(new Font("",1,30));
		left_text.setBounds(0, 0, 250, 100);
		left_text.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel right_text = new JLabel("创建新的名单");
		right_text.setFont(new Font("",1,30));
		right_text.setBounds(0, 0, 250, 100);
		right_text.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JPanel left = new JPanel();
		left.setLayout(null);
		left.setBounds(0, 0, 250, 400);
		left.add(left_text);
		left.add(selecting_js);
		left.add(deleteteam);
		left.add(accept);
		
		JPanel right = new JPanel();
		right.setLayout(null);
		right.setBounds(400, 0, 250, 400);
		right.add(right_text);
		
		newname.setBounds(25, 150, 200, 50);
		newname.setFont(new Font("",0,20));
		newname.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				if(newname.getText().equals(("名单"+(Variable.teamscount+1))))
				newname.setText("点这里输入组名");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				if(newname.getText().equals("点这里输入组名"))
					newname.setText("名单"+(Variable.teamscount+1));
			}
		});
		
		JButton back = new JButton("返回",new ImageIcon(".\\res\\images\\back.png"));
		JButton creat = new JButton("以此名称创建",new ImageIcon(".\\res\\images\\add.png"));
		creat.setBounds(50, 250, 150, 70);
		creat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(Variable.enterflag[6]==false) {
					Mywindow.showcreating();
					Variable.enterflag[6]=true;
				}
				if(newname.getText().equals("点这里输入组名"))
					Variable.creatingname="名单"+(Variable.teamscount+1);
				else
					Variable.creatingname=newname.getText();
				newteamname.setText(Variable.creatingname);
				container4.add(newteamname);
				changing.setVisible(false);
				creating1.setVisible(true);
			}
		});
		
		right.add(creat);
		back.setBounds(275, 300, 100, 60);
		
		
		right.add(newname);
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(true);
				changing.setVisible(false);
			}
			
		});
		accept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(true);
				changing.setVisible(false);
				Errortext.errorchecking(Myfile.readfile(selecting.getSelectedValue()),selecting.getSelectedValue());
				nowteam.setText(Nowteamdata.teamname);
				if(Nowquestiondata.name.equals("尚未载入题组")&&Variable.questionflag) {
					start.setEnabled(false);
				}
				else {
					start.setEnabled(true);
				}
			}
		});
		
		deleteteam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(true);
				changing.setVisible(false);
				String temp=selecting.getSelectedValue();
				Errortext.errorchecking(Myfile.deletefile(temp),temp);
				
			}
		});
		selecting.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO 自动生成的方法存根
				if(Variable.teamscount!=0) {
					accept.setEnabled(true);
					deleteteam.setEnabled(true);
				}
				if(selecting.getSelectedValue()==null) {
					accept.setEnabled(false);
					deleteteam.setEnabled(false);
					deleteteam.setEnabled(false);
				}
			}
		});
		container3.add(left);
		container3.add(middle_or);
		container3.add(right);
		container3.add(back);
	}
	
	public static void showcreating() {
		
		creating1.setResizable(false);
		creating1.setVisible(false);
		creating1.setBounds(0,0,600, 400);
		creating1.setLocationRelativeTo(null);
		creating1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		creating1.setLayout(null);
		creating2.setVisible(false);
		creating2.setBounds(0,0,600, 400);
		creating2.setLocationRelativeTo(null);
		creating2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		creating2.setLayout(null);
		creating2.setResizable(false);
		
		JLabel notes = new JLabel("您正在创建：");
		JLabel notes2 = new JLabel("输入名单或使用Ctrl+v粘贴名单");
		JLabel notes3 = new JLabel("确定名称组：");
		JLabel notes4 = new JLabel("名单");
		JLabel notes5 = new JLabel("额外选项");
		notes.setBounds(0, 0, 600, 30);
		newteamname.setBounds(0, 30, 600, 50);
		notes2.setBounds(0, 80, 600, 30);
		notes3.setBounds(0, 0, 600, 30);
		notes4.setBounds(0, 80, 300, 30);
		notes5.setBounds(300, 80, 300, 30);
		notes.setFont(new Font("", 0, 25));
		newteamname.setFont(new Font("", 1, 50));
		notes2.setFont(new Font("", 0, 25));
		notes3.setFont(new Font("", 0, 25));
		notes4.setFont(new Font("", 1, 25));
		notes5.setFont(new Font("", 1, 25));
		notes.setHorizontalAlignment(SwingConstants.CENTER);
		newteamname.setHorizontalAlignment(SwingConstants.CENTER);
		notes2.setHorizontalAlignment(SwingConstants.CENTER);
		notes3.setHorizontalAlignment(SwingConstants.CENTER);
		notes4.setHorizontalAlignment(SwingConstants.CENTER);
		notes5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextArea namelist = new JTextArea();
		namelist.setBackground(new Color(200, 200, 200));
		JScrollPane namelist_js = new JScrollPane(namelist);
		namelist_js.setBounds(50, 110, 500, 170);
		
		JList<String> acceptclass = new JList<>();
		acceptclass.setFont(new Font("", 0, 20));
		JScrollPane acceptclass_js = new JScrollPane(acceptclass);
		acceptclass_js.setBounds(50, 110, 200, 175);
		
		JCheckBox extra1 = new JCheckBox("立即载入此名单", true);
		extra1.setFont(new Font("", 1, 18));
		JCheckBox extra2 = new JCheckBox("将此班级设定为默认名单", false);
		extra2.setFont(new Font("", 1, 18));
		extra1.setBounds(350, 150, 250, 50);
		extra2.setBounds(350, 200, 250, 50);
		
		JButton next1 = new JButton("下一步",new ImageIcon(".\\res\\images\\next.png"));
		JButton prev1 = new JButton("上一步",new ImageIcon(".\\res\\images\\prev.png"));
		JButton next2 = new JButton("确认创建",new ImageIcon(".\\res\\images\\add.png"));
		JButton prev2 = new JButton("上一步",new ImageIcon(".\\res\\images\\prev.png"));
		JButton tips1 = new JButton("操作提示");
		prev1.setBounds(50, 295, 125, 60);
		prev2.setBounds(50, 295, 125, 60);
		next1.setBounds(425, 295, 125, 60);
		next2.setBounds(425, 295, 125, 60);
		tips1.setBounds(237, 295, 125, 60);
		tips1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JDialog showtip = new JDialog(creating1);
				showtip.setTitle("提示信息");
				showtip.setVisible(true);
				showtip.setSize(400, 200);
				showtip.setResizable(false);
				showtip.setLocationRelativeTo(null);
				String temp = "<html>您可以在excel表格中复制名单后<br/>同时按下Ctrl键和v键来粘贴名单<br/>也可以直接输入<br/>每输入一个名字另起一行</html>";
				JLabel pikachu = new JLabel(temp);
				showtip.add(pikachu);
				pikachu.setFont(new Font("", 1, 25));
			}
		});
		prev1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				creating1.setVisible(false);
				changing.setVisible(true);
				selecting.setListData(Variable.teamnamelist);
			}
		});
		next1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(!namelist.getText().equals(""))
					Variable.tempnamelist = namelist.getText().split("\n");
				else {
					Errortext.errorchecking(1002, null);
					return;
				}
				creating1.setVisible(false);
				creating2.setVisible(true);
				container5.add(newteamname);
				acceptclass.setListData(Variable.tempnamelist);
			}
		});
		prev2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				creating1.setVisible(true);
				creating2.setVisible(false);
				container4.add(newteamname);
			}
		});
		next2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(true);
				creating2.setVisible(false);
				Errortext.errorchecking(Myfile.creatfile(Variable.creatingname),Variable.creatingname);
				namelist.setText(null);
				newname.setText("点这里输入组名");
				s_defaultteam.addItem(Variable.creatingname);
				if(extra1.isSelected()) {
					Errortext.errorchecking(Myfile.readfile(Variable.creatingname),Variable.creatingname);
					nowteam.setText(Nowteamdata.teamname);
					if(Nowquestiondata.name.equals("尚未载入题组")&&Variable.questionflag) {
						start.setEnabled(false);
					}
					else {
						start.setEnabled(true);
					}
				}
				if(extra2.isSelected()) {
					s_defaultteam.setSelectedItem(Variable.creatingname);
					File default0 = new File(".\\settings\\teamdefaultset.lxc");
					try {
						FileWriter fw = new FileWriter(default0);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(Variable.creatingname);
						bw.flush();
						bw.close();
						fw.close();
					} catch (IOException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
					
				}
			}
		});
		container4.add(newteamname);
		container4.add(notes);
		container4.add(notes2);
		container4.add(namelist_js);
		container4.add(next1);
		container4.add(tips1);
		container4.add(prev1);
		container5.add(next2);
		container5.add(prev2);
		container5.add(notes3);
		container5.add(notes4);
		container5.add(notes5);
		container5.add(acceptclass_js);
		container5.add(extra1);
		container5.add(extra2);
	}
	
	public static void preparing () {
		Myfile.dicchecking();
		Myfile.defaultread();
		Myfile.creattemp();
		Variable.refreshing();
		Variable.loadreading();
	}
	
	public static void main(String[] args) {
		File startcheck = new File(".\\1q9w6e1r6t3y6u3i0o6.key");
		if(!startcheck.exists()) {
			System.exit(0);
		}
		
		preparing();
		
		small.setVisible(false);
		small.setBounds(0,0,250, 180);
		small.setResizable(false);
		small.setLocationRelativeTo(null);
		small.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		small.setLayout(null);
		small.setAlwaysOnTop(true);
		JButton doit = new JButton("点名");
		JButton back = new JButton("返回");
		doit.setFont(new Font("", 1, 35));
		back.setFont(new Font("", 1, 35));
		doit.setBounds(0, 0, 250, 100);
		back.setBounds(0, 100, 250, 50);
		container9.add(doit);
		container9.add(back);
		doit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int temp[] = new int[2];
				temp=Choosecore.chooseit();
				while((lastname.equals(Variable.nowresult)&&Nowteamdata.totalmember>=2)
						||(Nowteamdata.flag[temp[0]]==true&&!Variable.teammode)) {
					temp=Choosecore.chooseit();
				}
				doit.setText(Variable.nowresult);
				System.out.println(Variable.nowresult);
				Nowteamdata.times++;
				Nowteamdata.flag[temp[0]]=true;
				if(Nowteamdata.times==Nowteamdata.totalmember) {
					for(int i = 0 ; i<Nowteamdata.totalmember;i++) {
						Nowteamdata.flag[i]=false;
					}
					Nowteamdata.times=0;
				}
				lastname=Variable.nowresult;
			}
		});
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				small.setVisible(false);
				menu.setVisible(true);
				Variable.minwindow=false;
			}
		});
		
		
		checking.setLayout(null);
		checking.setVisible(false);
		checking.setBounds(0,0,500, 750);
		checking.setResizable(false);
		checking.setLocationRelativeTo(null);
		checking.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel type = new JLabel("组的类型");
		JLabel targetname = new JLabel("组的名称");
		JList<String> showtarget = new JList<>();
		showtarget.setFont(new Font("", 1, 20));
		JButton backtarget = new JButton("确定",new ImageIcon(".\\res\\images\\accept.png"));
		backtarget.setFont(new Font("", 1, 25));
		type.setBounds(0, 0, 500, 100);
		type.setFont(new Font("", 1, 30));
		type.setHorizontalAlignment(SwingConstants.CENTER);
		backtarget.setBounds(150, 610, 200, 80);
		targetname.setBounds(0, 75, 500, 100);
		targetname.setFont(new Font("", 1, 50));
		targetname.setHorizontalAlignment(SwingConstants.CENTER);
		JScrollPane js_showtarget = new JScrollPane(showtarget);
		js_showtarget.setBounds(150, 200, 200, 350);
		
		backtarget.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(true);
				checking.setVisible(false);
			}
		});
		
		container10.add(backtarget);
		container10.add(type);
		container10.add(targetname);
		container10.add(js_showtarget);
		
		
		
		
		
		menu.setLayout(null);
		menu.setVisible(true);
		menu.setBounds(0,0,1000, 750);
		menu.setResizable(false);
		menu.setLocationRelativeTo(null);
		menu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel border1 = new JPanel();
		JPanel border2 = new JPanel();
		border1.setBounds(310, 10, 330, 500);
		border2.setBounds(650, 10, 330, 500);
		border1.setLayout(null);
		border2.setLayout(null);
		border1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3),
				"名单信息", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("", 1, 20)));
		border2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3),
				"题组信息", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("", 1, 20)));
		
		
		start.setToolTipText("进入点名界面");
		start.setFont(new Font("", 1, 30));
		start.setBounds(30, 170, 150, 150);
		if(Nowteamdata.teamname.equals("尚未载入名单")) {
			start.setEnabled(false);
		}
		if(Nowquestiondata.name.equals("尚未载入题组")&&Variable.questionflag) {
			start.setEnabled(false);
		}
		container.add(start);
		
		JButton smallstart = new JButton("<html>简易<br/>模式</html>");
		smallstart.setFont(new Font("", 1, 30));
		smallstart.setBounds(190, 170, 100, 150);
		container.add(smallstart);
		smallstart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Variable.minwindow=true;
				menu.setVisible(false);
				small.setVisible(true);
				if(Nowteamdata.teamname=="尚未载入名单") {
					doit.setEnabled(false);
					doit.setText("请载入名单");
				}
				else {
					doit.setEnabled(true);
					doit.setText("点名");
				}
			}
		});
		
		JButton changeteam = new JButton("载入名单");
		changeteam.setFont(new Font("", 1, 30));
		changeteam.setToolTipText("<html>选择或改变已有的名单<br/>也可创建新的名单</html>");
		changeteam.setBounds(42, 375, 250, 100);
		border1.add(changeteam);
		JButton changequestion = new JButton("载入题组");
		changequestion.setBounds(42, 375, 250, 100);
		changequestion.setFont(new Font("", 1, 30));
		changequestion.setToolTipText("<html>选择或改变已有的题目信息<br/>也可创建新的题目信息</html>");
		border2.add(changequestion);
		
		JButton lookteam = new JButton("查看此名单");
		JButton lookq = new JButton("查看此题组");
		lookteam.setBounds(42, 275, 250, 75);
		lookq.setBounds(42, 275, 250, 75);
		lookteam.setFont(new Font("", 1, 30));
		lookq.setFont(new Font("", 1, 30));
		border1.add(lookteam);
		border2.add(lookq);
		smallstart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(false);
				Variable.minwindow=true;
			}
		});
		lookteam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(Nowteamdata.teamname.equals("尚未载入名单")) {
					return;
				}
				type.setText("名单");
				String[] temp= new String[Nowteamdata.totalmember];
				for(int i=0;i<Nowteamdata.totalmember;i++) {
					temp[i] = Nowteamdata.membername[i];
				}
				targetname.setText(Nowteamdata.teamname);
				showtarget.setListData(temp);
				menu.setVisible(false);
				checking.setVisible(true);
			}
		});
		lookq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(Nowquestiondata.name.equals("尚未载入题组")) {
					return;
				}
				type.setText("题组");
				String[] temp= new String[Nowquestiondata.totalmember];
				for(int i=0;i<Nowquestiondata.totalmember;i++) {
					temp[i] = Nowquestiondata.member[i];
				}
				targetname.setText(Nowquestiondata.name);
				showtarget.setListData(temp);
				menu.setVisible(false);
				checking.setVisible(true);
			}
		});
		
		JButton others = new JButton("关于",new ImageIcon(".\\res\\images\\information.png"));
		others.setFont(new Font("", 1, 30));
		others.setBounds(352, 550, 250, 100);
		container.add(others);
		JButton settings = new JButton("设置",new ImageIcon(".\\res\\images\\set.png"));
		settings.setToolTipText("更改程序设置");
		settings.setBounds(692, 550, 250, 100);
		settings.setForeground(new Color(255, 0, 0));
		settings.setFont(new Font("", 1, 30));
		container.add(settings);
		
		JLabel title = new JLabel("随机抽取",SwingConstants.CENTER);
		title.setFont(new Font("", 1, 60));
		title.setBounds(0, 30, 300, 100);
		container.add(title);
		
		vkcoding.setText("点名快捷键  \""+Variable.vkcodes[Variable.vkcode]+"\"");
		vkcoding.setFont(new Font("", 1, 25));
		vkcoding.setBounds(0, 350, 300, 40);
		container.add(vkcoding);
		JLabel vkcoding2 = new JLabel("可在设置中更改",SwingConstants.CENTER);
		vkcoding2.setFont(new Font("", 1, 25));
		vkcoding2.setBounds(0, 390, 300, 35);
		container.add(vkcoding2);
		
		JLabel listener = new JLabel();
		listener.setHorizontalAlignment(SwingConstants.CENTER);
		if(Variable.iflag) {
			if(Myfile.backcheck()==0) {
				listener.setText("<html>此功能出现未知错误<br/>请将问题反馈给作者</html>");
				listener.setForeground(new Color(255, 0, 0));
			}
			else {
				listener.setText("此功能已开启");
				listener.setForeground(new Color(0, 170, 0));
			}
		}
		else if(!Variable.iflag){
			listener.setText("此功能未开启");
			listener.setForeground(new Color(255, 0, 0));
		}
		listener.setBounds(0, 430, 300, 75);
		listener.setFont(new Font("", 1, 25));
		container.add(listener);
		
		JLabel creator = new JLabel("<html>梁笑尘制作<br/>版本号 1.4</html>",SwingConstants.CENTER);
		creator.setFont(new Font("", 1, 45));
		creator.setForeground(new Color(200,200,200));
		creator.setBounds(0, 500, 300, 150);
		container.add(creator);
		
		JLabel a1 = new JLabel("当前名单为",SwingConstants.CENTER);
		JLabel a2 = new JLabel("当前题组为",SwingConstants.CENTER);
		a1.setFont(new Font("", 1, 30));
		a2.setFont(new Font("", 1, 30));
		a1.setBounds(0, 50, 330, 100);
		a2.setBounds(0, 50, 330, 100);
		border1.add(a1);
		border2.add(a2);
		
		nowteam.setText(Nowteamdata.teamname);
		nowteam.setHorizontalAlignment(SwingConstants.CENTER);
		nowteam.setFont(new Font("", 1, 40));
		nowteam.setBounds(0, 100, 330, 200);
		nowteam.setForeground(new Color(0,0, 255));
		border1.add(nowteam);
		
		if(!Variable.questionflag) {
			nowquestion.setText("<html>题组功能未开启<br/>请在设置中开启</html>");
		}
		else {
			nowquestion.setText(Nowquestiondata.name);
		}
		nowquestion.setHorizontalAlignment(SwingConstants.CENTER);
		nowquestion.setFont(new Font("", 1, 40));
		nowquestion.setBounds(0, 100, 330, 200);
		nowquestion.setForeground(new Color(0, 0,255));
		border2.add(nowquestion);
		
		container.add(border1);
		container.add(border2);
		
		
		settings.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(false);
				if(Variable.enterflag[4]==false) {
					Mywindow.showsetting();
					Variable.enterflag[4]=true;
				}
				setting.setVisible(true);
				File default0 = new File(".\\settings\\teamdefaultset.lxc");
				
				try {
					FileReader fr = new FileReader(default0);
					BufferedReader bw = new BufferedReader(fr);
					String temp;
					temp=bw.readLine();
					if(!temp.equals("none")) {
						s_defaultteam.setSelectedItem(temp);
					}
					else {
						s_defaultteam.setSelectedIndex(-1);
					}
					bw.close();
					fr.close();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				File default00 = new File(".\\settings\\questiondefaultset.lxc");
				
				try {
					FileReader fr = new FileReader(default00);
					BufferedReader bw = new BufferedReader(fr);
					String temp;
					temp=bw.readLine();
					if(!temp.equals("none")) {
						s_defaultquestion.setSelectedItem(temp);
					}
					else {
						s_defaultquestion.setSelectedIndex(-1);
					}
					bw.close();
					fr.close();
				} catch (IOException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(false);
				if(Variable.enterflag[3]==false) {
					Mywindow.showpointing();
					Variable.enterflag[3]=true;
				}
				pointing.setVisible(true);
				pnowteam.setText(Nowteamdata.teamname);
				if(!Variable.questionflag) {
					pnowquestion.setText("题组功能未开启");
					question.setText("题组功能未开启");
					question.setEnabled(false);
					changeq.setEnabled(false);
				}
				else {
					pnowquestion.setText(Nowquestiondata.name);
					question.setText("点击按钮...");
					question.setEnabled(true);
					changeq.setEnabled(true);
				}
			}
			
		});
		changequestion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(false);
				if(Variable.enterflag[2]==false) {
					Mywindow.showqchanging();
					Variable.enterflag[2]=true;
				}
				qchanging.setVisible(true);
				qselecting.setListData(Variable.questionnamelist);
			}
		});
		
		changeteam.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(false);
				if(Variable.enterflag[1]==false) {
					Mywindow.showchanging();
					Variable.enterflag[1]=true;
				}
				changing.setVisible(true);
				selecting.setListData(Variable.teamnamelist);
			}
			
		});
		others.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				menu.setVisible(false);
				if(Variable.enterflag[0]==false) {
					Mywindow.showstaff();
					Variable.enterflag[0]=true;
				}
				staff.setVisible(true);
			}
		});
		
		menu.setExtendedState(ICONIFIED);
		menu.setExtendedState(NORMAL);
	}

}
