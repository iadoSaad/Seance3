package master.atelier.seance3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyHelper extends SQLiteOpenHelper {
	
	private static final String REQUETTE="CREATE TABLE etudiant ("
			+ " id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT NOT NULL,"
			+ "prenom TEXT NOT NULL)" ;

	public MyHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	
	public MyHelper(Context context){
		super(context,"etudiant",null,1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(REQUETTE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE etudiant");
		onCreate(db);
	}

}
