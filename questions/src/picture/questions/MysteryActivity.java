package picture.questions;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import classes.InfoCreater;

public class MysteryActivity extends Activity implements OnClickListener{
    int positionInVarioties, positionInMystiries;
	TextView questionText, linkText;
    ImageView image;
    Button answerButton;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        
        setContentView(R.layout.infomystery);
        
        Bundle extras = getIntent().getExtras();
        positionInVarioties = extras.getInt("pisitionInVarioties", 0);
        positionInMystiries = extras.getInt("positionInMysteries", 0);		
      
        answerButton = (Button) findViewById(R.id.buttonAnswer);
        questionText = (TextView) findViewById(R.id.questionText);
       
        questionText.setText(InfoCreater.allMysteries.
            		get(positionInVarioties).getMysteries().
            		get(positionInMystiries).getQuestion());	
        
        image = (ImageView) findViewById(R.id.questionPicture);         
        image.setImageResource(InfoCreater.allMysteries.
        		get(positionInVarioties).getMysteries().
        		get(positionInMystiries).getPictureId());
          
        answerButton.setOnClickListener(this);
        image.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		   case R.id.questionPicture:
			{
				Intent intentPict = new Intent(MysteryActivity.this, PictureActivity.class);
				intentPict.putExtra("pisitionInVarioties", positionInVarioties);
				intentPict.putExtra("positionInMysteries", positionInMystiries);   
				startActivity(intentPict);
				break;
			}
			case R.id.buttonAnswer:
			{
				Dialog dialog = new Dialog(this);
				dialog.setTitle("Ответ");
				TextView text = new TextView(this);
				text.setText(InfoCreater.allMysteries.
	        		get(positionInVarioties).getMysteries().
	        		get(positionInMystiries).getAnswer());
				text.setTextSize(27);
				ScrollView scroll = new ScrollView(this);
				LinearLayout layout = new LinearLayout(this);
				scroll.addView(text);
				int a = InfoCreater.allMysteries.
		        		get(positionInVarioties).getMysteries().
		        		get(positionInMystiries).getPictureAnswer();
				int b = InfoCreater.allMysteries.
		        		get(positionInVarioties).getMysteries().
		        		get(positionInMystiries).getPictureId();
				if (a != b)
				{
					ImageView image = new ImageView(this);
					image.setImageResource(InfoCreater.allMysteries.
			        		get(positionInVarioties).getMysteries().
			        		get(positionInMystiries).getPictureAnswer());
					
					layout.setBackgroundColor(Color.WHITE);
					layout.addView(scroll);
					layout.addView(image);
				}
				else
				{
					layout.setBackgroundColor(Color.WHITE);
					layout.addView(scroll);	
				}
				dialog.setContentView(layout);	
				dialog.setCanceledOnTouchOutside(true);
				dialog.show();	
				break;
			}	
			
		}
		
	}

}