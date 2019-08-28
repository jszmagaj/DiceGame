package application;


import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Controller {

    @FXML
    Label finalscore1, finalscore2;

    @FXML
    TextField score1, score2, wynik1, wynik2;

    @FXML
    ImageView  kosc1, kosc2, kosc3, kosc4, kosc5;

    @FXML
    Button roll, jeden1, jeden2, dwa1, dwa2, trzy1, trzy2, cztery1, cztery2, piec1, piec2, szesc1, szesc2, threex1, threex2, fourx1, fourx2, full1, full2, mstrit1, mstrit2, dstrit1, dstrit2, gen1, gen2, szansa1, szansa2;


    private ArrayList<ImageView> kosci = new ArrayList<>();

    private ArrayList<Kosc> dice = new ArrayList<>();

    private String currentPlayer = "p1";

    private int change = 0;

    private int sum1, sum2;

    private int end = 0;

    private String winner;

    public void initialize() {
        for (int i = 0; i < 5; i++) {
            dice.add(new Kosc());
        }

        kosci.add(kosc1);
        kosci.add(kosc2);
        kosci.add(kosc3);
        kosci.add(kosc4);
        kosci.add(kosc5);

        roll();
        change = 0;

    }

    public void roll() {

        change++;
        int random;
        double randomX;
        double randomRotate;


        for (int i = 0; i < 5; i++) {
            random = (int) (Math.random() * 6) + 1;
            randomX = (Math.random() * 25) + 50;
            randomRotate = Math.random() * 100;
            if(!dice.get(i).isSelected()) {
                setImages(random, dice.get(i));
                dice.get(i).setValue(random); // set random value to each dice
                Image image = SwingFXUtils.toFXImage(dice.get(i).getImage(), null); // zamienia BufferedImage na Image
                kosci.get(i).setImage(image);
                kosci.get(i).setX(randomX);
                kosci.get(i).setY(randomX);
                kosci.get(i).setRotate(randomRotate);
            }
        }


        // player1
        fillPartOne(jeden1, 1);
        fillPartOne(dwa1, 2);
        fillPartOne(trzy1, 3);
        fillPartOne(cztery1, 4);
        fillPartOne(piec1, 5);
        fillPartOne(szesc1, 6);

        //player2
        fillPartOne(jeden2, 1);
        fillPartOne(dwa2, 2);
        fillPartOne(trzy2, 3);
        fillPartOne(cztery2, 4);
        fillPartOne(piec2, 5);
        fillPartOne(szesc2, 6);


        showScore1();
        showScore2();

        show();
        sameThree();
        sameFour();
        general();
        full();
        strit();
        szansa();


        if (change == 2) {
            rollHide();
            change = 0;
        }


    }

    @FXML
    public void selectedDice1() throws IOException {  // don't know how to do this in loop for now, need to make new function for each dice
        if(!dice.get(0).isSelected()) {
            BufferedImage image = ImageIO.read(new File("src/sample/kosci/" + dice.get(0).getValue() + "red.jpg"));
            Image red = SwingFXUtils.toFXImage(image, null);
            kosc1.setImage(red);
            dice.get(0).setSelected(true);
        } else {
            BufferedImage image = ImageIO.read(new File("src/sample/kosci/" + dice.get(0).getValue() + ".jpg"));
            Image red = SwingFXUtils.toFXImage(image, null);
            kosc1.setImage(red);
            dice.get(0).setSelected(false);
        }
    }
    @FXML
    public void selectedDice2() throws IOException {
        if(!dice.get(1).isSelected()) {
            BufferedImage image = ImageIO.read(new File("src/sample/kosci/" + dice.get(1).getValue() + "red.jpg"));
            Image red = SwingFXUtils.toFXImage(image, null);
            kosc2.setImage(red);
            dice.get(1).setSelected(true);
        } else {
            BufferedImage image = ImageIO.read(new File("src/sample/kosci/" + dice.get(1).getValue() + ".jpg"));
            Image red = SwingFXUtils.toFXImage(image, null);
            kosc2.setImage(red);
            dice.get(1).setSelected(false);
        }
    }
    @FXML
    public void selectedDice3() throws IOException {
        if(!dice.get(2).isSelected()) {
            BufferedImage image = ImageIO.read(new File("src/sample/kosci/" + dice.get(2).getValue() + "red.jpg"));
            Image red = SwingFXUtils.toFXImage(image, null);
            kosc3.setImage(red);
            dice.get(2).setSelected(true);
        } else {
            BufferedImage image = ImageIO.read(new File("src/sample/kosci/" + dice.get(2).getValue() + ".jpg"));
            Image red = SwingFXUtils.toFXImage(image, null);
            kosc3.setImage(red);
            dice.get(2).setSelected(false);
        }
    }
    @FXML
    public void selectedDice4() throws IOException {
        if(!dice.get(3).isSelected()) {
            BufferedImage image = ImageIO.read(new File("src/sample/kosci/" + dice.get(3).getValue() + "red.jpg"));
            Image red = SwingFXUtils.toFXImage(image, null);
            kosc4.setImage(red);
            dice.get(3).setSelected(true);
        } else {
            BufferedImage image = ImageIO.read(new File("src/sample/kosci/" + dice.get(3).getValue() + ".jpg"));
            Image red = SwingFXUtils.toFXImage(image, null);
            kosc4.setImage(red);
            dice.get(3).setSelected(false);
        }
    }
    @FXML
    public void selectedDice5() throws IOException {
        if(!dice.get(4).isSelected()) {
            BufferedImage image = ImageIO.read(new File("src/sample/kosci/" + dice.get(4).getValue() + "red.jpg"));
            Image red = SwingFXUtils.toFXImage(image, null);
            kosc5.setImage(red);
            dice.get(4).setSelected(true);
        } else {
            BufferedImage image = ImageIO.read(new File("src/sample/kosci/" + dice.get(4).getValue() + ".jpg"));
            Image red = SwingFXUtils.toFXImage(image, null);
            kosc5.setImage(red);
            dice.get(4).setSelected(false);
        }
    }

    @FXML
    public void pressToFill(ActionEvent event){
        refresh();
        Button button = (Button)event.getSource();
        button.setOpacity(1.0);
        button.setDisable(true);
        end++;

        if(end == 26){
            try {
                endGame();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        change = 0;
        rollShow();
        show();
        changePlayer();


    }

    private void refresh(){
        for (int i = 0; i<dice.size();i++){
            dice.get(i).setSelected(false);
        }
    }

    private void fillPartOne(Button button, int a) {  // filling scored from 1 to 6
        int score = 0;
        if (!button.isDisabled()) {  //  after chosing score it's not changed after roll
            for (int i = 0; i < dice.size(); i++) {
                if (dice.get(i).getValue() == a) {
                    score += a;
                }
            }
            button.setText(String.valueOf(score));
        }
    }

    private void changePlayer() {
        refresh();
        if (currentPlayer.equals("p1")) {
            currentPlayer = "p2";

            roll();
        } else {
            currentPlayer = "p1";
            roll();
        }

    }

    private void setImages(int num, Kosc kosc) {
        try {
            kosc.setImage(ImageIO.read(new File("src/sample/kosci/" + num + ".jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void hide(Button button) {  // hiding scores for other player and showing scores already pressed
        if (button.isDisabled()) {
            button.setVisible(true);
        } else {
            button.setVisible(false);
        }
    }

    private void show() {
        if (currentPlayer.equals("p1")) {
            jeden1.setVisible(true);
            dwa1.setVisible(true);
            trzy1.setVisible(true);
            cztery1.setVisible(true);
            piec1.setVisible(true);
            szesc1.setVisible(true);
            threex1.setVisible(true);
            fourx1.setVisible(true);
            full1.setVisible(true);
            mstrit1.setVisible(true);
            dstrit1.setVisible(true);
            gen1.setVisible(true);
            szansa1.setVisible(true);

            hide(jeden2);
            hide(dwa2);
            hide(trzy2);
            hide(cztery2);
            hide(piec2);
            hide(szesc2);
            hide(threex2);
            hide(fourx2);
            hide(full2);
            hide(mstrit2);
            hide(dstrit2);
            hide(gen2);
            hide(szansa2);

        } else if (currentPlayer.equals("p2")) {
            jeden2.setVisible(true);
            dwa2.setVisible(true);
            trzy2.setVisible(true);
            cztery2.setVisible(true);
            piec2.setVisible(true);
            szesc2.setVisible(true);
            threex2.setVisible(true);
            fourx2.setVisible(true);
            full2.setVisible(true);
            mstrit2.setVisible(true);
            dstrit2.setVisible(true);
            gen2.setVisible(true);
            szansa2.setVisible(true);

            hide(jeden1);
            hide(dwa1);
            hide(trzy1);
            hide(cztery1);
            hide(piec1);
            hide(szesc1);
            hide(threex1);
            hide(fourx1);
            hide(full1);
            hide(mstrit1);
            hide(dstrit1);
            hide(gen1);
            hide(szansa1);
        }
    }

    private void rollShow() {
        roll.setDisable(false);
        roll.setStyle("-fx-background-color: red; -fx-border-color: white");
    }

    private void rollHide() {
        roll.setDisable(true);
        roll.setStyle("-fx-background-color: green; -fx-border-color: white");
    }

    private void sameThree() {

        if (currentPlayer.equals("p1")) {

            if (!threex1.isDisabled()) {
                threex1.setText("0");
                int[] a = new int[6];


                for (int i = 0; i < dice.size(); i++) {
                    a[dice.get(i).getValue() - 1]++;
                }

                for(int i=0; i<a.length; i++){
                    if(a[i] >=3){
                        threex1.setText(String.valueOf(a[i]*(i+1)));
                    }
                }
            }
        }
        if (currentPlayer.equals("p2")) {

            if (!threex2.isDisabled()) {
                threex2.setText("0");
                int[] a = new int[6];


                for (int i = 0; i < dice.size(); i++) {
                    a[dice.get(i).getValue() - 1]++;
                }

                for(int i=0; i<a.length; i++){
                    if(a[i] >=3){
                        threex2.setText(String.valueOf(a[i]*(i+1)));
                    }
                }
            }
        }
    }

    private void sameFour() {

        if (currentPlayer.equals("p1")) {

            if (!fourx1.isDisabled()) {
                fourx1.setText("0");
                int[] a = new int[6];


                for (int i = 0; i < dice.size(); i++) {
                    a[dice.get(i).getValue() - 1]++;
                }

                for(int i=0; i<a.length; i++){
                    if(a[i] >=4){
                        fourx1.setText(String.valueOf(a[i]*(i+1)));
                    }
                }
            }
        }
        if (currentPlayer.equals("p2")) {

            if (!fourx2.isDisabled()) {
                fourx2.setText("0");
                int[] a = new int[6];


                for (int i = 0; i < dice.size(); i++) {
                    a[dice.get(i).getValue() - 1]++;
                }

                for(int i=0; i<a.length; i++){
                    if(a[i] >=4){
                        fourx2.setText(String.valueOf(a[i]*(i+1)));
                    }
                }
            }
        }
    }

    private void general() {

        showNotDisabled(gen1, gen2);

        if (!gen1.isDisabled()) {
            if (isSame() && currentPlayer.equals("p1")) {
                gen1.setText("50");
            }
        }
        if (!gen2.isDisabled()) {
            if (isSame() && currentPlayer.equals("p2")) {
                gen2.setText("50");
            }
        }
    }

    private void full(){
        int[] a = new int[6];

        showNotDisabled(full1, full2);

        for(int i = 0; i<dice.size();i++){
            a[dice.get(i).getValue()-1]++;
        }


        for (int i : a){
            if(i==3){
                for(int j : a){
                    if(j==2){
                        if(!full1.isDisabled()) {
                            if (currentPlayer.equals("p1")) {
                                full1.setText("25");
                            }
                        }
                        if(!full2.isDisabled()) {
                            if (currentPlayer.equals("p2")) {
                                full2.setText("25");
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean isSame(){
        for(int i=0; i<dice.size();i++){
            if(dice.get(0).getValue() != dice.get(i).getValue()){
                return false;
            }
        }
        return true;
    }

    private void strit() {

        int[] a = new int[6];

        showNotDisabled(mstrit1, mstrit2);
        showNotDisabled(dstrit1, dstrit2);

        for (int i = 0; i < dice.size(); i++) {
            a[i] = dice.get(i).getValue();
        }

        // maly strit
        if (contains(a, 1) && contains(a, 2) && contains(a, 3) && contains(a, 4)
                || contains(a, 2) && contains(a, 3) && contains(a, 4) && contains(a, 5)
                || contains(a, 3) && contains(a, 4) && contains(a, 5) && contains(a, 6)) {

            if(!mstrit1.isDisabled()) {
                if (currentPlayer.equals("p1")) {
                    mstrit1.setText("30");
                }
            }
            if(!mstrit2.isDisabled()) {
                if (currentPlayer.equals("p2")) {
                    mstrit2.setText("30");
                }
            }
        }


        // duzy strit
        if (contains(a, 1) && contains(a, 2) && contains(a, 3) && contains(a, 4) && contains(a, 5) ||
                contains(a, 2) && contains(a, 3) && contains(a, 4) && contains(a, 5) && contains(a, 6)) {
            if(!dstrit1.isDisabled()) {
                if (currentPlayer.equals("p1")) {
                    dstrit1.setText("40");
                }
            }
            if(!dstrit2.isDisabled()) {
                if (currentPlayer.equals("p2")) {
                    dstrit2.setText("40");
                }
            }
        }
    }

    private void szansa() {

        showNotDisabled(szansa1, szansa2);

        int[] a = new int[6];

        for (int i = 0; i < dice.size(); i++) {
            a[i] = dice.get(i).getValue();
        }
        int sum = 0;
        for (int i : a) {
            sum += i;
        }

        if(currentPlayer.equals("p1")){
            if(!szansa1.isDisabled()) {
                szansa1.setText(String.valueOf(sum));
            }
        }
        if (currentPlayer.equals("p2")) {
            if (!szansa2.isDisabled()) {
                szansa2.setText(String.valueOf(sum));
            }
        }
    }

    private void showScore1(){
        int sum = 0;

        //player1
        int a = getInt(jeden1);
        int b = getInt(dwa1);
        int c = getInt(trzy1);
        int d = getInt(cztery1);
        int e = getInt(piec1);
        int f = getInt(szesc1);

        sum = a+b+c+d+e+f;
        sum1 = sum;

        score1.setText(String.valueOf(sum));
        if(sum >= 63){
            score1.setText(String.valueOf(sum + 35));
        }

        //player2
        a = getInt(jeden2);
        b = getInt(dwa2);
        c = getInt(trzy2);
        d = getInt(cztery2);
        e = getInt(piec2);
        f = getInt(szesc2);

        sum = a+b+c+d+e+f;
        sum2 = sum;

        score2.setText(String.valueOf(sum));
        if(sum >= 63){
            score2.setText(String.valueOf(sum + 35));
        }

    }

    private void showScore2(){

        int sum = 0;

        //player1
        int a = getInt(threex1);
        int b = getInt(fourx1);
        int c = getInt(full1);
        int d = getInt(mstrit1);
        int e = getInt(dstrit1);
        int f = getInt(gen1);
        int g = getInt(szansa1);

        sum = a+b+c+d+e+f+g;
        wynik1.setText(String.valueOf(sum + sum1));
        finalscore1.setText(String.valueOf(sum + sum1));


        int summ = 0;
        //player2
        a = getInt(threex2);
        b = getInt(fourx2);
        c = getInt(full2);
        d = getInt(mstrit2);
        e = getInt(dstrit2);
        f = getInt(gen2);
        g = getInt(szansa2);

        summ = a+b+c+d+e+f+g;
        wynik2.setText(String.valueOf(summ+sum2));
        finalscore2.setText(String.valueOf(summ + sum2));

        if(sum + sum1 > summ+sum2){
            winner = "Player 1";
        } else {
            winner = "Player 2";
        }

    }

    private int getInt(Button button){
        int i = 0;
        if(button.isDisabled()){
            i = Integer.valueOf(button.getText());
        }
        return i;
    }

    private void showNotDisabled(Button button1, Button button2){
        if(currentPlayer.equals("p1")){
            if(!button1.isDisabled()){
                button1.setText("0");
            }
        } else if (currentPlayer.equals("p2")){
            if(!button2.isDisabled()){
                button2.setText("0");
            }
        }
    }

    private boolean contains(int[]array, int i){ // check if array contains number -> needed for strit
        boolean result = false;

        for (int a : array){
            if(a == i){
                result = true;
                break;
            }
        }
        return result;
    }

    private void endGame() throws IOException {
        Dialog dialog = new Dialog();
        FXMLLoader.load(getClass().getResource("../controllers/sample.fxml"));
        dialog.setTitle("WINNER");
        dialog.setHeaderText(winner + " won!");
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();
    }
}