
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Catapult extends JPanel implements ActionListener, MouseListener{
	private Image catapultBody;
	private double direction;
	private double releaseAngle; //angle of arm (orthogonal to velocity)
	private int magnitude;
	private Timer time;
	
	private Point fulcrum;
	private Point catapultLoc;
	private int groundHeight = 20;
	private Color sky = Color.cyan;
	
	public Catapult(){
		fulcrum = new Point(0, getHeight()-groundHeight);
		catapultLoc = new Point(0, getHeight()-groundHeight-catapultBody.getHeight(null));
		
		time = new Timer(10, this);
		setBackground(sky);
	}
	
	public void startLaunch(){
		releaseAngle = Math.PI/4;
	}
	
	public int[] getReleaseVelocity(){
		
	}

	private void calculateAngle(){
		double x;
		double y;
		
		//finds direction of mouse relative to fulcrum of catapult
		Point mouse = new Point(MouseInfo.getPointerInfo().getLocation());
		x = mouse.getX() - fulcrum.getX();
		y = mouse.getY() - fulcrum.getY();
		
		direction = Math.atan2(y,x);
	}
	
	private void calculateMagnitude(){
		
	}
	
	public void paint(Graphics g){
		super.repaint();
		
		//draw ground
		g.setColor(new Color(0, 102, 0));
		g.fill3DRect(0, getHeight() - groundHeight, getWidth(), getHeight(), false);
		
		//draw catapult body
		Graphics2D g2 = (Graphics2D)g;
		g2.drawImage(catapultBody, (int)catapultLoc.getX(), (int)catapultLoc.getY(), sky, null);
		
		//draw catapultArm
	}
	
	public void mouseClicked(MouseEvent arg0) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {
		time.start();
	}
	public void mouseReleased(MouseEvent arg0) {
		time.stop();
		calculateMagnitude();
		//run launch animation
		//call launch complete in window
	}
	
	public void actionPerformed(ActionEvent e){
		calculateAngle();
		repaint();
	}
}
