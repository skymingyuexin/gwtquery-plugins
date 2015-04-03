

# Plugin Information #

| **Plugin name** |Selectable|
|:----------------|:---------|
| **Latest release** |[1.0.3](http://code.google.com/p/gwtquery-plugins/downloads/detail?name=selectable-plugin-1.0.3.jar)|
| **Latest release date** |Apr 20 2012|
| **Maintainer** |[Julien Dramaix](http://code.google.com/u/julien.dramaix/)|
| **Issues tracking** | [Open issues](http://code.google.com/p/gwtquery-plugins/issues/list?can=2&q=label%3ASelectable)|

This plugin is a gwt clone of the [JQuery-ui selectable plugin](http://jqueryui.com/demos/selectable/)

The Selectable plugin allows for elements to be selected by drawing a lasso with the mouse over the elements or by cliking on element. If you want to select non-contiguous element  just hold the Ctrl/Meta key.

# Changelog #

## v1.0.2 ##
  * Compatible with GQuery 1.1.0
## v1.0.2 ##
  * Change release numbering
  * Remove dependency to common-ui (moved to GwtQuery trunk)
  * Correct some bugs on delay and distance options.
## v1.1 ##
  * implementation of delay and distance options
  * add dependency to commonui-plugin
## v1.0 ##
  * First release

# Using the plugin #

## Dependency ##

The selectable plugin needs [the last snapshot](http://code.google.com/p/gwtquery/wiki/UsingLatestSnapshot) of GwtQuery library to work.

## Configuration ##

First of all you have to include the library in the classpath of your project. If you are using ant normally it is enough to download the library from the [downloads page](http://code.google.com/p/gwtquery-plugins/downloads/list) and put it in the war/WEB-INF/lib folder.

If you use maven, you have to add these blocks to your pom.xml
```
   <repositories>
        <repository>
         <id>plugins</id>
         <url>http://gwtquery-plugins.googlecode.com/svn/mavenrepo</url>
       </repository>
   </repositories>

   <build>
    <dependencies>
        <dependency>
            <groupId>com.googlecode.gwtquery.plugins</groupId>
            <artifactId>selectable-plugin</artifactId>
            <scope>compile</scope>
            <version>1.0.3</version>
        </dependency>
    </dependencies>
   </build>
```

Then you need to inherit the plugin in your Module.gwt.xml file:
```
  <inherits name='gwtquery.plugins.selectable.Selectable'/>
```

And finally, as with all gwtQuery plugins, just call the selectable plugin like that :
```
import static gwtquery.plugins.selectable.client.Selectable.Selectable;

...

$("#selectable").as(Selectable).selectable();
```

It calls the plugin with the default options. All children of element with id = selectable can be now selected.

# Settings #

The plugin can be configured ! You just have to give an instance of the class `gwtquery.plugins.selectable.client.SelectableOptions` when you call the plugin :
```
import static gwtquery.plugins.selectable.client.Selectable.Selectable;
import gwtquery.plugins.selectable.client.SelectableOptions;

...

SelectableOptions options = new SelectableOptions();
//set the options you want... See next paragraph
...
//call the plug-in with your options 
("#selectable").as(Selectable).selectable(options); 
```


## `SelectableOptions` Object ##

To configure the plugin, just set value you want in the different properties of the `SelectableOptions` instance you give to the plugin.
The table below lists the different properties of the `SelectableOptions` object. Each property is reachable by its respective getter/setter.

| **Property** | **Type** | **Description** | **Default value** | **Comments** |
|:-------------|:---------|:----------------|:------------------|:-------------|
|disabled|boolean|Disables (true) or enables (false) the selectable. |false|- |
|multiSelect|boolean|Determine whether the selection can select many element (true) or only one (false). |true|This options doesn't exist in the jQuery-ui selectable plugin|
|autoRefresh|boolean|This determines whether to refresh (recalculate) the position and size of each selectee (able to be selected) at the beginning of each select operation. |true|If you have many many items, you may want to set this to false and call the refresh method  manually|
|appendTo|String|Selector used to append the 'lasso' div. |"body"|- |
|filter|String|The matching child elements will be made selectees (able to be selected). |"`*`"|- |
|tolerance|Tolerance |Tolerance to select an selectee (able to be selected)|TOUCH|Two possible value : <br />TOUCH : if the lasso touches the element, the element is selected ; <br />FIT : the lasso has to entirely wrap the element if you want it to be selected.|
|delay|int|Time in milliseconds to define when the selecting should start. It helps preventing unwanted selections when clicking on an element |0 |Since v1.1|
|distance|int|Tolerance, in pixels, for when selecting should start. If specified, selecting will not start until after mouse is dragged beyond distance. |0 |Since v1.1|
|onSelected|Function|This callback function is called at the end of the select operation, on each element added to the selection.  |null|- |
|onSelecting|Function|This callback function is called during the select operation, on each element added to the selection. |null|- |
|onUnselected|Function|This callback function is called at the end of the select operation, on each element added to the selection. |null|- |
|onUnselecting|Function|This callback function is called during the select operation, on each element removed from the selection |null|- |
|onStartSelection|Function|This callback function is called when the selecting start|null|- |
|onStopSelection|Function|This callback function is called at the end of the select operation.|null|- |

Please note that all properties can be changed during the working of the plugin. See the  [Sample 2](http://gwtquery-plugins.googlecode.com/svn/trunk/selectable/demos/SelectableSample2/Sample2.html) to test some settings of the plugin.

# Events #

As can be seen in the previous paragraph, the `SelectableOptions` object allows you to pass `Function` who will be invoked by the plugin during its working. In addition to invoke these functions, the plugin fires some event that you can listen. For that, we use the [GWT event system](http://code.google.com/intl/fr/webtoolkit/doc/latest/tutorial/manageevents.html). Just pass as argument a `HandlerManager` object when you call the plugin :

```
import static com.google.gwt.query.client.GQuery.$;
import static gwtquery.plugins.selectable.client.Selectable.Selectable;

import com.google.gwt.event.shared.HandlerManager;

 
  public void onModuleLoad() {
    
    ...
    
    // create an instance of HandlerManager to bind events fired by the selectable plug-in
    HandlerManager handlerManager = new HandlerManager(null);
    
  
    // you can use also options
    SelectableOptions o = new SelectableOptions();
    o.setFilter(".can-be-selected");

    // call the plugin
    $("#selectable").as(Selectable).selectable(o, handlerManager);

  }


```

Register now your implementation of `EventHandler` :

```
  private static class MyEventHandler implements SelectedEventHandler,
      UnselectedEventHandler {

    public void onSelected(SelectedEvent event) {
        Window.alert("The following element :"+event.getSelectedElement().getId()+" is selected");

    }

    public void onUnselected(UnselectedEvent event) {
       Window.alert("The following element :"+event.getUnselectedElement().getId()+" is unselected");

    }

  }

   ...
  
    MyEventHandler handler = new MyEventHandler();
    //bind events who interest us
    handlerManager.addHandler(SelectedEvent.TYPE, handler);
    handlerManager.addHandler(UnselectedEvent.TYPE, handler);
  
```

The different events that you can listen are :
```
gwtquery.plugins.selectable.client.event.SelectedEvent;
gwtquery.plugins.selectable.client.event.UnselectedEvent;
gwtquery.plugins.selectable.client.event.SelectingEvent;
gwtquery.plugins.selectable.client.event.UnselectingEvent;
gwtquery.plugins.selectable.client.event.SelectionStartEvent;
gwtquery.plugins.selectable.client.event.SelectionStopEvent;
```

See [the sample 3](http://gwtquery-plugins.googlecode.com/svn/trunk/selectable/demos/SelectableSample3/Sample3.html), it uses this system to change the widget in each cell depending of whether it is selected or not.

# Samples #

To better understand the plugin, three examples are available
  * Sample 1 : http://gwtquery-plugins.googlecode.com/svn/trunk/selectable/demos/SelectableSample1/Sample1.html
This sample show how to set a simple html list selectable. It defines also some callback functions to display informations on the selection operation.
  * Sample 2 : http://gwtquery-plugins.googlecode.com/svn/trunk/selectable/demos/SelectableSample2/Sample2.html
Play with different settings of the plugin.
  * Snap sample : http://gwtquery-plugins.googlecode.com/svn/trunk/draggable/demo/SnapSample/SnapSample.html
See the snap options in action
  * Containment sample : http://gwtquery-plugins.googlecode.com/svn/trunk/draggable/demo/ContainmentSample/Containment.html
Sample around the containment options
  * Stack options : http://gwtquery-plugins.googlecode.com/svn/trunk/draggable/demo/StackSample/StackSample.html
See the stack option in action
  * GWT integration : http://gwtquery-plugins.googlecode.com/svn/trunk/draggable/demo/GWTIntegrationSample/GWTIntegrationSample.html
This sample demonstrate how it is simple to add drag functionality to your GWT widget.