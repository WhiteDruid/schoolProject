package GUI;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.EmptySpace;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.gui2.dialogs.DialogWindow;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogBuilder;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.gui2.table.Table;

public class ListShower extends DialogWindow {

    private MessageDialogButton result;

    ListShower(
            String title,
            Table<String> table,
            MessageDialogButton... buttons
            ) {

        super(title);
        this.result = null;
        if(buttons == null || buttons.length == 0) {
            buttons = new MessageDialogButton[] { MessageDialogButton.OK };
        }

        Panel buttonPanel = new Panel();
        buttonPanel.setLayoutManager(new GridLayout(buttons.length).setHorizontalSpacing(1));
        for(final MessageDialogButton button: buttons) {
            buttonPanel.addComponent(new Button(button.toString(), new Runnable() {
                @Override
                public void run() {
                    result = button;
                    close();
                }
            }));
        }

        Panel mainPanel = new Panel();
        mainPanel.setLayoutManager(
                new GridLayout(1)
                        .setLeftMarginSize(1)
                        .setRightMarginSize(1));
        Table<String> tab = table;
        tab.addTo(mainPanel);
        mainPanel.addComponent(new EmptySpace(TerminalSize.ONE));
        buttonPanel.setLayoutData(
                GridLayout.createLayoutData(
                        GridLayout.Alignment.END,
                        GridLayout.Alignment.CENTER,
                        false,
                        false))
                .addTo(mainPanel);
        setComponent(mainPanel);
    }

    /**
     * {@inheritDoc}
     * @param textGUI Text GUI to add the dialog to
     * @return The selected button's enum value
     */
    @Override
    public MessageDialogButton showDialog(WindowBasedTextGUI textGUI) {
        result = null;
        super.showDialog(textGUI);
        return result;
    }

    /**
     * Shortcut for quickly displaying a message box
     * @param textGUI The GUI to display the message box on
     * @param title Title of the message box
     * @param tables 
     * @param text Main message of the message box
     * @param buttons Buttons that the user can confirm the message box with
     * @return Which button the user selected
     */
    public static MessageDialogButton showMessageDialog(
            WindowBasedTextGUI textGUI,
            String title,
             MessageDialogButton... buttons) {
        MessageDialogBuilder builder = new MessageDialogBuilder()
                .setTitle(title);
        if(buttons.length == 0) {
            builder.addButton(MessageDialogButton.OK);
        }
        for(MessageDialogButton button: buttons) {
            builder.addButton(button);
        }
        return builder.build().showDialog(textGUI);
    }
}