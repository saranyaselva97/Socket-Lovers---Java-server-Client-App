
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ClientView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JFrame frame;
    private JTextField clientTypingBoard;
    private JList clientActiveUsersList;
    private JTextArea clientMessageBoard;
    private JButton clientKillProcessBtn;
    private JRadioButton oneToNRadioBtn;
    private JRadioButton broadcastBtn;

    DataInputStream inputStream;
    DataOutputStream outStream;
    DefaultListModel<String> dm;
    String id, clientIds = "";

    public ClientView() {
        initialize();
    }

    public ClientView(String id, Socket s) { // constructor call, it will initialize required variables
        initialize(); // initilize UI components
        this.id = id;
        try {
            frame.setTitle("Client View - " + id); // set title of UI
            dm = new DefaultListModel<String>(); // default list used for showing active users on UI
            clientActiveUsersList.setModel(dm);// show that list on UI component JList named clientActiveUsersList
            inputStream = new DataInputStream(s.getInputStream()); // initilize input and output stream
            outStream = new DataOutputStream(s.getOutputStream());
            new Read().start(); // create a new thread for reading the messages
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    class Read extends Thread {

        @Override
        public void run() {
            while (true) {
                try {

                    /**
                     * ********************************************************************************
                     */
                    String m = inputStream.readUTF();  // read message from server, this will contain :;.,/=<comma seperated clientsIds>
            
                
                   
                    System.out.println("inside read thread : " + m); // print message for testing purpose
                    if (m.contains(":;.,/=")) { // prefix(i know its random)
                        m = m.substring(6); // comma separated all active user ids
                        dm.clear(); // clear the list before inserting fresh elements
                        StringTokenizer st = new StringTokenizer(m, ","); // split all the clientIds and add to dm below
                        while (st.hasMoreTokens()) {
                            String u = st.nextToken();
                            if (!id.equals(u)) // we do not need to show own user id in the active user list pane
                            {
                                dm.addElement(u); // add all the active user ids to the defaultList to display on active
                            }													// user pane on client view
                        }
                    } else {
                         String Newstr = "";
                    for (int i = 0; i < m.length(); i++) {
                        char ch = Character.toLowerCase(m.charAt(i));
                        switch (ch) {
                            case 'b':
                                Newstr = Newstr + "a";
                                break;
                            case 'c':
                                Newstr = Newstr + "b";
                                break;
                            case 'd':
                                Newstr = Newstr + "c";
                                break;
                            case 'e':
                                Newstr = Newstr + "d";
                                break;
                            case 'f':
                                Newstr = Newstr + "e";
                                break;
                            case 'g':
                                Newstr = Newstr + "f";
                                break;
                            case 'h':
                                Newstr = Newstr + "g";
                                break;
                            case 'i':
                                Newstr = Newstr + "h";
                                break;
                            case 'j':
                                Newstr = Newstr + "i";
                                break;
                            case 'k':
                                Newstr = Newstr + "j";
                                break;
                            case 'l':
                                Newstr = Newstr + "k";
                                break;
                            case 'm':
                                Newstr = Newstr + "l";
                                break;
                            case 'n':
                                Newstr = Newstr + "m";
                                break;
                            case 'o':
                                Newstr = Newstr + "n";
                                break;
                            case 'p':
                                Newstr = Newstr + "o";
                                break;
                            case 'q':
                                Newstr = Newstr + "p";
                                break;
                            case 'r':
                                Newstr = Newstr + "q";
                                break;
                            case 's':
                                Newstr = Newstr + "r";
                                break;
                            case 't':
                                Newstr = Newstr + "s";
                                break;
                            case 'u':
                                Newstr = Newstr + "t";
                                break;
                            case 'v':
                                Newstr = Newstr + "u";
                                break;
                            case 'w':
                                Newstr = Newstr + "v";
                                break;
                            case 'x':
                                Newstr = Newstr + "w";
                                break;
                            case 'y':
                                Newstr = Newstr + "x";
                                break;
                            case 'z':
                                Newstr = Newstr + "y";
                                break;
                            case '1':
                                Newstr = Newstr + "z";
                                break;
                            case ' ':
                                Newstr = Newstr + " ";
                                break;
                            case '2':
                                Newstr = Newstr + '.';
                                break;
                            case '3':
                                Newstr = Newstr + ",";
                                break;
                            case '4':
                                Newstr = Newstr + '(';
                                break;
                            case '5':
                                Newstr = Newstr + '\"';
                                break;
                            case '6':
                                Newstr = Newstr + ")";
                                break;
                            case '7':
                                Newstr = Newstr + "?";
                                break;
                            case '8':
                                Newstr = Newstr + "!";
                                break;
                            case '9':
                                Newstr = Newstr + "-";
                                break;
                            case '(':
                                Newstr = Newstr + "%";
                                break;
                            case ')':
                                Newstr = Newstr + "1";
                                break;
                            case '!':
                                Newstr = Newstr + "2";
                                break;
                            case '@':
                                Newstr = Newstr + "3";
                                break;
                            case '#':
                                Newstr = Newstr + "4";
                                break;
                            case '$':
                                Newstr = Newstr + "5";
                                break;
                            case '^':
                                Newstr = Newstr + "6";
                                break;
                            case '&':
                                Newstr = Newstr + "7";
                                break;
                            case '*':
                                Newstr = Newstr + "8";
                                break;
                            case '{':
                                Newstr = Newstr + "9";
                                break;
                            case '}':
                                Newstr = Newstr + "0";
                                break;
                            default:
                                Newstr = Newstr + " : ";
                                break;

                        }

                    }
                        clientMessageBoard.append("" + Newstr + "\n"); //otherwise print on the clients message board
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() { // initialize all the components of UI
        frame = new JFrame();
        frame.setBounds(100, 100, 926, 705);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setTitle("Client View");

        clientMessageBoard = new JTextArea();
        clientMessageBoard.setEditable(false);
        clientMessageBoard.setBounds(12, 25, 530, 495);
        frame.getContentPane().add(clientMessageBoard);

        clientTypingBoard = new JTextField();
        clientTypingBoard.setHorizontalAlignment(SwingConstants.LEFT);
        clientTypingBoard.setBounds(12, 533, 530, 84);
        frame.getContentPane().add(clientTypingBoard);
        clientTypingBoard.setColumns(10);

        JButton clientSendMsgBtn = new JButton("Send");
        clientSendMsgBtn.addActionListener(new ActionListener() { // action to be taken on send message button
            public void actionPerformed(ActionEvent e) {
                String Newstr = "";
                String textAreaMessage = clientTypingBoard.getText(); // get the message from textbox

                /**
                 * ********************************************************************************
                 */
                for (int i = 0; i < textAreaMessage.length(); i++) {
                    char ch = Character.toLowerCase(textAreaMessage.charAt(i));
                    switch (ch) {
                        case 'a':
                            Newstr = Newstr + "b";
                            break;
                        case 'b':
                            Newstr = Newstr + "c";
                            break;
                        case 'c':
                            Newstr = Newstr + "d";
                            break;
                        case 'd':
                            Newstr = Newstr + "e";
                            break;
                        case 'e':
                            Newstr = Newstr + "f";
                            break;
                        case 'f':
                            Newstr = Newstr + "g";
                            break;
                        case 'g':
                            Newstr = Newstr + "h";
                            break;
                        case 'h':
                            Newstr = Newstr + "i";
                            break;
                        case 'i':
                            Newstr = Newstr + "j";
                            break;
                        case 'j':
                            Newstr = Newstr + "k";
                            break;
                        case 'k':
                            Newstr = Newstr + "l";
                            break;
                        case 'l':
                            Newstr = Newstr + "m";
                            break;
                        case 'm':
                            Newstr = Newstr + "n";
                            break;
                        case 'n':
                            Newstr = Newstr + "o";
                            break;
                        case 'o':
                            Newstr = Newstr + "p";
                            break;
                        case 'p':
                            Newstr = Newstr + "q";
                            break;
                        case 'q':
                            Newstr = Newstr + "r";
                            break;
                        case 'r':
                            Newstr = Newstr + "s";
                            break;
                        case 's':
                            Newstr = Newstr + "t";
                            break;
                        case 't':
                            Newstr = Newstr + "u";
                            break;
                        case 'u':
                            Newstr = Newstr + "v";
                            break;
                        case 'v':
                            Newstr = Newstr + "w";
                            break;
                        case 'w':
                            Newstr = Newstr + "x";
                            break;
                        case 'x':
                            Newstr = Newstr + "y";
                            break;
                        case 'y':
                            Newstr = Newstr + "z";
                            break;
                        case 'z':
                            Newstr = Newstr + "1";
                            break;
                        case ' ':
                            Newstr = Newstr + " ";
                            break;
                        case '.':
                            Newstr = Newstr + '2';
                            break;
                        case ',':
                            Newstr = Newstr + "3";
                            break;
                        case '(':
                            Newstr = Newstr + '4';
                            break;
                        case '\"':
                            Newstr = Newstr + '5';
                            break;
                        case ')':
                            Newstr = Newstr + "6";
                            break;
                        case '?':
                            Newstr = Newstr + "7";
                            break;
                        case '!':
                            Newstr = Newstr + "8";
                            break;
                        case '-':
                            Newstr = Newstr + "9";
                            break;
                        case '%':
                            Newstr = Newstr + "(";
                            break;
                        case '1':
                            Newstr = Newstr + ")";
                            break;
                        case '2':
                            Newstr = Newstr + "!";
                            break;
                        case '3':
                            Newstr = Newstr + "@";
                            break;
                        case '4':
                            Newstr = Newstr + "#";
                            break;
                        case '5':
                            Newstr = Newstr + "$";
                            break;
                        case '6':
                            Newstr = Newstr + "^";
                            break;
                        case '7':
                            Newstr = Newstr + "&";
                            break;
                        case '8':
                            Newstr = Newstr + "*";
                            break;
                        case '9':
                            Newstr = Newstr + "{";
                            break;
                        case '0':
                            Newstr = Newstr + "}";
                            break;
                            case ':':
                            Newstr = Newstr + ":";
                            break;
                        default:
                            Newstr = Newstr + " : ";
                            break;
                    }

                }

                if (Newstr != null && !Newstr.isEmpty()) {  // only if message is not empty then send it further otherwise do nothing
                    try {
                        String messageToBeSentToServer = "";
                        String cast = "broadcast"; // this will be an identifier to identify type of message
                        int flag = 0; // flag used to check whether used has selected any client or not for multicast 
                        if (oneToNRadioBtn.isSelected()) { // if 1-to-N is selected then do this
                            cast = "multicast";
                            List<String> clientList = clientActiveUsersList.getSelectedValuesList(); // get all the users selected on UI
                            if (clientList.size() == 0) // if no user is selected then set the flag for further use
                            {
                                flag = 1;
                            }
                            for (String selectedUsr : clientList) { // append all the usernames selected in a variable
                                if (clientIds.isEmpty()) {
                                    clientIds += selectedUsr;
                                } else {
                                    clientIds += "," + selectedUsr;
                                }
                            }
                            messageToBeSentToServer = cast + ":" + clientIds + ":" + Newstr; // prepare message to be sent to server
                        } else {
                            messageToBeSentToServer = cast + ":" + Newstr; // in case of broadcast we don't need to know userIds
                        }
                        if (cast.equalsIgnoreCase("multicast")) {
                            if (flag == 1) { // for multicast check if no user was selected then prompt a message dialog
                                JOptionPane.showMessageDialog(frame, "No user selected");
                            } else { // otherwise just send the message to the user
                                outStream.writeUTF(messageToBeSentToServer);
                                clientTypingBoard.setText("");
                                clientMessageBoard.append("< You sent msg to " + clientIds + ">" + textAreaMessage + "\n"); //show the sent message to the sender's message board
                            }
                        } else { // in case of broadcast
                            outStream.writeUTF(messageToBeSentToServer);
                            clientTypingBoard.setText("");
                            clientMessageBoard.append("< You sent msg to All >" + textAreaMessage + "\n");
                        }
                        clientIds = ""; // clear the all the client ids 
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "User does not exist anymore."); // if user doesn't exist then show message
                    }
                }
            }
        });
        clientSendMsgBtn.setBounds(554, 533, 137, 84);
        frame.getContentPane().add(clientSendMsgBtn);

        clientActiveUsersList = new JList();
        clientActiveUsersList.setToolTipText("Active Users");
        clientActiveUsersList.setBounds(554, 63, 327, 457);
        frame.getContentPane().add(clientActiveUsersList);

        clientKillProcessBtn = new JButton("End Chat");
        clientKillProcessBtn.addActionListener(new ActionListener() { // kill process event
            public void actionPerformed(ActionEvent e) {
                try {
                    outStream.writeUTF("exit"); // closes the thread and show the message on server and client's message
                    // board
                    clientMessageBoard.append("You are disconnected now.\n");
                    frame.dispose(); // close the frame 
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        clientKillProcessBtn.setBounds(703, 533, 193, 84);
        frame.getContentPane().add(clientKillProcessBtn);

        JLabel lblNewLabel = new JLabel("Active Users");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setBounds(559, 43, 95, 16);
        frame.getContentPane().add(lblNewLabel);

        oneToNRadioBtn = new JRadioButton("Users");
        oneToNRadioBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clientActiveUsersList.setEnabled(true);
            }
        });
        oneToNRadioBtn.setSelected(true);
        oneToNRadioBtn.setBounds(682, 24, 72, 25);
        frame.getContentPane().add(oneToNRadioBtn);

        ButtonGroup btngrp = new ButtonGroup();
        btngrp.add(oneToNRadioBtn);

        frame.setVisible(true);
    }
}
