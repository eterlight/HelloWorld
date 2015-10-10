package test;

public class TestArray {

	public static void main(String[] args) {
		String[] array = {"a1","a2","a3","a4","a5","a6","a7","a8","a9","a10","a11","a12","a13","a14","a15"};
		String str = "";
		for(int i=0;i<array.length;i++){
			
			if(i==0 || i%5==0){
				str += "<p>";
			}
			str += i+"";
			if(i%5 == 4){
				str += "</p>";
			}
		}
		System.out.println(str);
	}

}
