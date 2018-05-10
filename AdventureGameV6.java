/*
Thomas Bui
Assignment 5
Fall 2016
CS 401
 */
package adventuregamev6;

import java.util.Random;
import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class AdventureGameV6 extends Application {
    ListView<String> playerlistView;
    ListView<String> playerweaponView;
    ListView<String> enemylistView;
    ListView<String> enemyweaponView;
    ImageView playerImage, weaponImage,enemyImage,enemyweaponImage;
    Button selectPlayer,selectEnemy,runsimulation,exitprogram,randomPlayer,randomEnemy,displaybattlerecords;
    HBox lefthbox,bottomhbox;
    Alert alert;
    VBox leftvbox, rightvbox, centervbox,centertopvbox,centerbottomvbox;
    ImageView playerImageView;
    Pane leftpanel,rightpanel,centerpanel,centerbottompanel;
    RadioButton fourenemies,fiveenemies,sixenemies,oneround,fiverounds,tenrounds,twentyrounds;
    final String ROGUE_IMG = "file:/Users/thomasbui/Desktop/art/Rogue.png";
    final String PALADIN_IMG = "file:/Users/thomasbui/Desktop/art/Paladin.png";
    final String JACKIE_CHAN_IMG = "file:/Users/thomasbui/Desktop/art/JackieChan.png";
    final String MACE_IMG = "file:/Users/thomasbui/Desktop/art/Mace.png";
    final String SHORT_SWORD_IMG = "file:/Users/thomasbui/Desktop/art/ShortSword.png";
    final String LONG_SWORD_IMG = "file:/Users/thomasbui/Desktop/art/LongSword.png";
    final String AXE_IMG = "file:/Users/thomasbui/Desktop/art/Axe.png";
    final String GOBLIN_IMG = "file:/Users/thomasbui/Desktop/art/Goblin.png";
    final String SKELETON_IMG = "file:/Users/thomasbui/Desktop/art/Skeleton.png";

    String playerName, playerWeapon, enemyName, enemyWeapon;
    int numRounds=1, numEnemies=4;
    int battlesWon=0, battlesLost=0;
    int rogue_record = 0, rogue_record_lose = 0;
    int paladin_record = 0, paladin_record_lose = 0;
    int jackie_record = 0, jackie_record_lose = 0;

    int goblin_record = 0, goblin_record_lose = 0;
    int skeleton_record = 0, skeleton_record_lose = 0;
    final int SHORT_SWORD_MIN = 1;
    final int SHORT_SWORD_MAX = 4;
    final int LONG_SWORD_MIN = 3;
    final int LONG_SWORD_MAX = 7;
    final int AXE_MIN = 2;
    final int AXE_MAX = 6;
    final int MACE_MIN = 2;
    final int MACE_MAX = 6;

    final int ROGUE_INIT_HP = 55;
    final int ROGUE_INIT_STRENGTH = 8;
    final int PALADIN_INIT_HP = 35;
    final int PALADIN_INIT_STRENGTH = 14;
    final int CHAN_INIT_HP = 45;
    final int CHAN_INIT_STRENGTH = 10;

    final int MINION_INIT_HP = 25;
    final int GOBLIN_INIT_STRENGTH = 4;
    final int SKELETON_INIT_STRENGTH = 3;

    int[] player = new int[5]; // stores the player attributes
    int[] enemy = new int[4];  // stores the enemy attributes
    @Override
    public void start(Stage primaryStage) {
        Random randomizer = new Random();
        //define borderpane,vbox,hbox
        BorderPane Bpane = new BorderPane();
        //set top of bordernpane
        Label topLbl= new Label("ADVENTURE GAME BATTLE SIMULATOR");
        topLbl.setFont(Font.font("Arial",FontWeight.BOLD,20));
        Bpane.setTop(topLbl);
        Bpane.setAlignment(topLbl, Pos.CENTER);
        
        //building left of borderpane
        Text leftLbl = new Text("PLAYER");
        leftLbl.setTextAlignment(TextAlignment.CENTER);
        leftLbl.setFont(new Font(20));
        //player choice
        playerlistView = new ListView<String>();
        playerlistView.getItems().addAll("Rogue","Paladin","Jackie Chan");
        //player weapon choice
        playerweaponView = new ListView<String>();
        playerweaponView.getItems().addAll("Mace","Short Sword","Long Sword","Axe");
        //setimages
        playerImage = new ImageView(); 
        weaponImage = new ImageView();
        
        //player buttons
        randomPlayer = new Button("RANDOMIZE PLAYER");
        //lambda to set action on randomizer button
        randomPlayer.setOnAction(e -> 
        {
            playerlistView.getSelectionModel().select(randomizer.nextInt(3));
            playerweaponView.getSelectionModel().select(randomizer.nextInt(4));
            
            setPlayerImage();
        }
            );
        selectPlayer = new Button("SELECT PLAYER");
        selectPlayer.setOnAction(e -> setPlayerImage());
        
        //set leftvbox
        leftvbox = new VBox(30,leftLbl,playerlistView,playerImage,playerweaponView,weaponImage,selectPlayer,randomPlayer);
        leftvbox.setPadding(new Insets(10,20,10,20));
        leftvbox.setAlignment(Pos.CENTER);
     
        Bpane.setLeft(leftvbox);
        
        
        //building right of borderpane
        Text rightlbl = new Text("ENEMY");
        rightlbl.setTextAlignment(TextAlignment.CENTER);
        rightlbl.setFont(new Font(20));
        enemylistView = new ListView<String>();
        enemylistView.getItems().addAll("Goblin","Skeleton");
        enemyweaponView = new ListView<String>();
        enemyweaponView.getItems().addAll("Mace","Short Sword","Long Sword","Axe");
        
        enemyImage = new ImageView();
        enemyweaponImage = new ImageView();
       
        randomEnemy = new Button("RANDOMIZE ENEMY");
        randomEnemy.setOnAction(e -> 
        {
            enemylistView.getSelectionModel().select(randomizer.nextInt(2));
            enemyweaponView.getSelectionModel().select(randomizer.nextInt(4));
            
            setEnemyImage();
        });
        selectEnemy = new Button("SELECT ENEMY");
        selectEnemy.setOnAction(e -> setEnemyImage());
        rightvbox = new VBox(30,rightlbl,enemylistView,enemyImage,enemyweaponView,enemyweaponImage,selectEnemy,randomEnemy);
        rightvbox.setPadding(new Insets(10,20,10,20));
        rightvbox.setAlignment(Pos.CENTER);
        Bpane.setRight(rightvbox);
        
        
        centerpanel = new Pane();
            
        //building top panel of center borderpane
        Text centertoplbl = new Text("OPTIONS");
        centertoplbl.setFont(new Font(20));
        centervbox = new VBox(30,centertoplbl);
        centervbox.relocate(20,10);
        
        Text centertoptxt = new Text("Number of enemies");
        fourenemies = new RadioButton("4 enemies");
        fourenemies.setSelected(true);
        fiveenemies = new RadioButton("5 enemies");
        sixenemies = new RadioButton("6 enemies");
        ToggleGroup groupSize = new ToggleGroup();
        fourenemies.setToggleGroup(groupSize);
        fiveenemies.setToggleGroup(groupSize);
        sixenemies.setToggleGroup(groupSize);
        centertopvbox = new VBox(10,centertoptxt,fourenemies,fiveenemies,sixenemies);
        centertopvbox.relocate(20, 120);
        
        
        
     groupSize.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (groupSize.getSelectedToggle() != null) {
          if (fourenemies.isSelected()) numEnemies=4;
          if (fiveenemies.isSelected()) numEnemies=5;
          if (sixenemies.isSelected()) numEnemies=6;
          System.out.println("numEnemies is: " + numEnemies);
        }

      }
    });
       
        //building bottom panel of bcenter orderpane
        Text centerbottomtxt = new Text("Number of Rounds");
        oneround = new RadioButton("1 round");
        oneround.setSelected(true);
        fiverounds = new RadioButton("5 rounds");
        tenrounds = new RadioButton("10 rounds");
        twentyrounds = new RadioButton("20 rounds");
        ToggleGroup roundamount = new ToggleGroup();
        oneround.setToggleGroup(roundamount);
        fiverounds.setToggleGroup(roundamount);
        tenrounds.setToggleGroup(roundamount);
        twentyrounds.setToggleGroup(roundamount);
        
     roundamount.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      public void changed(ObservableValue<? extends Toggle> ov,
          Toggle old_toggle, Toggle new_toggle) {
        if (roundamount.getSelectedToggle() != null) {
          if (oneround.isSelected()) numRounds=1;
          if (fiverounds.isSelected()) numRounds=5;
          if (tenrounds.isSelected()) numRounds=10;
          if (twentyrounds.isSelected()) numRounds=20;
          System.out.println("numRounds is: " + numRounds);
        }

      }
    });
          
        centerbottomvbox = new VBox(10,centerbottomtxt,oneround,fiverounds,tenrounds,twentyrounds);
        centerbottomvbox.relocate(20,260);
        centerpanel.getChildren().addAll(centervbox,centertopvbox,centerbottomvbox);
        Bpane.setCenter(centerpanel);
        
       //building bottom of borderpane
        runsimulation = new Button("Run Simulation");
        exitprogram= new Button("Exit");
        displaybattlerecords = new Button("Display Battle Records");
        displaybattlerecords.setOnAction(e ->
                RecordsMessageBox.show(rogue_record, rogue_record_lose, paladin_record, paladin_record_lose, jackie_record, jackie_record_lose, goblin_record, goblin_record_lose, skeleton_record, skeleton_record_lose));
        runsimulation.setDisable(true); // disable this button until both player and enemy are properly seclected
       
        runsimulation.setOnAction(e ->Runsimulation());
        exitprogram.setOnAction(e ->primaryStage.close());
        
        bottomhbox = new HBox(10,runsimulation,displaybattlerecords,exitprogram);
        bottomhbox.setAlignment(Pos.CENTER);
        Bpane.setBottom(bottomhbox);
        
        //set scene
        Scene scene = new Scene(Bpane);
        primaryStage.setScene(scene);
        primaryStage.show();
    
    }  
    public void Runsimulation(){

        switch(playerName)
        {
        case "Rogue":
            player[0] = ROGUE_INIT_HP;
            player[1] = ROGUE_INIT_STRENGTH;
            break;
        case "Paladin":
            player[0] = PALADIN_INIT_HP;
            player[1] = PALADIN_INIT_STRENGTH;
            break;
        case "Jackie Chan":
            player[0] = CHAN_INIT_HP;
            player[1] = CHAN_INIT_STRENGTH;
            break;
        }//end of playername switch case
        switch(playerWeapon) 
        {
            case "Mace":
                player[2] = MACE_MIN;
                player[3] = MACE_MAX;
                break;
            case "Short Sword":
                player[2] = SHORT_SWORD_MIN;
                player[3] = SHORT_SWORD_MAX;
                break;
            case "Long Sword":
                player[2] = LONG_SWORD_MIN;
                player[3] = LONG_SWORD_MAX;
                break;
            case "Axe":
                player[2] = AXE_MIN;
                player[3] = AXE_MAX;
                break;            
        }

        switch(enemyName)
        {
        case "Goblin":
            enemy[0] = MINION_INIT_HP;
            enemy[1] = GOBLIN_INIT_STRENGTH;
            break;
        case "Skeleton":
            enemy[0] = MINION_INIT_HP;
            enemy[1] = SKELETON_INIT_STRENGTH;
            break;
    }
        switch(enemyWeapon) 
        {
        case "Mace":
            enemy[2] = MACE_MIN;
            enemy[3] = MACE_MAX;
            break;
        case "Short Sword":
            enemy[2] = SHORT_SWORD_MIN;
            enemy[3] = SHORT_SWORD_MAX;
            break;
        case "Long Sword":
            enemy[2] = LONG_SWORD_MIN;
            enemy[3] = LONG_SWORD_MAX;
            break;
        case "Axe":
            enemy[2] = AXE_MIN;
            enemy[3] = AXE_MAX;
            break;            
        }

    fightMinion(player, enemy, playerName, enemyName, numEnemies);// gets character stats after the first battle method       
}
    
    public void fightMinion(int[] player, int[] enemy, String playerName, String enemyName, int numEnemies)
    {
    int playerDamage;
    int playerATK;
    int enemyDamage;
    int enemyATK;
    int coins;
    
    // counters for the number of battles won, battles lost, and enemies defeated 
    int numEnemiesDefeated=0; 
    
    Random randomNums = new Random();
    Scanner keyboard = new Scanner(System.in);

    // outer loops for the number of rounds fighting
    for (int j=1; j <= numRounds; j++) {
    
        // inner loop for fighting a number of enemies
        for (int i = 1; i <= numEnemies; i++)
        {
        enemy[0] = 25;
        System.out.printf("***%s vs %s %d***\n", playerName, enemyName, i);

            while(enemy[0] > 0 && player[0] > 0)
            {
                playerDamage = randomNums.nextInt(player[3] - player[2] + 1) + player[2];
                playerATK = player[1] + playerDamage;
                enemy[0] -= playerATK;
       
                if (enemy[0] <= 0)
                    break;

                enemyDamage = randomNums.nextInt(enemy[3] - enemy[2] + 1) + enemy[2];
                enemyATK = enemy[1] + enemyDamage;
                player[0] -= enemyATK;
            } // end of while loop

            if (player[0] > 0)
            { 
                numEnemiesDefeated++;
                System.out.printf("%s defeated %s %d!\n\n", playerName, enemyName, i);
                switch (playerName)
                {
                    case "Rogue":
                    rogue_record += 1;
                    break;

                    case "Paladin":
                    paladin_record += 1;
                    break;

                    case "Jackie Chan":
                    jackie_record += 1;
                    break;
                }
                switch (enemyName)
                {
                    case "Skeleton":
                    skeleton_record_lose += 1;
                    break;
                    case "Goblin":
                    goblin_record_lose +=1;
                    break;
                }
            }
            else
            {
                battlesLost++;
                System.out.printf("--%s is defeated in battle!--\n", playerName);
                
                switch (playerName)
                {
                    case "Rogue":
                    rogue_record_lose += 1;
                    break;

                    case "Paladin":
                    paladin_record_lose += 1;
                    break;

                    case "Jackie Chan":
                    jackie_record_lose += 1;
                    break;
                }
                switch (enemyName)
                {
                    case "Skeleton":
                    skeleton_record += 1;
                    break;
                    case "Goblin":
                    goblin_record +=1;
                    break;
                }
                i = 100;
            }

        } // end of inner loop
    
        // check to see if player won battle
        if (player[0] > 0) 
           battlesWon++;
   
    // Reset the player's hit points after each round.
        switch(playerName)
        {
        case "Rogue":
            player[0] = 55;
            break;
        case "Paladin":
            player[0] = 35;
            break;
        case "Jackie Chan":
            player[0] = 45;
            break;
        }//end of switch case
    
    } // end of outer loop

        //display simulation results 
        MessageBox.show(numEnemies, numRounds, numEnemiesDefeated, battlesWon, battlesLost);
        
      
  }//end method
    public void setPlayerImage(){
        String playerselected = playerlistView.getSelectionModel().getSelectedItem();
        String weaponselected = playerweaponView.getSelectionModel().getSelectedItem();
        Image image = null;
        Image w_image = null;
        
        if(playerselected==null||weaponselected==null)
            PlayerMessageBox.show(playerlistView, playerweaponView, enemylistView, enemyweaponView);
       
        if(playerselected!=null && weaponselected!=null)
        {
        if (playerselected.equals("Rogue"))
            image = new Image(ROGUE_IMG);
            else if (playerselected.equals("Paladin"))
                image = new Image(PALADIN_IMG);
            else if(playerselected.equals("Jackie Chan"))
                image = new Image(JACKIE_CHAN_IMG);
      
            playerImage.setImage(image);
            playerName = playerselected;
       
            if(weaponselected.equals("Mace"))
                w_image = new Image(MACE_IMG);
            else if(weaponselected.equals("Short Sword"))
                w_image = new Image(SHORT_SWORD_IMG);
            else if(weaponselected.equals("Long Sword"))
                w_image = new Image(LONG_SWORD_IMG);
            else if(weaponselected.equals("Axe"))
                w_image = new Image(AXE_IMG);
        
            weaponImage.setImage(w_image); 
            playerWeapon = weaponselected;
        
        // if both player and enemy are selected properly then enable the runsimulation button
        if ((playerName != null) && (enemyName != null))
            runsimulation.setDisable(false);
        }
        
    }
    
    public void setEnemyImage(){
        String enemyselected = enemylistView.getSelectionModel().getSelectedItem();
        String enemyweaponselected = enemyweaponView.getSelectionModel().getSelectedItem();
        Image enemy_image = null;
        Image enemy_w_image = null;
            //call method for displaying the message box
            if(enemyselected==null||enemyweaponselected==null)
                PlayerMessageBox.list(playerlistView,playerweaponView,enemylistView,enemyweaponView);
   
            if(enemyselected!=null && enemyweaponselected!=null)
            {
            if (enemyselected.equals("Goblin"))
                enemy_image = new Image(GOBLIN_IMG);
            else
                enemy_image = new Image(SKELETON_IMG);
            //set enemyImage
            enemyImage.setImage(enemy_image);
            enemyName = enemyselected;

            if(enemyweaponselected.equals("Mace"))
                enemy_w_image = new Image(MACE_IMG);
            else if(enemyweaponselected.equals("Short Sword"))
                enemy_w_image = new Image(SHORT_SWORD_IMG);
            else if(enemyweaponselected.equals("Long Sword"))
                enemy_w_image = new Image(LONG_SWORD_IMG);
            else if(enemyweaponselected.equals("Axe"))
                enemy_w_image = new Image(AXE_IMG);
        
            enemyweaponImage.setImage(enemy_w_image); 
            enemyWeapon = enemyweaponselected;
            
        // if both player and enemy are selected properly then enable the runsimulation button
        if ((playerName != null) && (enemyName != null))
            runsimulation.setDisable(false);            
            
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
}
