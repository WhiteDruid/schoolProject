package GUI;

import java.awt.Cursor;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Borders;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.CheckBoxList;
import com.googlecode.lanterna.gui2.CheckBoxList.Listener;
import com.googlecode.lanterna.gui2.Component;
import com.googlecode.lanterna.gui2.DefaultWindowManager;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.TextBox;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogBuilder;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import Database.Repository;
import Database.Select;
import Database.TableAction;
import model.Teacher;

public class ui   {	
	
	static List<String> StudentId = Select.selcetStudentId();
	
	static List<String> namesOfStudent = Select.selcetStudentName();
	
	static List<String> StudentAges = Select.selcetStudentAge();	
	
	static List<String> TeacherId = Select.selcetTeacherId();
	
	static List<String> namesOfTeacher = Select.selcetteacherName();
	
	static List<String> TeacherAge = Select.selcetTeacherAge();		

	static List<String> CourseId = Select.selcetCourseId();
	
	static List<String> namesOfCourse = Select.selcetCourseName();
	
	static List<String> courseTeacher = Select.selcetCourseTeacher();		

	static Table<String> StudentTabel;

	static Table<String> CourseTable;
	
	static Table<String> TeacherTable;
	
	static Table<String> WiringList;
	
	static Table<String> WiringListInnerJoin;
	
	static CheckBoxList<String> checkBoxList ;

	static CheckBoxList<String> checkB2oxList;
	
	static CheckBoxList<String> checkB3oxList;
	
	static Button but ;

	static Button but1 ;
	
	static Button hi ;
	
	static Button bye;

	static Button one;
	
