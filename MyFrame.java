package JavaProject3;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyFrame extends JFrame{

	Calendar calendar;
	
	//Time of the day-----------
	SimpleDateFormat timeFormat;
	JLabel timeLabel;
	String time;
	//--------------------------
	
	
	//Day of the week----------
	SimpleDateFormat dayFormat;
	JLabel dayLabel;
	String day;
	//-------------------------
	
	
	//Date--------------------
	SimpleDateFormat dateFormat;
	JLabel dateLabel;
	String date;
	//-------------------------
	
	public MyFrame() {
		// TODO Auto-generated constructor stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Clock");
		this.setLayout(new FlowLayout());
		this.setSize(350, 200);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		timeFormat = new SimpleDateFormat("hh:mm:ss a");//Go to https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbURnLW9VZW10R1NKaFowVjlSUzBocHdiZG5RUXxBQ3Jtc0trSERKOTlORmNZRFFuOXBlR191bXRucWRyNFF1dktPVGI4TWZzNElsZGZjRC1NbkxtYW00Z0liTGtrTnhKcFBrU1hQa3JmUEtpeDhoRmRpbkxpVm0xQ1EwMzhHbFRscW9pSWRMVTMzNGdtejRwU3I1Zw&q=https%3A%2F%2Fdocs.oracle.com%2Fjavase%2F7%2Fdocs%2Fapi%2Fjava%2Ftext%2FSimpleDateFormat.html%23text&v=U63PV3u4aeQ
											  //For simpleDateFormat parameters
											  // hh(2 digit for hour), mm(2 digit for minutes), ss(2 digits for seconds) a(am or pm)
		
		dayFormat = new SimpleDateFormat("EEEE");//E(only 3 letter of the day), EEEE(spell out full name)
		
		dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");
		
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
		timeLabel.setForeground(new Color(0x00FF00));
		timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true);
		
		time = timeFormat.format(Calendar.getInstance().getTime());//Get the current time and store it in the String variable time
		timeLabel.setText(time);
		
		dayLabel = new JLabel();
		dayLabel.setFont(new Font("Ink Free", Font.PLAIN, 35));
		
		dateLabel = new JLabel();
		dateLabel.setFont(new Font("Ink Free", Font.PLAIN, 25));

		this.add(timeLabel);//How they order, time above
		this.add(dayLabel);//day middle
		this.add(dateLabel);//date last
		this.setVisible(true);
		
		//without calling this method you will notice the clock does not move
		//So in order for the clock to move we are creating a method that update the clock every one second.
		setTime();
	}

	public void setTime() {
		while(true) {
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText("Day: " + day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText("Date: " + date);
			
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
}
