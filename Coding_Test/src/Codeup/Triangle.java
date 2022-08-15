package Codeup;
public class Triangle {
	
	static int height = 5;
	
    public static void main(String[] args) {
    	int cnt = 1;
    	int length = String.valueOf(height * (height+1) / 2).length();
    	
        for (int i = 0; i < height; i++) {
        	String line = "";
			for (int j = 0; j <= i; j++) {
				for (int k = String.valueOf(cnt).length(); k < length; k++) {
					line += " ";
				}
				line += (cnt + " ");
				cnt += 1;
			}
			System.out.println(line);
        }
        
    }
}