package chooser;
import java.io.*;
public class Variable {
	public static boolean questionflag=false;
	public static boolean iflag=true;
	
	public static boolean teammode;
	public static boolean questionmode;
	
	public static boolean enterflag[] = new boolean[20];
	
	public static boolean minwindow=false;
	
	public static String[] tempnamelist;
	public static String[] qtempnamelist;
	public static String nowresult;//结果显示
	public static String nowquestion;//问题显示
	public static int questioncount;
	public static int teamscount;//组数
	public static String[] teamnamelist = new String[500];	
	public static String[] questionnamelist = new String[300];
	
	public static int vkcode;
	public static int changingnum=0;
	
	public final static String TITLE="随机抽取 v1.4";//程序标题
	
	public static final String[] intro = new String[4];
	public static final String[] vkcodes = new String[222+1];
	
	public static String creatingname;//正在创建的新名称
	public static String qcreatingname;
	
	public static void loadreading() {
		vkcodes[222]="'";
		vkcodes[221]="]";
		vkcodes[220]="\\";
		vkcodes[219]="[";
		vkcodes[192]="`";
		vkcodes[191]="/";
		vkcodes[190]=".";
		vkcodes[189]="-";
		vkcodes[188]=",";
		vkcodes[187]="=";
		vkcodes[186]=";";
		vkcodes[165]="右方Alt";
		vkcodes[164]="左方Alt";
		vkcodes[163]="右方Ctrl";
		vkcodes[162]="左方Ctrl";
		vkcodes[161]="右方Shift";
		vkcodes[160]="左方Shift";
		vkcodes[145]="ScrLK";
		vkcodes[144]="NmLk";
		vkcodes[123]="F12";
		vkcodes[122]="F11";
		vkcodes[121]="F10";
		vkcodes[120]="F9";
		vkcodes[119]="F8";
		vkcodes[118]="F7";
		vkcodes[117]="F6";
		vkcodes[116]="F5";
		vkcodes[115]="F4";
		vkcodes[114]="F3";
		vkcodes[113]="F2";
		vkcodes[112]="F1";
		vkcodes[111]="小键盘/";
		vkcodes[110]="小键盘.";
		vkcodes[109]="小键盘-";
		vkcodes[107]="小键盘+";
		vkcodes[106]="小键盘*";
		vkcodes[105]="小键盘9";
		vkcodes[104]="小键盘8";
		vkcodes[103]="小键盘7";
		vkcodes[102]="小键盘6";
		vkcodes[101]="小键盘5";
		vkcodes[100]="小键盘4";
		vkcodes[99]="小键盘3";
		vkcodes[98]="小键盘2";
		vkcodes[97]="小键盘1";
		vkcodes[96]="小键盘0";
		vkcodes[91]="Windows键";
		vkcodes[90]="z";
		vkcodes[89]="y";
		vkcodes[88]="x";
		vkcodes[87]="w";
		vkcodes[86]="v";
		vkcodes[85]="u";
		vkcodes[84]="t";
		vkcodes[83]="s";
		vkcodes[82]="r";
		vkcodes[81]="q";
		vkcodes[80]="p";
		vkcodes[79]="o";
		vkcodes[78]="n";
		vkcodes[77]="m";
		vkcodes[76]="l";
		vkcodes[75]="k";
		vkcodes[74]="j";
		vkcodes[73]="i";
		vkcodes[72]="h";
		vkcodes[71]="g";
		vkcodes[70]="f";
		vkcodes[69]="e";
		vkcodes[68]="d";
		vkcodes[67]="c";
		vkcodes[66]="b";
		vkcodes[65]="a";
		vkcodes[57]="9";
		vkcodes[56]="8";
		vkcodes[55]="7";
		vkcodes[54]="6";
		vkcodes[53]="5";
		vkcodes[52]="4";
		vkcodes[51]="3";
		vkcodes[50]="2";
		vkcodes[49]="1";
		vkcodes[48]="0";
		vkcodes[46]="Delete";
		vkcodes[45]="Insert";
		vkcodes[44]="PrtSc";
		vkcodes[40]="↓";
		vkcodes[39]="→";
		vkcodes[38]="↑";
		vkcodes[37]="←";
		vkcodes[36]="Home";
		vkcodes[35]="End";
		vkcodes[34]="PgDn";
		vkcodes[33]="PgUp";
		vkcodes[32]="空格";
		vkcodes[27]="Esc";
		vkcodes[20]="CapsLock";
		vkcodes[19]="Pause";
		vkcodes[13]="回车";
		vkcodes[9]="Tab";
		vkcodes[8]="退格";
		intro[0]="可重复：较小概率出现近期已被点名的人";
		intro[1]="不重复：已被点名的人将不再出现";
		intro[2]="可重复：一道题有可能在短期内多次出现";
		intro[3]="不重复：已被抽出的题将不再出现";
	}
	
	public static void refreshing() {//从文件中读取需要准备的数据
		for(int i = 0; i <20; i++) {
			enterflag[i] = false;
		}
		nowresult = "抽取结果";
		nowquestion = "题目抽取结果";
		File prereading = new File(".\\data\\teamlist.lxc");
		if(!prereading.exists()) {
			teamscount=0;
			try {
				prereading.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return;
		}
		try {
			FileReader fr1 = new FileReader(prereading);
			BufferedReader br1 = new BufferedReader(fr1);
			int i=0;
			while(br1.readLine()!=null) {
				i++;
			}
			teamscount=i;
			br1.close();
			fr1.close();
			FileReader fr2 = new FileReader(prereading);
			BufferedReader br2 = new BufferedReader(fr2);
			for(int o = 0; o<teamscount;o++) {
				Variable.teamnamelist[o]=br2.readLine();
			}
			br2.close();
			fr2.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		
		File prereading0 = new File(".\\data\\questionlist.lxc");
		if(!prereading0.exists()) {
			questioncount=0;
			try {
				prereading0.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return;
		}
		try {
			FileReader fr1 = new FileReader(prereading0);
			BufferedReader br1 = new BufferedReader(fr1);
			int i=0;
			while(br1.readLine()!=null) {
				i++;
			}
			questioncount=i;
			br1.close();
			fr1.close();
			FileReader fr2 = new FileReader(prereading0);
			BufferedReader br2 = new BufferedReader(fr2);
			for(int o = 0; o<questioncount;o++) {
				Variable.questionnamelist[o]=br2.readLine();
			}
			br2.close();
			fr2.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return;
		
	}
}
