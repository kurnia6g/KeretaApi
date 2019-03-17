package id.ac.darmajaya.keretaapi;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PengertianDetailActivity extends AppCompatActivity {

    private ImageView musik;
    private int mstatus = 0;
    private MediaPlayer ring;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pengertian_detail);

        TextView judul = (TextView) findViewById(R.id.judul);
        TextView deskripsi = (TextView) findViewById(R.id.deskripsi);
        musik = (ImageView) findViewById(R.id.musik_penjelasan);
        final String datamusik = getIntent().getStringExtra("MUSIK");

        judul.setText(getIntent().getStringExtra("JUDUL"));
        deskripsi.setText(getIntent().getStringExtra("DESKRIPSI"));

        if (datamusik.equals("") || datamusik == null) {
            musik.setVisibility(View.GONE);

        }

        musik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mstatus == 0) {
                    ring = MediaPlayer.create(getApplicationContext(), Uri.parse("android.resource://" + getPackageName() + "/raw/" + getIntent().getStringExtra("MUSIK")));
                    ring.start();
                    mstatus = 1;
                    musik.setImageResource(R.drawable.ic_stop);

                } else {
                    ring.stop();
                    musik.setImageResource(R.drawable.ic_play);
                    mstatus = 0;
                }
            }
        });
    }

}