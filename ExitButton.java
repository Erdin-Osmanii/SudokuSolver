import javax.swing.*;
import java.awt.event.*;
public class ExitButton extends JButton implements ActionListener
{
/** Constructor ExitButton builds the controller
* @param my label - the label for the controller's button */
public ExitButton(String my_label)
{ super(my_label);
addActionListener(this);
}
/** actionPerformed handles a button-push event
* @param evt - the event */
public void actionPerformed(ActionEvent evt)
{ System.exit(0); }
}
