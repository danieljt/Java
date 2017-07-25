import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.event.*;
import java.io.File;
import javafx.stage.FileChooser.*;
import javafx.scene.Node;


/**
 * Klassen oppretter et grafisk brukergrensesnitt for en labyrint
 * loser. Klassen bruker javaFX pakken.
 * 
 * @author Daniel James Tarplett
 *
 */
public class Grafisk extends Application{
    
    // Setter sammen lerretet
    private BorderPane lerret;
    private HBox top;
    private HBox senter;
    private HBox bunn;
    
    // Definerer griddet og knappene
    private GridPane grid;
    private Button nesteLosning;
    
    // Setter scenen og fil loseren
    private Scene hovedScene;
    private FileChooser filaapner;
    
    // Setter viktige variabler tilknyttet labyrinten
    private Labyrint labyrint;
    
    public void start(Stage vindu) throws Exception{
	lerret = new BorderPane();
	
	// Sett sidepanelene
	lerret.setTop(top());
	lerret.setBottom(bunn());
	
	// Lag vinduet
	hovedScene = new Scene(lerret, 900, 700);
	vindu.setScene(hovedScene);
	vindu.show();
	vindu.setTitle("Labyrint Loser");	
    }
      
    /**
     * Metode som lager toppfanen til det grafiske brukergrensesnittet
     * med tilhorende knapper og funksjonalitet
     * @return HBox toppfanen
     */
    public HBox top() throws Exception{
	top = new HBox();
	top.setPadding(new Insets(35, 20, 35, 20));
	top.setSpacing(10);
	top.setStyle("-fx-background-color: #999999");
	
	// Legg til knapper
	Button lesFil = new Button("Les in fil");
	lesFil.setPrefSize(150, 50);
	lesFil.setOnAction(new AapneFil());
	nesteLosning = new Button("Neste Losning");
	nesteLosning.setPrefSize(150, 50);
	//nesteLosning.setOnAction(new NesteLosning());
	nesteLosning.setVisible(false);
	
	// initialiser knapper
	top.getChildren().addAll(lesFil, nesteLosning);
	return top;
    }
    
    class ABC extends Button{
	int x, y;
	ABC(int x, int y){
	    this.x = x;
	    this.y = y;
	}
    }
     
    /**
     * Metode som lager selve labyrinten med knapper, action events m.m.
     * Dersom en fil ikke er spesifisert, returnerer metoden null.
     * Metoden farger ogsaa labyrintens sorte ruter i svart farge.
     * 
     * @return GridPane labyrinten
     */
    public HBox senter() throws Exception{
	senter = new HBox();
	senter.setAlignment(Pos.CENTER);
	grid = new GridPane();
	FinnLosning felles = new FinnLosning();
	for(int i=0; i<labyrint.rader;i++){
	    for(int j=0; j<labyrint.kolonner; j++){
		ABC rute = new ABC(i,j);
		rute.setOnAction(felles);
		
		if(labyrint.ruter[i][j] instanceof SortRute){
		    rute.setStyle("-fx-background-color: black");
		}
		else{
		    rute.setStyle("-fx-background-color: white");
		}
		// Sett inn i griddet. Husk at rader og kolonner er omvendt
		// fra java generelt
		grid.add(rute, j, i);
	    }
	}
	senter.getChildren().addAll(grid);
	return senter;	
    }
    
    
    
