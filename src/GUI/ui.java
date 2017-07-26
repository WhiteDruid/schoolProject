package GUI;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Borders;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextGUI;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import Database.Select;


public class ui   {	
	
	public static void main(String[] args) throws IOException , Exception  {
    	
		BasicWindow window = new BasicWindow();
		
    	Select select = new Select();
    	
		Terminal terminal = new DefaultTerminalFactory().createTerminal();
		
		Screen screen = new TerminalScreen(terminal);

		Button hei = null;
		
		screen.startScreen();
		
		WindowBasedTextGUI  text = new MultiWindowTextGUI(screen);	
		
		List<String> StudentId = select.selcetStudentId();
		
		List<String> namesOfStudent = select.selcetStudentName();
		
		List<String> StudentAges = select.selcetStudentAge();	
		
		List<String> TeacherId = select.selcetTeacherId();
		
		List<String> namesOfTeacher = select.selcetTeacherName();
		
		List<String> TeacherAge = select.selcetTeacherAge();		

		
		Panel mainPanel = new Panel();
		mainPanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));
		mainPanel.withBorder(Borders.singleLine("Taha App"));
		
		Panel panel = new Panel();
		mainPanel.addComponent(panel.withBorder(Borders.singleLine("Menu")));
		
		
		panel.addComponent(new Button("Add" , new Runnable(){
			@Override
			public void run() {
				MessageDialog.showMessageDialog(text, "mr airezaii", "i did this ");
			}
		}));
		
		panel.addComponent( new Button("Delet" , new Runnable(){
			@Override
			public void run() {
				System.out.println("hello");
			}
		}));
		
		Panel center = new Panel();
		mainPanel.addComponent(center.withBorder(Borders.singleLine("Panel")));

		Table<String> StudentTabel = new Table<String>("StudentId" , "StudentName" , "StuedntAge"); 
		StudentTabel.getTableModel().addRow(StudentId.toString().replace("[", " ").replace("]", "").replace(",", ""), namesOfStudent.toString().replace("[", " ").replace("]", "").replace(",", "") , StudentAges.toString().replace("[", " ").replace("]", "").replace(",", ""));
		StudentTabel.setSelectAction(new Runnable(){
					@Override
				public void run() {
					List<String> data = StudentTabel.getTableModel().getRow(StudentTabel.getSelectedRow());
					for(int i = 0; i < data.size(); i++) {
					    System.out.println(data.get(i));
					}
				}
			});
		
		Table<String> TeacherTabel = new Table<String>("TeacherId" , "TeacherName" , "TeacherAge"); 
		TeacherTabel.getTableModel().addRow(TeacherId.toString().replace("[", " ").replace("]", "").replace(",", ""), namesOfTeacher.toString().replace("[", " ").replace("]", "").replace(",", "") , TeacherAge.toString().replace("[", " ").replace("]", "").replace(",", ""));
		TeacherTabel.setSelectAction(new Runnable(){
					@Override
				public void run() {
					List<String> data = TeacherTabel.getTableModel().getRow(TeacherTabel.getSelectedRow());
					for(int i = 0; i < data.size(); i++) {
					    System.out.println(data.get(i));
					}
				}
			});
		
		panel.addComponent( new Button("StudentList" , new Runnable(){
			@Override
			public void run() {
				if(center.containsComponent(TeacherTabel)){
					center.removeComponent(TeacherTabel);
					if(!center.containsComponent(StudentTabel)){
						StudentTabel.addTo(center);
					}
			 }else {
					if(!center.containsComponent(StudentTabel)){
						StudentTabel.addTo(center);
					}
			 }
		}
	}));
		
		panel.addComponent( new Button("TeacherList" , new Runnable(){
			@Override
			public void run() {
				if(center.containsComponent(StudentTabel)){
					center.removeComponent(StudentTabel);
				if(!center.containsComponent(TeacherTabel)){
					TeacherTabel.addTo(center);
				}
			 }else {
					if(!center.containsComponent(TeacherTabel)){
						TeacherTabel.addTo(center);
				} 
			 }
			}
		}));

		
		window.setComponent(mainPanel);
		
		MultiWindowTextGUI win = new MultiWindowTextGUI(screen , new DefaultWindowManager() , new EmptySpace(TextColor.ANSI.CYAN));
		win.addWindowAndWait(window);


	}
}     

