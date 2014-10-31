package tabs.example.gui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RadioButton;
import tabs.example.R;

public class TabButton extends RadioButton
{
	private boolean mTextAllCaps;

	private int mLineHeightSelected;
	private int mLineHeightUnselected;

	private Paint mLinePaint;
	private Rect  rect;

	public TabButton(Context context, AttributeSet attrs)
	{
		this(context, attrs, R.attr.tabControlButtonStyle);
	}

	public TabButton(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		init(attrs, defStyle);
		rect = new Rect(0, this.getHeight(), getWidth(), this.getHeight());
	}

	public void init(AttributeSet attrs, int defStyle)
	{
		if (attrs != null)
		{
			TypedArray a = this.getContext().obtainStyledAttributes(attrs,
																	R.styleable.TabButton,
																	defStyle,
																	R.style.TabButton);

			mTextAllCaps = a
					.getBoolean(R.styleable.TabButton_textAllCaps,
								false);
			setTextCompact(getText());

			int lineColor = a
					.getColor(R.styleable.TabButton_lineColor, 0);
			mLineHeightUnselected = a.getDimensionPixelSize(
					R.styleable.TabButton_lineHeightUnselected, 0);
			mLineHeightSelected = a.getDimensionPixelSize(
					R.styleable.TabButton_lineHeightSelected, 0);

			mLinePaint = new Paint();
			mLinePaint.setColor(lineColor);
			mLinePaint.setStyle(Style.FILL);

			a.recycle();
		}
	}

	@Override
	public void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);

		// Draw the line
		if (mLinePaint
				.getColor() != 0 && (mLineHeightSelected > 0 || mLineHeightUnselected > 0))
		{
			int lineHeight;
			if (isChecked())
			{
				lineHeight = mLineHeightSelected;
			}
			else
			{
				lineHeight = mLineHeightUnselected;
			}

			if (lineHeight > 0)
			{
				rect.set(0, this.getHeight() - lineHeight, getWidth(),
							 this.getHeight());
				canvas.drawRect(rect, mLinePaint);
			}
		}
	}

	// Used for android:textAllCaps
	public void setTextCompact(CharSequence text)
	{
		if (mTextAllCaps)
		{
			setText(text.toString().toUpperCase());
		}
		else
		{
			setText(text);
		}
	}
}
