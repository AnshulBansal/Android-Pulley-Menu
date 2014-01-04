package anshul.pulleymenu;

import anshul.pulleymenu.MenuDrawer.OnDrawerStateChangeListener;
import anshul.pulleymenu.MenuDrawer.Type;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.ListView;

public class PulleyMenu {
	private Context context;
	private ListView menuview;
	int listsize;
	MenuDrawer mMenuDrawer;
	int localpx;
	int index;

	public PulleyMenu(Activity activity, int Contentview,
			final ListView menuview, final int color1, final int color2) {
		context = activity;
		this.menuview = menuview;

		mMenuDrawer = MenuDrawer.attach(activity, Type.BEHIND, Position.TOP,
				MenuDrawer.MENU_DRAG_CONTENT);
		mMenuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_FULLSCREEN);
		mMenuDrawer.setContentView(Contentview);
		menuview.setVerticalScrollBarEnabled(false);
		menuview.setHorizontalScrollBarEnabled(false);
		menuview.setDividerHeight(0);
	//	menuview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		listsize = menuview.getAdapter().getCount();
		mMenuDrawer.setMenuView(menuview);

		// TODO Auto-generated constructor stub
		int size = (int) (listsize * 40 * context.getResources()
				.getDisplayMetrics().density);
size+=30;
		mMenuDrawer.setMenuSize(size);
		mMenuDrawer
				.setOnDrawerStateChangeListener(new OnDrawerStateChangeListener() {

					@Override
					public void onDrawerStateChange(int oldState, int newState) {
						// TODO Auto-generated method stub
						int globalpx = localpx;
						Log.d(oldState + "oldstate","old");
						Log.d(newState + "newstate","new");
						
						Log.d("Local called" + localpx, "Localpx");
						Log.d("index" + index,"index");
						if(oldState == MenuDrawer.STATE_OPEN && newState == MenuDrawer.STATE_CLOSING){
							
						}else{
						
						if (oldState == 2 && oldState != 8
								&& newState == 8 || newState ==1 ) {

							Log.d("Local ps" + localpx, "Localpx");
							Log.d("globalpx" + globalpx,"globalpx");
							int offdp = (int) (globalpx / context.getResources()
									.getDisplayMetrics().density);
							index = (int) offdp / 40;
							index--;
							menuview.clearAnimation();
							index = listsize - index;
							if (index >= 0 && index < listsize + 1) {
								Log.d("Clicked", "itemclicked");
								menuview.performItemClick(menuview, index,
										menuview.getId());
							}
						}
						if (newState == MenuDrawer.STATE_OPENING
								|| newState == MenuDrawer.STATE_OPEN) {
							mMenuDrawer.closeMenu();
							
						}
					}
					}
					@Override
					public void onDrawerSlide(float openRatio, int offsetPixels) {
						// TODO Auto-generated method stub
						localpx = offsetPixels;
						int offdp = (int) (localpx / context.getResources()
								.getDisplayMetrics().density);
						index = (int) offdp / 40;

						index = listsize - index;

						if (index >= 0) {

							for (int i = 0; i < listsize; i++) {
								if (i != index) {
									menuview.getChildAt(i).setBackgroundColor(
											color1);
								} else {
									menuview.getChildAt(index)
											.setBackgroundColor(color2);

								}
							}

						}
					}
				});

	}

}