    /**
     * Metode som lager bunnen i programmet med tilhorende knapper.
     * @return HBox bunnen
     */
    public HBox bunn(){
	bunn = new HBox();
	bunn.setPadding(new Insets(35, 20, 35, 25));
	bunn.setSpacing(50);
	bunn.setStyle("-fx-background-color: #999999");
	
	// Legg til knapper m/ funksjonalitet
	Button avslutt = new Button("AVSLUTT");
	avslutt.setPrefSize(150, 50);
	avslutt.setOnAction(new Avslutt());
	
	// Legg til knapper i fanen
	bunn.getChildren().addAll(avslutt);
	return bunn;	
    }
    
    
    /**
     * Metoden fargelegger nodene i labyrinten som utgjor
     * utveien dersom det finnes en utvei.
     * @param vei array med true false verdier
     */
    public void fargelegg(boolean[][] vei){
	for(Node node : grid.getChildren()){
	    if(vei[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)] == true){
		node.setStyle("-fx-background-color: green");
	    }
	    else if(labyrint.ruter[GridPane.getRowIndex(node)][GridPane.getColumnIndex(node)]
		    instanceof HvitRute){
		node.setStyle("-fx-background-color: white");
	    }
	}
    } 
    
    
    /**
    * Konverterer losning-String fra oblig 5 til en boolean[][]-representasjon
    * av losningstien.
    * @param losningString String-representasjon av utveien
    * @param bredde bredde til labyrinten
    * @param hoyde hoyde til labyrinten
    * @return 2D-representasjon av rutene der true indikerer at
    * ruten er en del av utveien.
    */
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
    
    /**
     * Klassen definerer en hendelse som viser neste losning av 
     * labyrinten dersom det finnes.
     * @author Daniel James Tarplett
     *
     
    private class NesteLosning implements EventHandler<ActionEvent>{
	public void handle(ActionEvent nesteLosning){
	    // Dersom alle losninger har blitt iterert over,
	    // start fra begynnelsen av
	    if(losningsnr == losninger.length){
		losningsnr = 0;
		fargelegg(losningStringTilTabell(losninger[losningsnr], 
			labyrint.rader, labyrint.kolonner));
		return;
	    }
	    else{
		
	    }
	}
    }*/
    
    /**
     * Klassen definerer en hendelse der det sokes etter en losning i 
     * labyrinten utifra denne knappen og fargelegger den forste 
     * losninfen i settet dersom det finnes. 
     * @author Daniel James Tarplett
     *
     */
    private class FinnLosning implements EventHandler<ActionEvent>{

	public FinnLosning(){
	   
	}
	
	public void handle(ActionEvent FinnLosningKnappTrykket){
	    ABC densomduharnrttoppklickpaa = (ABC)FinnLosningKnappTrykket.getSource();
	    Liste<String> hentesUt = labyrint.finnUtveiFra(densomduharnrttoppklickpaa.x, densomduharnrttoppklickpaa.y);
	    String[] losninger = new String[hentesUt.storrelse()];
	    System.out.println(losninger.length);
	    int i = 0;
	    for(String s : hentesUt){
		 System.out.println(s);
		losninger[i] = s;
		i++;
	    }
	    
	    // Fargelegger bare hvis det finnes en losning
	    if(losninger.length > 0){
		// Fargelegg forste losning
		boolean[][] los = losningStringTilTabell(losninger[0], 
			labyrint.rader, labyrint.kolonner);
		fargelegg(los);
	    }

		
	}
    }
       
    /**
     * Klassen definerer en hendelse som avslutter programmet
     * @author Daniel James Tarplett
     */
    private class Avslutt implements EventHandler<ActionEvent>{
	public void handle(ActionEvent avsluttKnappTrykka){
	    javafx.application.Platform.exit();
	}
    }
    
    
    
    /**
     * Klassen definerer en hendelse der brukeren kan aapne en fil
     * grafisk fra menyen og laste den inn til et nytt grid.
     * @author Daniel James Tarplett
     *
     */
    private class AapneFil implements EventHandler<ActionEvent>{

	public void handle(ActionEvent AapnefilKnappTrykka){
	    filaapner = new FileChooser();
	    filaapner.setTitle("Les in ny fil");
	    filaapner.getExtensionFilters().addAll(new ExtensionFilter("Files", "*.in"));
	    File fil = filaapner.showOpenDialog(new Stage());
	    try{
		labyrint = Labyrint.lesFraFil(fil);
		labyrint.settMinimalUtskrift();
		lerret.setCenter(senter());
	    }
	    catch(Exception e){
		
	    }
	}
    }
    
    /**
     * Kjorer programmet
     * @param args
     */
    public static void main(String[] args){
	launch(args);
    }
}