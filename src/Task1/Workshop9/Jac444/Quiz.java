/*
Student: Mitchell Culligan
id: 161293170
email: mculligan@myseneca.ca
Professor: Mahboob Ali
 */
package Task1.Workshop9.Jac444;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.Node;

public class Quiz extends Application {
        public static final char[] OPERATIONS={'+','-','*','/'};
        public static final double BUTTON_WIDTH=75;
        public static final double BUTTON_HEIGHT=25;
        private Text[] questions;
        private TextField[] questionBlanks;
        private NumberPair pair;
        private Text mssge;
        private Answer guessChecker;
        public Quiz(){
            this.questions = new Text[4];
            this.questionBlanks = new TextField[4];
            //Arrays.fill(this.questions,new Text());
            for(int i=0;i<this.questions.length;i++)
                this.questions[i]=new Text();
            for(int i=0;i<this.questionBlanks.length;i++)
                this.questionBlanks[i] = new TextField();
           //Arrays.fill(this.questionBlanks,new TextField());
            this.pair = null;
            this.mssge = new Text("");
            this.guessChecker = new Answer();

        }

        public void generate(){
            this.pair = NumberPair.generatePair();
            this.guessChecker.clearGuesses();
            for(int i=0;i<questions.length;i++){

                this.questions[i].setText(String.format("%d %c %d=",
                        this.pair.getFirst(),OPERATIONS[i],this.pair.getSecond()));
                this.questionBlanks[i].setText("");

            }
            this.mssge.setText("");
        }
    @Override
    public void start(Stage primaryStage){
        BorderPane root = new BorderPane();
        Pane p = this.formatQuestions();

        BorderPane.setMargin(p,new Insets(8,8,8,8));
        root.setCenter(p);
        p = formatButtons();
        BorderPane.setMargin(p,new Insets(10,10,10,10));
        BorderPane.setAlignment(p, Pos.BOTTOM_CENTER);
        root.setBottom(p);
        primaryStage.setTitle("Arithmatic Quiz");
        //primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public VBox formatQuestions(){
            VBox vb = new VBox(5);
            HBox hb;
            this.generate();
            for(int i=0;i<questions.length;i++) {
                hb = new HBox(8);
                hb.getChildren().addAll(this.questions[i], this.questionBlanks[i]);
                System.out.println(this.questions[i]);
               // System.out.println(hb.getChildren().toString());
                vb.getChildren().add(hb);
            }
            vb.setSpacing(10);
            vb.getChildren().add(this.mssge);


            return vb;
    }


    public HBox formatButtons(){
           HBox hb= new HBox(5);
           Button submit = new Button("Submit"), close = new Button("Close"),
                   newPairButton = new Button(" New Pair");
            submit.setPrefSize(BUTTON_WIDTH,BUTTON_HEIGHT);
            submit.setOnMouseClicked((e)->{
                boolean guessed= false;
                Number[] nums = new Number[this.questionBlanks.length];

                try {
                    for (int i = 0; i < this.questionBlanks.length && !guessed; i++) {
                        nums[i] = Double.parseDouble(this.questionBlanks[i].getText());
                        if (this.guessChecker.checkGuesses(i, nums[i])) {
                            guessed = true;
                            this.mssge.setText("Already tried answer for question " + (1+i));
                        }
                    }
                    if (!guessed) {
                        this.mssge.setText(String.format("Number of Correct: %d / %d", this.guessChecker.checkAnswers(this.pair, nums),
                                this.guessChecker.questions()));
                    }
                }catch(NumberFormatException nfe){
                    this.mssge.setText("Invalid Input!!");
                }
            });
            newPairButton.setPrefSize(BUTTON_WIDTH+10,BUTTON_HEIGHT);
            newPairButton.setOnMouseClicked((e)->this.generate());
            close.setPrefSize(BUTTON_WIDTH,BUTTON_HEIGHT);
            close.setOnMouseClicked((e)->((Node)e.getSource()).getScene().getWindow().hide());
            hb.getChildren().addAll(submit,newPairButton,close);
            return hb;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
