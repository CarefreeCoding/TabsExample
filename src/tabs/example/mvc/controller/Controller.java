package tabs.example.mvc.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import tabs.example.mvc.model.Model;
import tabs.example.mvc.view.View;

public abstract class Controller<V extends View, M extends Model>
		extends Activity
{
	protected V view;
	protected M model;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		init();
	}

	public abstract void init();

	public abstract boolean onCreateOptionsMenu(Menu menu);

	public abstract boolean onOptionsItemSelected(MenuItem item);
}
