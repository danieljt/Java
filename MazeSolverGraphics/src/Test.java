import java.io.File;;
public class Test {
	public static void main(String[] args) throws Exception{
		File fil = new File("2.in");
		Labyrint labyrint = Labyrint.lesFraFil(fil);
		System.out.print(labyrint.toString());
		labyrint.settMinimalUtskrift();
		labyrint.finnUtveiFra(6, 2);
		for(String utvei : labyrint.utveier){
		    System.out.println(utvei);
		}
		
		// Hent losningstabell
		boolean[][] losning = losningStringTilTabell(labyrint.utveier.hent(0),
			labyrint.rader, labyrint.kolonner);
		
		for(int i=0; i<labyrint.rader; i++){
		    for(int j=0; j<labyrint.kolonner; j++){
			System.out.print(losning[i][j] + "   ");
		    }
		    System.out.println();
		}
	}
	static boolean[][] losningStringTilTabell(String losningString, int hoyde, int bredde) {
	    boolean[][] losning = new boolean[hoyde][bredde];
	    java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
	    java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
	    while(m.find()) {
		int x = Integer.parseInt(m.group(1))-1;
		int y = Integer.parseInt(m.group(2))-1;
		losning[x][y] = true;
	    }
	    return losning;
	}

}


