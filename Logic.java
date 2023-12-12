import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
public class Logic implements KeyListener{
        private boolean b = false;
        private JTextField cells[][] = new JTextField[9][9];
        private int gameSolution[][];
        private boolean toEdit[][];
        

            public  Logic( int gs[][],boolean te[][]) {
            	gameSolution=gs;
            	toEdit=te;
            }

        public void uneditableNums(){
            for (int i = 0; i < gameSolution.length; i++) {
                for (int j = 0; j < gameSolution[i].length; j++) {
                    if (!toEdit[i][j]){
                        cells[i][j].setText(String.valueOf(gameSolution[i][j]));
                        cells[i][j].setEditable(false);
                        cells[i][j].setBackground(new Color(80, 89, 145));
                    }
                }
            }
        }
        
        public void solvedAll(){
            for (int i = 0; i < gameSolution.length; i++) {
                for (int j = 0; j < gameSolution[i].length; j++) {
                	if (toEdit[i][j]){
                		cells[i][j].setText(String.valueOf(gameSolution[i][j]));
                        cells[i][j].setBackground(new Color(73, 176, 0));
                        b=true;
                    }
                	}
                }
            }

        public void solveRandom(){
        	boolean found=false;
        	int n =1000;
        	int k=0;
        	while(!found&&k<n) {
        	Random rand = new Random();
        	int i= rand.nextInt(9);
        	int j= rand.nextInt(9);
                    if (cells[i][j].getText().equals("")){
                        cells[i][j].setText(String.valueOf(gameSolution[i][j]));
                        cells[i][j].setEditable(false);
                        toEdit[i][j]=false;
                        cells[i][j].setBackground(new Color(80, 89, 200));
                        found=true;
                    }
                    k++;
                }
        }
        public void keyTyped(KeyEvent e) {
            if (!Character.isDigit(e.getKeyChar())) {
                e.consume();
            }
        }

        public void keyPressed(KeyEvent e) {
        }
        
        public void CheckSwitch() {
        	b=!b;
        	CheckControll();
        }
        
        public void CheckControll() {
        	if (b) {
            	for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if(!cells[i][j].getText().isEmpty() && cells[i][j].isEditable()) {
                        	 if (Integer.parseInt(cells[i][j].getText()) != (gameSolution[i][j])) {
                                cells[i][j].setBackground(new Color(232, 2, 2));
                            }else{
                                cells[i][j].setBackground(new Color(73, 176, 0));
                            }
                        }else if (cells[i][j].isEditable()){
                               cells[i][j].setBackground(Color.WHITE);
                        }
                    }
                }
            }
                else {for (int i = 0; i < gameSolution.length; i++) {
                    for (int j = 0; j < gameSolution[i].length; j++) {
                        if (toEdit[i][j]){
                            cells[i][j].setBackground(Color.white);
                        }}}}
                }

        public void keyReleased(KeyEvent e) {
        	CheckControll();
        }
            

        public JTextField[][] getCells(){
            return cells;
        }
}
