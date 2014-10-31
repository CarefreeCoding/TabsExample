package tabs.example.mvc.view.main;

import android.widget.TextView;
import tabs.example.R;
import tabs.example.gui.TabButton;
import tabs.example.mvc.controller.main.MainController;
import tabs.example.mvc.model.main.MainModel;
import tabs.example.mvc.view.View;

public class MainView extends View<MainController, MainModel>
{
	private TabButton option1;
	private TabButton option2;
	private TabButton option3;

	private TextView group1;
	private TextView group2;
	private TextView group3;

	public MainView(MainController controller, MainModel model)
	{
		super(controller, model);
	}

	@Override
	public void setVisible(int visibility)
	{
		option1.setVisibility(visibility);
		option2.setVisibility(visibility);
		option3.setVisibility(visibility);

		group1.setVisibility(visibility);
		group2.setVisibility(visibility);
		group3.setVisibility(visibility);
	}

	@Override
	protected void loadComponents()
	{
		option1 = (TabButton) controller.findViewById(R.id.option1);
		option2 = (TabButton) controller.findViewById(R.id.option2);
		option3 = (TabButton) controller.findViewById(R.id.option3);

		group1 = (TextView) controller.findViewById(R.id.group1);
		group2 = (TextView) controller.findViewById(R.id.group2);
		group3 = (TextView) controller.findViewById(R.id.group3);

		group1.setVisibility(android.view.View.VISIBLE);
		group2.setVisibility(android.view.View.GONE);
		group3.setVisibility(android.view.View.GONE);
	}

	@Override
	protected void assignListeners()
	{
		option1.setOnClickListener(new android.view.View.OnClickListener()
		{
			@Override
			public void onClick(android.view.View view)
			{
				group1.setVisibility(android.view.View.VISIBLE);
				group2.setVisibility(android.view.View.GONE);
				group3.setVisibility(android.view.View.GONE);

				option2.setChecked(false);
				option3.setChecked(false);
			}
		});
		option2.setOnClickListener(new android.view.View.OnClickListener()
		{
			@Override
			public void onClick(android.view.View view)
			{
				group1.setVisibility(android.view.View.GONE);
				group2.setVisibility(android.view.View.VISIBLE);
				group3.setVisibility(android.view.View.GONE);

				option1.setChecked(false);
				option3.setChecked(false);
			}
		});
		option3.setOnClickListener(new android.view.View.OnClickListener()
		{
			@Override
			public void onClick(android.view.View view)
			{
				group1.setVisibility(android.view.View.GONE);
				group2.setVisibility(android.view.View.GONE);
				group3.setVisibility(android.view.View.VISIBLE);

				option1.setChecked(false);
				option2.setChecked(false);
			}
		});
	}

	@Override
	public void registerModel(MainModel model)
	{
	}

	@Override
	public void refresh()
	{
	}
}
