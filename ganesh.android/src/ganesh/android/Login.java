package ganesh.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.View.OnClickListener;
import android.view.textservice.TextInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//String message = "...";
		LinearLayout window = new LinearLayout(this);

		TextView txtUsuario = new TextView(this);
		txtUsuario.setText("Usuário");
		
		
		
		//window.addView(txtUsuario);
		
		Button b = new Button(this);
		b.setText("Clique aqui");
		b.setOnClickListener(new SomeHandler());
		window.addView(b);
		
		setContentView(window);
		
         

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	private class SomeHandler implements OnClickListener{



		@Override
        public void onClick(View arg0) {
	        Log.v(getClass().getSimpleName(), "Clicou no botão, uhul"); 
	        Toast.makeText(Login.this, "Meu primeiro Toast", Toast.LENGTH_SHORT).show();
        }
		
	}
	
}
