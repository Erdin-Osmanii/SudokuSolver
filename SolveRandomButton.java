import javax.swing.*;
import java.awt.event.*;
public class SolveRandomButton extends JButton implements ActionListener
{
private JPanel gameFrame;
private	Logic l ;

public SolveRandomButton(String my_label,JPanel p,Logic lo)
{ super(my_label);
 gameFrame=p;
 l=lo;
 addActionListener(this);
}

public void actionPerformed(ActionEvent evt)
{   l.solveRandom();
}
}
