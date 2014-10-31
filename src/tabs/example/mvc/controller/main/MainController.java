package tabs.example.mvc.controller.main;

import android.view.Menu;
import android.view.MenuItem;
import tabs.example.R;
import tabs.example.mvc.controller.Controller;
import tabs.example.mvc.model.main.MainModel;
import tabs.example.mvc.view.main.MainView;

public class MainController extends Controller<MainView, MainModel>
{
	@Override
	public void init()
	{
		setContentView(R.layout.main);

		view = new MainView(this, model);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		return false;
	}
}
