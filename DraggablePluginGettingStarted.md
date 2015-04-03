

# Plugin Information #

---


| **Plugin name** |Draggable|
|:----------------|:--------|
| **Latest release** |[1.0.4](http://code.google.com/p/gwtquery-plugins/downloads/detail?name=draggable-plugin-1.0.4.jar)|
| **Latest release date** |May 2011|
| **Maintainer** |[Julien Dramaix](http://code.google.com/u/julien.dramaix/)|
| **Issues tracking** | [Open issues](http://code.google.com/p/gwtquery-plugins/issues/list?can=2&q=label%3ADraggable)|

This plugin is a gwt clone of the [JQuery-ui draggable plugin](http://jqueryui.com/demos/draggable/)

The Draggable plugin enables draggable functionality on any DOM element and GWT widget (it makes the selected element draggable by mouse).

# Changelog #

---

## v1.0.4 ##
  * Compliant with first release of GwtQuery
  * Remove dependency with CommoUi plugin
## v1.0.2 ##
  * Change release numbering
  * Chenges needed for droppable plugin
## v1.0 ##
  * First release

# Using the plugin #

---


## Dependency ##

The draggable plugin needs the [common-ui library](http://code.google.com/p/gwtquery-plugins/downloads/detail?name=commonui-plugin-1.0.3.jar). If you are not using maven, just download the last version of the library and put it in the war/WEB-INF/lib folder.

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
            <artifactId>draggable-plugin</artifactId>
            <version>1.0.4</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
   </build>
```

Then you need to inherit the plugin in your Module.gwt.xml file:
```
  <inherits name='gwtquery.plugins.draggable.Draggable'/>
```

## Support of touch events ##
The draggable plugin can handle mobile device and react on touch events instead of mouse events. The only thing you have to do is to use the last snapshot of GwtQuery available [here](http://code.google.com/p/gwtquery/wiki/Downloads)

## Call the plugin ##

Simply, as with all gwtQuery plugins, just call the selectable plugin like that :
```
import static gwtquery.plugins.draggable.client.Draggable.Draggable;

...

$(".iWantToDrag").as(Draggable).draggable();
```

This calls the plugin with the default options. The elements with the css class name 'iWantToDrag' are now draggable.

## Disabled the plugin ##

To remove the draggable functionality completely, just call the `destroy()` method of the plugin.

```
$(".iWantToDrag").as(Draggable).destroy();
```

Please note that if you want just disable temporary the drag operation for an element to reenable it later, just
```
//disable the drag operation on these elements
$(".iWantToDrag").as(Draggable).options().setDisabled(true);
...
//enable the drag operation
$(".iWantToDrag").as(Draggable).options().setDisabled(false);
```

# Settings #

---


The drag operation is fully configurable ! You just have to give an instance of the class `gwtquery.plugins.draggable.client.DraggableOptions` when you call the plugin :
```
import static gwtquery.plugins.draggable.client.Draggable.Draggable;
import gwtquery.plugins.draggable.client.DraggableOptions;

...

DraggableOptions options = new DraggableOptions();
//set the options you want... See next paragraph
...
//call the plug-in with your options 
$(".iWantToDrag").as(Draggable).draggable(options); 
```


To retrieve the current options of a draggable element just call the `options()` method.

```
DraggableOptions options = $(".iWantToDrag").as(Draggable).options();
```

And for change the options


```
//reinitialise default options
$(".iWantToDrag").as(Draggable).options(new DraggableOptions());
```

## DraggableOptions Object ##

To configure the plugin, just set the properties you wish to configure in the `DraggableOptions`instance you pass to the plugin.
The table below lists the different properties of the `DraggableOptions`object. Each property is accessible via getter/setter methods.

| **Property** | **Type** | **Description** | **Default value** | **Comments** |
|:-------------|:---------|:----------------|:------------------|:-------------|
|disabled|boolean|Disables (true) or enables (false) the drag operation. |false|- |
|delay|int|Time in milliseconds to define when the drag should start. |1 |- |
|distance|int|Tolerance, in pixels, for when the drag should start. If specified, drag will not start until after mouse is dragged beyond distance. |0 |- |
|appendTo|String|The element selected by the appendTo option will be used as the draggable helper's container during dragging. By default, the helper is appended to the same container as the draggable.|null|- |
|axis|AxisOption|Constrains dragging to either the horizontal (AxisOption.X\_AXIS) or vertical (AxisOption.Y\_AXIS) axis.|AxisOption.NONE|- |
|containment|String or int[.md](.md)|Constrains dragging to within the bounds of the specified region or element|null|- |
|cursor|Cursor|Specify the css cursor to use during the drag operation.|Cursor.AUTO|- |
|cursorAt|CursorAt|Moves the dragging helper so the cursor always appears to drag from the same position.|null|- |
|grid|int[.md](.md)|Snaps the dragging helper to a grid. The array of int defining the dimension of the cell of the snap grid.|null|- |
|handle|String|Restricts drag start when the user clicks on the specified element(s).|null|- |
|helper|String or Element or GQuery or HelperType|Allows to use a dom element or a clone of the draggable or the draggable itself for dragging display|HelperType.ORIGNAL|By default, the draggable itself will be used. Using clone or dom element will not move the original draggable. These options are useful in combination with the droppable plug-in|
|onBeforeDragStart|DragFunction|The callback function called before the initialization of the drag operation|null|- |
|onDrag|DragFunction|The callback function called when the drag operation is dragging |null|- |
|onDragStart|DragFunction|The callback function called when the drag operation starts |null|- |
|onDragStop|DragFunction|The callback function called when the drag operation ends |null|- |
|opacity|Float|Specify the opacity of the helper during the drag.|null|If null, the opacity of the helper is not changed|
|revert|RevertOption|Determine if the helper will return to its starts position when dragging stops|RevertOption.NEVER|the two following options RevertOption.ON\_VALID\_DROP and RevertOption.ON\_INVALID\_DROP are useful in combination with the droppable plugin|
|revertDuration|int|The duration of the revert animation, in milliseconds.|null|- |
|scope|String| Used to group sets of draggable and droppable items, in addition to droppable's accept option. A draggable with the same scope value as a droppable will be accepted by the droppable.|'default'|- |
|scroll|boolean| Define if the container scroll while dragging|true|- |
|scrollSensitivity|int| Distance in pixels from the edge of the viewport after which the viewport should scroll. Distance is relative to pointer, not to the draggable.|20|- |
|scrollSpeed|int| The speed at which the window should scroll once the mouse pointer gets within the scrollSensitivity distance.|20|- |
|snap|boolean| Define if the draggable will snap to the edges of the other draggable elements when it is near an edge of these elements.|false|- |
|snap|GQuery or String| The draggable will snap to the edges of the selected elements when near an edge of the element.|null|- |
|snapMode|SnapMode| Determines which edges of snap elements the draggable will snap to.|SnapMode.BOTH|Possible values: SnapMode.INNER, SnapMode.OUTER, SnapMode.BOTH|
|snapTolerance|int| The distance in pixels from the snap element edges at which snapping should occur.|20|- |
|stack|GQuery or String| Controls the z-Index of the selected elements, always brings to front the dragged item.|null|- |
|zIndex|Integer| z-index for the helper while being dragged.|null|- |

Please note that all properties can be modified after the plugin is instantiated. See the [Sample 2](http://gwtquery-plugins.googlecode.com/svn/branches/draggable_1_0/demo/DraggableSample2/DraggableSample2.html) to test some settings of the plugin

# Events #

---


As can be seen in the previous paragraph, the `DraggableOptions` object allows you to pass `Function` who will be invoked by the plugin during the drag operation. In addition to invoke these functions, the plugin fires some event that you can listen for. For that, we use the [GWT event system](http://code.google.com/intl/fr/webtoolkit/doc/latest/tutorial/manageevents.html). Just pass as argument a `HandlerManager` object when you call the plugin :

```
import static com.google.gwt.query.client.GQuery.$;
import static gwtquery.plugins.selectable.client.Draggable.Draggable;

import com.google.gwt.event.shared.HandlerManager;

 
  public void onModuleLoad() {
    
    ...
    
    // create an instance of HandlerManager to bind events fired by the selectable plug-in
    HandlerManager handlerManager = new HandlerManager(null);


    // call the plugin
    $(".iWantToDrag").as(Draggable).draggable(new DraggableOptions(), handlerManager);

  }


```

Now register your implementation of `EventHandler` :

```
  private static class MyEventHandler implements DragEventHandler,
      DragStopEventHandler{
    
     public void onDrag(DragEvent event) {
      String msg = "Component " + event.getDraggable().getId() + " is dragging";
      infoMsg.setHTML(msg);

    }

    public void onDragStop(DragStopEvent event) {
      infoMsg.setHTML("End of the drag operation");

    }

  }

   ...
  
    MyEventHandler handler = new MyEventHandler();
    //bind events who interest us
    handlerManager.addHandler(DragEvent.TYPE, handler);
    handlerManager.addHandler(DragStopEvent.TYPE, handler);
  
```

The different events that you can listen for are :
```
gwtquery.plugins.draggable.client.events.BeforeDragStartEvent;
gwtquery.plugins.draggable.client.events.DragStartEvent;
gwtquery.plugins.draggable.client.events.DragEvent;
gwtquery.plugins.draggable.client.events.DragStopEvent;
```

# Integration with GWT #

---


The draggable plugin can be used to make any GWT widget draggable !! You just have to wrap your widget in a `DraggableWidget` object and it will be automatically draggable. This `DraggableWidget` object allows GWT devellopers to use the plugin without any knowledge about GQuery.

```

import gwtquery.plugins.draggable.client.gwt.DraggableWidget;
...

public class MyGWTApplication implements EntryPoint {

  public void onModuleLoad() {
    //create your widget and let's assume it is a DecoratedTabPanel
    DecoratedTabPanel myWidget = createMyWidget();
    
    //make it draggable
    DraggableWidget<DecoratedTabPanel>  myDraggableWidget = new DraggableWidget<DecoratedTabPanel>(myWidget);
    
    //set options for the drag operation
    myDraggableWidget.setAxis(AxisOption.X_AXIS); 
    myDraggableWidget.setCursor(Cursor.MOVE);
    ....

    //Add your draggable widget to the dom
    RootPanel.get().add(myDraggableWidget);

    // if you want to call some function on your original widget use getOriginalWidget() method. It will be automatically casted.
   myDraggableWidget.getOriginalWidget().selectTab(0);    

}
}  
```

For more example, see [here](http://gwtquery-plugins.googlecode.com/svn/branches/draggable_1_0/demo/GWTIntegrationSample/GWTIntegrationSample.html)

# Examples #

---


To better understand the plugin, examples are available
  * Example 1 : http://gwtquery-plugins.googlecode.com/svn/branches/draggable_1_0/demo/DraggableSample1/DraggableSample1.html
This example shows how to make a simple div draggable. It defines also some callback functions to display informations on the drag operation.
  * Test the options : http://gwtquery-plugins.googlecode.com/svn/branches/draggable_1_0/demo/DraggableSample2/DraggableSample2.html
Play with the different options of the draggable plug-in and see the effect they have on the drag operation.
  * Snap sample : http://gwtquery-plugins.googlecode.com/svn/branches/draggable_1_0/demo/SnapSample/SnapSample.html
Watch the snap options in action.
  * Containment sample : http://gwtquery-plugins.googlecode.com/svn/branches/draggable_1_0/demo/ContainmentSample/Containment.html
This example shows you how it's possible to constraint the drag area with the containment option.
  * Stack sample : http://gwtquery-plugins.googlecode.com/svn/branches/draggable_1_0/demo/StackSample/StackSample.html
This sample shows how the draggable plugin can handle the z-index to bring on top the current draggable item.
  * GWT integration : http://gwtquery-plugins.googlecode.com/svn/branches/draggable_1_0/demo/GWTIntegrationSample/GWTIntegrationSample.html
This sample shows how it is easier to add drag functionnality to any GWT widget. Simply in using the DraggableWidget wrapper !! This example shows also how to use event fired by the plugin.

All examples are tested on Internet explore 6, 7 and 8, Firefox 3.6, Google Chrome 4, Opera 10 and Safari 5.