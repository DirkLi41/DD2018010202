package tw.com.pcschool.dd2018010202;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1;

    RadioGroup rg;

    Switch sw1;
    ProgressBar pb1;

    ProgressBar pb2;

    SeekBar sb1;
    TextView tv1;

    int pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.checkBox);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    Toast.makeText(MainActivity.this, "已選取", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "已取消", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rg = (RadioGroup) findViewById(R.id.radioGroup);

        sw1 = (Switch) findViewById(R.id.switch1);
        pb1 = (ProgressBar) findViewById(R.id.progressBar);

        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    pb1.setVisibility(View.VISIBLE);
                }
                else
                {
                    pb1.setVisibility(View.INVISIBLE);
                }

            }
        });

        pb2 = (ProgressBar)findViewById(R.id.progressBar2);

        sb1 = (SeekBar)findViewById(R.id.seekBar);
        tv1 = (TextView)findViewById(R.id.textView);

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv1.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void click1(View v)
    {
        switch(rg.getCheckedRadioButtonId())
        {
            case R.id.radioButton:
                Toast.makeText(MainActivity.this, "選項1已選取", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton2:
                Toast.makeText(MainActivity.this, "選項2已選取", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton3:
                Toast.makeText(MainActivity.this, "選項3已選取", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void click2(View v)
    {
        pb1.setVisibility(View.VISIBLE);
        new Thread(){
            @Override
            public void run() {
                super.run();

                try{
                    Thread.sleep(3000);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pb1.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }.start();

    }
    public void click3(View v)
    {
        pb2.setProgress(pb2.getProgress()-10);
    }
    public void click4(View v)
    {
        pb2.setProgress(pb2.getProgress()+10);
    }
    public void clickGo(View v)
    {
        new Thread()
        {
            @Override
            public void run() {
                super.run();
                //int pi;
                for(pi=0;pi <= 100;pi++)
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pb2.setProgress(pi);
                        }
                    });
                    try
                    {
                        Thread.sleep(10);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
