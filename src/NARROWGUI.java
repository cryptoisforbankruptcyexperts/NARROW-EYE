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

// Java core by Joshua Wilkinson - TEAM_17
// Definitely couldn't do SHA-256 off the top of my head, Reference: https://www.geeksforgeeks.org/sha-256-hash-in-java/
// "If it doesn't put me on a watch list, I've failed."

public class NARROWGUI extends JFrame {
    private JPanel narrowLogin;
    private JTextField username;
    private JPasswordField passphrase;
    private JButton LOGINButton;
public NARROWGUI() {
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
        setSize(500,175);
        setVisible(true);
        setResizable(false);
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (narrowLOGIN(username,passphrase) == true) {
                    System.out.println("Win");
                    // OPEN MAIN GUI
                }
            }
        });
        passphrase.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    if (narrowLOGIN(username,passphrase) == true) {
                        System.out.println("Win");
                        // OPEN MAIN GUI
                    }
                }
            }
        });
        return true;
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

    public static void main(String[] args) {
    NARROWGUI x = new NARROWGUI();
}
}
