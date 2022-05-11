import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

public class View extends JFrame{
    private Controller controller;

    // paneler
    private JPanel hovedPanel, overskrift, innstillinger, nivaa, baner, start;


    // konstanter
    private final int BRETTBREDDE = 800;
    private final int BRETTHOYDE = 500;

    public View(Controller controller) {
        this.controller = controller;

        // fallback paa layout for gui
        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName()
            );
        } catch (Exception e) { System.exit(9); }

        // setter opp vindu
        setTitle("Pacman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // setter opp paneler
        hovedPanel = settHovedPanel();

        // legger til paneler i vindu
        add(hovedPanel);


        setSize(new Dimension(BRETTBREDDE, BRETTHOYDE));
        setVisible(true);

    }

    private JPanel settHovedPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(BRETTBREDDE, BRETTHOYDE));
        panel.setOpaque(true);
        panel.setBackground(Color.BLACK);

        // setter opp paneler og legger til hovedpanel
        overskrift = settOverskrift();
        innstillinger = settInnstillinger();
        start = settStart();

        panel.add(overskrift, BorderLayout.NORTH);
        panel.add(innstillinger, BorderLayout.CENTER);
        panel.add(start, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel settOverskrift() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);

        JLabel overskrift = new JLabel("PACMAN");
        overskrift.setForeground(Color.RED);
        overskrift.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));

        panel.add(overskrift, BorderLayout.NORTH);

        return panel;

    }

    private JPanel settInnstillinger() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.DARK_GRAY);

        // setter opp valg av vanskelighetsgrad
        nivaa = settNivaa();
        panel.add(nivaa, BorderLayout.NORTH);

        // setter opp valg av antall baner
        baner = settBaner();
        panel.add(baner, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel settNivaa() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel valg = new JPanel(new BorderLayout());
        JLabel overskrift = new JLabel("VANSKELIGHETSGRAD");

        JButton lett = new JButton("Lett"); 
        JButton middels = new JButton("Middels"); 
        JButton vanskelig = new JButton("Vanskelig"); 
        valg.add(lett, BorderLayout.WEST);
        valg.add(middels, BorderLayout.CENTER);
        valg.add(vanskelig, BorderLayout.EAST);

        panel.add(overskrift, BorderLayout.NORTH);
        panel.add(valg, BorderLayout.SOUTH);


        return panel;
    }

    private JPanel settBaner() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel valg = new JPanel(new BorderLayout());
        JLabel overskrift = new JLabel("VANSKELIGHETSGRAD");

        JButton fem = new JButton("5"); 
        JButton ti = new JButton("10"); 
        JButton femten = new JButton("15"); 
        valg.add(fem, BorderLayout.WEST);
        valg.add(ti, BorderLayout.CENTER);
        valg.add(femten, BorderLayout.EAST);

        panel.add(overskrift, BorderLayout.NORTH);
        panel.add(valg, BorderLayout.SOUTH);


        return panel;
    }

    private JPanel settStart() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton start = new JButton("START");
        start.setBackground(Color.WHITE);

        panel.add(start);

        return panel;
    }

}