package chooser;
import java.util.Random;

public class Choosecore {
	public static int[] chooseit (){
		Random choose = new Random();
		Random choose1 = new Random();
		int[] temp = new int[2];
		temp[0]=choose.nextInt(Nowteamdata.totalmember);
		Variable.nowresult = Nowteamdata.membername[temp[0]];
		if(Variable.questionflag) {
			temp[1]=choose1.nextInt(Nowquestiondata.totalmember);
			Variable.nowquestion = Nowquestiondata.member[temp[1]];
		}
		return temp;
	}
}
