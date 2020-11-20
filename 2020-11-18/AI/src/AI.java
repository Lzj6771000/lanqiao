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
	/*Image upImg,downImg,leftImg,rightImg,currentImg;
	Image upImgNext,upImgThen;
	Image downImgNext,downImgThen;
	Image leftImgNext,leftImgThen;
	Image rightImgNext,rightImgThen;*/
	Image currentImg;
	Image[][] hero_image=new Image[4][3];
	int Flag=1;
	public MainCanvas(){
		try
		{

			for(int i=0;i<4;i++)
				for(int j=0;j<3;j++)
				{
					if(i==0)
						hero_image[i][j]=Image.createImage("/sayo"+j+"4.png");
					if(i==1)
						hero_image[i][j]=Image.createImage("/sayo"+j+"0.png");
					if(i==2)
						hero_image[i][j]=Image.createImage("/sayo"+j+"2.png");
					if(i==3)
						hero_image[i][j]=Image.createImage("/sayo"+j+"6.png");
				}

			currentImg=hero_image[1][1];
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
			if(Flag==1)
			{
				currentImg=hero_image[0][0];;
				y--;
				Flag=2;
			}
			else
			{
				currentImg=hero_image[0][2];;
				y--;
				Flag=1;
			}


		}
		if(action==DOWN)
		{

				if(Flag==1)
			{
				currentImg=hero_image[1][0];
				y++;
				Flag=2;
			}
			else
			{
				currentImg=hero_image[1][2];;
				y++;
				Flag=1;
			}


		}
		if(action==LEFT)
		{
			if(Flag==1)
			{
				currentImg=hero_image[2][0];;
				x--;
				Flag=2;
			}
			else
			{
				currentImg=hero_image[2][2];;
				x--;
				Flag=1;
			}

		}

		if(action==RIGHT)
		{
			//currentImg=rightImg;

				if(Flag==1)
			{
				currentImg=hero_image[3][0];;
				x++;
				Flag=2;
			}
			else
			{
				currentImg=hero_image[3][2];;
				x++;
				Flag=1;
			}		




		}
		repaint();

	}
}