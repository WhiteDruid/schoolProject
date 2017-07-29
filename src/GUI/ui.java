package GUI;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Borders;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogBuilder;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import Database.Repository;
import Database.Select;
import Database.TableAction;

public class ui   {	
	
	static List<String> StudentId = Select.selcetStudentId();
	
	static List<String> namesOfStudent = Select.selcetStudentName();
	
	static List<String> StudentAges = Select.selcetStudentAge();	
	
	static List<String> TeacherId = Select.selcetTeacherId();
	
	static List<String> namesOfTeacher = Select.selcetTeacherName();
	
	static List<String> TeacherAge = Select.selcetTeacherAge();		

	static List<String> CourseId = Select.selcetCourseId();
	
	static List<String> namesOfCourse = Select.selcetCourseName();
	
	static List<String> courseTeacher = Select.selcetCourseTeacher();		

	static Table<String> StudentTabel;

	static Table<String> CourseTable;
	
	static Table<String> TeacherTable;
	
	public static void main(String[] args) throws IOException , Exception  {
    	
		TableAction action = new TableAction();
		
		BasicWindow window = new BasicWindow();
		
    	Select select = new Select();
    	
		Terminal terminal = new DefaultTerminalFactory().createTerminal();
		
		Screen screen = new TerminalScreen(terminal);
		
		screen.startScreen();
		
		WindowBasedTextGUI  text = new MultiWindowTextGUI(screen);	
		
		
		Panel mainPanel = new Panel();
		mainPanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));
		mainPanel.withBorder(Borders.singleLine("Taha App"));
		
		Panel panel = new Panel();
		mainPanel.addComponent(panel.withBorder(Borders.singleLine("Menu")));
		
		
		panel.addComponent( new Button("Delet" , new Runnable(){
			@Override
			public void run() {
				System.out.println("hello");
			}
		}));
		
         TextBox TeacherName = new TextBox() ;
         TextBox TeacherCourse = new TextBox() ;
         TextBox teacherAge = new TextBox() ;
         TextBox StudentName = new TextBox() ;
         TextBox StudentCourse = new TextBox() ;
         TextBox StudentAge = new TextBox() ;
         TextBox CourseName = new TextBox() ;
         TextBox CourseTeacher = new TextBox() ;

		
		Panel center = new Panel();
		mainPanel.addComponent(center.withBorder(Borders.singleLine("Panel")));
		
		panel.addComponent(new Button("AddCourse" , new Runnable(){
			@Override
			public void run() {
				if(center.containsComponent(TeacherTable) || center.containsComponent(CourseTable) || center.containsComponent(StudentTabel) || center.containsComponent(StudentName)){
					center.removeAllComponents();	
				}
				if(!center.containsComponent(CourseName)){ 
		        new Label("CourseName :").addTo(center);
		        CourseName.addTo(center);
		        
		        new Label("TeacherName :").addTo(center);
		        CourseTeacher.addTo(center);
				
		        center.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
		        center.addComponent(new Button("Submit" , new Runnable(){
					@SuppressWarnings("static-access")
					@Override
					public void run() {
				        if(!CourseName.getText().equals("") &&  !CourseTeacher.getText().equals("")) {
				        	new MessageDialogBuilder()
				    		.setTitle("It Was Succsus").setText("the detail sended").build().showDialog(text);
				        	try {				        
								 action.CourseInsert(CourseTeacher.getText().toString() , CourseTeacher.getText().toString()); 
				        	} catch (SQLException e) {
								e.printStackTrace();
				        	}
				        }
				      }
		        }));
			 }
			}
		}));

		
		panel.addComponent(new Button("AddTeacher" , new Runnable(){
			@Override
			public void run() {
				if(center.containsComponent(TeacherTable) || center.containsComponent(CourseTable) || center.containsComponent(StudentTabel) || center.containsComponent(StudentName) || center.containsComponent(CourseName)){
					center.removeAllComponents();	
				}
				if(!center.containsComponent(TeacherName)){ 
		        new Label("TeacherName :").addTo(center);
		        TeacherName.addTo(center);
		        
		        new Label("TeacherCourse :").addTo(center);
		        TeacherCourse.addTo(center);

		        new Label("TeacherAge :").addTo(center);
		        teacherAge.setValidationPattern(Pattern.compile("[0-9]*"));
				teacherAge.addTo(center);
				
		        center.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
		        center.addComponent(new Button("Submit" , new Runnable(){
					@SuppressWarnings("static-access")
					@Override
					public void run() {
				        if(!TeacherName.getText().equals("") &&  !TeacherCourse.getText().equals("") && !teacherAge.getText().equals("")) {
				        	new MessageDialogBuilder()
				    		.setTitle("It Was Succsus").setText("the detail sended").build().showDialog(text);
				        	int y = Integer.parseInt(teacherAge.getText());				        	
				        	try {				        
								 action.TeacherInsert(TeacherName.getText().toString() , y);
								 
				        	} catch (SQLException e) {
								e.printStackTrace();
				        	}
				        }
				      }
		        }));
			 }
			}
		}));

	   	
		panel.addComponent(new Button("AddStudent" , new Runnable(){
			@Override
			public void run() {
				if(center.containsComponent(TeacherTable) || center.containsComponent(CourseTable) || center.containsComponent(StudentTabel) || center.containsComponent(TeacherName) || center.containsComponent(CourseName)){
					center.removeAllComponents();	
				}
				if(!center.containsComponent(StudentName)){ 
		        new Label("StudentName :").addTo(center);
		        StudentName.addTo(center);
		        
		        new Label("StudentCourse :").addTo(center);
		        StudentCourse.addTo(center);

		        new Label("StudentAge :").addTo(center);
		        StudentAge.setValidationPattern(Pattern.compile("[0-9]*"));
		        StudentAge.addTo(center);
				
		        center.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
		        center.addComponent(new Button("Submit" , new Runnable(){
					@Override
					public void run() {
				        if(!StudentName.getText().equals("") &&  !StudentCourse.getText().equals("") && !StudentAge.getText().equals("")) {
				        	new MessageDialogBuilder()
				    		.setTitle("It Was Succsus").setText("the detail sended").build().showDialog(text);
				        	int y = Integer.parseInt(StudentAge.getText());				        	
				        	try {				        
								 action.StudentInsert(StudentName.getText().toString() , y);
				        	} catch (SQLException e) {
								e.printStackTrace();
							}
				        }
				      }
		        }));
			 }
			}
		}));

		
		panel.addComponent( new Button("StudentList" , new Runnable(){
			@Override
			public void run() {
				if(center.containsComponent(TeacherTable) || center.containsComponent(CourseTable) || center.containsComponent(teacherAge) || center.containsComponent(StudentName) || center.containsComponent(CourseName)){
					center.removeAllComponents();
					if(!center.containsComponent(StudentTabel)){
					
					   	 List<String> StudentId = Select.selcetStudentId();
						 	
					   	 List<String> namesOfStudent = Select.selcetStudentName();
					   	
					   	 List<String>  StudentAges = Select.selcetStudentAge();	

						 
						 StudentTabel = new Table<String>("StudentId" , "StudentName" , "StuedntAge"); 
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

						
						StudentTabel.addTo(center);
					}
			 }else {
					if(!center.containsComponent(StudentTabel)){
					   	 List<String> StudentId = Select.selcetStudentId();
						 	
					   	 List<String> namesOfStudent = Select.selcetStudentName();
					   	
					   	 List<String>  StudentAges = Select.selcetStudentAge();	

						 
						 StudentTabel = new Table<String>("StudentId" , "StudentName" , "StuedntAge"); 
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

						StudentTabel.addTo(center);
					}
			 }
		}
	}));
		
		panel.addComponent( new Button("TeacherList" , new Runnable(){
			@Override
			public void run() {
				if(center.containsComponent(StudentTabel) || center.containsComponent(CourseTable) || center.containsComponent(teacherAge) || center.containsComponent(StudentName) || center.containsComponent(CourseName) ){
					center.removeAllComponents();
				if(!center.containsComponent(TeacherTable)){
					
					 List<String>  TeacherId = Select.selcetTeacherId();
					   	
				   	 List<String> namesOfTeacher = Select.selcetTeacherName();
				   	
				     List<String> TeacherAge = Select.selcetTeacherAge();		

				     TeacherTable = new Table<String>("TeacherId" , "TeacherName" , "TeacherAge"); 
						TeacherTable.getTableModel().addRow(TeacherId.toString().replace("[", " ").replace("]", "").replace(",", ""), namesOfTeacher.toString().replace("[", " ").replace("]", "").replace(",", "") , TeacherAge.toString().replace("[", " ").replace("]", "").replace(",", ""));
						TeacherTable.setSelectAction(new Runnable(){
									@Override
								public void run() {
									List<String> data = TeacherTable.getTableModel().getRow(TeacherTable.getSelectedRow());
									for(int i = 0; i < data.size(); i++) {
									    System.out.println(data.get(i));
									}
								}
							});

					TeacherTable.addTo(center);
				}
			 }else {
					if(!center.containsComponent(TeacherTable)){
						 List<String>  TeacherId = Select.selcetTeacherId();
						   	
					   	 List<String> namesOfTeacher = Select.selcetTeacherName();
					   	
					     List<String> TeacherAge = Select.selcetTeacherAge();		

					     TeacherTable = new Table<String>("TeacherId" , "TeacherName" , "TeacherAge"); 
							TeacherTable.getTableModel().addRow(TeacherId.toString().replace("[", " ").replace("]", "").replace(",", ""), namesOfTeacher.toString().replace("[", " ").replace("]", "").replace(",", "") , TeacherAge.toString().replace("[", " ").replace("]", "").replace(",", ""));
							TeacherTable.setSelectAction(new Runnable(){
										@Override
									public void run() {
										List<String> data = TeacherTable.getTableModel().getRow(TeacherTable.getSelectedRow());
										for(int i = 0; i < data.size(); i++) {
										    System.out.println(data.get(i));
										}
									}
								});

						
						TeacherTable.addTo(center);
				} 
			 }
			}
		}));

		
		panel.addComponent( new Button("CourseList" , new Runnable(){
			@Override
			public void run() {
				if(center.containsComponent(StudentTabel) || center.containsComponent(TeacherTable) || center.containsComponent(teacherAge) || center.containsComponent(StudentName) || center.containsComponent(CourseName)){
					center.removeAllComponents();
				if(!center.containsComponent(CourseTable)){
					 List<String> CourseId = Select.selcetCourseId();
					   	
					 List<String> namesOfCourse = Select.selcetCourseName();
					   	
					 List<String> courseTeacher = Select.selcetCourseTeacher();		
				   	 
					 CourseTable = new Table<String>("CourseId" , "CourseName" , "TeacherName"); 
						CourseTable.getTableModel().addRow(CourseId.toString().replace("[", " ").replace("]", "").replace(",", ""), namesOfCourse.toString().replace("[", " ").replace("]", "").replace(",", "") , courseTeacher.toString().replace("[", " ").replace("]", "").replace(",", ""));
						CourseTable.setSelectAction(new Runnable(){
									@Override
								public void run() {
									List<String> data = CourseTable.getTableModel().getRow(CourseTable.getSelectedRow());
									for(int i = 0; i < data.size(); i++) {
									    System.out.println(data.get(i));
									}
								}
							});

				
					CourseTable.addTo(center);
				}
			 }else {		
				 if(!center.containsComponent(CourseTable)){
					 List<String> CourseId = Select.selcetCourseId();
					   	
					 List<String> namesOfCourse = Select.selcetCourseName();
					   	
					 List<String> courseTeacher = Select.selcetCourseTeacher();		
				   	 
					 CourseTable = new Table<String>("CourseId" , "CourseName" , "TeacherName"); 
						CourseTable.getTableModel().addRow(CourseId.toString().replace("[", " ").replace("]", "").replace(",", ""), namesOfCourse.toString().replace("[", " ").replace("]", "").replace(",", "") , courseTeacher.toString().replace("[", " ").replace("]", "").replace(",", ""));
						CourseTable.setSelectAction(new Runnable(){
									@Override
								public void run() {
									List<String> data = CourseTable.getTableModel().getRow(CourseTable.getSelectedRow());
									for(int i = 0; i < data.size(); i++) {
									    System.out.println(data.get(i));
									}
								}
							});


					CourseTable.addTo(center);
				} 
			 }
			}
		}));

		
		window.setComponent(mainPanel);
		
		MultiWindowTextGUI win = new MultiWindowTextGUI(screen , new DefaultWindowManager() , new EmptySpace(TextColor.ANSI.BLUE));
		win.addWindowAndWait(window);


	}
}     

