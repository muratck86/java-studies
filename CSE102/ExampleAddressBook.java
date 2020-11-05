package CSE102;



import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ExampleAddressBook extends JFrame {
    //size of string fields in one record
    final static int NAME_SIZE = 32;
    final static int ADDRESS_SIZE = 50;
    final static int SEMT_SIZE = 20;
    final static int CITY_SIZE = 20;
    final static int POST_CODE = 5;
    final static int RECORD_SIZE = (NAME_SIZE+ ADDRESS_SIZE+ SEMT_SIZE+ CITY_SIZE+ POST_CODE);

    //Access "addresses.dat" using RandomAccessFile
    private RandomAccessFile raf;

    //Text Fields
    private JTextField jtfName = new JTextField(NAME_SIZE);
    private JTextField jtfAddress = new JTextField(ADDRESS_SIZE);
    private JTextField jtfSemt = new JTextField(SEMT_SIZE);
    private JTextField jtfCity = new JTextField(CITY_SIZE);
    private JTextField jtfPost = new JTextField(POST_CODE);

    //Buttons
    private JButton jbtAdd = new JButton("Add");
    private JButton jbtFirst = new JButton("First");
    private JButton jbtNext = new JButton("Next");
    private JButton jbtPrevious = new JButton("Previous");
    private JButton jbtLast = new JButton("Last");

    //Constructor
    public ExampleAddressBook(){
        //Open or create random access file
        try {
            raf = new RandomAccessFile("exampleAddress.dat","rw");
        } catch (IOException ex){
            System.out.println("Error: "+ex);
            System.exit(1);
        }
        //Panel p1 for holding labels Name, Address, Semt
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3,1));
        p1.add(new JLabel("Name: "));
        p1.add(new JLabel("Address: "));
        p1.add(new JLabel("Semt: "));

        //Panel jpCity for holding City
        JPanel jpCity = new JPanel();
        jpCity.setLayout(new BorderLayout());
        jpCity.add(new JLabel("City: "),BorderLayout.WEST);
        jpCity.add(jtfCity,BorderLayout.CENTER);

        //Panel jpPost for holding post code
        JPanel jpPost = new JPanel();
        jpPost.setLayout(new BorderLayout());
        jpPost.add(new JLabel("Post Code: "), BorderLayout.WEST);
        jpPost.add(jtfPost,BorderLayout.CENTER);

        //Panel p2 for holding jpCity and jpPost
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.add(jpCity, BorderLayout.WEST);
        p2.add(jpPost,BorderLayout.CENTER);

        //Panel p3 for holding jtfSemt and p2
        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.add(jtfSemt, BorderLayout.CENTER);
        p3.add(p2, BorderLayout.EAST);

        //Panel p4 for holding jtfName, jtfAddress and p3
        JPanel p4 = new JPanel();
        p4.setLayout(new GridLayout(3,1));
        p4.add(jtfName);
        p4.add(jtfAddress);
        p4.add(p3);

        //Place p1 and p4 into jpAddress
        JPanel jpAddress = new JPanel(new BorderLayout());
        jpAddress.add(p1, BorderLayout.WEST);
        jpAddress.add(p4, BorderLayout.CENTER);

        //Set the panel with line border
        jpAddress.setBorder(new BevelBorder(BevelBorder.RAISED));

        //Add buttons to a panel
        JPanel jpButton = new JPanel();
        jpButton.add(jbtAdd);
        jpButton.add(jbtFirst);
        jpButton.add(jbtPrevious);
        jpButton.add(jbtNext);
        jpButton.add(jbtLast);

        //Add jpAddress and jpButton to the frame
        add(jpAddress,BorderLayout.CENTER);
        add(jpButton,BorderLayout.SOUTH);

        jbtAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeAddress();
            }
        });
        jbtFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(raf.length() >0) readAddress(0);
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        });
        jbtNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    long currentPosition = raf.getFilePointer();
                    if(currentPosition< raf.length())
                        readAddress(currentPosition);
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        });
        jbtPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long currentPosition = raf.getFilePointer();
                    if (currentPosition - 2*RECORD_SIZE > 0)
                        readAddress(currentPosition-2*2*RECORD_SIZE);
                    else readAddress(0);
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        });
        jbtLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long lastPosition = raf.length();
                    if (lastPosition > 0)
                        readAddress(lastPosition -2 * RECORD_SIZE);
                } catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        });
        //Display the first record if exists
        try{
            if(raf.length() > 0) readAddress(0);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    /**Write a record at the end of the file*/
    public void writeAddress(){
        try{
            raf.seek(raf.length());
            FixedLengthStringIO.writeFixedLengthString(jtfName.getText(),NAME_SIZE,raf);
            FixedLengthStringIO.writeFixedLengthString(jtfAddress.getText(),ADDRESS_SIZE,raf);
            FixedLengthStringIO.writeFixedLengthString(jtfSemt.getText(),SEMT_SIZE,raf);
            FixedLengthStringIO.writeFixedLengthString(jtfCity.getText(),CITY_SIZE,raf);
            FixedLengthStringIO.writeFixedLengthString(jtfPost.getText(),POST_CODE,raf);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    /**Read a record at the specified location*/
    public void readAddress(long position) throws IOException{
        raf.seek(position);
        String name = FixedLengthStringIO.readFixedLengthString(NAME_SIZE,raf);
        String address = FixedLengthStringIO.readFixedLengthString(ADDRESS_SIZE,raf);
        String semt = FixedLengthStringIO.readFixedLengthString(SEMT_SIZE,raf);
        String city = FixedLengthStringIO.readFixedLengthString(CITY_SIZE,raf);
        String postCode = FixedLengthStringIO.readFixedLengthString(POST_CODE,raf);
        jtfName.setText(name);
        jtfAddress.setText(address);
        jtfSemt.setText(semt);
        jtfCity.setText(city);
        jtfPost.setText(postCode);
    }

    public static void main(String[] args) {
        ExampleAddressBook frame1 = new ExampleAddressBook();
                frame1.pack();
                frame1.setTitle("My Address Book");
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setVisible(true);

    }
}
class FixedLengthStringIO {
    public static String readFixedLengthString(int size, DataInput in) throws IOException {
        char[] chars = new char[size];

        for (int i = 0; i < size; i++) {
            chars[i] = in.readChar();
        }
        return new String(chars);
    }

    public static void writeFixedLengthString(String s,int size,DataOutput out) throws IOException {
        char[] chars = new char[size];
        s.getChars(0, s.length(), chars, 0);

        for (int i = Math.min(s.length(), size); i < chars.length; i++) {
            chars[i] =' ';
        }
        out.writeChars(new String(chars));
    }
}

class AddressBook extends JFrame {
    // Specify the size of five string fields in the record
    final static int NAME_SIZE = 32;
    final static int STREET_SIZE = 32;
    final static int CITY_SIZE = 20;
    final static int STATE_SIZE = 2;
    final static int ZIP_SIZE = 5;
    final static int RECORD_SIZE =
            (NAME_SIZE + STREET_SIZE + CITY_SIZE + STATE_SIZE + ZIP_SIZE);

    // Access address.dat using RandomAccessFile
    private RandomAccessFile raf;

    // Text fields
    private JTextField jtfName = new JTextField(NAME_SIZE);
    private JTextField jtfStreet = new JTextField(STREET_SIZE);
    private JTextField jtfCity = new JTextField(CITY_SIZE);
    private JTextField jtfState = new JTextField(STATE_SIZE);
    private JTextField jtfZip = new JTextField(ZIP_SIZE);

    // Buttons
    private JButton jbtAdd = new JButton("Add");
    private JButton jbtFirst = new JButton("First");
    private JButton jbtNext = new JButton("Next");
    private JButton jbtPrevious = new JButton("Previous");
    private JButton jbtLast = new JButton("Last");

    public AddressBook() {
        // Open or create a random access file
        try {
            raf = new RandomAccessFile("address.dat", "rw");
        }
        catch(IOException ex) {
            System.out.print("Error: " + ex);
            System.exit(1);
        }

        // Panel p1 for holding labels Name, Street, and City
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 1));
        p1.add(new JLabel("Name"));
        p1.add(new JLabel("Street"));
        p1.add(new JLabel("City"));

        // Panel jpState for holding state
        JPanel jpState = new JPanel();
        jpState.setLayout(new BorderLayout());
        jpState.add(new JLabel("State"), BorderLayout.WEST);
        jpState.add(jtfState, BorderLayout.CENTER);

        // Panel jpZip for holding zip
        JPanel jpZip = new JPanel();
        jpZip.setLayout(new BorderLayout());
        jpZip.add(new JLabel("Zip"), BorderLayout.WEST);
        jpZip.add(jtfZip, BorderLayout.CENTER);

        // Panel p2 for holding jpState and jpZip
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.add(jpState, BorderLayout.WEST);
        p2.add(jpZip, BorderLayout.CENTER);

        // Panel p3 for holding jtfCity and p2
        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.add(jtfCity, BorderLayout.CENTER);
        p3.add(p2, BorderLayout.EAST);

        // Panel p4 for holding jtfName, jtfStreet, and p3
        JPanel p4 = new JPanel();
        p4.setLayout(new GridLayout(3, 1));
        p4.add(jtfName);
        p4.add(jtfStreet);
        p4.add(p3);

        // Place p1 and p4 into jpAddress
        JPanel jpAddress = new JPanel(new BorderLayout());
        jpAddress.add(p1, BorderLayout.WEST);
        jpAddress.add(p4, BorderLayout.CENTER);

        // Set the panel with line border
        jpAddress.setBorder(new BevelBorder(BevelBorder.RAISED));

        // Add buttons to a panel
        JPanel jpButton = new JPanel();
        jpButton.add(jbtAdd);
        jpButton.add(jbtFirst);
        jpButton.add(jbtNext);
        jpButton.add(jbtPrevious);
        jpButton.add(jbtLast);

        // Add jpAddress and jpButton to the frame
        add(jpAddress, BorderLayout.CENTER);
        add(jpButton, BorderLayout.SOUTH);

        jbtAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeAddress();
            }
        });
        jbtFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (raf.length() > 0) readAddress(0);
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jbtNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long currentPosition = raf.getFilePointer();
                    if (currentPosition < raf.length())
                        readAddress(currentPosition);
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jbtPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    long currentPosition = raf.getFilePointer();
                    if (currentPosition - 2 * RECORD_SIZE > 0)
                        // Why 2 * 2 * RECORD_SIZE? See the follow-up remarks
                        readAddress(currentPosition - 2 * 2 * RECORD_SIZE);
                    else
                        readAddress(0);
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jbtLast.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    long lastPosition = raf.length();
                    if (lastPosition > 0)
                        // Why 2 * RECORD_SIZE? See the follow-up remarks
                        readAddress(lastPosition - 2 * RECORD_SIZE);
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Display the first record if exists
        try {
            if (raf.length() > 0) readAddress(0);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /** Write a record at the end of the file */
    public void writeAddress() {
        try {
            raf.seek(raf.length());
            FixedLengthStringIO.writeFixedLengthString(
                    jtfName.getText(), NAME_SIZE, raf);
            FixedLengthStringIO.writeFixedLengthString(
                    jtfStreet.getText(), STREET_SIZE, raf);
            FixedLengthStringIO.writeFixedLengthString(
                    jtfCity.getText(), CITY_SIZE, raf);
            FixedLengthStringIO.writeFixedLengthString(
                    jtfState.getText(), STATE_SIZE, raf);
            FixedLengthStringIO.writeFixedLengthString(
                    jtfZip.getText(), ZIP_SIZE, raf);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /** Read a record at the specified position */
    public void readAddress(long position) throws IOException {
        raf.seek(position);
        String name = FixedLengthStringIO.readFixedLengthString(
                NAME_SIZE, raf);
        String street = FixedLengthStringIO.readFixedLengthString(
                STREET_SIZE, raf);
        String city = FixedLengthStringIO.readFixedLengthString(
                CITY_SIZE, raf);
        String state = FixedLengthStringIO.readFixedLengthString(
                STATE_SIZE, raf);
        String zip = FixedLengthStringIO.readFixedLengthString(
                ZIP_SIZE, raf);

        jtfName.setText(name);
        jtfStreet.setText(street);
        jtfCity.setText(city);
        jtfState.setText(state);
        jtfZip.setText(zip);
    }
}
