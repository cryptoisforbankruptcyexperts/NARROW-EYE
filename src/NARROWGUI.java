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
    private JLabel mcpv;
    private JLabel emrPats;
    private JLabel cooep;
    private JLabel mem;
    private JLabel welcome47;
    private JLabel partnera;
    private JLabel partnerb;
    private JLabel EmpID;
    private JLabel Aliase;
    private JLabel supervisor;
    private JLabel salary;
    private JLabel passport;
    private JLabel dLicense;
    private JLabel ethnic;
    private JLabel hite;
    private JLabel weapon;
    private JLabel welcome;


    private String userid = null;
    String weaponID = "";

    public NARROWGUI() {
        /*akia.setText("Civilians KIA: " + civiliancasualties());
        mDLoc.setText(mostDangerousLocation());
        terrorist.setText("Terrorist in Custody: "+TiC());
        emrPats.setText("Emergency Patrols This Year: "+emerPatrols());
        mcpv.setText("Most Common Police Vehicle (Current): "+mcpV());
        cooep.setText("Current Officer(s) on Emergency Patrols: "+cooeP());
        mem.setText(meM());
        fillAgentTab("AE1461296");*/


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

    void fillAgentTab(String empID) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle2.wiu.edu:1521/orclpdb1", "F22_TEAM_17", "kl98oPFo");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from alphaagents");
            while (rs.next()) {
                if(rs.getString("EMPID").equals(empID)) {
                    EmpID.setText("EmpID: "+empID);
                    weaponID = rs.getString("WEAPONID");
                    Aliase.setText("Alise: "+rs.getString("ALIASES"));
                    supervisor.setText("Supervisor: "+rs.getString("SUPERVISORNAME"));
                    salary.setText("Salary: $"+rs.getString("SALARY"));
                    dLicense.setText("License No.: "+rs.getString("DRIVERSLICENCE"));
                    passport.setText("Passport No.: "+rs.getString("PASSPORTNO"));
                    ethnic.setText("Ethnicity: "+rs.getString("ETHNICITY"));
                    hite.setText("Height: "+rs.getString("HEIGHT"));
                    weapon.setText("Assigned Weapon: "+getWeapon(weaponID));
                }
            }
            con.close();
            return;
        } catch (Exception e) {
            System.out.println("Error on Fill Agent.");
            return;
        }

    }
    String getWeapon(String weaponID){
        try {
            String actualWeapon = "";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle2.wiu.edu:1521/orclpdb1", "F22_TEAM_17", "kl98oPFo");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select serialno, nameoftheweapon from weaponsdata");
            while (rs.next()) {
                if(rs.getString("SERIALNO").equals(weaponID)) {
                    actualWeapon = rs.getString("NAMEOFTHEWEAPON");
                }
            }
            con.close();
            return actualWeapon;
        } catch (Exception e) {
            System.out.println("Error on Fill Agent.");
            return "bruh";
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
                        welcome47.setVisible(true);
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
    static String meM() {
        try {
            String returnedString = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle2.wiu.edu:1521/orclpdb1", "F22_TEAM_17", "kl98oPFo");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT EventName, SUM(MoneySpentOnEvent) AS MoneySpent  FROM Budget GROUP BY EventName ORDER BY MoneySpent DESC FETCH FIRST 5 ROWS ONLY");
            while (rs.next()) {
                returnedString = "Most Expensive Mission: "+rs.getString("EventName")+" - $"+rs.getString("MoneySpent");
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
    static String cooeP() {
        try {
            int i = 0;
            String returnedString = "";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle2.wiu.edu:1521/orclpdb1", "F22_TEAM_17", "kl98oPFo");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select AlphaAgents.names FROM Patrolling,AlphaAgents WHERE AlphaAgents.EmpID=Patrolling.officerOnDuty AND Patrolling.PURPOSEOFPATROLLING = 'emergency'");
            while (rs.next()) {
                returnedString += rs.getString("names")+", ";
                if (i==7) {
                    break;
                }
                i++;
            }
            con.close();
            return returnedString;
        } catch (Exception e) {
            return "Error";
        }
    }
    static String emerPatrols() {
        try {
            String returnedString = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle2.wiu.edu:1521/orclpdb1", "F22_TEAM_17", "kl98oPFo");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM Patrolling WHERE Patrolling.PURPOSEOFPATROLLING = 'emergency'");
            while (rs.next()) {
                returnedString = rs.getString("COUNT(*)");
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
                    "AssetDamageInDollars DESC FETCH FIRST 10 ROWS ONLY");
            while (rs.next()){
                dateTime = rs.getString("dateTimes");
                loc = rs.getString("incidentLocation");
                //cost = rs.getString("AssetDamageInDollars");
                returnedString = "Most Dangerous Location: "+loc+"     Date: "+dateTime;
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
            int i = 0;
            String returnedString = "";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle2.wiu.edu:1521/orclpdb1", "F22_TEAM_17", "kl98oPFo");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NameOfTerrorists,ethnicity,IdentityNumber FROM TerroristsInformation WHERE InCustody = 'Yes'");
            while (rs.next()) {
                returnedString += rs.getString("NameOfTerrorists")+", ";
                if (i==5) {
                    break;
                }
                i++;
            }
            con.close();
            return returnedString;
        } catch (Exception e) {
            return "Error";
        }
    }
    static String mcpV() {
        try {
            String returnedString = "";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle2.wiu.edu:1521/orclpdb1", "F22_TEAM_17", "kl98oPFo");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select VehicleUsed,count(VehicleUsed) FROM Patrolling GROUP BY VehicleUsed ORDER BY count(VehicleUsed) DESC FETCH FIRST 5 ROWS ONLY");
            while (rs.next()) {
                returnedString += rs.getString("VehicleUsed")+", ";

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