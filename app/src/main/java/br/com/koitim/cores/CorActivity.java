package br.com.koitim.cores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class CorActivity extends AppCompatActivity {

    private int mVermelho;
    private int mVerde;
    private int mAzul;
    private SeekBar mCorVermelho;
    private SeekBar mCorVerde;
    private SeekBar mCorAzul;
    private Button mVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cor);

        Intent it = getIntent();
        if (it != null) {
            mVermelho = it.getIntExtra("vermelho", 0);
            mVerde = it.getIntExtra("verde", 0);
            mAzul = it.getIntExtra("azul", 0);
        }
        mCorVermelho = (SeekBar) findViewById(R.id.cor_seek_vermelho);
        mCorVerde = (SeekBar) findViewById(R.id.cor_seek_verde);
        mCorAzul = (SeekBar) findViewById(R.id.cor_seek_azul);
        mCorVermelho.setProgress(mVermelho);
        mCorVerde.setProgress(mVerde);
        mCorAzul.setProgress(mAzul);

        mVoltar = (Button) findViewById(R.id.cor_voltar);
        mVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.putExtra("vermelho", mCorVermelho.getProgress());
                it.putExtra("verde", mCorVerde.getProgress());
                it.putExtra("azul", mCorAzul.getProgress());
                setResult(RESULT_OK, it);
                finish();
            }
        });
    }
}