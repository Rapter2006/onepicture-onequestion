package picture.questions;

import uk.co.senab.photoview.PhotoViewAttacher;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import classes.InfoCreater;


public class PictureActivity extends Activity {
	private ImageView mImageView;
	private PhotoViewAttacher mAttacher;
    private int positionInVarioties, positionInMystiries;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.picture);
      
		Bundle extras = getIntent().getExtras();
        positionInVarioties = extras.getInt("pisitionInVarioties", 0);
        positionInMystiries = extras.getInt("positionInMysteries", 0);		
		
		mImageView = (ImageView) findViewById(R.id.iv_photo);
		
		Drawable bitmap = getResources().getDrawable(InfoCreater.allMysteries.
        		get(positionInVarioties).getMysteries().
        		get(positionInMystiries).getPictureId());
		mImageView.setImageDrawable(bitmap);

		mAttacher = new PhotoViewAttacher(mImageView);

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mAttacher.cleanup();
	}



	

}