

# Plugin Information #

---


| **Plugin name** |Droppable|
|:----------------|:--------|
| **Latest release** |[1.0.8](http://code.google.com/p/gwtquery-plugins/downloads/detail?name=droppable-plugin-1.0.8.jar)|
| **Latest release date** |October 29 2012|
| **Maintainer** |[Julien Dramaix](http://code.google.com/u/julien.dramaix/)|
| **Issues tracking** | [Open issues](http://code.google.com/p/gwtquery-plugins/issues/list?can=2&q=label%3ADroppable)|

This plugin is a gwt clone of the [JQuery-ui droppable plugin](http://jqueryui.com/demos/droppable/)

The Droppable plugin enables any DOM element and GWT widget to be droppable or in other words a target for draggable elements.


# Changelog #

---

## v1.0.8 ##
  * Release compatible for GWT 2.5

## v1.0.7 ##
  * Release compatible for GWT 2.4

## v1.0.6 ##
  * Release compatible for GWT 2.3

## v1.0.5 ##
  * Compliant with first release of GwtQuery

## v1.0.4 ##
  * Remove dependency with CommoUi plugin

## v1.0.3 ##
  * Release compatible with GWT 2.2

## v1.0.2 ##
  * Issue [4](http://code.google.com/p/gwtquery-plugins/issues/detail?id=4) : GWT 2.1.1 Cell API break.

## v1.0.1 ##
  * First release

# Using the plugin #

---


## Dependency ##

The droppable plugin needs the [draggable library](http://code.google.com/p/gwtquery-plugins/downloads/detail?name=draggable-plugin-1.0.4.jar). If you are not using maven, just download the last version of this libraries and put it in the war/WEB-INF/lib folder.


## Configuration ##

First of all you have to include the library in the classpath of your project. If you are using ant normally it is enough to download the library from the [downloads page](http://code.google.com/p/gwtquery-plugins/downloads/list) and put it in the war/WEB-INF/lib folder.

If you use maven, you have to add these blocks to your pom.xml
```
<project>

   <repositories>
        <repository>
         <id>plugins</id>
         <url>http://gwtquery-plugins.googlecode.com/svn/mavenrepo</url>
       </repository>
   </repositories>

    <dependencies>
        <dependency>
            <groupId>com.googlecode.gwtquery.plugins</groupId>
            <artifactId>droppable-plugin</artifactId>
            <version>1.0.8</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>
</project>
```

Then you need to inherit the plugin in your Module.gwt.xml file:
```
  <inherits name='gwtquery.plugins.droppable.Droppable'/>
```

## Call the plugin ##

Simply, as with all gwtQuery plugins, just call the droppable plugin like that :
```
import static gwtquery.plugins.droppable.client.Droppable.Droppable;

...

$(".dropTarget").as(Droppable).droppable();
```

This calls the plugin with the default options. The elements with the css class name 'dropTarget' are now droppable.

## Disabled the plugin ##

To remove the droppable functionality completely, just call the `destroy()` method of the plugin.

```
$(".dropTarget").as(Droppable).destroy();
```

> Note:
> The destroy method must be called when a droppable DOM element is removed of the DOM in order to release resources used by the plugin.

# Settings #

---


The drop operation is fully configurable ! You just have to give an instance of the class `gwtquery.plugins.droppable.client.DroppableOptions` when you call the plugin :
```
import static gwtquery.plugins.droppable.client.Droppable.Droppable;
import gwtquery.plugins.droppable.client.DroppableOptions;

...

DroppableOptions options = new DroppableOptions();
//set the options you want... See next paragraph
...
//call the plug-in with your options 
$(".dropTarget").as(Droppable).droppable(options); 
```


To retrieve the current options of a droppable element just call the `options()` method.

```
//return the options associated to the first element
DroppableOptions options = $(".dropTarget").as(Droppable).options();
```

And for change the options


```
//reinitialise default options
$(".dropTarget").as(Droppable).options(new DroppableOptions());
```

## DroppableOptions Object ##

To configure the plugin, just set the properties you wish to configure in the `DroppableOptions`instance you pass to the plugin.
The table below lists the different properties of the `DroppableOptions`object. Each property is accessible via getter/setter methods.

| **Property** | **Type** | **Description** | **Default value** | **Comments** |
|:-------------|:---------|:----------------|:------------------|:-------------|
|disabled|boolean|Disables (true) or enables (false) the drop operation. |false|- |
|accept|String or AcceptFunction|Define which draggable elements will be accepted by the droppable |null|If this option is null, the droppable accepts all draggables|
|activeClass|String|Css class added to the droppable when it is active (i.e. when an acceptable draggable is being dragged)) |null|If this option is null, no class is added|
|draggableHoverClass|String|Css class that will be added to an acceptable draggable when it is being dragged over the droppable|null|If this option is null, no class is added|
|droppableHoverClass|String|Css class that will be added to a droppable when an acceptable draggable is being dragged over it|null|If this option is null, no class is added|
|greedy|boolean|When set to true, prevents events propagation of droppable parents of the droppable|false|- |
|onActivate|DroppableFunction|Callback function called when a droppable is activated (i.e. when an acceptable draggable starts being dragged)|null|- |
|onDeactivate|DroppableFunction|Callback function called when a droppable is deactivated (when an acceptable draggable stops being dragged)|null|- |
|onDrop|DroppableFunction|Callback function called when an acceptable draggable is dropped on the droppable|null|- |
|onOut|DroppableFunction|Callback function called when an acceptable draggable is being dragged out of the droppable|null|- |
|onOver|DroppableFunction|Callback function called when an acceptable draggable is being dragged over the droppable|null|- |
|scope|String|Used to group sets of draggable and droppable widget, in addition to droppable's accept option. A droppable will accept any draggable with the same scope value as itself.|"default"|- |
|tolerance|DroppableTolerance|Specifies which mode to use for testing whether a draggable is 'over' a droppable.|DroppableTolerance.INTERSECT|- |

Please note that all properties can be modified after the plugin is instantiated. See this [example](http://gwtquery-plugins.googlecode.com/svn/branches/droppable_1_0/demo/TestOptionsSample/TestOptionsSample.html) to test the different options.

# Events #

---


As can be seen in the previous paragraph, the `DroppableOptions` object allows you to pass `DropFunction` who will be invoked by the plugin during the drag and drop operation. In addition to invoke these callback functions, the plugin fires some event that you can listen for. For that, we use the [GWT event system](http://code.google.com/intl/fr/webtoolkit/doc/latest/tutorial/manageevents.html). Just pass as argument a `EventBus` object when you call the plugin :

```
import static gwtquery.plugins.droppable.client.Droppable.Droppable;
import gwtquery.plugins.droppable.client.DroppableOptions;

import com.google.gwt.event.shared.SimpleEventBus;

 
  public void onModuleLoad() {
    
    ...
    
    // create an instance of SimpleEventBus to bind events fired by the selectable plug-in
    EventBus eventBus = new SimpleEventBus();


    // call the plugin
    $(".dropTarget").as(Droppable).options(new DroppableOptions(), eventBus);

  }


```

Now register your implementation of `EventHandler` :

```
  private static class MyEventHandler implements DropEventHandler,
    OverDroppableEventHandler, OutDroppableEventHandler{
    
     public void onDrop(DropEvent event) {
      //do something
     }

  
     public void onOutDroppable(OutDroppableEvent event) {
      //do something
     }

  
     public void onOverDroppable(OverDroppableEvent event) {
      //do something
     }
  }
   ...
  
    MyEventHandler handler = new MyEventHandler();
    //bind events who interest us
    eventBus.addHandler(DropEvent.TYPE, handler);
    eventBus.addHandler(OutDroppableEvent.TYPE, handler);
    eventBus.addHandler(OverDroppableEvent.TYPE, handler);
  
```

The different events that you can listen for are :
```
gwtquery.plugins.droppable.client.events.DropEvent
gwtquery.plugins.droppable.client.events.OutDroppableEvent
gwtquery.plugins.droppable.client.events.OverDroppableEvent
gwtquery.plugins.droppable.client.events.ActivateDroppableEvent
gwtquery.plugins.droppable.client.events.DectivateDroppableEvent
```

Please note that the draggable, droppable and helper element are available on each event object.

```
    public void onDrop(DropEvent event) {
      Element draggable = event.getDraggable();
      Element droppable = event.getDroppable();
      Element helper = event.getDragHelper();
      // do something with thses elements
     }

```

# Integration with GWT #

---


The droppable plugin can be used to implement droppable functionality on any GWT widget.
For more information please read this [article](http://code.google.com/p/gwtquery-plugins/wiki/DragAndDropPluginForGWTDeveloppers)

# Examples #

---


To better understand the plugin, examples are available to :
http://gwtquery-plugins.googlecode.com/svn/branches/droppable_1_0/demo/SimpleSample/SimpleSample.html


All examples are tested on Internet explore 6, 7 and 8, Firefox 3.6, Google Chrome 4, Opera 10 and Safari 5.

# Issues #

---

Although I spent much time testing this plugin, this one is not guaranteed bug free. If you find any bugs, please don't hesitate to open a issue in the [issue tracker](http://code.google.com/p/gwtquery-plugins/issues/entry).