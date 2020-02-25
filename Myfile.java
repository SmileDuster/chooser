package chooser;

import java.io.*;

public class Myfile {
	public static void dicchecking () {//内部文件检查和创建
		
		File rescheck = new File(".\\res");
		if(rescheck.exists()) {
			if(!rescheck.isDirectory()) {
				rescheck.delete();
				rescheck.mkdirs();
			}
		}
		else {
			rescheck.mkdirs();
		}
		
		File res_imagecheck = new File(".\\res\\images");
		if(res_imagecheck.exists()) {
			if(!res_imagecheck.isDirectory()) {
				res_imagecheck.delete();
				res_imagecheck.mkdirs();
			}
		}
		else {
			res_imagecheck.mkdirs();
		}
		
		File datacheck = new File(".\\data");
		if(datacheck.exists()) {
			if(!datacheck.isDirectory()) {
				datacheck.delete();
				datacheck.mkdirs();
			}
		}
		else {
			datacheck.mkdirs();
		}
		
		File data_teamcheck = new File(".\\data\\team");
		if(data_teamcheck.exists()) {
			if(!data_teamcheck.isDirectory()) {
				data_teamcheck.delete();
				data_teamcheck.mkdirs();
			}
		}
		else {
			data_teamcheck.mkdirs();
		}
		
		File data_team_listcheck = new File(".\\data\\team\\list");
		if(data_team_listcheck.exists()) {
			if(!data_team_listcheck.isDirectory()) {
				data_team_listcheck.delete();
				data_team_listcheck.mkdirs();
			}
		}
		else {
			data_team_listcheck.mkdirs();
		}
		
		
		File data_questioncheck = new File(".\\data\\question");
		if(data_questioncheck.exists()) {
			if(!data_questioncheck.isDirectory()) {
				data_questioncheck.delete();
				data_questioncheck.mkdirs();
			}
		}
		else {
			data_questioncheck.mkdirs();
		}
		
		File data_question_listcheck = new File(".\\data\\question\\list");
		if(data_question_listcheck.exists()) {
			if(!data_question_listcheck.isDirectory()) {
				data_question_listcheck.delete();
				data_question_listcheck.mkdirs();
			}
		}
		else {
			data_question_listcheck.mkdirs();
		}
		
		
		File setcheck = new File(".\\settings");
		if(setcheck.exists()) {
			if(!setcheck.isDirectory()) {
				setcheck.delete();
				setcheck.mkdirs();
			}
		}
		else {
			setcheck.mkdirs();
		}
		
		File delete = new File(".\\settings\\vkcode.txt");
		if(delete.exists()) {
			delete.delete();
		}
		
		File defaultset0000 = new File(".\\settings\\vkcode.lxc");
		if(!defaultset0000.exists()) {
			try {
				defaultset0000.createNewFile();
				FileWriter fw = new FileWriter(defaultset0000);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("186");
				bw.newLine();
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		File defaultset00 = new File(".\\settings\\q_switch.lxc");
		if(!defaultset00.exists()) {
			try {
				defaultset00.createNewFile();
				FileWriter fw = new FileWriter(defaultset00);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("0");
				bw.newLine();
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		File defaultset00000 = new File(".\\settings\\i_switch.lxc");
		if(!defaultset00000.exists()) {
			try {
				defaultset00000.createNewFile();
				FileWriter fw = new FileWriter(defaultset00000);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("1");
				bw.newLine();
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		File defaultset000000 = new File(".\\settings\\teammode.lxc");
		if(!defaultset000000.exists()) {
			try {
				defaultset000000.createNewFile();
				FileWriter fw = new FileWriter(defaultset000000);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("1");
				bw.newLine();
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		File defaultset0000000 = new File(".\\settings\\questionmode.lxc");
		if(!defaultset0000000.exists()) {
			try {
				defaultset0000000.createNewFile();
				FileWriter fw = new FileWriter(defaultset0000000);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("1");
				bw.newLine();
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		File defaultset0 = new File(".\\settings\\questiondefaultset.lxc");
		if(!defaultset0.exists()) {
			try {
				defaultset0.createNewFile();
				FileWriter fw = new FileWriter(defaultset0);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("none");
				bw.newLine();
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		File defaultset = new File(".\\settings\\teamdefaultset.lxc");
		if(!defaultset.exists()) {
			try {
				defaultset.createNewFile();
				FileWriter fw = new FileWriter(defaultset);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("none");
				bw.newLine();
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		File checkteamlist = new File(".\\data\\teamlist.lxc");
		File checkquestionlist = new File(".\\data\\questionlist.lxc");
		if(!checkteamlist.exists()) {
			try {
				checkteamlist.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if(!checkquestionlist.exists()) {
			try {
				checkquestionlist.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
	public static int creatq (String newfilename) {//创建新问题文件 1成功 0 失败 -1文件已存在
		File creatnewfile = new File(".\\data\\question\\list\\"+newfilename+"_name"+".lxc");
		File creatnewtimes = new File(".\\data\\question\\times\\"+newfilename+"_times"+".lxc");
		try {
			if(creatnewfile.exists()) {
				return -1;
			}
			if(creatnewtimes.exists()) {
				return -1;
			}
			creatnewfile.createNewFile();
			creatnewtimes.createNewFile();
			
			FileWriter fw1 = new FileWriter(creatnewfile);
			FileWriter fw2 = new FileWriter(creatnewtimes);
			BufferedWriter bw1 = new BufferedWriter(fw1);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			for (String x :Variable.qtempnamelist) {
				System.out.println(x);
				bw1.write(x);
				bw1.newLine();
				bw1.flush();
				bw2.write("0");
				bw2.newLine();
				bw2.flush();
			}
			fw1.close();
			fw2.close();
			bw1.close();
			bw2.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return 0;
		}
		File addteamlist = new File(".\\data\\questionlist.lxc");
		boolean flag=false;
		if(!addteamlist.exists()) {
			flag=true;
			try {
				addteamlist.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		try {
			FileWriter fw = new FileWriter(addteamlist);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i=0;i<Variable.questioncount;i++) {
				bw.write(Variable.questionnamelist[i]);
				bw.newLine();
				bw.flush();
			}
			bw.write(newfilename);
			bw.newLine();
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Variable.questionnamelist[Variable.questioncount]=newfilename;
		Variable.questioncount++;
		if(flag) {
			return -2;
		}
		return 1;
	}
	
	public static int creatfile (String newfilename) {//创建新班级文件 1 成功 0失败 -1 文件已存在
		File creatnewfile = new File(".\\data\\team\\list\\"+newfilename+"_name"+".lxc");
		File creatnewtimes = new File(".\\data\\team\\times\\"+newfilename+"_times"+".lxc");
		try {
			if(creatnewfile.exists()) {
				return -1;
			}
			if(creatnewtimes.exists()) {
				return -1;
			}
			creatnewfile.createNewFile();
			creatnewtimes.createNewFile();
			
			FileWriter fw1 = new FileWriter(creatnewfile);
			FileWriter fw2 = new FileWriter(creatnewtimes);
			BufferedWriter bw1 = new BufferedWriter(fw1);
			BufferedWriter bw2 = new BufferedWriter(fw2);
			for (String x :Variable.tempnamelist) {
				System.out.println(x);
				bw1.write(x);
				bw1.newLine();
				bw1.flush();
				bw2.write("0");
				bw2.newLine();
				bw2.flush();
			}
			fw1.close();
			fw2.close();
			bw1.close();
			bw2.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return 0;
		}
		File addteamlist = new File(".\\data\\teamlist.lxc");
		boolean flag=false;
		if(!addteamlist.exists()) {
			flag=true;
			try {
				addteamlist.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		try {
			FileWriter fw = new FileWriter(addteamlist);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i=0;i<Variable.teamscount;i++) {
				bw.write(Variable.teamnamelist[i]);
				bw.newLine();
				bw.flush();
			}
			bw.write(newfilename);
			bw.newLine();
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Variable.teamnamelist[Variable.teamscount]=newfilename;
		Variable.teamscount++;
		if(flag) {
			return -2;
		}
		return 1;
	}
	
	public static int deleteq (String deletefilename) {//删除问题文件 	11成功10 失败
		File deletefile = new File(".\\data\\question\\list\\"+deletefilename+"_name"+".lxc");
		File deletetimes = new File(".\\data\\question\\times\\"+deletefilename+"_times"+".lxc");
		if(deletefile.exists()) {
			deletefile.delete();
		}
		if(deletetimes.exists()) {
			deletetimes.delete();
		}
		for(int i = 0 ; i<Variable.questioncount; i++) {
			if(Variable.questionnamelist[i]==deletefilename) {
				for(int o = i; o<Variable.questioncount;o++) {
					Variable.questionnamelist[o]=Variable.questionnamelist[o+1];
				}
			}
		}
		Variable.questioncount--;
		File addteamlist = new File(".\\data\\questionlist.lxc");
		if(!addteamlist.exists()) {
			try {
				addteamlist.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				return 10;
			}
		}
		try {
			FileWriter fw = new FileWriter(addteamlist);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i=0;i<Variable.questioncount;i++) {
				bw.write(Variable.questionnamelist[i]);
				bw.newLine();
				bw.flush();
			}
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return 10;
		}
		File default0  = new File(".\\settings\\questiondefaultset.lxc");
		
		try {
			FileReader fr1 = new FileReader(default0);
			BufferedReader br1 = new BufferedReader(fr1);
			String temp = br1.readLine();
			br1.close();
			fr1.close();
			if(temp.equals(deletefilename)) {
				Mywindow.s_defaultquestion.setSelectedIndex(-1);
				Mywindow.s_defaultquestion.removeItem(deletefilename);
				FileWriter fw1 = new FileWriter(default0);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				bw1.write("none");
				bw1.close();
				fw1.close();
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(Nowquestiondata.name.equals(deletefilename)) {
			Nowquestiondata.name="尚未载入题组";
			Mywindow.nowquestion.setText(Nowquestiondata.name);
			Mywindow.start.setEnabled(false);
		}
		
		return 11;
	}
	
	public static int deletefile (String deletefilename) {//删除文件 11成功 10 失败
		File deletefile = new File(".\\data\\team\\list\\"+deletefilename+"_name"+".lxc");
		File deletetimes = new File(".\\data\\team\\times\\"+deletefilename+"_times"+".lxc");
		if(deletefile.exists()) {
			deletefile.delete();
		}
		if(deletetimes.exists()) {
			deletetimes.delete();
		}
		for(int i = 0 ; i<Variable.teamscount; i++) {
			if(Variable.teamnamelist[i]==deletefilename) {
				for(int o = i; o<Variable.teamscount;o++) {
					Variable.teamnamelist[o]=Variable.teamnamelist[o+1];
				}
			}
		}
		Variable.teamscount--;
		File addteamlist = new File(".\\data\\teamlist.lxc");
		if(!addteamlist.exists()) {
			try {
				addteamlist.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				return 10;
			}
		}
		try {
			FileWriter fw = new FileWriter(addteamlist);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i=0;i<Variable.teamscount;i++) {
				bw.write(Variable.teamnamelist[i]);
				bw.newLine();
				bw.flush();
			}
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return 10;
		}
		File default0  = new File(".\\settings\\teamdefaultset.lxc");
		
		try {
			FileReader fr1 = new FileReader(default0);
			BufferedReader br1 = new BufferedReader(fr1);
			String temp = br1.readLine();
			br1.close();
			fr1.close();
			if(temp.equals(deletefilename)) {
				Mywindow.s_defaultteam.setSelectedIndex(-1);
				Mywindow.s_defaultteam.removeItem(deletefilename);
				FileWriter fw1 = new FileWriter(default0);
				BufferedWriter bw1 = new BufferedWriter(fw1);
				bw1.write("none");
				bw1.close();
				fw1.close();
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(Nowteamdata.teamname.equals(deletefilename)) {
			Nowteamdata.teamname="尚未载入名单";
			Mywindow.nowteam.setText(Nowteamdata.teamname);
			Mywindow.start.setEnabled(false);
		}
		
		return 11;
	}
	
	public static int readq (String readfilename) {//载入已有问题文件 21成功 20失败 19文件丢失
		File readfile = new File(".\\data\\question\\list\\"+readfilename+"_name"+".lxc");
		File readtimes = new File(".\\data\\question\\times\\"+readfilename+"_times"+".lxc");
		if(!readfile.exists()) {
			return 19;
		}
		if(!readtimes.exists()) {
			return 19;
		}
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
			Nowquestiondata.totalmember=i;
			Nowquestiondata.name=readfilename;
			for(int o = 0;o<i;o++) {
				Nowquestiondata.member[o]=br1.readLine();
			}
			br2.close();
			br1.close();
			fr2.close();
			fr1.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return 20;
		}
		for(int i = 0 ; i<Nowquestiondata.totalmember;i++) {
			Nowquestiondata.flag[i]=false;
		}
		Nowquestiondata.times=0;
		return 21;
	}
	
	public static int readfile (String readfilename) {//载入已有班级文件 21成功 20失败 19 文件丢失
		File readfile = new File(".\\data\\team\\list\\"+readfilename+"_name"+".lxc");
		File readtimes = new File(".\\data\\team\\times\\"+readfilename+"_times"+".lxc");
		if(!readfile.exists()) {
			return 19;
		}
		if(!readtimes.exists()) {
			return 19;
		}
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
			Nowteamdata.totalmember=i;
			Nowteamdata.teamname=readfilename;
			for(int o = 0;o<i;o++) {
				Nowteamdata.membername[o]=br1.readLine();
			}
			br2.close();
			br1.close();
			fr2.close();
			fr1.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return 20;
		}
		for(int i = 0 ; i<Nowteamdata.totalmember;i++) {
			Nowteamdata.flag[i]=false;
		}
		Nowteamdata.times=0;
		Myfile.creattemp();
		return 21;
	}
	
	public static void defaultread () {
		File defaultteam = new File(".\\settings\\teamdefaultset.lxc");
		try {
			FileReader fw = new FileReader(defaultteam);
			BufferedReader bw = new BufferedReader(fw);
			String default1 = bw.readLine();
			bw.close();
			fw.close();
			if(!default1.equals("none")) {
				Errortext.errorchecking(readfile(default1),default1);
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		File defaultteam0 = new File(".\\settings\\questiondefaultset.lxc");
		try {
			FileReader fw = new FileReader(defaultteam0);
			BufferedReader bw = new BufferedReader(fw);
			String default1 = bw.readLine();
			bw.close();
			fw.close();
			if(!default1.equals("none")) {
				Errortext.errorchecking(readq(default1),default1);
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		File defaultvkcode = new File(".\\settings\\vkcode.lxc");
		try {
			FileReader fr = new FileReader(defaultvkcode);
			BufferedReader br = new BufferedReader(fr);
			Variable.vkcode=Integer.parseInt(br.readLine());
			br.close();
			fr.close();
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		
		File defaultswitch = new File(".\\settings\\q_switch.lxc");
		try {
			FileReader fr = new FileReader(defaultswitch);
			BufferedReader br = new BufferedReader(fr);
			if(Integer.parseInt(br.readLine())==1) {
				Variable.questionflag=true;
			}
			else {
				Variable.questionflag=false;
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		File defaulttmode = new File(".\\settings\\teammode.lxc");
		try {
			FileReader fr = new FileReader(defaulttmode);
			BufferedReader br = new BufferedReader(fr);
			if(Integer.parseInt(br.readLine())==1) {
				Variable.teammode=true;
			}
			else {
				Variable.teammode=false;
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		File defaultqmode = new File(".\\settings\\questionmode.lxc");
		try {
			FileReader fr = new FileReader(defaultqmode);
			BufferedReader br = new BufferedReader(fr);
			if(Integer.parseInt(br.readLine())==1) {
				Variable.questionmode=true;
			}
			else {
				Variable.questionmode=false;
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		File defaultswitch0 = new File(".\\settings\\i_switch.lxc");
		try {
			FileReader fr = new FileReader(defaultswitch0);
			BufferedReader br = new BufferedReader(fr);
			if(Integer.parseInt(br.readLine())==1) {
				Variable.iflag=true;
			}
			else {
				Variable.iflag=false;
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public static void creattemp () {
		File life = new File(".\\InstantCheck.lxc");
		if(life.exists()) {
			life.delete();
		}
		try {
			life.createNewFile();
			life.deleteOnExit();
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		try {
			FileWriter fw = new FileWriter(life);
			BufferedWriter bw = new BufferedWriter(fw);
			
			if(!Nowteamdata.teamname.equals("尚未载入名单")) {
				bw.write(String.valueOf(Variable.vkcode));
				bw.newLine();
				bw.write(Nowteamdata.teamname);
				bw.newLine();
			}
			else {
				bw.write("-1");
				bw.newLine();
				bw.write("null");
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

	public static int backcheck () {
		File check = new File(".\\welldone.key");
		if(check.exists()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}
