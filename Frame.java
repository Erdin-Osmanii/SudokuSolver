import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
public class Frame extends JFrame{    
        private JPanel gameFrame = new JPanel();
	    Logic sudokuLogic = new LocalGame().getLogic();
	    public Frame() {
	    gameFrame.setLayout(new GridLayout(9,9));
	         Font bigFont = new Font("sans-serif", Font.BOLD, 24);
	         for (int i = 0; i < 9; i++) {
	             for (int j = 0; j < 9; j++) {
	                 JTextField cell = new JTextField();
	                 gameFrame.add(cell);
	                 cell.addKeyListener(sudokuLogic);
	                 cell.setFocusable(true);
	                 sudokuLogic.getCells()[i][j] = cell;
	                 cell.setFont(bigFont);
	                 cell.setHorizontalAlignment(JTextField.CENTER);
	                 Border border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY);
	                 sudokuLogic.getCells()[i][j].setBorder(border);
	                 if (i % 3 == 0 && i > 0){
	                     Border newBorder = BorderFactory.createMatteBorder(3, 1, 1, 1, Color.GRAY);
	                     sudokuLogic.getCells()[i][j].setBorder(newBorder);
	                 }
	                 if (j % 3 == 2 && j < 8){
	                     Border newBorder = BorderFactory.createMatteBorder(1, 1, 1, 3, Color.GRAY);
	                     sudokuLogic.getCells()[i][j].setBorder(newBorder);
	                 }
	                 if ((i%3==0 && j%3 == 2 && i>0 && j<8)){
	                     Border newBorder = BorderFactory.createMatteBorder(3, 1, 1, 3, Color.GRAY);
	                     sudokuLogic.getCells()[i][j].setBorder(newBorder);
	                 }
	             }
	         }
	    sudokuLogic.uneditableNums();	
    	Container cp = getContentPane();
    	cp.setLayout(new BorderLayout());
    	cp.add(gameFrame, BorderLayout.NORTH); // add the scrolling list to the pane
    	JPanel p = new JPanel(new FlowLayout());
    	p.add(new SolveRandomButton("Solve Random",gameFrame,sudokuLogic)); 
    	p.add(new SolveAllButton("Solve All",gameFrame,sudokuLogic)); 
    	p.add(new CheckButton("Check",gameFrame,sudokuLogic)); 
    	p.add(new ExitButton("Quit")); 
    	cp.add(p, BorderLayout.SOUTH);
    	setSize(420, 400);
    	setVisible(true);
    }
}
