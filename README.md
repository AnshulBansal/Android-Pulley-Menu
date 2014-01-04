MenuDrawer
==========

Pulley menu is a traditional Menu alternate which allows user to select any option for an activity intuitively. The menu is revealed by dragging the screen downwards and in that gesture user can also select any of the options. 



Usage
=====

This library is very simple to use. It requires no extension of custom classes,
it's simply added to an activity by calling the method  

PulleyMenu(Context,ParentView,Menuview,Normal Background Color,Highlighted Color)`
methods.

For examples on how to use this library, check out the sample app.


Sample Call
-------
```java
	final ListView menuview = new ListView(this);
		menuview.setPadding(0, 30 , 0, 0);

		// ListView menuview = new ListView(this);
		// String[] collection = new String[] { " First", " Second", " Third",
		// " Fourth", " Fifth", " Sixth"}
		ArrayList<String> list = new ArrayList<String>();
		list.add("Start");
		list.add("Stop");
		list.add("Reset");

		anshul.pulleymenu.CustomListViewAdapter adapter = new anshul.pulleymenu.CustomListViewAdapter(this,
				android.R.layout.simple_list_item_1, list);
		menuview.setAdapter(adapter);
		menuview.setOnItemClickListener(this);
		int color1 = Color.WHITE;
		int color2 = Color.argb(255, 50, 255, 255);
		pulleymenu = new anshul.pulleymenu.PulleyMenu(this,R.layout.activity_topmenu,menuview,color1,color2);
```
-------

Including in your project
=========================

Include it in your project as an android library project.

Credits
=======

 * Cyril Mottier for his [articles][1] on the pattern
 * Simon VT for his library Android menu Drawer
[1]: http://android.cyrilmottier.com/?p=658


