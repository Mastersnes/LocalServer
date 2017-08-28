package launch;
import java.awt.Desktop;
import java.net.URI;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.eclipse.jetty.server.Server;

public class LaunchFrame extends JFrame {
    private static final long serialVersionUID = 4872199452273194690L;

    public LaunchFrame() throws Exception {
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new JLabel("Serveur lancé ! Fermez cette fenetre pour couper le jeu."));
        setLocationRelativeTo(null);
        pack();

        final Server server = new Server(8080);
        server.setHandler(new LaunchServer());
        try {
            server.start();
            Desktop.getDesktop().browse(URI.create("http://localhost:8080/bebel/index.html"));
            server.join();
        } catch (final Exception e) {
            System.err.println("Le serveur est deja lancé !");
            Desktop.getDesktop().browse(URI.create("http://localhost:8080/bebel/index.html"));
            System.exit(0);
        }

    }

    public static void main(final String[] args) throws Exception {
        new LaunchFrame();
    }
}
