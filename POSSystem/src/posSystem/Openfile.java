package posSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Openfile
{
	private JFileChooser file = new JFileChooser();
	private FileNameExtensionFilter filter = new FileNameExtensionFilter("*.txt");
	private File input;

	public Openfile()
	{
		file.setFileFilter(filter);
		input = file.getSelectedFile();

		read();

	}

	void read()
	{
		try
		{
			FileReader fileReader = new FileReader(input);
			BufferedReader reader = new BufferedReader(fileReader);
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				if (isStringDouble(line))
				{
					for (int i = 0 ; i < Integer.parseInt(line); i++)
					{
						int size = line.length();
						
					}
				}
			}
			// read line then insert number

			reader.close();
		} catch (Exception ex)
		{
		}
	}

	public static boolean isStringDouble(String s)
	{
		try
		{
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e)
		{
			return false;
		}
	}
}