	public static void main(String[] args) throws IOException , Exception  {
    	
		
		TableAction action = new TableAction();
		
		BasicWindow window = new BasicWindow();
		
    	Select select = new Select();
    	
		Repository.CreateDatabase();
		action.createCourceTable();
		action.createTeacherTable();
		action.createStudentTable();
		action.createWiringTable();

    	
    	Terminal terminal = new DefaultTerminalFactory().createTerminal();
		
		Screen screen = new TerminalScreen(terminal);
		
		screen.startScreen();
		
		WindowBasedTextGUI  text = new MultiWindowTextGUI(screen);			
		
		Panel mainPanel = new Panel();
		mainPanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));
		mainPanel.withBorder(Borders.singleLine("Taha App"));
		
		Panel panel = new Panel();
		mainPanel.addComponent(panel.withBorder(Borders.singleLine("Menu")));
		
         TextBox TeacherName = new TextBox() ;
         TextBox TeacherCourse = new TextBox() ;
         TextBox teacherAge = new TextBox() ;
         TextBox StudentName = new TextBox() ;
         TextBox StudentCourse = new TextBox() ;
         TextBox StudentAge = new TextBox() ;
         TextBox CourseName = new TextBox() ;
         TextBox CourseTeacher = new TextBox() ;
         TextBox ListName = new TextBox();
         TextBox Column = new TextBox();
         TextBox IdNumber = new TextBox();
         TextBox tableName = new TextBox();
         TextBox column = new TextBox();
         TextBox Id = new TextBox();
         TextBox IdForTeacher = new TextBox();

		 Label label = new Label("you should full it ").setForegroundColor(TextColor.ANSI.RED);

 		 Repository rep = new Repository();
 		 TableAction tables = new TableAction();
 		 
		Panel center = new Panel();
		mainPanel.addComponent(center.withBorder(Borders.singleLine("Panel")));
		
	     checkBoxList = new CheckBoxList<String>();
		for(int i = 0 ; i < Select.selcetStudentIdArray().size(); i++ ){
			Integer ii = Select.selcetStudentIdArray().get(i);
			checkBoxList.addItem(ii.toString());
		}

		
	    checkB2oxList = new CheckBoxList<String>();
		for(int i = 0 ; i < Select.selcetCourseIdArray().size(); i++ ){
			String hi =  Select.selcetCourseIdArray().get(i).toString();
			checkB2oxList.addItem(hi);
		}

	   checkB3oxList = new CheckBoxList<String>();
		for(int i = 0 ; i < Select.selcetTeacherIdArray().size(); i++ ){
			String hi =  Select.selcetTeacherIdArray().get(i).toString();
			checkB3oxList.addItem(hi);
		}
		
		panel.addComponent(new Button("Create Tables" , new Runnable(){
			@Override
			public void run() {
	        	new MessageDialogBuilder()
	    		.setTitle("It Was Succsus").setText("we created tables").build().showDialog(text);
	    		Repository.CreateDatabase();
	    		try {
					TableAction.createCourceTable();
		    		TableAction.createTeacherTable();
		    		TableAction.createStudentTable();
		    		TableAction.createWiringTable();
				} catch (SQLException e) {
					e.printStackTrace();
				}	        	
			}
		}));
		
		

		
 		panel.addComponent( new Button("Update" , new Runnable(){
 			@Override
			public void run() {
				if(center.containsComponent(TeacherTable) || center.containsComponent(CourseTable) || center.containsComponent(StudentTabel) || center.containsComponent(StudentName) || center.containsComponent(CourseName) || center.containsComponent(teacherAge) || center.containsComponent(IdNumber) || center.containsComponent(IdForTeacher) || center.containsComponent(checkBoxList) || center.containsComponent(WiringList)){
					center.removeAllComponents();	
				}
				if(!center.containsComponent(tableName)){ 
		        new Label("tableName :").addTo(center);
		        tableName.addTo(center);
		        center.setLayoutManager(new GridLayout(1));
		        new Label("Column :").addTo(center);
		        column.addTo(center);
		        new Label("IdNumber :").addTo(center);
		        Id.addTo(center);
				
		        center.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
		        center.addComponent(new Button("Delet It" , new Runnable(){
					@SuppressWarnings("static-access")
					@Override
					public void run() {
				        if(!tableName.getText().equals("") &&  !Id.getText().equals("") &&  !column.getText().equals("")) {
				        	new MessageDialogBuilder()
				    		.setTitle("It Was Succsus").setText("the row deleted").build().showDialog(text);
				        	int y = Integer.parseInt(IdNumber.getText());				        	
				        	try {				        
								 TableAction.update(ListName.getText().toString() , Column.getText().toString() , y); 
								 tableName.setText("");
								 column.setText("");
								 Id.setText("");
								 tableName.takeFocus();
				        	} catch (SQLException e) {
								e.printStackTrace();
							} 
				        } else {
				        	if(!center.containsComponent(label)){
				        		label.addTo(center);
				        	}
				        	 
				        }
				      }
		        }));
			 }			
 			}
 		}));


		
 		panel.addComponent( new Button("Delet" , new Runnable(){
 			@Override
			public void run() {
				if(center.containsComponent(TeacherTable) || center.containsComponent(CourseTable) || center.containsComponent(StudentTabel) || center.containsComponent(StudentName) || center.containsComponent(CourseName) || center.containsComponent(teacherAge) || center.containsComponent(tableName) || center.containsComponent(checkBoxList) || center.containsComponent(WiringList)){
					center.removeAllComponents();	
				}
				if(!center.containsComponent(ListName)){ 
		        new Label("ListName :").addTo(center);
		 		  center.setLayoutManager(new GridLayout(1));
		        ListName.addTo(center);
		        
		        new Label("Column :").addTo(center);
		        Column.addTo(center);

		        
		        new Label("IdNumber :").addTo(center);
		        IdNumber.addTo(center);
				
		        center.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
		        center.addComponent(new Button("Delet It" , new Runnable(){
					@SuppressWarnings("static-access")
					@Override
					public void run() {
				        if(!ListName.getText().equals("") &&  !IdNumber.getText().equals("") &&  !Column.getText().equals("")) {
				        	new MessageDialogBuilder()
				    		.setTitle("It Was Succsus").setText("the row deleted").build().showDialog(text);
				        	Integer y = Integer.parseInt(IdNumber.getText());	
				        	try {				        
								 TableAction.deletFromList(ListName.getText().toString() , Column.getText().toString() , y); 
								 if(Select.selcetTeacherIdArrayWiring().contains(y) && ListName.getText().toLowerCase().equals("teacher")){
									 TableAction.deletFromWiringTeacher(y);
								 }
								 if(Select.selcetStudentIdArray().contains(y) && ListName.getText().toLowerCase().equals("student")){
									 TableAction.deletFromWiringStudent(y);
								 }
								 if(Select.selcetCourseIdArray().contains(y) && ListName.getText().toLowerCase().equals("teacher")){
									 TableAction.deletFromWiringCourse(y);
								 }
								 ListName.setText("");
								 Column.setText("");
								 IdNumber.setText("");
								 ListName.takeFocus();
								 if(center.containsComponent(label)){
									 center.removeComponent(label);
								 }
				        	} catch (SQLException e) {
								e.printStackTrace();
							} 
				        } else {
				        	if(!center.containsComponent(label)){
				        		label.addTo(center);
				        	}
				        }
				      }
		        }));
			 }			
 			}
 		}));

		
		panel.addComponent(new Button("AddCourse" , new Runnable(){
			@Override
			public void run() {
				if(center.containsComponent(TeacherTable) || center.containsComponent(CourseTable) || center.containsComponent(StudentTabel) || center.containsComponent(StudentName) || center.containsComponent(CourseName) || center.containsComponent(ListName) || center.containsComponent(teacherAge) || center.containsComponent(column) || center.containsComponent(checkBoxList) || center.containsComponent(WiringList)){
					center.removeAllComponents();	
				}
				if(!center.containsComponent(CourseName)){ 
		        new Label("CourseName :").addTo(center);
		        CourseName.addTo(center);
		 		  center.setLayoutManager(new GridLayout(1));

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
								 CourseTeacher.setText("");
							     checkBoxList = new CheckBoxList<String>();
									for(int i = 0 ; i < Select.selcetStudentIdArray().size(); i++ ){
										Integer ii = Select.selcetStudentIdArray().get(i);
										checkBoxList.addItem(ii.toString());
									}

									
								    checkB2oxList = new CheckBoxList<String>();
									for(int i = 0 ; i < Select.selcetCourseIdArray().size(); i++ ){
										String hi =  Select.selcetCourseIdArray().get(i).toString();
										checkB2oxList.addItem(hi);
									}

								   checkB3oxList = new CheckBoxList<String>();
									for(int i = 0 ; i < Select.selcetTeacherIdArray().size(); i++ ){
										String hi =  Select.selcetTeacherIdArray().get(i).toString();
										checkB3oxList.addItem(hi);
									}

								 
								 if(center.containsComponent(label)){
									 center.removeComponent(label);
								 }
				        	} catch (SQLException e) {
								e.printStackTrace();
							} 
				        } else {
				        	if(!center.containsComponent(label)){
				        		label.addTo(center);
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
				if(center.containsComponent(TeacherTable) || center.containsComponent(CourseTable) || center.containsComponent(StudentTabel) || center.containsComponent(StudentName) || center.containsComponent(CourseName) || center.containsComponent(ListName) || center.containsComponent(column) || center.containsComponent(checkBoxList) || center.containsComponent(WiringList)){
					center.removeAllComponents();	
				}
				if(!center.containsComponent(TeacherName)){ 
		        new Label("TeacherName :").addTo(center);
		        TeacherName.addTo(center);
		 		  center.setLayoutManager(new GridLayout(1));

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
								 teacherAge.setText("");
								 TeacherCourse.setText("");
								 TeacherName.setText("");
								 TeacherName.takeFocus();
								 if(center.containsComponent(label)){
									 center.removeComponent(label);
								 }
								 
							     checkBoxList = new CheckBoxList<String>();
									for(int i = 0 ; i < Select.selcetStudentIdArray().size(); i++ ){
										Integer ii = Select.selcetStudentIdArray().get(i);
										checkBoxList.addItem(ii.toString());
									}

									
								    checkB2oxList = new CheckBoxList<String>();
									for(int i = 0 ; i < Select.selcetCourseIdArray().size(); i++ ){
										String hi =  Select.selcetCourseIdArray().get(i).toString();
										checkB2oxList.addItem(hi);
									}

								   checkB3oxList = new CheckBoxList<String>();
									for(int i = 0 ; i < Select.selcetTeacherIdArray().size(); i++ ){
										String hi =  Select.selcetTeacherIdArray().get(i).toString();
										checkB3oxList.addItem(hi);
									}

								 
				        	} catch (SQLException e) {
								e.printStackTrace();
							} 
				        } else {
				        	if(!center.containsComponent(label)){
				        		label.addTo(center);
				        	}
				        	}
				        }
				      }
		        ));
			 }
			}
		}));

	   	
		panel.addComponent(new Button("AddStudent" , new Runnable(){
			@Override
			public void run() {
				if(center.containsComponent(TeacherTable) || center.containsComponent(CourseTable) || center.containsComponent(StudentTabel) || center.containsComponent(TeacherName) || center.containsComponent(CourseName) || center.containsComponent(ListName) || center.containsComponent(checkBoxList) || center.containsComponent(WiringList)){
					center.removeAllComponents();	
				}
				if(!center.containsComponent(StudentName)){ 
		        new Label("StudentName :").addTo(center);
		        StudentName.addTo(center);
		 		  center.setLayoutManager(new GridLayout(1));

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
								 StudentAge.setText("");
								 StudentCourse.setText("");
								 StudentName.setText("");
								 StudentName.takeFocus();
								 if(center.containsComponent(label)){
									 center.removeComponent(label);
								 }
								 
							     checkBoxList = new CheckBoxList<String>();
									for(int i = 0 ; i < Select.selcetStudentIdArray().size(); i++ ){
										Integer ii = Select.selcetStudentIdArray().get(i);
										checkBoxList.addItem(ii.toString());
									}

									
								    checkB2oxList = new CheckBoxList<String>();
									for(int i = 0 ; i < Select.selcetCourseIdArray().size(); i++ ){
										String hi =  Select.selcetCourseIdArray().get(i).toString();
										checkB2oxList.addItem(hi);
									}

								   checkB3oxList = new CheckBoxList<String>();
									for(int i = 0 ; i < Select.selcetTeacherIdArray().size(); i++ ){
										String hi =  Select.selcetTeacherIdArray().get(i).toString();
										checkB3oxList.addItem(hi);
									}

				        	} catch (SQLException e) {
								e.printStackTrace();
							} 
				        } else {
				        	if(!center.containsComponent(label)){
				        		label.addTo(center);
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
				if(center.containsComponent(TeacherTable) || center.containsComponent(CourseTable) || center.containsComponent(teacherAge) || center.containsComponent(StudentName) || center.containsComponent(CourseName) || center.containsComponent(ListName) || center.containsComponent(column) || center.containsComponent(checkBoxList) || center.containsComponent(WiringList) || center.containsComponent(WiringListInnerJoin)){
					center.removeAllComponents();
					if(!center.containsComponent(StudentTabel)){
					
					   	 List<String> StudentId = Select.selcetStudentId();
						 	
					   	 List<String> namesOfStudent = Select.selcetStudentName();
					   	
					   	 List<String>  StudentAges = Select.selcetStudentAge();	

				 		  center.setLayoutManager(new GridLayout(1));

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
				 		  center.setLayoutManager(new GridLayout(1));

						 
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
				if(center.containsComponent(StudentTabel) || center.containsComponent(CourseTable) || center.containsComponent(teacherAge) || center.containsComponent(StudentName) || center.containsComponent(CourseName) || center.containsComponent(ListName) || center.containsComponent(checkBoxList) || center.containsComponent(WiringList) || center.containsComponent(WiringListInnerJoin)){
					center.removeAllComponents();
				if(!center.containsComponent(TeacherTable)){
					
					 List<String>  TeacherId = Select.selcetTeacherId();
			 		  center.setLayoutManager(new GridLayout(1));

				   	 List<String> namesOfTeacher = Select.selcetteacherName();
				   	
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
						   	
					   	 List<String> namesOfTeacher = Select.selcetteacherName();
					   	
					     List<String> TeacherAge = Select.selcetTeacherAge();		
				 		  center.setLayoutManager(new GridLayout(1));

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
				if(center.containsComponent(StudentTabel) || center.containsComponent(TeacherTable) || center.containsComponent(teacherAge) || center.containsComponent(StudentName) || center.containsComponent(CourseName) || center.containsComponent(ListName) || center.containsComponent(checkBoxList) || center.containsComponent(WiringList) || center.containsComponent(WiringListInnerJoin)){
					center.removeAllComponents();
				if(!center.containsComponent(CourseTable)){
					 List<String> CourseId = Select.selcetCourseId();
					   	
					 List<String> namesOfCourse = Select.selcetCourseName();
			 		  center.setLayoutManager(new GridLayout(1));

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
			 		  center.setLayoutManager(new GridLayout(1));

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

 		
 		

				
		panel.addComponent( new Button("addStudentToTeacher" , new Runnable(){
			@Override
			public void run() {
				if(center.containsComponent(TeacherTable) || center.containsComponent(CourseTable) || center.containsComponent(StudentTabel) || center.containsComponent(StudentName) || center.containsComponent(CourseName) || center.containsComponent(teacherAge) || center.containsComponent(tableName) || center.containsComponent(ListName) || center.containsComponent(WiringList) || center.containsComponent(CourseTable) || center.containsComponent(WiringListInnerJoin)){
					center.removeAllComponents();	
				}
				if(!center.containsComponent(checkBoxList)){ 
				center.addComponent(new Label("TeacherIds"));
		        center.addComponent(checkB3oxList);
		        center.setLayoutManager(new GridLayout(2));
				EmptySpace emp ;
				center.addComponent( emp = new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
				center.addComponent( hi = new Button("choose it" , new Runnable(){
					@Override
					public void run() {
				      if(3 == checkB3oxList.getCheckedItems().toString().length()) {
				        	int teacherId = Integer.parseInt(checkB3oxList.getSelectedItem().toString());
				        	center.removeAllComponents();
							center.addComponent(new Label("CourseIds"));
				        	center.addComponent(checkB2oxList);
				        	center.addComponent(emp);
				        	center.addComponent(bye = new Button("Choose it" , new Runnable(){
								@Override
								public void run() {
						        	if(3 == checkB2oxList.getCheckedItems().toString().length()){
							        	int CourseId = Integer.parseInt(checkB2oxList.getSelectedItem().toString());
							        	center.removeAllComponents();
										center.addComponent(new Label("StudentId"));
							        	center.addComponent(checkBoxList);
							        	center.addComponent(emp);
							        	center.addComponent(one = new Button("Submit" , new Runnable(){
											@Override
											public void run() {
									        	if(checkBoxList.getCheckedItems().toString().length() != 2){
												try {
													List<Integer> checkedItems = Integer.parseInt(checkBoxList.getCheckedItems());										
													for(int StudentId : checkedItems.toString())
												{	
													action.wiringInsert(StudentId, teacherId, CourseId);
												}
									        	new MessageDialogBuilder()
									    		.setTitle("It Was Succsus").setText("we details submited").build().showDialog(text);
												} catch (SQLException e) {
													e.printStackTrace();
												}
									         }
											}
							        	}));
							        	one.takeFocus();		        	
						        	}
								}
				        	}));
				        	bye.takeFocus();	
				        	
								if(center.containsComponent(label)){
								 center.removeComponent(label);
							 }
							}
				        else {
				        	if(!center.containsComponent(label)){
				        		label.addTo(center);
				        	}
				        }
				      }
		        }));
			 }			
			}
		}));

		
		panel.addComponent( new Button("WringList" , new Runnable(){
			@Override
			public void run() {
				if(center.containsComponent(StudentTabel) || center.containsComponent(TeacherTable) || center.containsComponent(teacherAge) || center.containsComponent(StudentName) || center.containsComponent(CourseName) || center.containsComponent(ListName) || center.containsComponent(checkBoxList) || center.containsComponent(WiringListInnerJoin)){
					center.removeAllComponents();
				if(!center.containsComponent(WiringList)){
			 		  center.setLayoutManager(new GridLayout(1));
			 		  
					List<String> teacheriD  =  Select.selcetTeacherIdWiring();
					   	
					List<String> StudentiD  =    Select.selcetStudentIdWiring();

					List<String> CourseiD  = Select.selcetCourseIdWiring();		
					
					List<String> WiringId  =  Select.selcetWiringId();
				   	 
					 WiringList = new Table<String>("WiringId" , "CourseId" , "StudentId" , "TeacherId"); 
					 WiringList.getTableModel().addRow( WiringId.toString().replace("[", " ").replace("]", "").replace(",", ""),CourseiD.toString().replace("[", " ").replace("]", "").replace(",", ""),  StudentiD.toString().replace("[", " ").replace("]", "").replace(",", "") , teacheriD.toString().replace("[", " ").replace("]", "").replace(",", ""));
						WiringList.setSelectAction(new Runnable(){
									@Override
								public void run() {
									List<String> data = WiringList.getTableModel().getRow(WiringList.getSelectedRow());
									for(int i = 0; i < data.size(); i++) {
									    System.out.println(data.get(i));
									}
								}
							});

				
						WiringList.addTo(center);
				}
			 }else {		
				 if(!center.containsComponent(WiringList)){
			 		  center.setLayoutManager(new GridLayout(1));
			 		  
					List<String> teacheriD  =  Select.selcetTeacherIdWiring();
					   	
					List<String> StudentiD  =    Select.selcetStudentIdWiring();

					List<String> CourseiD  = Select.selcetCourseIdWiring();		
					
					List<String> WiringId  =  Select.selcetWiringId();
				   	 
					 WiringList = new Table<String>("WiringId" , "CourseId" , "StudentId" , "TeacherId"); 
					 WiringList.getTableModel().addRow( WiringId.toString().replace("[", " ").replace("]", "").replace(",", ""),CourseiD.toString().replace("[", " ").replace("]", "").replace(",", ""),  StudentiD.toString().replace("[", " ").replace("]", "").replace(",", "") , teacheriD.toString().replace("[", " ").replace("]", "").replace(",", ""));
						WiringList.setSelectAction(new Runnable(){
									@Override
								public void run() {
									List<String> data = WiringList.getTableModel().getRow(WiringList.getSelectedRow());
									for(int i = 0; i < data.size(); i++) {
									    System.out.println(data.get(i));
									}
								}
							});

				
						WiringList.addTo(center);
			     } 
			   }
			}
		}));

		panel.addComponent( new Button("WringInnerList" , new Runnable(){
			@Override
			public void run() {
				if(center.containsComponent(StudentTabel) || center.containsComponent(TeacherTable) || center.containsComponent(teacherAge) || center.containsComponent(StudentName) || center.containsComponent(CourseName) || center.containsComponent(ListName) || center.containsComponent(checkBoxList) || center.containsComponent(WiringList)){
					center.removeAllComponents();
				if(!center.containsComponent(WiringListInnerJoin)){
			 		  center.setLayoutManager(new GridLayout(1));
			 		  
						List<String> WiringId  =  Select.selcetWiringId();
					   	
						List<String> teacheriDInner  =  Select.selcetWiringTeacherInnerJoin();
					   	
						List<String> StudentiDInner  =  Select.selcetWiringStudentInnerJoin();

						List<String> CourseiDInner  =   Select.selcetWiringCourseInnerJoin();		
				   	 
						WiringListInnerJoin = new Table<String>("WiringId" , "CourseName" , "StudentName" , "teacherName"); 
						WiringListInnerJoin.getTableModel().addRow( WiringId.toString().replace("[", " ").replace("]", "").replace(",", ""),CourseiDInner.toString().replace("[", " ").replace("]", "").replace(",", ""),  StudentiDInner.toString().replace("[", " ").replace("]", "").replace(",", "") , teacheriDInner.toString().replace("[", " ").replace("]", "").replace(",", ""));
						WiringListInnerJoin.setSelectAction(new Runnable(){
										@Override
									public void run() {
										List<String> data = WiringListInnerJoin.getTableModel().getRow(WiringListInnerJoin.getSelectedRow());
										for(int i = 0; i < data.size(); i++) {
										    System.out.println(data.get(i));
										}
									}
								});
				
						WiringListInnerJoin.addTo(center);
				}
			 }else {		
				 if(!center.containsComponent(WiringListInnerJoin)){
						List<String> WiringId  =  Select.selcetWiringId();
					   	
						List<String> teacheriDInner  =  Select.selcetWiringTeacherInnerJoin();
					   	
						List<String> StudentiDInner  =  Select.selcetWiringStudentInnerJoin();

						List<String> CourseiDInner  =   Select.selcetWiringCourseInnerJoin();		
				 		  center.setLayoutManager(new GridLayout(1));

						WiringListInnerJoin = new Table<String>("WiringId" , "CourseName" , "StudentName" , "teacherName"); 
						WiringListInnerJoin.getTableModel().addRow( WiringId.toString().replace("[", " ").replace("]", "").replace(",", ""),CourseiDInner.toString().replace("[", " ").replace("]", "").replace(",", ""),  StudentiDInner.toString().replace("[", " ").replace("]", "").replace(",", "") , teacheriDInner.toString().replace("[", " ").replace("]", "").replace(",", ""));
						WiringListInnerJoin.setSelectAction(new Runnable(){
										@Override
									public void run() {
										List<String> data = WiringListInnerJoin.getTableModel().getRow(WiringListInnerJoin.getSelectedRow());
										for(int i = 0; i < data.size(); i++) {
										    System.out.println(data.get(i));
										}
									}
								});
				
						WiringListInnerJoin.addTo(center);

			     } 
			   }
			}
		}));


		window.setHints(Arrays.asList(Window.Hint.CENTERED , Window.Hint.FIT_TERMINAL_WINDOW));
		window.setComponent(mainPanel);
		
		MultiWindowTextGUI win = new MultiWindowTextGUI(screen , new DefaultWindowManager() , new EmptySpace(TextColor.ANSI.BLUE));
		win.addWindowAndWait(window);


	}
}     

