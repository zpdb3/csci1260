import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
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
    private JLabel worldLabel;
    private JLabel dayLabel;
    private JLabel actionLabel;
    private JLabel areaLabel;
    private JLabel dayLabel1;
    private JLabel actionLabel1;
    private JButton axeB;
    private JButton hoeB;
    private JButton shovelB;
    private JButton pickaxeB;
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
        worldLabel = new JLabel("World Information");
        worldLabel.setBounds(510, 10, 290, 590);
        worldf.add(worldLabel);

        actionLabel = new JLabel("Actions Left:  ", SwingConstants.CENTER);
        actionLabel.setBounds(10, 530, 190,90);
        worldf.add(actionLabel);

        dayLabel = new JLabel("Days Left:  ", SwingConstants.CENTER);
        dayLabel.setOpaque(true);
        dayLabel.setBackground(Color.GREEN);
        dayLabel.setBounds(210, 530, 190, 90);
        worldf.add(dayLabel);

        worldf.setSize(810, 650);
        worldf.setLayout(null);
        worldf.setVisible(true);


        areaLabel = new JLabel("Area Information");
        areaLabel.setBounds(510, 10, 290, 590);
        areaf.add(areaLabel);

        axeB = new JButton("Use Axe");
        axeB.setBounds(10, 420, 90, 20);
        axeB.addActionListener(this);
        areaf.add(axeB);

        hoeB = new JButton("Use Hoe");
        hoeB.setBounds(110, 420, 90, 20);
        hoeB.addActionListener(this);
        areaf.add(hoeB);

        shovelB = new JButton("Use Shovel");
        shovelB.setBounds(210, 420, 90, 20);
        shovelB.addActionListener(this);
        areaf.add(shovelB);

        pickaxeB = new JButton("Use Pickaxe");
        pickaxeB.setBounds(310, 420, 90, 20);
        pickaxeB.addActionListener(this);
        areaf.add(pickaxeB);

        fireworkB = new JButton("Use Firework");
        fireworkB.setBounds(410, 420, 90, 20);
        fireworkB.addActionListener(this);
        areaf.add(fireworkB);

        talkB = new JButton("Talk");
        talkB.setBounds(10, 450, 90, 20);
        talkB.addActionListener(this);
        areaf.add(talkB);

        pickupB = new JButton("Pick Up Items");
        pickupB.setBounds(110, 450, 90, 20);
        pickupB.addActionListener(this);
        areaf.add(pickupB);

        repairB = new JButton("Repair");
        repairB.setBounds(210, 450, 90, 20);
        repairB.addActionListener(this);
        areaf.add(repairB);

        restB = new JButton("Rest");
        restB.setBounds(310, 450, 90, 20);
        restB.addActionListener(this);
        areaf.add(restB);

        backToWorldB = new JButton("World Map");
        backToWorldB.setBounds(410, 450, 90, 20);
        backToWorldB.addActionListener(this);
        areaf.add(backToWorldB);

        actionLabel1 = new JLabel("Actions Left:  ", SwingConstants.CENTER);
        actionLabel1.setBounds(10, 530, 190, 90);
        actionLabel1.setOpaque(true);
        actionLabel1.setBackground(Color.GREEN);
        areaf.add(actionLabel1);

        dayLabel1 = new JLabel("Days Left:  ", SwingConstants.CENTER);
        dayLabel1.setBounds(210, 530, 190, 90);
        areaf.add(dayLabel1);

/*
        try {
            scaledImage = ImageIO.read(new File("testImage.png"));
            image =  scaledImage.getScaledInstance(490, 400, Image.SCALE_AREA_AVERAGING);
            imageLabel = new JLabel(new ImageIcon(image));
            imageLabel.setBounds(10, 10, 490, 400);
            areaf.add(imageLabel);
        }
        catch(IOException e) {
            JFrame oopsieF = new JFrame("No file loaded");
            oopsieF.setSize(300, 300);
            oopsieF.setLayout(null);
            oopsieF.setVisible(true);
            areaf.setVisible(false);
            worldf.setVisible(false);
        }
*/


        areaf.setSize(810, 650);
        areaf.setLayout(null);
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

                areaLabel.setText("set basic welcome text and description");
                //update actions because of travel
                areaf.update(areaLabel.getGraphics());
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
