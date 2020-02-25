package listener;
import java.awt.*;
import java.io.*;

import java.util.Random;

import javax.swing.*;

import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HMODULE;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.HHOOK;
import com.sun.jna.platform.win32.WinUser.KBDLLHOOKSTRUCT;
import com.sun.jna.platform.win32.WinUser.LowLevelKeyboardProc;
import com.sun.jna.platform.win32.WinUser.MSG;

  
public class Mylisetener {
    private static HHOOK keyboardHHK;
    private static LowLevelKeyboardProc keyboardHook;
    private static int vkcodes;
    private static int number;
    private static String[] namelist;
    private static String name;
    private static JLabel showname = new JLabel("等待呼出");
    private static JFrame base = new JFrame("快捷呼出窗口 适用于随机抽取v1.3.1");
    private static String lastname="nhkaazmw";
    
    private static boolean setflag=false;
    
    private static void setHook() {
        HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
        keyboardHHK = User32.INSTANCE.SetWindowsHookEx(WinUser.WH_KEYBOARD_LL, keyboardHook, hMod, 0);      
    }
    private static void unHook() {
        User32.INSTANCE.UnhookWindowsHookEx(keyboardHHK); 
    }
    
    private static void readfile(String filename) {
    	File readfile = new File(".\\data\\team\\list\\"+filename+"_name"+".lxc");
		File readtimes = new File(".\\data\\team\\times\\"+filename+"_times"+".lxc");
		try {
			FileReader fr1 = new FileReader(readfile);
			FileReader fr2 = new FileReader(readtimes);
			FileReader fr0 = new FileReader(readfile);
			BufferedReader br1 = new BufferedReader(fr1);
			BufferedReader br2 = new BufferedReader(fr2);
			BufferedReader br0 = new BufferedReader(fr0);
			int i = 0;
			while(br0.readLine()!=null) {
				i++;
			}
			br0.close();
			fr0.close();
			number=i;
			namelist = new String[number+1];
			for(int o = 0;o<i;o++) {
				namelist[o]=br1.readLine();
			}
			br2.close();
			br1.close();
			fr2.close();
			fr1.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
    }
    
    private static void runchoose() {
    	
    	Container container = base.getContentPane();
    	base.setUndecorated(true);
    	base.setVisible(false);
    	base.setSize(1000, 350);
    	base.setLocationRelativeTo(null);
    	base.setAlwaysOnTop(true);
    	base.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	base.setLayout(new GridLayout(1, 1));
    	showname.setFont(new Font("", 1, 150));
    	showname.setBorder(BorderFactory.createEtchedBorder(new Color(4), new Color(0, 0, 0)));
    	showname.setHorizontalAlignment(SwingConstants.CENTER);
    	container.add(showname);
    }
    private static boolean exitcheck() {
    	File check0 = new File(".\\changevk.key");
    	if(check0.exists()) {
    		setflag=true;
    		return true;
    	}
    	File check = new File(".\\InstantCheck.lxc");
    	if(check.exists()) {
			try {
				FileReader fr = new FileReader(check);
				BufferedReader br = new BufferedReader(fr);
				vkcodes = Integer.parseInt(br.readLine());
				if(vkcodes==-1) {
					br.close();
					fr.close();
					return false;
				}
				String temp = br.readLine();
				if(!temp.equals(name)) {
					name = temp;
					readfile(name);
				}
				br.close();
				fr.close();
			} catch (NumberFormatException | IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
    		return true;
    	}
    	else {
    		System.exit(0);
    		return false;
    	}
    }
    
    public static void main(String[] args) {
    	File startcheck = new File(".\\1q9w6e1r6t3y6u3i0o6.key");
		if(!startcheck.exists()) {
			System.exit(0);
		}
    	runchoose();
        keyboardHook = new LowLevelKeyboardProc() {
              
            public LRESULT callback(int nCode, WPARAM wParam, KBDLLHOOKSTRUCT lParam) {
                unHook();
            	int w = wParam.intValue();
//                if(w==WinUser.WM_KEYDOWN || w==WinUser.WM_SYSKEYDOWN)
//                    System.out.println("key down: vkCode = "+lParam.vkCode);
//                else if(w==WinUser.WM_KEYUP || w==WinUser.WM_SYSKEYUP)
//                    System.out.println("key up: vkCode = "+lParam.vkCode);
                if(exitcheck()) {
                	if(setflag&&(w==WinUser.WM_KEYUP || w==WinUser.WM_SYSKEYUP)) {
                		setflag=false;
                		try {
        					File flag = new File(".\\setreturn.key");
        					if(flag.exists()) {
        						flag.delete();
        					}
        					flag.createNewFile();
        					FileWriter fw0 = new FileWriter(flag);
        					BufferedWriter bw0 = new BufferedWriter(fw0);
        					bw0.write(String.valueOf(lParam.vkCode));
        					bw0.flush();
        					bw0.close();
        					fw0.close();
        				} catch (IOException e2) {
        					// TODO 自动生成的 catch 块
        					e2.printStackTrace();
        				}
                	}
                	if(lParam.vkCode==vkcodes&&(w==WinUser.WM_KEYUP || w==WinUser.WM_SYSKEYUP)) {
                		Random choose = new Random();
                		String temp=namelist[choose.nextInt(number)];
                		while(number>=2&&temp.equals(lastname)) {
                			temp=namelist[choose.nextInt(number)];
                		}
                		lastname=temp;
                		base.setVisible(true);
                		showname.setText(temp);
                		try {
							Thread.sleep(1500);
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
                		base.setVisible(false);
                	}
                }
                setHook();
                return User32.INSTANCE.CallNextHookEx(keyboardHHK, nCode, wParam, lParam.getPointer());
            }
        };
        setHook();     
        base.setExtendedState(1);
        base.setExtendedState(0);
        File done = new File(".\\welldone.key");
        try {
			done.createNewFile();
			done.deleteOnExit();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        while ((User32.INSTANCE.GetMessage(new MSG(), null, 0, 0)) != 0) {          

        }
        System.exit(0);
    }   
      
      
}