/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventuregamev6;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author thomasbui
 */
public class PlayerMessageBox {
    public static void show(ListView <String> playerlistView,ListView<String> playerweaponView,ListView <String> enemylistView,ListView <String> enemyweaponView)
    {
       
        String playerselected = playerlistView.getSelectionModel().getSelectedItem();
        String weaponselected = playerweaponView.getSelectionModel().getSelectedItem();
        //create text fields and stage
        Stage Messagestage = new Stage();
        Text firstline = new Text();
           
        //create stage
        
        
        Messagestage.initModality(Modality.APPLICATION_MODAL);
        Messagestage.setTitle("ERROR");
        Messagestage.setMinWidth(400);
        Messagestage.setMinHeight(300);
        //create button
        Button btnOk = new Button();
        btnOk.setText("OK");
        btnOk.setOnAction(e ->Messagestage.close());
        
       
         //statements for enemy
         if(playerselected == null && (weaponselected==null))
         {
           firstline.setText("You must choose a character and a weapon.");
         }
        else if(playerselected == null || (weaponselected == null))
        {
            if(playerselected==null)
            {
                firstline.setText("You must choose a character. ");
            }
            if(weaponselected ==null)
            {
               firstline.setText("You must choose a weapon.");
            }
        }
        
       
           //create vbox
        VBox messagepane = new VBox(10);
        messagepane.getChildren().addAll(firstline,btnOk);
        messagepane.setAlignment(Pos.CENTER);
         //create scene
        Scene messagescene= new Scene(messagepane);
        Messagestage.setScene(messagescene);
        Messagestage.showAndWait();
    }//end of void
    
    public static void list(ListView <String> playerlistView,ListView<String> playerweaponView,ListView <String> enemylistView,ListView <String> enemyweaponView){
         //initialize variables
        String enemyselected = enemylistView.getSelectionModel().getSelectedItem();
        String enemyweaponselected = enemyweaponView.getSelectionModel().getSelectedItem();
        //create text fields and stage
        Stage Messagestage = new Stage();
        Text firstline = new Text();
     
        Messagestage.initModality(Modality.APPLICATION_MODAL);
        Messagestage.setTitle("ERROR");
        Messagestage.setMinWidth(200);
        Messagestage.setMinHeight(150);
        //create button
        Button btnOk = new Button();
        btnOk.setText("OK");
        btnOk.setOnAction(e ->Messagestage.close());
        
       
         //statements for enemy
        if(enemyselected == null && (enemyweaponselected==null))
         {
           firstline.setText("You must choose an enemy and a weapon.");
         }
        else if(enemyselected == null || (enemyweaponselected == null))
        {
            if(enemyselected==null)
            {
                firstline.setText("You must choose an enemy. ");
            }
            if(enemyweaponselected ==null)
            {
               firstline.setText("You must choose a weapon.");
            }
        }
     
        //create vbox
        VBox messagepane = new VBox(20,firstline,btnOk);
        messagepane.setAlignment(Pos.CENTER);
         //create scene
        Scene messagescene= new Scene(messagepane);
        Messagestage.setScene(messagescene);
        Messagestage.showAndWait();
    }
    
    
}//end of main


