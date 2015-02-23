package master.atelier.seance3;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AjoutActivity extends ActionBarActivity implements OnClickListener {
	EditText t1,t2;
	Button b;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ajout_etudiant);
		t1=(EditText)findViewById(R.id.editnom);
		t2=(EditText)findViewById(R.id.editprenom) ;
		b=(Button) findViewById(R.id.ajoutButton);
		b.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		MyHelper help=new MyHelper(this);
		SQLiteDatabase db=help.getWritableDatabase();
		ContentValues cc=new ContentValues();
		cc.put("nom",t1.getText().toString());
		cc.put("prenom",t2.getText().toString());
		db.insert("etudiant", null, cc);
		db.close();
		finish();
        ListEtudiant.adapt.notifyDataSetChanged();
	}
	
	
	

}
