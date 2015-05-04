package com.hcm.newpdf;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements OnPageChangeListener {
	
	private Button btn;
	private PDFView pdfView;
	public static final String SAMPLE_FILE = "sample.pdf";
	
	private Context ctx ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ctx = this;
		btn = (Button) findViewById(R.id.button1);
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d("Click", "Clicked");
		        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(3)
                .onPageChange((MainActivity)ctx)
                .load();
			}
		});
		
		pdfView = (PDFView) findViewById(R.id.pdfView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onPageChanged(int arg0, int arg1) {
		Log.d("onPageChanged", arg0 +" "+ arg1);
		
	}

}
