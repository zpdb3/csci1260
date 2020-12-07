import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public class Window extends JFrame implements ActionListener {

    private JFrame worldf;
    private JFrame areaf;
    private JLabel imageLabel;
    private ArrayList<JButton> buttonAL;
    private JTextArea worldTextArea;
    private JLabel dayLabel;
    private JLabel actionLabel;
    private JTextArea areaTextArea;
    private JLabel dayLabel1;
    private JLabel actionLabel1;
    private JButton axeB;
    private JButton hoeB;
    private JButton shovelB;
    private JButton scarecrowB;
    private JButton fireworkB;
    private JButton talkB;
    private JButton pickupB;
    private JButton backToWorldB;
    private JButton restB;
    private JButton repairB;
    private Icon icon;

    Image image;
    BufferedImage scaledImage;

    Window(){

        worldf = new JFrame();
        areaf = new JFrame();
        JButton b;
        buttonAL = new ArrayList<JButton>();

        for(int Vcount = 10; Vcount < 510; Vcount += 100) {
            for(int Hcount = 10; Hcount < 510; Hcount += 100){

                if(Hcount == 10 || Hcount == 410){
                    icon = new ImageIcon("FieldIcon.png");
                }
                if(Hcount == 110){
                    icon = new ImageIcon("ForestIcon.png");
                }
                if(Hcount == 210){
                    icon = new ImageIcon("SettlementIcon.png");
                }
                if(Hcount == 310){
                    icon = new ImageIcon("MineIcon.png");
                }
                b = new JButton(icon);
                b.setBounds(Hcount, Vcount, 90, 90);
                b.addActionListener(this);
                worldf.add(b);
                buttonAL.add(b);
            }
        }
        worldTextArea = new JTextArea("World Information");
        worldTextArea.setEditable(false);
        worldTextArea.setOpaque(true);
        worldTextArea.setBackground(Color.GRAY);
        worldTextArea.setBounds(510, 10, 290, 610);
        worldf.add(worldTextArea);

        actionLabel = new JLabel("Actions Left:  ", SwingConstants.CENTER);
        actionLabel.setOpaque(true);
        actionLabel.setBackground(Color.GREEN);
        actionLabel.setBounds(10, 520, 190,90);
        worldf.add(actionLabel);

        dayLabel = new JLabel("Days Left:  ", SwingConstants.CENTER);
        dayLabel.setOpaque(true);
        dayLabel.setBackground(Color.GREEN);
        dayLabel.setBounds(210, 520, 190, 90);
        worldf.add(dayLabel);

        worldf.setSize(810, 650);
        worldf.setLayout(null);
        worldf.getContentPane().setBackground(Color.DARK_GRAY);
        worldf.setVisible(true);


        areaTextArea = new JTextArea("Area Information");
        areaTextArea.setEditable(false);
        areaTextArea.setOpaque(true);
        areaTextArea.setBackground(Color.GRAY);
        areaTextArea.setBounds(510, 10, 290, 610);
        areaf.add(areaTextArea);

        icon = new ImageIcon("axeIcon.png");
        axeB = new JButton(icon);
        axeB.setBounds(10, 420, 90, 60);
        axeB.addActionListener(this);
        areaf.add(axeB);

        icon = new ImageIcon("hoeIcon.png");
        hoeB = new JButton(icon);
        hoeB.setBounds(110, 420, 90, 60);
        hoeB.addActionListener(this);
        areaf.add(hoeB);

        icon = new ImageIcon("shovelIcon.png");
        shovelB = new JButton(icon);
        shovelB.setBounds(210, 420, 90, 60);
        shovelB.addActionListener(this);
        areaf.add(shovelB);

        icon = new ImageIcon("scarecrowIcon.png");
        scarecrowB = new JButton(icon);
        scarecrowB.setBounds(310, 420, 90, 60);
        scarecrowB.addActionListener(this);
        areaf.add(scarecrowB);

        icon = new ImageIcon("fireworkIcon.png");
        fireworkB = new JButton(icon);
        fireworkB.setBounds(410, 420, 90, 60);
        fireworkB.addActionListener(this);
        areaf.add(fireworkB);

        icon = new ImageIcon("talkIcon.png");
        talkB = new JButton(icon);
        talkB.setBounds(10, 490, 90, 60);
        talkB.addActionListener(this);
        areaf.add(talkB);

        icon = new ImageIcon("pickupIcon.png");
        pickupB = new JButton(icon);
        pickupB.setBounds(110, 490, 90, 60);
        pickupB.addActionListener(this);
        areaf.add(pickupB);

        icon = new ImageIcon("repairIcon.png");
        repairB = new JButton(icon);
        repairB.setBounds(210, 490, 90, 60);
        repairB.addActionListener(this);
        areaf.add(repairB);


        icon = new ImageIcon("restIcon.png");
        restB = new JButton(icon);
        restB.setBounds(310, 490, 90, 60);
        restB.addActionListener(this);
        areaf.add(restB);

        icon = new ImageIcon("worldMapIcon.png");
        backToWorldB = new JButton(icon);
        backToWorldB.setBounds(410, 490, 90, 60);
        backToWorldB.addActionListener(this);
        areaf.add(backToWorldB);

        actionLabel1 = new JLabel("Actions Left:  ", SwingConstants.CENTER);
        actionLabel1.setBounds(10, 560, 190, 60);
        actionLabel1.setOpaque(true);
        actionLabel1.setBackground(Color.GREEN);
        areaf.add(actionLabel1);

        dayLabel1 = new JLabel("Days Left:  ", SwingConstants.CENTER);
        dayLabel1.setBounds(210, 560, 190, 60);
        dayLabel1.setOpaque(true);
        dayLabel1.setBackground(Color.GREEN);
        areaf.add(dayLabel1);

        areaf.setSize(810, 650);
        areaf.setLayout(null);
        areaf.getContentPane().setBackground(Color.DARK_GRAY);
        areaf.setVisible(false);


    }

    public void actionPerformed(ActionEvent e){

        if(worldf.isVisible()){
            worldf.setVisible(false);
            if(buttonAL.get(0) == e.getSource()){

                try {
                    if(imageLabel != null) {
                        areaf.remove(imageLabel);
                    }
                    scaledImage = ImageIO.read(new File("pastureField.png"));
                    image =  scaledImage.getScaledInstance(490, 400, Image.SCALE_AREA_AVERAGING);
                    imageLabel = new JLabel(new ImageIcon(image));
                    imageLabel.setBounds(10, 10, 490, 400);
                    areaf.add(imageLabel);
                }
                catch(IOException x) {
                    JFrame oopsieF = new JFrame("No file loaded");
                    oopsieF.setSize(300, 300);
                    oopsieF.setLayout(null);
                    oopsieF.setVisible(true);
                    areaf.setVisible(false);
                    worldf.setVisible(false);
                }

                areaTextArea.setText("set basic welcome text and description");
                //update actions because of travel
                areaf.update(areaTextArea.getGraphics());
                areaf.update(imageLabel.getGraphics());

            }
            if(buttonAL.get(1) == e.getSource()){

                try {
                    if(imageLabel != null) {
                        areaf.remove(imageLabel);
                    }
                    scaledImage = ImageIO.read(new File("rainForest.png"));
                    image =  scaledImage.getScaledInstance(490, 400, Image.SCALE_AREA_AVERAGING);
                    imageLabel = new JLabel(new ImageIcon(image));
                    imageLabel.setBounds(10, 10, 490, 400);
                    areaf.add(imageLabel);
                }
                catch(IOException x) {
                    JFrame oopsieF = new JFrame("No file loaded");
                    oopsieF.setSize(300, 300);
                    oopsieF.setLayout(null);
                    oopsieF.setVisible(true);
                    areaf.setVisible(false);
                    worldf.setVisible(false);
                }

                areaf.update(imageLabel.getGraphics());
            }
            if(buttonAL.get(2) == e.getSource()){

                try {
                    if(imageLabel != null) {
                        areaf.remove(imageLabel);
                    }
                    scaledImage = ImageIO.read(new File("medievalInn.png"));
                    image =  scaledImage.getScaledInstance(490, 400, Image.SCALE_AREA_AVERAGING);
                    imageLabel = new JLabel(new ImageIcon(image));
                    imageLabel.setBounds(10, 10, 490, 400);
                    areaf.add(imageLabel);
                }
                catch(IOException x) {
                    JFrame oopsieF = new JFrame("No file loaded");
                    oopsieF.setSize(300, 300);
                    oopsieF.setLayout(null);
                    oopsieF.setVisible(true);
                    areaf.setVisible(false);
                    worldf.setVisible(false);
                }

                areaf.update(imageLabel.getGraphics());
            }
            if(buttonAL.get(3) == e.getSource()){

                try {
                    if(imageLabel != null) {
                        areaf.remove(imageLabel);
                    }
                    scaledImage = ImageIO.read(new File("horizontalMine.png"));
                    image =  scaledImage.getScaledInstance(490, 400, Image.SCALE_AREA_AVERAGING);
                    imageLabel = new JLabel(new ImageIcon(image));
                    imageLabel.setBounds(10, 10, 490, 400);
                    areaf.add(imageLabel);
                }
                catch(IOException x) {
                    JFrame oopsieF = new JFrame("No file loaded");
                    oopsieF.setSize(300, 300);
                    oopsieF.setLayout(null);
                    oopsieF.setVisible(true);
                    areaf.setVisible(false);
                    worldf.setVisible(false);
                }

                areaf.update(imageLabel.getGraphics());
            }
            if(buttonAL.get(4) == e.getSource()){

            }
            if(buttonAL.get(5) == e.getSource()){

            }
            if(buttonAL.get(6) == e.getSource()){

            }
            if(buttonAL.get(7) == e.getSource()){

            }
            if(buttonAL.get(8) == e.getSource()){

            }
            if(buttonAL.get(9) == e.getSource()){

            }
            if(buttonAL.get(10) == e.getSource()){

            }
            if(buttonAL.get(11) == e.getSource()){

            }
            if(buttonAL.get(12) == e.getSource()){

            }
            if(buttonAL.get(13) == e.getSource()){

            }
            if(buttonAL.get(14) == e.getSource()){

            }
            if(buttonAL.get(15) == e.getSource()){

            }
            if(buttonAL.get(16) == e.getSource()){

            }
            if(buttonAL.get(17) == e.getSource()){

            }
            if(buttonAL.get(18) == e.getSource()){

            }
            if(buttonAL.get(19) == e.getSource()){

            }
            if(buttonAL.get(20) == e.getSource()){

            }
            if(buttonAL.get(21) == e.getSource()){

            }
            if(buttonAL.get(22) == e.getSource()){

            }
            if(buttonAL.get(23) == e.getSource()){

            }
            if(buttonAL.get(24) == e.getSource()){

            }
            areaf.setVisible(true);
        }
        else{
            areaf.setVisible(false);
            worldf.setVisible(true);
        }
    }
}
