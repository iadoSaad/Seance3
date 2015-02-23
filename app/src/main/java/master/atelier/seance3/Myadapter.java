package master.atelier.seance3;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import android.R.color;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class Myadapter extends BaseAdapter implements View.OnClickListener {
	
	List<Etudiant> p ;
	TextView v;
    Button supprimer ;
	Context t;
	
	public Myadapter(Context t,List<Etudiant> l) {
		
		p=l;
		this.t=t;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
	
		return p.size()-1;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return p.get(position) ;
		
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position ;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView t1,t2;
		if(convertView==null){
		LayoutInflater v;
	    v=LayoutInflater.from(t);

	    convertView=v.inflate(R.layout.ligne, null) ;
           supprimer=(Button) convertView.findViewById(R.id.supprimer);
            supprimer.setOnClickListener(this);
            supprimer.setTag(position);
	    }

	
		
	//	convertView.setBackgroundColor(Color.RED);
		t1=(TextView) convertView.findViewById(R.id.nom) ;
		t2=(TextView) convertView.findViewById(R.id.prenom) ;
		t1.setText(p.get(position).nom);
		t2.setText(p.get(position).prenom);
		return  convertView ;
		//if(convertView!=null) return convertView;
		
	}


    @Override
    public void onClick(View view) {
        int tag=(Integer)view.getTag();
        MyHelper help=new MyHelper(t);
        SQLiteDatabase db=help.getWritableDatabase();
        db.delete("etudiant","id="+p.get(tag).id,null);
        p.remove(tag);
        ListEtudiant.adapt.notifyDataSetChanged();
    }
}
