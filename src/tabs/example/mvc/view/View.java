package tabs.example.mvc.view;

import tabs.example.mvc.controller.Controller;
import tabs.example.mvc.model.Model;

public abstract class View<C extends Controller, M extends Model>
{
	protected C controller;

	public View(C controller, M model)
	{
		this.controller = controller;

		loadComponents();
		assignListeners();
		registerModel(model);
	}

	protected abstract void loadComponents();

	protected abstract void assignListeners();

	protected abstract void registerModel(M model);

	public void setVisible(boolean visibility)
	{
		setVisible(
				visibility ?
						android.view.View.VISIBLE : android.view.View.GONE);
	}

	public abstract void setVisible(int visibility);

	public abstract void refresh();
}
