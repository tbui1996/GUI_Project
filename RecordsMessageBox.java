/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregamev6;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author thomasbui
 */
public class RecordsMessageBox {
     public static void show(int rogue_record,int rogue_record_lose,int paladin_record,int paladin_record_lose,int jackie_record, int jackie_record_lose, int goblin_record, int goblin_record_lose, int skeleton_record, int skeleton_record_lose)
    {
        //create stage
        Stage Messagestage = new Stage();
        Messagestage.initModality(Modality.APPLICATION_MODAL);
        Messagestage.setTitle("BATTLE RECORDS");
         Messagestage.setMinWidth(200);
        Messagestage.setMinHeight(250);
        //create text lines
        Text firstlinetext = new Text();
        String s = String.format("%-30s\t%10s\t%-5s%10s\t%-5s\n%-30s\t%10s\t%-5s%10s\t%-5s\n%-30s\t%10s\t%-5s%10s\t%-5s\n%-30s\t%10s\t%-5s%10s\t%-5s\n%-30s\t%10s\t%-5s%10s\t%-5s\n","Rogue:" ,rogue_record," W", rogue_record_lose," L", "Paladin:", paladin_record," W", paladin_record_lose," L", "Jackie Chan:", jackie_record," W",jackie_record_lose," L","Goblin:" ,goblin_record," W", goblin_record_lose," L","Skeleton:",skeleton_record," W", skeleton_record_lose," L");
        
        firstlinetext.setText(s);
        
        //create button
        Button btnOk = new Button();
        btnOk.setText("OK");
        btnOk.setOnAction(e -> Messagestage.close());
        
        //create vbox
        VBox messagepane = new VBox(15);
        messagepane.getChildren().addAll(firstlinetext,btnOk);
        messagepane.setAlignment(Pos.CENTER);
        
        //create scene
        Scene messagescene= new Scene(messagepane);
        Messagestage.setScene(messagescene);
        Messagestage.showAndWait();
       
        
        
    }
}
