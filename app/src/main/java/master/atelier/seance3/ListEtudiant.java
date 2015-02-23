package master.atelier.seance3;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.os.Build;

public class ListEtudiant extends ActionBarActivity {

	ListView lis;
public	static Myadapter adapt;
public 	static List<Etudiant> lEtud ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_etudiant);
		lis=(ListView) findViewById(R.id.MyListView);
		MyHelper help=new MyHelper(this);
		SQLiteDatabase db=help.getReadableDatabase();
		Cursor it=db.query("etudiant",new String[]{"id","nom","prenom"},
				null, null, null,
				null,"id DESC");
		lEtud=new ArrayList<Etudiant>() ;

		while(it.moveToNext()){
			lEtud.add(new Etudiant(it.getInt(0),it.getString(1)
					,it.getString(2))) ;
		}
		adapt=new Myadapter(this,lEtud);
		lis.setAdapter(adapt);
	  lis.invalidate();
	}
	
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		MyHelper help=new MyHelper(this);
		SQLiteDatabase db=help.getReadableDatabase();
		Cursor it=db.query("etudiant",new String[]{"id","nom","prenom"},
				null, null, null,
				null,"id DESC");
		lEtud=new ArrayList<Etudiant>() ;
		it.moveToFirst();
		while(it.moveToNext()){
			lEtud.add(new Etudiant(it.getInt(0),it.getString(1)
					,it.getString(2))) ;
		}
		adapt=new Myadapter(this,lEtud);
		lis.setAdapter(adapt);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_etudiant, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.ajoutMenu) {
		Intent it=new Intent(this,AjoutActivity.class) ;
		startActivity(it);	
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_list_etudiant,
					container, false);
			return rootView;
		}
	}

}
