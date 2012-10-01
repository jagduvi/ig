package se.jagdyvi.instagramophone;

import android.media.MediaPlayer;
import android.media.audiofx.BassBoost;
import android.media.audiofx.Equalizer;
import android.media.audiofx.PresetReverb;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

	PresetReverb reverb;
	MediaPlayer mp;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btnStart = (Button)findViewById(R.id.btnStart);
        
        btnStart.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				
				 SetSound();
				
			}
		});
        
        Button btnStop = (Button)findViewById(R.id.btnEnd);
        
        btnStop.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				StopSound();
			}
		});
        
        
       
    }
    
    private void SetSound()
    {
    	PresetReverb reverb = new  PresetReverb(0, 0);
        reverb.setPreset(PresetReverb.PRESET_SMALLROOM);
     
      
        	reverb.setEnabled(true);

        	Equalizer eq = new Equalizer(0, 0);
        	
        	short bands = eq.getNumberOfBands();
        	
        	
        	final short minEQLevel = eq.getBandLevelRange()[0];
            final short maxEQLevel = eq.getBandLevelRange()[1];

            for (short i = 0; i < bands; i++) {
                final short band = i;

               eq.setBandLevel((short) 2, (short) (-15 * 1000));
              
               
            }
        	
      //   eq.setBandLevel()
        
            mp = MediaPlayer.create(this, R.raw.gramophone);
            mp.setLooping(true); 
            
            int maxVolume = 50;
           
            
            float log1=(float)(Math.log(maxVolume-49)/Math.log(maxVolume));
            mp.setVolume(1-log1, 1-log1);	
            
            mp.start();
        	
       
       
    }
    
    private void StopSound()
    {
    	//reverb.setEnabled(false);
    	mp.stop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
