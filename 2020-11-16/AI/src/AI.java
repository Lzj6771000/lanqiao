import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int x=120,y=100;
	Image upImg,downImg,leftImg,rightImg,currentImg;
	Image upImgNext,upImgThen;
	Image downImgNext,downImgThen;
	Image leftImgNext,leftImgThen;
	Image rightImgNext,rightImgThen;
	int Flag=1;
	public MainCanvas(){
		try
		{
			
			upImg=Image.createImage("/sayo14.png");
			downImg=Image.createImage("/sayo10.png");
			leftImg=Image.createImage("/sayo12.png");
			rightImg=Image.createImage("/sayo16.png");

			leftImgNext=Image.createImage("/sayo02.png");
			leftImgThen=Image.createImage("/sayo22.png");
			
			upImgNext=Image.createImage("/sayo04.png");
			upImgThen=Image.createImage("/sayo24.png");

			downImgNext=Image.createImage("/sayo00.png");
			downImgThen=Image.createImage("/sayo20.png");

			rightImgNext=Image.createImage("/sayo06.png");
			rightImgThen=Image.createImage("/sayo26.png");

			currentImg=downImg;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==UP)
		{
			//currentImg=upImg;
			if(Flag==1)
			{
				currentImg=upImgNext;
				y--;
				Flag=2;
			}
			else
			{
				currentImg=upImgThen;
				y--;
				Flag=1;
			}


		}
		if(action==DOWN)
		{
			//currentImg=downImg;

				if(Flag==1)
			{
				currentImg=downImgNext;
				y++;
				Flag=2;
			}
			else
			{
				currentImg=downImgThen;
				y++;
				Flag=1;
			}


		}
		if(action==LEFT)
		{
			if(Flag==1)
			{
				currentImg=leftImgNext;
				x--;
				Flag=2;
			}
			else
			{
				currentImg=leftImgThen;
				x--;
				Flag=1;
			}

		}

		if(action==RIGHT)
		{
			//currentImg=rightImg;

				if(Flag==1)
			{
				currentImg=rightImgNext;
				x++;
				Flag=2;
			}
			else
			{
				currentImg=rightImgThen;
				x++;
				Flag=1;
			}		




		}
		repaint();

	}
}