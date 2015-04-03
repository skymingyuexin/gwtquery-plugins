

# Plugin Information #

| **Plugin name** |Enhance|
|:----------------|:------|
| **Latest release** |[1.0.5](http://gwtquery-plugins.googlecode.com/svn/mavenrepo/com/googlecode/gwtquery/plugins/enhance-plugin/1.0.4/enhance-plugin-1.0.5.jar)|
| **Latest release date** |2012|
| **Maintainer** |[Manolo Carrasco](http://code.google.com/u/manuel.carrasco.m/)|
| **Issues tracking** | [Open issues](http://code.google.com/p/gwtquery-plugins/issues/list?can=2&q=label%3AEnhance)|

This plugin is a set of gwt widgets which are used to enhance standar html elements.


## What does it do? ##
The Ratings plugin is a plugin for the [GwtQuery](http://code.google.com/p/gwtquery/) library that creates a non-obstrusive controls based on standard html elements.

  * Normally it hides the original html element and enhances it to give a better user experience.
  * If you enhance form elements they will work as usual when submiting a form.
  * All widgets in this plugins are available as standard gwt plugins as well.

# Changelog #
## v1.0.4 ##
  * Upgrade gwt-2.5.1 and gquery 1.3.3
## v1.0.4 ##
  * Upgrade to gwt-2.4.0
## v1.0.2 ##
  * Upgrade to gwt-2.2.0 and many fixes
## v1.0.0 ##
  * Compatibility release for gwt-2.1.1 and gquery-1.0.0
## v1.0.0 ##
  * First release

# Using the plugin #

## Configuration ##

First of all you have to include the library in the classpath of your project.
  * If you are using `ant` normally it is enough to download the library from the [downloads page](http://code.google.com/p/gwtquery-plugins/downloads/list) and put it in the war/WEB-INF/lib folder.

  * If you use `maven`, you have to add these blocks to your pom.xml
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
            <artifactId>enhance-plugin</artifactId>
            <scope>provided</scope>
            <version>1.0.5</version>
        </dependency>
    </dependencies>
   </build>
```

Then you need to inherit the plugin in your Module.gwt.xml file:
```
  <inherits name='gwtquery.plugins.enhance.Enhance'/>
```

And finally, as with all gwtQuery plugins, just call the Ratings plugin like that :
```
import static gwtquery.plugins.ratings.client.enhance.Enhance;
...
$("input[name=color]").as(Enhance).colorBox();
$("input[name=number]").as(Enhance).slider(0, 100);
```

It enhances the input with the name color with a colorpicker, and the input with name number with a slider bar.

# Samples #

```
        $("textarea").as(Enhance).richText();
        $(".color input").as(Enhance).colorBox();
        $(".colorfull input").as(Enhance).colorBox(ColorPickerType.ADVANCED);
        $(".ffamily input").as(Enhance).fontFamilyBox();
        $(".fsize input").as(Enhance).fontSizeBox();
        $(".slider input").as(Enhance).slider(0, 2);
        $(".multiselect select").as(Enhance).multiselect();
```

To better understand the plugin, take a look to the example:
  * http://gwtquery-plugins.googlecode.com/svn/trunk/enhance/demos/Enhance/EnhanceSample.html