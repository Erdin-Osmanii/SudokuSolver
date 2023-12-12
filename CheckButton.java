import javax.swing.*;
import java.awt.event.*;
public class CheckButton extends JButton implements ActionListener
{
private JPanel gameFrame;
private	Logic l ;

public CheckButton(String my_label,JPanel p,Logic lo)
{ super(my_label);
 gameFrame=p;
 l=lo;
 addActionListener(this);
}

public void actionPerformed(ActionEvent evt)
{   l.CheckSwitch(); 
}
}
