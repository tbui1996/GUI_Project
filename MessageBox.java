package adventuregamev6;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.text.Text;
/**
 *
 * @author thomasbui
 */
public class MessageBox {
    public static void show(int numEnemies,int numRounds,int numEnemiesDefeated,int battlesWon,int battlesLost)
    {
        //create stage
        Stage Messagestage = new Stage();
        Messagestage.initModality(Modality.APPLICATION_MODAL);
        Messagestage.setTitle("SIMULATION RESULTS");
        Messagestage.setMinWidth(400);
        Messagestage.setMinHeight(300);
        
        //create text lines
        Text linetext = new Text();
         linetext.setText("Number of enemies per round: " + numEnemies + 
            "\nNumber of rounds: " + numRounds +
            "\nNumber of battles won: " + battlesWon +
            "\nNumber of battles lost: " + battlesLost +
            "\nTotal number of enemies defeated: " + numEnemiesDefeated);
        //create button
        Button btnOk = new Button();
        btnOk.setText("OK");
        btnOk.setOnAction(e ->Messagestage.close());
        
        //create vbox
        VBox messagepane = new VBox(15,linetext,btnOk);
        messagepane.setAlignment(Pos.CENTER);
        
        //create scene
        Scene messagescene= new Scene(messagepane);
        Messagestage.setScene(messagescene);
        Messagestage.showAndWait();
    }  
}
