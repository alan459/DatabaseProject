import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// panel with functioning main menu button
public class Main_Menu_Button extends JPanel
{
	public Main_Menu_Button(final Hospital_Frame hospital_frame)
	{
		setLayout(new GridBagLayout());

		JButton main_menu_button = new JButton("Main Menu");


		/* Add functionality - Return user to main menu */
		main_menu_button.addActionListener(
                        new ActionListener()
                        {
                                public void actionPerformed(ActionEvent e)
                                {       
                                    hospital_frame.changeScreen(new Main_Menu_Panel(hospital_frame));
                                }
                        });
		

		add(main_menu_button);

	}
}