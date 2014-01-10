Android Pulley Menu
==========

Pulley menu is an alternate to traditional Menu which allows user to select any option for an activity intuitively. The menu is revealed by dragging the screen downwards and in that gesture user can also select any of the options. 

This Libraray has been implemented in the following android applications :-

Demo of pulley menu on a Stopwatch Application – [Pulley Menu Demo][2] 


Please drop a mail at ans_hul_1994@yahoo.co.in if you are using it in yor project so that it can be listed here.

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


License
=======

    Copyright 2013 Anshul Bansal

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[1]: http://android.cyrilmottier.com/?p=658
[2]: https://play.google.com/store/apps/details?id=net.anshul.pulleymenu.samples

