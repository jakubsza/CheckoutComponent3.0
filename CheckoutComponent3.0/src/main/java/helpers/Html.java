package helpers;

public class Html {

	public static String newLine(){
		return "<br />";
	}
	
	public static String fakeTab(int length){
		String tab="";
		for (int i=0; i<length;i++){
			tab+="&ensp;";
		}
		
		return tab;
	}
}
