import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.*;
import javax.imageio.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

// Java core by Joshua Wilkinson - TEAM_17
// Definitely couldn't do SHA-256 off the top of my head, Reference: https://www.geeksforgeeks.org/sha-256-hash-in-java/
// "If it doesn't put me on a watch list, I've failed."

public class NARROWGUI extends JFrame {
    private JPanel narrowLogin;
    private JTextField username;
    private JPasswordField passphrase;
    private JButton LOGINButton;
    private JLabel AGENCYLOGINLabel;
    private JLabel unauthorizedAccessOrUseLabel;
    private JTabbedPane tabbedPane1;
    private JLabel backgroundlogo;
    private JPanel Home;
    private JPanel Administration;
    private JPanel Agents;
    private JPanel Missions;
    private JLabel hello;
    private JLabel akia;
    private JLabel mDLoc;
    private JLabel terrorist;


    private String userid = null;


    public NARROWGUI() {
        akia.setText("Civilians KIA: " + civiliancasualties());
        //mDLoc.setText(""+mostDangerousLocation());
        terrorist.setText("Terrorist in Custody: "+TiC());





        try {
            final BufferedImage logo = ImageIO.read(getClass().getResource("res/logo.png"));
            setIconImage(logo);
        } catch(Exception e) {
            System.out.println("Epic fail");
        }
        setContentPane(narrowLogin);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("NARROWEYE - CAI");
        try {
            if (n_Login() == true)  {
                System.out.println("Gotcha");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public boolean n_Login() throws Exception{
        setSize(1280,720);
        setVisible(true);
        setResizable(false);
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (narrowLOGIN(username,passphrase)) {
                    // OPEN MAIN GUI
                }
            }
        });
        passphrase.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    if (narrowLOGIN(username,passphrase)) {
                        connect();
                        // OPEN MAIN GUI
                        initialize(username,passphrase,LOGINButton,AGENCYLOGINLabel,unauthorizedAccessOrUseLabel,tabbedPane1);
                        userid = username.getText();
                    }
                }
            }
        });
        return true;
    }

    public static void initialize(JTextField username,JPasswordField passphrase,JButton LOGINButton,JLabel AGENCYLOGINLabel,JLabel unauthorizedAccessOrUseLabel, JTabbedPane maincontainer) {
        username.setVisible(false);
        passphrase.setVisible(false);
        LOGINButton.setVisible(false);
        AGENCYLOGINLabel.setVisible(false);
        unauthorizedAccessOrUseLabel.setVisible(false);
        maincontainer.setVisible(true);
        civiliancasualties();
    }
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
    static boolean narrowLOGIN(JTextField username, JPasswordField passphrase) {
        String j = username.getText();
        String password = passphrase.getText() + "cai-4-lyfe-88579";
        System.out.println(j + password);
        try {
            System.out.println(toHexString(getSHA(password)));
            return true;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
            return false;
        }
    }
    static String civiliancasualties() {
        try {
            String returnedString = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle2.wiu.edu:1521/orclpdb1", "F22_TEAM_17", "kl98oPFo");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SUM(NUMBEROFPEOPLEKILLED) AS TOTALCiviliansKilled FROM TerroristActivities");
            while (rs.next()) {
                returnedString = rs.getString("TOTALCIVILIANSKILLED");
                if (returnedString != null) {
                    break;
                }
            }
            con.close();
            return returnedString;
        } catch (Exception e) {
            return "Error";
        }
    }
    static String mostDangerousLocation() {
        try {
            String dateTime="", loc="", cost="";
            String returnedString = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle2.wiu.edu:1521/orclpdb1", "F22_TEAM_17", "kl98oPFo");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT dateTimes,incidentLocation FROM Causalities ORDER BY " +
                    "AssetDamageInDollars DESC FETCH FIRST 10 ROWS ONLY;");
            while (rs.next()){
                returnedString = rs.getString("DATETIMES");
                if (returnedString != null) {
                    break;
                }
            }
            con.close();
            return returnedString;
        } catch (Exception e) {
            return "Error";
        }
    }
    static String TiC() {
        try {
            String returnedString = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle2.wiu.edu:1521/orclpdb1", "F22_TEAM_17", "kl98oPFo");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NameOfTerrorists,ethnicity,IdentityNumber FROM TerroristsInformation WHERE InCustody = 'Yes';");
            while (rs.next()) {
                returnedString = rs.getString("NameOfTerrorists");
                if (returnedString != null) {
                    break;
                }
            }
            con.close();
            return returnedString;
        } catch (Exception e) {
            return "Error";
        }
    }

    static void connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle2.wiu.edu:1521/orclpdb1", "F22_TEAM_17", "kl98oPFo");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BETAAGENTS");
            while (rs.next())
                System.out.println(rs.getString("PASSWORDS"));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        NARROWGUI x = new NARROWGUI();
    }
}